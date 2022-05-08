/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.bonsaiweb;

import cst.Constants;
import cst.CurrentAccount;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.naming.*; 
import javax.sql.*; 
import java.sql.*; 

/**
 *
 * @author ayoub
 */
@WebServlet(name = "AccountSignup", urlPatterns = {"/accountSignup"})
public class AccountSignup extends HttpServlet {
private String messageColor;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private int accCheck(String email,String password, String password_conf, Statement stmt)
            throws ServletException, IOException, SQLException {
        // 0: Successful sign up
        // 1: email arleady used
        // 2: password and password confirmation not matching
        String qry = "SELECT accountEmail FROM Account WHERE UPPER(accountEmail) = \'" + email +"\';";
        ResultSet rs = stmt.executeQuery(qry);
        if(rs.next()) return 1;
        if(!password.equals(password_conf)) return 2;
        return 0;
    }
    
    private void createAccount(String email, String password, String fName, String lName, 
            String address, String phone, Statement stmt,PrintWriter out) throws ServletException, IOException, SQLException {
        StringBuilder qry = new StringBuilder(""+
            "INSERT INTO Account(accountEmail, accountPass, accountLastName"+
            ", accountFirstName");
        if(!address.isEmpty()) qry.append(", accountAddress");
        if(!phone.isEmpty()) qry.append(", accountPhone");
        qry.append(""+
            ", accountAUIER) values(\'"+email+"\',\'"+password+"\', \'"+lName+"\', \'"+ fName+"\'"
        );
        if(!address.isEmpty()) qry.append(", \'"+address+"\'");
        if(!phone.isEmpty()) qry.append(", \'"+phone+"\'");
        qry.append(", false);");
        stmt.execute(qry.toString());
        CurrentAccount.Logged = true;
        CurrentAccount.email = email;
        CurrentAccount.firstName = fName;
        CurrentAccount.lastName = lName;
        CurrentAccount.address = address;
        CurrentAccount.phone = phone;
        qry = new StringBuilder("SELECT accountID FROM Account WHERE UPPER(accountEmail) = \'" + email +"\';");
        ResultSet rs = stmt.executeQuery(qry.toString());
        rs.next();
        CurrentAccount.ID = rs.getInt("accountId");
        
    }
    
    private void signUp(HttpServletRequest request, HttpServletResponse response,PrintWriter out)
            throws ServletException, IOException {
            try{    
                String email = request.getParameter("email").toUpperCase();
                String password = request.getParameter("password");
                String password_conf = request.getParameter("confirm_password");
                String fName = request.getParameter("f_name");
                String lName = request.getParameter("l_name");
                String address = request.getParameter("address");
                String phone = request.getParameter("phone");
                String message="error?";
                String color="red";
                String btnValue="continue";
                String url = "index";
                Context ctx = new InitialContext();
                if (ctx == null) {
                throw new Exception("Error - No Context");
                }
                DataSource ds = (DataSource)
                ctx.lookup("java:/comp/env/jdbc/postgres");
                if (ds != null) {
                    Connection conn = ds.getConnection();
                    if(conn != null){
                        Statement stmt = conn.createStatement();
                        int check = accCheck(email,password,password_conf,stmt);
                        

                        switch (check){
                            case 1:
                                message = "Account with email "+ email+" already exist.";
                                color = "red";
                                btnValue = "Go back";
                                url = "signup";
                                break;
                            case 2:
                                message = "Password Confirmation does not match password";
                                color = "red";
                                btnValue = "Go back";
                                url = "signup";
                                break;
                            case 0:
                                message = "Account Created Successfully";
                                color = "green";
                                btnValue = "Done";
                                url = "index";
                                createAccount(email,password,fName,lName,address,phone,stmt,out);
                        }
                    }
                }
                
                String box = ""+
                                        "    <div class=\"container\">\n" +
                "        <div class=\"d-flex flex-column justify-content-center\" id=\"login-box\">\n" +
                "            <div class=\"login-box-header\">\n" +
                "                <h4 style=\"color:rgb(139,139,139);margin-bottom:0px;font-weight:400;font-size:27px;\">Sign Up</h4>\n" +
                "            </div>\n" +
                "            <div class=\"d-flex flex-row align-items-center login-box-seperator-container\">\n" +
                "                <div class=\"login-box-seperator\"></div>\n" +
                "                <div class=\"login-box-seperator\"></div>\n" +
                "            </div>\n" +
                "                <div class=\"email-login\" style=\"background-color:#ffffff;\">\n"+
                "                <p style=\"color:"+color+"\">"+message+"</p>"+
                "               </div>\n" +
                "                <div class=\"submit-row\" style=\"margin-bottom:8px;padding-top:0px;\">\n" +
                "                    <a class=\"btn btn-primary btn-block box-shadow\" role=\"button\" type =\"submit\" id=\"submit-id-submit\" href=\""+url+"\">"+btnValue+"</a>\n" +
                "                    <!-- <input type=\"submit\" class =\"btn btn-primary btn-block box-shadow\" role=\"button\" id=\"submit-id-submit\" value =\"Sign Up\" form=\"SignupForm\">\n -->" +
                "                </div>\n" +
                "\n" +
                "            <div id=\"login-box-footer\" style=\"padding:10px 20px;padding-bottom:23px;padding-top:18px;\">\n" +
                "                <p style=\"margin-bottom:0px;\">Already have an account?<a id=\"register-link\" href=\"login\">Log In!</a></p>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>";
                out.println(box);
            }
            catch (SQLException ex) {
            out.println("SQLException: " + ex);
            }
            catch (Exception e) {
            //e.printStackTrace();
            out.println("Exception caught");
            out.println(e.toString());
            }
            out.println(Constants.getFooter());
            out.println(Constants.getClosing());
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println(Constants.getPreBody());
            out.println("<Body>\n");
            out.println(Constants.getNavBar());
            out.println(Constants.getPromo());
            signUp(request,response,out);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

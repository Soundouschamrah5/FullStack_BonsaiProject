/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.bonsaiweb;

import cst.CurrentAccount;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
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
@WebServlet(name = "AccountLogin", urlPatterns = {"/accountLogin"})
public class AccountLogin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddAccount</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Account Login</h1>");
            try {
                String email = request.getParameter("email").toUpperCase();
                String password = request.getParameter("password");
                Context ctx = new InitialContext();
                if (ctx == null) {
                throw new Exception("Error - No Context");
                }
                DataSource ds = (DataSource)
                ctx.lookup("java:/comp/env/jdbc/postgres");
                if (ds != null) {
                    Connection conn = ds.getConnection();
                    if (conn != null){
                        String qry = "SELECT * FROM Account WHERE\n"+
                                "UPPER(accountEmail) = " + "\'"+email+"\'" +
                                "  AND accountPass = " + "\'"+password+ "\'"+";";
                        out.print("<div>"+qry+"</div><br/>");
                        Statement stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery(qry);
                        if (!rs.next()){
                            //out.print("<div style=\"color:red\">Failed to find account</div><br/>");
                            Login.loginFailed = true;
                            response.sendRedirect("login");
                        }
                        else{
                            // out.print("<div style=\"color:green\">Successfully Logged in</div><br/>");
                            CurrentAccount.Logged = true;
                            CurrentAccount.ID = rs.getInt("accountID");
                            CurrentAccount.email = rs.getString("accountEmail");
                            CurrentAccount.firstName = rs.getString("accountFirstName");
                            CurrentAccount.lastName = rs.getString("accountLastName");
                            CurrentAccount.address = rs.getString("accountAddress");
                            CurrentAccount.phone = rs.getString("accountPhone");
                            response.sendRedirect("index");
                        }
                    }
                }
            }
            
            catch (SQLException ex) {
            out.println("SQLException: " + ex);
            }
            catch (Exception e) {
            //e.printStackTrace();
            out.println("Exception caught");
            out.println(e.toString());
            }
            out.println("</body>");
            out.println("</html>");
        
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

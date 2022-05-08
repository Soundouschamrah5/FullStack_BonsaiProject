/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.bonsaiweb;

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
@WebServlet(name = "AccountUpdate", urlPatterns = {"/accountUpdate"})
public class AccountUpdate extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private void updateAccount(HttpServletRequest request, HttpServletResponse response, PrintWriter out)
            throws ServletException, IOException , SQLException, NamingException, Exception{
        String email = request.getParameter("email");
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        
        if(email.isBlank() && fname.isBlank() && lname.isBlank() && address.isBlank() && phone.isBlank()){
            AccountProfile.setMessage("Enter a field to get update","red");
            response.sendRedirect("accountProfile");
        }
        
        StringBuilder qry = new StringBuilder("UPDATE Account\n");
        qry.append("SET ");
        if (!email.isBlank()) qry.append("accountEmail = \'" + email+"\',\n");
        if (!fname.isBlank()) qry.append("accountFirstName = \'" + fname + "\',\n");
        if (!lname.isBlank()) qry.append("accountLastName = \'" + lname +"\',\n");
        if (!address.isBlank()) qry.append("accountAddress = \'" + address + "\',\n");
        if (!phone.isBlank()) qry.append("accountPhone = \'" + phone + "\',\n");
        qry.deleteCharAt(qry.length()-2);
        qry.append("WHERE accountID = " + CurrentAccount.ID + ";");
        Context ctx = new InitialContext();
        if (ctx == null) {
            throw new Exception("Error - No Context");
        }
        // /jdbc/postgres is the name of the resource in context.xml
        DataSource ds = (DataSource)
        ctx.lookup("java:/comp/env/jdbc/postgres");
        if (ds != null) {
            Connection conn = ds.getConnection();
            if (conn != null) {
                Statement stmt = conn.createStatement();
                stmt.execute(qry.toString());
                AccountProfile.setMessage("Successfully updated account details", "green");
                if (!email.isBlank()) CurrentAccount.email = email;
                if (!fname.isBlank()) CurrentAccount.firstName = fname;
                if (!lname.isBlank()) CurrentAccount.lastName = lname;
                if (!address.isBlank()) CurrentAccount.address = address;
                if (!phone.isBlank()) CurrentAccount.phone = phone;
                response.sendRedirect("accountProfile");
            }
        }
        
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AccountUpdate</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AccountUpdate at " + request.getContextPath() + "</h1>");
            try{
                updateAccount(request,response,out);
            }
            catch (SQLException e){
               out.println("SQL Exception: "+e.toString()); 
            }
            catch (Exception e){
                out.println("Exception caught:<br/>"+e.toString());
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

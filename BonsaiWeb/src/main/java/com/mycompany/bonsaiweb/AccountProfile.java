/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.bonsaiweb;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cst.Constants;
import cst.CurrentAccount;

/**
 *
 * @author ayoub
 */
@WebServlet(name = "AccountProfile", urlPatterns = {"/accountProfile"})
public class AccountProfile extends HttpServlet {
    private static String message="";
    private static String color = "red";
    public static void setMessage(String m, String c){
        message = m;
        color = c;
    }
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private void printAccountForm(PrintWriter out){
        out.println(
                "<form id=\"account_details\" action=\"accountUpdate\">"+
                "<div align=\"center\">\n" +
                "           <!-- <p style=\"color:rgb(139,139,139);margin-bottom:0px;font-weight:400;font-size:27px;\">First name: </p> -->\n" +
                "           <!-- <input type=\"email\" class=\"email-imput form-control\" style=\"margin-top:10px;\" placeholder=\"\"> -->\n" +
                "           <label style=\"width:120px; clear:left; text-align:left;padding-right:10px\"><font face >Email:</label> "+
                "               <input type=\"text\" style=\"margin-top: 40px; width: 600px\" placeholder=\" "+CurrentAccount.email+"\" name=\"email\"> <br/>"+
                "           <label style=\"width:120px; clear:left; text-align:left;padding-right:10px\"><font face >First Name:</label> "+
                "               <input type=\"text\" style=\"margin-top: 40px; width: 600px\" placeholder=\" "+CurrentAccount.firstName+"\" name=\"fname\"> <br/>"+
                "           <label style=\"width:120px; clear:left; text-align:left;padding-right:10px\"><font face >Last Name:</label> "+
                "               <input type=\"text\" style=\"margin-top: 40px; width: 600px\" placeholder=\" "+CurrentAccount.lastName+"\" name=\"lname\"> <br/>"+
                "           <label style=\"width:120px; clear:left; text-align:left;padding-right:10px\"><font face >Address:</label> "+
                "               <input type=\"text\" style=\"margin-top: 40px; width: 600px\" placeholder=\" "+CurrentAccount.address+"\" name=\"address\"> <br/>"+
                "           <label style=\"width:120px; clear:left; text-align:left;padding-right:10px\"><font face >Phone Number:</label> "+
                "               <input type=\"text\" style=\"margin-top: 60px; width: 600px\" placeholder=\" "+CurrentAccount.phone+"\" name=\"phone\"> <br/>"
        );
        if(!message.isEmpty()){
            out.println(
                "               <span style=\"color:"+color+"\">"+message+"</span><br/>"
            );
            setMessage("","red");
        }
        out.println(
                "                    <input type=\"submit\" class =\"btn btn-primary btn-block box-shadow\" role=\"button\"  style=\"width: 240px; margin-top: 80px\"  value =\"Update\" form=\"account_details\">"+
                "</div>"+
                "</form>"
        
        );
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
            printAccountForm(out);
            out.println(Constants.getFooter());
            out.println(Constants.getClosing());
            
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

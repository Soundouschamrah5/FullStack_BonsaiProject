/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.bonsaiweb;

import cst.Constants;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ayoub
 */
@WebServlet(name = "signup", urlPatterns = {"/signup"})
public class Signup extends HttpServlet {

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
            out.println(Constants.getPreBody());
            out.println("<Body>\n");
            out.println(Constants.getNavBar());
            out.println(Constants.getPromo());
            out.println(
                "    <div class=\"container\">\n" +
                "        <div class=\"d-flex flex-column justify-content-center\" id=\"login-box\">\n" +
                "            <div class=\"login-box-header\">\n" +
                "                <h4 style=\"color:rgb(139,139,139);margin-bottom:0px;font-weight:400;font-size:27px;\">Sign Up</h4>\n" +
                "            </div>\n" +
                "            <div class=\"d-flex flex-row align-items-center login-box-seperator-container\">\n" +
                "                <div class=\"login-box-seperator\"></div>\n" +
                "                <div class=\"login-box-seperator\"></div>\n" +
                "            </div>\n" +
                "            <form name = \"AccountSignup\" action = \"accountSignup\" id=\"SignupForm\">\n" +
                "                <div class=\"email-login\" style=\"background-color:#ffffff;\">\n"+
                "                   <input type=\"email\" class=\"email-imput form-control\" style=\"margin-top:10px;\" required=\"\" placeholder=\"Email (Required)\" minlength=\"6\" name=\"email\">\n"+
                "                   <input type=\"password\" class=\"password-input form-control\" style=\"margin-top:10px;\" required=\"\" placeholder=\"Password (Required)\" minlength=\"6\" name=\"password\">\n" +
                "                   <input type=\"password\" class=\"password-input form-control\" style=\"margin-top:10px;\" required=\"\" placeholder=\"Confirm Password (Required)\"minlength=\"6\" name=\"confirm_password\">\n" +
                "                   <input type=\"text\" class=\"email-input form-control\" style=\"margin-top:10px;\" required=\"\" placeholder=\"First Name (Required)\" name=\"f_name\">"+
                "                   <input type=\"text\" class=\"email-input form-control\" style=\"margin-top:10px;\" required=\"\" placeholder=\"Last Name (Required)\" name=\"l_name\">" +
                "                   <input type=\"text\" class=\"email-input form-control\" style=\"margin-top:10px;\" required=\"\" placeholder=\"Address (Optional)\" name=\"address\">" +
                "                   <input type=\"text\" class=\"email-input form-control\" style=\"margin-top:10px;\" required=\"\" placeholder=\"Phone Number (Optional)\" name=\"phone\">" +
                "               </div>\n" +
                "            </form>\n" +
                "                <div class=\"submit-row\" style=\"margin-bottom:8px;padding-top:0px;\">\n" +
                "                    <!-- <a class=\"btn btn-primary btn-block box-shadow\" role=\"button\" type =\"submit\" id=\"submit-id-submit\" href=\"index.html\">Login</a> -->\n" +
                "                    <input type=\"submit\" class =\"btn btn-primary btn-block box-shadow\" role=\"button\" id=\"submit-id-submit\" value =\"Sign Up\" form=\"SignupForm\">\n" +
                "                </div>\n" +
                "\n" +
                "            <div id=\"login-box-footer\" style=\"padding:10px 20px;padding-bottom:23px;padding-top:18px;\">\n" +
                "                <p style=\"margin-bottom:0px;\">Already have an account?<a id=\"register-link\" href=\"login\">Log In!</a></p>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>"
            );
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

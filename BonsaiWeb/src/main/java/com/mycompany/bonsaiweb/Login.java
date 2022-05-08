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
@WebServlet(name = "login", urlPatterns = {"/login"})
public class Login extends HttpServlet {
    public static Boolean loginFailed = false;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private void loginForm(HttpServletRequest request, HttpServletResponse response, PrintWriter out)
            throws ServletException, IOException{
        out.println(
                "    <div class=\"container\">\n" +
                "        <div class=\"d-flex flex-column justify-content-center\" id=\"login-box\">\n" +
                "            <div class=\"login-box-header\">\n" +
                "                <h4 style=\"color:rgb(139,139,139);margin-bottom:0px;font-weight:400;font-size:27px;\">Login</h4>\n" +
                "            </div>\n" +
                "            <div class=\"login-box-content\">\n" +
                "                <div class=\"fb-login box-shadow\"><a class=\"d-flex flex-row align-items-center social-login-link\" href=\"Facebook.com\"><i class=\"fa fa-facebook\" style=\"margin-left:0px;padding-right:20px;padding-left:22px;width:56px;\"></i>Login with Facebook</a></div>\n" +
                "                <div class=\"gp-login box-shadow\"><a class=\"d-flex flex-row align-items-center social-login-link\" style=\"margin-bottom:10px;\" href=\"Gmail.com\"><i class=\"fa fa-google\" style=\"color:rgb(255,255,255);width:56px;\"></i>Login with Google+</a></div>\n" +
                "            </div>\n" +
                "            <div class=\"d-flex flex-row align-items-center login-box-seperator-container\">\n" +
                "                <div class=\"login-box-seperator\"></div>\n" +
                "                <div class=\"login-box-seperator-text\">\n" +
                "                    <p style=\"margin-bottom:0px;padding-left:10px;padding-right:10px;font-weight:400;color:rgb(201,201,201);\">or</p>\n" +
                "                </div>\n" +
                "                <div class=\"login-box-seperator\"></div>\n" +
                "            </div>\n" +
                "            <form name = \"AccountLogin\" action = \"accountLogin\" id=\"LoginForm\">\n" +
                "                <div class=\"email-login\" style=\"background-color:#ffffff;\"><input type=\"email\" class=\"email-imput form-control\" style=\"margin-top:10px;\" required=\"\" placeholder=\"Email\" minlength=\"6\" name=\"email\"><input type=\"password\" class=\"password-input form-control\" style=\"margin-top:10px;\" required=\"\" placeholder=\"Password\"\n" +
                "                        minlength=\"6\" name=\"password\"></div>\n" +
                "            </form>\n" +
                "                <div class=\"submit-row\" style=\"margin-bottom:8px;padding-top:0px;\">\n" +
                "                    <!-- <a class=\"btn btn-primary btn-block box-shadow\" role=\"button\" type =\"submit\" id=\"submit-id-submit\" href=\"index.html\">Login</a> -->\n" +
                "                    <input type=\"submit\" class =\"btn btn-primary btn-block box-shadow\" role=\"button\" id=\"submit-id-submit\" value =\"Login\" form=\"LoginForm\">\n" +
                "                    <div class=\"d-flex justify-content-between\">\n" +
                "                        <div class=\"form-check form-check-inline\" id=\"form-check-rememberMe\"><input class=\"form-check-input\" type=\"checkbox\" id=\"formCheck-1\" for=\"remember\" style=\"cursor:pointer;\" name=\"check\"><label class=\"form-check-label\" for=\"formCheck-1\"><span class=\"label-text\">Remember Me</span></label></div><a id=\"forgot-password-link\"\n" +
                "                            href=\"#\">Forgot Password?</a></div>\n");
        if(loginFailed){
            out.println(
            "<br/><div style=\"color:red\" align=\"center\">Login Failed! Wrong username or password</div>"
            );
            loginFailed = false;
        }
        out.println(
                "                </div>\n" +
                "\n" +
                "            <div id=\"login-box-footer\" style=\"padding:10px 20px;padding-bottom:23px;padding-top:18px;\">\n" +
                "                <p style=\"margin-bottom:0px;\">Don't you have an account?<a id=\"register-link\" href=\"signup\">Sign Up!</a></p>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>"
        );
    }
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            /*
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet login</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet login at " + request.getContextPath() + "</h1>");
            response.sendRedirect("login.html");
            out.println("Failed to login");
            out.println("</body>");
            out.println("</html>");
            */
            out.println(Constants.getPreBody());
            out.println("<Body>\n");
            out.println(Constants.getNavBar());
            out.println(Constants.getPromo());
            loginForm(request,response,out);
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

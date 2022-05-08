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
@WebServlet(name = "index", urlPatterns = {"/index"})
public class index extends HttpServlet {

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
            /*
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet index</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet index at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            */
            out.println(Constants.getPreBody());
            out.println("<Body>\n");
            out.println(Constants.getNavBar());
            out.println(Constants.getPromo());
            out.println(
            "<div class=\"container site-section\" id=\"welcome\" style=\"padding: 14px;\">\n" +
            "        <h1>Welcome to Bonsai Sushi Bar</h1>\n" +
            "        <p><br><em>Fresh, inventive and inspiring, the japanese cuisine equals first quality ingredients and refined presentation. The famous sushis and sashimis, the golden and crispy nems and fabulous Thai soups. Bonsai Sushi bar chefs propose a variety of specialities that remind the whole knowledge of the traditional Japanese and Thai cookery, with a fusion touch.</em><br><br></p>\n" +
            "    </div>\n" +
            "    <div class=\"dark-section\">\n" +
            "        <div class=\"container site-section\" id=\"why\" style=\"padding: 28px;\">\n" +
            "            <h1 class=\"border rounded shadow\">Why Choose Us?</h1>\n" +
            "            <div class=\"row\">\n" +
            "                <div class=\"col-lg-4 offset-lg-0 text-sm-left\" data-aos=\"fade\" style=\"padding: 15px;\">\n" +
            "                    <h4 class=\"text-center\"><strong><em>Great Taste</em></strong></h4>\n" +
            "                    <p class=\"text-center text-sm-center text-md-center text-lg-center text-xl-center\">Savor the freshest of ingredients, prepared and displayed by a master chef.<br><br></p>\n" +
            "                </div>\n" +
            "                <div class=\"col-lg-4\" data-aos=\"fade\" style=\"padding: 15px;\">\n" +
            "                    <h4><strong><em>Variety</em></strong></h4>\n" +
            "                    <p class=\"text-center text-sm-center text-md-center text-lg-center text-xl-center\">Whatever you’re in the mood for, it’s there.<br><br></p>\n" +
            "                </div>\n" +
            "                <div class=\"col-lg-4\" data-aos=\"fade\" style=\"padding: 15px;\">\n" +
            "                    <h4><strong><em>Fast Delivery</em></strong><br></h4>\n" +
            "                    <p class=\"text-center text-sm-center text-md-center text-lg-center text-xl-center\">We always try to deliver your food fast and fresh.<br><br></p>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <p></p>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "    <div class=\"container site-section\" id=\"welcome-1\" style=\"padding: 13px;\">\n" +
            "        <h1>Gallery</h1>\n" +
            "        <div class=\"row\">\n" +
            "            <div class=\"col\">\n" +
            "                <div class=\"card\"><a href=\"assets/img/images.jpg\" target=\"_blank\" data-lightbox=\"sushi\"><img class=\"img-fluid\" src=\"assets/img/images.jpg\"></a></div>\n" +
            "            </div>\n" +
            "            <div class=\"col\">\n" +
            "                <div class=\"card\"><a href=\"assets/img/images.jpg\" target=\"_blank\" data-lightbox=\"sushi\"><img class=\"img-fluid\" src=\"assets/img/images%20(1).jpg\"></a></div>\n" +
            "            </div>\n" +
            "            <div class=\"col\">\n" +
            "                <div class=\"card\"><a href=\"assets/img/images.jpg\" target=\"_blank\" data-lightbox=\"sushi\"><img class=\"img-fluid\" src=\"assets/img/images%20(2).jpg\"></a></div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "    <footer>\n" +
            "        <div class=\"container\">\n" +
            "            <div class=\"row\">\n" +
            "                <div class=\"col-sm-6 col-md-4 footer-navigation\">\n" +
            "                    <h3><a href=\"#\">Bonsai Sushi Bar</a></h3>\n" +
            "                    <p class=\"links\"><a href=\"index.html\">Home</a><strong> · </strong><a href=\"Menu.html\">Menu</a><strong> · </strong><a href=\"Order.html\">Order</a><strong> · </strong><a href=\"index.html\">About</a><strong>&nbsp;· </strong><a href=\"ContactUs.html\">Contact</a></p>\n" +
            "                    <p\n" +
            "                        class=\"company-name\">Bonsai Sushi Bar © 2021</p>\n" +
            "                </div>\n" +
            "                <div class=\"col-sm-6 col-md-4 footer-contacts\">\n" +
            "                    <div><span class=\"fa fa-map-marker footer-contacts-icon\"> </span>\n" +
            "                        <p><span class=\"new-line-span\">Quartier Hay Ryad&nbsp;</span>Ifrane, Morocco</p>\n" +
            "                    </div>\n" +
            "                    <div><i class=\"fa fa-phone footer-contacts-icon\"></i>\n" +
            "                        <p class=\"footer-center-info email text-left\"> +212 6 16 83 03 80</p>\n" +
            "                    </div>\n" +
            "                    <div><i class=\"fa fa-envelope footer-contacts-icon\"></i>\n" +
            "                        <p> <a href=\"#\" target=\"_blank\" style=\"font-size: 15px;\">support@bonsai.com</a></p>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "                <div class=\"clearfix\"></div>\n" +
            "                <div class=\"col-md-4 footer-about\">\n" +
            "                    <h4>What is a bonsai?</h4>\n" +
            "                    <p>The word “Bon-sai” (often misspelled as bonzai or banzai) is a Japanese term which, literally translated, means “planted in a container”.&nbsp;<br></p>\n" +
            "                    <div class=\"social-links social-icons\"><a href=\"https://www.facebook.com/bonsaisushibarifrane/\" target=\"_blank\"><i class=\"fa fa-facebook\"></i></a><a href=\"#\"><i class=\"fa fa-twitter\"></i></a><a href=\"#\"><i class=\"fa fa-linkedin\"></i></a><a href=\"#\"><i class=\"fa fa-github\"></i></a></div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </footer>\n" +
            "    <script src=\"assets/js/jquery.min.js\"></script>\n" +
            "    <script src=\"assets/bootstrap/js/bootstrap.min.js\"></script>\n" +
            "    <script src=\"assets/js/bs-init.js\"></script>\n" +
            "    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/aos/2.1.1/aos.js\"></script>\n" +
            "    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/lightbox2/2.11.3/js/lightbox.min.js\"></script>\n" +
            "    <script src=\"assets/js/PHP-Contact-Form-dark-1.js\"></script>\n" +
            "    <script src=\"assets/js/PHP-Contact-Form-dark.js\"></script>\n" +
            "    <script src=\"assets/js/Pricing-Table-Item-1.js\"></script>\n" +
            "    <script src=\"assets/js/Pricing-Table-Item.js\"></script>\n" +
            "</body>\n" +
            "\n" +
            "</html>"
            );
            
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

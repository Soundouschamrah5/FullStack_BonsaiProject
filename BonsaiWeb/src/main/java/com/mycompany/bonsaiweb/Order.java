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


import javax.naming.*; 
import javax.sql.*; 
import java.sql.*; 

/**
 *
 * @author ayoub
 */
@WebServlet(name = "order", urlPatterns = {"/order"})
public class Order extends HttpServlet {
    
    
    private void displayDishes(HttpServletRequest request, HttpServletResponse response, PrintWriter out, String qry)
            throws SQLException, ServletException, IOException, Exception{
        out.println(
                "<form name=\"Search Dishes\" id=\"display_dishes\" action=\"order\">\n"+
                "<div style=\"margin-top: 5%; padding-left: 10%\">\n"+
                "   <font face= \"Times New Roman\" size = \"4\">\n"+   
                "       <span>Search by name:<span>\n"+
                "       <input type=\"text\" style=\"width: 120px; margin-left: 10px; margin-right: 30px\" name=\"search_sub\" id=\"search_sub\">\n"+
                        
                "       <span>Sort the dishes by:</span>"+
                "       <select name=\"sort_by\" id=\"sort_by\" style=\"width: 120px; margin-left: 10px; margin-right: 20px\">\n" +
                "           <option value=\"dishName\">Name</option>\n" +
                "           <option value=\"dishType\">Type</option>\n"+
                "           <option value=\"dishPrice\">Price</option>\n"+
                "           <option value=\"dishPopularity\">Popularity</option>\n"+
                "       </select>\n"+
                "       <span> in </span>\n"+
                "       <select name=\"order_by\" id=\"order_by\" style=\"width: 120px; margin-left: 10px; margin-right: 20px\">\n" +
                "           <option value=\"ASC\">Ascending</option>\n" +
                "           <option value=\"DESC\">Descending</option>\n"+
                "       </select\n>"+
                "       <span> order </span>\n"+
                "       <input type=\"submit\" role=\"button\"  style=\"width: 120px; margin-left: 60px\"  value =\"Search\" form=\"display_dishes\" name=\"search\">\n"+
                "   </font>\n"+
                "</div>\n"+
                "</form><br/><br/>\n"
        );
        
        Context ctx = new InitialContext();
        if (ctx == null) { 
            throw new Exception("Error - No Context"); 
        }    

        // /jdbc/postgres is the name of the resource in context.xml  
        DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/postgres");  
        if (ds != null) { 
            Connection conn = ds.getConnection();
         
            if (conn != null) {
                Statement stmt = conn.createStatement(); 
                // Result set get the result of the SQL query 
                ResultSet rs = stmt.executeQuery(qry); 
                ResultSetMetaData rsmd = rs.getMetaData(); 
                int c = rsmd.getColumnCount();
                out.println("<div style=\"\">");
                // out.println("<table style =\"margin-top: 5%; padding-left: 10%; margin-bottom: 10%;border:1px solid black;margin-left:auto;margin-right:auto;\" border=1 width=50% height=50%>");  
                // out.println("<tr><th>Name</th><th>Type</th><th>Price</th><tr>");
                out.println(
                "<div align=\"left\" style=\"padding-left:10%;padding-right:5%;\">\n"+
                "<table style=\"border:0px solid black ;table-layout:auto\">\n" +
                "<tr>\n" +
                "   <td style=\"padding: 0 40px\"><b>Name</b></td>\n" +
                "   <td style=\"padding: 0 40px\"><b>Type</b></td>\n" +
                "   <td style=\"padding: 0 40px\"><b>Price</b></td>\n" +
                "   <td style=\"padding: 0 80px\"><b></b></td>\n"+
                "</tr>\n"
                );
                
                while(rs.next()){
                    String name = rs.getString("dishName");
                    String type = rs.getString("dishType");
                    Double price = rs.getDouble("dishPrice");
                    out.println(
                    "<tr>\n" +
                    "   <td style=\"padding: 0 40px\">"+name+"</td>\n" +
                    "   <td style=\"padding: 0 40px\">"+type+"</td>\n" +
                    "   <td style=\"padding: 0 40px\">"+price+" MAD"+"</td>\n" +
                    "   <td style=\"padding: 0 80px\">Quantity <input type=\"text\" style=\"width: 25px; margin-left: 15px\" value=\"0\"></td>\n"+
                    "</tr>\n"
                    );
                }
                
                out.println(
                "</table>"+
                "</div>"+
                "</div>"+
                "<div align=\"right\" style=\"padding-right:25%; margin-top: 25px\">"+
                "   <a class=\"btn btn-info btn-lg\" role=\"button\" href=\"order\">Order</a></p>\n"+
                "</div>"
                );
                
            }
        }
    }
    
    private String buildQuery(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException{
        StringBuilder qry = new StringBuilder("SELECT dishName, dishType, dishPrice FROM Dish");
        if(request.getParameter("search") != null){
            String sub = request.getParameter("search_sub");
            String sortParameter = request.getParameter("sort_by");
            String orderParameter = request.getParameter("order_by");
            if(sub != null && !sub.isBlank())
                qry.append(" WHERE UPPER(dishName) LIKE \'%"+sub.toUpperCase()+"%\'");          
            qry.append(" ORDER BY "+sortParameter+" "+orderParameter);
            
        }
        qry.append(";");
        return qry.toString();
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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            out.println(Constants.getPreBody());
            out.println("<Body>\n");
            out.println(Constants.getNavBar());
            String qry = "";
            try{
            qry = buildQuery(request,response);
            displayDishes(request, response, out, qry);
            }
            catch (SQLException e){
                out.println("SQLException: " + e.toString());
                out.println("<br/>");
                out.println(qry);
            }
            catch (Exception e){
                out.println("Exception caught:\n"+e.toString());
            }
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

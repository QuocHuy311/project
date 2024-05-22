/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package control;

import dao.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.CategoryDTO;

/**
 *
 * @author quoch
 */
@WebServlet(name="piechartControl", urlPatterns={"/piechart"})
public class piechartControl extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        DAO dao = new DAO();
        ArrayList<CategoryDTO> listO = dao.getQuantityCategory();
        
        CategoryDTO cdto1 = new CategoryDTO();
        CategoryDTO cdto2 = new CategoryDTO();
        CategoryDTO cdto3 = new CategoryDTO();
        CategoryDTO cdto4 = new CategoryDTO();
        CategoryDTO cdto5 = new CategoryDTO();
        CategoryDTO cdto6 = new CategoryDTO();
        CategoryDTO cdto7 = new CategoryDTO();
        
        int count = 1;
        for (CategoryDTO o : listO) {
            if (count == 1) {
                cdto1 = o;
            }
            if (count == 2) {
                cdto2 = o;
            }
            if (count == 3) {
                cdto3 = o;
            }
            if (count == 4) {
                cdto4 = o;
            }
            if (count == 5) {
                cdto5 = o;
            }
            if (count == 6) {
                cdto6 = o;
            }
            if (count == 7) {
                cdto7 = o;
            }
            if (count == 8) {
                break;
            }
            count++;
        }
        request.setAttribute("cdto1", cdto1);
        request.setAttribute("cdto2", cdto2);
        request.setAttribute("cdto3", cdto3);
        request.setAttribute("cdto4", cdto4);
        request.setAttribute("cdto5", cdto5);
        request.setAttribute("cdto6", cdto6);
        request.setAttribute("cdto7", cdto7);
        request.getRequestDispatcher("piechart.jsp").forward(request, response);
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

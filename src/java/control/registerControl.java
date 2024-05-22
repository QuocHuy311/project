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
import model.Account;
import utils.Validation;

/**
 *
 * @author quoch
 */
@WebServlet(name = "registerControl", urlPatterns = {"/register"})
public class registerControl extends HttpServlet {

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
        response.setCharacterEncoding("UTF-8");
        DAO dao = new DAO();
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        String re_pass = request.getParameter("re_pass");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        try {
            int phonenumber = Integer.parseInt(request.getParameter("phonenumber"));

            if (!email.matches("^[A-Za-z](.*)([@]{1})(.{2,})(\\.)(.{2,})")) {
                request.setAttribute("mess1", " Nhập email theo định dạng này: account_name@domain.domain");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
            if ((Validation.removeAllBlank(pass).length() < 8) || (Validation.removeAllBlank(re_pass).length() < 8)) {
                request.setAttribute("mess1", "Mật khẩu phải nhiều hơn 8 ký tự");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
            if (request.getParameter("phonenumber").matches("-?[0-9 ]+")) {
                request.setAttribute("mess1", "Số điện thoại phải là các số từ 0-9");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
            if (dao.checkDuplicateAccount(email)) {
                request.setAttribute("mess1", "Tài khoản đã tồn tại");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else {
                dao.getRegister(email, pass, name, address, phonenumber);
                response.sendRedirect("login.jsp");
            }
        } catch (NumberFormatException e) {
            request.setAttribute("mess1", "Số điện thoại phải là các số từ 0-9");
            request.getRequestDispatcher("login.jsp").forward(request, response);
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

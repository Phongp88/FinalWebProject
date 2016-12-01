/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import newBean.UserSLSB;

/**
 *
 * @author 695923
 */
public class UserOps2 extends HttpServlet {

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
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirm = request.getParameter("confirm");
        String admin = request.getParameter("admin");
        String lock = request.getParameter("locked");
    
        UserSLSB usb = new UserSLSB();
        String message = "";

        if (admin == null) {
            admin = "0";

        }
        if (lock == null) {
            lock = "0";
        }
        if (username != null && password != null && confirm != null&&admin!=null&&lock!=null&&!username.equals("")&&!password.equals("")&&!confirm.equals("")){
            if (password.equals(confirm)) {
                System.out.println("its still going here");
                usb.addUser(username, password, Integer.parseInt(admin), Integer.parseInt(lock));
                message = "User added";
                response.sendRedirect("admin.jsp?message=" + message);

            } else {
                message = "Passwords do not match!";
                response.sendRedirect("admin.jsp?message=" + message);
            }

        } else {
            message = "Passwords do not match!";
            response.sendRedirect("admin.jsp?message=" + message);
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Database.ProductoDAO;
import Model.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author super
 */
@WebServlet(name = "ProductoController", urlPatterns = {"/ProductoController"})
public class ProductoController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProductoController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductoController at " + request.getContextPath() + "</h1>");
            out.println("<h1>Test</h1>");
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String op;
        op = (request.getParameter("op") != null) ? request.getParameter("op") : "list";
        
        if(op.equals("init")){
            HttpSession session = request.getSession();
            session.setAttribute("access", 1);
            
            List<Producto> list = null;
            try {
                list = ProductoDAO.listar();
            } catch (SQLException ex) {
                Logger.getLogger(ProductoController.class.getName()).log(Level.SEVERE, null, ex);
            }
            session.setAttribute("list", list);
            
            response.sendRedirect("/productos/");
        }
        
        if(op.equals("eliminar")){
            String id;
            id = request.getParameter("id");
            
            try {
                ProductoDAO.delete(Integer.parseInt(id));
            } catch (SQLException ex) {
                Logger.getLogger(ProductoController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            response.sendRedirect("/productos/");
        }
        
        if(op.equals("editar")){
            String id;
            id = request.getParameter("id");
            
            HttpSession session = request.getSession();
            session.setAttribute("id", id);
            
            response.sendRedirect("/productos/edit.jsp");
        }
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String op;
        op = (request.getParameter("op") != null) ? request.getParameter("op") : "list";

        if (op.equals("nuevo")) {
            
            String nombre = request.getParameter("lnombre");
            int precio = Integer.parseInt(request.getParameter("lprecio"));
            String tipo = request.getParameter("ltipo");
            Producto p = new Producto(nombre, precio, tipo);
            
            try {
                ProductoDAO.add(p);
            } catch (SQLException ex) {
                Logger.getLogger(ProductoController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            response.sendRedirect("/productos/");
        }
        
        if(op.equals("edit")){
            int id = Integer.parseInt(request.getParameter("lid"));
            String nombre = request.getParameter("lnombre");
            int precio = Integer.parseInt(request.getParameter("lprecio"));
            String tipo = request.getParameter("ltipo");
            Producto p = new Producto(nombre, precio, tipo);
            
            try {
                ProductoDAO.update(p, id);
            } catch (SQLException ex) {
                Logger.getLogger(ProductoController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            response.sendRedirect("/productos/");
        }
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serwlety;

import Trwalosc.PracownicyQuery;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author student
 */
@WebServlet(name = "Usun", urlPatterns = {"/Usun"})
public class Usun extends HttpServlet {

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
        String IDp = request.getParameter("IDp");
        String kom_usunieto = "Wpisane ID bylo niepoprawne";
        if(IDp != null) {
            int wyn = new PracownicyQuery().usunPracownika(IDp);
            if(wyn == 1)
            {
                kom_usunieto = "Usunieto pracownika o ID "+IDp;
            }
        }
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");            
            out.println("<meta><link rel='stylesheet' href='Style/css/components.css'>");            
            out.println("<link rel='stylesheet' href='Style/css/icons.css'>");            
            out.println("<link rel='stylesheet' href='Style/css/responsee.css'>");             
            out.println("<title>Servlet Usun</title>");            
            out.println("</head>");
            out.println("<body>" + kom_usunieto+"<br />Lista pracowników<br />"); 
           // out.println(getDataFromDb());
            out.println(new PracownicyQuery().getPracownicyListaBYID());
            out.println("</body></html>");   
            out.println("<a class=\'button rounded-full-btn reload-btn s-2 margin-bottom\' href=");            
            out.println(request.getHeader("referer"));            
            out.println("><i class='icon-sli-arrow-left'>Powrót</i></a>");
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

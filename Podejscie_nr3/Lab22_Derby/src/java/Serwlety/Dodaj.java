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
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import Trwalosc.Pracownicy;

/**
 *
 * @author student
 */
@WebServlet(name = "Dodaj", urlPatterns = {"/Dodaj"})
public class Dodaj extends HttpServlet {

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
            
            throws ServletException, IOException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        String imie = request.getParameter("imie");
        String nazwisko = request.getParameter("nazwisko");
        out.println(new PracownicyQuery().dodajPracownika(imie,nazwisko));
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           /* out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Dodaj</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Dodaj at " + request.getContextPath() + "</h1>");
            out.println(new PracownicyQuery().dodajPracownika(imie,nazwisko));
            out.println("</body>");
            out.println("</html>");*/
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");            
            out.println("<meta><link rel='stylesheet' href='Style/css/components.css'>");            
            out.println("<link rel='stylesheet' href='Style/css/icons.css'>");            
            out.println("<link rel='stylesheet' href='Style/css/responsee.css'>");             
            out.println("<title>Servlet Dodaj</title>");            
            out.println("</head>");
            out.println("<body>" + "Lista pracowników<br />"); 
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
        try {
            processRequest(request, response);
        } catch (NoSuchFieldException ex) {
            Logger.getLogger(Dodaj.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Dodaj.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Dodaj.class.getName()).log(Level.SEVERE, null, ex);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (NoSuchFieldException ex) {
            Logger.getLogger(Dodaj.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Dodaj.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Dodaj.class.getName()).log(Level.SEVERE, null, ex);
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

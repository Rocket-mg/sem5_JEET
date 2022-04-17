/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serwlety;

import Trwalosc.PicturesQuery;
import Trwalosc.PracownicyQuery;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author student
 */
@WebServlet(name = "Nowy", urlPatterns = {"/Nowy"})
public class Nowy extends HttpServlet {

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
        String name= request.getParameter("nameA");
        String author = request.getParameter("authorA");
        String type = request.getParameter("typeA");
        String form = request.getParameter("formA");
        String USDprice = request.getParameter("USD_priceA");
        String MP = request.getParameter("M_propertyA");
        boolean MP2 = true;
        if(MP == null){
            MP2 = false;
        }
        int idd = new PicturesQuery().dodajImage(name, author, type, form, USDprice, MP2);
        //out.println(new PicturesQuery().dodajImage(name, author, type, form, USDprice, MP2));
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
            out.println("<title>Servlet Nowy</title>");            
            out.println("</head>");
            out.println("<body>" + "Dodano obraz o ID " + idd +"<br>Lista obrazów<br />"); 
           // out.println(getDataFromDb());
            out.println(new PicturesQuery().getPicturesLista(false));
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
            Logger.getLogger(Nowy.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Nowy.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Nowy.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Nowy.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Nowy.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Nowy.class.getName()).log(Level.SEVERE, null, ex);
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

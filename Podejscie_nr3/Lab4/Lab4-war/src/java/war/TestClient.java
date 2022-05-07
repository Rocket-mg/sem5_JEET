/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war;

import ebj.DataAccessBeanRemote;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author student
 */
@WebServlet(name = "TestClient", urlPatterns = {"/TestClient"})
public class TestClient extends HttpServlet {

    @EJB
    private DataAccessBeanRemote dataAccessBean;
    //Stanowy komponent EJB
    //
    //HttpSession session = request.getSession();
    //DataAccessBeanRemote bean = (DataAccessBeanRemote) session.getAttribute("ejb");
    //if (bean = null) {
    // InitialContext ctx = new InitialContext();
    // Object obj = ctx. Lookup ("lab4.ebj.DataAccessBeanRemote");
    //bean = (DataAccessBeanRemote) PortableRemoteobject.narrow(obj, DataAccessBeanRenote.class);
    //session.setAttribute("ejb", bean);
    //
    //###
    //Bezstanowy komponent EJE
    //***
    /*InitialContext ctx;
    Object obj = ctx.lookup("lab4.ebj.DataAccessBeanRemote");
    DataAccessBeanRemote bean = (DataAccessBeanRemote) PortableRemoteObject.narrow(obj, DataAccessBeanRemote.class);

    public TestClient() throws NamingException {
        this.ctx = new InitialContext();
    }/*
    //###
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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TestClient</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<b>Ostatni dostęp: " + dataAccessBean.getOstatnieDane()+ "</b><br/>");
            dataAccessBean.setOstatnieDane(request.getHeader("user-agent"), new java.util.Date());
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

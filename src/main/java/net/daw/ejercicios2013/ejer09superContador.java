/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.ejercicios2013;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rafa
 */
public class ejer09superContador extends HttpServlet {

    private ServletConfig config;
    private String fichero;
    private int count;

    @Override
    public void init(ServletConfig oConfig) throws ServletException {
        super.init(oConfig);
        ServletContext ctx = oConfig.getServletContext();
        fichero = oConfig.getInitParameter("fichero");
        try {
            FileReader rFichero = new FileReader(ctx.getRealPath(fichero));
            BufferedReader bFichero = new BufferedReader(rFichero);
            String strInicial = bFichero.readLine();
            try {
                count = Integer.parseInt(strInicial);
            } catch (NumberFormatException ignored) {
                count = 0;
            }
            bFichero.close();
        } catch (FileNotFoundException e) {
            count = 0;
        } catch (IOException e) {
            count = 0;
        }
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

        PrintWriter out = response.getWriter();

        response.setContentType("text/html");
        synchronized (request) {
            out.println(String.format("<p>Contador de visitas: %d</p>", ++count));
        }
//        HttpSession session = request.getSession();
//        String name = (String) session.getAttribute(Login.strName);
//        Integer numAccess = (Integer) session.getAttribute(strNumAccess);
//        if (numAccess == null) {
//            numAccess = new Integer(0);
//        }
//        session.setAttribute(strNumAccess, new Integer(numAccess.intValue() + 1));
//        String rmSesion = request.getParameter(strRemoveSession);
//        RequestDispatcher rd = request.getRequestDispatcher(greetings);
//        rd.include(request, response);
//        if (rmSesion != null) {
//            rd = request.getRequestDispatcher(sessionRemoved);
//            rd.include(request, response);
//            session.removeAttribute(strNumAccess);
//            session.removeAttribute(Login.strName);
//        } else {
//            rd = request.getRequestDispatcher(formContinue);
//            rd.include(request, response);
//        }
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

    @Override
    public final void destroy() {
        ServletContext oContext = getServletConfig().getServletContext();
        String file = oContext.getInitParameter("fichero");
        System.out.println("fichero..." + file);
        try {
            System.out.println("escribiendo...");
            FileWriter wFichero = new FileWriter(oContext.getRealPath(fichero));
            wFichero.write(String.format("%d", count), 0, String.format("%d", count).length());
            wFichero.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } 
    }

}

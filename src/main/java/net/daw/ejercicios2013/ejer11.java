/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.ejercicios2013;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rafa
 */
public class ejer11 extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ejer11</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ejer11 at " + request.getContextPath() + "</h1>");
            out.println("<h3>Estadísticas</h3>");
            ServletContext ctx = request.getServletContext();
            Long acumulado;
            try {
                FileReader rFichero = new FileReader(ctx.getRealPath("estadisticas01.txt"));
                BufferedReader bFichero = new BufferedReader(rFichero);
                String strInicial = bFichero.readLine();
                try {
                    acumulado = Long.parseLong(strInicial);
                } catch (NumberFormatException ignored) {
                    acumulado = 0L;
                }
                bFichero.close();
            } catch (FileNotFoundException e) {
                acumulado = 0L;
            } catch (IOException e) {
                acumulado = 0L;
            }
            
            
                        ServletContext ctx2 = request.getServletContext();
            Integer peticiones;
            try {
                FileReader rFichero = new FileReader(ctx.getRealPath("estadisticas02.txt"));
                BufferedReader bFichero = new BufferedReader(rFichero);
                String strInicial = bFichero.readLine();
                try {
                    peticiones = Integer.parseInt(strInicial);
                } catch (NumberFormatException ignored) {
                    peticiones = 0;
                }
                bFichero.close();
            } catch (FileNotFoundException e) {
                peticiones = 0;
            } catch (IOException e) {
                peticiones = 0;
            }
            
            
            
            out.println("<p>Milisegundos acumulados: " + acumulado + "</p>");
            out.println("<p>Peticiones: " + peticiones + "</p>");
            out.println("<p>Media: " + acumulado/peticiones + " ms por petición</p>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
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

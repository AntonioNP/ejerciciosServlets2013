/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.ejercicios2013;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rafa
 */
public class ejer01peticionHTTP extends HttpServlet {

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
            out.println("<title>Servlet ejer01peticionHTTP</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<h1>Parámetros de sistema</h1>");
            out.println("<b>Protocolo:</b>" + request.getProtocol() + "<br />");
            out.println("<b>Método:</b>" + request.getMethod() + "<br />");
            out.println("<b>URI:</b>" + request.getRequestURI() + "<br />");
            out.println("<b>URL:</b>" + request.getRequestURL()+ "<br />");
            out.println("<b>Path:</b>" + request.getContextPath() + "<br />");
            out.println("<b>Codificación:</b>" + request.getCharacterEncoding()+ "<br />");
            out.println("<b>Tipo mime:</b>" + request.getContentType()+ "<br />");
            out.println("<b>IP recepción:</b>" + request.getLocalAddr()+ "<br />");
            out.println("<b>Nombre ifaz. recepción:</b>" + request.getLocalName()+ "<br />");
            out.println("<b>Path:</b>" + request.getPathInfo()+ "<br />");
            out.println("<b>PrePath:</b>" + request.getPathTranslated()+ "<br />");
            out.println("<b>IP remota:</b>" + request.getRemoteAddr()+ "<br />");
            out.println("<b>Host remoto:</b>" + request.getRemoteHost()+ "<br />");
            out.println("<b>Nombre del host remoto:</b>" + request.getServerName()+ "<br />");
            out.println("<b>Puerto:</b>" + request.getServerPort()+ "<br />");                      
            
            out.println("<h1>Cabeceras</h1>");
            out.println("<table><tr><th>Cabecera</th><th>Valor</th></tr>");
            Enumeration cabeceras = request.getHeaderNames();
            while (cabeceras.hasMoreElements()) {
                String cabecera = (String) cabeceras.nextElement();
                out.println("<tr><td>" + cabecera + "</td >");
                out.println("<td>" + request.getHeader(cabecera) + "</td></tr>");
            }
            out.println("</table>");
            
            out.println("<h1>Parámetros de usuario</h1>");
            out.println("<table><tr><th>Parametro</th><th>Valor</th></tr>");
            Enumeration parametros = request.getParameterNames();
            while (parametros.hasMoreElements()) {
                String parametro = (String) parametros.nextElement();
                out.println("<tr><td>" + parametro + "</td><td>");
                String[] valores = request.getParameterValues(parametro);
                if (valores.length == 1) {
                    String paramValue = valores[0];
                    if (paramValue.length() == 0) {
                        out.print("Vacío");
                    } else {
                        out.println(paramValue);
                    }
                } else {
                    out.print("<b>Array: </b>");
                    for (int i = 0; i < valores.length; i++) {
                        out.println(valores[i] + " ");
                    }
                }
                out.print("</td>");
            }
            out.println("</table>");
            out.println("<a href=\"index.jsp\">Volver al índice</a>");
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

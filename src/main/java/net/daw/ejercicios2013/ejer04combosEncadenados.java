/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.ejercicios2013;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rafa
 */
public class ejer04combosEncadenados extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private String DameCombo(String nombre, ArrayList<String> alValores, String selected) {
        String strCombo = "<select name=\"" + nombre + "\">\n";
        strCombo += "<option value=\"\" ";
        if (selected.equals("ninguno")) {
            strCombo += "selected";
        }
        strCombo += " >Escoge un " + nombre + "</option>\n";
        Iterator<String> it = alValores.iterator();
        while (it.hasNext()) {
            String valor = it.next();
            strCombo += "<option ";
            if (valor.equals(selected)) {
                strCombo += "selected";
            }
            strCombo += " >" + valor + "</option>\n";
        }
        strCombo += "</select>";
        return strCombo;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ejer04combosEncadenados</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ejer04combosEncadenados at " + request.getContextPath() + "</h1>");
            out.println("<form name=\"combos\" action=\"ejer04combosEncadenados\">\n");

            if (request.getParameter("marca") == null || request.getParameter("marca") == ""
                    || "reset".equals(request.getParameter("reset"))) {
                ArrayList<String> alMarcas = new ArrayList<String>();
                alMarcas.add("TOYOTA");
                alMarcas.add("BMW");
                alMarcas.add("SEAT");
                out.println(DameCombo("marca", alMarcas, "ninguno"));

            } else {
                //tenemos marca

                ArrayList<String> alMarcas = new ArrayList<String>();
                alMarcas.add("TOYOTA");
                alMarcas.add("BMW");
                alMarcas.add("SEAT");
                out.println(DameCombo("marca", alMarcas, request.getParameter("marca")));

                if (request.getParameter("marca").equals("TOYOTA")) {
                    ArrayList<String> alModelos = new ArrayList<String>();
                    alModelos.add("Celica");
                    alModelos.add("Corolla");
                    alModelos.add("Avensis");
                    if (request.getParameter("modelo") == null || request.getParameter("modelo") == "") {
                        out.println(DameCombo("modelo", alModelos, "ninguno"));
                    } else {
                        out.println(DameCombo("modelo", alModelos, request.getParameter("modelo")));
                    }
                }

                if (request.getParameter("marca").equals("BMW")) {
                    ArrayList<String> alModelos = new ArrayList<String>();
                    alModelos.add("Serie1");
                    alModelos.add("Serie3");
                    alModelos.add("Serie5");
                    if (request.getParameter("modelo") == null || request.getParameter("modelo") == "") {
                        out.println(DameCombo("modelo", alModelos, "ninguno"));
                    } else {
                        out.println(DameCombo("modelo", alModelos, request.getParameter("modelo")));
                    }
                }

                if (request.getParameter("marca").equals("SEAT")) {
                    ArrayList<String> alModelos = new ArrayList<String>();
                    alModelos.add("Altea");
                    alModelos.add("Cordoba");
                    alModelos.add("Ibiza");
                    if (request.getParameter("modelo") == null || request.getParameter("modelo") == "") {
                        out.println(DameCombo("modelo", alModelos, "ninguno"));
                    } else {
                        out.println(DameCombo("modelo", alModelos, request.getParameter("modelo")));
                    }
                }

                if (request.getParameter("modelo") != null && request.getParameter("modelo") != "") {
                    ArrayList<String> alColores = new ArrayList<String>();
                    alColores.add("Azul");
                    alColores.add("Verde");
                    alColores.add("Rojo");
                    if (request.getParameter("color") == null || request.getParameter("color") == "") {
                        out.println(DameCombo("color", alColores, "ninguno"));
                    } else {
                        out.println(DameCombo("color", alColores, request.getParameter("color")));
                    }
                    if (request.getParameter("color") != null && request.getParameter("color") != "") {
                        out.println("<br/>");
                        out.println("Has elegido marca " + request.getParameter("marca"));
                        out.println("<br/>");
                        out.println("Has elegido modelo " + request.getParameter("modelo"));
                        out.println("<br/>");
                        out.println("Has elegido color " + request.getParameter("color"));
                        out.println("<br/>");
                    }

                }

            }
            out.println("<br/>");
            out.println("<input type=\"submit\" value=\"enviar\" name=\"enviar\" />\n");
            out.println("<input type=\"submit\" value=\"reset\" name=\"reset\" />\n");
            out.println("</form>\n");
            out.println("</select>");
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

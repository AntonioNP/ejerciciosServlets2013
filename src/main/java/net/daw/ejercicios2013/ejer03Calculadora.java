/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.ejercicios2013;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rafa
 */
public class ejer03Calculadora extends HttpServlet {

    public boolean esDecimal(String cad) {
        try {
            Double.parseDouble(cad);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    public boolean esEntero(String cad) {
        try {
            Integer.parseInt(cad);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String intOperacion = request.getParameter("oper");
            String strOperando1 = request.getParameter("ope1");
            String strOperando2 = request.getParameter("ope2");

            if (!esDecimal(strOperando1)) {
                out.print("formato incorrecto del operador 1<br/>");
                out.print("<a href=\"calculadora.jsp\">volver</a><br/>");
            } else {
                if (!esDecimal(strOperando2)) {
                    out.print("formato incorrecto del operador 2<br/>");
                    out.print("<a href=\"calculadora.jsp\">volver</a><br/>");
                } else {
                    if (!esEntero(intOperacion)) {
                        out.print("formato incorrecto de la operación<br/>");
                        out.print("<a href=\"calculadora.jsp\">volver</a><br/>");
                    } else {
                        Double resultado;
                        String mostrar;
                        switch (Integer.parseInt(intOperacion)) {
                            case 1:
                                resultado = Double.parseDouble(strOperando1) + Double.parseDouble(strOperando2);
                                mostrar = strOperando1 + " + " + strOperando2 + " = " + resultado;
                                break;
                            case 2:
                                resultado = Double.parseDouble(strOperando1) - Double.parseDouble(strOperando2);
                                mostrar = strOperando1 + " - " + strOperando2 + " = " + resultado;
                                break;
                            case 3:
                                resultado = Double.parseDouble(strOperando1) * Double.parseDouble(strOperando2);
                                mostrar = strOperando1 + " * " + strOperando2 + " = " + resultado;
                                break;
                            case 4:
                                resultado = Double.parseDouble(strOperando1) / Double.parseDouble(strOperando2);
                                mostrar = strOperando1 + " / " + strOperando2 + " = " + resultado;
                                break;
                            default:
                                mostrar = "Operacion no válida";
                                break;
                        }
                        out.print(mostrar + "<br/>");
                    }

                }
            }
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

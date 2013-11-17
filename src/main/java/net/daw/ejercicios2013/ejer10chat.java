package net.daw.ejercicios2013;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author rafa
 */
public class ejer10chat extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    ArrayList<String> alMensajes = new ArrayList<String>();

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        String initial = "<i>" + config.getInitParameter("mensajes") + "</i>";
        alMensajes.add("Bienvenido/a. Este es el ausiasChat de DAW.");

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession oSession = request.getSession();
        if ("login".equals(request.getParameter("do"))) {
            if (request.getParameter("user") != null && !request.getParameter("user").equals("")) {
                oSession.setAttribute("user", request.getParameter("user"));

                request.setAttribute("mensajes", alMensajes);

                RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/chat.jsp");
                reqDispatcher.forward(request, response);
            } else {
                request.setAttribute("requestBoolIntentoFallido", true);
                RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/chatintro.jsp");
                reqDispatcher.forward(request, response);
            }
        } else {
            if (oSession.getAttribute("user") != null && !oSession.getAttribute("user").equals("")) {
                if (request.getParameter("mensaje") != null && !request.getParameter("mensaje").equals("")) {
                    alMensajes.add(oSession.getAttribute("user") + ": " + request.getParameter("mensaje"));
                }
                request.setAttribute("mensajes", alMensajes);
                RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/chat.jsp");
                reqDispatcher.forward(request, response);
            } else {
                //request.setAttribute("requestBoolIntentoFallido", true);
                RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/chatintro.jsp");
                reqDispatcher.forward(request, response);
            }

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

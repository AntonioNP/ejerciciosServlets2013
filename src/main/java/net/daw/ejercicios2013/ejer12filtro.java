package net.daw.ejercicios2013;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.daw.entidades.LoginBean;

/**
 * Servlet de control para el programa de autenticación
 *
 * @author rafael aznar
 */
public class ejer12filtro extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
        String strAction = request.getParameter("do");
        if (strAction != null && strAction.equalsIgnoreCase("login")) {
            String strUserId = request.getParameter("user");
            String strPassword = request.getParameter("password");
            LoginBean oLoginBean = new LoginBean();
            oLoginBean.setUser(strUserId);
            oLoginBean.setPass(strPassword);
            if (oLoginBean.autenticado()) {
                HttpSession oSession = request.getSession();
                oSession.setAttribute("sessionBeanUsuario", oLoginBean);
                ServletContext oServletContext = request.getServletContext();
                RequestDispatcher oRequestDispatcher = oServletContext.getRequestDispatcher("/ejer12/bienvenido.jsp");
                oRequestDispatcher.forward(request, response);
            } else {
                request.setAttribute("requestBoolIntentoFallido", true);
                ServletContext oServletContext = request.getServletContext();
                RequestDispatcher oRequestDispatcher = oServletContext.getRequestDispatcher("/ejer12/index.jsp");
                oRequestDispatcher.forward(request, response);
            }
        }
        if (strAction != null && strAction.equalsIgnoreCase("logout")) {
            HttpSession Session = request.getSession();
            request.setAttribute("requestBeanUsuario", Session.getAttribute("sessionBeanUsuario"));
            Session.invalidate();
            ServletContext oServletContext = request.getServletContext();
            RequestDispatcher oRequestDispatcher = oServletContext.getRequestDispatcher("/ejer12/salida.jsp");
            oRequestDispatcher.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Autenticación";
    }
}

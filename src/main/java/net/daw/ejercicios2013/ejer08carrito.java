package net.daw.ejercicios2013;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.daw.entidades.AlmacenBean;
import net.daw.entidades.LoginBean;
import net.daw.entidades.carritoBean;
import net.daw.entidades.productoBean;

/**
 * Servlet de control para el programa de autenticación
 *
 * @author rafael aznar
 */
public class ejer08carrito extends HttpServlet {

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

                AlmacenBean oAlmacen = new AlmacenBean();

                productoBean prod1 = new productoBean();
                productoBean prod2 = new productoBean();
                productoBean prod3 = new productoBean();
                productoBean prod4 = new productoBean();
                productoBean prod5 = new productoBean();

                prod1.setNombre("bolsa de pipas");
                prod2.setNombre("jaula de loro");
                prod3.setNombre("televisor de plasma");
                prod4.setNombre("cocherito lere");
                prod5.setNombre("alfombra voladora");

                oAlmacen.addArticulo(prod1, 5);
                oAlmacen.addArticulo(prod2, 5);
                oAlmacen.addArticulo(prod3, 5);
                oAlmacen.addArticulo(prod4, 5);
                oAlmacen.addArticulo(prod5, 5);

                oSession.setAttribute("almacen", oAlmacen);

                carritoBean oCarrito = new carritoBean();

                oCarrito.addArticulo(prod1, 0);
                oCarrito.addArticulo(prod2, 0);
                oCarrito.addArticulo(prod3, 0);
                oCarrito.addArticulo(prod4, 0);
                oCarrito.addArticulo(prod5, 0);

                oSession.setAttribute("carrito", oCarrito);

                ServletContext oServletContext = request.getServletContext();
                RequestDispatcher oRequestDispatcher = oServletContext.getRequestDispatcher("/ejer08/bienvenido.jsp");
                oRequestDispatcher.forward(request, response);
            } else {
                request.setAttribute("requestBoolIntentoFallido", true);
                ServletContext oServletContext = request.getServletContext();
                RequestDispatcher oRequestDispatcher = oServletContext.getRequestDispatcher("/ejer08/index.jsp");
                oRequestDispatcher.forward(request, response);
            }
        }
        if (strAction != null && strAction.equalsIgnoreCase("logout")) {
            HttpSession Session = request.getSession();
            request.setAttribute("requestBeanUsuario", Session.getAttribute("sessionBeanUsuario"));
            Session.invalidate();
            ServletContext oServletContext = request.getServletContext();
            RequestDispatcher oRequestDispatcher = oServletContext.getRequestDispatcher("/ejer08/salida.jsp");
            oRequestDispatcher.forward(request, response);
        }
        if (strAction != null && strAction.equalsIgnoreCase("buy")) {

            if (request.getParameter("producto") != null
                    && request.getParameter("cantidad") != null
                    && request.getParameter("producto").equals("")
                    && request.getParameter("cantidad").equals("")) {
                response.sendRedirect("ejer08/privada01.jsp");
            } else {

                HttpSession oSession = request.getSession();

                AlmacenBean oAlmacen = (AlmacenBean) oSession.getAttribute("almacen");

                String strProducto = request.getParameter("producto");
                Integer intCantidadComprada = Integer.parseInt(request.getParameter("cantidad"));

                Iterator itAlmacen = oAlmacen.getArticulos().entrySet().iterator();
                while (itAlmacen.hasNext()) {
                    Map.Entry e = (Map.Entry) itAlmacen.next();
                    productoBean oProductoBean = (productoBean) e.getKey();
                    if (oProductoBean.getNombre().equals(strProducto)) {
                        Integer intExistencias = (Integer) e.getValue();
                        if ((intExistencias - intCantidadComprada) >= 0) {
                            e.setValue(intExistencias - intCantidadComprada);
                            carritoBean oCarrito = (carritoBean) oSession.getAttribute("carrito");
                            Iterator itCarrito = oCarrito.getArticulos().entrySet().iterator();
                            while (itCarrito.hasNext()) {
                                Map.Entry e2 = (Map.Entry) itCarrito.next();
                                productoBean oProductoBean2 = (productoBean) e2.getKey();
                                if (oProductoBean2.getNombre().equals(strProducto)) {
                                    Integer intCompras = (Integer) e2.getValue();
                                    e2.setValue(intCompras + intCantidadComprada);
                                }
                            }
                        } else {
                            oSession.setAttribute("mensaje", "No puedes comprar más de " + intExistencias.toString() + " unidades de este producto. La compra no fué procesada.");
                        }
                    }
                }
                response.sendRedirect("ejer08/privada01.jsp");
            }
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

<%--
    Document   : privada01
    Created on : Oct 15, 2013, 8:12:34 PM
    Author     : rafael aznar
--%>

<%@page import="net.daw.entidades.carritoBean"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Iterator"%>
<%@page import="net.daw.entidades.productoBean"%>
<%@page import="net.daw.entidades.AlmacenBean"%>
<%@page import="net.daw.entidades.LoginBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->

<html class="no-js">
    <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>Login</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width">
        <link rel="stylesheet" href="../css/bootstrap.min.css">
        <link rel="stylesheet" href="../css/bootstrap-responsive.min.css">
        <link rel="stylesheet" href="../css/main.css">
    </head>
    <body>
        <%
            LoginBean oUsuario = (LoginBean) request.getSession().getAttribute("sessionBeanUsuario");
            if (oUsuario != null && oUsuario.autenticado()) {
        %>
        <div class="container-fluid">
            <div class="row-fluid">
                <div class="span12">
                    <h1>Zona privada</h1>
                    <h2>Página 02 de la zona privada</h2>
                </div>
            </div>
        </div>
        <div class="container-fluid">
            <div class="row-fluid">
        
                    <%
                        HttpSession oSession = request.getSession();
                      
                        carritoBean oCarrito = (carritoBean) oSession.getAttribute("carrito");                

                    %>
       
              
                <div class="span4">
                    <h3>Estas son tus compras...</h3>
                    <%
                        out.println("<table class=\"table table-condensed\">");
                        Iterator it3 = oCarrito.getArticulos().entrySet().iterator();
                        while (it3.hasNext()) {
                            Map.Entry e = (Map.Entry) it3.next();
                            productoBean oProductoBean = (productoBean) e.getKey();
                            out.println("<tr><td>" + oProductoBean.getNombre() + "</td><td>" + e.getValue() + "</td></tr>");
                        }
                        out.println("</table>");
                    %>
                </div>
            </div>
            <div class="row-fluid">
                <div class="span12">
                    <p><a class="btn btn-large btn-primary" type="button" href="privada01.jsp">Seguir comprando</a></p>
                    <p><a class="btn btn-danger" href="../ejer08carrito?do=logout">Salir</a></p>
                    <hr/>
                    <footer><p>&copy; Rafael Aznar (2013)</p></footer>
                </div>   
            </div>
        </div>




        <%        } else {
        %>
        <p>No puedes acceder al área privada sin autenticarte.</p>
        <p><a href="index.jsp">Ir al formulario de entrada</a></p>
        <%
            }
        %>
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>        
        <script src="../js/vendor/modernizr-2.6.1-respond-1.1.0.min.js"></script>
        <script src="../js/vendor/bootstrap-transition.js"></script>
        <script src="../js/vendor/bootstrap-alert.js"></script>
        <script src="../js/vendor/bootstrap-modal.js"></script>
        <script src="../js/vendor/bootstrap-dropdown.js"></script>
        <script src="../js/vendor/bootstrap-scrollspy.js"></script>
        <script src="../js/vendor/bootstrap-tab.js"></script>
        <script src="../js/vendor/bootstrap-tooltip.js"></script>
        <script src="../js/vendor/bootstrap-popover.js"></script>
        <script src="../js/vendor/bootstrap-button.js"></script>
        <script src="../js/vendor/bootstrap-collapse.js"></script>
        <script src="../js/vendor/bootstrap-carousel.js"></script>
        <script src="../js/vendor/bootstrap-typeahead.js"></script>        
        <script src="../js/main.js"></script>
    </body>
</html>

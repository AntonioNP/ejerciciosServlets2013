<%-- 
    Document   : privada01
    Created on : Oct 15, 2013, 8:12:34 PM
    Author     : rafael aznar
--%>

<%@page import="net.daw.entidades.LoginBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
                <link rel="stylesheet" type="text/css" href="css/forms.css"/>
    </head>
    <body>
        <%
            LoginBean oUsuario = (LoginBean) request.getSession().getAttribute("sessionBeanUsuario");
            if (oUsuario != null && oUsuario.autenticado()) {
        %>                                                    
        <h1>Zona privada</h1>
        <h2>Página 02 de la zona privada</h2>
        <p><a href="privada01.jsp">Ir a la primera página privada</a></p>
        <p><a href="../ejer07login?do=logout">Salir</a></p>
        <%
        } else {
        %>
        <p>No puedes acceder al área privada sin autenticarte.</p>
        <p><a href="index.jsp">Ir al formulario de entrada</a></p>
        <%
            }
        %>         
    </body>
</html>
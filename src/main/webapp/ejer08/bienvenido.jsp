<%-- 
    Document   : bienvenido
    Created on : Oct 15, 2013, 7:01:43 PM
    Author     : rafael aznar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="net.daw.entidades.LoginBean"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
                <link rel="stylesheet" type="text/css" href="css/forms.css"/>
    </head>
    <body>
        <%LoginBean oUsuario = (LoginBean) request.getSession().getAttribute("sessionBeanUsuario");
            if (oUsuario != null)
                if (oUsuario.autenticado()) {%>                                                    
        <h1>Bienvenido <%=oUsuario.getUser()%></h1>
        <p><a href="ejer08/privada01.jsp">Acceder a la zona privada</a></p>
        <% } else {%>
        <p>No puedes acceder al área privada sin autenticarte.</p>
        <p><a href="ejer08/index.jsp">Ir al formulario de entrada</a></p>
        <% }%>        
    </body>
</html>

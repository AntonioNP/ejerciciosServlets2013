<%-- 
    Document   : contadorSession
    Created on : Nov 15, 2013, 5:58:47 PM
    Author     : rafa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession sesion = request.getSession();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Contador de visitas a nivel de sesión</h1>
        <p>Número de visitas en esta sesión: <%=sesion.getAttribute("contador")%></p>
    </body>
</html>

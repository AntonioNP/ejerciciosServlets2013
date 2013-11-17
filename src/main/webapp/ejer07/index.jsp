<%-- 
    Document   : index
    Created on : Oct 15, 2013, 6:00:00 PM
    Author     : rafael aznar
--%>

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
        <div class="container-fluid">
            <div class="row-fluid">
                <div class="span12">
                    <form  class="form-horizontal"  action="../ejer07login" method="post">
                        <h1>Formulario de entrada al sistema</h1> 
                        <br />
                        <input type="hidden" name="do" value="login">     
                        <div class="control-group">
                            <label class="control-label" for="user">Usuario:</label>
                            <div class="controls">
                                <input type="text" id="text" autofocus="autofocus" placeholder="Nombre de usuario" name="user">
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="inputPassword">Password:</label>
                            <div class="controls">
                                <input type="password" id="inputPassword" placeholder="Password" name="password">
                            </div>
                        </div>
                        <div class="control-group">
                            <div class="controls">
                                <button type="submit" class="btn">Entrar</button>
                            </div>
                        </div>
                    </form>
                    <%
                        Boolean bIntentoFallido = (Boolean) request.getAttribute("requestBoolIntentoFallido");
                        if (bIntentoFallido != null)
                            if (bIntentoFallido) {
                    %>
                    <h2>Login o password incorrectos. Por favor, inténtalo otra vez.</h2>
                    <% }%>


                </div>
            </div>
            <div class="row-fluid">
                <div class="span12"><hr><footer><p>&copy; Rafael Aznar (2013)</p></footer></div>   
            </div>
        </div>
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




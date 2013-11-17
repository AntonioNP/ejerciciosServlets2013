
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String meta;
    //si no se ha recibido ninguna visita, redireccionaremos la página automáticamente al servlet
    if (request.getAttribute("mensajes") == null) {
        meta = "<meta http-equiv=\"REFRESH\" content=\"0;url=./Chat\">";
    } else {
        meta = "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">";
    }

    String strListaMensajes = "";
    ArrayList<String> alListaMensajes = (ArrayList<String>) request.getAttribute("mensajes");
    Iterator it = alListaMensajes.iterator();
    while (it.hasNext()) {
        String v = (String) it.next();
        strListaMensajes += v + "<br/>";
    }
    HttpSession oSession = request.getSession();

%>
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
        <%=meta%>
        <title>ausiasChat</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap-responsive.min.css">
        <link rel="stylesheet" href="css/main.css">
    </head>
    <body>
        <div class="container-fluid">
            <div class="row-fluid">
                <div class="span8">
                    <h1>Chat Asíncrono</h1>
                    <h2>Usuario: <%=oSession.getAttribute("user")%></h2>
                    <p>
                        <%=strListaMensajes%>
                    </p>
                </div>
                <div class="span4">
                    <form action="ejer10chat" method="post" accept-charset="ISO-8859-1">
                        <p>
                            Mensaje: <textarea name="mensaje"></textarea>
                        </p>
                        <p>
                            <input type="submit" value="Enviar" />
                        </p>
                    </form>
                </div>

            </div>
            <div class="row-fluid">
                <div class="span12"><hr><footer><p>&copy; Rafael Aznar (2013)</p></footer></div>   
            </div>
        </div>
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>        
        <script src="js/vendor/modernizr-2.6.1-respond-1.1.0.min.js"></script>
        <script src="js/vendor/bootstrap-transition.js"></script>
        <script src="js/vendor/bootstrap-alert.js"></script>
        <script src="js/vendor/bootstrap-modal.js"></script>
        <script src="js/vendor/bootstrap-dropdown.js"></script>
        <script src="js/vendor/bootstrap-scrollspy.js"></script>
        <script src="js/vendor/bootstrap-tab.js"></script>
        <script src="js/vendor/bootstrap-tooltip.js"></script>
        <script src="js/vendor/bootstrap-popover.js"></script>
        <script src="js/vendor/bootstrap-button.js"></script>
        <script src="js/vendor/bootstrap-collapse.js"></script>
        <script src="js/vendor/bootstrap-carousel.js"></script>
        <script src="js/vendor/bootstrap-typeahead.js"></script>        
        <script src="js/main.js"></script>
    </body>
</html>
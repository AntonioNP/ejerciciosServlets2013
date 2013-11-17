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
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap-responsive.min.css">
        <link rel="stylesheet" href="css/main.css">
        <script>

            function test(num) {
                var expresionRegular = /^\d+$/;
                if (expresionRegular.test(num)) {
                    return true;
                } else {
                    return false;
                }

            }

            function validar(evento) {
                var valida = true;
                var intRegex = /^\d+$/;
                var op1=document.getElementById("ope1");
                var op2=document.getElementById("ope2");
                document.getElementById("errorop1").innerHTML = "";
                document.getElementById("errorop2").innerHTML = "";
                if (!test(op1.value)) {
                    document.getElementById("errorop1").innerHTML = "error de validación en el primer operando";
                    valida = false;
                }
                if (!test(op2.value)) {
                    document.getElementById("errorop2").innerHTML = "error de validación en el segundo operando";
                    valida = false;
                }
                if (!valida)
                    evento.preventDefault();

            }

            function inicio() {
                var calcform = document.getElementById('formcalc');
                calcform.addEventListener('submit', validar, false);
            }

            window.onload = inicio;

        </script>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row-fluid">
                <div class="span12">
                    <h1>Calculadora</h1>
                    <form class="form-horizontal" id="formcalc" name='formcalc' action='ejer03Calculadora'>
                        <div>
                            <label>Primer operando: </label> 
                            <input type="text" name = 'ope1' id="ope1" required=""/><label id="errorop1"></label> 
                            <label>Operación: </label> 
                            <select name="oper"> 
                                <option value="1">Suma</option>
                                <option value="2">Resta</option>
                                <option value="3">Multiplicación</option>
                                <option value="4">División</option> 
                            </select>                
                            <label>Segundo operando: </label> 
                            <input type="text" name = 'ope2' id="ope2" required=""/><label id="errorop2"></label> 
                            <input id="enviar" type='submit' value='Enviar'/>
                        </div>
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

<%-- 
    Document   : borrar
    Created on : 06-15-2020, 08:37:59 PM
    Author     : W. Hernandez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="../bootstrap-337/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <%@include file = "../WEB-INF/Vistas-Parciales/css-js.jspf" %>
    </head>
    <body>
        
        <%@include file = "../WEB-INF/Vistas-Parciales/encabezado.jspf" %>
        
     <div class="container">
         <div class="row justify-content-center">
            <div class="col-lg-10 col-md-6 col-sm-4">
           <h1 class="alert-danger">Registro Borrado exitosamente!</h1>
           </div>
         </div>
     </div>
        <%@include file = "../WEB-INF/Vistas-Parciales/pie.jspf" %>
    </body>
</html>

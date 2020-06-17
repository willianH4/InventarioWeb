<%-- 
    Document   : Editar
    Created on : 06-15-2020, 05:54:23 PM
    Author     : W. Hernandez
--%>

<%@page import="Model.Categoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-----Para importar los datos de la clase Categoria-
----->
<jsp:useBean id="categoria" scope="session" class="Model.Categoria"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file = "../WEB-INF/Vistas-Parciales/css-js.jspf" %>
    </head>
    <body>
         <%@include file = "../WEB-INF/Vistas-Parciales/encabezado.jspf" %>
        
         <%
             Categoria cat = new Categoria();
            //int id_cat = (int) request.getAttribute("id_categoria");
            String nombre = (String) request.getAttribute("nomCategoria");
            //int estado = (int) request.getAttribute("estCategoria");
            //int id_mod = (int) request.getAttribute("id_modificar");
       
        %>

 <div class="container">
    <div class="row">
       <div class="col-lg-5 col-md-7 col-sm-4">
        <h1 class="alert-info">Modificar registro</h1>
        <form>
            <div class="form-horizontal" id="frmCategoria" name="frmCategoria" action="editar" method="post">
                <input type="hidden" name="id_categoria" value="<%= cat.getId_categoria() %>">
                <div class="form-group">
                    <label for="txtNomCategoria" class="col-sm-2 control-label">Nombre: </label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="txtNomCategoria" value="<%= nombre %>">
                    </div>
                </div>
                <div class="form-group">
                    <label for="txtEstadoCategoria" class="col-sm-2 control-label">Estado: </label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="txtEstadoCategoria" value="<%= cat.getEstado_categoria() %>">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <input type="submit" class="btn btn-success btn-sm" name="btnGuardar" value="Actualizar"/>
                        <input type="submit" class="btn btn-danger btn-sm" onclick="regresar('<%= request.getContextPath() %>/categorias?opcion=listar')"
                               name="btnRegresar" value="Regresar"/>
                </div>
             </div>
            </form>
         </div>
       </div>
    </div>
 </div>
                               
        <%@include file = "../WEB-INF/Vistas-Parciales/pie.jspf" %>
    </body>
</html>

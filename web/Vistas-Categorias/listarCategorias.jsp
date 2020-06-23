<%-- 
    Document   : listarCategorias
    Created on : 06-11-2020, 01:20:50 PM
    Author     : W. Hernandez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import = "Model.Categoria" %> <!----Importar el modelo------>
<!-----El id debe ser el mismo que se le coloco de nombre a la sesion en el controlador----->
<jsp:useBean id = "lista" scope="session" class="java.util.List"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Control de inventario</title>
        <%@include file = "../WEB-INF/Vistas-Parciales/css-js.jspf" %>  
    </head>
    <body>
        <%@include file = "../WEB-INF/Vistas-Parciales/encabezado.jspf" %>  
        
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-9 col-md-6 col-sm-3">
                    <div style="">
            <a href="<%= request.getContextPath() %>/categorias?opcion=crear" class="btn bg-success btn-sm glyphicon glyphicon-pencil" role="button"> Nueva Categoria</a>
            
            <h3>Listado de Categorias Registradas</h3>
        <table class="table table-striped table-hover">
            <tr>
                <th>ID</th><th>Nombre</th><th>Estado</th><th>Acción</th>
            </tr>
            <%
                for (int i = 0; i < lista.size(); i++) {
                        Categoria categoria = new Categoria();
                        categoria = (Categoria)lista.get(i); //(Categoria) es para el casting
                    
            %>
            <tr>
                <td><%= categoria.getId_categoria()%></td>
                <td><%= categoria.getNom_categoria()%></td>
                <td><%= categoria.getEstado_categoria()%></td>
                <td>
                    <a href="<%= request.getContextPath() %>/editar?opcion=modificar&&id_cat=<%= categoria.getId_categoria() %>&&nombre_cat=<%= categoria.getNom_categoria() %>&&estado_cat=<%= categoria.getEstado_categoria() %>" class="btn btn-primary btn-sm glyphicon glyphicon-edit" role="button"> Editar</a>
                    <a href="eliminar?id_categoria=<%= categoria.getId_categoria()%>" class="btn btn-danger btn-sm glyphicon glyphicon-remove" role="button"> Eliminar</a>
                </td>
            </tr>
            <%
                }
            %>
        </table>
        
        <!------- Formulario para generar reporte en PDF de los registros de la base de datos ----------->
        <!-------Parte de la investigacion de como realizar un reporte en pdf desde la base de datos ------->
        <!-------Para este proceso importamos la libreria itextpdf-5.5.9 para generar el documento ---------->
        <!-------Usamos un servlet para pasar los parametros con los cuales se generara el archivo -------->
        <form name="reporte" action="../InventarioWeb/Pdf">
            <input type="submit" class="btn btn-primary btn-sm glyphicon glyphicon-book" value=" Generar PDF" name="btnver"> 
        </form>
        
            </div>
        </div>
    </div>
 </div>
        
       
        <br>
        <%@include file = "../WEB-INF/Vistas-Parciales/pie.jspf" %>  
    </body>
</html>

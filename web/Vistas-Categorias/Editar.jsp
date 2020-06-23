<%-- 
    Document   : Editar
    Created on : 06-15-2020, 05:54:23 PM
    Author     : W. Hernandez
--%>
<%@page import="DAO.CategoriaDAOImplementar"%>
<%@page import="DAO.CategoriaDAO"%>
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
              String id = (String)request.getParameter("id_cat");
              String nombre = (String)request.getParameter("nombre_cat");
        %> 

 <div class="container">
    <div class="row">
       <div class="col-lg-5 col-md-7 col-sm-4">
           
           <h3 class="alert-success">Modificar Registros</h3>
            
            <form class="form-horizontal" id="frmCategoria" name="frmCategoria" action="editar" method="POST">
                <input type="hidden" name="txtid" value="<%= id%>">
               <div class="form-group">
                   <label for="txtNomCategoria" class="col-sm-2 control-label">Nombre: </label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="txtnombre" value="<%= nombre%>">
                </div>
              </div>
                <div class="form-group">
                    <label for="txtEstadoCategoria" class="col-sm-2 control-label">Estado: </label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="txtestado" value="<%= categoria.getEstado_categoria()%>">
                    </div>
                </div>
              <div class="form-group">
                   <div class="col-sm-offset-2 col-sm-10">
                    <input type="submit" class="btn btn-success btn-sm" name="accion" value="Actualizar"/>
                    </div>
                 </div>
            </form>
                     
           </div>
         </div>
    </div>
    
                               
        <%@include file = "../WEB-INF/Vistas-Parciales/pie.jspf" %>
    </body>
</html>

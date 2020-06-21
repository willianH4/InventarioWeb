
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-----Para importar los datos de la clase Categoria------>
<jsp:useBean id="categoria" scope="session" class="Model.Categoria"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Control de inventario</title>
        <%@include file = "../WEB-INF/Vistas-Parciales/css-js.jspf" %>
        
        <script type="text/javascript">
            function regresar(url){ //Funcion para el boton regresar
                location.href = url;
            }
        </script>
        
    </head>
    <body>
        <%@include file = "../WEB-INF/Vistas-Parciales/encabezado.jspf" %>
        
 <div class="container">
    <div class="row">
       <div class="col-lg-5 col-md-7 col-sm-4">
           
           <h3 class="alert-success">Mantenimiento Categorias</h3>
            
            <form class="form-horizontal" id="frmCategoria" name="frmCategoria" action="<%= request.getContextPath() %>/categorias" method="POST">
               <input type="hidden" name="idcategoria" value="<%= categoria.getId_categoria() %>">
               <div class="form-group">
                   <label for="txtNomCategoria" class="col-sm-2 control-label">Nombre: </label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="txtnombre" value="<%= categoria.getNom_categoria() %>" required="">
                </div>
              </div>
                <div class="form-group">
                    <label for="txtEstadoCategoria" class="col-sm-2 control-label">Estado: </label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="txtestado" value="<%= categoria.getEstado_categoria()%>" required="">
                    </div>
                </div>
              <div class="form-group">
                   <div class="col-sm-offset-2 col-sm-10">
                    <input type="submit" class="btn btn-success btn-sm" name="btnGuardar" value="Guardar"/>
                    <input type="submit" class="btn btn-danger btn-sm" onclick="regresar('<%= request.getContextPath() %>/categorias?opcion=listar')"
                     name="btnRegresar" value="Regresar"/>
                    </div>
                 </div>
            </form>
                     
           </div>
         </div>
    </div>
    
                        
                    <%@include file = "../WEB-INF/Vistas-Parciales/pie.jspf" %>
    </body>
</html>

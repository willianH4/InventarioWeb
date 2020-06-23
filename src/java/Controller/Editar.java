
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.CategoriaDAOImplementar;
import DAO.CategoriaDAO;
import Model.Categoria;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;


/**
 *
 * @author W. Hernandez
 */

public class Editar extends HttpServlet {
    
    
    protected void listaCategorias(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        //Crear instancia a CategoriaDAO
        CategoriaDAO categoria = new CategoriaDAOImplementar();
        //Crear instancia de sesión; se le da true para crear la sesión.
        HttpSession session = request.getSession(true);
        session.setAttribute("lista", categoria.Listar()); //lista es el nombre de la variable de sesión.
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Vistas-Categorias/listarCategorias.jsp");
        dispatcher.forward(request, response);
        //response.sendRedirect("/index.jsp");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       //Se captura el parámetro que se esta enviando.
        String parametro = request.getParameter("opcion");
        if(parametro.equals("modificar")){
            //Se efectua el casting o conversión de datos porque lo ingresado en el formulario es texto.
            int id_categoria = Integer.parseInt(request.getParameter("id_cat"));
            String nom_categoria = request.getParameter("nombre_cat");
            int estado_categoria = Integer.parseInt(request.getParameter("estado_cat"));
            
            String pagina = "/Vistas-Categorias/Editar.jsp?id_c="+id_categoria+"&&nombre_c="+nom_categoria+"&&estado_c="+estado_categoria+"&&senal=1";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
            dispatcher.forward(request, response);
            
        }
    }
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Categoria categoria = new Categoria();
        //Se efectua el casting o conversión de datos porque lo ingresado en el formulario es texto.
        int id_categoria = Integer.parseInt(request.getParameter("txtid"));
        String nom_categoria = request.getParameter("txtnombre");
        int estado_categoria = Integer.parseInt(request.getParameter("txtestado"));
        
        categoria.setId_categoria(id_categoria);
        categoria.setNom_categoria(nom_categoria);
        categoria.setEstado_categoria(estado_categoria);
        
        CategoriaDAO guardarCategoria = new CategoriaDAOImplementar();
        guardarCategoria.guardarCat(categoria);
        
        this.listaCategorias(request, response);
            
     }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

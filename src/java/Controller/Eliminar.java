
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.CategoriaDAO;
import DAO.CategoriaDAOImplementar;
import Model.Categoria;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;


/**
 *
 * @author W. Hernandez
 */
public class Eliminar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }
    //Metodo para listar
    protected void listaCategorias(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        //Crear instancia de CategoriaDAO
        CategoriaDAO categoria = new CategoriaDAOImplementar();
        //Crear instancia de session; se le da true para crear la sesion
        HttpSession sesion = request.getSession(true);
        sesion.setAttribute("lista", categoria.Listar()); //Lista es el nombre de la sesion
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Vistas-Categorias/listarCategorias.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        //Metodo para la Eliminacion de datos
        int id_cat_edit = (Integer.parseInt(request.getParameter("id_categoria"))); //id de URL
        CategoriaDAO categoria = new CategoriaDAOImplementar();
        Categoria cat;
        cat = (Categoria) categoria.editarCat(id_cat_edit);
        cat.setId_categoria(id_cat_edit);
        categoria.borrarCat(id_cat_edit);  //Llamado del metodo para borrar
        this.listaCategorias(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

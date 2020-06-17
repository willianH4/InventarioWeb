
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


/**
 *
 * @author W. Hernandez
 */
public class Eliminar extends HttpServlet {

    String listar="/Vistas-Categorias/listarCategorias.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
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
        
        if (categoria.borrarCat(id_cat_edit)){
            request.getRequestDispatcher("/Vistas-Categorias/borrar.jsp").forward(request, response);
        }else{
            request.getRequestDispatcher("/Vistas-Categorias/index.jsp").forward(request, response);
        }  
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

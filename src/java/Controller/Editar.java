
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

/**
 *
 * @author W. Hernandez
 */
public class Editar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        
        System.out.println("listar");
        int id_cat_edit = (Integer.parseInt(request.getParameter("id_categoria"))); //id de URL
        System.out.println("El id a modificar es: "+ id_cat_edit);
        CategoriaDAO categoria = new CategoriaDAOImplementar();
        categoria.editarCat(id_cat_edit);
        
        Categoria cat = new Categoria();
        // Creo las variables para la vista
        request.setAttribute("id_categoria", cat.getId_categoria());
        request.setAttribute("nomCategoria", cat.getNom_categoria());
        request.setAttribute("estCategoria", cat.getEstado_categoria());
        request.setAttribute("id_modificar", id_cat_edit);
        String pagina = "/Vistas-Categorias/Editar.jsp";
        //request.getRequestDispatcher("/Vistas-Categorias/Editar.jsp").forward(request, response);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id_mod = (Integer.parseInt(request.getParameter("id_mod")));
        String accion = request.getParameter("accion");
        if(accion == null){accion = "nada";}
        if(accion.equalsIgnoreCase("actualizar")){
        // Captura los datos de la vista editar
        int id = (Integer.parseInt(request.getParameter("id_categoria")));
        String nombre = request.getParameter("txtNomCategoria");
        int estado = (Integer.parseInt(request.getParameter("txtEstadoCategoria")));
        
            Categoria cat = new Categoria();
            cat.setId_categoria(id);
            cat.setNom_categoria(nombre);
            cat.setEstado_categoria(estado);
            
            CategoriaDAO categoria = new CategoriaDAOImplementar();

            if (categoria.guardarCat(cat) == true ) {                    
                    request.getRequestDispatcher("categorias").forward(request, response);
                } else {
                    request.getRequestDispatcher("index").forward(request, response);
                }
        
        }
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

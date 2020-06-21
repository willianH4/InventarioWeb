
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
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String parametro = request.getParameter("opcion"); //Capturar el parametro que se esta enviando
        if (parametro.equals("editar")) { //Evaluar si el parametro es crear o listar o cualquier otro
            String pagina = "/Vistas-Categorias/Editar.jsp"; //Vista o formulario para registrar una nueva categoria
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
            dispatcher.forward(request, response);
        } 
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    // processRequest(request, response); 
        }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

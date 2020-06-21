
package Controller;

import DAO.CategoriaDAO;
import DAO.CategoriaDAOImplementar;
import Model.Categoria;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Categorias", urlPatterns = {"/categorias"})
public class Categorias extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            // TODO output your page here. You may use following sample code. 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Categorias</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Categorias at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } 
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String parametro = request.getParameter("opcion"); //Capturar el parametro que se esta enviando
        if (parametro.equals("crear")) { //Evaluar si el parametro es crear o listar o cualquier otro
            String pagina = "/Vistas-Categorias/crearCategoria.jsp"; //Vista o formulario para registrar una nueva categoria
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
            dispatcher.forward(request, response);
       }else{
            this.listaCategorias(request, response);
        }
    }
    
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Categoria categoria = new Categoria();
        //Se efectua el casting o conversion de datos porque lo ingresado en el formulario es texto
        categoria.setId_categoria(Integer.parseInt(request.getParameter("idcategoria")));
        categoria.setNom_categoria(request.getParameter("txtnombre"));
        categoria.setEstado_categoria(Integer.parseInt(request.getParameter("txtestado")));
        
        CategoriaDAO guardaCategoria = new CategoriaDAOImplementar();
        guardaCategoria.guardarCat(categoria);
        this.listaCategorias(request, response);
        //response.sendRedirect("/Vistas-Categorias/listarCategorias.jsp");
    }
}

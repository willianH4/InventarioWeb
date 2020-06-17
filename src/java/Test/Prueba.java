
package Test;

import DAO.CategoriaDAO;
import DAO.CategoriaDAOImplementar;
import Model.Categoria;
import java.util.List;

public class Prueba {
    public static void main(String[] args) {
        Prueba evaluar = new Prueba();
        evaluar.guardaCategoria();
        evaluar.listarCategorias();
        //evaluar.eliminarCategoria();
        //evaluar.listarCategorias();
    }
     
   public void listarCategorias(){
    CategoriaDAO categoria = new CategoriaDAOImplementar();
    List<Categoria> listar = categoria.Listar();
        System.out.println("Listado de categorias");
        for (Categoria categoriaListar : listar) {
            System.out.println("ID: "+categoriaListar.getId_categoria() +
                    " Nombre: " + categoriaListar.getNom_categoria() + 
                    " Estado: " + categoriaListar.getEstado_categoria());
        }
  } 
      public void guardaCategoria(){
         CategoriaDAO categoria = new CategoriaDAOImplementar();
         Categoria guarda_cat = new Categoria();
         guarda_cat.setNom_categoria("Bebidas"); //Nueva categoria
         guarda_cat.setEstado_categoria(1); //Estado 1
         categoria.guardarCat(guarda_cat);
     
     }
      
   /*   public void eliminarCategoria(){
          CategoriaDAO categoria = new CategoriaDAOImplementar();
          categoria.borrarCat(2); //Se eliminara la categoria con id_categoria = 2
      } */
}


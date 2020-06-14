
package DAO;

import Model.Categoria;
import java.util.List;

public interface CategoriaDAO {
/*
  Definir los metodos, como la clase en interface los metodos no se implementaran aqui
    , los metodos son de tipo abstractos
    */    
    
 public List<Categoria> Listar();
 public List<Categoria> Listar2();
 public Categoria editarCat(int id_cat_edit);
 public boolean guardarCat(Categoria categoria);
 public boolean borrarCat(int id_cat_borrar);
}

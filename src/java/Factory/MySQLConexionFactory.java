
package Factory;

import java.sql.Connection;
import java.sql.DriverManager;

public final class MySQLConexionFactory extends ConexionDB{

    public MySQLConexionFactory(String[] criterios) {
        this.parametros = criterios; //Pasa los criterios al array de la clase padre parametros
        this.open(); //Llamar el metodo open
    }
    
    @Override
    public Connection open() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //En this.parametros[] iran los datos respectivos de la BD, usuario y clave
            this.conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + this.parametros[0], this.parametros[1], this.parametros[2]);
        } catch (Exception ex) {
            ex.getStackTrace();
        }
        return this.conexion;
    }
    
}

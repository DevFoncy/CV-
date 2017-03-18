package app.proyecto.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author PC-TOSHIBA
 */
public class AccesoDB { 
    private Connection conexion; 
    
    public Connection getConexion() { 
        return conexion; 
    }    

    public void setConexion(Connection conexion) { 
        this.conexion = conexion; 
    }  

    public AccesoDB conectar(){ 
        try { 
            //Class.forName("oracle.jdbc.OracleDriver"); 
            //String BaseDeDatos = "jdbc:oracle:thin:@localhost:1521:ORCL"; 
            String url="jdbc:oracle:thin:@localhost:1521:oracle";
            String login="alumno1";
            String password="alumno1";
            conexion = DriverManager.getConnection(url,login,password);             
            if (conexion != null) { 
            JOptionPane.showMessageDialog(null,"Conexion establecida con exito a Oracle! ");    
            //System.out.println("Conexion exitosa!"); 
            }else{ 
            JOptionPane.showMessageDialog(null,"Conexion fallida! ");        
            //System.out.println("Conexion fallida!"); 
            } 
        } catch (Exception e) { 
            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage()); 
        }        return this; 
    } 

    public boolean Escribir(String sql) { 
        try { 
            Statement sentencia=null;
            sentencia = getConexion().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            sentencia.executeUpdate(sql); 
            getConexion().commit(); 
            sentencia.close(); 
             
        } catch (SQLException e) { 
            e.printStackTrace(); 
            System.out.print("ERROR SQL"); 
            return false; 
        }         
        return true; 
    } 
    public ResultSet Consultar(String sql) { 
        ResultSet r = null; 
        try { 
            Statement sentencia; 
            sentencia = getConexion().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            r = sentencia.executeQuery(sql); 
             
        } catch (SQLException e) { 
            e.printStackTrace(); 
            return null; 
        }        return r; 
    } 
    
}

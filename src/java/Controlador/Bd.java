/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alumno_2DAW
 */
public class Bd {
   private final static String drv = "com.mysql.jdbc.Driver";
   private final static String db = "jdbc:mysql://localhost:3306/usuarios?useSSL=false";
   private final static String user = "root";
   private Connection conn;
   private PreparedStatement pst;
   private ResultSet rs; 
   
   
   public void abrirConexion() throws ClassNotFoundException, SQLException{
    Class.forName(drv);
    conn = DriverManager.getConnection(db,user,"");
       System.out.println("La conexion se realizo con exito");
   }
   public void cerrarConexion() throws SQLException{
    if(pst != null)pst.close();
    if(rs !=null)pst.close();
       System.out.println("Conexion Cerrada");
    }
   public String[] encuentraUsuarios(){
       String[]usuarios=null;
       String sql = "SELECT * FROM usuarios";
       try {
           pst = conn.prepareStatement(sql);
           rs = pst.executeQuery();
           int cont = 0;
           while(rs.next()){
           cont++;
           }
           usuarios=new String[cont];
           cont = 0;
           rs.beforeFirst();
           while(rs.next()){
               
               usuarios[cont]= rs.getString(1);
               cont++;
           }
       } catch (SQLException ex) {
           Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       return usuarios;
   }
}

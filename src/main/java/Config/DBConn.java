/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author super
 */
public class DBConn {
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String host = "jdbc:mysql://localhost:3306/";
    
    private String url = "jdbc:mysql://localhost:3306/coc_final";
    
    public static Connection getConnection(String database, String userDB, String passwordDB){
        Connection conn = null;
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(host + database, userDB, passwordDB);
        }catch(SQLException err){
            System.out.println("SQL Error");
        }catch(ClassNotFoundException err){
            System.out.println("Clase no encontrada");
        }
        return conn;
    }
}

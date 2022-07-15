/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import Config.DBConn;
import Model.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author super
 */
public class ProductoDAO {
    private static final String query_Select_one = "SELECT * FROM productos WHERE id = ?";
    private static final String query_Select = "SELECT * FROM productos";
    private static final String query_Insert = "INSERT INTO productos(nombre, precio, tipo) VALUES (?,?,?);";
    private static final String query_Update = "UPDATE productos SET nombre=?, precio=?, tipo=? WHERE id = ?";
    private static final String query_Delete = "DELETE FROM productos WHERE id = ?";
    
    public static List<Producto> listar() throws SQLException{
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        Producto producto = null;
        List<Producto> productos = new ArrayList<Producto>();
        
        conn = DBConn.getConnection("coc_final", "root", "root");

        ps = conn.prepareStatement(query_Select);
        rs = ps.executeQuery();
        
        while(rs.next()){
            Producto p = new Producto();
            p.setId(rs.getInt("id"));
            p.setNombre(rs.getString("nombre"));
            p.setPrecio(rs.getInt("precio"));
            p.setTipo(rs.getString("tipo"));
            
            productos.add(p);
        }
        
        return productos;
    }
    
    public static List<Producto> listar(String ty, String or, String num) throws SQLException{
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String type = ty;
        String ord = or;
        String order = " ORDER BY " + type + " " + ord;
        
        String limitNum = num;
        String limit = " LIMIT " + limitNum;
        
        Producto producto = null;
        List<Producto> productos = new ArrayList<Producto>();
        
        conn = DBConn.getConnection("coc_final", "root", "root");

        ps = conn.prepareStatement(query_Select + order + limit);
        rs = ps.executeQuery();
        
        while(rs.next()){
            Producto p = new Producto();
            p.setId(rs.getInt("id"));
            p.setNombre(rs.getString("nombre"));
            p.setPrecio(rs.getInt("precio"));
            p.setTipo(rs.getString("tipo"));
            
            productos.add(p);
        }
        
        return productos;
    }
    
    public static Producto unique(int id) throws SQLException{
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Producto p = null;
        
        conn = DBConn.getConnection("coc_final", "root", "root");
        
        ps = conn.prepareStatement(query_Select_one);
        ps.setInt(1, id);
        rs = ps.executeQuery();
        
        while(rs.next()){
            p = new Producto();
            p.setId(rs.getInt("id"));
            p.setNombre(rs.getString("nombre"));
            p.setPrecio(rs.getInt("precio"));
            p.setTipo(rs.getString("tipo"));
        }
        
        return p;
    }
    
    public static int add(Producto p) throws SQLException{
        int status = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        
        conn = DBConn.getConnection("coc_final", "root", "root");
        
        ps = conn.prepareStatement(query_Insert);
        ps.setString(1, p.getNombre());
        ps.setInt(2, p.getPrecio());
        ps.setString(3, p.getTipo());
        status = ps.executeUpdate();
        
        return status;
    }
    
    public static int delete(int id) throws SQLException{
        int status = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        
        conn = DBConn.getConnection("coc_final", "root", "root");
        
        ps = conn.prepareStatement(query_Delete);
        ps.setInt(1, id);
        status = ps.executeUpdate();
        
        return status;
    }
    
    public static int update(Producto p, int id) throws SQLException{
        int status = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        
        conn = DBConn.getConnection("coc_final", "root", "root");
        
        ps = conn.prepareStatement(query_Update);
        ps.setString(1, p.getNombre());
        ps.setInt(2, p.getPrecio());
        ps.setString(3, p.getTipo());
        ps.setInt(4, id);
        status = ps.executeUpdate();

        return status;
    }
    
    
    
    
}

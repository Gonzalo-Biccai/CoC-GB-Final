/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

public class Producto {
    private int id;
    private String nombre;
    private int precio;
    private String tipo;
    
    public Producto(){
        this.id = 0;
        this.nombre = "";
        this.precio = 0;
        this.tipo = "";
    }
    
    public Producto(String name, int precio, String tipo){
        this.nombre = name;
        this.precio = precio;
        this.tipo = tipo;
    }
    
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}

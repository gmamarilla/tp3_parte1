/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Gustavo
 */
public class Biblioteca {
    private String nombre;
    private String direccion;
    private String telefono;
    ArrayList<Libro> libros;

    public Biblioteca(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        
        this.libros = new ArrayList();
    }
    
    public void crearLibro(String titulo, int edicion, Autor autor) throws Exception{
        Libro nuevoLibro = new Libro( titulo, edicion, autor);
        
        if(tieneLibro(nuevoLibro)){
            throw new Exception("El libro ya se encuentra cargado en el sistema.");
        }
        
        libros.add(nuevoLibro);
    }
    
    public Libro buscarLibro(String titulo){
        if(libros.isEmpty()){
            return null;
        }
        
        for(Libro libro:libros){
            if(libro.getTitulo().equalsIgnoreCase(titulo)){
                return libro;
            }
        }
        
        return null;
    }
    
    public void editarLibro(Libro libro, String titulo, int edicion) throws Exception{
        if(!tieneLibro(libro)){
            throw new Exception("No existe el libro en el sistema.");
        }
        
        libro.setTitulo(titulo);
        libro.setEdicion(edicion);
    }
    
    
    public void borrarLibro(Libro libro) throws Exception{
        if(!tieneLibro(libro)){
            throw new Exception("El libro "+libro.getTitulo()+" no está cargado en el sistema.");
        }
        
        libro.borrarTodosLosEjemplares();
        libros.remove(libro);
    }
    
    public boolean tieneLibro(Libro libro){
        if(libros.isEmpty()){
            return false;
        }
        
        return libros.contains(libro);
    }
    
    public void agregarEjemplar(Integer nroInventario, boolean sale, Libro libro) throws Exception{
        Ejemplar nuevoEjemplar = new Ejemplar( nroInventario, sale);
        
        if(libro.tieneEjemplar(nuevoEjemplar)){
            throw new Exception("El libro "+libro.getTitulo()+" ya posee dicho ejemplar.");
        }
        
        if(!tieneLibro(libro)){
            throw new Exception("El libro "+libro.getTitulo()+" no está cargado en el sistema.");
        }
        
        libro.agregarEjemplar(nuevoEjemplar);
    }
    
    /*
    public Autor crearAutor(String nombre) throws Exception{
        Autor nuevoAutor = new Autor( nombre);
        
        
        return autor;
    }
*/
    
    public void agregarAutor(Autor autor, Libro libro) throws Exception{
        if(libro.tieneAutor(autor)){
            throw new Exception("El libro ya tenía asignado ese autor.");
        }
        
        libro.agregarAutor(autor);
    }
    
    //setters

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    //getters

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }
}

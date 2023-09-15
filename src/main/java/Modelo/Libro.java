/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/**
 *
 * @author Gustavo
 */
public class Libro {
    private String titulo;
    private int edicion;
    
    private ArrayList<Autor> autores;
    private ArrayList<Ejemplar> ejemplares;
    
    public Libro(String titulo, int edicion, Autor autor) throws Exception {
        if(edicion<1900||edicion>2018){
            throw new Exception("La edición no puede ser menor a 1900 ni mayor a 2018.");
        }
        
        this.titulo = titulo;
        this.edicion = edicion;
        
        this.autores = new ArrayList();
        autores.add(autor);
        
        this.ejemplares = new ArrayList();
    }

    public Libro(String titulo, int edicion, ArrayList<Autor> autores) {
        this.titulo = titulo;
        this.edicion = edicion;
        this.autores = autores;
    }
    
    public void agregarAutor(Autor autor) throws Exception{
        if(tieneAutor(autor)){
            throw new Exception("El libro "+this.getTitulo()+" ya tiene agregado el autor "+autor.getNombre()+".");
        }
        
        autores.add(autor);
    }
    
    public boolean tieneAutor(Autor autor){
        if(autores.isEmpty()){
            return false;
        }
        
        return autores.contains(autor);
    }
    
    public boolean tieneAutores(){
        return !autores.isEmpty();
    }
    
    public void agregarEjemplar(Ejemplar ejemplar){
        ejemplares.add(ejemplar);
    }
    
    public void borrarEjemplar(Ejemplar ejemplar) throws Exception{
        if(!tieneEjemplar(ejemplar)){
            throw new Exception("El libro "+this.getTitulo()+" no tiene cargado el ejemplar "+ejemplar.getNroInventario()+".");
        }
        
        ejemplares.remove(ejemplar);
    }
    
    public void borrarTodosLosEjemplares() throws Exception{
        if(ejemplares.isEmpty()){
            throw new Exception("El libro "+this.getTitulo()+" no tiene ejemplares cargados.");
        }
        
        ejemplares.clear();
    }
    
    public boolean tieneEjemplar(Ejemplar ejemplar){
        if(ejemplares.isEmpty()){
            return false;
        }
        
        return ejemplares.contains(ejemplar);
    }
    
    @Override
    public String toString(){
        String nomAutores = "";
        String nomEjemplares = "Ejemplares: ";
        Iterator iterA = autores.iterator();
        Iterator iterE = ejemplares.iterator();
        
        nomAutores+="\n";
        
        if(autores.size()==1){
            nomAutores+="Autor: ";
            
            nomAutores+=(Autor)iterA.next();
        }else{
            nomAutores+="Autores: ";
            
            while(iterA.hasNext()){
                nomAutores+=(Autor)iterA.next();
                
                if(iterA.hasNext()){
                    nomAutores+=", ";
                }
            }
        }
        
        nomEjemplares+="\n";
        
        while(iterE.hasNext()){
            nomEjemplares+=(Ejemplar)iterE.next();
            
            if(iterE.hasNext()){
                nomEjemplares+=", ";
            }
        }
        
        return "Título: "+titulo+", "+
                "Edición: "+edicion+", "+
                nomAutores+
                nomEjemplares;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.titulo);
        hash = 89 * hash + this.edicion;
        hash = 89 * hash + Objects.hashCode(this.autores);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Libro other = (Libro) obj;
        if (this.edicion != other.edicion) {
            return false;
        }
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        return Objects.equals(this.autores, other.autores);
    }
    
    //setters

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setEdicion(int edicion) {
        this.edicion = edicion;
    }
    
    //getters

    public String getTitulo() {
        return titulo;
    }

    public int getEdicion() {
        return edicion;
    }

    public ArrayList<Ejemplar> getEjemplares() {
        return ejemplares;
    }
}

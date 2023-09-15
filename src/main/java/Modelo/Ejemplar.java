/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Gustavo
 */
public class Ejemplar {
    private Integer nroInventario;
    private boolean sale;
    private boolean prestado;

    public Ejemplar(Integer nroInventario, boolean sale) {
        this.nroInventario = nroInventario;
        this.sale = sale;
        this.prestado = false;
    }
    
    @Override
    public String toString(){
        return "Número de inventario: "+nroInventario+", "+
                "Sale: "+sale+", "+
                "Prestado: "+prestado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.nroInventario;
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
        final Ejemplar other = (Ejemplar) obj;
        return this.nroInventario == other.nroInventario;
    }
    
    //getters

    public void setNroInventario(int nroInventario) {
        this.nroInventario = nroInventario;
    }

    public void setSale(boolean sale) {
        this.sale = sale;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }
    
    //setters
    
    public int getNroInventario() {
        return nroInventario;
    }

    public boolean isSale() {
        return sale;
    }

    public boolean isPrestado() {
        return prestado;
    }
}

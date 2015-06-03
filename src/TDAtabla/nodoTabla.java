/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAtabla;

/**
 *
 * @author Nelson Cardenas
 */
public class nodoTabla {

    private String dato;
    private String ubicacion;
    private nodoTabla siguiente;

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public nodoTabla getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(nodoTabla siguiente) {
        this.siguiente = siguiente;
    }

    public nodoTabla(String valor, String ub) {
        this.setDato(valor);
        this.setSiguiente(null);
        this.setUbicacion(ub);
    }

}

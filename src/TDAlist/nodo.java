/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TDAlist;

/**
 *
 * @author Nelson Cardenas
 */
public class nodo {
    private char dato;
    private nodo siguiente;

    public nodo(char dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public char getDato() {
        return dato;
    }

    public void setDato(char dato) {
        this.dato = dato;
    }

    public nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(nodo siguiente) {
        this.siguiente = siguiente;
    }
    
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package comprimirarchivos;

/**
 *
 * @author Nelson Cardenas
 */
public class nodo {
    
    private int dato;
    private nodo izq, der;

    public nodo(int dato, nodo izq, nodo der) {
        this.dato = dato;
        this.izq = izq;
        this.der = der;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public nodo getIzq() {
        return izq;
    }

    public void setIzq(nodo izq) {
        this.izq = izq;
    }

    public nodo getDer() {
        return der;
    }

    public void setDer(nodo der) {
        this.der = der;
    }
    
    
}

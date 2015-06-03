/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAarbol;

import TDAarbol.arbol;

/**
 *
 * @author Nelson Cardenas
 */
public class nodoListaArbol {

    private arbol tree;
    private nodoListaArbol siguiente;

    public arbol getArbol() {
        return tree;
    }

    public void setArbol(arbol tree) {
        this.tree = tree;
    }

    public nodoListaArbol getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(nodoListaArbol siguiente) {
        this.siguiente = siguiente;
    }

    public nodoListaArbol(arbol valor) {
        this.setArbol(valor);
        this.setSiguiente(null);
    }

}

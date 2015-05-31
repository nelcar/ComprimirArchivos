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
public class arbol {

    private nodoArbol raiz;

    public nodoArbol getRaiz() {
        return raiz;
    }

    public void setRaiz(nodoArbol raiz) {
        this.raiz = raiz;
    }

    public arbol() {
        raiz = null;
    }

    public arbol(String s, Integer suma) {
        raiz = new nodoArbol(s, suma);
    }

    public void AgregarHojas(nodoArbol izq, nodoArbol der) {
        raiz.setIzq(izq);
        raiz.setDer(der);
    }

}

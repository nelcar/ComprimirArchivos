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
    
    private char dato;
    private int frecuencia;
    private nodo izq, der;

    public nodo(char dato, int frecuencia, nodo izq, nodo der) {
        this.dato = dato;
        this.frecuencia = frecuencia;
        this.izq = izq;
        this.der = der;
    }
    private boolean isLeath(){
        //assert para que se ignore el error
        assert (izq == null && der == null) || (izq != null && der != null);
        return (izq == null && der == null);
    }
    
    public int compareTo(nodo algo) {
        return this.frecuencia - algo.frecuencia;
    }
    
    public char getDato() {
        return dato;
    }

    public void setDato(char dato) {
        this.dato = dato;
    }

    public int getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(int frecuencia) {
        this.frecuencia = frecuencia;
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

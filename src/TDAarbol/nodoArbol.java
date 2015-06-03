/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAarbol;

/**
 *
 * @author Nelson Cardenas
 */
public class nodoArbol {

    private String dato;
    private Integer frecuencia;
    private nodoArbol izq;
    private nodoArbol der;

    public Integer getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(Integer frecuencia) {
        this.frecuencia = frecuencia;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public nodoArbol getIzq() {
        return izq;
    }

    public void setIzq(nodoArbol izq) {
        this.izq = izq;
    }

    public nodoArbol getDer() {
        return der;
    }

    public void setDer(nodoArbol der) {
        this.der = der;
    }

    public nodoArbol(String d) {
        dato = d;
        frecuencia = 1;
        izq = null;
        der = null;
    }

    public nodoArbol(String d, Integer n) {
        dato = d;
        frecuencia = n;
        izq = null;
        der = null;
    }
}

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
public class listaArbol {

    private nodoListaArbol inicio;

    public listaArbol() {
        inicio = null;
    }

    public nodoListaArbol getInicio() {
        return inicio;
    }

    public void setInicio(nodoListaArbol inicio) {
        this.inicio = inicio;
    }

    public void paraListaArbol(lista list) {
        if (list.getInicio() == null) {

        } else {
            String caracter = "";
            Integer frecuencia = 0;
            while (list.getInicio() != null) {
                caracter = list.getInicio().getDato() + "";
                frecuencia = list.contarIguales(list.getInicio().getDato());
                this.agregarOrdenados(new arbol(caracter, frecuencia));
                frecuencia = 0;
                caracter = "";
            }
        }
    }

    public void agregarOrdenados(arbol tree) {
        nodoListaArbol nuevo = new nodoListaArbol(tree);
        if (inicio == null) {
            inicio = nuevo;
        } else {
            nodoListaArbol aux = inicio;
            nodoListaArbol aux2 = null;
            while (aux != null && (aux.getTree().getRaiz().getFrecuencia() < nuevo.getTree().getRaiz().getFrecuencia())) {
                aux2 = aux;
                aux = aux.getSiguiente();
            }
            if (aux2 == null) {
                nuevo.setSiguiente(inicio);
                inicio = nuevo;
            } else if (aux == null) {
                aux2.setSiguiente(nuevo);
            } else {
                aux2.setSiguiente(nuevo);
                nuevo.setSiguiente(aux);
            }
        }
    }

    public void obtenerArbol() {
        nodoArbol uno = null;
        nodoArbol dos = null;
        while (this.inicio.getSiguiente() != null) {
            uno = this.sacarInicio();
            dos = this.sacarInicio();
            arbol nuevo = new arbol(null, uno.getFrecuencia() + dos.getFrecuencia());
            nuevo.AgregarHojas(uno, dos);
            this.agregarOrdenados(nuevo);
        }
    }

    public nodoArbol sacarInicio() {
        if (this.inicio == null) {

        }
        nodoListaArbol aux = inicio;
        inicio = aux.getSiguiente();
        aux.setSiguiente(null);
        return aux.getTree().getRaiz();
    }
}

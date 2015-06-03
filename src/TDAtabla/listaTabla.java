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
public class listaTabla {

    private nodoTabla inicio;

    public listaTabla() {
        inicio = null;
    }

    public nodoTabla getInicio() {
        return inicio;
    }

    public void setInicio(nodoTabla inicio) {
        this.inicio = inicio;
    }

    public nodoTabla sacarInicio() throws Exception {
        if (this.inicio == null) {
            throw new Exception();
        }
        nodoTabla aux = inicio;
        inicio = aux.getSiguiente();
        aux.setSiguiente(null);
        return aux;
    }

    public void agregar(String valor, String ubicacion) {
        nodoTabla nuevo = new nodoTabla(valor, ubicacion);
        if (this.getInicio() == null) {
            this.setInicio(nuevo);
        } else {
            nuevo.setSiguiente(inicio);
            inicio = nuevo;
        }
    }

    public String unirTodo(String mensaje) throws Exception {
        if (this.getInicio() == null) {
            throw new Exception();
        }
        String todo = "";
        for (int i = 0; i < mensaje.length(); i++) {
            todo = todo + ubicacionDe(mensaje.charAt(i) + "");
        }
        return todo;
    }

    private String ubicacionDe(String dato) {
        nodoTabla aux = inicio;
        while (aux != null && !(aux.getDato().equals(dato))) {
            aux = aux.getSiguiente();
        }
        return aux.getUbicacion();
    }

    public String LetraDe(String ubicacion) {
        String letra = null;
        nodoTabla aux = inicio;
        while (aux != null && !(aux.getUbicacion().equals(ubicacion))) {
            aux = aux.getSiguiente();
        }
        if (aux != null) {
            letra = aux.getDato();
        }
        return letra;
    }
}

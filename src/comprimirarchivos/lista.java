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
public class lista {
    
    private nodo inicio;
    
    public lista() {
    }
    
    public lista(nodo inicio) {
        this.inicio = inicio;
    }
    
    public nodo getInicio() {
        return inicio;
    }
    
    public void setInicio(nodo inicio) {
        this.inicio = inicio;
    }

    //Metodos
    public void paraLista(String contenido) {
        for (int i = 0; i < contenido.length(); i++) {
            
        }
    }
    
    public void agregar(char caracter) {
        nodo nuevo = new nodo(caracter);
        if (inicio == null) {
            inicio = nuevo;
        } else {
            nodo auxiliar = inicio;
            while (auxiliar.getSiguiente() != null) {
                auxiliar = auxiliar.getSiguiente();
            }
            auxiliar.setSiguiente(nuevo);
        }
    }
}

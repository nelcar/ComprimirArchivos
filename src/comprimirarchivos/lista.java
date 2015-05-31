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
            this.agregarAtras(contenido.charAt(i));
        }
    }
    
    public void agregarAtras(char caracter) {
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
    
    public void recorrer(){
        if(inicio == null){
            System.out.println("NULL");
        }else{
            nodo auxiliar = this.getInicio();
            while(auxiliar != null){
                System.out.print(" ** " + auxiliar.getDato());
                auxiliar = auxiliar.getSiguiente();
            }
        }
    }
}

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
public class comprNelCar {

    public String[] comprimir(String contenido) {
        //Se crea una lista para guardar el mensaje
        lista cadena = new lista();
        cadena.paraLista(contenido);
        cadena.recorrer();
        
        //se crea una lista de arboles
        listaArbol list = new listaArbol();
        list.paraListaArbol(cadena);
        
        //se crea el arbol
        list.obtenerArbol();
        
        //se crea la Tabla
        
        return null;
    }
}

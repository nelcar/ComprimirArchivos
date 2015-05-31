/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAlist;

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

    public void recorrer() {
        if (inicio == null) {
            System.out.println("NULL");
        } else {
            nodo auxiliar = this.getInicio();
            while (auxiliar != null) {
                System.out.print(" ** " + auxiliar.getDato());
                auxiliar = auxiliar.getSiguiente();
            }
        }
    }

    public Integer contarIguales(char dato) {
        nodo auxiliar = inicio;
        Integer contador = 0;
        Integer contador2 = 0;
        while (auxiliar != null) {
            contador2++;
            if (auxiliar.getDato() == dato) {
                contador++;
                auxiliar = auxiliar.getSiguiente();
                this.eliminar(contador2);
                contador2--;
            } else {
                auxiliar = auxiliar.getSiguiente();
            }
        }
        return contador;
    }

    public void eliminar(int posicion) {
        if (inicio != null) {
            if (posicion > 0) {
                nodo anterior = null;
                nodo auxiliar = inicio;
                int cont = 1;
                while ((auxiliar != null) && (cont != posicion)) {
                    cont++;
                    anterior = auxiliar;
                    auxiliar = auxiliar.getSiguiente();
                }
                if (auxiliar == null) {

                }
                if (anterior == null) {
                    inicio = inicio.getSiguiente();
                    auxiliar.setSiguiente(null);
                    auxiliar = null;
                } else {
                    anterior.setSiguiente(auxiliar.getSiguiente());
                    auxiliar.setSiguiente(null);
                    auxiliar = null;
                }
            }
        } else {

        }
    }
}

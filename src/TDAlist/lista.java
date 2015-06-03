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

    public nodo getInicio() {
        return inicio;
    }

    public void setInicio(nodo inicio) {
        this.inicio = inicio;
    }

    //constructores
    public lista() {
        this.setInicio(null);
    }

    public void agregar(char valor) {
        nodo nuevo = new nodo(valor);
        if (this.getInicio() == null) {
            this.setInicio(nuevo);
        } else {
            nuevo.setSiguiente(inicio);
            inicio = nuevo;
        }
    }

    //Metodos
    public void toLista(String mensaje) {
        for (int i = 0; i < mensaje.length(); i++) {
            this.agregarAtras(mensaje.charAt(i));
        }
    }

    public void agregarAtras(char valor) {
        nodo nuevo = new nodo(valor);
        if (inicio == null) {
            inicio = nuevo;
        } else {
            nodo aux = inicio;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevo);
        }
    }

    public void recorrer() {
        if (inicio == null) {
            System.out.println("NULL.");
        } else {
            nodo aux = this.getInicio();
            System.out.print("Inicio ");
            while (aux != null) {
                System.out.print(" -> " + aux.getDato());
                aux = aux.getSiguiente();
            }
            System.out.println(" -> NULL");
        }
    }

    public Integer contarIguales(char dato) throws Exception {
        nodo aux = inicio;
        Integer contador = 0;
        Integer contador2 = 0;
        while (aux != null) {
            contador2++;
            if (aux.getDato() == dato) {
                contador++;
                aux = aux.getSiguiente();
                this.eliminar(contador2);
                contador2--;
            } else {
                aux = aux.getSiguiente();
            }
        }
        return contador;
    }

    public void eliminar(int posicion) throws Exception {
        if (inicio != null) {
            if (posicion > 0) {
                nodo ant = null;
                nodo aux = inicio;
                int cont = 1;
                while ((aux != null) && (cont != posicion)) {
                    cont++;
                    ant = aux;
                    aux = aux.getSiguiente();
                }
                if (aux == null) {
                    throw new Exception();
                }
                if (ant == null) {
                    inicio = inicio.getSiguiente();
                    aux.setSiguiente(null);
                    aux = null;
                } else {
                    ant.setSiguiente(aux.getSiguiente());
                    aux.setSiguiente(null);
                    aux = null;
                }

            }
        } else {
            throw new Exception();
        }
    }
}

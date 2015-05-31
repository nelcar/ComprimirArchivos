/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comprimirarchivos;

import TDAarbol.listaArbol;
import TDAlist.lista;
import TDAtabla.listaTabla;
import TDAtabla.nodoTabla;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author Nelson Cardenas
 */
public class comprNelCar {

    public String[] comprimir(String contenido, String direccionG) {
        //Se crea una lista para guardar el mensaje
        lista cadena = new lista();
        cadena.paraLista(contenido);
        cadena.recorrer();

        //se crea una lista de arboles
        listaArbol list = new listaArbol();
        list.paraListaArbol(cadena);

        //se crea el arbol
        list.obtenerArbol();
        System.out.println("se creo el arbol");

        //se crea la Tabla
        listaTabla tabla = new listaTabla();
        tabla = list.obtenerHojas("", tabla, list.getInicio().getTree().getRaiz());

        String direccion = tabla.unirTodo(contenido);

        //escribir codigo
        String codigo = guardar(direccion, tabla, direccionG + "/comprimido.txt");
        String[] array = {direccion, codigo};
        return array;
    }

    private String guardar(String mensaje, listaTabla tabla, String nombre) {
        try {
            File f = new File(nombre);
            FileWriter w = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(w);
            PrintWriter pw = new PrintWriter(bw);
            String bits = "";
            String codificado = "";
            int falta = 0;
            byte bin;
            char car;

            for (int i = 0; i < mensaje.length(); i++) {
                if (bits.length() == 8) {
                    bin = (byte) Short.parseShort(bits, 2);
                    car = (char) (bin & 0xFF);
                    codificado += car;
                    bits = "";
                    i--;
                } else {
                    bits += mensaje.charAt(i);
                }
            }
            if (bits.length() != 0) {
                bin = (byte) Short.parseShort(bits, 2);
                car = (char) (bin & 0xFF);
                codificado += car;
                falta = 8 - bits.length();
            }

            pw.write(codificado + "\n");
            pw.write(falta + "\n");
            nodoTabla aux = tabla.getInicio();
            //A partir de nuestra ListaTabla escribimos el caracter seguido de la direccion
            while (aux != null) {
                pw.write(aux.getDato() + aux.getUbicacion() + "\n");
                aux = aux.getSiguiente();
            }
            pw.close();
            bw.close();
            JOptionPane.showMessageDialog(null, "Archivo generado exitosamente!!!\n nombre: " + nombre);
            //Retornamos la cadena decodificada
            return codificado;
        } catch (Exception e) {

        } finally {

        }
        return null;
    }

}

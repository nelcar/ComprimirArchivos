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
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author Nelson Cardenas
 */
public class comprNelCar {

    public String[] comprimir(String contenido, String direccionG) throws Exception {
        //Se crea una lista para guardar el mensaje
        lista cadena = new lista();
        cadena.toLista(contenido);
        cadena.recorrer();

        //se crea una lista de arboles
        listaArbol list = new listaArbol();
        list.paraListaArbol(cadena);

        //se crea el arbol
        list.obtenerArbol();
        System.out.println("se creo el arbol");

        //se crea la Tabla
        listaTabla tabla = new listaTabla();
        tabla = list.obtenerHojas("", tabla, list.getInicio().getArbol().getRaiz());

        String direccion = tabla.unirTodo(contenido);

        //escribir codigo
        String name = JOptionPane.showInputDialog("Nombre del archivo");
        String codigo = guardar(direccion, tabla, direccionG + "/" + name + ".txt");
        String[] array = {direccion, codigo};
        return array;
    }

    private String guardar(String mensaje, listaTabla tabla, String nombre) {
        //Creamos los objetos necesarios para escribir
        String codificado = "";
        try {
            File f = new File(nombre);
            FileWriter w = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(w);
            PrintWriter escritor = new PrintWriter(bw);
            String bits = "";

            int falta = 0;
            byte bin;
            char car;
            //Convertimos los 1 y 0 a bytes y despues a caracter, y lo vamos concatenando
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
            //Escribimos en el archivo la cadena de caracteres generada
            escritor.write(codificado + "\n");
            escritor.write(falta + "\n");
            nodoTabla aux = tabla.getInicio();
            //A partir de nuestra ListaTabla escribimos el caracter seguido de la direccion
            while (aux != null) {
                escritor.write(aux.getDato() + aux.getUbicacion() + "\n");
                aux = aux.getSiguiente();
            }
            escritor.close();
            bw.close();
            JOptionPane.showMessageDialog(null, "Archivo generado exitosamente!!!\n nombre: " + nombre);
            //Retornamos la cadena decodificada
            return codificado;
        } catch (Exception e) {

        }
        return codificado;
    }

    public String Descomprimir(String direccion) {
        File doc = new File(direccion);
        try {
            FileReader fr = new FileReader(doc);
            BufferedReader lector = new BufferedReader(fr);

            //Cargamos en apoyo2 el mensaje de caracteres
            String apoyo2 = lector.readLine();
            Integer falta = Integer.parseInt(lector.readLine());
            String apoyo = "";
            String mensaje = "";
            byte bit2;

            //los convertimos a binario y rellenamos con ceros en caso de que no sea de longitud 8
            for (int i = 0; i < apoyo2.length(); i++) {
                bit2 = (byte) apoyo2.charAt(i);
                apoyo = Integer.toBinaryString(bit2 & 0xFF);
                if (apoyo.length() < 8) {
                    apoyo = rellenar(apoyo);
                    if (i == (apoyo2.length() - 1)) {
                        apoyo = quitar(apoyo, falta);
                    }
                }
                mensaje += apoyo;
            }
            
            
            //Creamos una listaTabla para cargar los caracteres y sus direcciones
            listaTabla tabla = new listaTabla();
            apoyo = lector.readLine();
            while (apoyo != null) {
                tabla.agregar(apoyo.charAt(0) + "", quitar(apoyo, 1));
                apoyo = lector.readLine();
            }
            JOptionPane.showMessageDialog(null, "Archivo cargado exitosamente!!!\nnombre: " + direccion + ".txt");
            apoyo = "";
            String original = "";
            apoyo2 = "";
            
            //Decodificamos el string de direcciones para obtener el mensaje original
            for (int i = 0; i < mensaje.length(); i++) {
                apoyo = apoyo + mensaje.charAt(i);
                apoyo2 = tabla.LetraDe(apoyo);
                if (apoyo2 != null) {
                    original = original + apoyo2;
                    apoyo = "";
                    apoyo2 = "";
                }
            }
            return original;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private String rellenar(String cadena) {
        //Rellenamos la cadena con ceros a la izquierda
        String nueva = "";
        for (int i = 0; i < 8 - cadena.length(); i++) {
            nueva += "0";
        }
        nueva += cadena;
        return nueva;
    }

    private String quitar(String cad, Integer n) {
        //Quitamos a la cadena n caracteres 
        String nueva = "";
        for (int i = n; i < cad.length(); i++) {
            nueva += cad.charAt(i);
        }
        return nueva;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Hojas.Nodo;

/**
 *
 * @author Marlon Ramirez
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Matriz {
    Nodo raiz;
    public Matriz() {
        this.raiz = null;
     

    }
    public void insertar(Object dato, int fila, int columna) {
    	Nodo nuevo = new Nodo(dato, fila, columna);

       System.out.println();

        if (raiz == null) {
            // Si la matriz está vacía el nuevo nodo será la raíz
            raiz = nuevo;
           
        } else {
            // Buscar la posición adecuada para el nuevo nodo
            Nodo actual = raiz;
            Nodo anterior = null;

            System.out.println("Buscando posición para el nuevo nodo...");

            while (actual != null && actual.fila <= fila && actual.columna <= columna) {
                anterior = actual;
                actual = actual.abajo;
                System.out.println("Actual: " + actual);
                System.out.println("Anterior: " + anterior);
            }
            
            System.out.println("Se encontró la posición adecuada para el modelo...");
            /**
             * actual.fila < nuevo.fila;
             * actual.linea.compareTo(nuevo.linea) < 0
             * 
             */
            while (actual != null && actual.fila <= nuevo.fila && actual.columna <= nuevo.columna ) {
                anterior = actual;
                actual = actual.derecha;
                System.out.println("Actual: " + actual);
                System.out.println("Anterior: " + anterior);
            }
            
            System.out.println("Se encontró la posición adecuada para la línea...");

            
            //No permite valores duplicados
            if (actual != null && actual.dato.equals(dato) && actual.fila == fila && actual.columna == columna) {
                System.out.println("El nodo ya existe en la matriz");
                return;
            }
            /**/
            
            System.out.println("Posición encontrada: " + anterior + ", " + actual);

            
            //
            if (anterior == null) {
                raiz = nuevo;
            } else if (anterior.abajo == null) {
                anterior.abajo = nuevo;
                nuevo.arriba = anterior;
            } else {
                nuevo.abajo = actual;
                actual.arriba = nuevo;
                nuevo.arriba = anterior;
                anterior.abajo = nuevo;
            }

            System.out.println("Nodo agregado en la dirección vertical...");

            
            //            
            if (anterior == null) {
                raiz = nuevo;
            } else if (anterior.derecha == null) {
                anterior.derecha = nuevo;
                nuevo.izquierda = anterior;
            } else {
                nuevo.derecha = actual;
                actual.izquierda = nuevo;
                nuevo.izquierda = anterior;
                anterior.derecha = nuevo;
            }

           
            System.out.println("Nodo agregado en la dirección horizontal...");
            
            System.out.println("--------------------------");

            
        }
    }
    
    
    public List<Nodo> buscar(Object dato) {
        List<Nodo> resultados = new ArrayList<>();
        Set<Nodo> nodosAgregados = new HashSet<>();

        Nodo actual = raiz;
        while (actual != null) {
            Nodo temp = actual;
            while (temp != null) {
                if ((dato == null || temp.dato.equals(dato))) {
                    if (!nodosAgregados.contains(temp)) {
                        resultados.add(temp);
                        nodosAgregados.add(temp);
                       

                    }
                }
                temp = temp.derecha;
            }
            actual = actual.abajo;
        }

        return resultados;
    }


    public void eliminar(Object dato) {
        List<Nodo> nodosAEliminar = buscar(dato);
        if (nodosAEliminar.isEmpty()) {
            System.out.println("No se encontraron nodos para eliminar");
            return;
        }
        for (Nodo nodoActual : nodosAEliminar) {
            Object placaEliminada = nodoActual.dato; 

            Nodo nodoArriba = nodoActual.arriba;
            Nodo nodoAbajo = nodoActual.abajo;
            Nodo nodoIzquierda = nodoActual.izquierda;
            Nodo nodoDerecha = nodoActual.derecha;

            if (nodoArriba != null) {
                nodoArriba.abajo = nodoAbajo;
            }
            if (nodoAbajo != null) {
                nodoAbajo.arriba = nodoArriba;
            }
            if (nodoIzquierda != null) {
                nodoIzquierda.derecha = nodoDerecha;
            }
            if (nodoDerecha != null) {
                nodoDerecha.izquierda = nodoIzquierda;
            }

            if (nodoActual == raiz) {
                raiz = nodoActual.derecha != null ? nodoActual.derecha : nodoActual.abajo;
            }

            nodoActual = null;
            
            System.out.println("Se eliminó correctamente la placa " + placaEliminada); 

        }
        
        System.out.println("Se han eliminado " + nodosAEliminar.size() + " nodos");

    }
    
    




}
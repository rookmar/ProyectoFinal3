/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hojas;

/**
 *
 * @author Marlon Ramirez
*/
public class Nodo {

    public Nodo abajo, arriba, izquierda, derecha;
    public Object dato;
    public int fila;
    public int columna;

    public Nodo(Object dato, int fila, int columna) {
        this.dato = dato;
        this.fila = fila;
        this.columna = columna;
    }
}

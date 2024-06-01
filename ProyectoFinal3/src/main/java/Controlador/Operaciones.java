/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vistas.HojaPrincipal;
import java.io.IOException;

/**
 *
 * @author Marlon Ramirez
 */
public class Operaciones {
    
    /**
     * @param args the command line arguments
     */
    
    int [][] spreadSheetSimulation = {{1,2,3,4},
        {5,6,7,8},
        {9,10,11,12},
        {13,14,15,16}};
    public static void main(String[] args) {
        
//        String calculo;
        try {
            // TODO code application logic here
            String txtInput = "=suma(3,5,10,20)";
            String[] numbers = txtInput.split("[^0-9()]");
            System.out.println(function(txtInput));
            new HojaPrincipal().setVisible(true);
            
        } catch (IOException ex) {
            System.err.println("Error");
        }
    }
    
    public static String function(String ecuation) throws IOException{
        if (ecuation.startsWith("=")){
            ecuation = ecuation.replace("=", "");
            String[] numbers;
            String switchTxt = ecuation.split("[^a-zA-Z]")[0].toLowerCase();
            switch (switchTxt){
                case "suma": /*Coding suma*/ 
                    ecuation = ecuation.replace(switchTxt, "");
                    System.out.println("Ecuation until now:"+ecuation+".");
                    numbers = ecuation.split("[^0-9()]");
                    numbers = replace(numbers);
                    System.out.println("Numeros a sumar");
                    printArray("SUMA", numbers);
                    
                    
                    break;
                case "multiplicacion": /* Coding multiplicacion*/
                    ecuation = ecuation.replace(switchTxt, "");
                    System.out.println("Ecuation until now:"+ecuation+".");
                    numbers = ecuation.split("[^0-9()]");
                    numbers = replace(numbers);
                    System.out.println("Numeros a multiplicar");
                    printArray("multi", numbers);
                    break;
                default: System.out.println("not a valid operation");break;
            }
        }else{
            throw new IOException();
        }
        return null;
    }
    
    public static void printArray(String id, String[] elements){
        for (int i = 0; i < elements.length; i++) {
            System.out.println(id + " " + elements[i]);
        }
    }
    
    public static String[] replace(String[] elements){
        for (int i = 0; i < elements.length; i++) {
            elements[i] = elements[i].replaceAll("[^0-9]", "");
        }
        return elements;
    }
    
}

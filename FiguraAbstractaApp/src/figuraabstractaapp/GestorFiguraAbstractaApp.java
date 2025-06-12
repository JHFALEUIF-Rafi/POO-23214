/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package figuraabstractaapp;

import java.util.ArrayList;
import java.util.Iterator;

public class GestorFiguraAbstractaApp {

    public static void main(String[] args) {
        Rectangulo r1 = new Rectangulo (12, 45);
        Circunferencia c1 = new Circunferencia (7);
        Triangulo t1 = new Triangulo (9, 13);
        
        ArrayList <Figura> listf = new ArrayList <Figura>();
        listf.add(r1);
        listf.add(c1);
        listf.add(t1);
        Iterator it = listf.iterator();
        while (it.hasNext()){
            Figura f1 = (Figura) it.next();
            System.out.println(f1.calcularArea());
        }
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package autosapp;

import java.util.ArrayList;

public class GestorAutosApp {

    public static void main(String[] args) {
        Auto objt1 = new Auto("Pichirilo", 1500);
        Auto objt2 = new Auto("El carro de mi papa", 4700);
        Auto objt3 = new Auto("El carro de tu primo", 7800);

        //ArrayList<Auto> listAuto = new ArrayList<Auto>();
        ListaAuto listAuto = new ListaAuto();
        listAuto.adicionarAuto(objt1);
        listAuto.adicionarAuto(objt2);
        //listAuto.add(objt3);
        listAuto.adicionarAuto(objt3);
        
        /*System.out.println(listAuto.size());
        Auto objtaux = new Auto();
        objtaux =listAuto.get(1);
        System.out.println(objtaux.toString());*/
        
        listAuto.mostrarLista();
        listAuto.definirMayor();
        listAuto.kilometraje("El carro de tu primo");
        
        System.out.println("LISTA ORDENADA");
        listAuto.ordenarAutos();
        listAuto.mostrarLista();
        
        System.out.println("LISTA 2");
        listAuto.ordenarAutosV2();
        listAuto.mostrarLista();
    }

}

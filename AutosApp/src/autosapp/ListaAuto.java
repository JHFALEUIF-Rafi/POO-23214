/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autosapp;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaAuto {

    ArrayList<Auto> listA;

    public ListaAuto() {
        this.listA = new ArrayList();
    }

    public void adicionarAuto(Auto obj) {
        listA.add(obj);
    }

    public void mostrarLista() {
        //recorre el array
        Auto aux = new Auto();
        Iterator it = listA.iterator();
        while (it.hasNext()) {
            aux = (Auto) it.next();
            System.out.println(aux.toString());
        }
    }

    public Auto definirMayor() {
        Iterator<Auto> it = listA.iterator();
        Auto mayor = it.next();
        while (it.hasNext()) {
            Auto actual = it.next();
            if (actual.getKm() > mayor.getKm()) {
                mayor = actual;
                System.out.println("El mayor es: " + mayor.toString());
            }
        }
        return mayor;
    }

    public int kilometraje(String marca) {
        int totalKm = 0;
        Iterator<Auto> it = listA.iterator();
        while (it.hasNext()) {
            Auto auto = it.next();
            if (auto.getModelo().equalsIgnoreCase(marca)) {
                totalKm += auto.getKm();
                System.out.println("totalKm"+ totalKm);
            }
        }
        return totalKm;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autosapp;

import java.util.Comparator;

/**
 *
 * @author Rafa
 */
public class OrdenarAutoPorKm implements Comparator <Auto>{

    @Override
    public int compare(Auto o1, Auto o2) {
        return o1.getKm()-o2.getKm();
    }
    
}

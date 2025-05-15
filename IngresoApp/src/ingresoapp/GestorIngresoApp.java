package ingresoapp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GestorIngresoApp {

    public static void main(String[] args) {
        InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);
        try{
            System.out.print("Ingrese califificacion entera: ");
            int calificacion = Integer.parseInt(br.readLine());
            System.out.println("Calificacion: " + calificacion);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
}

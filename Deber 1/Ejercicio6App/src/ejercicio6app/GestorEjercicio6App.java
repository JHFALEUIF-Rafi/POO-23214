/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio6app;
import java.util.Scanner;

public class GestorEjercicio6App {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("Ingrese numero de anios M(1-30): ");
        int M = entrada.nextInt();
        System.out.print("Ingrese numero de surcursales N(1-35): ");
        int N = entrada.nextInt();
        
        if (M<1 || M>30 || N<1 || N>35){
            System.out.println("Valores fuera de rango. Intente de nuevo");
            return;
        }
        
        double[][] ventas = new double[M][N];
        for (int año=0; año<M; año++){
            System.out.println("\nIngrese ventas " + (año + 1) + ":");
            
            for (int sucursal = 0; sucursal < N; sucursal++){
                System.out.println("Sucursal " + ( sucursal + 1 ) + ": ");
                ventas[año][sucursal]= entrada.nextDouble();
            }
        }
        int sucursalMax = 0;
        double maxVentas = 0;
        for (int sucursal=0; sucursal<N; sucursal++){
            double totalSucursal = 0;
            for ( int año=0; año<M; año++){
                totalSucursal += ventas[año][sucursal];
            }
            if(totalSucursal>maxVentas){
                maxVentas = totalSucursal;
                sucursalMax = sucursal + 1;                    
                }
            }
        
        double[] promediosAño = new double[M];
        for (int año=0; año<M; año++){
            double totalAño = 0;
            for (int sucursal=0; sucursal<N; sucursal++){
                totalAño += ventas[año][sucursal];
            }
            promediosAño[año]=totalAño / N;
        }
        
        int añoMaxPromedio=0;
        double maxPromedio=promediosAño[0];
        for(int año=1; año<M; año++){
            if(promediosAño[año]>maxPromedio){
               maxPromedio = promediosAño[año];
               añoMaxPromedio=año + 1;
            }
        }
        System.out.println("\nb Promedios por anio: ");
        for(int año=0; año<M; año++){
            System.out.println("Anio " + (año + 1) + ": $" + promediosAño[año]);
        }
        System.out.println("\n. Anio con mayor promedio de ventas: Anio " + añoMaxPromedio + " con $" + maxPromedio);
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package erroresapp;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GestporErroresApp {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        boolean continuarCiclo = true;
        int a = 0, b = 0, x = 0;
        do {//inicia ciclo
            try {
                System.out.print("Ingrese un numero: ");
                a = entrada.nextInt();
                System.out.print("Ingrese un numero: ");
                b = entrada.nextInt();

                //division
                System.out.println("El resultado es: " + a / b);
                //System.out.println("Quieres continuar?: 0: no 1: si");
                validarRango(a, b);
                x = entrada.nextInt();
                if (x == 0) {
                    continuarCiclo = false;
                }

            } catch (ErrorIntervalo ime) {
                /*System.out.println("Ingreo una letra, vuelva a intentarlo");
                entrada.nextLine();*/

                System.out.println(ime.getMessage());
            } catch (ArithmeticException ae) {
                System.out.println("Estas dividiendo para cero miso, no seas pendej0");
                System.out.println("Especifica otro numero");
                entrada.nextLine();
            } finally {
                System.out.println("Listo, otro intento");
            }
        } while (continuarCiclo);
        System.out.println("Ya chao");
    }

    //metodo adicional
    static void validarRango(int num, int den) throws ErrorIntervalo {
        if (num > 20) {
            throw new ErrorIntervalo("Numeros fuera de rango");
        }
    }
}

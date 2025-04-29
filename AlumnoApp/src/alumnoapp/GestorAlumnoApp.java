/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package alumnoapp;

public class GestorAlumnoApp {

    public static void main(String[] args) {
        /*Alumno objtAlumno = new Alumno("Rafi", 19);
        //objtAlumno.imprimir();

        Alumno objt2Alumno = new Alumno(19, "Tilin");
        objt2Alumno.setEdad(26);
        System.out.println("Nueva edad");
        objt2Alumno.imprimir();

        Alumno objt3Alumno = new Alumno();
        objt3Alumno.setEdad(15);
        System.out.println("Nueva edad");
        objt3Alumno.imprimir();

        Alumno objt4Alumno = new Alumno(19);
        //objt4Alumno.imprimir();*/

        Alumno objt5Alumno = new Alumno("Aylin");
        //objt5Alumno.imprimir();
        String temp = objt5Alumno.getNombre();
        System.out.println(temp);
        
        System.out.println(objt5Alumno.getNombre()); //imprimir edad una sola línea 
        
        int temp2=objt5Alumno.getEdad();
        System.out.println(temp2);
    }
}

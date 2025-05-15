/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package deber2app;

/**
 *
 * @author Rafa
 */
public class Deber2App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Ejercicio 1
        Ciudadano objtCiudadano = new Ciudadano(11111, "Rafi", "Prry");
        System.out.println("****RESUMEN CIUDADANO****");
        objtCiudadano.nombreCompleto();
        objtCiudadano.imprimirId();

        //Ejercicio 2
        YogurtDeslactosado objtYog = new YogurtDeslactosado(120.50f);
        System.out.println("\n****RESUMEN YOGURT****");
        objtYog.imprimirCal();

        //Ejercicio 3
        IngenieroInformatico objtIngS = new IngenieroInformatico("Javier", "Serrano", 19);
        System.out.println("\n****RESUMEN I.Informatico****");
        //ejecutar funciones

        //Ejercicio 4
        Libro objtLib = new Libro(125, "El ululu", 12.20);
        System.out.println("\n****RESUMEN LIBRO****");
        objtLib.datosPubli();
        objtLib.datosLibro();

        Cd objtCd = new Cd(98, "Oyejaime", 6.25);
        System.out.println("\n****RESUMEN CD****");
        objtCd.datosPubli();
        objtCd.datosCd();

        //Ejercicio 5
        System.out.println("\n****P.FRESCOS****");
        System.out.println("Cereza:");
        Frescos cereza = new Frescos("si", "Italia", "22 MAY 2027", 12);
        System.out.println(cereza.toString());
        System.out.println("Durazno:");
        Frescos durazno = new Frescos("si", "Francia", " 15 SEP 2028", 1);
        System.out.println(durazno.toString());

        System.out.println("\n****P.REFRIGERADOS****");
        System.out.println("Camaron:");
        Refrigerado camaron = new Refrigerado("12A", 5.01, "si", "Esmeraldas", "12 OCT 2025", 52);
        System.out.println(camaron.toString());
        System.out.println("Pulpo:");
        Refrigerado pulpo = new Refrigerado("21E", 2.22, "si", "China", "05 NOV 2025", 21);
        System.out.println(pulpo.toString());
        System.out.println("Cangrejo:");
        Refrigerado cangrejo = new Refrigerado("2B", 1.14, "no", "Guayaquil", "06 SEP 2025", 3);
        System.out.println(cangrejo.toString());

        System.out.println("\n****P.CONGELADOS****");
        System.out.println("Pollo(Agua):");
        Agua pollo = new Agua(1.2, "4A", 12.02, "si", "Quito", "15 JUN 2025", 4);
        System.out.println(pollo.toString());
        System.out.println("Carne(Agua):");
        Agua carne = new Agua(1.2, "7B", 10.02, "si", "Quito", "15 AGO 2025", 4);
        System.out.println(carne.toString());
        System.out.println("Pan(Aire):");
        Aire pan = new Aire(14.1, 1.1, 12.1, "4C", 11.1,"no", "Ambato", "21 DIC 2025", 14);
        System.out.println(pan.toString());
        System.out.println("Zanahorias(Aire):");
        Aire zanahoria=new Aire(02.1, 1.2, 1.1, "4ASD", 10.2,"no", "Ambato", "21 OCT 2025", 15);
        System.out.println(zanahoria.toString());
        System.out.println("Pescado(Nitrogeno):");
        Nitrogeno pescado=new Nitrogeno("Congelacion Master", 422, "7K", 16.41,"si", "Santa Elena", "16 ENE 2026", 62);
        System.out.println(pescado.toString());
    }

}

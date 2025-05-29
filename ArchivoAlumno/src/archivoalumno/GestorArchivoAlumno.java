package archivoalumno;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class GestorArchivoAlumno {

    public static void main(String[] args) {
        Alumno p1 = new Alumno("Rafi", "1234", 12);
        Alumno p2 = new Alumno("Javi", "5678", 19);

        ArrayList<Alumno> listAlumno = new ArrayList<Alumno>();
        listAlumno.add(p1);
        listAlumno.add(p2);

        File archivo = new File("Alumno.txt");
        FileWriter fw = null;
        PrintWriter pw = null;

        try {
            fw = new FileWriter(archivo);
            pw = new PrintWriter(fw);

            for (Alumno a : listAlumno) {
                pw.printf("%-25s DNI:%s Nota:%4.1f%n", a.getNombre(), a.getDni(), a.getNota());
            }
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

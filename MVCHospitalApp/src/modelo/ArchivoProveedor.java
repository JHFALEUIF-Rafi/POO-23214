package modelo;

import java.io.File;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ArchivoProveedor {
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public ArrayList<Proveedor> lecturaArchivo() {
    ArrayList<Proveedor> listP = new ArrayList<>();
    File archivo = new File("proveedor.txt");

    try (FileReader fr = new FileReader(archivo);
         Scanner ingreso = new Scanner(fr)) {
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        while (ingreso.hasNext()) {
            String line = ingreso.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] datos = line.split("%");
            if (datos.length >= 3) {
                String nombre = datos[0].trim();
                String pais = datos[1].trim();
                int cedula = Integer.parseInt(datos[2].trim());
                
                Date fechaNacimiento = null;
                if (datos.length >= 4 && !datos[3].trim().isEmpty()) {
                    try {
                        fechaNacimiento = sdf.parse(datos[3].trim());
                    } catch (ParseException e) {
                        System.err.println("Fecha inválida: " + datos[3]);
                    }
                }
                
                listP.add(new Proveedor(nombre, pais, cedula, fechaNacimiento));
            }
        }
    } catch (Exception io) {
        System.err.println("Error al leer archivo: " + io.getMessage());
    }
    return listP;
}
}

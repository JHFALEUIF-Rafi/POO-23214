package asociacionprograma;

import java.util.ArrayList;
import java.util.Iterator;

public class Usuario {

    private String nombreUsuario;
    private int clave;

    //Asociacion NN
    ArrayList<Programa> programas = new ArrayList<Programa>();

    public Usuario(String nombreUsuario, int clave) {
        this.nombreUsuario = nombreUsuario;
        this.clave = clave;
    }

    public Usuario() {
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public void instalarPrograma(Programa programa) {
        Iterator<Programa> iterator = programas.iterator();
        Programa aux = new Programa();
        boolean encontrado = false;
        while (iterator.hasNext() && !encontrado) {
            aux = iterator.next();
            if (aux.getNombrePrograma() == programa.getNombrePrograma()) {
                encontrado = true;
            }
        }
        if (encontrado) {
            System.out.println("El programa ya existe");
        } else {
            programas.add(programa);
            //enlace asociacion NN
            programa.crearUsuario(this);
            System.out.println("El programa fue creado");
        }
    }

}

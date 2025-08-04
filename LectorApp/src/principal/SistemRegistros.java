package principal;

import Clases.Lector;
import Clases.PersonalAdministrativo;
import Clases.Policia;
import java.util.ArrayList;
import java.util.Comparator;

public class SistemRegistros {

    private static SistemRegistros unicaInstancia;

    public static SistemRegistros getInstancia() {
        if (unicaInstancia == null) {
            unicaInstancia = new SistemRegistros();
        }
        return unicaInstancia;
    }

    private SistemRegistros() {
    }

    private ArrayList<Policia> ListaPolicia = new ArrayList();
    private ArrayList<PersonalAdministrativo> ListaAdministrativo = new ArrayList();
    private final String nombreComisaria = "LOS TRALALEROS";

    public void ejecutar() {
        int opt;
        do {
            opt = menu();
            switch (opt) {
                case 1:
                    registrarPolicia();
                    break;
                case 2:
                    registrarPersonal();
                    break;
                case 3:
                    calcularSaldo();
                    break;
                case 4:
                    listarPoliciaEdad();
                    break;
                case 5:
                    lsitarPoliciaSueldo();
                    break;
                case 6:
                    listarPersonal();
                    break;
                case 7:
                    System.out.println("Saliendo del programa");
                    break;
                default:
                    System.out.println("La opcion no es valida");
            }
        } while (opt != 7);
    }

    public int menu() {
        String opciones
                = "\n MENU PRINCIPAL DE LA COMISARIA " + nombreComisaria
                + "\n1.Registrar Policia "
                + "\n2.Registrar Personal Administrativo "
                + "\n3.Calcular Saldo del Policia "
                + "\n4.Listar Ascendentemente los Policias por Edad "
                + "\n5.Listar Según el Sueldo de los Policias "
                + "\n6.Listar Alfabeticamente al Personal Administrativo por Apellidos "
                + "\n7. Salir"
                + "\nSeleccione Opcion";
        return Integer.parseInt(Lector.leer(opciones));
    }

    public void registrarPolicia() {
        String codigo = Lector.leer("Ingrese el código del policía:");
        String nombres = Lector.leer("Ingrese los nombres del policía:");
        String apellidos = Lector.leer("Ingrese los apellidos del policía:");
        String dni = Lector.leer("Ingrese el DNI del policía:");
        int edad = Integer.parseInt(Lector.leer("Ingrese la edad del policía:"));
        int rango = Integer.parseInt(Lector.leer("Ingrese el rango del policía (1-5):"));
        double saldo = Double.parseDouble(Lector.leer("Ingrese el saldo inicial del policía:"));
        Policia policia = new Policia(edad, rango, saldo, codigo, nombres, apellidos, dni);
        ListaPolicia.add(policia);
        System.out.println("Policía registrado exitosamente!");
    }

    public void registrarPersonal() {
        String codigo = Lector.leer("Ingrese el código del personal:");
        String nombres = Lector.leer("Ingrese los nombres del personal:");
        String apellidos = Lector.leer("Ingrese los apellidos del personal:");
        String dni = Lector.leer("Ingrese el DNI del personal:");
        String sector = Lector.leer("Ingrese el sector del personal:");

        PersonalAdministrativo personal = new PersonalAdministrativo(sector, codigo, nombres, apellidos, dni);
        ListaAdministrativo.add(personal);
        System.out.println("Personal administrativo registrado exitosamente!");
    }

    public void calcularSaldo() {
        if (ListaPolicia.isEmpty()) {
            System.out.println("No hay policías registrados");
            return;
        }

        for (Policia policia : ListaPolicia) {
            policia.calcularS();
            System.out.println("Saldo calculado para " + policia.getApellidos() + ": " + policia.getSaldo());
        }
    }

    public void listarPoliciaEdad() {
        if (ListaPolicia.isEmpty()) {
            System.out.println("No hay policías registrados");
            return;
        }

        ListaPolicia.sort(Comparator.comparingInt(Policia::getEdad));

        System.out.println("Listado de policías ordenados por edad:");
        for (Policia policia : ListaPolicia) {
            System.out.println(policia.toString());
        }
    }

    public void lsitarPoliciaSueldo() {
        if (ListaPolicia.isEmpty()) {
            System.out.println("No hay policías registrados");
            return;
        }

        ListaPolicia.sort((p1, p2) -> Double.compare(p2.getSaldo(), p1.getSaldo()));

        System.out.println("Listado de policías ordenados por saldo:");
        for (Policia policia : ListaPolicia) {
            System.out.println(policia.toString());
        }
    }

    public void listarPersonal() {
        if (ListaAdministrativo.isEmpty()) {
            System.out.println("No hay personal administrativo registrado");
            return;
        }

        ListaAdministrativo.sort(Comparator.comparing(PersonalAdministrativo::getApellidos));

        System.out.println("Listado de personal administrativo ordenado por apellidos:");
        for (PersonalAdministrativo personal : ListaAdministrativo) {
            System.out.println(personal.toString());
        }
    }
}

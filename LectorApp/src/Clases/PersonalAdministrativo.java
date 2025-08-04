package Clases;


public class PersonalAdministrativo extends Persona{
    
    private String sector;

    public PersonalAdministrativo(String sector, String codigo, String nombres, String apellidos, String DNI) {
        super(codigo, nombres, apellidos, DNI);
        this.sector = sector;
    }
    
}

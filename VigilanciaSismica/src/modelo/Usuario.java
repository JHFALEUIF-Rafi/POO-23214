package modelo;

public class Usuario {

    private String username;
    private String passwordHash;
    private String rol;

    public Usuario(String username, String passwordHash, String rol) {
        this.username = username;
        this.passwordHash = passwordHash;
        this.rol = rol;
    }

    // Getters
    public String getUsername() {
        return username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public String getRol() {
        return rol;
    }

    // Setter para el hash (usado en guardarUsuario)
    public void setPasswordHash(String hash) {
        this.passwordHash = hash;
    }

    // Método para uso en formularios (no almacenar así en DB)
    public String getPassword() {
        return "";
    } // Sólo para compatibilidad
}

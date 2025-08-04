package controlador;

import modelo.Usuario;
import modelo.UsuarioDAO;
import org.mindrot.jbcrypt.BCrypt;
import vista.Login;

public class Autentificador {

    private UsuarioDAO usuarioDAO;
    private Login vista;

    public boolean autenticar(String username, String password) {
        Usuario usuario = usuarioDAO.buscarPorUsername(username);
        return BCrypt.checkpw(password, usuario.getPassword());
    }
}

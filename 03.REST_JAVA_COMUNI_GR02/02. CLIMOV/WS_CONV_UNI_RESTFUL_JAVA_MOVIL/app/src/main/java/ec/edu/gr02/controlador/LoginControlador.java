package ec.edu.gr02.controlador;

public class LoginControlador {

    public boolean login(String usuario, String clave) {

        if (usuario == null || clave == null) return false;

        if (usuario.isEmpty() || clave.isEmpty()) return false;

        return usuario.equals("monster") && clave.equals("monster9");
    }
}
package ec.edu.gr02.servicio;

import ec.edu.gr02.modelo.CredencialesUsuario;

public class LoginServicio {

    // Usuario y contraseña permitidos
    private static final String USUARIO_PERMITIDO = "Monster";
    private static final String CONTRASEÑA_PERMITIDA = "admin";

    public boolean autenticar(CredencialesUsuario credenciales) {
        // Validar que los datos no sean nulos
        if (credenciales == null ||
                credenciales.getNombreUsuario() == null ||
                credenciales.getContraseña() == null) {
            return false;
        }

        // Validar usuario y contraseña
        return credenciales.getNombreUsuario().equals(USUARIO_PERMITIDO) &&
                credenciales.getContraseña().equals(CONTRASEÑA_PERMITIDA);
    }
}
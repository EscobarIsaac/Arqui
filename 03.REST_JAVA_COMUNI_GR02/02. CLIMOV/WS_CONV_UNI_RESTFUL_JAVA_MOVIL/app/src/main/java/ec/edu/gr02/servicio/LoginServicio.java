package ec.edu.gr02.servicio;

import ec.edu.gr02.modelo.CredencialesUsuario;

public class LoginServicio {

    // Usuario y contraseña permitidos
    private static final String USUARIO_PERMITIDO = "monster";
    private static final String CONTRASEÑA_PERMITIDA = "monster9";

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
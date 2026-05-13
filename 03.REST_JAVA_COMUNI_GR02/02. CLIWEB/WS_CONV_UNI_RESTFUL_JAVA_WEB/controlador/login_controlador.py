from servicio.login_servicio import LoginServicio

class LoginControlador:

    def __init__(self):
        self.servicio = LoginServicio()

    def login(self, usuario, clave):
        return self.servicio.login(usuario, clave)
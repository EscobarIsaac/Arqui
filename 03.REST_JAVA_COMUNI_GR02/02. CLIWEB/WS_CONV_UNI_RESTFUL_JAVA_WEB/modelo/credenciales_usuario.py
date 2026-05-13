class CredencialesUsuario:

    def __init__(self, nombre_usuario, contraseña):
        self.nombre_usuario = nombre_usuario
        self.contraseña = contraseña

    def get_nombre_usuario(self):
        return self.nombre_usuario

    def set_nombre_usuario(self, nombre_usuario):
        self.nombre_usuario = nombre_usuario

    def get_contraseña(self):
        return self.contraseña

    def set_contraseña(self, contraseña):
        self.contraseña = contraseña

    def __str__(self):
        return f"CredencialesUsuario(nombre_usuario='{self.nombre_usuario}', contraseña='******')"

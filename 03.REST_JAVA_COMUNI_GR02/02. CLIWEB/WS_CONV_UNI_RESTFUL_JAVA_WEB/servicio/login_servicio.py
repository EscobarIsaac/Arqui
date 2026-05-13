class LoginServicio:

    def login(self, usuario, clave):

        if usuario is None or clave is None:
            return False

        if usuario == "" or clave == "":
            return False

        return usuario == "monster" and clave == "monster9"
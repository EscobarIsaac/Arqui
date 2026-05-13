from flask import Flask, render_template, request, redirect, url_for, flash
from controlador.login_controlador import LoginControlador
from controlador.conversion_controlador import ConversionControlador

app = Flask(__name__)
app.secret_key = "monster_secret"

login_controlador = LoginControlador()
conversion_controlador = ConversionControlador()

# LOGIN
@app.route("/", methods=["GET", "POST"])
def index():
    if request.method == "POST":
        usuario = request.form.get("usuario")
        clave = request.form.get("contraseña")

        if login_controlador.login(usuario, clave):
            return redirect(url_for("conversion"))
        else:
            flash("Credenciales incorrectas")

    return render_template("index.html")


# CONVERSION
@app.route("/conversion", methods=["GET", "POST"])
def conversion():
    resultado = None

    if request.method == "POST":
        valor = request.form.get("valor")
        origen = request.form.get("origen")
        destino = request.form.get("destino")

        if valor == "" or valor is None:
            resultado = "⚠ Ingrese un valor"
        else:
            resultado = conversion_controlador.convertir(valor, origen, destino)

    return render_template("conversion.html", resultado=resultado)


# LOGOUT
@app.route("/logout")
def logout():
    return redirect(url_for("index"))


if __name__ == "__main__":
    app.run(debug=True)
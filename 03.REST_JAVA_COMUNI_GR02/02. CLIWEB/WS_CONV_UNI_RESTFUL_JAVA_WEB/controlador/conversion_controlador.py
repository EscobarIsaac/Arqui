from servicio.conversion_servicio import ConversionServicio

class ConversionControlador:

    def __init__(self):
        self.servicio = ConversionServicio()

    def convertir(self, valor, origen, destino):
        return self.servicio.convertir(valor, origen, destino)
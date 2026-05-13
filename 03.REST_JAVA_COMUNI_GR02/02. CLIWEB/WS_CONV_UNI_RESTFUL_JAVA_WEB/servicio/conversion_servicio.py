import requests

class ConversionServicio:

    def convertir(self, valor, origen, destino):

        try:
            url = f"http://localhost:8080/WS_CONV_UNI_RESTFUL_JAVA/webresources/conversion/{valor}/{origen}/{destino}"
            response = requests.get(url)

            return response.text

        except:
            return "❌ Error al conectar con el servidor"
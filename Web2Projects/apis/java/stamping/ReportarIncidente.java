import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;

public class ReportarIncidente {

    public static void main(String[] args) throws Exception {
        // Simulamos una imagen en base64 (foto del siniestro)
        String base64Image = Base64.getEncoder().encodeToString("foto de siniestro falsa para pruebas".getBytes());

        // Información real de prueba
        String nombre = "Carlos Fernández";
        String caso = "Colisión leve en Av. Siempre Viva, La Paz";
        String firma = "Autorizado digitalmente por Carlos Fernández";

        // Token de acceso (puedes reemplazarlo si usas autenticación básica)
        String token = "98cdb8c28f159e8021b736173b9dbe8fa1d8a6d4bc68bf40f6448b05d7a";

        // Construcción del body JSON
        String jsonBody = String.format("""
        {
          "process": "75e65e0c-708a-4320-a220-adf740a6dcf7",
          "token": "%s",
          "scope": "dev",
          "params": [
            {
              "name": "photo",
              "value": "%s"
            },
            {
              "name": "name",
              "value": "%s"
            },
            {
              "name": "case",
              "value": "%s"
            },
            {
              "name": "signature",
              "value": "%s"
            }
          ]
        }
        """, token, base64Image, nombre, caso, firma);

        // Crear solicitud HTTP POST
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://api.stamping.io/exec/"))
            .header("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
            .build();

        // Enviar solicitud y mostrar respuesta
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Status: " + response.statusCode());
        System.out.println("Respuesta: " + response.body());
    }
}

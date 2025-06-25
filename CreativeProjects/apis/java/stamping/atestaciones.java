import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.MessageDigest;
import java.util.Base64;

public class atestaciones {

    public static void main(String[] args) throws Exception {
        // 1. Definir la afirmación en formato JSON (sin espacios ni saltos innecesarios)
        String json = "{\"id\":\"did:dni:pe:10203040\",\"type\":\"Constancia de trabajo\",\"subjectName\":\"Juan Perez\",\"role\":\"Jefe de Planta\",\"startOfWork\":\"01/07/2018\"}";

        // 2. Calcular SHA256 hash del JSON
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = digest.digest(json.getBytes("UTF-8"));
        StringBuilder hexHash = new StringBuilder();
        for (byte b : hashBytes) {
            hexHash.append(String.format("%02x", b));
        }
        String evidenceHash = hexHash.toString();

        // 3. Codificar JSON en Base64
        String base64Data = Base64.getEncoder().encodeToString(json.getBytes("UTF-8"));

        // 4. Token de acceso proporcionado por Stamping.io
        String token = "98cdb8c28f159e8021b736173b9dbe8fa1d8a6d4bc68bf40f6448b05d7a";

        // 5. Construir la URL de la API
        String url = String.format(
            "https://api.stamping.io/stamp/?evidence=%s&data=%s&async=true&token=%s",
            evidenceHash, base64Data, token
        );

        // 6. Crear cliente HTTP y solicitud
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .GET()
            .build();

        // 7. Enviar solicitud y mostrar respuesta
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status: " + response.statusCode());
        System.out.println("Respuesta: " + response.body());
    }
}

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class tiposMonedas {

    private JsonObject rates;

    public tiposMonedas() throws IOException, InterruptedException {
        String apiKey = "9371d1b65d5f94b158eba76d";
        String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/USD";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            Gson gson = new Gson();
            JsonObject json = gson.fromJson(response.body(), JsonObject.class);
            this.rates = json.getAsJsonObject("conversion_rates");
        } else {
            throw new IOException("No se pudo obtener la respuesta de la API.");
        }
    }

    public double obtenerTasa(String currencyCode) {
        return rates.get(currencyCode).getAsDouble();
    }
}

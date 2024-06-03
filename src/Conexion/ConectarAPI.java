package Conexion;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class ConectarAPI {
    String guardarApi = "https://v6.exchangerate-api.com/v6/6af216db4bf551cfe47c9c94/latest/DOP";

    HttpClient client = HttpClient.newHttpClient();

    HttpRequest request = HttpRequest.newBuilder().uri(URI.create(guardarApi)).build();
}
;
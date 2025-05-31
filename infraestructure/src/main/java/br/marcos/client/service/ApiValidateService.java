package br.marcos.client.service;

import br.marcos.client.dto.ApiValidateResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.coyote.BadRequestException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiValidateService {
    //TODO: Em um cenário real, moveria para um arquivo .env. Estou deixando hardcode para simplificar
    private final String API_URL = "https://run.mocky.io/v3/66cc7d12-5aa2-4e89-ab55-faa7dea4459c";

    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    public ApiValidateService() {
        this.httpClient = HttpClient.newBuilder().build();
        this.objectMapper = new ObjectMapper();
    }

    public ApiValidateResponse validate() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (!(response.statusCode() >= 200 && response.statusCode() < 300)) {
            System.err.println("Erro na requisição. Status: " + response.statusCode() + ", Corpo: " + response.body());
            throw new BadRequestException("Houve um erro ao enviar a requisição");
        }

        return objectMapper.readValue(response.body(), new TypeReference<ApiValidateResponse>() {});
    }
}
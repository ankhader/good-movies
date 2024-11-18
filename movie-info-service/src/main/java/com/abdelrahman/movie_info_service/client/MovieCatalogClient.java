package com.abdelrahman.movie_info_service.client;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class MovieCatalogClient {

    public void getMovieCatalog() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> exchange = restTemplate.exchange("http://localhost:8081/api/v1/catalog/123", HttpMethod.GET, null, String.class);
        System.out.println(exchange.getBody());
    }

    public static void main(String[] args) {
        MovieCatalogClient client = new MovieCatalogClient();
        client.getMovieCatalog();
    }
}


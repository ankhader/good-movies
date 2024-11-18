package com.abdelrahman.movie_catalog_service.controllers;

import com.abdelrahman.movie_catalog_service.models.CatalogItem;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(MovieCatalogController.ACCOUNT_CUSTOMER_DETAILS_REQUEST_MAPPING)
public class MovieCatalogController {
    public static final String ACCOUNT_CUSTOMER_DETAILS_REQUEST_MAPPING = "/api/v1/catalog";

    @GetMapping("/{userId}")
    public CatalogItem getCatalogItem(String id) {
        return new CatalogItem("sameer","mahmood",101);
    }
}

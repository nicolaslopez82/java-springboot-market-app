package com.nicolaslopez82.market.web.controller;

import com.nicolaslopez82.market.domain.Product;
import com.nicolaslopez82.market.domain.Purchase;
import com.nicolaslopez82.market.domain.service.PurchaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchases")
@Tag(name = "Purchase", description = "Purchases API")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("/all")
    @Operation(summary = "Get all supermarket Purchases.", description = "Get all supermarket Purchases.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Purchase.class)) }),
            @ApiResponse(responseCode = "404", description = "Purchases not found", content = @Content)
    })
    public ResponseEntity<List<Purchase>> getPurchases() {
        return new ResponseEntity<>(purchaseService.findAll(), HttpStatus.OK) ;
    }

    @GetMapping("/purchase/{clientId}")
    @Operation(summary = "Get a List of Purchases by Client's ID.", description = "Get a List of Purchases by Client's ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Purchase.class)) }),
            @ApiResponse(responseCode = "404", description = "Products not found", content = @Content)
    })
    public ResponseEntity<List<Purchase>> getPurchasesByClientId(@Parameter(description = "The Client's ID", required = true, example = "4546221")
                                                                 @PathVariable("clientId") String clientId) {
        return purchaseService.getByClient(clientId)
                .map(purchases -> new ResponseEntity<>(purchases, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    @Operation(summary = "Save a Purchase.", description = "Save a Purchase in the DataBase.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "CREATED",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Product.class)) }),
            @ApiResponse(responseCode = "500", description = "500 Internal Server Error", content = @Content)
    })
    public ResponseEntity<Purchase> save(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Product to create", required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Product.class),
                            examples = @ExampleObject(
                                    name = "Purchase Example",
                                    value = "{\n" +
                                            "    \"clientId\": \"983824\",\n" +
                                            "    \"date\": \"2013-08-10T17:30:00\",\n" +
                                            "    \"paymentMethod\": \"E\",\n" +
                                            "    \"comment\": \"Fuscia\",\n" +
                                            "    \"state\": \"P\",\n" +
                                            "    \"purchaseItemList\": [\n" +
                                            "        {\n" +
                                            "            \"productId\": 5,\n" +
                                            "            \"quantity\": 5,\n" +
                                            "            \"totalPrice\": 20000.0,\n" +
                                            "            \"purchased\": true\n" +
                                            "        },\n" +
                                            "        {\n" +
                                            "            \"productId\": 8,\n" +
                                            "            \"quantity\": 2,\n" +
                                            "            \"totalPrice\": 300.0,\n" +
                                            "            \"purchased\": true\n" +
                                            "        },\n" +
                                            "        {\n" +
                                            "            \"productId\": 28,\n" +
                                            "            \"quantity\": 10,\n" +
                                            "            \"totalPrice\": 20000.0,\n" +
                                            "            \"purchased\": true\n" +
                                            "        }\n" +
                                            "    ]\n" +
                                            "}")))
            @RequestBody Purchase purchase) {
        return new ResponseEntity<>(purchaseService.save(purchase), HttpStatus.CREATED);
    }
}

package com.nicolaslopez82.market.web.controller;

import com.nicolaslopez82.market.domain.Product;
import com.nicolaslopez82.market.domain.service.ProductService;
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
@RequestMapping("/products")
@Tag(name = "Products", description = "Products API")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/all")
    @Operation(summary = "Get all supermarket Products.", description = "Get all supermarket Products.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Product.class)) }),
            @ApiResponse(responseCode = "404", description = "Products not found", content = @Content)
    })
    public ResponseEntity<List<Product>> getProduct(){
       return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a Product by ID's Product.", description = "Get a Product by ID's Product.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Product.class)) }),
            @ApiResponse(responseCode = "404", description = "Products not found", content = @Content)
    })
    public ResponseEntity<Product> getProduct(@Parameter(description = "The Product's ID", required = true, example = "7")
                                              @PathVariable("id") int productId){
        return productService.getProduct(productId)
                .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/category/{categoryId}")
    @Operation(summary = "Get a List of Product by Category ID.", description = "Get a List of Product by Category ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Product.class)) }),
            @ApiResponse(responseCode = "404", description = "Products not found", content = @Content)
    })
    public ResponseEntity<List<Product>> getProductsByCategoryId(@Parameter(description = "The Category ID", required = true, example = "8")
                                                                 @PathVariable("categoryId") int categoryId){
        return productService.getProductsByCategoryId(categoryId)
                .map(products -> new ResponseEntity<>(products, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    @Operation(summary = "Save a Product.", description = "Save a Product in the DataBase.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "CREATED",
                    content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Product.class)) }),
            @ApiResponse(responseCode = "500", description = "500 Internal Server Error", content = @Content)
    })
    public ResponseEntity<Product> save(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Product to create", required = true,
                    content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Product.class),
                    examples = @ExampleObject(
                            name = "Product Example",
                            value = "{ \"productName\": \"Cafe\", " +
                                      "\"categoryId\": \"8\", " +
                                      "\"price\": \"12000.0\", " +
                                      "\"stock\": \"1500\", " +
                                      "\"active\": \"true\" }")))
            @RequestBody Product product){
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete a Product.", description = "Delete a Product in the DataBase identify by Product ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK",
                    content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Product.class)) }),
            @ApiResponse(responseCode = "404", description = "Products not found", content = @Content)
    })
    public ResponseEntity deleteProduct(@Parameter(description = "The Product's ID", required = true, example = "50")
                                        @PathVariable("id") int productId){
        if(productService.delete(productId)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

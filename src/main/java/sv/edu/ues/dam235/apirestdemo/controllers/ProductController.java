package sv.edu.ues.dam235.apirestdemo.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sv.edu.ues.dam235.apirestdemo.dtos.ProductsDTO;
import sv.edu.ues.dam235.apirestdemo.services.ProductServices;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/products")
public class ProductController {
    final private ProductServices productServices;
    public ProductController(ProductServices productServices) {
        this.productServices = productServices;
    }
    @GetMapping
    public ResponseEntity<List<ProductsDTO>> getAllItems() {

        try {
            List<ProductsDTO> items = productServices.getAllProducts();
            if (items.isEmpty()) {
                return ResponseEntity.status(204).build();
            } else {
                return ResponseEntity.ok(items);
            }
        } catch (Exception e) {
            log.error("Error al obtener todos los productos: " + e.getMessage(), e);

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
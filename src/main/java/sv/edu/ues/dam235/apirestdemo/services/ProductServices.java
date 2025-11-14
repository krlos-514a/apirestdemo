package sv.edu.ues.dam235.apirestdemo.services;

import sv.edu.ues.dam235.apirestdemo.dtos.ProductsDTO;

import java.util.List;

public interface ProductServices {
    public List<ProductsDTO> getAllProducts();
}
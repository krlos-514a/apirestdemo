package sv.edu.ues.dam235.apirestdemo.implementations;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sv.edu.ues.dam235.apirestdemo.dtos.ProductsDTO;
import sv.edu.ues.dam235.apirestdemo.entities.Product;
import sv.edu.ues.dam235.apirestdemo.repositories.ProductRepository;
import sv.edu.ues.dam235.apirestdemo.services.ProductServices;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ProductsImpl implements ProductServices {
    private final ProductRepository productRepository;
    private ProductsImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public List<ProductsDTO> getAllProducts() {
        List<ProductsDTO> result = new ArrayList<>();
        List<Product> items = this.productRepository.findAll();
        for (Product item : items) {
            result.add(new ProductsDTO(item.getCode(), item.getName(),
                    item.isStatus()));
        }
        return result;
    }
}
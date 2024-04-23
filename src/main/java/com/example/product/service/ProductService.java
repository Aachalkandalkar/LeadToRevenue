package com.example.product.service;

import com.example.product.errorHandling.ResourceNotFoundException;
import com.example.product.model.Product;
import com.example.product.repository.IProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private IProductRepo iProductRepo;


    public Product createProduct(Product product) {
        return iProductRepo.save(product);
    }

    public Product getProductById(int productId) {
       return iProductRepo.findById(productId).orElse(null);
    }


    public List<Product> getAllProduct() {
        return iProductRepo.findAll();
    }

    public Product updateProduct(Product product) {
        return iProductRepo.save(product);
    }

    public boolean deleteProduct(int productId) {
        if (!iProductRepo.existsById(productId)) {
            throw new ResourceNotFoundException("Product", "productId", productId);
        }
        iProductRepo.deleteById(productId);
        return true;
    }
}

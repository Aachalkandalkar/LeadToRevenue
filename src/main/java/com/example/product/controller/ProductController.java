package com.example.product.controller;

import com.example.product.model.Product;
import com.example.product.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    //create a product
    @PostMapping("/create")
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        Product createProduct =  productService.createProduct(product);
        return new ResponseEntity<>(createProduct, HttpStatus.CREATED);
    }

    //Get Product by Id
    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable int productId){
       Product getProduct =  productService.getProductById(productId);
       if(getProduct != null){
           return new ResponseEntity<>(getProduct,HttpStatus.OK);
       }else{
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
    }

    //Get All Products
    @GetMapping("/")
    public ResponseEntity<List<Product>> getAllProduct(){
      List<Product> products = productService.getAllProduct();
      if(products.isEmpty()){
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }else{
          return new ResponseEntity<>(products,HttpStatus.OK);
      }
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable int productId , @Valid @RequestBody Product product){
        Product updateProduct = productService.updateProduct(product);
        if(updateProduct != null){
            return new ResponseEntity<>(updateProduct,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //delete product
    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int productId){
        boolean deleteProduct = productService.deleteProduct(productId);
        if(deleteProduct){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }










}

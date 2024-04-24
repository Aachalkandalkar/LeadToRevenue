package com.example.product.service;

import com.example.product.errorHandling.ResourceNotFoundException;
import com.example.product.model.*;
import com.example.product.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Attr;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private IProductRepo productRepo;

    @Autowired
    private ICategoryRepo categoryRepo;

    @Autowired
    private IAttributeRepo attributeRepo;

    @Autowired
    private IAvailabilityRepo availabilityRepo;

    @Autowired
    private IRatingsRepo ratingRepo;

    @Transactional
    public Product createProduct(Product product) {
        Product toSave = new Product();
        toSave.setProductName(product.getProductName());
        toSave.setDescription(product.getDescription());
        toSave.setPrice(product.getPrice());

        // Save the product
        Product savedProduct = productRepo.save(toSave);

        // Save categories
        for (Category catToSave : product.getCategories()) {
            Category newCategory = new Category();
            newCategory.setName(catToSave.getName());
            newCategory.setProduct(savedProduct);
            Category savedCategory = categoryRepo.save(newCategory);
            System.out.println("Saved Category: " + savedCategory);
        }

        // Save attributes
        for (Attribute attrToSave : product.getAttributes()) {
            Attribute newAttribute = new Attribute();
            newAttribute.setName(attrToSave.getName());
            newAttribute.setValue(attrToSave.getValue());
            newAttribute.setProduct(savedProduct);
            Attribute savedAttribute = attributeRepo.save(newAttribute);
            System.out.println("Saved Attribute: " + savedAttribute);
        }

        // Save availability
        Availability availability = new Availability();
        availability.setInStock(product.getAvailability().isInStock());
        availability.setQuantity(product.getAvailability().getQuantity());
        availability.setProduct(savedProduct);
        Availability savedAvailability = availabilityRepo.save(availability);
        System.out.println("Saved Availability: " + savedAvailability);

        // Save ratings
        for (Rating ratingToSave : product.getRating()) {
            Rating newRating = new Rating();
            newRating.setUserId(ratingToSave.getUserId());
            newRating.setRating(ratingToSave.getRating());
            newRating.setComment(ratingToSave.getComment());
            newRating.setProduct(savedProduct);
            Rating savedRating = ratingRepo.save(newRating);
            System.out.println("Saved Rating: " + savedRating);
        }
        return savedProduct;
    }


    public Product getProductById(int productId) {
        Product newProduct = new Product();

        Product product = productRepo.findById(productId).orElse(null);
        newProduct.setProductId(product.getProductId());

        List<Attribute> attributes = product.getAttributes();
        for(Attribute attribute : attributes) {
            attribute.setProduct(newProduct);
        }
        List<Category> categories = product.getCategories();
        for(Category category : categories) {
            category.setProduct(newProduct);
        }
        List<Rating> ratings = product.getRating();
        for(Rating rating : ratings) {
            rating.setProduct(newProduct);
        }
        product.getAvailability().setProduct(newProduct);

        return product;
    }

    public List<Product> getAllProduct() {
        Product newProduct = new Product();
        List<Product> products = productRepo.findAll();
        for(Product product : products) {
            newProduct.setProductId(product.getProductId());
            List<Attribute> attributes = product.getAttributes();
            for(Attribute attribute : attributes) {
                attribute.setProduct(newProduct);
            }
            List<Category> categories = product.getCategories();
            for(Category category : categories) {
                category.setProduct(newProduct);
            }
            List<Rating> ratings = product.getRating();
            for(Rating rating : ratings) {
                rating.setProduct(newProduct);
            }

            product.getAvailability().setProduct(newProduct);
        }
        return products;
    }

    public Product updateProduct(Product product) {
        return productRepo.save(product);
    }

    public boolean deleteProduct(int productId) {
        if (!productRepo.existsById(productId)) {
            throw new ResourceNotFoundException("Product", "productId", productId);
        }
        productRepo.deleteById(productId);
        return true;
    }
}






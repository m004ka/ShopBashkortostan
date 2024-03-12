package org.urr.shopbashkortostan.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.urr.shopbashkortostan.models.Product;
import org.urr.shopbashkortostan.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;



@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public Product updateProduct(Long id, Product updatedProduct) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

        existingProduct.setName(updatedProduct.getName());
        existingProduct.setPrice(updatedProduct.getPrice());
        existingProduct.setPricePerSquareMeter(updatedProduct.getPricePerSquareMeter());
        existingProduct.setLength(updatedProduct.getLength());
        existingProduct.setDensity(updatedProduct.getDensity());
        existingProduct.setThickness(updatedProduct.getThickness());
        existingProduct.setDescription(updatedProduct.getDescription());
        existingProduct.setPhoto(updatedProduct.getPhoto());
        existingProduct.setAvailable(updatedProduct.isAvailable());
        existingProduct.setAvailabilityCounter(updatedProduct.getAvailabilityCounter());
        existingProduct.setWeight(updatedProduct.getWeight());

        return productRepository.save(existingProduct);
    }
}
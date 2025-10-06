package org.siteshkumar.ims_backend.controller;

import java.util.List;
import org.siteshkumar.ims_backend.model.ProductModel;
import org.siteshkumar.ims_backend.service.ProductService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping("/products")
    public boolean createProduct(@RequestBody ProductModel productModel){
        return productService.createProduct(productModel);
    }

    @GetMapping("/products")
    public List<ProductModel> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public ProductModel getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @GetMapping("/products/below-threshold")
    public List<ProductModel> getAllProductsBelowThreshold(@RequestParam Long threshold){
        return productService.getAllProductsBelowThreshold(threshold);
    }
    
    @PutMapping("products/{id}")
    public ProductModel updateProduct(@PathVariable Long id, @RequestBody ProductModel productModel){
        return productService.updateProduct(id, productModel);
    }

    @PutMapping("products/increase/{id}")
    public ProductModel increaseStockQuantity(@PathVariable Long id, @RequestParam Long increaseBy){
        return productService.increaseStockQuantity(id, increaseBy);
    }

    @PutMapping("products/decrease/{id}")
    public ProductModel decreaseStockQuantity(@PathVariable Long id, @RequestParam Long decreaseBy){
        return productService.decreaseStockQuantity(id, decreaseBy);
    }

    @DeleteMapping("products/{id}")
    public boolean deleteProduct(@PathVariable Long id){
        return productService.deleteProduct(id);
    }
}

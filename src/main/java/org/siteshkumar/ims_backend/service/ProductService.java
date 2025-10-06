package org.siteshkumar.ims_backend.service;

import java.util.List;

import org.siteshkumar.ims_backend.model.ProductModel;

public interface ProductService {
    public boolean createProduct(ProductModel productModel);
    public List<ProductModel> getAllProducts();
    public ProductModel getProductById(Long id);
    public List<ProductModel> getAllProductsBelowThreshold(Long threshold);
    public ProductModel updateProduct(Long id, ProductModel productModel);
    public ProductModel increaseStockQuantity(Long id, Long increaseBy);
    public ProductModel decreaseStockQuantity(Long id, Long decreaseBy);
    public boolean deleteProduct(Long id);
}

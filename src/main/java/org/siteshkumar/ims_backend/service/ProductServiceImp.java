package org.siteshkumar.ims_backend.service;

import java.util.ArrayList;
import java.util.List;

import org.siteshkumar.ims_backend.entity.ProductEntity;
import org.siteshkumar.ims_backend.mapper.ProductMapper;
import org.siteshkumar.ims_backend.model.ProductModel;
import org.siteshkumar.ims_backend.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImp implements ProductService{
    
    private final ProductRepository productRepository;

    public ProductServiceImp(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public boolean createProduct(ProductModel productModel){
        ProductEntity productEntity = ProductMapper.modelToEntity(productModel);
        ProductEntity savedEntity = productRepository.save(productEntity);

        if(savedEntity.getId() != null)
            return true;
        return false;
    }

    @Override
    public List<ProductModel> getAllProducts(){
        List<ProductEntity> productEntity = productRepository.findAll();

        List<ProductModel> result = new ArrayList<ProductModel>();
        for(ProductEntity pe : productEntity){
            ProductModel pm = ProductMapper.entityToModel(pe);

            result.add(pm);
        }
        return result;
    }

    @Override
    public ProductModel getProductById(Long id) {
    ProductEntity pe = productRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Product not found, Please provide the correct id"));
    return ProductMapper.entityToModel(pe);
}


    @Override
    public List<ProductModel> getAllProductsBelowThreshold(Long threshold){
        List<ProductEntity> productEntity = productRepository.findAll();

        List<ProductModel> productModel = new ArrayList<>();
        for(ProductEntity pe : productEntity){
            if(pe.getStockQuantity() < threshold){
                ProductModel pm = ProductMapper.entityToModel(pe);
                productModel.add(pm);
            }
        }
        return productModel;
    }

    @Override
    public ProductModel updateProduct(Long id, ProductModel productModel){
        ProductEntity pe = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found please provide the correct id"));
        
        if(productModel.getProductName() != null)
            pe.setProductName(productModel.getProductName());

        if(productModel.getDescription() != null)
            pe.setDescription(productModel.getDescription());

        if(productModel.getStockQuantity() != null){
            if (productModel.getStockQuantity() < 0)
                throw new IllegalArgumentException("Stock quantity cannot be less than zero");

            pe.setStockQuantity(productModel.getStockQuantity());
        }

        productRepository.save(pe);
        ProductEntity resultEntity = productRepository.findById(id).get();
        ProductModel resultModel = ProductMapper.entityToModel(resultEntity);
        return resultModel;
    }

    @Override
    public ProductModel increaseStockQuantity(Long id, Long increaseBy){
        if(increaseBy < 0)
            throw new IllegalArgumentException("Increase value cannot be negative");

        ProductEntity pe = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found please provide the correct id"));

        Long currStockQuantity = pe.getStockQuantity();
        Long reqStockQuantity = currStockQuantity + increaseBy;
        pe.setStockQuantity(reqStockQuantity);

        ProductEntity productEntity = productRepository.save(pe);
        return ProductMapper.entityToModel(productEntity);
    }

    @Override
    public ProductModel decreaseStockQuantity(Long id, Long decreaseBy){
        ProductEntity pe = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found please provide the correct id"));

        Long currStockQuantity = pe.getStockQuantity();
        if(decreaseBy > currStockQuantity)
            throw new IllegalArgumentException("Cannot decrease stock below zero");

        Long reqStockQuantity = currStockQuantity - decreaseBy;
        pe.setStockQuantity(reqStockQuantity);

        ProductEntity productEntity = productRepository.save(pe);
        return ProductMapper.entityToModel(productEntity);
    }


    @Override
    public boolean deleteProduct(Long id){
        ProductEntity pe = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found, Please provide the correct id"));

        productRepository.delete(pe);
        return true;
    }
}

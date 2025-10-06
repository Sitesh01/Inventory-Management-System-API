package org.siteshkumar.ims_backend.mapper;

import org.siteshkumar.ims_backend.entity.ProductEntity;
import org.siteshkumar.ims_backend.model.ProductModel;

public class ProductMapper {

    public static ProductModel entityToModel(ProductEntity entity) {
        if(entity == null)
            return null;

        return new ProductModel(
            entity.getId(),
            entity.getProductName(),
            entity.getDescription(),
            entity.getStockQuantity()
        );
    }

    public static ProductEntity modelToEntity(ProductModel model){
        if(model == null)
            return null;

        return new ProductEntity(
            model.getId(),
            model.getProductName(),
            model.getDescription(),
            model.getStockQuantity()
        );
    }
}

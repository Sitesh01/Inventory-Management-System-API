package org.siteshkumar.ims_backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductModel {
    private Long id;
    private String productName;
    private String description;
    private Long stockQuantity;
}

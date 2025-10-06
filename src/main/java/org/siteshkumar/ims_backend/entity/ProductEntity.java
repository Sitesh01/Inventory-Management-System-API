package org.siteshkumar.ims_backend.entity;

import org.hibernate.annotations.Check;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="products")
@Check(constraints = "stock_quantity >= 0")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String productName;
    private String description;

    @Column(name="stock_quantity")
    private Long stockQuantity;
}

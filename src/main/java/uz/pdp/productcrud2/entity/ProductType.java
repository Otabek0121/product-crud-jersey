package uz.pdp.productcrud2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "product_type")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductType {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private String description;

    private Timestamp createdAt;

    private Timestamp updatedAt;

    private boolean deleted=true;
}

package uz.pdp.productcrud2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "product_status")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String name;

    private Timestamp createdAt;

    private Timestamp updatedAt;

    private boolean deleted=true;

}

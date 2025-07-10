package uz.pdp.productcrud2.service;


import uz.pdp.productcrud2.entity.Product;
import uz.pdp.productcrud2.entity.ProductStatus;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductStatusService {

    ProductStatus save(ProductStatus productStatus);

    ProductStatus update(ProductStatus productStatus);

    void deleteById(UUID id);

    Optional<ProductStatus> findById(UUID id);

    List<ProductStatus> findAll();

}

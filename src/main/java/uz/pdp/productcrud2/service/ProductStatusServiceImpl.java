package uz.pdp.productcrud2.service;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import uz.pdp.productcrud2.entity.Product;
import uz.pdp.productcrud2.entity.ProductStatus;
import uz.pdp.productcrud2.repository.ProductStatusRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Singleton
public class ProductStatusServiceImpl implements ProductStatusService {

    private ProductStatusRepository productStatusRepository;

    @Inject
    public ProductStatusServiceImpl(ProductStatusRepository productStatusRepository) {
        this.productStatusRepository = productStatusRepository;
    }


    @Override
    public ProductStatus save(ProductStatus productStatus) {
        return productStatusRepository.save(productStatus);
    }

    @Override
    public ProductStatus update(ProductStatus productStatus) {
        return productStatusRepository.update(productStatus);
    }

    @Override
    public void deleteById(UUID id) {
        productStatusRepository.deleteById(id);
    }

    @Override
    public Optional<ProductStatus> findById(UUID id) {
        return productStatusRepository.findById(id);
    }

    @Override
    public List<ProductStatus> findAll() {
        return productStatusRepository.findAll();
    }
}

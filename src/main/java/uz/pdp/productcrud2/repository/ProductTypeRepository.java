package uz.pdp.productcrud2.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.ws.rs.NotFoundException;
import uz.pdp.productcrud2.entity.ProductStatus;
import uz.pdp.productcrud2.entity.ProductType;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public class ProductTypeRepository {

    private final EntityManager em;

    public ProductTypeRepository(EntityManager em) {
        this.em = Persistence.createEntityManagerFactory("product-crud").createEntityManager();
    }

    public ProductType save(ProductType productType) {
        em.getTransaction().begin();
        em.persist(productType);
        em.getTransaction().commit();
        return productType;
    }

    public Optional<ProductType> findById(UUID id) {
        em.getTransaction().begin();
        ProductType productType = em.find(ProductType.class, id);
        em.getTransaction().commit();
        return productType != null ? Optional.of(productType) : Optional.empty();
    }

    @SuppressWarnings("unchecked")
    public List<ProductStatus> findAll() {
        return em.createQuery("from ProductStatus where deleted=true").getResultList();
    }

    public ProductType update(ProductType productType) {
        em.getTransaction().begin();
        productType = em.merge(productType);
        em.getTransaction().commit();
        return productType;
    }

    public void deleteById(UUID id) {
        em.getTransaction().begin();
        ProductType productType = em.find(ProductType.class, id);
        if (Objects.isNull(productType)) {
            throw new NotFoundException("Product type not found with id: " + id);
        }
        productType.setDeleted(true);
        em.merge(productType);
        em.getTransaction().commit();
    }

}

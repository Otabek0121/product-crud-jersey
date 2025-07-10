package uz.pdp.productcrud2.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.ws.rs.NotFoundException;
import uz.pdp.productcrud2.entity.ProductStatus;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public class ProductStatusRepository {

    private final EntityManager em;

    public ProductStatusRepository(EntityManager em) {
        this.em = Persistence.createEntityManagerFactory("product-crud").createEntityManager();
    }

    public ProductStatus save(ProductStatus productStatus) {
        em.getTransaction().begin();
        em.persist(productStatus);
        em.getTransaction().commit();
        return productStatus;
    }

    public Optional<ProductStatus> findById(UUID id) {
        em.getTransaction().begin();
        ProductStatus productStatus = em.find(ProductStatus.class, id);
        em.getTransaction().commit();
        return productStatus != null ? Optional.of(productStatus) : Optional.empty();
    }

    @SuppressWarnings("unchecked")
    public List<ProductStatus> findAll() {
        return em.createQuery("from ProductStatus where deleted=true").getResultList();
    }

    public ProductStatus update(ProductStatus productStatus) {
        em.getTransaction().begin();
        productStatus = em.merge(productStatus);
        em.getTransaction().commit();
        return productStatus;
    }

    public void deleteById(UUID id) {
        em.getTransaction().begin();
        ProductStatus productStatus = em.find(ProductStatus.class, id);
        if (Objects.isNull(productStatus)) {
            throw new NotFoundException("Product status not found with id: " + id);
        }
        productStatus.setDeleted(true);
        em.merge(productStatus);
        em.getTransaction().commit();
    }

}

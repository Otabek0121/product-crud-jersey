package uz.pdp.productcrud2.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.ws.rs.NotFoundException;
import uz.pdp.productcrud2.entity.Product;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public class ProductRepository {

    private final EntityManager em;

    public ProductRepository() {
        this.em = Persistence.createEntityManagerFactory("product-crud").createEntityManager();
    }

    public Product save(Product product) {
        em.getTransaction().begin();
        em.persist(product);
        em.getTransaction().commit();
        return product;
    }

    public Optional<Product> findById(UUID id) {
        em.getTransaction().begin();
        Product product = em.find(Product.class, id);
        em.getTransaction().commit();
        return product != null ? Optional.of(product) : Optional.empty();
    }

    @SuppressWarnings("unchecked")
    public List<Product> findAll() {
        return em.createQuery("from Product").getResultList();
    }

    public Product update(Product product) {
        em.getTransaction().begin();
        product = em.merge(product);
        em.getTransaction().commit();
        return product;
    }

    public void deleteById(UUID id) {
        em.getTransaction().begin();
        Product product = em.find(Product.class, id);
        if (Objects.isNull(product)) {
            throw new NotFoundException("Product not found with id: " + id);
        }
        product.setDeleted(true);
        em.merge(product);
        em.getTransaction().commit();
    }

//    public void close() {
//        emf.close();
//    }

}

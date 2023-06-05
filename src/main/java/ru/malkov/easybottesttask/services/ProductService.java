package ru.malkov.easybottesttask.services;

import org.springframework.stereotype.Service;
import ru.malkov.easybottesttask.abstractClasses.Product;
import ru.malkov.easybottesttask.exceptions.ProductTypeCastException;
import ru.malkov.easybottesttask.repositories.ProductRepository;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Service for all {@link Product} children. Should be parametrized with specific child type.
 * @param <T> -- specific child type.
 */
@Service
public class ProductService<T extends Product> {
    private final ProductRepository<T> repository;

    public ProductService(ProductRepository<T> repository) {
        this.repository = repository;
    }

    /**
     * Add new object to the database.
     * @param product -- entity to add.
     * @return the added entity.
     */
    public T addProduct(T product) {
        return repository.save(product);
    }

    /**
     * Updates product with given id. Uses given entity as source of values for the target object.
     * @param id -- id of entity that should be updated.
     * @param source -- entity containing new values for the target.
     * @return -- updated target.
     * @throws ProductTypeCastException -- thrown if {@link Product} can not be cast to the specific child type.
     */
    public T updateProduct(Long id, T source) throws ProductTypeCastException {
        T pcToUpdate = repository.getReferenceById(id);
        pcToUpdate.update(source);
        return repository.save(pcToUpdate);
    }

    /**
     * Searches for all objects of given class in the database.
     * @param clazz -- the class of the searched entities.
     * @return list of all found entities.
     */
    public List<T> getAllProducts(Class<? extends T> clazz) {
        return repository.findAllByType(clazz);
    }

    /**
     * Returns an entity with given id from the database.
     * @param id -- id of the requested entity.
     * @return -- found entity.
     * @throws NoSuchElementException -- thrown if the database contains no objects with given id.
     */
    public T getProductById(Long id) throws NoSuchElementException {
        return repository.findById(id).orElseThrow();
    }

    /**
     * Removes an objects with given id from the database.
     * @param id -- id of the requested entity.
     * @return -- message of successful deletion.
     */
    public String deleteById(Long id) {
        repository.deleteById(id);
        return "Deletion executed successfully.";
    }
}
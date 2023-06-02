package ru.malkov.easybottesttask.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.malkov.easybottesttask.abstractClasses.Product;

import java.util.List;

@Repository
public interface ProductRepository<T extends Product> extends JpaRepository<T, Long> {
    List<T> findAllByOrderBySerialNumberAsc();
}

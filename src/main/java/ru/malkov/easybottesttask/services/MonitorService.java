package ru.malkov.easybottesttask.services;

import org.springframework.stereotype.Service;
import ru.malkov.easybottesttask.entities.Monitor;
import ru.malkov.easybottesttask.repositories.MonitorRepository;

import java.util.List;

@Service
public class MonitorService implements ProductService<Monitor>{
    private final MonitorRepository repository;

    public MonitorService(MonitorRepository repository) {
        this.repository = repository;
    }

    @Override
    public Monitor addProduct(Monitor product) {
        return repository.save(product);
    }

    @Override
    public Monitor updateProduct(Long id, Monitor source) {
        Monitor pcToUpdate = repository.getReferenceById(id);
        updateProduct(pcToUpdate, source);
        return repository.save(pcToUpdate);
    }

    @Override
    public List<Monitor> getAllProducts() {
        return repository.findAllByOrderBySerialNumberAsc();
    }

    @Override
    public Monitor getProductById(Long id) {
        return repository.getReferenceById(id);
    }

    private void updateProduct(Monitor target, Monitor source) {
        ProductService.super.updateProduct(target, source);
        if(source.getDiagonal() != null){
            target.setDiagonal(source.getDiagonal());
        }
    }
}
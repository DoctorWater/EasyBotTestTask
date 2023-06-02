package ru.malkov.easybottesttask.services;

import org.springframework.stereotype.Service;
import ru.malkov.easybottesttask.entities.HardDrive;
import ru.malkov.easybottesttask.repositories.HardDriveRepository;

import java.util.List;

@Service
public class HardDriveService implements ProductService<HardDrive>{
    private final HardDriveRepository repository;

    public HardDriveService(HardDriveRepository repository) {
        this.repository = repository;
    }

    @Override
    public HardDrive addProduct(HardDrive product) {
        return repository.save(product);
    }

    @Override
    public HardDrive updateProduct(Long id, HardDrive source) {
        HardDrive pcToUpdate = repository.getReferenceById(id);
        updateProduct(pcToUpdate, source);
        return repository.save(pcToUpdate);
    }

    @Override
    public List<HardDrive> getAllProducts() {
        return repository.findAllByOrderBySerialNumberAsc();
    }

    @Override
    public HardDrive getProductById(Long id) {
        return repository.getReferenceById(id);
    }

    private void updateProduct(HardDrive target, HardDrive source) {
        ProductService.super.updateProduct(target, source);
        if(source.getMemorySize() != null){
            target.setMemorySize(source.getMemorySize());
        }
    }
}
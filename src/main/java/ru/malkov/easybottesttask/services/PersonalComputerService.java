package ru.malkov.easybottesttask.services;

import org.springframework.stereotype.Service;
import ru.malkov.easybottesttask.abstractClasses.Product;
import ru.malkov.easybottesttask.entities.PersonalComputer;
import ru.malkov.easybottesttask.repositories.PersonalComputerRepository;
import ru.malkov.easybottesttask.repositories.ProductRepository;

import java.util.List;

@Service
public class PersonalComputerService implements ProductService<PersonalComputer>{
    private final ProductRepository<PersonalComputer> repository;

    public PersonalComputerService(ProductRepository<PersonalComputer> repository) {
        this.repository = repository;
    }

    @Override
    public PersonalComputer addProduct(PersonalComputer product) {
        return repository.save(product);
    }

    @Override
    public PersonalComputer updateProduct(Long id, PersonalComputer source) {
        PersonalComputer pcToUpdate = repository.getReferenceById(id);
        updateProduct(pcToUpdate, source);
        return repository.save(pcToUpdate);
    }

    @Override
    public List<PersonalComputer> getAllProducts() {
        return repository.findAllByOrderBySerialNumberAsc();
    }

    @Override
    public PersonalComputer getProductById(Long id) {
        return repository.getReferenceById(id);
    }

    private void updateProduct(PersonalComputer target, PersonalComputer source) {
        ProductService.super.updateProduct(target, source);
        if(source.getFormFactor() != null){
            target.setFormFactor(source.getFormFactor());
        }
    }
}
package ru.malkov.easybottesttask.controllers;

import org.springframework.web.bind.annotation.*;
import ru.malkov.easybottesttask.entities.PersonalComputer;
import ru.malkov.easybottesttask.exceptions.ProductTypeCastException;
import ru.malkov.easybottesttask.services.ProductService;

import java.util.List;

@RestController
@RequestMapping(value = "pc")
public class PersonalComputerController {
    private final ProductService<PersonalComputer> service;

    public PersonalComputerController(ProductService<PersonalComputer> service) {
        this.service = service;
    }

    @PostMapping(value = "/add")
    public PersonalComputer addNewLaptop(@RequestBody PersonalComputer entity) {
        return service.addProduct(entity);
    }

    @PatchMapping(value = "/update")
    public PersonalComputer updateLaptop(@RequestBody PersonalComputer entity, @RequestParam Long id) throws ProductTypeCastException {
        return service.updateProduct(id, entity);
    }

    @GetMapping(value = "/get-all")
    public List<PersonalComputer> getAllLaptops() {
        return service.getAllProducts(PersonalComputer.class);
    }

    @GetMapping(value = "/get")
    public PersonalComputer getById(@RequestParam Long id) {
        return service.getProductById(id);
    }

    @DeleteMapping(value = "/delete")
    public String deleteById(@RequestParam Long id) {
        return service.deleteById(id);
    }
}
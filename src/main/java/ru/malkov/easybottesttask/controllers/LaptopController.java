package ru.malkov.easybottesttask.controllers;

import org.springframework.web.bind.annotation.*;
import ru.malkov.easybottesttask.entities.Laptop;
import ru.malkov.easybottesttask.exceptions.ProductTypeCastException;
import ru.malkov.easybottesttask.services.ProductService;

import java.util.List;

@RestController
@RequestMapping(value = "laptop")
public class LaptopController {
    private final ProductService<Laptop> service;

    public LaptopController(ProductService<Laptop> service) {
        this.service = service;
    }

    @PostMapping(value = "/add")
    public Laptop addNewLaptop(@RequestBody Laptop entity) {
        return service.addProduct(entity);
    }

    @PatchMapping(value = "/update")
    public Laptop updateLaptop(@RequestBody Laptop entity, @RequestParam Long id) throws ProductTypeCastException {
        return service.updateProduct(id, entity);
    }

    @GetMapping(value = "/get-all")
    public List<Laptop> getAllLaptops() {
        return service.getAllProducts(Laptop.class);
    }

    @GetMapping(value = "/get")
    public Laptop getById(@RequestParam Long id) {
        return service.getProductById(id);
    }

    @DeleteMapping(value = "/delete")
    public String deleteById(@RequestParam Long id) {
        return service.deleteById(id);
    }
}
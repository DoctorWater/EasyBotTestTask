package ru.malkov.easybottesttask.controllers;

import org.springframework.web.bind.annotation.*;
import ru.malkov.easybottesttask.entities.Laptop;
import ru.malkov.easybottesttask.entities.Monitor;
import ru.malkov.easybottesttask.exceptions.ProductTypeCastException;
import ru.malkov.easybottesttask.services.ProductService;

import java.util.List;

@RestController
@RequestMapping(value = "monitor")
public class MonitorController {
    private final ProductService<Monitor> service;

    public MonitorController(ProductService<Monitor> service) {
        this.service = service;
    }

    @PostMapping(value = "/add")
    public Monitor addNewLaptop(@RequestBody Monitor entity) {
        return service.addProduct(entity);
    }

    @PatchMapping(value = "/update")
    public Monitor updateLaptop(@RequestBody Monitor entity, @RequestParam Long id) throws ProductTypeCastException {
        return service.updateProduct(id, entity);
    }

    @GetMapping(value = "/get-all")
    public List<Monitor> getAllLaptops() {
        return service.getAllProducts();
    }

    @GetMapping(value = "/get")
    public Monitor getById(@RequestParam Long id) {
        return service.getProductById(id);
    }
}
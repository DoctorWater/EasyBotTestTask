package ru.malkov.easybottesttask.controllers;

import org.springframework.web.bind.annotation.*;
import ru.malkov.easybottesttask.entities.HardDrive;
import ru.malkov.easybottesttask.exceptions.ProductTypeCastException;
import ru.malkov.easybottesttask.services.ProductService;

import java.util.List;

@RestController
@RequestMapping(value = "hard-drive")
public class HardDriveController {
    private final ProductService<HardDrive> service;

    public HardDriveController(ProductService<HardDrive> service) {
        this.service = service;
    }

    @PostMapping(value = "/add")
    public HardDrive addNewLaptop(@RequestBody HardDrive entity) {
        return service.addProduct(entity);
    }

    @PatchMapping(value = "/update")
    public HardDrive updateLaptop(@RequestBody HardDrive entity, @RequestParam Long id) throws ProductTypeCastException {
        return service.updateProduct(id, entity);
    }

    @GetMapping(value = "/get-all")
    public List<HardDrive> getAllLaptops() {
        return service.getAllProducts(HardDrive.class);
    }

    @GetMapping(value = "/get")
    public HardDrive getById(@RequestParam Long id) {
        return service.getProductById(id);
    }

    @DeleteMapping(value = "/delete")
    public String deleteById(@RequestParam Long id) {
        return service.deleteById(id);
    }
}
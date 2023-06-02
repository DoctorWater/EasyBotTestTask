package ru.malkov.easybottesttask.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.malkov.easybottesttask.abstractClasses.Product;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Laptop extends Product {
    public enum LaptopSize{
        THIRTEEN_INCHES,
        FOURTEEN_INCHES,
        FIFTEEN_INCHES,
        SEVENTEEN_INCHES
    }
    @Enumerated(EnumType.STRING)
    private LaptopSize size;

    public Laptop(Long serialNumber, String manufacturer, Float price, Integer leftNumber, LaptopSize size) {
        super(serialNumber, manufacturer, price, leftNumber, ProductType.LAPTOP);
        this.size = size;
    }
}
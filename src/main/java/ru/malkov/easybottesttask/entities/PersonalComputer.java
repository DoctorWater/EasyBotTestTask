package ru.malkov.easybottesttask.entities;

import jakarta.persistence.*;
import lombok.*;
import ru.malkov.easybottesttask.abstractClasses.Product;
@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class PersonalComputer extends Product {
    public enum PCFormFactor{
        DESKTOP,
        NETTOP,
        MONOBLOCK
    }

    public PersonalComputer(Long serialNumber, String manufacturer, Float price, Integer leftNumber, PCFormFactor formFactor) {
        super(serialNumber, manufacturer, price, leftNumber, ProductType.PC);
        this.formFactor = formFactor;
    }

    @Enumerated(EnumType.STRING)
    private PCFormFactor formFactor;
}
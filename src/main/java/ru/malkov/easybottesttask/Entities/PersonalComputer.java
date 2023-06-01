package ru.malkov.easybottesttask.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.*;
import ru.malkov.easybottesttask.InterfacesAndAbstractClasses.Product;
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

    private PCFormFactor formFactor;
}

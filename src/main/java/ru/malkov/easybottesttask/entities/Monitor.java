package ru.malkov.easybottesttask.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
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
public class Monitor extends Product {
    private Float diagonal;

    public Monitor(Long serialNumber, String manufacturer, Float price, Integer leftNumber, Float diagonal) {
        super(serialNumber, manufacturer, price, leftNumber, ProductType.MONITOR);
        this.diagonal = diagonal;
    }
}

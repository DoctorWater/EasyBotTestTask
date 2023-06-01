package ru.malkov.easybottesttask.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.malkov.easybottesttask.InterfacesAndAbstractClasses.Product;
@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class HardDrive extends Product {
    private Integer memorySize;

    public HardDrive(Long serialNumber, String manufacturer, Float price, Integer leftNumber, Integer memorySize) {
        super(serialNumber, manufacturer, price, leftNumber, ProductType.HARDDRIVE);
        this.memorySize = memorySize;
    }
}

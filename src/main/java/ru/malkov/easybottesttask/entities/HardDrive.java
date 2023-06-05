package ru.malkov.easybottesttask.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.malkov.easybottesttask.abstractClasses.Product;
import ru.malkov.easybottesttask.exceptions.ProductTypeCastException;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(schema = "easybot", name = "hard_drive")
public class HardDrive extends Product {
    private Integer memorySize;

    public HardDrive(Long serialNumber, String manufacturer, Float price, Integer leftNumber, Integer memorySize) {
        super(serialNumber, manufacturer, price, leftNumber);
        this.memorySize = memorySize;
    }

    @Override
    public void update(Product source) throws ProductTypeCastException {
        super.update(source);
        if(!(source instanceof HardDrive)){
            throw new ProductTypeCastException(new ClassCastException());
        }
        if(((HardDrive) source).getMemorySize() != null){
            this.memorySize = ((HardDrive) source).getMemorySize();
        }
    }
}
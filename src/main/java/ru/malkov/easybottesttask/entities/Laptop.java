package ru.malkov.easybottesttask.entities;

import jakarta.persistence.*;
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
        super(serialNumber, manufacturer, price, leftNumber);
        this.size = size;
    }

    @Override
    public void update(Product source) throws ProductTypeCastException {
        super.update(source);
        if(!(source instanceof Laptop)){
            throw new ProductTypeCastException(new ClassCastException());
        }
        this.size = ((Laptop) source).getSize();
    }
}
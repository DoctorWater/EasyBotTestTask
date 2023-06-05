package ru.malkov.easybottesttask.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(catalog = "EASYBOT", schema = "PUBLIC")
public class Laptop extends Product {
    public enum LaptopSize {
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
        if (!(source instanceof Laptop)) {
            throw new ProductTypeCastException(new ClassCastException());
        }
        if (((Laptop) source).getSize() != null) {
            this.size = ((Laptop) source).getSize();
        }
    }
}
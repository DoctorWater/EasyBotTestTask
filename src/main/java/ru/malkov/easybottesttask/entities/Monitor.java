package ru.malkov.easybottesttask.entities;

import jakarta.persistence.Entity;
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
public class Monitor extends Product {
    private Float diagonal;

    public Monitor(Long serialNumber, String manufacturer, Float price, Integer leftNumber, Float diagonal) {
        super(serialNumber, manufacturer, price, leftNumber);
        this.diagonal = diagonal;
    }

    @Override
    public void update(Product source) throws ProductTypeCastException {
        super.update(source);
        if (!(source instanceof Monitor)) {
            throw new ProductTypeCastException(new ClassCastException());
        }
        if (((Monitor) source).getDiagonal() != null) {
            this.diagonal = ((Monitor) source).getDiagonal();
        }
    }
}
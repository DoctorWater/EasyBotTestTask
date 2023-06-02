package ru.malkov.easybottesttask.abstractClasses;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.malkov.easybottesttask.entities.ProductType;

/**
 * Main abstract class of all products.
 */

//I've decided to use abstract class instead of interface, because interfaces should not describe objects' states, only behavior.
@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "serial_number")
    protected Long serialNumber;
    private String manufacturer;
    private Float price;
    @Column(name = "left_number")
    private Integer leftNumber;
    @Enumerated(EnumType.STRING)
    private ProductType productType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;

        if (getSerialNumber() != null ? !getSerialNumber().equals(product.getSerialNumber()) : product.getSerialNumber() != null)
            return false;
        if (getManufacturer() != null ? !getManufacturer().equals(product.getManufacturer()) : product.getManufacturer() != null)
            return false;
        if (getPrice() != null ? !getPrice().equals(product.getPrice()) : product.getPrice() != null) return false;
        if (getLeftNumber() != null ? !getLeftNumber().equals(product.getLeftNumber()) : product.getLeftNumber() != null)
            return false;
        return getProductType() == product.getProductType();
    }

    @Override
    public int hashCode() {
        int result = getSerialNumber() != null ? getSerialNumber().hashCode() : 0;
        result = 31 * result + (getManufacturer() != null ? getManufacturer().hashCode() : 0);
        result = 31 * result + (getPrice() != null ? getPrice().hashCode() : 0);
        result = 31 * result + (getLeftNumber() != null ? getLeftNumber().hashCode() : 0);
        result = 31 * result + (getProductType() != null ? getProductType().hashCode() : 0);
        return result;
    }
}
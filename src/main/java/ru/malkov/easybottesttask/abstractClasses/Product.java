package ru.malkov.easybottesttask.abstractClasses;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.malkov.easybottesttask.exceptions.ProductTypeCastException;

/**
 * Main abstract class of all products.
 * ATTENTION: SERIAL NUMBER MUST BE UNIQUE AMONG ALL PRODUCTS, NOT ONLY AMONG THE CERTAIN PRODUCT'S CATEGORY!
 */

//I've decided to use abstract class instead of interface, because interfaces should not describe objects' states, only behavior.
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Product {
    @Id
    @Column(name = "id")
    private Long serialNumber;
    private String manufacturer;
    private Float price;
    @Column(name = "left_number")
    private Integer leftNumber;

    /**
     * Update method for general {@link Product} type. Should be overridden in all children. Ignores null fields.
     * @param source -- source of new values for fields.
     * @throws ProductTypeCastException -- thrown if {@link Product} can not be cast to the specific child type.
     */
    public void update(Product source) throws ProductTypeCastException {
        if (source.getSerialNumber() != null) {
            this.setSerialNumber(source.getSerialNumber());
        }
        if (source.getPrice() != null) {
            this.setPrice(source.getPrice());
        }
        if (source.getManufacturer() != null) {
            this.setManufacturer(source.getManufacturer());
        }
        if (source.getLeftNumber() != null) {
            this.setLeftNumber(source.getLeftNumber());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;

        if (getSerialNumber() != null ? !getSerialNumber().equals(product.getSerialNumber()) : product.getSerialNumber() != null)
            return false;
        if (getManufacturer() != null ? !getManufacturer().equals(product.getManufacturer()) : product.getManufacturer() != null)
            return false;
        if (getPrice() != null ? !getPrice().equals(product.getPrice()) : product.getPrice() != null) return false;
        return getLeftNumber() != null ? getLeftNumber().equals(product.getLeftNumber()) : product.getLeftNumber() == null;
    }

    @Override
    public int hashCode() {
        int result = getSerialNumber() != null ? getSerialNumber().hashCode() : 0;
        result = 31 * result + (getManufacturer() != null ? getManufacturer().hashCode() : 0);
        result = 31 * result + (getPrice() != null ? getPrice().hashCode() : 0);
        result = 31 * result + (getLeftNumber() != null ? getLeftNumber().hashCode() : 0);
        return result;
    }
}
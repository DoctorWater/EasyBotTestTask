package ru.malkov.easybottesttask.entities;

import jakarta.persistence.*;
import lombok.*;
import ru.malkov.easybottesttask.abstractClasses.Product;
import ru.malkov.easybottesttask.exceptions.ProductTypeCastException;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(schema = "easybot", name = "pc")
public class PersonalComputer extends Product {
    public enum PCFormFactor{
        DESKTOP,
        NETTOP,
        MONOBLOCK
    }

    public PersonalComputer(Long serialNumber, String manufacturer, Float price, Integer leftNumber, PCFormFactor formFactor) {
        super(serialNumber, manufacturer, price, leftNumber);
        this.formFactor = formFactor;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "form_factor")
    private PCFormFactor formFactor;

    @Override
    public void update(Product source) throws ProductTypeCastException {
        super.update(source);
        if(!(source instanceof PersonalComputer)){
            throw new ProductTypeCastException(new ClassCastException());
        }
        if(((PersonalComputer) source).getFormFactor() != null){
            this.formFactor = ((PersonalComputer) source).getFormFactor();
        }
    }
}
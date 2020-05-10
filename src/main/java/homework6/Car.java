package homework6;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@Getter
@EqualsAndHashCode

public class Car {
    //Car custom object of choice with any number of fields (> 2) of different types;
    private String brand;
    private int age;
    private long regNumber;

    @Override
    public String toString() {
        return "Youngest car: " + brand + ", with age: " + age;
    }

}



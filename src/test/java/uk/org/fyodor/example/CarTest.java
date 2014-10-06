package uk.org.fyodor.example;

import org.junit.Test;
import uk.org.fyodor.example.builders.CarBuilder;

public class CarTest {

    @Test
    public void createCar(){
        Car car = CarBuilder.builder().build();
    }
}

package uk.org.fyodor.example;

import org.junit.Test;
import uk.org.fyodor.example.builders.CarBuilder;

import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    Pattern productCodePattern = Pattern.compile("^[A-Z]{5}-[A-Z0-9]{7}-[0-9]{3}-[DXZ]$");
    @Test
    public void createCar(){
        Car car = CarBuilder.builder().build();
        assertThat(productCodePattern.matcher(car.getProductCode()).matches()).isTrue();
    }
}

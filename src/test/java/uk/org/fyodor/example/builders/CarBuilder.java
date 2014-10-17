package uk.org.fyodor.example.builders;

import org.joda.time.LocalDate;
import uk.org.fyodor.example.Car;
import uk.org.fyodor.example.Manufacturer;
import uk.org.fyodor.example.RDG;

import java.math.BigDecimal;

import static org.joda.time.Years.years;
import static uk.org.fyodor.generators.RDG.*;
import static uk.org.fyodor.jodatime.generators.RDG.localDate;
import static uk.org.fyodor.jodatime.range.LocalDateRange.aged;
import static uk.org.fyodor.range.Range.closed;

public class CarBuilder {

    private String name = string(15).next();
    private String description = string(50).next();
    private String productCode = RDG.productCode().next();
    private Manufacturer manufacturer = value(Manufacturer.values()).next();
    private LocalDate dateOfManufacture = localDate(aged(closed(years(3), years(15)))).next();
    private BigDecimal price = bigDecimal(50000).next();
//    private Engine engine = EngineBuilder.engineBuilder().build();

    private CarBuilder() {
    }

    public static CarBuilder builder() {
        return new CarBuilder();
    }

    public Car build() {
        Car car = new Car();
        car.setDateOfManufacture(dateOfManufacture);
        car.setDescription(description);
        car.setManufacturer(manufacturer);
        car.setName(name);
        car.setPrice(price);
        car.setProductCode(productCode);
        return car;
    }
}

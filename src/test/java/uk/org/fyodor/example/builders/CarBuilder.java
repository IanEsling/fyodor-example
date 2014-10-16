package uk.org.fyodor.example.builders;

import org.joda.time.LocalDate;
import uk.org.fyodor.example.Car;
import uk.org.fyodor.example.Manufacturer;
import uk.org.fyodor.example.RDG;
import uk.org.fyodor.jodatime.range.LocalDateRange;

import java.math.BigDecimal;

import static org.joda.time.LocalDate.now;
import static uk.org.fyodor.jodatime.generators.RDG.localDate;

public class CarBuilder {

    private String name = RDG.string(15).next();
    private String description = RDG.string(50).next();
    private String productCode = RDG.productCode().next();
    private Manufacturer manufacturer = RDG.value(Manufacturer.values()).next();
    private LocalDate dateOfManufacture = localDate(LocalDateRange.closed(now().minusYears(15), now().minusYears(3))).next();
    private BigDecimal price = RDG.bigDecimal(50000).next();
//    private Engine engine = EngineBuilder.engineBuilder().build();

    private CarBuilder() {}

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

package uk.org.fyodor.example.builders;

import org.joda.time.LocalDate;
import uk.org.fyodor.example.Car;
import uk.org.fyodor.example.Manufacturer;
import uk.org.fyodor.jodatime.generators.JodaRDG;
import uk.org.fyodor.range.Range;

import java.math.BigDecimal;

import static org.joda.time.LocalDate.now;

public class CarBuilder {

    private String name = JodaRDG.string(15).next();
    private String description = JodaRDG.string(50).next();
    private Manufacturer manufacturer = JodaRDG.value(Manufacturer.values()).next();
    private LocalDate dateOfManufacture = JodaRDG.localDate(Range.closed(now().minusYears(15), now().minusYears(3))).next();
    private BigDecimal price = JodaRDG.bigDecimal(50000).next();
//    private Engine engine = EngineBuilder.engineBuilder().build();

    private CarBuilder() {}

    public static CarBuilder builder() {
        return new CarBuilder();
    }

    public Car build() {
        return new Car();
    }
}

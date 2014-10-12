package uk.org.fyodor.example;

import uk.org.fyodor.example.generators.ProductCodeGenerator;
import uk.org.fyodor.generators.Generator;

public class RDG extends uk.org.fyodor.generators.RDG {

    public static Generator<String> productCode() {
        return new ProductCodeGenerator();
    }
}

package uk.org.fyodor.example.generators;

import uk.org.fyodor.example.RDG;
import uk.org.fyodor.generators.Generator;
import uk.org.fyodor.generators.characters.CharacterSetFilter;
import uk.org.fyodor.range.Range;

public class ProductCodeGenerator implements Generator<String> {

    private Generator<String> firstBit = RDG.string(5, CharacterSetFilter.LettersOnly);
    private Generator<String> secondBit = RDG.string(7, CharacterSetFilter.LettersAndDigits);
    private Generator<Integer> number = RDG.integer(Range.closed(100, 999));
    private Generator<String> lastBit = RDG.string(1, "DXZ");

    public String next() {
        return String.format("%s-%s-%d-%s",
                firstBit.next().toUpperCase(),
                secondBit.next().toUpperCase(),
                number.next(),
                lastBit.next());
    }
}

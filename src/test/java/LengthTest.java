
import org.example.Length;
import org.example.Unit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LengthTest {

    @Test
    public void shouldReturnTrueForEqualLengths(){
        Length length1 = new Length(1, Unit.CENTIMETER);
        Length length2 = new Length(1, Unit.CENTIMETER);

        assertTrue(length1.equals(length2));
    }

    @Test
    public void shouldReturnFalseForNonEqualLengths(){
        Length length1 = new Length(1, Unit.CENTIMETER);
        Length length2 = new Length(2, Unit.CENTIMETER);

        assertFalse(length1.equals(length2));
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionForNonPositiveLengths(){
        assertThrows(IllegalArgumentException.class, () -> new Length(0, Unit.CENTIMETER) );
    }

    @Test
    public void shouldReturn2CmForLength1Cm(){
        Length length1 = new Length(1, Unit.CENTIMETER);
        Length length2 = new Length(1, Unit.CENTIMETER);
        Length expectedLength = new Length(2, Unit.CENTIMETER);

        Length result = length1.add(length2);

        assertEquals(expectedLength, result);
    }

    @Test
    public void shouldReturnTrueForComparing100CmAnd1M(){
        Length length1 = new Length(100, Unit.CENTIMETER);
        Length length2 = new Length(1, Unit.METER);

        assertTrue(length1.equals(length2));
    }

    @Test
    public void shouldReturnTrueForComparing1MAnd100Cm(){
        Length length1 = new Length(1, Unit.METER);
        Length length2 = new Length(100, Unit.CENTIMETER);

        assertTrue(length1.equals(length2));
    }

    @Test
    public void shouldReturnFalseForComparing10CmAnd1M(){
        Length length1 = new Length(10, Unit.CENTIMETER);
        Length length2 = new Length(1, Unit.METER);

        assertFalse(length1.equals(length2));
    }

//    @Test
//    public void shouldReturnInchConversionForCm(){
//        Length length = new Length(1, Unit.INCHES);
//        Length expectedLength = new Length(0.0254, Unit.METER);
//
//        Length result = length.convertTo(Unit.METER);
//
//        assertEquals(expectedLength, result);
//    }

    @Test
    public void shouldReturn2mForAdding1mAnd100cm(){
        Length length1 = new Length(1, Unit.METER);
        Length length2 = new Length(100, Unit.CENTIMETER);
        Length expectedLength = new Length(2, Unit.METER);

        Length result = length1.add(length2);

        assertEquals(expectedLength, result);
    }

    @Test
    public void shouldReturn200CmForAdding100CmAnd1m(){
        Length length1 = new Length(100, Unit.CENTIMETER);
        Length length2 = new Length(1, Unit.METER);
        Length expectedLength = new Length(200, Unit.CENTIMETER);

        Length result = length1.add(length2);

        assertEquals(expectedLength, result);
    }
}

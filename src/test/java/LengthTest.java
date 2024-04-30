
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
    public void shouldReturn100CmFor1M(){
        Length length = new Length(1, Unit.METER);
        Length expectedLength = new Length(100, Unit.CENTIMETER);

        Length result = length.convertTo(Unit.CENTIMETER);

        assertEquals(expectedLength, result);
    }

    @Test
    public void shouldReturn1MFor100Cm(){
        Length length = new Length(100, Unit.CENTIMETER);
        Length expectedLength = new Length(1, Unit.METER);

        Length result = length.convertTo(Unit.METER);

        assertEquals(expectedLength, result);
    }
}

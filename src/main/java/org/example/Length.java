package org.example;

import java.util.Objects;

public class Length {

    private final double value;
    private final Unit unit;
    public Length(double value, Unit unit) {
        if(value<=0){
            throw new IllegalArgumentException("org.example.Length cannot be zero or a non positive number");
        }

        this.value = value;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Length length)) return false;
        return Double.compare(value, length.value) == 0 && Objects.equals(unit, length.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, unit);
    }

    public Length add(Length length) {
        double result = this.value + length.value;
        return new Length(result, this.unit);
    }

    public Length convertTo(Unit targetUnit){
        if(this.unit==targetUnit){
            return this;
        }

        double conversionFactor = this.unit.getConversionFactorTo(targetUnit);
        double convertedValue = this.value * conversionFactor;

        return new Length(convertedValue, targetUnit);
    }
}

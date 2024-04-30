package org.example;

public enum Unit {
    CENTIMETER(1.0),
    METER(100.0);
    private final double conversionFactor;


    Unit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double getConversionFactorTo(Unit targetUnit){
        return this.conversionFactor / targetUnit.conversionFactor;
    }
}

package org.example;

public enum Unit {
    CENTIMETER(1.0),
    METER(100.0);

    //converting meter to centimeter
    private final double conversionFactor;


    Unit(double conversionFactor) {
        this.conversionFactor=conversionFactor;
    }

    //method to convert conversion factor to a target unit
    public double getConversionFactorTo(Unit targetUnit){
        return this.conversionFactor/ targetUnit.conversionFactor;
    }
}

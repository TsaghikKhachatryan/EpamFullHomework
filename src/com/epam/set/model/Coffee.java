package com.epam.set.model;

import java.util.Objects;

public class Coffee implements Comparable<Coffee> {
    private String color;
    private String type;
    private String originCountry;

    public Coffee(String color, String type, String originCountry) {
        this.color = color;
        this.type = type;
        this.originCountry = originCountry;
    }

    public String getColor() {
        return color;
    }

    public String getType() {
        return type;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    @Override
    public String toString() {
        return this.type + " " + this.color +
                " " + this.originCountry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coffee coffee = (Coffee) o;
        return Objects.equals(color, coffee.color) &&
                Objects.equals(type, coffee.type) &&
                Objects.equals(originCountry, coffee.originCountry);
    }

    @Override
    public int compareTo(Coffee coffee) {
        int result = this.type.compareTo(coffee.type);
        if (result == 0) {
            result = this.color.compareTo(coffee.color);
            if (result == 0) {
                result = this.originCountry.compareTo(coffee.originCountry);
            }
        }
        return result;
    }
}
package com.epam.set.model;

import java.util.Objects;

public class Flower implements Comparable<Flower> {
    private String name;
    private String color;

    public Flower(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return this.name + " " + this.color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flower flower = (Flower) o;
        return Objects.equals(name, flower.name) &&
                Objects.equals(color, flower.color);
    }

    @Override
    public int compareTo(Flower flower) {
        int result = this.name.compareTo(flower.name);
        if (result == 0) {
            result = this.color.compareTo(flower.color);
        }
        return result;
    }
}
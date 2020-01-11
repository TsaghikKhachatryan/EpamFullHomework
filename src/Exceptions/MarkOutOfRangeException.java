package Exceptions;

import models.Mark;

public class MarkOutOfRangeException extends RuntimeException {
    private int value;

    public MarkOutOfRangeException(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value + " is out of range!";
    }
}
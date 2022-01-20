package com.fillipelima.general;

public class SequenceGenerator {
    protected int currentValue = 0;

    public int getNextSequence() {
        currentValue = currentValue + 1;
        return currentValue;
    }
}

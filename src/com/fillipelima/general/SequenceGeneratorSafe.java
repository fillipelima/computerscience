package com.fillipelima.general;

public class SequenceGeneratorSafe extends SequenceGenerator {
    
	@Override
	public synchronized int getNextSequence() {
        super.currentValue = super.currentValue + 1;
        return super.currentValue;
    }
	
}

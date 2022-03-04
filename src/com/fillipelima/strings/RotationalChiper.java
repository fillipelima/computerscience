package com.fillipelima.strings;

public class RotationalChiper {
	String rotationalCipher(String input, int rotationFactor) {
		// Write your code here
		char[] rotated = input.toCharArray();
		int azRange = 'z' - 'a' + 1;
		int aZRange = 'Z' - 'A' + 1;
		int nuRange = '9' - '0' + 1;
		for (int i = 0; i < rotated.length; i++) {
			// Numeric
			if (rotated[i] >= 'a' && rotated[i] <= 'z') {
				int factor = rotationFactor;
				if (rotationFactor >= azRange) {
					factor = rotationFactor % azRange;
				}
				char r = (char) (rotated[i] + factor);
				if (r > 'z') {
					rotated[i] = (char) (r - 'z' + 'a' - 1);
				} else {
					rotated[i] = r;
				}
				// Upper case letters
			} else if (rotated[i] >= 'A' && rotated[i] <= 'Z') {
				int factor = rotationFactor;
				if (rotationFactor >= aZRange) {
					factor = rotationFactor % aZRange;
				}				
				char r = (char) (rotated[i] + factor);
				if (r > 'Z') {
					rotated[i] = (char) (r - 'Z' + 'A' - 1);
				} else {
					rotated[i] = r;
				}
				// Lower case letters
			} else if (rotated[i] >= '0' && rotated[i] <= '9') {
				int factor = rotationFactor;
				if (rotationFactor >= nuRange) {
					factor = rotationFactor % nuRange;
				}
				char r = (char) (rotated[i] + factor);
				if (r > '9') {
					rotated[i] = (char) (r - '9' + '0' - 1);
				} else {
					rotated[i] = r;
				}
			}
		}
		return String.valueOf(rotated);
	}
	public static void main(String[] args) {
		System.out.println(new RotationalChiper().rotationalCipher("abcdZXYzxy-999.@", 200));
		System.out.println(new RotationalChiper().rotationalCipher("9", 200));
		System.out.println(new RotationalChiper().rotationalCipher("a", 200));
	}
}

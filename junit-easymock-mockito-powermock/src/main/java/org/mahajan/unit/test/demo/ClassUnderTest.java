package org.mahajan.unit.test.demo;

public class ClassUnderTest {
	
	private Math math;

	

	public float calculateAvg(int[] intArray) {
		
		return math.average(intArray);
	}

	
	public Math getMath() {
		return math;
	}

	public void setMath(Math math) {
		this.math = math;
	}
}

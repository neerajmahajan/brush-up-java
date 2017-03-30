package org.mahajan.unit.test.demo;

public class Math {
	
	public int add (int a, int b){
		
		return a+b;
	}
	
	public int sub (int a, int b){
		
		return a-b;
	}
	
	public int multiple (int a, int b){
		
		return a*b;
	}
	
	public float divide (int a, int b) {
		
		if(a!=1 && b == 0){
			throw new RuntimeException("Divisor should be non zero");
		}
		return a/b;
	}
	
	public float average(int[] intArray){
		
		int sum=0;
		if(intArray == null) {
			throw new RuntimeException("Array Cannot be mepty");
		}
		
		for (int i : intArray) {
			sum = sum+ i;
		}
		
		return sum/intArray.length;
	}

}

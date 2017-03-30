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

}

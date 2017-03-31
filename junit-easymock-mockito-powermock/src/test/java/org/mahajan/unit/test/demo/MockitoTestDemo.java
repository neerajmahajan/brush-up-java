package org.mahajan.unit.test.demo;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class MockitoTestDemo {
	

	private Math mathMock;
	
	@Test
	public void testWithMockObject() {
		
		mathMock =  mock(Math.class);
		
		when(mathMock.average(isA(int[].class))).thenReturn(2.0f);
		
		ClassUnderTest classUnderTest = new ClassUnderTest();
		classUnderTest.setMath(mathMock);
		
		
		int[] intArray = {1,1,2,2,3,3};
		float actualAverage = classUnderTest.calculateAvg(intArray);
		
		float expectedAverage = (1+1+2+2+3+3)/6;
		assertEquals("Average Should Match", expectedAverage, actualAverage, 0);
		verify(mathMock,times(1)).average(intArray);
	}
	
	@Test(expected=RuntimeException.class)
	public void testMockObjectThrowsException() {
		
		mathMock =  mock(Math.class);
		
		doThrow(new RuntimeException()).when(mathMock.average(isA(int[].class)));
		
		ClassUnderTest classUnderTest = new ClassUnderTest();
		classUnderTest.setMath(mathMock);
		verify(mathMock,times(1)).average(isA(int[].class));
	}
	

}

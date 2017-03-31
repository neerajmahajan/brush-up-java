package org.mahajan.unit.test.demo;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

@RunWith(MockitoJUnitRunner.class)
public class MockitoTestAnnotationsDemo {
	
	@Rule public MockitoRule mockitoRule = MockitoJUnit.rule();

	@Mock
	private Math mathMock;
	
	@Test
	public void testWithMockObject() {
		
		when(mathMock.average(isA(int[].class))).thenReturn(2.0f);
		
		ClassUnderTest classUnderTest = new ClassUnderTest();
		classUnderTest.setMath(mathMock);
		
		
		int[] intArray = {1,1,2,2,3,3};
		float actualAverage = classUnderTest.calculateAvg(intArray);
		
		float expectedAverage = (1+1+2+2+3+3)/6;
		assertEquals("Average Should Match", expectedAverage, actualAverage, 0);
		verify(mathMock,times(1)).average(intArray);
	}
	

}

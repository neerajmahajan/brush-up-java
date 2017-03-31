package org.mahajan.unit.test.demo;

import static org.easymock.EasyMock.isA;
import static org.easymock.EasyMock.mock;
import static org.easymock.EasyMock.niceMock;
import static org.easymock.EasyMock.strictMock;
import static org.junit.Assert.assertEquals;

import org.easymock.EasyMock;
import org.junit.Test;

//For reference read http://easymock.org/user-guide.html

public class EasyMockTestDemo {
	
	private ClassUnderTest classUnderTest;

	@Test
	public void testWithoutMockObject() {
		classUnderTest = new ClassUnderTest();
		
		//------------------------------//
		classUnderTest.setMath(new Math());
		//------------------------------//
		
		int[] intArray = {1,1,2,2,3,3};
		float actualAverage = classUnderTest.calculateAvg(intArray);
		float expectedAverage = (1+1+2+2+3+3)/6;
				
				assertEquals("Average Should Match", expectedAverage, actualAverage, 0);
	}
	
	@Test
	public void testWithMockObject() {
		Math mathMock = mock(Math.class);
		EasyMock.expect(mathMock.average(isA(int[].class))).andReturn(2.0F);
		EasyMock.expectLastCall();
		EasyMock.replay(mathMock);
	
		classUnderTest = new ClassUnderTest();
		classUnderTest.setMath(mathMock);
		
		int[] intArray = {1,1,2,2,3,3};
		float actualAverage = classUnderTest.calculateAvg(intArray);
		
		EasyMock.verify(mathMock);

		float expectedAverage = (1+1+2+2+3+3)/6;
				
				assertEquals("Average Should Match", expectedAverage, actualAverage, 0);
	}
	
	/*
	  Nice Mocks  
 	  On a Mock Object returned by mock() the default behavior for all methods is
	  to throw an AssertionError for all unexpected method calls. 
	  If you would like a "nice" Mock Object that by default allows all method calls
	  and returns appropriate empty values (0, null or false), use niceMock() instead. 
	  
	  */
	
	@Test
	public void testWithNiceMockObject() {
		Math mathMock = niceMock(Math.class);
	
		classUnderTest = new ClassUnderTest();
		classUnderTest.setMath(mathMock);
		
		int[] intArray = {1,1,2,2,3,3};
		float actualAverage = classUnderTest.calculateAvg(intArray);
		
		float defaultValue = 0f; 
				
		assertEquals("Average Should Match", defaultValue, actualAverage, 0);
	}
	
	
	/*
	Strict Mocks
	On a Mock Object returned by a EasyMock.mock(), the order of method calls is not checked.
	If you would like a strict Mock Object that checks the order of method calls, use EasyMock.strictMock() to create it.
	If an unexpected method is called on a strict Mock Object, 
	the message of the exception will show the method calls expected at this point followed by the first conflicting one. 
	verify(mock) shows all missing method calls.
	*/
	
	@Test
	public void testWithStrictMockObject() {
		Math mathMock = strictMock(Math.class);
		
		EasyMock.expect(mathMock.average(isA(int[].class))).andReturn(2.0F);
		EasyMock.expectLastCall().times(1);
		EasyMock.checkOrder(mathMock, true);
		EasyMock.replay(mathMock);
	
		classUnderTest = new ClassUnderTest();
		classUnderTest.setMath(mathMock);
		
		int[] intArray = {1,1,2,2,3,3};
		float actualAverage = classUnderTest.calculateAvg(intArray);
		
		EasyMock.verify(mathMock);

		float expectedAverage = (1+1+2+2+3+3)/6;
				
		assertEquals("Average Should Match", expectedAverage, actualAverage, 0);
				
				
				
	}

}

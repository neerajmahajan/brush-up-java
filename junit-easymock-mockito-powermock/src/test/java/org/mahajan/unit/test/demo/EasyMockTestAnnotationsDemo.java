package org.mahajan.unit.test.demo;

import static org.easymock.EasyMock.isA;
import static org.junit.Assert.assertEquals;

import org.easymock.EasyMock;
import org.easymock.EasyMockRule;
import org.easymock.Mock;
import org.easymock.MockType;
import org.easymock.TestSubject;
import org.junit.Rule;
import org.junit.Test;

//@RunWith(EasyMockRunner.class)
//The above runner is necessary when we are not using EasymockRule @Rule

public class EasyMockTestAnnotationsDemo {
	
	@Rule
	  public EasyMockRule mocks = new EasyMockRule(this);
	
	@TestSubject
	private ClassUnderTest classUnderTest = new ClassUnderTest();
	
	@Mock(type=MockType.NICE, name = "mymock", fieldName = "math") //"fieldName", allows specifying the target field name where the mock should be injected
	private Math mathMock;

	
	@Test
	public void testWithMockObject() {
		EasyMock.expect(mathMock.average(isA(int[].class))).andReturn(2.0F);
		EasyMock.expectLastCall();
		EasyMock.replay(mathMock);
	
		classUnderTest.setMath(mathMock);
		
		int[] intArray = {1,1,2,2,3,3};
		float actualAverage = classUnderTest.calculateAvg(intArray);
		
		//EasyMock.verify(mathMock);

		float expectedAverage = (1+1+2+2+3+3)/6;
				
				assertEquals("Average Should Match", expectedAverage, actualAverage, 0);
				
				
				
	}

}

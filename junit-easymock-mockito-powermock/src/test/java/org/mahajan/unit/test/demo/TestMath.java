package org.mahajan.unit.test.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assume.assumeTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runners.MethodSorters;


// Used to define methods execution Order
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestMath {
	
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	
	Math math = null;
	
	@BeforeClass
	public static void initialize(){
		//math = new Math();
	}
	
	@AfterClass
	public static void destroy(){
		//math = null;
	}
	
	
	@Before
	public  void setup(){
		math = new Math();
	}
	
	@After
	public  void teardown(){
		math = null;
	}
	
	@Test(expected=RuntimeException.class)
	public void testDivideThrowsException() {
		 math.divide(5, 0);
	}
	
	@Test
	public void testDivideThrowsExceptionAndValidateMessage() {
		
		assumeTrue(true); 
		
		/* This is used to make assumptions . If assumption fails then the test is halted and not executed. If using exception rules,
		   then the assumption should be made before defining expectation */

		/* Using ExceptionRule !*/
		expectedEx.expect(RuntimeException.class);
	    expectedEx.expectMessage("Divisor should be non zero");
	    
	    math.divide(5, 0);
	}
	
	@Test
	@Ignore // Used to ignore the test case which is marked with Ignore Annotation
	public void testDivideThrowsExceptionUsingTryCatch() {
		try{
			math.divide(5, 0);
			Assert.fail("This code line should not execute");
		}catch(RuntimeException e){
			assertEquals("Divisor should be non zero", e.getMessage());
		}
	}

	@Test
	public void testAdd() {
		assertEquals("Addition value should match",5*6, math.multiple(5, 6));
	}

	@Test
	public void testSub() {
		assertEquals("Substraction value should match",5-6, math.sub(5, 6));
	}

	@Test
	public void testMultiple() {
		assertEquals("Multiplication value should match",5*6, math.multiple(5, 6));
	}

	@Test
	public void testDivide() {
		assertEquals("Division value should match", 5/6, math.divide(5, 6),0.0);
	}

}

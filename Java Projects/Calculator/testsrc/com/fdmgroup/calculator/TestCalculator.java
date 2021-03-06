package com.fdmgroup.calculator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fdmgroup.calculator.Calculator;

public class TestCalculator {
	Calculator myCalc;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		myCalc = new Calculator();
	}
	
	@Test
	public void testComplex() {
		Double result = myCalc.compute("6 * 8 / 7 + 6 - 9 + 5 / 4 * 3 - 8 + 6");
		assertTrue(result == 5.607142857142858);
	}
	
	@Test
	public void testExp(){
		Double result = myCalc.compute("2^3");
		assertTrue(result == 8);
	}
	
	@Test 
	public void testDoublePos(){
		Double result = myCalc.compute("18 + +2");
		assertTrue(result == 20);
	}
	
	@Test 
	public void testDoubleNeg(){
		Double result = myCalc.compute("10 - -2");
		assertTrue(result == 12);
	}
	
	@Test
	public void testSimpleDivision() {
		Double result = myCalc.compute("10 / 2");
		assertTrue(result == 5);
	}
	
	@Test
	public void testSimpleMultiplication() {
		Double result = myCalc.compute("10 * 2");
		assertTrue(result == 20);
	}
	
	@Test
	public void testSimpleSubtraction() {
		Double result = myCalc.compute("10 - 2");
		assertTrue(result == 8);
	}
	
	@Test
	public void testSimpleAddition() {
		Double result = myCalc.compute("10 + 2");
		assertTrue(result == 12);
	}
	
	@Test
	public void testWithJustSingleNumber() {
		Double result = myCalc.compute("123");
		assertNull(result);
	}
	
	@Test
	public void testComputeWords() {
		Double result = myCalc.compute("abc123");
		assertNull(result);
	}
	
	@Test
	public void testComputeWithSpace() {
		Double result = myCalc.compute(" ");
		assertNull(result);
	}
	
	@Test
	public void testComputeNoSpace() {
		Double result = myCalc.compute("");
		assertNull(result);
	}
	
	@Test
	public void testComputeEmpty() {
		Double result = myCalc.compute(null);
		assertNull(result);
	}
	
	@Test
	public void testConstuctor() {
		assertNotNull(myCalc);
	}

}

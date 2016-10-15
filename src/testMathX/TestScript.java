package testMathX;

import mathX.v1.*;


import org.junit.Test;
import org.junit.Assert;

public class TestScript {

	@Test
	public void testAdd()
	{
		Calculator calc = new Calculator();
		double ans = calc.calculate("1.1 + 2.4");
		
		Assert.assertEquals(3.5d, ans, 0.0d);
	}
	
	@Test
	public void testSubtract()
	{
		Calculator calc = new Calculator();
		double ans = calc.calculate("1-2");
		
		Assert.assertEquals(-1.0d, ans, 0.0d);
	}
	
	
	@Test
	public void testMultiply()
	{
		Calculator calc = new Calculator();
		double ans = calc.calculate("1*2");
		
		Assert.assertEquals(2.0d, ans, 0.0d);
	}
	
	
	@Test
	public void testDivision_1()
	{
		Calculator calc = new Calculator();
		double ans = calc.calculate("1/2");
		
		Assert.assertEquals(0.5d, ans, 0.0d);
	}
	
	@Test
	public void testDivision_0()
	{
		Calculator calc = new Calculator();
		double ans = calc.calculate("1/0");
		Assert.assertTrue(Double.isInfinite(ans));
	}
}

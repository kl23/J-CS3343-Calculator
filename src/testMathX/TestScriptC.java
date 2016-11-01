package testMathX;

import mathX.v3.*;


import org.junit.Test;
import org.junit.Assert;

public class TestScriptC {

	@Test
	public void testLogBase2()
	{
		Calculator calc = new Calculator();
		double ans = calc.calcMagnitude("log(64, 2)");
		Assert.assertEquals(6.0d, ans, 0.0d);
	}
	
	
	@Test
	public void testLogBase3()
	{
		Calculator calc = new Calculator();
		double ans = calc.calcMagnitude("log(27, 3)");
		Assert.assertEquals(3.0d, ans, 0.0d);
	}
	
	@Test
	public void testAddVec()
	{
		Calculator calc = new Calculator();
		String ans = calc.calculate("(1,10)+(2,20)");
		Assert.assertEquals("<3.0, 30.0>", ans);
	}
		
}

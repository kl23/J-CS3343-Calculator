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
		
}

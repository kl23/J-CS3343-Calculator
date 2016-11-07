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
	
	@Test
	public void testMax()
	{
		Calculator calc = new Calculator();
		double ans = calc.calcMagnitude("max(27, 3, 4, 9, 1)");
		Assert.assertEquals(27.0d, ans, 0.0d);
	}
	
	@Test
	public void testMin()
	{
		Calculator calc = new Calculator();
		double ans = calc.calcMagnitude("min(-27, 3, 4, 9, -1)");
		Assert.assertEquals(-27.0d, ans, 0.0d);
	}
	
	@Test
	public void testMean()
	{
		Calculator calc = new Calculator();
		double ans = calc.calcMagnitude("mean(27, 3, 4, 1, 6)");
		Assert.assertEquals(8.2d, ans, 0.0d);
	}
	
	@Test
	public void testMedian_1()
	{
		Calculator calc = new Calculator();
		double ans = calc.calcMagnitude("median(27, 3, 4, 1, 6)");
		Assert.assertEquals(4.0d, ans, 0.0d);
	}
	
	@Test
	public void testMedian_2()
	{
		Calculator calc = new Calculator();
		double ans = calc.calcMagnitude("median(27, 3, 11, 1, 6, 13)");
		Assert.assertEquals(8.5d, ans, 0.0d);
	}
	
	@Test
	public void testMode()
	{
		Calculator calc = new Calculator();
		String ans = calc.calculate("mode(27, 8, 13, 8, 6, 13, 1, 1, 66, 9)");
		Assert.assertEquals("<1.0, 8.0, 13.0>", ans);
	}
	
	@Test
	public void testAbs()
	{
		Calculator calc = new Calculator();
		double ans = calc.calcMagnitude("abs(-17.5)");
		Assert.assertEquals(17.5d, ans, 0.0d);
	}
	
	@Test
	public void testVar()
	{
		Calculator calc = new Calculator();
		double ans = calc.calcMagnitude("var(206, 76, -102, 36, -34)");
		Assert.assertEquals(13610.8000000000d, ans, 1e-10);
	}
	
	@Test
	public void testSd()
	{
		Calculator calc = new Calculator();
		double ans = calc.calcMagnitude("sd(206, 76, -102, 36, -34)");
		Assert.assertEquals(116.6653333257d, ans, 1e-10);
	}
	
	@Test
	public void testSavedAns()
	{
		Calculator calc = new Calculator();
		double q1 = calc.calcMagnitude("3+3*3");
		double q2 = calc.calcMagnitude("ans/2");
		double ans = calc.calcMagnitude("ans+3");
		Assert.assertEquals(9.0d, ans, 0.0d);
	}
	
	@Test
	public void testStorage()
	{
		Calculator calc = new Calculator();
		double q1 = calc.calcMagnitude("A=4+2*3");
		double q2 = calc.calcMagnitude("B=ans/2");
		double q3 = calc.calcMagnitude("C=ans+3");
		
		double ans;
		ans = calc.calcMagnitude("A");
		Assert.assertEquals(10.0d, ans, 0.0d);
		ans = calc.calcMagnitude("B");
		Assert.assertEquals(5.0d, ans, 0.0d);
		ans = calc.calcMagnitude("C");
		Assert.assertEquals(8.0d, ans, 0.0d);
		
	}
	
	@Test
	public void testNegativeSign()
	{
		Calculator calc = new Calculator();
		double ans = calc.calcMagnitude("-(2*3)");
		Assert.assertEquals(-6.0d, ans, 0.0d);
	}
	
	@Test
	public void testlne()
	{
		Calculator calc = new Calculator();
		double ans = calc.calcMagnitude("lne");
		Assert.assertEquals(1.0d, ans, 0.0d);
	}
	
	@Test
	public void testTrigoFormat_A()
	{
		Calculator calc = new Calculator();
		double ans = calc.calcMagnitude("sin6^2");
		Assert.assertEquals(-0.991778853443115d, ans, 1e-15);
	}
	
	@Test
	public void testTrigoFormat_B()
	{
		Calculator calc = new Calculator();
		double ans = calc.calcMagnitude("(sin6)^2");
		Assert.assertEquals(0.078073020633753d, ans, 1e-15);
	}
	
}
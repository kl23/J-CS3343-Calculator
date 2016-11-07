package testMathX;

import mathX.v3.*;


import org.junit.Test;
import org.junit.Assert;

public class TestScriptB {

	@Test
	public void testSine()
	{
		Calculator calc = new Calculator();
		double ans = calc.calcMagnitude("sin180");
		Assert.assertEquals(-0.80115263573383047774673111582099, ans, 1e-15);
	}
	
	@Test
	public void testCosine()
	{
		Calculator calc = new Calculator();
		double ans = calc.calcMagnitude("cos180");
		Assert.assertEquals(-0.5984600690578581389679486481597, ans, 1e-15);
	}
	
	@Test
	public void testTangent()
	{
		Calculator calc = new Calculator();
		double ans = calc.calcMagnitude("tan180");
		Assert.assertEquals(1.3386902103511543616808987449579, ans, 1e-15);
	}
	
	@Test
	public void testSecant()
	{
		Calculator calc = new Calculator();
		double ans = calc.calcMagnitude("sec180");
		Assert.assertEquals(-1.670955259511761407737203284098, ans, 1e-15);
	}
	
	@Test
	public void testCosecant()
	{
		Calculator calc = new Calculator();
		double ans = calc.calcMagnitude("csc180");
		Assert.assertEquals(-1.2482015977941976377153784531866, ans, 1e-15);
	}
	
	@Test
	public void testCotangent()
	{
		Calculator calc = new Calculator();
		double ans = calc.calcMagnitude("cot180");
		Assert.assertEquals(0.74699881441404438757197462319304, ans, 1e-15);
	}
	
	@Test
	public void testArcsine()
	{
		Calculator calc = new Calculator();
		double ans = calc.calcMagnitude("arcsin0.5");
		Assert.assertEquals(0.523598775598298873077107230546583, ans, 1e-15);
	}
	
	@Test
	public void testArccosine()
	{
		Calculator calc = new Calculator();
		double ans = calc.calcMagnitude("arccos0.5");
		Assert.assertEquals(1.04719755119659774615421446109316, ans, 1e-15);
	}
	
	@Test
	public void testArctangent()
	{
		Calculator calc = new Calculator();
		double ans = calc.calcMagnitude("arctan0.5");
		Assert.assertEquals(0.4636476090008061162142562314612, ans, 1e-15);
	}
	
	@Test
	public void testArcsecant()
	{
		Calculator calc = new Calculator();
		double ans = calc.calcMagnitude("arcsec180");
		Assert.assertEquals(1.565240742660983463537031231293617, ans, 1e-15);
	}
	
	@Test
	public void testArccosecant()
	{
		Calculator calc = new Calculator();
		double ans = calc.calcMagnitude("arccsc180");
		Assert.assertEquals(0.00555558413391315569429046034613, ans, 1e-15);
	}
	
	@Test
	public void testArccotangent()
	{
		Calculator calc = new Calculator();
		double ans = calc.calcMagnitude("arccot180");
		Assert.assertEquals(0.0055554984006926217576438942038, ans, 1e-15);
	}
	
	@Test
	public void testLogarithm()
	{
		Calculator calc = new Calculator();
		double ans = calc.calcMagnitude("log45");
		Assert.assertEquals(1.6532125137753436793763169117857, ans, 1e-15);
	}
	
	@Test
	public void testNaturalLogarithm()
	{
		Calculator calc = new Calculator();
		double ans = calc.calcMagnitude("ln45");
		Assert.assertEquals(3.8066624897703197573912498070712, ans, 1e-15);
	}
	
	@Test
	public void testPercentage()
	{
		Calculator calc = new Calculator();
		double ans = calc.calcMagnitude("45%");
		Assert.assertEquals(0.45, ans, 1e-15);
	}
	
	@Test
	public void testConstantPI()
	{
		Calculator calc = new Calculator();
		double ans = calc.calcMagnitude("pi");
		Assert.assertEquals(3.1415926535897932384626433832795, ans, 1e-15);
	}
	
	@Test
	public void testConstantE()
	{
		Calculator calc = new Calculator();
		double ans = calc.calcMagnitude("e");
		Assert.assertEquals(2.7182818284590452353602874713527, ans, 1e-15);
	}
	
}

package testMathX;

import mathX.v2.*;


import org.junit.Test;
import org.junit.Assert;

public class TestScriptB {

	@Test
	public void testSine()
	{
		Calculator calc = new Calculator();
		double ans = calc.calculate("sin180");
		Assert.assertEquals(-0.80115263573383047774673111582099, ans, 1e-15);
	}
	
	@Test
	public void testCosine()
	{
		Calculator calc = new Calculator();
		double ans = calc.calculate("cos180");
		Assert.assertEquals(-0.5984600690578581389679486481597, ans, 1e-15);
	}
	
	@Test
	public void testTangent()
	{
		Calculator calc = new Calculator();
		double ans = calc.calculate("tan180");
		Assert.assertEquals(1.3386902103511543616808987449579, ans, 1e-15);
	}
	
	@Test
	public void testSecant()
	{
		Calculator calc = new Calculator();
		double ans = calc.calculate("sec180");
		Assert.assertEquals(-1.670955259511761407737203284098, ans, 1e-15);
	}
	
	@Test
	public void testCosecant()
	{
		Calculator calc = new Calculator();
		double ans = calc.calculate("csc180");
		Assert.assertEquals(-1.2482015977941976377153784531866, ans, 1e-15);
	}
	
	@Test
	public void testCotangent()
	{
		Calculator calc = new Calculator();
		double ans = calc.calculate("cot180");
		Assert.assertEquals(0.74699881441404438757197462319304, ans, 1e-15);
	}
	
	@Test
	public void testArcsine()
	{
		Calculator calc = new Calculator();
		double ans = calc.calculate("arcsin0.5");
		Assert.assertEquals(0.523598775598298873077107230546583, ans, 1e-15);
	}
	
	@Test
	public void testArccosine()
	{
		Calculator calc = new Calculator();
		double ans = calc.calculate("arccos0.5");
		Assert.assertEquals(1.04719755119659774615421446109316, ans, 1e-15);
	}
	
	@Test
	public void testArctangent()
	{
		Calculator calc = new Calculator();
		double ans = calc.calculate("arctan0.5");
		Assert.assertEquals(0.4636476090008061162142562314612, ans, 1e-15);
	}
	
	@Test
	public void testArcsecant()
	{
		Calculator calc = new Calculator();
		double ans = calc.calculate("arcsec180");
		Assert.assertEquals(1.565240742660983463537031231293617, ans, 1e-15);
	}
	
	@Test
	public void testArccosecant()
	{
		Calculator calc = new Calculator();
		double ans = calc.calculate("arccsc180");
		Assert.assertEquals(0.00555558413391315569429046034613, ans, 1e-15);
	}
	
	@Test
	public void testArccotangent()
	{
		Calculator calc = new Calculator();
		double ans = calc.calculate("arccot180");
		Assert.assertEquals(0.0055554984006926217576438942038, ans, 1e-15);
	}
	
	@Test
	public void testLogarithm()
	{
		Calculator calc = new Calculator();
		double ans = calc.calculate("log45");
		Assert.assertEquals(1.6532125137753436793763169117857, ans, 1e-15);
	}
	
	@Test
	public void testNaturalLogarithm()
	{
		Calculator calc = new Calculator();
		double ans = calc.calculate("ln45");
		Assert.assertEquals(3.8066624897703197573912498070712, ans, 1e-15);
	}
	
	@Test
	public void testPercentage()
	{
		Calculator calc = new Calculator();
		double ans = calc.calculate("45%");
		Assert.assertEquals(0.45, ans, 1e-15);
	}
	
	@Test
	public void testConstantPI()
	{
		Calculator calc = new Calculator();
		double ans = calc.calculate("pi");
		Assert.assertEquals(3.1415926535897932384626433832795, ans, 1e-15);
	}
	
	@Test
	public void testConstantE_1()
	{
		Calculator calc = new Calculator();
		double ans = calc.calculate("e");
		Assert.assertEquals(2.7182818284590452353602874713527, ans, 1e-15);
	}
	
}

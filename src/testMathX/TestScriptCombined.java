package testMathX;

import java.util.*;

import org.junit.Assert;
import org.junit.Test;

import mathX.v3.*;

public class TestScriptCombined
{

	@Test
	public void test1_InfixToPrefix_0()
	{
		class stubCalculator extends Calculator
		{
			public String prefixify(String raw) { return super.prefixify(raw); }
		}
		stubCalculator calc = new stubCalculator();
		String result = calc.prefixify("1.1 + 2.4");
		Assert.assertEquals("+ 1.1 2.4", result);
	}
	
	@Test
	public void test1_InfixToPrefix_1()
	{
		class stubCalculator extends Calculator
		{
			public String prefixify(String raw) { return super.prefixify(raw); }
		}
		stubCalculator calc = new stubCalculator();
		String result = calc.prefixify("2*3+1");
		Assert.assertEquals("+ * 2 3 1", result);
	}
	
	
	@Test
	public void test1_InfixToPrefix_2()
	{
		class stubCalculator extends Calculator
		{
			public String prefixify(String raw) { return super.prefixify(raw); }
		}
		stubCalculator calc = new stubCalculator();
		String result = calc.prefixify("(1+2^3)*4+5^6");
		Assert.assertEquals("+ * + 1 ^ 2 3 4 ^ 5 6", result);
	}
	
	@Test
	public void test1_InfixToPrefix_3()
	{
		class stubCalculator extends Calculator
		{
			public String prefixify(String raw) { return super.prefixify(raw); }
		}
		stubCalculator calc = new stubCalculator();
		String result = calc.prefixify("(10+21^37)*4.92+501^69.90");
		Assert.assertEquals("+ * + 10 ^ 21 37 4.92 ^ 501 69.90", result);
	}
	
	
	@Test
	public void test2_ConvertExp_1()
	{
		class stubCalculator extends Calculator
		{
			public LinkedList<IMathExp> chunkify(String prefixified) { return super.chunkify(prefixified); }
		}
		
		stubCalculator calc = new stubCalculator();
		LinkedList<IMathExp> result = calc.chunkify("+ * 2 3 1");
		
		int offset = 0;
		Assert.assertEquals("add", result.get(offset++).getName());
		Assert.assertEquals("multiply", result.get(offset++).getName());
		Assert.assertEquals("2.0", result.get(offset++).getName());
		Assert.assertEquals("3.0", result.get(offset++).getName());
		Assert.assertEquals("1.0", result.get(offset++).getName());
	}
	
	@Test
	public void test2_ConvertExp_2()
	{
		class stubCalculator extends Calculator
		{
			public LinkedList<IMathExp> chunkify(String prefixified) { return super.chunkify(prefixified); }
		}
		
		stubCalculator calc = new stubCalculator();
		LinkedList<IMathExp> result = calc.chunkify("+ * + 10 1 2 1");
		
		int offset = 0;
		Assert.assertEquals("add", result.get(offset++).toString());
		Assert.assertEquals("multiply", result.get(offset++).toString());
		Assert.assertEquals("add", result.get(offset++).toString());
		Assert.assertEquals("10.0", result.get(offset++).toString());
		Assert.assertEquals("1.0", result.get(offset++).toString());
		Assert.assertEquals("2.0", result.get(offset++).toString());
		Assert.assertEquals("1.0", result.get(offset++).toString());
	}
	
	@Test
	public void testAdd()
	{
		Calculator calc = new Calculator();
		double ans = calc.calcMagnitude("1.1 + 2.4");
		
		Assert.assertEquals(3.5d, ans, 0.0d);
	}
	
	@Test
	public void testSubtract()
	{
		Calculator calc = new Calculator();
		double ans = calc.calcMagnitude("1-2");
		
		Assert.assertEquals(-1.0d, ans, 0.0d);
	}
	
	
	@Test
	public void testMultiply()
	{
		Calculator calc = new Calculator();
		double ans = calc.calcMagnitude("1*2");
		
		Assert.assertEquals(2.0d, ans, 0.0d);
	}
	
	
	@Test
	public void testDivision_1()
	{
		Calculator calc = new Calculator();
		double ans = calc.calcMagnitude("1/2");
		
		Assert.assertEquals(0.5d, ans, 0.0d);
	}
	
	@Test
	public void testDivision_0()
	{
		Calculator calc = new Calculator();
		double ans = calc.calcMagnitude("1/0");
		Assert.assertTrue(Double.isInfinite(ans));
	}
	
	@Test
	public void testModulo()
	{
		Calculator calc = new Calculator();
		double ans = calc.calcMagnitude("9|2");
		Assert.assertEquals(1.0d, ans, 0.0d);
	}
	
	@Test
	public void testMixedPriority_1()
	{
		Calculator calc = new Calculator();
		double ans = calc.calcMagnitude("1+2*3");
		Assert.assertEquals(7.0d, ans, 0.0d);
	}
	@Test
	public void testMixedPriority_2()
	{
		Calculator calc = new Calculator();
		double ans = calc.calcMagnitude("2*3+1");
		Assert.assertEquals(7.0d, ans, 0.0d);
	}
	
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
	public void testAddVec_1()
	{
		Calculator calc = new Calculator();
		String ans = calc.calculate("(1,10)+(2,20)");
		Assert.assertEquals("<3.0, 30.0>", ans);
	}
	
	@Test
	public void testAddVec_2()
	{
		Calculator calc = new Calculator();
		String ans = calc.calculate("(1,10,20)+(2,20)");
		Assert.assertEquals("<3.0, 30.0, 20.0>", ans);
	}
	
	@Test
	public void testMax()
	{
		Calculator calc = new Calculator();
		double ans = calc.calcMagnitude("max(3, 27, 4, 9, 1)");
		Assert.assertEquals(27.0d, ans, 0.0d);
	}
	
	@Test
	public void testMin()
	{
		Calculator calc = new Calculator();
		double ans = calc.calcMagnitude("min(3, -27, 4, 9, -1)");
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
	public void testNegativeSign_1()
	{
		Calculator calc = new Calculator();
		double ans = calc.calcMagnitude("-(2*3)");
		Assert.assertEquals(-6.0d, ans, 0.0d);
	}
	
	@Test
	public void testNegativeSign_2()
	{
		Calculator calc = new Calculator();
		double ans = calc.calcMagnitude("(4*6)-(2*3)");
		Assert.assertEquals(18.0d, ans, 0.0d);
	}
	
	@Test
	public void testNegativeSign_3()
	{
		Calculator calc = new Calculator();
		double ans = calc.calcMagnitude("pi-pi+e-e");
		Assert.assertEquals(0.0d, ans, 0.0d);
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
	
	@Test
	public void testSqrt()
	{
		Calculator calc = new Calculator();
		double ans = calc.calcMagnitude("sqrt(64)");
		Assert.assertEquals(8.0d, ans, 0.0d);
	}
	
	@Test
	public void testUnsupportedOperend()
	{
		try
		{
			Calculator calc = new Calculator();
			double ans = calc.calcMagnitude("xyz(45)");
			Assert.fail();
		}
		catch(UnsupportedOperationException ex)
		{
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void testStorageRuntimeException()
	{
		try
		{
			Calculator calc = new Calculator();
			double ans = calc.calcMagnitude("3=1+2");
			Assert.fail();
		}
		catch(RuntimeException ex)
		{
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void testRegisteredOperator()
	{
		class stubCalculator extends Calculator
		{
			stubCalculator()
			{
				// register existed operator
				this.registerOperator('+', "add", 1, new IAlgorithm() {
					@Override
					public double calc(double... param)
					{
						return param[0] + param[1]; 
					}
				});
			}
		}
		
		try
		{
			stubCalculator calc = new stubCalculator();
		}
		catch(RuntimeException ex)
		{
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void testRegisteredConstant()
	{
		class stubCalculator extends Calculator
		{
			stubCalculator()
			{
				// register existed constant
				this.registerConstant('P', Math.PI);
			}
		}
		
		try
		{
			stubCalculator calc = new stubCalculator();
		}
		catch(RuntimeException ex)
		{
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void testRegisteredNameReplacement()
	{
		class stubCalculator extends Calculator
		{
			stubCalculator()
			{
				// register existed constant
				this.registerNameReplacement("ans", "last answer", Storage.Answer);
			}
		}
		
		try
		{
			stubCalculator calc = new stubCalculator();
		}
		catch(RuntimeException ex)
		{
			Assert.assertTrue(true);
		}
	}
}

package testMathX;

import mathX.v3.*;
import mathX.v3.units.IAngleUnit;

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
		System.out.println(ans);
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
				// register existed name
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
	
	@Test
	public void testAngleUnit_Degree()
	{
		class stubCalculator extends Calculator
		{
			public IAngleUnit setAngleUnit(String unitName) { return super.setAngleUnit(unitName); }
		}
		stubCalculator calc = new stubCalculator();
		calc.setAngleUnit("degree");
		double ans;
		// -- toRadian
		ans = calc.calcMagnitude("sin180");
		Assert.assertEquals(0.0d, ans, 1e-10);
		// -- toUnit
		ans = calc.calcMagnitude("arcsin0.5");
		Assert.assertEquals(30.0d, ans, 1e-10);
	}
	
	@Test
	public void testAngleUnit_Radian()
	{
		class stubCalculator extends Calculator
		{
			public IAngleUnit setAngleUnit(String unitName) { return super.setAngleUnit(unitName); }
		}
		stubCalculator calc = new stubCalculator();
		calc.setAngleUnit("radian");
		double ans;
		// -- toRadian
		ans = calc.calcMagnitude("sin180");
		Assert.assertEquals(-0.80115263573383047774673111582099, ans, 1e-10);
		// -- toUnit
		ans = calc.calcMagnitude("arcsin0.5");
		Assert.assertEquals(0.523598775598298873077107230546583, ans, 1e-10);
	}
	
	@Test
	public void testAngleUnit_Gradian()
	{
		class stubCalculator extends Calculator
		{
			public IAngleUnit setAngleUnit(String unitName) { return super.setAngleUnit(unitName); }
		}
		stubCalculator calc = new stubCalculator();
		calc.setAngleUnit("gradian");
		double ans;
		// -- toRadian
		ans = calc.calcMagnitude("sin180");
		Assert.assertEquals(0.30901699437494742410229341718282, ans, 1e-10);
		// -- toUnit
		ans = calc.calcMagnitude("arcsin0.5");
		Assert.assertEquals(33.333333333333333333333333333333, ans, 1e-10);
	}
	
	@Test
	public void testAngleUnit_Turn()
	{
		class stubCalculator extends Calculator
		{
			public IAngleUnit setAngleUnit(String unitName) { return super.setAngleUnit(unitName); }
		}
		stubCalculator calc = new stubCalculator();
		calc.setAngleUnit("turn");
		double ans;
		// -- toRadian
		ans = calc.calcMagnitude("sin180");
		Assert.assertEquals(0.0d, ans, 1e-10);
		// -- toUnit
		ans = calc.calcMagnitude("arcsin0.5");
		Assert.assertEquals(0.08333333333333333333333333333333, ans, 1e-10);
	}
	
	@Test
	public void testBase_Decimal()
	{
		class stubCalculator extends Calculator
		{
			public IBaseState setBase(int base) { return super.setBase(base); }
		}
		stubCalculator calc = new stubCalculator();
		calc.setBase(10);
		String ans = calc.calculate("10");
		Assert.assertEquals("10.0", ans);
	}
	
	@Test
	public void testBase_Hexadecimal()
	{
		class stubCalculator extends Calculator
		{
			public IBaseState setBase(int base) { return super.setBase(base); }
		}
		stubCalculator calc = new stubCalculator();
		calc.setBase(16);
		String ans = calc.calculate("10");
		Assert.assertEquals("a", ans);
	}
	
	@Test
	public void testBase_Octal()
	{
		class stubCalculator extends Calculator
		{
			public IBaseState setBase(int base) { return super.setBase(base); }
		}
		stubCalculator calc = new stubCalculator();
		calc.setBase(8);
		String ans = calc.calculate("10");
		Assert.assertEquals("12", ans);

	}
	
	@Test
	public void testBase_Binary()
	{
		class stubCalculator extends Calculator
		{
			public IBaseState setBase(int base) { return super.setBase(base); }
		}
		stubCalculator calc = new stubCalculator();
		calc.setBase(2);
		String ans = calc.calculate("10");
		Assert.assertEquals("1010", ans);
	}
}
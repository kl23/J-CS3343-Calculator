package testMathX;

import java.util.*;

import org.junit.Assert;
import org.junit.Test;

import mathX.v3.*;

public class TestBasic
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
}

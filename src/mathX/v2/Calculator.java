package mathX.v2;

import java.util.*;

public class Calculator {
	
	public Calculator()
	{
		// register operators
		this.registerOperator('+', "add", 1, new IAlgorithm() {
			@Override
			public double calc(Iterator<IMathExp> iterator, double... param)
			{
				return param[0] + param[1]; 
			}
		});
		this.registerOperator('-', "subtract", 1, new IAlgorithm() {
			@Override
			public double calc(Iterator<IMathExp> iterator, double... param)
			{
				return param[0] - param[1]; 
			}
		});
		this.registerOperator('*', "multiply", 2, new IAlgorithm() {
			@Override
			public double calc(Iterator<IMathExp> iterator, double... param)
			{
				return param[0] * param[1]; 
			}
		});
		this.registerOperator('/', "divide", 2, new IAlgorithm() {
			@Override
			public double calc(Iterator<IMathExp> iterator, double... param)
			{
				return param[0] / param[1]; 
			}
		});
		
		this.registerOperator('^', "exponential", 3, new IAlgorithm() {
			@Override
			public double calc(Iterator<IMathExp> iterator, double... param)
			{
				return Math.pow(param[0], param[1]); 
			}
		});
		
		this.registerOperator('|', "modulo", 2, new IAlgorithm() {
			@Override
			public double calc(Iterator<IMathExp> iterator, double... param)
			{
				return param[0] % param[1]; 
			}
		});
		
		// register functions
		this.registerFunction((char)128, "sine", new IAlgorithm() {
			@Override
			public double calc(Iterator<IMathExp> iterator, double... param)
			{
				return Math.sin(param[0]); 
			}
		});
		
		this.registerFunction((char)129, "cosine", new IAlgorithm() {
			@Override
			public double calc(Iterator<IMathExp> iterator, double... param)
			{
				return Math.cos(param[0]); 
			}
		});
		
		this.registerFunction((char)130, "tangent", new IAlgorithm() {
			@Override
			public double calc(Iterator<IMathExp> iterator, double... param)
			{
				return Math.tan(param[0]); 
			}
		});
		
		this.registerFunction((char)131, "secant", new IAlgorithm() {
			@Override
			public double calc(Iterator<IMathExp> iterator, double... param)
			{
				return 1.0 / Math.cos(param[0]); 
			}
		});
		
		this.registerFunction((char)132, "cosecant", new IAlgorithm() {
			@Override
			public double calc(Iterator<IMathExp> iterator, double... param)
			{
				return 1.0 / Math.sin(param[0]); 
			}
		});
		
		this.registerFunction((char)133, "cotangent", new IAlgorithm() {
			@Override
			public double calc(Iterator<IMathExp> iterator, double... param)
			{
				return 1.0 / Math.tan(param[0]); 
			}
		});
		
		this.registerFunction((char)134, "arcsine", new IAlgorithm() {
			@Override
			public double calc(Iterator<IMathExp> iterator, double... param)
			{
				return Math.asin(param[0]); 
			}
		});
		
		this.registerFunction((char)135, "arccosine", new IAlgorithm() {
			@Override
			public double calc(Iterator<IMathExp> iterator, double... param)
			{
				return Math.acos(param[0]); 
			}
		});
		
		this.registerFunction((char)136, "arctangent", new IAlgorithm() {
			@Override
			public double calc(Iterator<IMathExp> iterator, double... param)
			{
				return Math.atan(param[0]); 
			}
		});
		
		this.registerFunction((char)137, "arcsecant", new IAlgorithm() {
			@Override
			public double calc(Iterator<IMathExp> iterator, double... param)
			{
				return Math.acos(1.0 / param[0]); 
			}
		});
		
		this.registerFunction((char)138, "arccosecant", new IAlgorithm() {
			@Override
			public double calc(Iterator<IMathExp> iterator, double... param)
			{
				return Math.asin(1.0 / param[0]); 
			}
		});
		
		this.registerFunction((char)139, "arccotangent", new IAlgorithm() {
			@Override
			public double calc(Iterator<IMathExp> iterator, double... param)
			{
				return Math.atan(1.0 / param[0]); 
			}
		});
		
		this.registerFunction((char)140, "logarithm", new IAlgorithm() {
			@Override
			public double calc(Iterator<IMathExp> iterator, double... param)
			{
				return Math.log10(param[0]); 
			}
		});
		
		this.registerFunction((char)141, "NaturalLogarithm", new IAlgorithm() {
			@Override
			public double calc(Iterator<IMathExp> iterator, double... param)
			{
				return Math.log(param[0]); 
			}
		});
		
		// register constants
		this.registerConstant('P', Math.PI);
		this.registerConstant('e', Math.E);
	}
	
	private Map<Character, IMathExp> tokenKeys = new HashMap<>(); 
	
	
	public void registerOperator(char symbol, String name, int priority, IAlgorithm algorithm)
	{
		if (this.tokenKeys.containsKey(symbol)) throw new RuntimeException("Symbol is already registered.");
		this.tokenKeys.put(symbol, new Operator(name, priority, algorithm));
	}
	
	public void registerFunction(char symbol, String name, IAlgorithm algorithm)
	{
		if (this.tokenKeys.containsKey(symbol)) throw new RuntimeException("Symbol is already registered.");
		this.tokenKeys.put(symbol, new Function(name, algorithm));
	}
	
	public void registerConstant(char symbol, double number)
	{
		if (this.tokenKeys.containsKey(symbol)) throw new RuntimeException("Symbol is already registered.");
		this.tokenKeys.put(symbol, new Number(number));
	}
	
	private String convertFunctionNameToSymbol(String mathRaw)
	{
		// Arc-Trigonometric Functions
		mathRaw = mathRaw.replaceAll("arcsin", String.valueOf((char)134));
		mathRaw = mathRaw.replaceAll("arccos", String.valueOf((char)135));
		mathRaw = mathRaw.replaceAll("arctan", String.valueOf((char)136));
		mathRaw = mathRaw.replaceAll("arcsec", String.valueOf((char)137));
		mathRaw = mathRaw.replaceAll("arccsc", String.valueOf((char)138));
		mathRaw = mathRaw.replaceAll("arccot", String.valueOf((char)139));
		
		// Trigonometric Functions
		mathRaw = mathRaw.replaceAll("sin", String.valueOf((char)128));
		mathRaw = mathRaw.replaceAll("cos", String.valueOf((char)129));
		mathRaw = mathRaw.replaceAll("tan", String.valueOf((char)130));
		mathRaw = mathRaw.replaceAll("sec", String.valueOf((char)131));
		mathRaw = mathRaw.replaceAll("csc", String.valueOf((char)132));
		mathRaw = mathRaw.replaceAll("cot", String.valueOf((char)133));
		
		// Log Functions
		mathRaw = mathRaw.replaceAll("log", String.valueOf((char)140));
		mathRaw = mathRaw.replaceAll("ln", String.valueOf((char)141));
		
		// Percentage and Constant
		mathRaw = mathRaw.replaceAll("%", "/100.0");
		mathRaw = mathRaw.replaceAll("pi", "P");

		return mathRaw;
	}
	
	public double calculate(String mathRaw)
	{
		mathRaw = mathRaw.toLowerCase();
		mathRaw = convertFunctionNameToSymbol(mathRaw);
		String prefixified = this.prefixify(mathRaw);
		LinkedList<IMathExp> expChain = this.chunkify(prefixified);
		
		Iterator<IMathExp> iterator = expChain.iterator();
		IMathExp mathExp = iterator.next();
		return mathExp.calc(iterator);	
	}
	

	private Stack<IMathExp> createMathExpressions(String mathPrefix)
	{
		throw new UnsupportedOperationException();
	}
	
	protected String prefixify(String raw)
	{
		// remove all spaces
		raw = raw.replaceAll("/\\s/", "");
		
		// convert brackets
		raw = raw.replaceAll("/[\\[{]/", "(");
		raw = raw.replaceAll("/[\\]}]/", ")");
		
		// check string contains invalid characters
		
		
		// proceed
		char[] chs = raw.toCharArray();
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		for (int i = chs.length - 1; i >= 0; i--)
		{
			if (' ' == chs[i])
				continue;	// skip
			else if (chs[i] >= '0' && chs[i] <= '9')
				sb.append(chs[i]);
			else if ('.' == chs[i])
				sb.append(chs[i]);
			else if (')' == chs[i])
				stack.push(')');
			else if ('(' == chs[i])
			{
				char c;
				while(')' != (c = stack.pop()))
					sb.append(" " + c + " ");
			}
			else if (tokenKeys.containsKey(chs[i]))
			{
				
				if (stack.size() > 0 && ')' != stack.peek())
				{
					IMathExp ins = tokenKeys.get(stack.peek());
					IMathExp exp = tokenKeys.get(chs[i]);
					if (exp.getPriority() < ins.getPriority())
						sb.append(" " + stack.pop());					
				}
				stack.push(chs[i]);
				sb.append(' ');
			}
			else
				throw new UnsupportedOperationException("'" + chs[i] + "' is not supported.");
		}
		
		// pop last
		while (stack.size() > 0)
			sb.append(" " + stack.pop());
		
		String rtn = sb.reverse().toString();
		rtn = rtn.replaceAll(" +", " ");
		return rtn;
	}
	
	protected LinkedList<IMathExp> chunkify(String prefixified)
	{
		LinkedList<IMathExp> rtn = new LinkedList<IMathExp>();
		String[] chunks = prefixified.split(" ");
		
		for (int i = 0; i < chunks.length; i++)
		{
			switch(chunks[i].length())
			{
				case 0: break; //skip
				case 1:
					char c = chunks[i].charAt(0);
					if (c < '0' || c > '9')
					{
						rtn.add(tokenKeys.get(c));
						break;
					} // else goto default
				default:
					double d = Double.parseDouble(chunks[i]);
					rtn.add(new Number(d));
					break;
			}
		} // end for
		
		return rtn;
	}
	
	
}

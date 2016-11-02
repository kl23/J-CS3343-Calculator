package mathX.v3;

import java.util.*;
import java.util.Map.Entry;

public class Calculator {
	
	public Calculator()
	{
		// register comma -> vector2
		this.tokenKeys.put(',', new VecDelimitor());
		
		
		// register operators
		this.registerOperator('+', "add", 1, new IAlgorithm() {
			@Override
			public double calc(double... param)
			{
				return param[0] + param[1]; 
			}
		});
		this.registerOperator('-', "subtract", 1, new IAlgorithm() {
			@Override
			public double calc(double... param)
			{
				return param[0] - param[1]; 
			}
		});
		this.registerOperator('*', "multiply", 2, new IAlgorithm() {
			@Override
			public double calc(double... param)
			{
				return param[0] * param[1]; 
			}
		});
		this.registerOperator('/', "divide", 2, new IAlgorithm() {
			@Override
			public double calc(double... param)
			{
				return param[0] / param[1]; 
			}
		});
		
		this.registerOperator('^', "exponential", 3, new IAlgorithm() {
			@Override
			public double calc(double... param)
			{
				return Math.pow(param[0], param[1]); 
			}
		});
		
		this.registerOperator('|', "modulo", 2, new IAlgorithm() {
			@Override
			public double calc(double... param)
			{
				return param[0] % param[1]; 
			}
		});
		
		// register functions
		// -- arc-functions must be registered before, as their names collides
		this.registerFunction("arcsin", "arcsine", new IAlgorithm() {
			@Override
			public double calc(double... param)
			{
				return Math.asin(param[0]); 
			}
		});
		
		this.registerFunction("arccos", "arccosine", new IAlgorithm() {
			@Override
			public double calc(double... param)
			{
				return Math.acos(param[0]); 
			}
		});
		
		this.registerFunction("arctan", "arctangent", new IAlgorithm() {
			@Override
			public double calc(double... param)
			{
				return Math.atan(param[0]); 
			}
		});
		
		this.registerFunction("arcsec", "arcsecant", new IAlgorithm() {
			@Override
			public double calc(double... param)
			{
				return Math.acos(1.0d / param[0]); 
			}
		});
		
		this.registerFunction("arccsc", "arccosecant", new IAlgorithm() {
			@Override
			public double calc(double... param)
			{
				return Math.asin(1.0d / param[0]); 
			}
		});
		
		this.registerFunction("arccot", "arccotangent", new IAlgorithm() {
			@Override
			public double calc(double... param)
			{
				return Math.atan(1.0d / param[0]); 
			}
		});
		this.registerFunction("sin", "sine", new IAlgorithm() {
			@Override
			public double calc(double... param)
			{
				return Math.sin(param[0]); 
			}
		});
		
		this.registerFunction("cos", "cosine", new IAlgorithm() {
			@Override
			public double calc(double... param)
			{
				return Math.cos(param[0]); 
			}
		});
		
		this.registerFunction("tan", "tangent", new IAlgorithm() {
			@Override
			public double calc(double... param)
			{
				return Math.tan(param[0]); 
			}
		});
		
		this.registerFunction("sec", "secant", new IAlgorithm() {
			@Override
			public double calc(double... param)
			{
				return 1.0d / Math.cos(param[0]); 
			}
		});
		
		this.registerFunction("csc", "cosecant", new IAlgorithm() {
			@Override
			public double calc(double... param)
			{
				return 1.0d / Math.sin(param[0]); 
			}
		});
		
		this.registerFunction("cot", "cotangent", new IAlgorithm() {
			@Override
			public double calc(double... param)
			{
				return 1.0d / Math.tan(param[0]); 
			}
		});
		
		this.registerFunction("log", "logarithm", new IAlgorithm() {
			@Override
			public double calc(double... param)
			{
				double base = param.length > 1 ? param[1] : 10.0d;
				return Math.log(param[0]) / Math.log(base); 
			}
		});
		
		this.registerFunction("ln", "NaturalLogarithm", new IAlgorithm() {
			@Override
			public double calc(double... param)
			{
				return Math.log(param[0]);
			}
		});
		
		// register constants
		this.registerConstant('P', Math.PI);
		this.registerConstant('e', Math.E);
	}
	
	private Map<Character, IMathExp> tokenKeys = new HashMap<>();
	private Map<String, Character> fncSymbols = new LinkedHashMap<>();		// note that linked hash map preserves the insertion order, which is required in this case
	private int fnOffset = 128;
	
	public void registerOperator(char symbol, String name, int priority, IAlgorithm algorithm)
	{
		if (this.tokenKeys.containsKey(symbol)) throw new RuntimeException("Symbol is already registered.");
		this.tokenKeys.put(symbol, new Operator(name, priority, algorithm));
	}
	
	public void registerFunction(String regName, String fullName, IAlgorithm algorithm)
	{
		regName = regName.toLowerCase();
		
		if (this.fncSymbols.containsKey(regName)) throw new RuntimeException("Label is already registered.");
		
		// get next usable symbol, no protection
		char symbol;
		while (this.tokenKeys.containsKey(symbol = (char)fnOffset++));
		
		this.fncSymbols.put(regName, symbol);
		this.tokenKeys.put(symbol, new Function(fullName, algorithm));
	}
	
	public void registerConstant(char symbol, double number)
	{
		if (this.tokenKeys.containsKey(symbol)) throw new RuntimeException("Symbol is already registered.");
		this.tokenKeys.put(symbol, new Number(number));
	}
	
	private String convertToSymbols(String mathRaw)
	{
		for (Entry<String, Character> e : this.fncSymbols.entrySet()) {
			mathRaw = mathRaw.replaceAll(e.getKey(), e.getValue().toString());
		}
		
		// Percentage and Constant
		mathRaw = mathRaw.replaceAll("%", "/100.0");
		mathRaw = mathRaw.replaceAll("pi", "P");

		return mathRaw;
	}
	
	public double calcMagnitude(String mathRaw) { return _calculate(mathRaw).magnitude(); }
	public String calculate(String mathRaw) { return _calculate(mathRaw).toString(); }
	private mVector _calculate(String mathRaw)
	{
		mathRaw = mathRaw.toLowerCase();
		mathRaw = convertToSymbols(mathRaw);
		String prefixified = this.prefixify(mathRaw);
		LinkedList<IMathExp> expChain = this.chunkify(prefixified);
		
		Iterator<IMathExp> iterator = expChain.iterator();
		IMathExp mathExp = iterator.next();
		return mathExp.value(iterator);	
	}
	

	protected String prefixify(String raw)
	{
		// remove all spaces
		raw = raw.replaceAll("/\\s/", "");
		
		// convert brackets
		raw = raw.replaceAll("/[\\[{<]/", "(");
		raw = raw.replaceAll("/[\\]}>]/", ")");
		
		// check string contains invalid characters
		
		
		// proceed
		char[] chs = raw.toCharArray();
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		boolean _isMinus = false;
		for (int i = chs.length - 1; i >= 0; i--)
		{
			if (' ' == chs[i])
				continue;	// skip
			else if (chs[i] >= '0' && chs[i] <= '9' || '.' == chs[i])
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
				if (_isMinus) {
					sb.setLength(sb.length() -1);
					sb.append(stack.pop());
				}
				
				if (stack.size() > 0 && ')' != stack.peek())
				{
					IMathExp ins = tokenKeys.get(stack.peek());
					IMathExp exp = tokenKeys.get(chs[i]);
					if (exp.getPriority() < ins.getPriority())
						sb.append(" " + stack.pop());					
				}
				stack.push(chs[i]);
				sb.append(' ');
				
				//--
				_isMinus = ('-' == chs[i]);
				continue;
			}
			else {
				throw new UnsupportedOperationException("'" + chs[i] + "' is not supported.");
			}
			_isMinus = false;
		}
		
		// last check
		if (_isMinus) {
			sb.setLength(sb.length() -1);
			sb.append(stack.pop());
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

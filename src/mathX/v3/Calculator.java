package mathX.v3;

import java.util.*;
import java.util.Map.Entry;

public class Calculator {
	
	public Calculator()
	{
		// register =
		this.tokenKeys.put('=', new AssignmentDelimitor());
		// register comma -> vector
		this.tokenKeys.put(',', new VecDelimitor());
		
		// register constants
		this.registerConstant('P', Math.PI);
		this.registerConstant('E', Math.E);
		
		
		// register independent classes
		this.registerNameReplacement("ans", "last answer", Storage.Answer);	// last answer
		this.registerNameReplacement("mode", "mode", new Mode());			// mode
		
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
		
		this.registerOperator('^', "exponential", Integer.MAX_VALUE-1, new IAlgorithm() {
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
		
		this.registerFunction("ln", "naturalLogarithm", new IAlgorithm() {
			@Override
			public double calc(double... param)
			{
				return Math.log(param[0]);
			}
		});
		
		this.registerFunction("max", "maximum", new IAlgorithm() {
			@Override
			public double calc(double... param)
			{
				double ans=param[0];
				for(int i=1;i<param.length;i++)
					ans = param[i]>ans?param[i]:ans;
				return ans;
			}
		});
		
		this.registerFunction("min", "minimum", new IAlgorithm() {
			@Override
			public double calc(double... param)
			{
				double ans=param[0];
				for(int i=1;i<param.length;i++)
					ans = param[i]<ans?param[i]:ans;
				return ans;
			}
		});
		
		this.registerFunction("mean", "mean", new IAlgorithm() {
			@Override
			public double calc(double... param)
			{
				double sum=0.0d;
				for(int i=0;i<param.length;i++)
					sum += param[i];
				return sum/param.length;
			}
		});
		
		this.registerFunction("median", "median", new IAlgorithm() {
			@Override
			public double calc(double... param)
			{
				Arrays.sort(param);
				double ans;
				if (param.length % 2 == 0)
					ans = (param[param.length/2] + param[param.length/2 - 1])/2.0;
				else
					ans = param[param.length/2];
				return ans;
			}
		});
		
		this.registerFunction("abs", "absolute", new IAlgorithm() {
			@Override
			public double calc(double... param)
			{
				return Math.abs(param[0]);
			}
		});
		
		this.registerFunction("var", "variance", new IAlgorithm() {
			@Override
			public double calc(double... param)
			{
				double sum=0.0d, summation=0.0d;
				for(int i=0;i<param.length;i++)
					sum += param[i];
				double mean = sum/param.length;
				
				for(int i=0;i<param.length;i++)
					summation += Math.pow(param[i]-mean, 2);
				return summation/(param.length-1);
			}
		});
		
		this.registerFunction("sd", "standardDeviation", new IAlgorithm() {
			@Override
			public double calc(double... param)
			{
				double sum=0.0d, summation=0.0d;
				for(int i=0;i<param.length;i++)
					sum += param[i];
				double mean = sum/param.length;
				
				for(int i=0;i<param.length;i++)
					summation += Math.pow(param[i]-mean, 2);
				return Math.sqrt(summation/(param.length-1));
			}
		});
		
		this.registerFunction("sqrt", "squareRoot", new IAlgorithm() {
			@Override
			public double calc(double... param)
			{
				return Math.sqrt(param[0]);
			}
		});
		
		// register storage - must at last
		for (char c = 'A'; c <= 'D'; c++)
			this.tokenKeys.put(c, new Storage("storage " + c));
	}
	
	private Map<Character, IMathExp> tokenKeys = new HashMap<>();
	private Map<String, Character> fncSymbols = new LinkedHashMap<>();		// note that linked hash map preserves the insertion order, which is required in this case
	private int fnOffset = 131;
	
	public void registerOperator(char symbol, String name, int priority, IAlgorithm algorithm)
	{
		if (this.tokenKeys.containsKey(symbol)) throw new RuntimeException("Symbol is already registered.");
		this.tokenKeys.put(symbol, new Operator(name, priority, algorithm));
	}
	
	public void registerFunction(String regName, String fullName, IAlgorithm algorithm)
	{
		IMathExp mathExp = new Function(fullName, algorithm);
		this.registerNameReplacement(regName, fullName, mathExp);
	}
	protected void registerNameReplacement(String regName, String fullName, IMathExp mathExp)
	{
		regName = regName.toLowerCase();
		
		if (this.fncSymbols.containsKey(regName)) throw new RuntimeException("Label is already registered.");
		
		// get next usable symbol, no protection
		char symbol;
		while (this.tokenKeys.containsKey(symbol = (char)fnOffset++));
		
		this.fncSymbols.put(regName, symbol);
		this.tokenKeys.put(symbol, mathExp);
	}
	public void registerConstant(char symbol, double number)
	{
		if (this.tokenKeys.containsKey(symbol)) throw new RuntimeException("Symbol is already registered.");
		this.tokenKeys.put(symbol, new mVector(number));
	}
	
	private String convertToSymbols(String mathRaw)
	{
		for (Entry<String, Character> e : this.fncSymbols.entrySet()) {
			mathRaw = mathRaw.replaceAll(e.getKey(), e.getValue().toString());
		}
		
		// convert others
		mathRaw = mathRaw.replaceAll("%", "/100.0");
		mathRaw = mathRaw.replaceAll("pi", "P");
		//mathRaw = mathRaw.replaceAll("mode", String.valueOf((char)129));
		//mathRaw = mathRaw.replaceAll("ans", String.valueOf((char)130));
		
		// back to upper, to support storage
		mathRaw = mathRaw.toUpperCase();
		
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
		mVector ans = mathExp.value(iterator);
		Storage.Answer.setValue(ans);
		return ans;
	}
	

	protected String prefixify(String raw)
	{
		// remove all spaces
		raw = raw.replaceAll("\\s","");
		
		// convert brackets
		raw = raw.replaceAll("[\\[{<]","(");
		raw = raw.replaceAll("[\\]}>]",")");
		
		// check string contains invalid characters
		
		// proceed
		char[] chs = raw.toCharArray();	
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		for (int i = chs.length - 1; i >= 0; i--)
		{
			//check negative sign
			if(chs[i]=='-')
			{
				int pos=i-1;
				boolean _isSign=true;
				while(pos>=0)
				{
					if(chs[pos] >= '0' && chs[pos] <= '9' || chs[pos]=='P' || chs[pos]=='e')
						_isSign=false;
					if(chs[pos]!='(' && chs[pos]!=')')
						break;
					pos--;
				}
				if(_isSign==true)
					chs[i]=(char)128;
			}
			
			if (chs[i] >= '0' && chs[i] <= '9' || '.' == chs[i] || (char)128 == chs[i])
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
				if(tokenKeys.get(chs[i]) instanceof mVector || tokenKeys.get(chs[i]).getName()=="answer")
				{
					sb.append(chs[i]);
					continue;
				}
				else if (stack.size() > 0 && ')' != stack.peek())
				{
					IMathExp ins = tokenKeys.get(stack.peek());
					IMathExp exp = tokenKeys.get(chs[i]);
					if (exp.getPriority() < ins.getPriority())
						sb.append(" " + stack.pop());
				}
				stack.push(chs[i]);
				sb.append(' ');
			}
			else {
				throw new UnsupportedOperationException("Operend '" + chs[i] + "' is not supported.");
			}
		}
		
		// pop last
		while (stack.size() > 0)
			sb.append(" " + stack.pop());
		
		String rtn = sb.reverse().toString();
		rtn = rtn.replaceAll(" +", " ");
		rtn = rtn.replaceAll(String.valueOf((char)128), "* -1 ");
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
					rtn.add(new mVector(d));
					break;
			}
		} // end for
		
		return rtn;
	}
	
	
}

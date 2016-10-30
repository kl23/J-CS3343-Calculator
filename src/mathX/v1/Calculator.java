package mathX.v1;

import java.util.*;

public class Calculator {
	
	public Calculator()
	{
		// register algorithms
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
	}
	
	private Map<Character, IMathExp> tokenKeys = new HashMap<>(); 
	
	
	public void registerOperator(char symbol, String name, int priority, IAlgorithm algorithm)
	{
		if (this.tokenKeys.containsKey(symbol)) throw new RuntimeException("Symbol is already registered.");
		this.tokenKeys.put(symbol, new Operator(name, priority, algorithm));
	}
	
	public double calculate(String mathRaw)
	{
		String prefixified = this.prefixify(mathRaw);
		LinkedList<IMathExp> expChain = this.chunkify(prefixified);
		
		Iterator<IMathExp> iterator = expChain.iterator();
		IMathExp mathExp = iterator.next();
		return mathExp.calc(iterator);	
	}
	

	protected Stack<IMathExp> createMathExpressions(String mathPrefix)
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

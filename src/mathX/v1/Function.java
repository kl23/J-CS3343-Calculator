package mathX.v1;

import java.util.Iterator;

public final class Function implements IMathExp 
{
	public Function(String name, IAlgorithm algorithm)
	{
		this.name = name;
	}
	private String name;
	private IAlgorithm algorithm;
	
	@Override
	public int getPriority() { return Integer.MAX_VALUE; }
	
	@Override
	public String getName() { return this.name; }
	
	@Override
	public double calc(Iterator<IMathExp> stack)
	{
		return algorithm.calc(stack, stack.next());
	}
	
}

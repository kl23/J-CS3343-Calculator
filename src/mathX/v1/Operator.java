package mathX.v1;

import java.util.Iterator;

public final class Operator implements IMathExp 
{
	public Operator(String name, int priority, IAlgorithm algorithm)
	{
		this.name = name;
		this.priority = priority;
		this.algorithm = algorithm;
	}
	
	private String name;
	private int priority;
	private IAlgorithm algorithm;
	
	@Override
	public int getPriority() { return this.priority; }
	
	@Override
	public String getName() { return this.name; }
	
	@Override
	public double calc(Iterator<IMathExp> iterator)
	{
		IMathExp left = iterator.next();
		IMathExp right = iterator.next();
		return algorithm.calc(iterator, left, right);
	}
}

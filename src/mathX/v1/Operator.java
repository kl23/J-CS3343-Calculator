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
		double left = iterator.next().calc(iterator);
		double right = iterator.next().calc(iterator);
		return algorithm.calc(iterator, left, right);
	}
}

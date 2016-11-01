package mathX.v3;

import java.util.Iterator;

public final class Function implements IMathExp 
{
	public Function(String name, IAlgorithm algorithm)
	{
		this.name = name;
		this.algorithm = algorithm;
	}
	private String name;
	private IAlgorithm algorithm;
	
	@Override
	public int getPriority() { return Integer.MAX_VALUE; }
	
	@Override
	public String getName() { return this.name; }
	
	@Override
	public mVector value(Iterator<IMathExp> iterator)
	{
		mVector vector = iterator.next().value(iterator);
		
		// calculate
		double[] vs = { algorithm.calc(vector.values) };
		
		return new mVector(vs);
	}
	
}

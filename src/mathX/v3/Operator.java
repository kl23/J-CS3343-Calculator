package mathX.v3;

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
	public mVector value(Iterator<IMathExp> iterator)
	{
		mVector left = iterator.next().value(iterator);
		mVector right = iterator.next().value(iterator);

		// init
		int i = 0;
		int min = left.size();
		int max = right.size();
		double[] vs;
		
		if (max < min) {
			vs = left.values;
			// swap
			min ^= max;
			max ^= min;
			min ^= max;
		} else {
			vs = right.values;	
		}
		
		// calculate
		for (; i < min; i++) {
			vs[i] = algorithm.calc(left.get(i), right.get(i));
		}
		
		return new mVector(vs);
	}

}

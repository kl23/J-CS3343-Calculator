package mathX.v3;

import java.util.Iterator;

public final class Mode implements IMathExp 
{
	public Mode() { }
	
	@Override
	public int getPriority() { return Integer.MAX_VALUE; }
	
	@Override
	public String getName() { return "mode"; }
	
	@Override
	public mVector value(Iterator<IMathExp> iterator)
	{
		mVector vector = iterator.next().value(iterator);
		
		// calculate
		// get the mode from this collection --> vector.values
		
		// use your method output to this array
		double[] vs = null;
		
		return new mVector(vs);
	}
	
}

package mathX.v3;

import java.util.Iterator;

public final class VecDelimitor implements IMathExp 
{
	@Override
	public int getPriority() { return Integer.MAX_VALUE; }
	
	@Override
	public String getName() { return "comma"; }
	
	@Override
	public mVector value(Iterator<IMathExp> iterator)
	{
		mVector left = iterator.next().value(iterator);
		mVector right = iterator.next().value(iterator);

		// try to handle 2D only
		double[] vs = { left.get(0), right.get(0) };

		return new mVector(vs);
	}

}

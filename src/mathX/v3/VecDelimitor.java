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
		
		double[] vs = new double[left.size()+1];
		for(int i=0; i<left.size();i++)
			vs[i]=left.get(i);
		
		vs[vs.length-1]=right.get(0);

		return new mVector(vs);
	}

}

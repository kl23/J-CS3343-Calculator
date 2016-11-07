package mathX.v3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class Mode implements IMathExp 
{
	public Mode() { }
	
	@Override
	public int getPriority() { return Integer.MAX_VALUE-2; }
	
	@Override
	public String getName() { return "mode"; }
	
	@Override
	public mVector value(Iterator<IMathExp> iterator)
	{
		mVector vector = iterator.next().value(iterator);
		
		// calculate
		double[] vs = new double[0];
		Map<Double, Integer> arrayVals = new HashMap<>();
		int maxCount = 0, vsIndex = 0;
		for(int i=0; i<vector.values.length;i++)
		{
			boolean keyExisted = arrayVals.containsKey(vector.values[i]);
	        
			int count = 1;
			if(keyExisted)
				count += arrayVals.get(vector.values[i]);

			arrayVals.put(vector.values[i], count);
			
			if(count>maxCount)
				maxCount = count;
		}

		for (Map.Entry<Double, Integer> entry : arrayVals.entrySet())
		{
			  if (entry.getValue().equals(maxCount))
			  {
				  vs = Arrays.copyOf(vs, vs.length+1);
				  vs[vsIndex++]=entry.getKey();
			  }
		}
		
		Arrays.sort(vs);
		return new mVector(vs);
	}
	
}

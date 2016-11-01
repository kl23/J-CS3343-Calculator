package mathX.v3;

import java.util.Arrays;
import java.util.Iterator;

// note that this is not really a vector, just a collection of various numbers
class mVector implements IMathExp {
	
	public final int size() { return values.length; };
	
	/*internal*/ double[] values;
	
	public mVector(double... values) { this.values = values; }
	public double get(int index) { return values[index]; }
	
	public double magnitude()
	{
		double sum = 0.0d;
		for (double d : values)
			sum += d * d;
		return Math.sqrt(sum);	
	}
	@Override
	public int getPriority() { return Integer.MAX_VALUE; }
	
	@Override
	public String getName() {
		return Arrays.toString(values);
	}
	@Override
	public mVector value(Iterator<IMathExp> iterator) {
		// TODO Auto-generated method stub
		return null;
	}
}

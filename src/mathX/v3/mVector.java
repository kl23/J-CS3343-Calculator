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
		if (values.length == 1) { return values[0]; }
		double sum = 0.0d;
		for (double d : values)
			sum += d * d;
		return Math.sqrt(sum);	
	}
	@Override
	public int getPriority() { return Integer.MAX_VALUE; }
	
	@Override
	public String getName() { return this.toString(); }
	
	@Override
	public String toString() {
		int i = values.length;
		if (i == 1) { return String.valueOf(values[0]); }
		
		StringBuilder sb = new StringBuilder("<");
		do {
			sb.append(String.valueOf(values[values.length - i])).append(", ");
		} while (--i>1);
		sb.append(String.valueOf(values[values.length - 1])).append(">");
		
		return sb.toString();
	}
	
	@Override
	public mVector value(Iterator<IMathExp> iterator) {
		return this;
	}
}

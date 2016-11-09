package mathX.v3;

import java.util.Iterator;

class mVector implements IMathExp {
	
	public static final mVector Zero = new mVector(0.0d); 
	
	public final int size() { return values.length; };
	
	/*internal*/ double[] values;
	
	public mVector(double... values) { this.values = values; }
	public double get(int index) { return values[index]; }
	
	public double magnitude()
	{
		return values[0];
	}
	@Override
	public int getPriority() { return Integer.MAX_VALUE; }
	
	@Override
	public String getName() { return this.toString(); }
	
	@Override
	public String toString() {
		return String.valueOf(values[0]);
	}
	
	@Override
	public mVector value(Iterator<IMathExp> iterator) {
		return this;
	}
}

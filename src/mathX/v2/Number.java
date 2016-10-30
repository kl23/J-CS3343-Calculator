package mathX.v2;

import java.util.Iterator;

public class Number implements IMathExp
{
	//constructor
	public Number(double value) { this._v = value; }
	
	//field
	private double _v;
	
	@Override
	public int getPriority() { return Integer.MIN_VALUE; }
	
	@Override
	public String getName() { return ""+this._v; }
	
	@Override
	public double calc(Iterator<IMathExp> stack) { return this._v; }
	
	public double getValue() { return this._v; }

}

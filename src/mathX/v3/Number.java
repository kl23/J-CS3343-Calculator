package mathX.v3;

import java.util.Iterator;

public class Number extends mVector implements IMathExp
{
	//constructor
	public Number(double value) { super(value); }
	
	@Override
	public double magnitude() { return this.get(0); }
	
	
	@Override
	public String getName() { return ""+this.get(0); }
	
	@Override
	public mVector value(Iterator<IMathExp> iterator) { return this; }
	
}

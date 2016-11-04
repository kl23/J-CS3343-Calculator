package mathX.v3;

import java.util.*;

public class Storage implements IMathExp
{
	private mVector values;
	private String name;
	
	public static final Storage Answer = new Storage("answer");

	public Storage(String name) {
		this.name = name;
	}
	
	@Override
	public int getPriority() { return Integer.MAX_VALUE; }

	@Override
	public String getName() { return this.name; }
	
	// note the modifier is not public
	void setValue(mVector value) {
		this.values = value;
	}
	
	@Override
	public mVector value(Iterator<IMathExp> iterator) {
		return this.values;
	}
}

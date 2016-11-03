package mathX.v3;

import java.util.Iterator;

public class Answer implements IMathExp
{
	private mVector values;
	
	private static Answer instance;

	private Answer() {
		values = null;
	}
	
	public static Answer getInstance() {
		if (instance == null) instance = new Answer();
		return instance;
	}
	
	@Override
	public int getPriority() { return Integer.MAX_VALUE; }

	@Override
	public String getName() { return "last answer"; }
	
	public void setValue(mVector ans) {
		this.values=ans;
	}
	
	@Override
	public mVector value(Iterator<IMathExp> iterator) {
		return this.values;
	}
}

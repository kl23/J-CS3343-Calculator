package mathX.v3;

import java.util.Iterator;

public interface IMathExp
{
	int getPriority();
	String getName();
	mVector value(Iterator<IMathExp> iterator);
}

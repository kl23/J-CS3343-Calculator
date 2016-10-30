package mathX.v2;

import java.util.Iterator;

public interface IMathExp
{
	int getPriority();
	String getName();
	double calc(Iterator<IMathExp> iterator);
}

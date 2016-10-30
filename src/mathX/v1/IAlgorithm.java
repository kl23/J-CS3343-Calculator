package mathX.v1;

import java.util.Iterator;

public interface IAlgorithm {
	double calc(Iterator<IMathExp> stack, double... number);
}

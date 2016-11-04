package mathX.v3;

import java.util.Iterator;

public class AssignmentDelimitor implements IMathExp {

	@Override
	public int getPriority() { return Integer.MIN_VALUE; }

	@Override
	public String getName() { return "assignment"; }

	@Override
	public mVector value(Iterator<IMathExp> iterator) {
		IMathExp left = iterator.next();
		if (left instanceof Storage) {
			mVector right = iterator.next().value(iterator);
			((Storage)left).setValue(right);
			return right;
		} else {
			throw new RuntimeException("must assign to a storage");
		}

	}

}

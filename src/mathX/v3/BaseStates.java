package mathX.v3;

public enum BaseStates implements IBaseState
{
	Decimal {
		@Override
		public String toBasedNumber(double number) {
			return String.valueOf(number);
		}
	},
	Hexadecimal {
		@Override
		public String toBasedNumber(double number) {
			return Integer.toHexString((int)number);
		}
	},
	Octal {
		@Override
		public String toBasedNumber(double number) {
			return Integer.toOctalString((int)number);
		}
	},
	Binary {
		@Override
		public String toBasedNumber(double number) {
			return Integer.toBinaryString((int)number);
		}
	};	
}




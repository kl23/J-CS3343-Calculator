package mathX.v3.units;

public enum AngleUnits implements IAngleUnit {
	Degree {
		@Override
		public double toRadian(double number) { return number / 180.0d * Math.PI; }
		@Override
		public double toUnit(double radian) { return radian / Math.PI * 180.0d; }
	}, 
	Radian {
		@Override
		public double toRadian(double number) { return number; }
		@Override
		public double toUnit(double radian) { return radian; }
	},
	Gradian {
		@Override
		public double toRadian(double number) { return number / 200.0d * Math.PI; }
		@Override
		public double toUnit(double radian) { return radian / Math.PI * 200.0d; }
	},
	Turn {
		@Override
		public double toRadian(double number) { return number * 2.0d * Math.PI; }
		@Override
		public double toUnit(double radian) { return radian / Math.PI / 2.0d; }
	};
}






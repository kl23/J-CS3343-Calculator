package mathX.v3.units;

class Turn implements IAngleUnit {
	@Override
	public double toRadian(double number) { return number * 2.0d * Math.PI; }
	@Override
	public double toUnit(double radian) { return radian / Math.PI / 2.0d; }
};
package mathX.v3.units;

class Gradian implements IAngleUnit {
	@Override
	public double toRadian(double number) { return number / 200.0d * Math.PI; }
	@Override
	public double toUnit(double radian) { return radian / Math.PI * 200.0d; }
};
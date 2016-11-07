package mathX.v3.units;

class Degree implements IAngleUnit {
	@Override
	public double toRadian(double number) { return number / 180.0d * Math.PI; }
	@Override
	public double toUnit(double radian) { return radian / Math.PI * 180.0d; }
};
package testpackage;
// This enum represents the sides on a six sided die.
// A die face can only be one of these six values.
// Not five.
// Not seven.
// Eight is right out.
public enum Face {
	ONE, TWO, THREE, FOUR, FIVE, SIX;

	public Integer value() {
		return this.ordinal() + 1;
	}
}

class Die {
	private int faceCount = 6;
	private int value;

	int roll() {
		value = 1+(int)(faceCount*Math.random());
		return value;
	}

	int value() {
		return value;
	}
}

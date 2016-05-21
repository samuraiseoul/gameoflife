public enum CellState {
	ALIVE("O"), DEAD("X");
	
	private final String outputString;
	
	CellState(String outputString) {
		this.outputString = outputString;
	}
	
	String outputString() {
		return this.outputString;
	}
}

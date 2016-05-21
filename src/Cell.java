import java.util.List;


public class Cell {
	private CellState state;
	private List<Cell> neighbors;
	private CellState nextState;
	
	
	public Cell(CellState state) {
		this.state = state;
		this.nextState = state;
	}
	
	public CellState state() {
		return this.state;
	}
	
	public void neighbors(List<Cell> neighbors) {
		this.neighbors = neighbors;
	}	
	
	public List<Cell> neighbors() {
		return this.neighbors;
	}
	
	public void update() {
		int aliveNeighbors = 0;
		for(final Cell cell : this.neighbors) {
			if(cell.state() == CellState.ALIVE) {
				aliveNeighbors++;
			}
		}
		this.determineNextState(aliveNeighbors);
	}
	
	private void determineNextState(final int aliveNeighbors) {
		if(this.state == CellState.ALIVE && (aliveNeighbors == 3 || aliveNeighbors == 2)) {
			this.nextState = CellState.ALIVE;
		} else if(this.state == CellState.DEAD && aliveNeighbors == 3) {
			this.nextState = CellState.ALIVE;
		} else {
			this.nextState = CellState.DEAD;
		}
	}
	
	public void updateState() {
		this.state = this.nextState;
	}
}


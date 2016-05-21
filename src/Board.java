import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {
	private List<List<Cell>> board;
	
	public Board(final List<List<Cell>> board) {
		this.board = board;
		
		this.assignNeighbors();
	}
	
	public List<List<Cell>> board() {
		return this.board;
	}
	
	private void assignNeighbors() {
		for(int i = 0; i < this.board.size(); i++) {
			for(int j = 0; j < this.board.get(i).size(); j++) {
				this.board.get(i).get(j).neighbors(
						this.findNeighbors(j, i, this.board.size(), this.board.get(i).size()));
			}
		}
	}
	
	private List<Cell> findNeighbors(final int xIndex, final int yIndex, final int maxY, final int maxX) {
		final List<Cell> neighbors = new ArrayList<Cell>();
		for(int i = -1; i < 2 ; i++) {
			for(int j = -1; j < 2; j++) {
				int x = xIndex + j;
				int y = yIndex + i;
				if (y >= 0 && x >= 0 && x < maxX && y < maxY && !(x == xIndex && y == yIndex)){
					neighbors.add(this.board.get(y).get(x));
				}
			}
		}
		return neighbors;
	}
	
	public void print() {
		for(final List<Cell> cells : this.board) {
			for(final Cell cell : cells) {
				System.out.print(cell.state().outputString() + " ");
			}
			System.out.println("");
		}
	}
	
	public void update() {
		for(final List<Cell> cells : this.board) {
			for(final Cell cell : cells) {
				cell.update();
			}
		}
		for(final List<Cell> cells : this.board) {
			for(final Cell cell : cells) {
				cell.updateState();
			}
		}
		System.out.println("UPDATED");
	}
	
	public static List<Cell> stringToCells(final String cellString, final int numberOfColumns) throws InvalidInputException, IncorrectRowSizeException{
		List<Cell> cellList = new ArrayList<Cell>();
		List<String> stringList = new ArrayList<String>(Arrays.asList(cellString.split(",")));
		if(stringList.size() != numberOfColumns) {
			throw new IncorrectRowSizeException();
		}
		for(String cell : stringList) {
			if(cell.equals("1")) {
				cellList.add(new Cell(CellState.ALIVE));
			} else if(cell.equals("0")) {
				cellList.add(new Cell(CellState.DEAD));
			} else {
				throw new InvalidInputException();
			}
		}
		return cellList;
	}
}

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class CellTest {

	private Board testBoard;
	
	@Before
	public void setUpBoard() {
		final List<List<Cell>> board = new ArrayList();
		try {
			board.add(Board.stringToCells("1,1,1,1", 4));
			board.add(Board.stringToCells("1,1,1,1", 4));
			board.add(Board.stringToCells("1,1,1,1", 4));
			board.add(Board.stringToCells("1,1,1,1", 4));
		} catch (InvalidInputException e) {
			fail("Exception thrown;");
		} catch (IncorrectRowSizeException e) {
			fail("Exception thrown;");
		}
		this.testBoard = new Board(board);
	}
	
	@Test
	public void shouldUpdate() {
		//start alive
		assertEquals(this.testBoard.board().get(0).get(0).state(), CellState.ALIVE);
		//stay alive other cells dead
		this.testBoard.update();
		assertEquals(this.testBoard.board().get(0).get(0).state(), CellState.ALIVE);
		assertEquals(this.testBoard.board().get(1).get(1).state(), CellState.DEAD);
		//no living neighbors, die
		this.testBoard.update();
		assertEquals(this.testBoard.board().get(0).get(0).state(), CellState.DEAD);
	}

}

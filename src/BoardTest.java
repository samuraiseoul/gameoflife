import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


public class BoardTest {

	@Test
	public void shouldBuildListFromString() {
		try {
			List<Cell> cells = Board.stringToCells("1,1,1,1,1,1,1,1", 8);
		} catch (InvalidInputException e) {
			fail("Exception thrown;");
		} catch (IncorrectRowSizeException e) {
			fail("Exception thrown;");
		}
	}
	
	@Test(expected = InvalidInputException.class) 
	public void shouldThrowInvalidInput () throws InvalidInputException, IncorrectRowSizeException {
		List<Cell> cells = Board.stringToCells("1,1,1,1,1,1,2,1", 8);
	}
	
	@Test(expected = IncorrectRowSizeException.class) 
	public void shouldThrowRowSize () throws InvalidInputException, IncorrectRowSizeException {
		List<Cell> cells = Board.stringToCells("1,1,1,1,1,1,1", 8);
	}
	
	@Test
	public void shouldAssignNeighbors () {
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
		
		final Board testBoard = new Board(board);
		
		//corners only have 3 neighbors
		assertEquals(testBoard.board().get(0).get(0).neighbors().size(), 3);
		
		//sides have 5
		assertEquals(testBoard.board().get(0).get(1).neighbors().size(), 5);
		
		//others have 8
		assertEquals(testBoard.board().get(1).get(1).neighbors().size(), 8);
	}
}

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class UserInterface {
	final private Scanner scanner = new Scanner(System.in);
	private int rows;
	private int columns;
	
	public void getBoardSize() {
		this.getRows();
		this.getColumns();
		this.scanner.nextLine(); //swallow end of line inputs
	}
	
	private void getRows() {
		try{
			System.out.print("Enter number of rows: ");
			this.rows = this.scanner.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Please only enter numbers.");
			this.scanner.next();
			this.getRows();
		}
	}
	
	private void getColumns() {
		try {
			System.out.print("Enter number of columns: ");
			this.columns = this.scanner.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Please only enter numbers.");
			this.scanner.next();
			this.getColumns();
		}
	}
	
	public List<List<Cell>> getBoardInput() {
		List<List<Cell>> board = new ArrayList<List<Cell>>(this.rows);
		this.displayRowInputInstructions();
		for(int i = 0; i < this.rows; i++) {
			System.out.print("Please enter a row: ");
			try {
				board.add(Board.stringToCells(this.scanner.nextLine(), this.columns));
			} catch(InvalidInputException e) {
				System.out.println("Please only use 1's, 0's, and commas.");
				i--;
				continue;
			} catch(IncorrectRowSizeException e) {
				System.out.println("Too many or an insufficient number of columns entered, please enter "+this.columns+" columns.");
				i--;
				continue;
			}
		}
		return board;
	}
	
	private void displayRowInputInstructions() {
		System.out.println("Please enter the cells for the starting configuration.");
		System.out.println("Enter one row per line, the format is 0 for a dead cell, 1 for a living cell.");
		System.out.println("Please seperate values by a comma.");
	}
	
	public void invalidCommandAlert() {
		System.out.println("Invalid command entered.");
	}
	
	public Command getCommand() {
		System.out.println("Please enter a command. " +
				"u for update, " +
				"e to exit the program, " +
				"and r to restart and enter a new board.");
		return Command.findByKey(this.scanner.nextLine());
	}
}

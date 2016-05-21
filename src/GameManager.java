
public class GameManager {
	private UserInterface userInterface = new UserInterface();
	private Board board;
	
	public void start() {
		this.userInterface.getBoardSize();
		this.board = new Board(this.userInterface.getBoardInput());
		this.board.print();
		this.programControl();
	}
	
	private void programControl() {
		try {
			switch(this.userInterface.getCommand()) {
			case UPDATE: 
				this.board.update();
				this.board.print();
				break;
			case EXIT:
				System.exit(0);
			case RESTART: 
				this.board = null;
				this.start();
				return;
			default:
			}
			this.programControl();
		} catch (NullPointerException e) {
			this.userInterface.invalidCommandAlert();
			this.programControl();
		}
	}
	
}

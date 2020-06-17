package chess_main;

import chess_board.Board;

public class Main {

	public Main() throws Exception {
		Board board = new Board();
		int endIndicator;
		
		do {
			board.doTurn();
			endIndicator = board.endIndicator();
		} while(board.isEnd(endIndicator) == false);
		
	}

	public static void main(String[] args) throws Exception {
		new Main();
	}

}

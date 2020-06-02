package chess_main;

import chess_board.Board;

public class Main {

	public Main() {
		Board board = new Board();
		
		do {
			board.doTurn();
		} while(board.isEnd() == false);
		
	}

	public static void main(String[] args) {
		new Main();
	}

}

package chess_piece;

import chess_board.Board;

public class Pawn extends Pieces {
	Board board = new Board();
	
	@Override
	//untuk white pawn
	public boolean validateMovement(int x1,int y1, int x2, int y2) {
		if((x1 - x2 > 0 && x1 - x2 <= 2 && y1 == y2) || (x1 - x2 == 1 && (y2 - y1 == 1 || y2 - y1 == -1))) return true;
		return false;
	}
	
	//untuk black pawn
	public boolean validateBlackMovement(int x1,int y1, int x2, int y2) {
		if((x2 - x1 > 0 && x2 - x1 <= 2 && y1 == y2) || (x2 - x1 == 1 && (y2 - y1 == 1 || y2 - y1 == -1))) return true;
		return false;
	}
}

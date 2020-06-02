package chess_piece;

import chess_board.Board;

public class Pawn extends Pieces {
	Board board = new Board();
	
	@Override
	//untuk white pawn
	public boolean validateMovement(int gridsArray[][], int x1,int y1, int x2, int y2) {
		if(x2 < 0 || x2 > 7 || y2 < 0 || y2 > 7) {
			//System.out.println("msk");
			return false;
		}
		// untuk turn 1
		if(x1 == 6) {
			if((x1 - x2 == 1 && gridsArray[x2][y2] == 0 && y1 == y2) || (x1 - x2 == 2 && gridsArray[x2][y2] == 0 && gridsArray[x2 + 1][y2] == 0 && y1 == y2)) return true;
			if(x1 - x2 == 1 && (y2 - y1 == 1 || y2 - y1 == -1) && gridsArray[x2][y2] != 0 && (gridsArray[x2][y2] >= 7 && gridsArray[x2][y2] <= 12)) return true;
			if(x1 - x2 == 1 && gridsArray[x2][y2] == 0 && y1 == y2) return true;
			if(x1 - x2 == 1 && (y2 - y1 == 1 || y2 - y1 == -1) && gridsArray[x2][y2] != 0 && (gridsArray[x2][y2] >= 7 && gridsArray[x2][y2] <= 12)) return true;
			if(x1 - x2 == 1 && (y2 - y1 == 1 || y2 - y1 == -1) && gridsArray[x2][y2] == 0) return true;
		}
		// untuk turn selanjutnya
		else {
			if(x1 - x2 == 1 && gridsArray[x2][y2] == 0 && y1 == y2) return true;
			if(x1 - x2 == 1 && (y2 - y1 == 1 || y2 - y1 == -1) && gridsArray[x2][y2] != 0 && (gridsArray[x2][y2] >= 7 && gridsArray[x2][y2] <= 12)) return true;
			if(x1 - x2 == 1 && (y2 - y1 == 1 || y2 - y1 == -1) && gridsArray[x2][y2] == 0) return true;
		}
		System.out.println("invalid move!");
		return false;
	}
	
	//untuk black pawn
	public boolean validateBlackMovement(int gridsArray[][], int x1,int y1, int x2, int y2) {
		if(x2 < 0 || x2 > 7 || y2 < 0 || y2 > 7) {
			//System.out.println("msk");
			return false;
		}
		if(x1 == 1) {
			if((x2 - x1 == 1 && gridsArray[x2][y2] == 0 && y1 == y2) || (x2 - x1 == 2 && gridsArray[x2][y2] == 0 && gridsArray[x2 - 1][y2] == 0 && y1 == y2)) return true;
			if(x2 - x1 == 1 && (y2 - y1 == 1 || y2 - y1 == -1) && gridsArray[x2][y2] != 0 && (gridsArray[x2][y2] >= 1 && gridsArray[x2][y2] <= 6)) return true;
			if(x2 - x1 == 1 && gridsArray[x2][y2] == 0 && y1 == y2) return true;
			if(x2 - x1 == 1 && (y2 - y1 == 1 || y2 - y1 == -1) && gridsArray[x2][y2] != 0 && (gridsArray[x2][y2] >= 1 && gridsArray[x2][y2] <= 6)) return true;
			if(x2 - x1 == 1 && (y2 - y1 == 1 || y2 - y1 == -1) && gridsArray[x2][y2] == 0) return true;
		}
		else {
			if(x2 - x1 == 1 && gridsArray[x2][y2] == 0 && y1 == y2) return true;
			if(x2 - x1 == 1 && (y2 - y1 == 1 || y2 - y1 == -1) && gridsArray[x2][y2] != 0 && (gridsArray[x2][y2] >= 1 && gridsArray[x2][y2] <= 6)) return true;
			if(x2 - x1 == 1 && (y2 - y1 == 1 || y2 - y1 == -1) && gridsArray[x2][y2] == 0) return true;
		}
		System.out.println("invalid move!");
		return false;
	}
}

package chess_piece;

import chess_board.Board;

public class Pawn extends Pieces {
	Board board = new Board();
	
	@Override
	public boolean validateMovement(int gridsArray[][], int x1,int y1, int x2, int y2) {
		if(gridsArray[x1][y1] == 1)
		{
			if(outOfBoard(x2, y2)) {
				return false;
			}
			if(x1 == 6) {
				if(upOneOrTwoSquare(gridsArray, x1, y1, x2, y2)) return true;
				if(diagonalUpEatEnemy(gridsArray, x1, y1, x2, y2)) return true;
			}
			else {
				if(upOneSquare(gridsArray, x1, y1, x2, y2)) return true;
				if(upwardRightEatEnemy(gridsArray, x1, y1, x2, y2)) return true;
				if(upwardLeftEatEnemy(gridsArray, x1, y1, x2, y2)) return true;
				if(enPassantWhiteMove(gridsArray, x1, y1, x2, y2)) return true;
			}
			return false;
		}
		
		return false;
	}

	private boolean enPassantWhiteMove(int[][] gridsArray, int x1, int y1, int x2, int y2) {
		return gridsArray[x2][y2] == 0 && x2 == x1 - 1 && (y2 == y1 - 1 || y2 == y1 + 1);
	}

	private boolean upwardLeftEatEnemy(int[][] gridsArray, int x1, int y1, int x2, int y2) {
		return gridsArray[x2][y2] != 0 && x2 == x1 - 1 && y2 == y1 - 1 && gridsArray[x2][y2] >= 7 && gridsArray[x2][y2] <= 12;
	}

	private boolean upwardRightEatEnemy(int[][] gridsArray, int x1, int y1, int x2, int y2) {
		return gridsArray[x2][y2] != 0 && x2 == x1 - 1 && y2 == y1 + 1 && gridsArray[x2][y2] >= 7 && gridsArray[x2][y2] <= 12;
	}

	private boolean upOneSquare(int[][] gridsArray, int x1, int y1, int x2, int y2) {
		return gridsArray[x2][y2] == 0 && x2 == x1 - 1 && y1 == y2;
	}

	private boolean diagonalUpEatEnemy(int[][] gridsArray, int x1, int y1, int x2, int y2) {
		return x1 - x2 == 1 && (y2 - y1 == 1 || y2 - y1 == -1) && gridsArray[x2][y2] != 0 && (gridsArray[x2][y2] >= 7 && gridsArray[x2][y2] <= 12);
	}

	private boolean upOneOrTwoSquare(int[][] gridsArray, int x1, int y1, int x2, int y2) {
		return (x1 - x2 == 1 && gridsArray[x2][y2] == 0 && y1 == y2) || (x1 - x2 == 2 && gridsArray[x2][y2] == 0 && gridsArray[x2 + 1][y2] == 0 && y1 == y2);
	} 
	
	public boolean validateBlackMovement(int gridsArray[][], int x1,int y1, int x2, int y2) {
		if(gridsArray[x1][y1] == 7)
		{
			if(outOfBoard(x2, y2)) {
				return false;
			}
			if(x1 == 1) {
				if(downOneOrTwoSquare(gridsArray, x1, y1, x2, y2)) return true;
				if(diagonalDownEatEnemy(gridsArray, x1, y1, x2, y2)) return true;
			}
			else {
				if(downOneSquare(gridsArray, x1, y1, x2, y2)) return true;
				if(downRightEatEnemy(gridsArray, x1, y1, x2, y2)) return true;
				if(downLeftEatEnemy(gridsArray, x1, y1, x2, y2)) return true;
				if(enPassantBlackMove(gridsArray, x1, y1, x2, y2)) return true;
			}
			return false;
		}
		
		return false;
	}

	private boolean enPassantBlackMove(int[][] gridsArray, int x1, int y1, int x2, int y2) {
		return gridsArray[x2][y2] == 0 && x2 == x1 + 1 && (y2 == y1 - 1 || y2 == y1 + 1);
	}

	private boolean downLeftEatEnemy(int[][] gridsArray, int x1, int y1, int x2, int y2) {
		return gridsArray[x2][y2] != 0 && x2 == x1 + 1 && y2 == y1 - 1 && gridsArray[x2][y2] >= 1 && gridsArray[x2][y2] <= 6;
	}

	private boolean downRightEatEnemy(int[][] gridsArray, int x1, int y1, int x2, int y2) {
		return gridsArray[x2][y2] != 0 && x2 == x1 + 1 && y2 == y1 + 1 && gridsArray[x2][y2] >= 1 && gridsArray[x2][y2] <= 6;
	}

	private boolean downOneSquare(int[][] gridsArray, int x1, int y1, int x2, int y2) {
		return gridsArray[x2][y2] == 0 && x2 == x1 + 1 && y1 == y2;
	}

	private boolean diagonalDownEatEnemy(int[][] gridsArray, int x1, int y1, int x2, int y2) {
		return x2 - x1 == 1 && (y2 - y1 == 1 || y2 - y1 == -1) && gridsArray[x2][y2] != 0 && (gridsArray[x2][y2] >= 1 && gridsArray[x2][y2] <= 6);
	}

	private boolean downOneOrTwoSquare(int[][] gridsArray, int x1, int y1, int x2, int y2) {
		return (x2 - x1 == 1 && gridsArray[x2][y2] == 0 && y1 == y2) || (x2 - x1 == 2 && gridsArray[x2][y2] == 0 && gridsArray[x2 - 1][y2] == 0 && y1 == y2);
	}

	private boolean outOfBoard(int x2, int y2) {
		return x2 < 0 || x2 > 7 || y2 < 0 || y2 > 7;
	}
}

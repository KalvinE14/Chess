package chess_piece;

public class Rook extends Pieces {
	
	@Override
	public boolean validateMovement(int gridsArray[][], int x1, int y1, int x2, int y2) {
		if(gridsArray[x1][y1] ==  2 || gridsArray[x1][y1] ==  8) {
			if(outOfBoard(x2, y2)) {
				return false;
			}
			if(eatFriend(gridsArray, x1, y1, x2, y2)) {
				return false;
			}
			
			
			if(upOrDownMove(x1, y1, x2, y2)) {
				for (int i = x1 - 1; i >= x2 ; i--) {
					if(i == x2 && gridsArray[i][y1] != 0) return true;
					if(gridsArray[i][y1] != 0) return false;
					if(i == x2) return true;
				}
				for (int i = x1 + 1; i <= x2 ; i++) {
					if(i == x2 && gridsArray[i][y1] != 0) return true;
					if(gridsArray[i][y1] != 0) return false;
					if(i == x2) return true;
				}
			}
			
			else if(leftOrRightMove(x1, y1, x2, y2))
			{
				for (int i = y1 + 1; i <= y2 ; i++) {
					if(i == y2 && gridsArray[x1][i] != 0) return true;
					if(gridsArray[x1][i] != 0) return false;
					if(i == y2) return true;
				}
				
				for (int i = y1 - 1; i >= y2 ; i--) {
					if(i == y2 && gridsArray[x1][i] != 0) return true;
					if(gridsArray[x1][i] != 0) return false;
					if(i == y2) return true;
				}
			}
		}
		return false;
	}

	private boolean eatFriend(int[][] gridsArray, int x1, int y1, int x2, int y2) {
		return (gridsArray[x1][y1] >= 7 && gridsArray[x1][y1] <= 12 && gridsArray[x2][y2] >= 7 && gridsArray[x2][y2] <= 12) ||
		   (gridsArray[x1][y1] < 7 && gridsArray[x1][y1] > 0 && gridsArray[x2][y2] < 7 && gridsArray[x2][y2] > 0);
	}

	private boolean outOfBoard(int x2, int y2) {
		return x2 < 0 || x2 > 7 || y2 < 0 || y2 > 7;
	}
	
	private boolean upOrDownMove(int x1, int y1, int x2, int y2)
	{
		return y1 == y2 && x1 != x2;
	}
	
	private boolean leftOrRightMove(int x1, int y1, int x2, int y2)
	{
		return x1 == x2 && y1 != y2;
	}

}

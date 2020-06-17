package chess_piece;

public class Bishop extends Pieces {

	@Override
	public boolean validateMovement(int[][] gridsArray, int x1, int y1, int x2, int y2) {
		if(gridsArray[x1][y1] == 4 || gridsArray[x1][y1] == 10) {
			if(outOfBoard(x2, y2)) {
				return false;
			}
			if(eatFriend(gridsArray, x1, y1, x2, y2)) {
				return false;
			}
			
			int j;
			
			if(upwardLeft(x1, y1, x2, y2)) {
				j = y1 - 1;
				for (int i = x1 - 1; i >= x2; i--) {
					if(i == x2 && j == y2 && gridsArray[i][j] != 0) return true;
					if(i == x2 && j == y2) return true;
					if(i != x2 && j != y2 && gridsArray[i][j] != 0) return false;
					j--;
				}
			}
			
			else if(upwardRight(x1, y1, x2, y2)) {
				j = y1 + 1;
				for (int i = x1 + 1; i <= x2; i++) {
					if(i == x2 && j == y2 && gridsArray[i][j] != 0) return true;
					if(i == x2 && j == y2) return true;
					if(i != x2 && j != y2 && gridsArray[i][j] != 0) return false;
					j++;
				}
			}
			
			else if(downLeft(x1, y1, x2, y2)) {
				j = y1 - 1;
				for (int i = x1 + 1; i <= x2; i++) {
					if(i == x2 && j == y2 && gridsArray[i][j] != 0) return true;
					if(i == x2 && j == y2) return true;
					if(i != x2 && j != y2 && gridsArray[i][j] != 0) return false;
					j--;
				}
			}
			
			else if(downRight(x1, y1, x2, y2)) {
				j = y1 + 1;
				for (int i = x1 - 1; i >= x2; i--) {
					if(i == x2 && j == y2 && gridsArray[i][j] != 0) return true;
					if(i == x2 && j == y2) return true;
					if(i != x2 && j != y2 && gridsArray[i][j] != 0) return false;
					j++;
				}
			}
		}
		return false;
	}

	private boolean downRight(int x1, int y1, int x2, int y2) {
		return x1 - x2 > 0 && y1 - y2 < 0;
	}

	private boolean downLeft(int x1, int y1, int x2, int y2) {
		return x1 - x2 < 0 && y1 - y2 > 0;
	}

	private boolean upwardRight(int x1, int y1, int x2, int y2) {
		return x1 - x2 < 0 && y1 - y2 < 0;
	}

	private boolean upwardLeft(int x1, int y1, int x2, int y2) {
		return x1 - x2 > 0 && y1 - y2 > 0;
	}

	private boolean outOfBoard(int x2, int y2) {
		return x2 < 0 || x2 > 7 || y2 < 0 || y2 > 7;
	}

	private boolean eatFriend(int[][] gridsArray, int x1, int y1, int x2, int y2) {
		return (gridsArray[x1][y1] >= 7 && gridsArray[x1][y1] <= 12 && gridsArray[x2][y2] >= 7 && gridsArray[x2][y2] <= 12) ||
			  (gridsArray[x1][y1] < 7 && gridsArray[x1][y1] > 0 && gridsArray[x2][y2] < 7 && gridsArray[x2][y2] > 0);
	}

}

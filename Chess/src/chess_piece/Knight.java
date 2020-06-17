package chess_piece;

public class Knight extends Pieces {

	@Override
	public boolean validateMovement(int[][] gridsArray, int x1, int y1, int x2, int y2) {
		if(gridsArray[x1][y1] == 3 || gridsArray[x1][y1] == 9)
		{
			if(outOfBoard(x2, y2)) {
				return false;
			}
			if(eatFriend(gridsArray, x1, y1, x2, y2))
			{
				System.out.println("Invalid knight move!");
				System.out.println("");
				return false;
			}
			else if(upMove(x1, y1, x2, y2))
			{
				return true;
			}
			else if(downMove(x1, y1, x2, y2))
			{
				return true;
			}
			
			System.out.println("Invalid knight move!");
			System.out.println("");
			return false;
		}
		
		return false;
	}

	private boolean downMove(int x1, int y1, int x2, int y2) {
		return (x2 - x1 == 1 && (y2 - y1 == 2 || y2 - y1 == -2)) || (x2 - x1 == 2 && (y2 - y1 == 1 || y2 - y1 == -1));
	}

	private boolean upMove(int x1, int y1, int x2, int y2) {
		return (x2 - x1 == -1 && (y2 - y1 == 2 || y2 - y1 == -2)) || (x2 - x1 == -2 && (y2 - y1 == 1 || y2 - y1 == -1));
	}

	private boolean eatFriend(int[][] gridsArray, int x1, int y1, int x2, int y2) {
		return (gridsArray[x1][y1] > 0 && gridsArray[x1][y1] < 7 && gridsArray[x2][y2] > 0 && gridsArray[x2][y2] < 7) || gridsArray[x1][y1] > 6 && gridsArray[x1][y1] < 13 && gridsArray[x2][y2] > 6 && gridsArray[x2][y2] < 13;
	}

	private boolean outOfBoard(int x2, int y2) {
		return x2 < 0 || x2 > 7 || y2 < 0 || y2 > 7;
	}

}

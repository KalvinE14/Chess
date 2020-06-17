package chess_piece;

public class King extends Pieces {

	@Override
	public boolean validateMovement(int[][] gridsArray, int x1, int y1, int x2, int y2) {
		if(gridsArray[x1][y1] == 6 || gridsArray[x1][y1] == 12) {
			if(outOfBoard(x2, y2)) {
				return false;
			}
			if(eatFriend(gridsArray, x1, y1, x2, y2)) {
				return false;
			}
		
			if(upMove(x1, y1, x2, y2)) return true;
			else if(downMove(x1, y1, x2, y2)) return true;
			else if(leftMove(x1, y1, x2, y2)) return true;
			else if(rightMove(x1, y1, x2, y2)) return true;
			else if(upwardLeftMove(x1, y1, x2, y2)) return true;
			else if(upwardRightMove(x1, y1, x2, y2)) return true;
			else if(downLeftMove(x1, y1, x2, y2)) return true;
			else if(downRightMove(x1, y1, x2, y2)) return true;
		}
		return false;
	}
	
	private boolean upMove(int x1, int y1, int x2, int y2)
	{
		return x1 - x2 == 1 && y1 == y2;
	}
	
	private boolean downMove(int x1, int y1, int x2, int y2)
	{
		return x1 - x2 == -1 && y1 == y2;
	}
	
	private boolean leftMove(int x1, int y1, int x2, int y2)
	{
		return y1 - y2 == 1 && x1 == x2;
	}
	
	private boolean rightMove(int x1, int y1, int x2, int y2)
	{
		return y1 - y2 == -1 && x1 == x2;
	}
	
	private boolean upwardLeftMove(int x1, int y1, int x2, int y2)
	{
		return x1 - x2 == 1 && y1 - y2 == 1;
	}
	
	private boolean upwardRightMove(int x1, int y1, int x2, int y2)
	{
		return x1 - x2 == 1 && y1 - y2 == -1;
	}
	
	private boolean downLeftMove(int x1, int y1, int x2, int y2)
	{
		return x1 - x2 == -1 && y1 - y2 == 1;
	}
	
	private boolean downRightMove(int x1, int y1, int x2, int y2)
	{
		return x1 - x2 == -1 && y1 - y2 == -1;
	}
	
	private boolean eatFriend(int[][] gridsArray, int x1, int y1, int x2, int y2) {
		return (gridsArray[x1][y1] >= 7 && gridsArray[x1][y1] <= 12 && gridsArray[x2][y2] >= 7 && gridsArray[x2][y2] <= 12) ||
		   (gridsArray[x1][y1] < 7 && gridsArray[x1][y1] > 0 && gridsArray[x2][y2] < 7 && gridsArray[x2][y2] > 0);
	}

	private boolean outOfBoard(int x2, int y2) {
		return x2 < 0 || x2 > 7 || y2 < 0 || y2 > 7;
	}

}

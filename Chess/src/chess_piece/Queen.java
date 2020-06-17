package chess_piece;

public class Queen extends Pieces {

	 @Override
	public boolean validateMovement(int[][] gridsArray, int x1, int y1, int x2, int y2) {
		 if(gridsArray[x1][y1] == 5 || gridsArray[x1][y1] == 11)
		 {
			 if(outOfBoard(x2, y2)) {
					return false;
				}
			 if(eatFriend(gridsArray, x1, y1, x2, y2))
			{
				print_invalid_queen_move();
				return false;
			} 
			 
			if(upMove(x1, y1, x2, y2))
			{
				for(int i = x1 - 1; i >= x2; i--) 
				{
					if(i == x2) return true;
					else if(i != x2)
					{
						if(gridsArray[i][y1] != 0)
						{
							print_invalid_queen_move();
							return false;
						}
					}
				}
			}
			else if(downMove(x1, y1, x2, y2))
			{
				for(int i = x1 + 1; i <= x2; i++) 
				{
					if(i == x2) return true;
					else if(i != x2)
					{
						if(gridsArray[i][y1] != 0)
						{
							print_invalid_queen_move();
							return false;
						}
					}
				}
			}
			else if(rightMove(x1, y1, x2, y2))
			{
				for(int i = y1 + 1; i <= y2; i++) 
				{
					if(i == y2) return true;
					else if(i != y2)
					{
						if(gridsArray[x1][i] != 0)
						{
							print_invalid_queen_move();
							return false;
						}
					}
				}
			}
			else if(leftMove(x1, y1, x2, y2))
			{
				for(int i = y1 - 1; i >= y2; i--) 
				{
					if(i == y2) return true;
					else if(i != y2)
					{
						if(gridsArray[x1][i] != 0) 
						{
							print_invalid_queen_move();
							return false;
						}
					}
				}
			}
			else if(upwardLeftMove(x1, y1, x2, y2))
			{
				for(int i = x1 - 1, j = y1 - 1; i >= x2; i--, j--)
				{
					if(i == x2 && j == y2) return true;
					else if(i != x2 && j != y2)
					{
						if(gridsArray[i][j] != 0)
						{
							print_invalid_queen_move();
							return false;
						}
					}
				}
			}
			else if(downLeftMove(x1, y1, x2, y2))
			{
				for(int i = x1 + 1, j = y1 - 1; i <= x2 ; i++, j--) 
				{
					if(i == x2 && j == y2) return true;
					else if(i != x2 && j != y2)
					{
						if(gridsArray[i][j] != 0)
						{
							print_invalid_queen_move();
							return false;
						}
					}
				}
			}
			else if(downRightMove(x1, y1, x2, y2))
			{
				for(int i = x1 + 1, j = y1 + 1; i <= x2; i++, j++) 
				{
					if(i == x2 && j == y2) return true;
					else if(i != x2 && j != y2)
					{
						if(gridsArray[i][j] != 0)
						{
							print_invalid_queen_move();
							return false;
						}
					}
				}
			}
			
			else if(upwardRightMove(x1, y1, x2, y2))
			{
				for(int i = x1 - 1, j = y1 + 1; i >= x2; i--, j++) 
				{
					if(i == x2 && j == y2) return true;
					else if(i != x2 && j != y2)
					{
						if(gridsArray[i][j] != 0)
						{
							print_invalid_queen_move();
							return false;
						}
					}
				}
			}
				
			print_invalid_queen_move();
			 
			 return false;
		} 
		 
		 return false;
	}


	private boolean upwardRightMove(int x1, int y1, int x2, int y2) {
		return x1 - x2 == ((y1 - y2) * -1) && x1 - x2 > 0 && y1 - y2 < 0;
	}


	private boolean downRightMove(int x1, int y1, int x2, int y2) {
		return x1 - x2 == y1 - y2 && x1 - x2 < 0 && y1 - y2 < 0;
	}


	private boolean downLeftMove(int x1, int y1, int x2, int y2) {
		return x1 - x2 == ((y1 - y2) * -1) && x1 - x2 < 0 && y1 - y2 > 0;
	}


	private boolean upwardLeftMove(int x1, int y1, int x2, int y2) {
		return x1 - x2 == y1 - y2 && x1 - x2 > 0 && y1 - y2 > 0;
	}


	private boolean leftMove(int x1, int y1, int x2, int y2) {
		return x1 == x2 && y2 - y1 < 0;
	}


	private boolean rightMove(int x1, int y1, int x2, int y2) {
		return x1 == x2 && y2 - y1 > 0;
	}


	private boolean downMove(int x1, int y1, int x2, int y2) {
		return x1 - x2 < 0 && y1 == y2;
	}


	private boolean upMove(int x1, int y1, int x2, int y2) {
		return x1 - x2 > 0 && y1 == y2;
	}


	private boolean eatFriend(int[][] gridsArray, int x1, int y1, int x2, int y2) {
		return (gridsArray[x1][y1] > 0 && gridsArray[x1][y1] < 7 && gridsArray[x2][y2] > 0 && gridsArray[x2][y2] < 7) || gridsArray[x1][y1] > 6 && gridsArray[x1][y1] < 13 && gridsArray[x2][y2] > 6 && gridsArray[x2][y2] < 13;
	}


	private boolean outOfBoard(int x2, int y2) {
		return x2 < 0 || x2 > 7 || y2 < 0 || y2 > 7;
	}
		 

	public void print_invalid_queen_move() {
		System.out.println("Invalid queen move!");
		System.out.println("");
	}

}

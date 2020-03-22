package chess_piece;

public class Queen extends Pieces {

	@Override
	public boolean validateMovement(int[][] gridsArray, int x1, int y1, int x2, int y2) {
		if((gridsArray[x1][y1] > 0 && gridsArray[x1][y1] < 7 && gridsArray[x2][y2] > 0 && gridsArray[x2][y2] < 7) || gridsArray[x1][y1] > 6 && gridsArray[x1][y1] < 13 && gridsArray[x2][y2] > 6 && gridsArray[x2][y2] < 13)
		{
			print_invalid_queen_move();
			return false;
		} 
		 
		//buat ke atas
		if(x1 - x2 > 0 && y1 == y2)
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
		//buat ke bawah
		else if(x1 - x2 < 0 && y1 == y2)
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
		//buat ke kanan
		else if(x1 == x2 && y2 - y1 > 0)
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
		//buat ke kiri
		else if(x1 == x2 && y2 - y1 < 0)
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
		//buat ke kiri atas
		else if(x1 - x2 == y1 - y2 && x1 - x2 > 0 && y1 - y2 > 0)
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
		//buat ke kiri bawah
		else if(x1 - x2 == ((y1 - y2) * -1) && x1 - x2 < 0 && y1 - y2 > 0)
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
		//buat ke kanan bawah
		else if(x1 - x2 == y1 - y2 && x1 - x2 < 0 && y1 - y2 < 0)
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
		
		//buat ke kanan atas
		else if(x1 - x2 == ((y1 - y2) * -1) && x1 - x2 > 0 && y1 - y2 < 0)
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
	
	public void print_invalid_queen_move() {
		System.out.println("Invalid queen move!");
		System.out.println("");
	}

}

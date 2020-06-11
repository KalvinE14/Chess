package chess_piece;

public class Knight extends Pieces {

	@Override
	public boolean validateMovement(int[][] gridsArray, int x1, int y1, int x2, int y2) {
		if(gridsArray[x1][y1] == 3 || gridsArray[x1][y1] == 9)
		{
			if(x2 < 0 || x2 > 7 || y2 < 0 || y2 > 7) {
				//System.out.println("msk");
				return false;
			}
			if((gridsArray[x1][y1] > 0 && gridsArray[x1][y1] < 7 && gridsArray[x2][y2] > 0 && gridsArray[x2][y2] < 7) || gridsArray[x1][y1] > 6 && gridsArray[x1][y1] < 13 && gridsArray[x2][y2] > 6 && gridsArray[x2][y2] < 13)
			{
				System.out.println("Invalid knight move!");
				System.out.println("");
				return false;
			}
			// jalan ke atas
			else if((x2 - x1 == -1 && (y2 - y1 == 2 || y2 - y1 == -2)) || (x2 - x1 == -2 && (y2 - y1 == 1 || y2 - y1 == -1)))
			{
				return true;
			}
			// jalan ke bawah
			else if((x2 - x1 == 1 && (y2 - y1 == 2 || y2 - y1 == -2)) || (x2 - x1 == 2 && (y2 - y1 == 1 || y2 - y1 == -1)))
			{
				return true;
			}
			
			System.out.println("Invalid knight move!");
			System.out.println("");
			return false;
		}
		
		return false;
	}

}

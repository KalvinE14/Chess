package chess_piece;

public class Bishop extends Pieces {

	@Override
	public boolean validateMovement(int[][] gridsArray, int x1, int y1, int x2, int y2) {
		if(x2 < 0 || x2 > 7 || y2 < 0 || y2 > 7) {
			//System.out.println("msk");
			return false;
		}
		if((gridsArray[x1][y1] >= 7 && gridsArray[x1][y1] <= 12 && gridsArray[x2][y2] >= 7 && gridsArray[x2][y2] <= 12) ||
			  (gridsArray[x1][y1] < 7 && gridsArray[x1][y1] > 0 && gridsArray[x2][y2] < 7 && gridsArray[x2][y2] > 0)) {
			//System.out.println("makan temenB");
			return false;
		}
		
		int j;
		
		// buat kiri atas	
		if(x1 - x2 > 0 && y1 - y2 > 0) {
			j = y1 - 1;
			for (int i = x1 - 1; i >= x2; i--) {
				//if(j > 7 || j < 0) break;
				if(i == x2 && j == y2 && gridsArray[i][j] != 0) return true;
				if(i == x2 && j == y2) return true;
				if(i != x2 && j != y2 && gridsArray[i][j] != 0) return false;
				j--;
			}
		}
		
		// buat kanan bawah
		else if(x1 - x2 < 0 && y1 - y2 < 0) {
			j = y1 + 1;
			for (int i = x1 + 1; i <= x2; i++) {
				//if(j > 7 || j < 0) break;
				if(i == x2 && j == y2 && gridsArray[i][j] != 0) return true;
				if(i == x2 && j == y2) return true;
				if(i != x2 && j != y2 && gridsArray[i][j] != 0) return false;
				j++;
			}
		}
		
		//buat kiri bawah
		else if(x1 - x2 < 0 && y1 - y2 > 0) {
			j = y1 - 1;
			for (int i = x1 + 1; i <= x2; i++) {
				//if(j > 7 || j < 0) break;
				if(i == x2 && j == y2 && gridsArray[i][j] != 0) return true;
				if(i == x2 && j == y2) return true;
				if(i != x2 && j != y2 && gridsArray[i][j] != 0) return false;
				j--;
			}
		}
		
		// buat kanan atas
		else if(x1 - x2 > 0 && y1 - y2 < 0) {
			j = y1 + 1;
			for (int i = x1 - 1; i >= x2; i--) {
				//if(j > 7 || j < 0) break;
				if(i == x2 && j == y2 && gridsArray[i][j] != 0) return true;
				if(i == x2 && j == y2) return true;
				if(i != x2 && j != y2 && gridsArray[i][j] != 0) return false;
				j++;
			}
		}
	
		return false;
	}

}

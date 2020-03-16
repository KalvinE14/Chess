package chess_piece;

public class Rook extends Pieces {

	@Override
	public boolean validateMovement(int gridsArray[][], int x1, int y1, int x2, int y2) {
		if((gridsArray[x1][y1] >= 7 && gridsArray[x1][y1] <= 12 && gridsArray[x2][y2] >= 7 && gridsArray[x2][y2] <= 12) ||
		   (gridsArray[x1][y1] < 7 && gridsArray[x1][y1] > 0 && gridsArray[x2][y2] < 7 && gridsArray[x2][y2] > 0)) {
			System.out.println("makan temen");
			return false;
		}
		
		//buat atas
		for (int i = x1 - 1; i >= x2 ; i--) {
			if(i == x2 && gridsArray[i][y1] != 0) return true;
			if(gridsArray[i][y1] != 0) return false;
			if(i == x2) return true;
		}
		
		//buat bawah
		for (int i = x1 + 1; i <= x2 ; i++) {
			if(i == x2 && gridsArray[i][y1] != 0) return true;
			if(gridsArray[i][y1] != 0) return false;
			if(i == x2) return true;
		}
		
		//buat kanan
		for (int i = y1 + 1; i <= y2 ; i++) {
			if(i == y2 && gridsArray[x1][i] != 0) return true;
			if(gridsArray[x1][i] != 0) return false;
			if(i == y2) return true;
		}
		
		//buat kiri
		for (int i = y1 - 1; i >= y2 ; i--) {
			if(i == y2 && gridsArray[x1][i] != 0) return true;
			if(gridsArray[x1][i] != 0) return false;
			if(i == y2) return true;
		}
		return false;
	}

}

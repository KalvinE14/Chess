package chess_rule;

public class Check {

	public boolean validateRookPath(int turn, int gridsArray[][], int x, int y) {
		for (int i = x - 1; i >= 0 ; i--) {
			if(turnWhite(turn)) {
				if(gridsArray[i][y] >= 7 && gridsArray[i][y] <= 12) {
					if(gridsArray[i][y] != 0 && gridsArray[i][y] == 12) {
						return true;
					}
					else if(gridsArray[i][y] != 0 && gridsArray[i][y] != 12) {
						break;
					}
				}	
				else if(gridsArray[i][y] >= 1 && gridsArray[i][y] <= 6) break;
			}
			else if(turnBlack(turn)) {
				if(gridsArray[i][y] >= 1 && gridsArray[i][y] <= 6) {
					if(gridsArray[i][y] != 0 && gridsArray[i][y] == 6) {
						return true;
					}
					else if(gridsArray[i][y] != 0 && gridsArray[i][y] != 6) {
						break;
					}
				}
				else if(gridsArray[i][y] >= 7 && gridsArray[i][y] <= 12) break;
			} 
		}
		
		for (int i = x + 1; i <= 7 ; i++) {
			if(turnWhite(turn)) {
				if(gridsArray[i][y] >= 7 && gridsArray[i][y] <= 12) {
					if(gridsArray[i][y] != 0 && gridsArray[i][y] == 12) {
						return true;
					}
					else if(gridsArray[i][y] != 0 && gridsArray[i][y] != 12) {
						break;
					}
				}
				else if(gridsArray[i][y] >= 1 && gridsArray[i][y] <= 6) break;
			}
			else if(turnBlack(turn)) {
				if(gridsArray[i][y] >= 1 && gridsArray[i][y] <= 6) {
					if(gridsArray[i][y] != 0 && gridsArray[i][y] == 6) { 
						return true;
					}
					else if(gridsArray[i][y] != 0 && gridsArray[i][y] != 6) {
						break;
					}
				}
				else if(gridsArray[i][y] >= 7 && gridsArray[i][y] <= 12) break;
			}
		}
		
		for (int i = y + 1; i <= 7 ; i++) {
			if(turnWhite(turn)) {
				if(gridsArray[x][i] >= 7 && gridsArray[x][i] <= 12) {
					if(gridsArray[x][i] != 0 && gridsArray[x][i] == 12) {
						return true;
					}
					else if(gridsArray[x][i] != 0 && gridsArray[x][i] != 12) {
						break;
					}
				}
				else if(gridsArray[x][i] >= 1 && gridsArray[x][i] <= 6) break;
			}
			else if(turnBlack(turn)) {
				if(gridsArray[x][i] >= 1 && gridsArray[x][i] <= 6) {
					if(gridsArray[x][i] != 0 && gridsArray[x][i] == 6) {
						return true;
					}
					else if(gridsArray[x][i] != 0 && gridsArray[x][i] != 6) {
						break;
					}
				}
				else if(gridsArray[x][i] >= 7 && gridsArray[x][i] <= 12) break;
			}
		}
		
		for (int i = y - 1; i >= 0 ; i--) {
			if(turnWhite(turn)) {
				if(gridsArray[x][i] >= 7 && gridsArray[x][i] <= 12) {
					if(gridsArray[x][i] != 0 && gridsArray[x][i] == 12) {
						return true;
					}
					else if(gridsArray[x][i] != 0 && gridsArray[x][i] != 12) {
						break;
					}
				}
				else if(gridsArray[x][i] >= 1 && gridsArray[x][i] <= 6) break;
			}
			else if(turnBlack(turn)) {
				if(gridsArray[x][i] >= 1 && gridsArray[x][i] <= 6) {
					if(gridsArray[x][i] != 0 && gridsArray[x][i] == 6) {
						return true;
					}
					else if(gridsArray[x][i] != 0 && gridsArray[x][i] != 6) {
						break;
					}
				}
				else if(gridsArray[x][i] >= 7 && gridsArray[x][i] <= 12) break;
			}
		}
		return false;
	}

	public boolean validateBishopPath(int turn, int gridsArray[][], int x, int y) {
		for(int i = x-1, j = y+1; i >= 0; i--, j++) {
			if(j <= 7 && i >= 0) {
				if(turnWhite(turn)) {
					if(gridsArray[i][j] == 12) {
						return true;				
					}
					else if(gridsArray[i][j] != 0 && gridsArray[i][j] != 12) break;
				}
				else if(turnBlack(turn)) {
					if(gridsArray[i][j] == 6) {
						return true;				
					}
					else if(gridsArray[i][j] != 0 && gridsArray[i][j] != 6) break;
				}
				if(i == 0 || j == 7) break;
			}		
		}
		
		for(int i = x-1, j = y-1; i >= 0; i--, j--) {
			if(j >= 0 && i >= 0) {
				if(turnWhite(turn)) {
					if(gridsArray[i][j] == 12) {
						return true;				
					}
					else if(gridsArray[i][j] != 0 && gridsArray[i][j] != 12) break;
				}
				else if(turnBlack(turn)) {
					if(gridsArray[i][j] == 6) {
						return true;				
					}
					else if(gridsArray[i][j] != 0 && gridsArray[i][j] != 6) break;
				}
				if(i == 0 || j == 0) break;
			}		
		}
		
		for(int i = x+1, j = y-1; i <= 7; i++, j--) {
			if(j >= 0 && i <= 7) {
				if(turnWhite(turn)) {
					if(gridsArray[i][j] == 12) {
						return true;				
					}
					else if(gridsArray[i][j] != 0 && gridsArray[i][j] != 12) break;
				}
				else if(turnBlack(turn)) {
					if(gridsArray[i][j] == 6) {
						return true;				
					}
					else if(gridsArray[i][j] != 0 && gridsArray[i][j] != 6) break;
				}
				if(i == 7 || j == 0) break;
			}			
		}
		
		for(int i = x+1, j = y+1; i <= 7; i++, j++) {
			if(i <= 7 && j <= 7) {
				if(turnWhite(turn)) {
					if(gridsArray[i][j] == 12) {
						return true;				
					}
					else if(gridsArray[i][j] != 0 && gridsArray[i][j] != 12) break;
				}
				else if(turnBlack(turn)) {
					if(gridsArray[i][j] == 6) {
						return true;				
					}
					else if(gridsArray[i][j] != 0 && gridsArray[i][j] != 6) break;
				}
				if(i == 7 || j == 7) break; 
			}	
		}
		return false;
	}
	
	public boolean validateQueenPath(int turn, int gridsArray[][], int x, int y) {
		if(turnWhite(turn)) {
			if(validateRookPath(turn, gridsArray, x, y) == true) return true;
			if(validateBishopPath(turn, gridsArray, x, y) == true) return true;
		}
		else if(turnBlack(turn)) {
			if(validateRookPath(turn, gridsArray, x, y) == true) return true;
			if(validateBishopPath(turn, gridsArray, x, y) == true) return true;
		}
		return false;
	}
	
	public boolean validateKingPath(int turn, int gridsArray[][], int x, int y) {
		if(turnWhite(turn)) {
			if(x-1 >= 0) {
				if(gridsArray[x-1][y] == 12) return true;
			}
			if(x+1 <= 7) {
				if(gridsArray[x+1][y] == 12) return true;
			}
			if(y-1 >= 0) {
				if(gridsArray[x][y-1] == 12) return true;
			}
			if(y+1 <= 7) {
				if(gridsArray[x][y+1] == 12) return true;
			}
			if(x-1 >= 0 && y+1 <= 7) {
				if(gridsArray[x-1][y+1] == 12) return true;
			}
			if(x-1 >= 0 && y-1 >= 0) {
				if(gridsArray[x-1][y-1] == 12) return true;
			}
			if(x+1 <= 7 && y-1 >= 0) {
				if(gridsArray[x+1][y-1] == 12) return true;
			}
			if(x+1 <= 7 && y+1 <= 7) {
				if(gridsArray[x+1][y+1] == 12) return true;
			}
		}
		else if(turnBlack(turn)) {
			if(x-1 >= 0) {
				if(gridsArray[x-1][y] == 6) return true;
			}
			if(x+1 <= 7) {
				if(gridsArray[x+1][y] == 6) return true;
			}
			if(y-1 >= 0) {
				if(gridsArray[x][y-1] == 6) return true;
			}
			if(y+1 <= 7) {
				if(gridsArray[x][y+1] == 6) return true;
			}
			if(x-1 >= 0 && y+1 <= 7) {
				if(gridsArray[x-1][y+1] == 6) return true;
			}
			if(x-1 >= 0 && y-1 >= 0) {
				if(gridsArray[x-1][y-1] == 6) return true;
			}
			if(x+1 <= 7 && y-1 >= 0) {
				if(gridsArray[x+1][y-1] == 6) return true;
			}
			if(x+1 <= 7 && y+1 <= 7) {
				if(gridsArray[x+1][y+1] == 6) return true;
			}
		}
		return false;
	}
	
	public boolean validatePawnPath(int turn, int gridsArray[][], int x, int y) {
		if(turnWhite(turn)) {
			if(x-1 >= 0 && y-1 >= 0) {
				if(gridsArray[x-1][y-1] == 12) return true;
			}
			if(x-1 >= 0 && y+1 <= 7) {
				if(gridsArray[x-1][y+1] == 12) return true;
			}
		}
		else if(turnBlack(turn)) {
			if(x+1 <= 7 && y+1 <= 7) {
				if(gridsArray[x+1][y+1] == 6) return true;
			}
			if(x+1 <= 7 && y-1 >= 0) {
				if(gridsArray[x+1][y-1] == 6) return true;
			}
		}
		return false;
	}

	private boolean turnBlack(int turn) {
		return turn == -1;
	}
	
	public boolean validateKnightPath(int turn, int gridsArray[][], int x, int y) {
		if(turnWhite(turn)) {
			int spin = 0;
			do
			{	
				spin++;
				int tempX = 0;
				int tempY = 0;
				
				if(turnWhite(spin))
				{
					tempX = x-1;
					tempY = y-2;
					if(tempX < 0 || tempY < 0) continue;
					
					if(gridsArray[tempX][tempY] == 12) return true;
				}else if(spin == 2)
				{
					tempX = x-2;
					tempY = y-1;
					if(tempX < 0 || tempY < 0) continue;
					
					if(gridsArray[tempX][tempY] == 12) return true;
				}else if(spin == 3)
				{
					tempX = x-1;
					tempY = y+2;
					if(tempX < 0 || tempY > 7) continue;
					
					if(gridsArray[tempX][tempY] == 12) return true;
				}else if(spin == 4)
				{
					tempX = x-2;
					tempY = y+1;
					if(tempX < 0 || tempY > 7) continue;
					
					if(gridsArray[tempX][tempY] == 12) return true;
				}else if(spin == 5)
				{
					tempX = x+1;
					tempY = y+2;
					if(tempX > 7 || tempY > 7) continue;
					
					if(gridsArray[tempX][tempY] == 12) return true;
				}else if(spin == 6)
				{
					tempX = x+2;
					tempY = y+1;
					if(tempX > 7 || tempY > 7) continue;
					
					if(gridsArray[tempX][tempY] == 12) return true;
				}else if(spin == 7)
				{
					tempX = x+1;
					tempY = y-2;
					if(tempX > 7 || tempY < 0) continue;
					
					if(gridsArray[tempX][tempY] == 12) return true;
				}else if(spin == 8)
				{
					tempX = x+2;
					tempY = y-1;
					if(tempX > 7 || tempY < 0) continue;
					
					if(gridsArray[tempX][tempY] == 12) return true;
				}
				
			}while(spin <= 8);
			return false;
		}else if(turnBlack(turn)) {
			int spin = 0;
			do
			{	
				spin++;
				int tempX = 0;
				int tempY = 0;
				
				if(turnWhite(spin))
				{
					tempX = x-1;
					tempY = y-2;
					if(tempX < 0 || tempY < 0) continue;
					
					if(gridsArray[tempX][tempY] == 6) return true;
				}else if(spin == 2)
				{
					tempX = x-2;
					tempY = y-1;
					if(tempX < 0 || tempY < 0) continue;
					
					if(gridsArray[tempX][tempY] == 6) return true;
				}else if(spin == 3)
				{
					tempX = x-1;
					tempY = y+2;
					if(tempX < 0 || tempY > 7) continue;
					
					if(gridsArray[tempX][tempY] == 6) return true;
				}else if(spin == 4)
				{
					tempX = x-2;
					tempY = y+1;
					if(tempX < 0 || tempY > 7) continue;
					
					if(gridsArray[tempX][tempY] == 6) return true;
				}else if(spin == 5)
				{
					tempX = x+1;
					tempY = y+2;
					if(tempX > 7 || tempY > 7) continue;
					
					if(gridsArray[tempX][tempY] == 6) return true;
				}else if(spin == 6)
				{
					tempX = x+2;
					tempY = y+1;
					if(tempX > 7 || tempY > 7) continue;
					
					if(gridsArray[tempX][tempY] == 6) return true;
				}else if(spin == 7)
				{
					tempX = x+1;
					tempY = y-2;
					if(tempX > 7 || tempY < 0) continue;
					
					if(gridsArray[tempX][tempY] == 6) return true;
				}else if(spin == 8)
				{
					tempX = x+2;
					tempY = y-1;
					if(tempX > 7 || tempY < 0) continue;
					
					if(gridsArray[tempX][tempY] == 6) return true;
				}
				
			}while(spin <= 8);
			return false;
		}
		
		return false;
	}

	private boolean turnWhite(int turn) {
		return turn == 1;
	}
	
	public boolean validateCheck(int gridsArray[][], int turn) {
		for(int i = 0; i <= 7; i++) {
			for(int j = 0; j <= 7; j++) {
				if(turnWhite(turn)) {
					if(gridsArray[i][j] == 1) {
						if(validatePawnPath(turn, gridsArray, i, j)) return true;
					}
					else if(gridsArray[i][j] == 2) {
						if(validateRookPath(turn, gridsArray, i, j)) return true;
					}
					else if(gridsArray[i][j] == 3) {
						if(validateKnightPath(turn, gridsArray, i, j)) return true;
					}
					else if(gridsArray[i][j] == 4) {
						if(validateBishopPath(turn, gridsArray, i, j)) return true;
					}
					else if(gridsArray[i][j] == 5) {
						if(validateQueenPath(turn, gridsArray, i, j)) return true;
					}
					else if(gridsArray[i][j] == 6) {
						if(validateKingPath(turn, gridsArray, i,j)) return true;
					}					
				}
				else if(turnBlack(turn)) {
					if(gridsArray[i][j] == 7) {
						if(validatePawnPath(turn, gridsArray, i,j)) return true;
					}
					else if(gridsArray[i][j] == 8) {
						if(validateRookPath(turn, gridsArray, i, j)) return true;
					}
					else if(gridsArray[i][j] == 9) {
						if(validateKnightPath(turn, gridsArray, i, j)) return true;
					}
					else if(gridsArray[i][j] == 10) {	
						if(validateBishopPath(turn, gridsArray, i, j)) return true;
					}
					else if(gridsArray[i][j] == 11) {
						if(validateQueenPath(turn, gridsArray, i, j)) return true;
					}
					else if(gridsArray[i][j] == 12) {
						if(validateKingPath(turn, gridsArray, i,j)) return true;
					}
				}
			}
		}
		return false;
	}
}

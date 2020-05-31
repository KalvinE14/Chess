package chess_rule;

public class Checkmate {
	public void moveKing(int gridsArray[][], int x1, int y1, int x2, int y2)
	{
		gridsArray[x2][y2] = gridsArray[x1][y1];
		gridsArray[x1][y1] = 0;
	}
	
	public int findXKing(int gridsArray[][], int turn)
	{
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if(turn == 1)
				{
					if(gridsArray[i][j] == 6)
					{
						return i;
					}
				}else if(turn == -1)
				{
					if(gridsArray[i][j] == 12)
					{
						return i;
					}
				}
			}
		}
		return 0;
	}
	
	public int findYKing(int gridsArray[][], int turn)
	{
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if(turn == 1)
				{
					if(gridsArray[i][j] == 6)
					{
						return j;
					}
				}else if(turn == -1)
				{
					if(gridsArray[i][j] == 12)
					{
						return j;
					}
				}
			}
		}
		return 0;
	}
	
	public int isKingAvailableMoveChecked(int gridsArray[][], int turn)
	{
		int xKing = findXKing(gridsArray, turn);
		int yKing = findYKing(gridsArray, turn);
		int checkCounter = 0;
		InvalidMove im = new InvalidMove();
		
		//atas
		if(xKing-1 >= 0) {
			if(gridsArray[xKing-1][yKing] == 0) {
				moveKing(gridsArray, xKing, yKing, xKing-1, yKing);
				if(im.validateInvalidMove(gridsArray, turn) == true) checkCounter++;
				moveKing(gridsArray, xKing-1, yKing, xKing, yKing);
			}
			else {
				checkCounter++;
			}
		}
		else {
			checkCounter++;
		}
		
		//bawah
		if(xKing+1 <= 7) {
			if(gridsArray[xKing+1][yKing] == 0) {
				moveKing(gridsArray, xKing, yKing, xKing+1, yKing);
				if(im.validateInvalidMove(gridsArray, turn) == true) checkCounter++;
				moveKing(gridsArray, xKing+1, yKing, xKing, yKing);
			}
			else {
				checkCounter++;
			}			
		}
		else {
			checkCounter++;
		}
			
		//kiri
		if(yKing-1 >= 0) {
			if(gridsArray[xKing][yKing-1] == 0) {
				moveKing(gridsArray, xKing, yKing, xKing, yKing-1);
				if(im.validateInvalidMove(gridsArray, turn) == true) checkCounter++;
				moveKing(gridsArray, xKing, yKing-1, xKing, yKing);
			}
			else {
				checkCounter++;
			}
		}
		else {
			checkCounter++;
		}
			
		//kanan
		if(yKing+1 <= 7) {
			if(gridsArray[xKing][yKing+1] == 0) {
				moveKing(gridsArray, xKing, yKing, xKing, yKing+1);
				if(im.validateInvalidMove(gridsArray, turn) == true) checkCounter++;
				moveKing(gridsArray, xKing, yKing+1, xKing, yKing);
			}
			else {
				checkCounter++;
			}
		}
		else {
			checkCounter++;
		}
			
		//kanan atas
		if(xKing-1 >= 0 && yKing+1 <= 7) {
			if(gridsArray[xKing-1][yKing+1] == 0) {
				moveKing(gridsArray, xKing, yKing, xKing-1, yKing+1);
				if(im.validateInvalidMove(gridsArray, turn) == true) checkCounter++;
				moveKing(gridsArray, xKing-1, yKing+1, xKing, yKing);
			}
			else {
				checkCounter++;
			}
		}
		else {
			checkCounter++;
		}
		
		//kiri atas
		if(xKing-1 >= 0 && yKing-1 >= 0) {
			if(gridsArray[xKing-1][yKing-1] == 0) {
				moveKing(gridsArray, xKing, yKing, xKing-1, yKing-1);
				if(im.validateInvalidMove(gridsArray, turn) == true) checkCounter++;
				moveKing(gridsArray, xKing-1, yKing-1, xKing, yKing);
			}
			else {
				checkCounter++;
			}
		}
		else {
			checkCounter++;
		}
		
		//kiri bawah
		if(xKing+1 <= 7 && yKing-1 >= 0) {
			if(gridsArray[xKing+1][yKing-1] == 0) {
				moveKing(gridsArray, xKing, yKing, xKing+1, yKing-1);
				if(im.validateInvalidMove(gridsArray, turn) == true) checkCounter++;
				moveKing(gridsArray, xKing+1, yKing-1, xKing, yKing);
			}
			else {
				checkCounter++;
			}
		}
		else {
			checkCounter++;
		}
		
		//kanan bawah
		if(xKing+1 <= 7 && yKing+1 <= 7) {
			if(gridsArray[xKing+1][yKing+1] == 0) {
				moveKing(gridsArray, xKing, yKing, xKing+1, yKing+1);
				if(im.validateInvalidMove(gridsArray, turn) == true) checkCounter++;
				moveKing(gridsArray, xKing+1, yKing+1, xKing, yKing);
			}
			else {
				checkCounter++;
			}
		}
		else {
			checkCounter++;
		}
		
		return checkCounter;
	}
	
	public boolean checkmate(int gridsArray[][], int turn, int xEnemyCheck, int yEnemyCheck)
	{
		boolean rookSaveKing = false;
		boolean pawnSaveKing = false;
		boolean knightSaveKing = false;
		boolean bishopSaveKing = false;
		boolean queenSaveKing = false;
		boolean kingSaveHimself = false;
		
		if(isKingAvailableMoveChecked(gridsArray, turn) == 8)
		{
			
			for(int i = 0; i < 8; i++) {
				for(int j = 0; j < 8; j++) {					
					if(turn == 1) {
						if(gridsArray[i][j] == 1) {
							pawnSaveKing = canPawnSaveKing(turn, gridsArray, i,j, xEnemyCheck, yEnemyCheck);
						}
						else if(gridsArray[i][j] == 2) {
							rookSaveKing = canRookSaveKing(turn, gridsArray, i, j, xEnemyCheck, yEnemyCheck);
						}
						else if(gridsArray[i][j] == 3) {
							knightSaveKing = canKnightSaveKing(turn, gridsArray, i, j, xEnemyCheck, yEnemyCheck);
						}
						else if(gridsArray[i][j] == 4) {
							bishopSaveKing = canBishopSaveKing(turn, gridsArray, i, j, xEnemyCheck, yEnemyCheck);
						}
						else if(gridsArray[i][j] == 5) {
							queenSaveKing = canQueenSaveKing(turn, gridsArray, i, j, xEnemyCheck, yEnemyCheck);
						}
						else if(gridsArray[i][j] == 6) {
							kingSaveHimself = canKingSaveHimself(turn, gridsArray, i, j, xEnemyCheck, yEnemyCheck);
						}
						
					}
				}
			}
			
			if(pawnSaveKing == true || rookSaveKing == true || knightSaveKing == true || bishopSaveKing == true || queenSaveKing == true || kingSaveHimself == true)
			{
				return true;
			}else
			{
				return false;
			}
		}
		
		System.out.println(isKingAvailableMoveChecked(gridsArray, turn));
		return false;
	}
	
	public boolean kingStillChecked(int gridsArray[][], int turn, int x1, int y1, int x2, int y2)
	{
		InvalidMove im = new InvalidMove();
		
		gridsArray[x2][y2] = gridsArray[x1][y1];
		gridsArray[x1][y1] = 0;
		
		return im.validateInvalidMove(gridsArray, turn * -1);
	}
	
	public void returnGridsToNormal(int gridsArray[][], int x1, int y1, int x2, int y2)
	{
		gridsArray[x1][y1] = gridsArray[x2][y2];
		gridsArray[x2][y2] = 0;
	}
	
	public boolean canKingSaveHimself(int turn, int gridsArray[][], int x, int y, int xEnemyCheck, int yEnemyCheck) {
		if(x-1 >= 0) {
			if(x-1 == xEnemyCheck && y == yEnemyCheck && gridsArray[x-1][y] == gridsArray[xEnemyCheck][yEnemyCheck]) {
				if(kingStillChecked(gridsArray, turn, x, y, x-1, y) == false) return true;
				else return false;
			}
		}
		else if(x+1 <= 7) {
			if(x+1 == xEnemyCheck && y == yEnemyCheck && gridsArray[x+1][y] == gridsArray[xEnemyCheck][yEnemyCheck]) {
				if(kingStillChecked(gridsArray, turn, x, y, x+1, y) == false) return true;
				else return false;
			}
		}
		else if(y-1 >= 0) {
			if(x == xEnemyCheck && y-1 == yEnemyCheck && gridsArray[x][y-1] == gridsArray[xEnemyCheck][yEnemyCheck]) {
				if(kingStillChecked(gridsArray, turn, x, y, x, y-1) == false) return true;
				else return false;
			}
		}
		else if(y+1 <= 7) {
			if(x == xEnemyCheck && y+1 == yEnemyCheck && gridsArray[x][y+1] == gridsArray[xEnemyCheck][yEnemyCheck]) {
				if(kingStillChecked(gridsArray, turn, x, y, x, y+1) == false) return true;
				else return false;
			}
		}
		else if(x-1 >= 0 && y+1 <= 7) {
			if(x-1 == xEnemyCheck && y+1 == yEnemyCheck && gridsArray[x-1][y+1] == gridsArray[xEnemyCheck][yEnemyCheck]) {
				if(kingStillChecked(gridsArray, turn, x, y, x-1, y+1) == false) return true;
				else return false;
			}
		}
		else if(x-1 >= 0 && y-1 >= 0) {
			if(x-1 == xEnemyCheck && y-1 == yEnemyCheck && gridsArray[x-1][y-1] == gridsArray[xEnemyCheck][yEnemyCheck]) {
				if(kingStillChecked(gridsArray, turn, x, y, x-1, y-1) == false) return true;
				else return false;
			}
		}
		else if(x+1 <= 7 && y-1 >= 0) {
			if(x+1 == xEnemyCheck && y-1 == yEnemyCheck && gridsArray[x+1][y-1] == gridsArray[xEnemyCheck][yEnemyCheck]) {
				if(kingStillChecked(gridsArray, turn, x, y, x+1, y-1) == false) return true;
				else return false;
			}
		}
		else if(x+1 <= 7 && y+1 <= 7) {
			if(x+1 == xEnemyCheck && y+1 == yEnemyCheck && gridsArray[x+1][y+1] == gridsArray[xEnemyCheck][yEnemyCheck]) {
				if(kingStillChecked(gridsArray, turn, x, y, x+1, y+1) == false) return true;
				else return false;
			}
		}
		
		return false;
	}
	
	public boolean canRookSaveKing(int turn, int gridsArray[][], int x, int y, int xEnemyCheck, int yEnemyCheck) {		
		// cek ke atas
		for (int i = x - 1; i >= 0 ; i--) {
			if(turn == 1) {
				//halangin jalan yg ngeskak
				if(kingStillChecked(gridsArray, turn, x, y, i, y) == false) return true;
				else
				{
					returnGridsToNormal(gridsArray, x, y, i, y);
				}
				
				//makan yg ngeskak
				if(gridsArray[i][y] >= 7 && gridsArray[i][y] <= 12) {
					if(gridsArray[i][y] != 0 && i == xEnemyCheck && y == yEnemyCheck && gridsArray[i][y] == gridsArray[xEnemyCheck][yEnemyCheck]) {
						return true;
					}else
					{
						break;
					}
				}
			}
			else if(turn == -1) {
				if(kingStillChecked(gridsArray, turn, x, y, i, y) == false) return true;
				else
				{
					returnGridsToNormal(gridsArray, x, y, i, y);
				}
				
				if(gridsArray[i][y] >= 1 && gridsArray[i][y] <= 6) {
					if(gridsArray[i][y] != 0 && i == xEnemyCheck && y == yEnemyCheck && gridsArray[i][y] == gridsArray[xEnemyCheck][yEnemyCheck]) {
						return true;
					}else
					{
						break;
					}
				}
			}
		}
		
		// cek ke bawah
		for (int i = x + 1; i <= 7 ; i++) {
			if(turn == 1) {
				if(kingStillChecked(gridsArray, turn, x, y, i, y) == false) return true;
				else
				{
					returnGridsToNormal(gridsArray, x, y, i, y);
				}
				
				if(gridsArray[i][y] >= 7 && gridsArray[i][y] <= 12) {
					if(gridsArray[i][y] != 0 && i == xEnemyCheck && y == yEnemyCheck && gridsArray[i][y] == gridsArray[xEnemyCheck][yEnemyCheck]) {
						return true;
					}else
					{
						break;
					}
				}
			}
			else if(turn == -1) {
				if(kingStillChecked(gridsArray, turn, x, y, i, y) == false) return true;
				else
				{
					returnGridsToNormal(gridsArray, x, y, i, y);
				}
				
				if(gridsArray[i][y] >= 1 && gridsArray[i][y] <= 6) {
					if(gridsArray[i][y] != 0 && i == xEnemyCheck && y == yEnemyCheck && gridsArray[i][y] == gridsArray[xEnemyCheck][yEnemyCheck]) {
						return true;
					}else
					{
						break;
					}
				}
			}
		}
		
		// cek ke kanan
		for (int i = y + 1; i <= 7 ; i++) {
			if(turn == 1) {
				if(kingStillChecked(gridsArray, turn, x, y, x, i) == false) return true;
				else
				{
					returnGridsToNormal(gridsArray, x, y, x, i);
				}
				
				if(gridsArray[x][i] >= 7 && gridsArray[x][i] <= 12) {
					if(gridsArray[x][i] != 0 && x == xEnemyCheck && i == yEnemyCheck && gridsArray[x][i] == gridsArray[xEnemyCheck][yEnemyCheck]) {
						return true;
					}else
					{
						break;
					}
				}
			}
			else if(turn == -1) {
				if(kingStillChecked(gridsArray, turn, x, y, x, i) == false) return true;
				else
				{
					returnGridsToNormal(gridsArray, x, y, x, i);
				}
				
				if(gridsArray[x][i] >= 1 && gridsArray[x][i] <= 6) {
					if(gridsArray[x][i] != 0 && x == xEnemyCheck && i == yEnemyCheck && gridsArray[x][i] == gridsArray[xEnemyCheck][yEnemyCheck]) {
						return true;
					}else
					{
						break;
					}
				}
			}
		}
		
		//cek ke kiri
		for (int i = y - 1; i >= 0 ; i--) {
			if(turn == 1) {
				if(kingStillChecked(gridsArray, turn, x, y, x, i) == false) return true;
				else
				{
					returnGridsToNormal(gridsArray, x, y, x, i);
				}
				
				if(gridsArray[x][i] >= 7 && gridsArray[x][i] <= 12) {
					if(gridsArray[x][i] != 0 && x == xEnemyCheck && i == yEnemyCheck && gridsArray[x][i] == gridsArray[xEnemyCheck][yEnemyCheck]) {
						return true;
					}else
					{
						break;
					}
				}
			}
			else if(turn == -1) {
				if(kingStillChecked(gridsArray, turn, x, y, x, i) == false) return true;
				else
				{
					returnGridsToNormal(gridsArray, x, y, x, i);
				}
				
				if(gridsArray[x][i] >= 1 && gridsArray[x][i] <= 6) {
					if(gridsArray[x][i] != 0 && x == xEnemyCheck && i == yEnemyCheck && gridsArray[x][i] == gridsArray[xEnemyCheck][yEnemyCheck]) {
						return true;
					}else
					{
						break;
					}
				}
			}
		}
		return false;
	}

	public boolean canBishopSaveKing(int turn, int gridsArray[][], int x, int y, int xEnemyCheck, int yEnemyCheck) {
		// cek kanan atas
		for(int i = x-1, j = y+1; i >= 0; i--, j++) {
			if(j <= 7 && i >= 0) {
				if(kingStillChecked(gridsArray, turn, x, y, i, j) == false) return true;
				else
				{
					returnGridsToNormal(gridsArray, x, y, i, j);
				}
					
				if(i == xEnemyCheck && j == yEnemyCheck && gridsArray[i][j] == gridsArray[xEnemyCheck][yEnemyCheck]) {
					return true;				
				}else if(gridsArray[i][j] != 0 && gridsArray[i][j] != gridsArray[xEnemyCheck][yEnemyCheck]) break;
				
				if(i == 0 || j == 7) break;
			}		
		}
		
		// cek kiri atas
		for(int i = x-1, j = y-1; i >= 0; i--, j--) {
			if(j >= 0 && i >= 0) {
				if(kingStillChecked(gridsArray, turn, x, y, i, j) == false) return true;
				else
				{
					returnGridsToNormal(gridsArray, x, y, i, j);
				}
				
				if(i == xEnemyCheck && j == yEnemyCheck && gridsArray[i][j] == gridsArray[xEnemyCheck][yEnemyCheck]) {
					return true;				
				}else if(gridsArray[i][j] != 0 && gridsArray[i][j] != gridsArray[xEnemyCheck][yEnemyCheck]) break;
				
				if(i == 0 || j == 0) break;
			}		
		}
		
		// cek kiri bawah
		for(int i = x+1, j = y-1; i <= 7; i++, j--) {
			if(j >= 0 && i <= 7) {
				if(kingStillChecked(gridsArray, turn, x, y, i, j) == false) return true;
				else
				{
					returnGridsToNormal(gridsArray, x, y, i, j);
				}
				
				if(i == xEnemyCheck && j == yEnemyCheck && gridsArray[i][j] == gridsArray[xEnemyCheck][yEnemyCheck]) {
					return true;				
				}else if(gridsArray[i][j] != 0 && gridsArray[i][j] != gridsArray[xEnemyCheck][yEnemyCheck]) break;
				
				if(i == 7 || j == 0) break;
			}			
		}
		
		// cek kanan bawah
		for(int i = x+1, j = y+1; i <= 7; i++, j++) {
			if(i <= 7 && j <= 7) {
				if(kingStillChecked(gridsArray, turn, x, y, i, j) == false) return true;
				else
				{
					returnGridsToNormal(gridsArray, x, y, i, j);
				}
				
				if(i == xEnemyCheck && j == yEnemyCheck && gridsArray[i][j] == gridsArray[xEnemyCheck][yEnemyCheck]) {
					return true;				
				}else if(gridsArray[i][j] != 0 && gridsArray[i][j] != gridsArray[xEnemyCheck][yEnemyCheck]) break;
				
				if(i == 7 || j == 7) break;
			}	
		}
		return false;
	}
	
	public boolean canQueenSaveKing(int turn, int gridsArray[][], int x, int y, int xEnemyCheck, int yEnemyCheck) {
		if(turn == 1) {
			if(canRookSaveKing(turn, gridsArray, x, y, xEnemyCheck, yEnemyCheck) == true) return true;
			if(canBishopSaveKing(turn, gridsArray, x, y, xEnemyCheck, yEnemyCheck) == true) return true;
		}
		else if(turn == -1) {
			if(canRookSaveKing(turn, gridsArray, x, y, xEnemyCheck, yEnemyCheck) == true) return true;
			if(canBishopSaveKing(turn, gridsArray, x, y, xEnemyCheck, yEnemyCheck) == true) return true;
		}
		return false;
	}
	
	public boolean canPawnSaveKing(int turn, int gridsArray[][], int x, int y, int xEnemyCheck, int yEnemyCheck) {
		if(turn == 1) {
			if(x-1 >= 0 && y-1 >= 0) {
				if(kingStillChecked(gridsArray, turn, x, y, x-1, y-1) == false) return true;
				else
				{
					returnGridsToNormal(gridsArray, x, y, x-1, y-1);
				}
				
				if(x-1 == xEnemyCheck && y-1 == yEnemyCheck && gridsArray[x-1][y-1] == gridsArray[xEnemyCheck][yEnemyCheck]) return true;
			}
			if(x-1 >= 0 && y+1 <= 7) {
				if(kingStillChecked(gridsArray, turn, x, y, x-1, y+1) == false) return true;
				else
				{
					returnGridsToNormal(gridsArray, x, y, x-1, y+1);
				}
				
				if(x-1 == xEnemyCheck && y+1 == yEnemyCheck && gridsArray[x-1][y+1] == gridsArray[xEnemyCheck][yEnemyCheck]) return true;
			}
		}
		else if(turn == -1) {
			if(x+1 <= 7 && y+1 <= 7) {
				if(kingStillChecked(gridsArray, turn, x, y, x+1, y+1) == false) return true;
				else
				{
					returnGridsToNormal(gridsArray, x, y, x+1, y+1);
				}
				
				if(x+1 == xEnemyCheck && y+1 == yEnemyCheck && gridsArray[x+1][y+1] == gridsArray[xEnemyCheck][yEnemyCheck]) return true;
			}
			if(x+1 <= 7 && y-1 >= 0) {
				if(kingStillChecked(gridsArray, turn, x, y, x+1, y-1) == false) return true;
				else
				{
					returnGridsToNormal(gridsArray, x, y, x+1, y-1);
				}
				
				if(x+1 == xEnemyCheck && y-1 == yEnemyCheck && gridsArray[x+1][y-1] == gridsArray[xEnemyCheck][yEnemyCheck]) return true;
			}
		}
		return false;
	}
	
	public boolean canKnightSaveKing(int turn, int gridsArray[][], int x, int y, int xEnemyCheck, int yEnemyCheck) {
			if(x == 0 && y == 0)
			{
				if(kingStillChecked(gridsArray, turn, x, y, x+1, y+2) == false) return true;
				else
				{
					returnGridsToNormal(gridsArray, x, y, x+1, y+2);
				}
				
				if(kingStillChecked(gridsArray, turn, x, y, x+2, y+1) == false) return true;
				else
				{
					returnGridsToNormal(gridsArray, x, y, x+2, y+1);
				}
				
				if((x+1 == xEnemyCheck && y+2 == yEnemyCheck && gridsArray[x+1][y+2] == gridsArray[xEnemyCheck][yEnemyCheck]) ||
						(x+2 == xEnemyCheck && y+1 == yEnemyCheck && gridsArray[x+2][y+1] == gridsArray[xEnemyCheck][yEnemyCheck])) return true;
			}else if(x == 0 && y == 7)
			{
				if(kingStillChecked(gridsArray, turn, x, y, x+1, y-2) == false) return true;
				else
				{
					returnGridsToNormal(gridsArray, x, y, x+1, y-2);
				}
				
				if(kingStillChecked(gridsArray, turn, x, y, x+2, y-1) == false) return true;
				else
				{
					returnGridsToNormal(gridsArray, x, y, x+2, y-1);
				}
				
				if((x+1 == xEnemyCheck && y-2 == yEnemyCheck && gridsArray[x+1][y-2] == gridsArray[xEnemyCheck][yEnemyCheck]) ||
						(x+2 == xEnemyCheck && y-1 == yEnemyCheck && gridsArray[x+2][y-1] == gridsArray[xEnemyCheck][yEnemyCheck])) return true;
			}else if(x == 7 && y == 7)
			{
				if(kingStillChecked(gridsArray, turn, x, y, x-1, y-2) == false) return true;
				else
				{
					returnGridsToNormal(gridsArray, x, y, x-1, y-2);
				}
				
				if(kingStillChecked(gridsArray, turn, x, y, x-2, y-1) == false) return true;
				else
				{
					returnGridsToNormal(gridsArray, x, y, x-2, y-1);
				}
				
				if((x-1 == xEnemyCheck && y-2 == yEnemyCheck && gridsArray[x-1][y-2] == gridsArray[xEnemyCheck][yEnemyCheck]) ||
						(x-2 == xEnemyCheck && y-1 == yEnemyCheck && gridsArray[x-2][y-1] == gridsArray[xEnemyCheck][yEnemyCheck])) return true;
			}else if(x == 7 && y == 0)
			{
				if(kingStillChecked(gridsArray, turn, x, y, x-1, y+2) == false) return true;
				else
				{
					returnGridsToNormal(gridsArray, x, y, x-1, y+2);
				}
				
				if(kingStillChecked(gridsArray, turn, x, y, x-2, y+1) == false) return true;
				else
				{
					returnGridsToNormal(gridsArray, x, y, x-2, y+1);
				}
				
				if((x-1 == xEnemyCheck && y+2 == yEnemyCheck && gridsArray[x-1][y+2] == gridsArray[xEnemyCheck][yEnemyCheck]) ||
						(x-2 == xEnemyCheck && y+1 == yEnemyCheck && gridsArray[x-2][y+1] == gridsArray[xEnemyCheck][yEnemyCheck])) return true;
			}else if(x == 0)
			{
				if(y == 1)
				{
					if(kingStillChecked(gridsArray, turn, x, y, x+2, y-1) == false) return true;
					else
					{
						returnGridsToNormal(gridsArray, x, y, x+2, y-1);
					}
					
					if(kingStillChecked(gridsArray, turn, x, y, x+2, y+1) == false) return true;
					else
					{
						returnGridsToNormal(gridsArray, x, y, x+2, y+1);
					}
					if(kingStillChecked(gridsArray, turn, x, y, x+1, y+2) == false) return true;
					else
					{
						returnGridsToNormal(gridsArray, x, y, x+1, y+2);
					}
					
					
					if((x+2 == xEnemyCheck && y-1 == yEnemyCheck && gridsArray[x+2][y-1] == gridsArray[xEnemyCheck][yEnemyCheck]) ||
							(x+2 == xEnemyCheck && y+1 == yEnemyCheck && gridsArray[x+2][y+1] == gridsArray[xEnemyCheck][yEnemyCheck]) ||
							(x+1 == xEnemyCheck && y+2 == yEnemyCheck && gridsArray[x+1][y+2] == gridsArray[xEnemyCheck][yEnemyCheck])) return true;
				}else if(y == 6)
				{
					if(kingStillChecked(gridsArray, turn, x, y, x+2, y+1) == false) return true;
					else
					{
						returnGridsToNormal(gridsArray, x, y, x+2, y+1);
					}
					
					if(kingStillChecked(gridsArray, turn, x, y, x+2, y-1) == false) return true;
					else
					{
						returnGridsToNormal(gridsArray, x, y, x+2, y-1);
					}
					if(kingStillChecked(gridsArray, turn, x, y, x+1, y-2) == false) return true;
					else
					{
						returnGridsToNormal(gridsArray, x, y, x+1, y-2);
					}
					
					
					if((x+2 == xEnemyCheck && y+1 == yEnemyCheck && gridsArray[x+2][y+1] == gridsArray[xEnemyCheck][yEnemyCheck]) ||
							(x+2 == xEnemyCheck && y-1 == yEnemyCheck && gridsArray[x+2][y-1] == gridsArray[xEnemyCheck][yEnemyCheck]) ||
							(x+1 == xEnemyCheck && y-2 == yEnemyCheck && gridsArray[x+1][y-2] == gridsArray[xEnemyCheck][yEnemyCheck])) return true;
				}else
				{
					if(kingStillChecked(gridsArray, turn, x, y, x+1, y-2) == false) return true;
					else
					{
						returnGridsToNormal(gridsArray, x, y, x+1, y-2);
					}
					
					if(kingStillChecked(gridsArray, turn, x, y, x+2, y-1) == false) return true;
					else
					{
						returnGridsToNormal(gridsArray, x, y, x+2, y-1);
					}
					if(kingStillChecked(gridsArray, turn, x, y, x+2, y+1) == false) return true;
					else
					{
						returnGridsToNormal(gridsArray, x, y, x+2, y+1);
					}
					if(kingStillChecked(gridsArray, turn, x, y, x+1, y+2) == false) return true;
					else
					{
						returnGridsToNormal(gridsArray, x, y, x+1, y+2);
					}
					
					
					if((x+1 == xEnemyCheck && y-2 == yEnemyCheck && gridsArray[x+1][y-2] == gridsArray[xEnemyCheck][yEnemyCheck]) ||
							(x+2 == xEnemyCheck && y-1 == yEnemyCheck && gridsArray[x+2][y-1] == gridsArray[xEnemyCheck][yEnemyCheck]) ||
							(x+2 == xEnemyCheck && y+1 == yEnemyCheck && gridsArray[x+2][y+1] == gridsArray[xEnemyCheck][yEnemyCheck]) || 
							(x+1 == xEnemyCheck && y+2 == yEnemyCheck && gridsArray[x+1][y+2] == gridsArray[xEnemyCheck][yEnemyCheck])) return true;
				}
			}else if(x == 7)
			{
				if(y == 1)
				{
					if(kingStillChecked(gridsArray, turn, x, y, x-2, y-1) == false) return true;
					else
					{
						returnGridsToNormal(gridsArray, x, y, x-2, y-1);
					}
					
					if(kingStillChecked(gridsArray, turn, x, y, x-2, y+1) == false) return true;
					else
					{
						returnGridsToNormal(gridsArray, x, y, x-2, y+1);
					}
					if(kingStillChecked(gridsArray, turn, x, y, x-1, y+2) == false) return true;
					else
					{
						returnGridsToNormal(gridsArray, x, y, x-1, y+2);
					}
					
					
					if((x-2 == xEnemyCheck && y-1 == yEnemyCheck && gridsArray[x-2][y-1] == gridsArray[xEnemyCheck][yEnemyCheck]) ||
							(x-2 == xEnemyCheck && y+1 == yEnemyCheck && gridsArray[x-2][y+1] == gridsArray[xEnemyCheck][yEnemyCheck]) ||
							(x-1 == xEnemyCheck && y+2 == yEnemyCheck && gridsArray[x-1][y+2] == gridsArray[xEnemyCheck][yEnemyCheck])) return true;
				}else if(y == 6)
				{
					if(kingStillChecked(gridsArray, turn, x, y, x-2, y+1) == false) return true;
					else
					{
						returnGridsToNormal(gridsArray, x, y, x-2, y-1);
					}
					
					if(kingStillChecked(gridsArray, turn, x, y, x-2, y-1) == false) return true;
					else
					{
						returnGridsToNormal(gridsArray, x, y, x-2, y+1);
					}
					if(kingStillChecked(gridsArray, turn, x, y, x-1, y-2) == false) return true;
					else
					{
						returnGridsToNormal(gridsArray, x, y, x-1, y-2);
					}
					
					
					if((x-2 == xEnemyCheck && y+1 == yEnemyCheck && gridsArray[x-2][y+1] == gridsArray[xEnemyCheck][yEnemyCheck]) ||
							(x-2 == xEnemyCheck && y-1 == yEnemyCheck && gridsArray[x-2][y-1] == gridsArray[xEnemyCheck][yEnemyCheck]) ||
							(x-1 == xEnemyCheck && y-2 == yEnemyCheck && gridsArray[x-1][y-2] == gridsArray[xEnemyCheck][yEnemyCheck])) return true;
				}else
				{
					if(kingStillChecked(gridsArray, turn, x, y, x-2, y-1) == false) return true;
					else
					{
						returnGridsToNormal(gridsArray, x, y, x-2, y-1);
					}
					
					if(kingStillChecked(gridsArray, turn, x, y, x-2, y+1) == false) return true;
					else
					{
						returnGridsToNormal(gridsArray, x, y, x-2, y+1);
					}
					if(kingStillChecked(gridsArray, turn, x, y, x-1, y+2) == false) return true;
					else
					{
						returnGridsToNormal(gridsArray, x, y, x-1, y+2);
					}
					if(kingStillChecked(gridsArray, turn, x, y, x-1, y-2) == false) return true;
					else
					{
						returnGridsToNormal(gridsArray, x, y, x-1, y-2);
					}
					
					
					if((x-2 == xEnemyCheck && y-1 == yEnemyCheck && gridsArray[x-2][y-1] == gridsArray[xEnemyCheck][yEnemyCheck]) ||
							(x-2 == xEnemyCheck && y+1 == yEnemyCheck && gridsArray[x-2][y+1] == gridsArray[xEnemyCheck][yEnemyCheck]) ||
							(x-1 == xEnemyCheck && y+2 == yEnemyCheck && gridsArray[x-1][y+2] == gridsArray[xEnemyCheck][yEnemyCheck]) || 
							(x-1 == xEnemyCheck && y-2 == yEnemyCheck && gridsArray[x-1][y-2] == gridsArray[xEnemyCheck][yEnemyCheck])) return true;
				}
			}else if(y == 0)
			{
				if(x == 1)
				{
					if(kingStillChecked(gridsArray, turn, x, y, x-1, y+2) == false) return true;
					else
					{
						returnGridsToNormal(gridsArray, x, y, x-1, y+2);
					}
					
					if(kingStillChecked(gridsArray, turn, x, y, x+1, y+2) == false) return true;
					else
					{
						returnGridsToNormal(gridsArray, x, y, x+1, y+2);
					}
					if(kingStillChecked(gridsArray, turn, x, y, x+2, y+1) == false) return true;
					else
					{
						returnGridsToNormal(gridsArray, x, y, x+2, y+1);
					}
					
					
					if((x-1 == xEnemyCheck && y+2 == yEnemyCheck && gridsArray[x-1][y+2] == gridsArray[xEnemyCheck][yEnemyCheck]) ||
							(x+1 == xEnemyCheck && y+2 == yEnemyCheck && gridsArray[x+1][y+2] == gridsArray[xEnemyCheck][yEnemyCheck]) ||
							(x+2 == xEnemyCheck && y+1 == yEnemyCheck && gridsArray[x+2][y+1] == gridsArray[xEnemyCheck][yEnemyCheck])) return true;
				}else if(x == 6)
				{
					if(kingStillChecked(gridsArray, turn, x, y, x-2, y+1) == false) return true;
					else
					{
						returnGridsToNormal(gridsArray, x, y, x-2, y+1);
					}
					
					if(kingStillChecked(gridsArray, turn, x, y, x-1, y+2) == false) return true;
					else
					{
						returnGridsToNormal(gridsArray, x, y, x-1, y+2);
					}
					if(kingStillChecked(gridsArray, turn, x, y, x+1, y+2) == false) return true;
					else
					{
						returnGridsToNormal(gridsArray, x, y, x+1, y+2);
					}
					
					
					if((x-2 == xEnemyCheck && y+1 == yEnemyCheck && gridsArray[x-2][y+1] == gridsArray[xEnemyCheck][yEnemyCheck]) ||
							(x-1 == xEnemyCheck && y+2 == yEnemyCheck && gridsArray[x-1][y+2] == gridsArray[xEnemyCheck][yEnemyCheck]) ||
							(x+1 == xEnemyCheck && y+2 == yEnemyCheck && gridsArray[x+1][y+2] == gridsArray[xEnemyCheck][yEnemyCheck])) return true;
				}else
				{
					if(kingStillChecked(gridsArray, turn, x, y, x-1, y+2) == false) return true;
					else
					{
						returnGridsToNormal(gridsArray, x, y, x-1, y+2);
					}
					
					if(kingStillChecked(gridsArray, turn, x, y, x+1, y+2) == false) return true;
					else
					{
						returnGridsToNormal(gridsArray, x, y, x+1, y+2);
					}
					if(kingStillChecked(gridsArray, turn, x, y, x+2, y+1) == false) return true;
					else
					{
						returnGridsToNormal(gridsArray, x, y, x+2, y+1);
					}
					if(kingStillChecked(gridsArray, turn, x, y, x-2, y+1) == false) return true;
					else
					{
						returnGridsToNormal(gridsArray, x, y, x-2, y+1);
					}
					
					if((x-1 == xEnemyCheck && y+2 == yEnemyCheck && gridsArray[x-1][y+2] == gridsArray[xEnemyCheck][yEnemyCheck]) ||
							(x+1 == xEnemyCheck && y+2 == yEnemyCheck && gridsArray[x+1][y+2] == gridsArray[xEnemyCheck][yEnemyCheck]) ||
							(x+2 == xEnemyCheck && y+1 == yEnemyCheck && gridsArray[x+2][y+1] == gridsArray[xEnemyCheck][yEnemyCheck]) || 
							(x-2 == xEnemyCheck && y+1 == yEnemyCheck && gridsArray[x-2][y+1] == gridsArray[xEnemyCheck][yEnemyCheck])) return true;
				}
			}else if(y == 7)
			{
				if(x == 1)
				{
					if(kingStillChecked(gridsArray, turn, x, y, x-1, y-2) == false) return true;
					else
					{
						returnGridsToNormal(gridsArray, x, y, x-1, y-2);
					}
					
					if(kingStillChecked(gridsArray, turn, x, y, x+1, y-2) == false) return true;
					else
					{
						returnGridsToNormal(gridsArray, x, y, x+1, y-2);
					}
					if(kingStillChecked(gridsArray, turn, x, y, x+2, y-1) == false) return true;
					else
					{
						returnGridsToNormal(gridsArray, x, y, x+2, y-1);
					}
					
					
					if((x-1 == xEnemyCheck && y-2 == yEnemyCheck && gridsArray[x-1][y-2] == gridsArray[xEnemyCheck][yEnemyCheck]) ||
							(x+1 == xEnemyCheck && y-2 == yEnemyCheck && gridsArray[x+1][y-2] == gridsArray[xEnemyCheck][yEnemyCheck]) ||
							(x+2 == xEnemyCheck && y-1 == yEnemyCheck && gridsArray[x+2][y-1] == gridsArray[xEnemyCheck][yEnemyCheck])) return true;
				}else if(x == 6)
				{
					if(kingStillChecked(gridsArray, turn, x, y, x-1, y-2) == false) return true;
					else
					{
						returnGridsToNormal(gridsArray, x, y, x-1, y-2);
					}
					
					if(kingStillChecked(gridsArray, turn, x, y, x+1, y-2) == false) return true;
					else
					{
						returnGridsToNormal(gridsArray, x, y, x+1, y-2);
					}
					if(kingStillChecked(gridsArray, turn, x, y, x-2, y-1) == false) return true;
					else
					{
						returnGridsToNormal(gridsArray, x, y, x-2, y-1);
					}
					
					
					if((x-1 == xEnemyCheck && y-2 == yEnemyCheck && gridsArray[x-1][y-2] == gridsArray[xEnemyCheck][yEnemyCheck]) ||
							(x+1 == xEnemyCheck && y-2 == yEnemyCheck && gridsArray[x+1][y-2] == gridsArray[xEnemyCheck][yEnemyCheck]) ||
							(x-2 == xEnemyCheck && y-1 == yEnemyCheck && gridsArray[x-2][y-1] == gridsArray[xEnemyCheck][yEnemyCheck])) return true;
				}else
				{
					if(kingStillChecked(gridsArray, turn, x, y, x-1, y-2) == false) return true;
					else
					{
						returnGridsToNormal(gridsArray, x, y, x-1, y-2);
					}
					
					if(kingStillChecked(gridsArray, turn, x, y, x+1, y-2) == false) return true;
					else
					{
						returnGridsToNormal(gridsArray, x, y, x+1, y-2);
					}
					if(kingStillChecked(gridsArray, turn, x, y, x+2, y-1) == false) return true;
					else
					{
						returnGridsToNormal(gridsArray, x, y, x+2, y-1);
					}
					if(kingStillChecked(gridsArray, turn, x, y, x-2, y-1) == false) return true;
					else
					{
						returnGridsToNormal(gridsArray, x, y, x-2, y-1);
					}
					
					
					if((x-1 == xEnemyCheck && y-2 == yEnemyCheck && gridsArray[x-1][y-2] == gridsArray[xEnemyCheck][yEnemyCheck]) ||
							(x+1 == xEnemyCheck && y-2 == yEnemyCheck && gridsArray[x+1][y-2] == gridsArray[xEnemyCheck][yEnemyCheck]) ||
							(x+2 == xEnemyCheck && y-1 == yEnemyCheck && gridsArray[x+2][y-1] == gridsArray[xEnemyCheck][yEnemyCheck]) ||
							(x-2 == xEnemyCheck && y-1 == yEnemyCheck && gridsArray[x-2][y-1] == gridsArray[xEnemyCheck][yEnemyCheck])) return true;
				}
			}else if(x == 1)
			{
				if(y == 1)
				{
					if(kingStillChecked(gridsArray, turn, x, y, x+2, y-1) == false) return true;
					else
					{
						returnGridsToNormal(gridsArray, x, y, x+2, y-1);
					}
					
					if(kingStillChecked(gridsArray, turn, x, y, x+2, y+1) == false) return true;
					else
					{
						returnGridsToNormal(gridsArray, x, y, x+2, y+1);
					}
					if(kingStillChecked(gridsArray, turn, x, y, x+1, y+2) == false) return true;
					else
					{
						returnGridsToNormal(gridsArray, x, y, x+1, y+2);
					}
					if(kingStillChecked(gridsArray, turn, x, y, x-1, y+2) == false) return true;
					else
					{
						returnGridsToNormal(gridsArray, x, y, x-1, y+2);
					}
					
					if((x+2 == xEnemyCheck && y-1 == yEnemyCheck && gridsArray[x+2][y-1] == gridsArray[xEnemyCheck][yEnemyCheck]) ||
							(x+2 == xEnemyCheck && y+1 == yEnemyCheck && gridsArray[x+2][y+1] == gridsArray[xEnemyCheck][yEnemyCheck]) ||
							(x+1 == xEnemyCheck && y+2 == yEnemyCheck && gridsArray[x+1][y+2] == gridsArray[xEnemyCheck][yEnemyCheck]) ||
							(x-1 == xEnemyCheck && y+2 == yEnemyCheck && gridsArray[x-1][y+2] == gridsArray[xEnemyCheck][yEnemyCheck])) return true;
				}else if(y == 6)
				{
					if(kingStillChecked(gridsArray, turn, x, y, x+2, y-1) == false) return true;
					else
					{
						returnGridsToNormal(gridsArray, x, y, x+2, y-1);
					}
					
					if(kingStillChecked(gridsArray, turn, x, y, x+2, y+1) == false) return true;
					else
					{
						returnGridsToNormal(gridsArray, x, y, x+2, y+1);
					}
					if(kingStillChecked(gridsArray, turn, x, y, x+1, y-2) == false) return true;
					else
					{
						returnGridsToNormal(gridsArray, x, y, x+1, y-2);
					}
					if(kingStillChecked(gridsArray, turn, x, y, x-1, y-2) == false) return true;
					else
					{
						returnGridsToNormal(gridsArray, x, y, x-1, y-2);
					}
					
					if((x+2 == xEnemyCheck && y-1 == yEnemyCheck && gridsArray[x+2][y-1] == gridsArray[xEnemyCheck][yEnemyCheck]) ||
							(x+2 == xEnemyCheck && y+1 == yEnemyCheck && gridsArray[x+2][y+1] == gridsArray[xEnemyCheck][yEnemyCheck]) ||
							(x+1 == xEnemyCheck && y-2 == yEnemyCheck && gridsArray[x+1][y-2] == gridsArray[xEnemyCheck][yEnemyCheck]) ||
							(x-1 == xEnemyCheck && y-2 == yEnemyCheck && gridsArray[x-1][y-2] == gridsArray[xEnemyCheck][yEnemyCheck])) return true;
				}else
				{
					if(kingStillChecked(gridsArray, turn, x, y, x+2, y-1) == false) return true;
					else
					{
						returnGridsToNormal(gridsArray, x, y, x+2, y-1);
					}
					
					if(kingStillChecked(gridsArray, turn, x, y, x+2, y+1) == false) return true;
					else
					{
						returnGridsToNormal(gridsArray, x, y, x+2, y+1);
					}
					if(kingStillChecked(gridsArray, turn, x, y, x+1, y+2) == false) return true;
					else
					{
						returnGridsToNormal(gridsArray, x, y, x+1, y+2);
					}
					if(kingStillChecked(gridsArray, turn, x, y, x-1, y+2) == false) return true;
					else
					{
						returnGridsToNormal(gridsArray, x, y, x-1, y+2);
					}
					if(kingStillChecked(gridsArray, turn, x, y, x+1, y-2) == false) return true;
					else
					{
						returnGridsToNormal(gridsArray, x, y, x+1, y-2);
					}
					if(kingStillChecked(gridsArray, turn, x, y, x-1, y-2) == false) return true;
					else
					{
						returnGridsToNormal(gridsArray, x, y, x-1, y-2);
					}
					
					if((x+2 == xEnemyCheck && y-1 == yEnemyCheck && gridsArray[x+2][y-1] == gridsArray[xEnemyCheck][yEnemyCheck]) ||
							(x+2 == xEnemyCheck && y+1 == yEnemyCheck && gridsArray[x+2][y+1] == gridsArray[xEnemyCheck][yEnemyCheck]) ||
							(x+1 == xEnemyCheck && y+2 == yEnemyCheck && gridsArray[x+1][y+2] == gridsArray[xEnemyCheck][yEnemyCheck]) ||
							(x-1 == xEnemyCheck && y+2 == yEnemyCheck && gridsArray[x-1][y+2] == gridsArray[xEnemyCheck][yEnemyCheck]) ||
							(x+1 == xEnemyCheck && y-2 == yEnemyCheck && gridsArray[x+1][y-2] == gridsArray[xEnemyCheck][yEnemyCheck]) ||
							(x-1 == xEnemyCheck && y-2 == yEnemyCheck && gridsArray[x-1][y-2] == gridsArray[xEnemyCheck][yEnemyCheck])) return true;
				}
			}else if(x == 6)
			{
				if(y == 1)
				{
					if(kingStillChecked(gridsArray, turn, x, y, x+1, y+2) == false) return true;
					else
					{
						returnGridsToNormal(gridsArray, x, y, x+1, y+2);
					}
					
					if(kingStillChecked(gridsArray, turn, x, y, x-1, y+2) == false) return true;
					else
					{
						returnGridsToNormal(gridsArray, x, y, x-1, y+2);
					}
					if(kingStillChecked(gridsArray, turn, x, y, x-2, y+1) == false) return true;
					else
					{
						returnGridsToNormal(gridsArray, x, y, x-2, y+1);
					}
					if(kingStillChecked(gridsArray, turn, x, y, x-2, y-1) == false) return true;
					else
					{
						returnGridsToNormal(gridsArray, x, y, x-2, y-1);
					}
					
					if((x+1 == xEnemyCheck && y+2 == yEnemyCheck && gridsArray[x+1][y+2] == gridsArray[xEnemyCheck][yEnemyCheck]) ||
							(x-1 == xEnemyCheck && y+2 == yEnemyCheck && gridsArray[x-1][y+2] == gridsArray[xEnemyCheck][yEnemyCheck]) ||
							(x-2 == xEnemyCheck && y+1 == yEnemyCheck && gridsArray[x-2][y+1] == gridsArray[xEnemyCheck][yEnemyCheck]) ||
							(x-2 == xEnemyCheck && y-1 == yEnemyCheck && gridsArray[x-2][y-1] == gridsArray[xEnemyCheck][yEnemyCheck])) return true;
				}else if(y == 6)
				{
					if(kingStillChecked(gridsArray, turn, x, y, x+1, y-2) == false) return true;
					else
					{
						returnGridsToNormal(gridsArray, x, y, x+1, y-2);
					}
					
					if(kingStillChecked(gridsArray, turn, x, y, x-1, y-2) == false) return true;
					else
					{
						returnGridsToNormal(gridsArray, x, y, x-1, y-2);
					}
					if(kingStillChecked(gridsArray, turn, x, y, x-2, y+1) == false) return true;
					else
					{
						returnGridsToNormal(gridsArray, x, y, x-2, y+1);
					}
					if(kingStillChecked(gridsArray, turn, x, y, x-2, y-1) == false) return true;
					else
					{
						returnGridsToNormal(gridsArray, x, y, x-2, y-1);
					}
					
					if((x+1 == xEnemyCheck && y-2 == yEnemyCheck && gridsArray[x+1][y-2] == gridsArray[xEnemyCheck][yEnemyCheck]) ||
							(x-1 == xEnemyCheck && y-2 == yEnemyCheck && gridsArray[x-1][y-2] == gridsArray[xEnemyCheck][yEnemyCheck]) ||
							(x-2 == xEnemyCheck && y+1 == yEnemyCheck && gridsArray[x-2][y+1] == gridsArray[xEnemyCheck][yEnemyCheck]) ||
							(x-2 == xEnemyCheck && y-1 == yEnemyCheck && gridsArray[x-2][y-1] == gridsArray[xEnemyCheck][yEnemyCheck])) return true;
				}else
				{
					if(kingStillChecked(gridsArray, turn, x, y, x+1, y+2) == false) return true;
					else
					{
						returnGridsToNormal(gridsArray, x, y, x+1, y+2);
					}
					
					if(kingStillChecked(gridsArray, turn, x, y, x-1, y+2) == false) return true;
					else
					{
						returnGridsToNormal(gridsArray, x, y, x-1, y+2);
					}
					if(kingStillChecked(gridsArray, turn, x, y, x-2, y+1) == false) return true;
					else
					{
						returnGridsToNormal(gridsArray, x, y, x-2, y+1);
					}
					if(kingStillChecked(gridsArray, turn, x, y, x-2, y-1) == false) return true;
					else
					{
						returnGridsToNormal(gridsArray, x, y, x-2, y-1);
					}
					if(kingStillChecked(gridsArray, turn, x, y, x+1, y-2) == false) return true;
					else
					{
						returnGridsToNormal(gridsArray, x, y, x+1, y-2);
					}
					
					if(kingStillChecked(gridsArray, turn, x, y, x-1, y-2) == false) return true;
					else
					{
						returnGridsToNormal(gridsArray, x, y, x-1, y-2);
					}
					
					if((x+1 == xEnemyCheck && y+2 == yEnemyCheck && gridsArray[x+1][y+2] == gridsArray[xEnemyCheck][yEnemyCheck]) ||
							(x-1 == xEnemyCheck && y+2 == yEnemyCheck && gridsArray[x-1][y+2] == gridsArray[xEnemyCheck][yEnemyCheck]) ||
							(x-2 == xEnemyCheck && y+1 == yEnemyCheck && gridsArray[x-2][y+1] == gridsArray[xEnemyCheck][yEnemyCheck]) ||
							(x-2 == xEnemyCheck && y-1 == yEnemyCheck && gridsArray[x-2][y-1] == gridsArray[xEnemyCheck][yEnemyCheck]) ||
							(x+1 == xEnemyCheck && y-2 == yEnemyCheck && gridsArray[x+1][y-2] == gridsArray[xEnemyCheck][yEnemyCheck]) ||
							(x-1 == xEnemyCheck && y-2 == yEnemyCheck && gridsArray[x-1][y-2] == gridsArray[xEnemyCheck][yEnemyCheck])) return true;
				}
			}else if(y == 1)
			{
				if(kingStillChecked(gridsArray, turn, x, y, x-2, y+1) == false) return true;
				else
				{
					returnGridsToNormal(gridsArray, x, y, x-2, y+1);
				}
				
				if(kingStillChecked(gridsArray, turn, x, y, x-1, y+2) == false) return true;
				else
				{
					returnGridsToNormal(gridsArray, x, y, x-1, y+2);
				}
				if(kingStillChecked(gridsArray, turn, x, y, x-2, y-1) == false) return true;
				else
				{
					returnGridsToNormal(gridsArray, x, y, x-2, y-1);
				}
				if(kingStillChecked(gridsArray, turn, x, y, x+2, y-1) == false) return true;
				else
				{
					returnGridsToNormal(gridsArray, x, y, x+2, y-1);
				}
				if(kingStillChecked(gridsArray, turn, x, y, x+2, y+1) == false) return true;
				else
				{
					returnGridsToNormal(gridsArray, x, y, x+2, y+1);
				}
				
				if(kingStillChecked(gridsArray, turn, x, y, x+1, y+2) == false) return true;
				else
				{
					returnGridsToNormal(gridsArray, x, y, x+1, y+2);
				}
				
				if((x-2 == xEnemyCheck && y+1 == yEnemyCheck && gridsArray[x-2][y+1] == gridsArray[xEnemyCheck][yEnemyCheck]) ||
						(x-1 == xEnemyCheck && y+2 == yEnemyCheck && gridsArray[x-1][y+2] == gridsArray[xEnemyCheck][yEnemyCheck]) ||
						(x-2 == xEnemyCheck && y-1 == yEnemyCheck && gridsArray[x-2][y-1] == gridsArray[xEnemyCheck][yEnemyCheck]) ||
						(x+2 == xEnemyCheck && y-1 == yEnemyCheck && gridsArray[x+2][y-1] == gridsArray[xEnemyCheck][yEnemyCheck]) ||
						(x+2 == xEnemyCheck && y+1 == yEnemyCheck && gridsArray[x+2][y+1] == gridsArray[xEnemyCheck][yEnemyCheck]) ||
						(x+1 == xEnemyCheck && y+2 == yEnemyCheck && gridsArray[x+1][y+2] == gridsArray[xEnemyCheck][yEnemyCheck])) return true;
			}else if(y == 6)
			{
				if(kingStillChecked(gridsArray, turn, x, y, x-2, y+1) == false) return true;
				else
				{
					returnGridsToNormal(gridsArray, x, y, x-2, y+1);
				}
				
				if(kingStillChecked(gridsArray, turn, x, y, x-2, y-1) == false) return true;
				else
				{
					returnGridsToNormal(gridsArray, x, y, x-2, y-1);
				}
				if(kingStillChecked(gridsArray, turn, x, y, x-1, y-2) == false) return true;
				else
				{
					returnGridsToNormal(gridsArray, x, y, x-1, y-2);
				}
				if(kingStillChecked(gridsArray, turn, x, y, x+2, y-1) == false) return true;
				else
				{
					returnGridsToNormal(gridsArray, x, y, x+2, y-1);
				}
				if(kingStillChecked(gridsArray, turn, x, y, x+1, y-2) == false) return true;
				else
				{
					returnGridsToNormal(gridsArray, x, y, x+1, y-2);
				}
				
				if(kingStillChecked(gridsArray, turn, x, y, x+2, y+1) == false) return true;
				else
				{
					returnGridsToNormal(gridsArray, x, y, x+2, y+1);
				}
				
				if((x-2 == xEnemyCheck && y+1 == yEnemyCheck && gridsArray[x-2][y+1] == gridsArray[xEnemyCheck][yEnemyCheck]) ||
						(x-2 == xEnemyCheck && y-1 == yEnemyCheck && gridsArray[x-2][y-1] == gridsArray[xEnemyCheck][yEnemyCheck]) ||
						(x-1 == xEnemyCheck && y-2 == yEnemyCheck && gridsArray[x-1][y-2] == gridsArray[xEnemyCheck][yEnemyCheck]) ||
						(x+2 == xEnemyCheck && y-1 == yEnemyCheck && gridsArray[x+2][y-1] == gridsArray[xEnemyCheck][yEnemyCheck]) ||
						(x+1 == xEnemyCheck && y-2 == yEnemyCheck && gridsArray[x+1][y-2] == gridsArray[xEnemyCheck][yEnemyCheck]) ||
						(x+2 == xEnemyCheck && y+1 == yEnemyCheck && gridsArray[x+2][y+1] == gridsArray[xEnemyCheck][yEnemyCheck])) return true;
			}else
			{
				if(kingStillChecked(gridsArray, turn, x, y, x-2, y+1) == false) return true;
				else
				{
					returnGridsToNormal(gridsArray, x, y, x-2, y+1);
				}
				
				if(kingStillChecked(gridsArray, turn, x, y, x-1, y+2) == false) return true;
				else
				{
					returnGridsToNormal(gridsArray, x, y, x-1, y+2);
				}
				if(kingStillChecked(gridsArray, turn, x, y, x-2, y-1) == false) return true;
				else
				{
					returnGridsToNormal(gridsArray, x, y, x-2, y-1);
				}
				if(kingStillChecked(gridsArray, turn, x, y, x-1, y-2) == false) return true;
				else
				{
					returnGridsToNormal(gridsArray, x, y, x-1, y-2);
				}
				if(kingStillChecked(gridsArray, turn, x, y, x+2, y-1) == false) return true;
				else
				{
					returnGridsToNormal(gridsArray, x, y, x+2, y-1);
				}
				if(kingStillChecked(gridsArray, turn, x, y, x+1, y-2) == false) return true;
				else
				{
					returnGridsToNormal(gridsArray, x, y, x+1, y-2);
				}
				if(kingStillChecked(gridsArray, turn, x, y, x+2, y+1) == false) return true;
				else
				{
					returnGridsToNormal(gridsArray, x, y, x+2, y+1);
				}
				if(kingStillChecked(gridsArray, turn, x, y, x+1, y+2) == false) return true;
				else
				{
					returnGridsToNormal(gridsArray, x, y, x+1, y+2);
				}
				
				if((x-2 == xEnemyCheck && y+1 == yEnemyCheck && gridsArray[x-2][y+1] == gridsArray[xEnemyCheck][yEnemyCheck]) ||
						(x-1 == xEnemyCheck && y+2 == yEnemyCheck && gridsArray[x-1][y+2] == gridsArray[xEnemyCheck][yEnemyCheck]) ||
						(x-2 == xEnemyCheck && y-1 == yEnemyCheck && gridsArray[x-2][y-1] == gridsArray[xEnemyCheck][yEnemyCheck]) ||
						(x-1 == xEnemyCheck && y-2 == yEnemyCheck && gridsArray[x-1][y-2] == gridsArray[xEnemyCheck][yEnemyCheck]) ||
						(x+2 == xEnemyCheck && y-1 == yEnemyCheck && gridsArray[x+2][y-1] == gridsArray[xEnemyCheck][yEnemyCheck]) ||
						(x+1 == xEnemyCheck && y-2 == yEnemyCheck && gridsArray[x+1][y-2] == gridsArray[xEnemyCheck][yEnemyCheck]) ||
						(x+2 == xEnemyCheck && y+1 == yEnemyCheck && gridsArray[x+2][y+1] == gridsArray[xEnemyCheck][yEnemyCheck]) ||
						(x+1 == xEnemyCheck && y+2 == yEnemyCheck && gridsArray[x+1][y+2] == gridsArray[xEnemyCheck][yEnemyCheck])) return true;
			}
			
			return false;
		}
}
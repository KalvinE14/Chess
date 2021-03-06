package chess_rule;

public class Checkmate {
	private int temp = 0;
	
	public void moveKing(int gridsArray[][], int x1, int y1, int x2, int y2)
	{
		gridsArray[x2][y2] = gridsArray[x1][y1];
		gridsArray[x1][y1] = 0;
	}
	 
	public int findXKing(int gridsArray[][], int turn)
	{
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if(turnWhite(turn))
				{
					if(gridsArray[i][j] == 6)
					{
						return i;
					}
				}else if(turnBlack(turn))
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
				if(turnWhite(turn))
				{
					if(gridsArray[i][j] == 6)
					{
						return j;
					}
				}else if(turnBlack(turn))
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
		if(isKingAvailableMoveChecked(gridsArray, turn) == 8)
		{
			
			
			for(int i = 0; i < 8; i++) {
				for(int j = 0; j < 8; j++) {					
					if(turnWhite(turn)) {
						if(gridsArray[i][j] == 1) {
							if(canPawnSaveKing(turn, gridsArray, i, j, xEnemyCheck, yEnemyCheck) == true) return false;
						}
						else if(gridsArray[i][j] == 2) {
							if(canRookSaveKing(turn, gridsArray, i, j, xEnemyCheck, yEnemyCheck) == true) return false;
						}
						else if(gridsArray[i][j] == 3) {
							if(canKnightSaveKing(turn, gridsArray, i, j, xEnemyCheck, yEnemyCheck) == true) return false;
						}
						else if(gridsArray[i][j] == 4) {
							if(canBishopSaveKing(turn, gridsArray, i, j, xEnemyCheck, yEnemyCheck) == true) return false;
						}
						else if(gridsArray[i][j] == 5) {
							if(canQueenSaveKing(turn, gridsArray, i, j, xEnemyCheck, yEnemyCheck) == true) return false;
						}
						else if(gridsArray[i][j] == 6) {
							if(canKingSaveHimself(turn, gridsArray, i, j, xEnemyCheck, yEnemyCheck) == true) return false;
						}
						
					}else if(turnBlack(turn))
					{
						if(gridsArray[i][j] == 7) {
							if(canPawnSaveKing(turn, gridsArray, i, j, xEnemyCheck, yEnemyCheck) == true) return false;
						}
						else if(gridsArray[i][j] == 8) {
							if(canRookSaveKing(turn, gridsArray, i, j, xEnemyCheck, yEnemyCheck) == true) return false;
						}
						else if(gridsArray[i][j] == 9) {
							if(canKnightSaveKing(turn, gridsArray, i, j, xEnemyCheck, yEnemyCheck) == true) return false;
						}
						else if(gridsArray[i][j] == 10) {
							if(canBishopSaveKing(turn, gridsArray, i, j, xEnemyCheck, yEnemyCheck) == true) return false;
						}
						else if(gridsArray[i][j] == 11) {
							if(canQueenSaveKing(turn, gridsArray, i, j, xEnemyCheck, yEnemyCheck) == true) return false;
						}
						else if(gridsArray[i][j] == 12) {
							if(canKingSaveHimself(turn, gridsArray, i, j, xEnemyCheck, yEnemyCheck) == true) return false;
						}
					}
				}
			}
			System.out.println(isKingAvailableMoveChecked(gridsArray, turn));
			return true;
		}
		
		
		return false;
	}
	
	public boolean kingStillChecked(int gridsArray[][], int turn, int x1, int y1, int x2, int y2)
	{
		temp = gridsArray[x2][y2];
		InvalidMove im = new InvalidMove();
		
		gridsArray[x2][y2] = gridsArray[x1][y1];
		gridsArray[x1][y1] = 0;
		
		return im.validateInvalidMove(gridsArray, turn);
	}
	
	public void returnGridsToNormal(int gridsArray[][], int x1, int y1, int x2, int y2)
	{	
		gridsArray[x1][y1] = gridsArray[x2][y2];
		gridsArray[x2][y2] = temp;
	}
	
	public boolean canKingSaveHimself(int turn, int gridsArray[][], int x, int y, int xEnemyCheck, int yEnemyCheck) {
		if(x-1 >= 0) {
			if(x-1 == xEnemyCheck && y == yEnemyCheck && gridsArray[x-1][y] == gridsArray[xEnemyCheck][yEnemyCheck]) {
				if(kingStillChecked(gridsArray, turn, x, y, x-1, y) == false) 
				{
					returnGridsToNormal(gridsArray, x, y, x-1, y);
					return true;
				}
				else {
					returnGridsToNormal(gridsArray, x, y, x-1, y);
					return false;
				}
			}
		}
		if(x+1 <= 7) {
			if(x+1 == xEnemyCheck && y == yEnemyCheck && gridsArray[x+1][y] == gridsArray[xEnemyCheck][yEnemyCheck]) {
				if(kingStillChecked(gridsArray, turn, x, y, x+1, y) == false)
				{
					returnGridsToNormal(gridsArray, x, y, x+1, y);
					return true;
				}
				else {
					returnGridsToNormal(gridsArray, x, y, x+1, y);
					return false;
				}
			}
		}
		if(y-1 >= 0) {
			if(x == xEnemyCheck && y-1 == yEnemyCheck && gridsArray[x][y-1] == gridsArray[xEnemyCheck][yEnemyCheck]) {
				if(kingStillChecked(gridsArray, turn, x, y, x, y-1) == false)
				{
					returnGridsToNormal(gridsArray, x, y, x, y-1);
					return true;
				}
				else {
					returnGridsToNormal(gridsArray, x, y, x, y-1);
					return false;
				}
			}
		}
		if(y+1 <= 7) {
			if(x == xEnemyCheck && y+1 == yEnemyCheck && gridsArray[x][y+1] == gridsArray[xEnemyCheck][yEnemyCheck]) {
				if(kingStillChecked(gridsArray, turn, x, y, x, y+1) == false) 
				{
					returnGridsToNormal(gridsArray, x, y, x, y+1);
					return true;
				}
				else {
					returnGridsToNormal(gridsArray, x, y, x, y+1);
					return false;
				}
			}
		}
		if(x-1 >= 0 && y+1 <= 7) {
			if(x-1 == xEnemyCheck && y+1 == yEnemyCheck && gridsArray[x-1][y+1] == gridsArray[xEnemyCheck][yEnemyCheck]) {
				if(kingStillChecked(gridsArray, turn, x, y, x-1, y+1) == false)
				{
					returnGridsToNormal(gridsArray, x, y, x-1, y+1);
					return true;
				}
				else {
					returnGridsToNormal(gridsArray, x, y, x-1, y+1);
					return false;
				}
			}
		}
		if(x-1 >= 0 && y-1 >= 0) {
			if(x-1 == xEnemyCheck && y-1 == yEnemyCheck && gridsArray[x-1][y-1] == gridsArray[xEnemyCheck][yEnemyCheck]) {
				if(kingStillChecked(gridsArray, turn, x, y, x-1, y-1) == false)
				{
					returnGridsToNormal(gridsArray, x, y, x-1, y-1);
					return true;
				}
				else {
					returnGridsToNormal(gridsArray, x, y, x-1, y-1);
					return false;
				}
			}
		}
		if(x+1 <= 7 && y-1 >= 0) {
			if(x+1 == xEnemyCheck && y-1 == yEnemyCheck && gridsArray[x+1][y-1] == gridsArray[xEnemyCheck][yEnemyCheck]) {
				if(kingStillChecked(gridsArray, turn, x, y, x+1, y-1) == false) 
				{
					returnGridsToNormal(gridsArray, x, y, x+1, y-1);
					return true;
				}
				else {
					returnGridsToNormal(gridsArray, x, y, x+1, y-1);
					return false;
				}
			}
		}
		if(x+1 <= 7 && y+1 <= 7) {
			if(x+1 == xEnemyCheck && y+1 == yEnemyCheck && gridsArray[x+1][y+1] == gridsArray[xEnemyCheck][yEnemyCheck]) {
				if(kingStillChecked(gridsArray, turn, x, y, x+1, y+1) == false) 
				{
					returnGridsToNormal(gridsArray, x, y, x+1, y+1);
					return true;
				}
				else {
					returnGridsToNormal(gridsArray, x, y, x+1, y+1);
					return false;
				}
			}
		}
		
		return false;
	}
	
	public boolean canRookSaveKing(int turn, int gridsArray[][], int x, int y, int xEnemyCheck, int yEnemyCheck) {		
		for (int i = x - 1; i >= 0 ; i--) {
			if(turnWhite(turn)) {
				if(gridsArray[i][y] >= 1 && gridsArray[i][y] <= 6) break;
				
				if(kingStillChecked(gridsArray, turn, x, y, i, y) == false) 
				{
					returnGridsToNormal(gridsArray, x, y, i, y);
					return true;
				}
				else
				{
					returnGridsToNormal(gridsArray, x, y, i, y);
				}
			}
			else if(turnBlack(turn)) {
				if(gridsArray[i][y] >= 7 && gridsArray[i][y] <= 12) break;
				
				if(kingStillChecked(gridsArray, turn, x, y, i, y) == false) 
				{
					returnGridsToNormal(gridsArray, x, y, i, y);
					return true;
				}
				else
				{
					returnGridsToNormal(gridsArray, x, y, i, y);
				}
			}
		}
		
		for (int i = x + 1; i <= 7 ; i++) {
			if(turnWhite(turn)) {
				if(gridsArray[i][y] >= 1 && gridsArray[i][y] <= 6) break;
				
				if(kingStillChecked(gridsArray, turn, x, y, i, y) == false) 
				{
					returnGridsToNormal(gridsArray, x, y, i, y);
					return true;
				}
				else
				{
					returnGridsToNormal(gridsArray, x, y, i, y);
				}
			}
			else if(turnBlack(turn)) {
				if(gridsArray[i][y] >= 7 && gridsArray[i][y] <= 12) break;
				
				if(kingStillChecked(gridsArray, turn, x, y, i, y) == false) 
				{
					returnGridsToNormal(gridsArray, x, y, i, y);
					return true;
				}
				else
				{
					returnGridsToNormal(gridsArray, x, y, i, y);
				}
			}
		}
		
		for (int i = y + 1; i <= 7 ; i++) {
			if(turnWhite(turn)) {
				if(gridsArray[x][i] >= 1 && gridsArray[x][i] <= 6) break;
				
				if(kingStillChecked(gridsArray, turn, x, y, x, i) == false)
				{
					returnGridsToNormal(gridsArray, x, y, x, i);
					return true;
				}
				else
				{
					returnGridsToNormal(gridsArray, x, y, x, i);
				}
			}
			else if(turnBlack(turn)) {
				if(gridsArray[x][i] >= 7 && gridsArray[x][i] <= 12) break;
				
				if(kingStillChecked(gridsArray, turn, x, y, x, i) == false) 
				{
					returnGridsToNormal(gridsArray, x, y, x, i);
					return true;
				}
				else
				{
					returnGridsToNormal(gridsArray, x, y, x, i);
				}
			}
		}
		
		for (int i = y - 1; i >= 0 ; i--) {
			if(turnWhite(turn)) {
				if(gridsArray[x][i] >= 1 && gridsArray[x][i] <= 6) break;
				
				if(kingStillChecked(gridsArray, turn, x, y, x, i) == false) 
				{
					returnGridsToNormal(gridsArray, x, y, x, i);
					return true;
				}
				else
				{
					returnGridsToNormal(gridsArray, x, y, x, i);
				}
			}
			else if(turnBlack(turn)) {
				if(gridsArray[x][i] >= 7 && gridsArray[x][i] <= 12) break;
				
				if(kingStillChecked(gridsArray, turn, x, y, x, i) == false) 
				{
					returnGridsToNormal(gridsArray, x, y, x, i);
					return true;
				}
				else
				{
					returnGridsToNormal(gridsArray, x, y, x, i);
				}
			}
		}
		return false;
	}

	public boolean canBishopSaveKing(int turn, int gridsArray[][], int x, int y, int xEnemyCheck, int yEnemyCheck) {
		for(int i = x-1, j = y+1; i >= 0; i--, j++) {
			if(j <= 7 && i >= 0) {
				if(turnWhite(turn))
				{
					if(gridsArray[i][j] >= 1 && gridsArray[i][j] <= 6) break;
					
					if(kingStillChecked(gridsArray, turn, x, y, i, j) == false) 
					{
						returnGridsToNormal(gridsArray, x, y, i, j);
						return true;
					}
					else
					{
						returnGridsToNormal(gridsArray, x, y, i, j);
					}
					
					if(i == 0 || j == 7) break;
				}else if(turnBlack(turn))
				{
					if(gridsArray[i][j] >= 7 && gridsArray[i][j] <= 12) break;
					
					if(kingStillChecked(gridsArray, turn, x, y, i, j) == false) 
					{
						returnGridsToNormal(gridsArray, x, y, i, j);
						return true;
					}
					else
					{
						returnGridsToNormal(gridsArray, x, y, i, j);
					}
					
					if(i == 0 || j == 7) break;
				}
				
			}		
		}
		
		for(int i = x-1, j = y-1; i >= 0; i--, j--) {
			if(j >= 0 && i >= 0) {
				if(turnWhite(turn))
				{
					if(gridsArray[i][j] >= 1 && gridsArray[i][j] <= 6) break;
					
					if(kingStillChecked(gridsArray, turn, x, y, i, j) == false) 
					{
						returnGridsToNormal(gridsArray, x, y, i, j);
						return true;
					}
					else
					{
						returnGridsToNormal(gridsArray, x, y, i, j);
					}
					
					if(i == 0 || j == 0) break;
				}else if(turnBlack(turn))
				{
					if(gridsArray[i][j] >= 7 && gridsArray[i][j] <= 12) break;
					
					if(kingStillChecked(gridsArray, turn, x, y, i, j) == false) 
					{
						returnGridsToNormal(gridsArray, x, y, i, j);
						return true;
					}
					else
					{
						returnGridsToNormal(gridsArray, x, y, i, j);
					}
					
					if(i == 0 || j == 0) break;
				}
				
			}		
		}
		
		for(int i = x+1, j = y-1; i <= 7; i++, j--) {
			if(j >= 0 && i <= 7) {
				if(turnWhite(turn))
				{
					if(gridsArray[i][j] >= 1 && gridsArray[i][j] <= 6) break;
					
					if(kingStillChecked(gridsArray, turn, x, y, i, j) == false) 
					{
						returnGridsToNormal(gridsArray, x, y, i, j);
						return true;
					}
					else
					{
						returnGridsToNormal(gridsArray, x, y, i, j);
					}
					
					if(i == 7 || j == 0) break;
				}else if(turnBlack(turn))
				{
					if(gridsArray[i][j] >= 7 && gridsArray[i][j] <= 12) break;
					
					if(kingStillChecked(gridsArray, turn, x, y, i, j) == false) 
					{
						returnGridsToNormal(gridsArray, x, y, i, j);
						return true;
					}
					else
					{
						returnGridsToNormal(gridsArray, x, y, i, j);
					}
					
					if(i == 7 || j == 0) break;
				}
				
			}			
		}
		
		for(int i = x+1, j = y+1; i <= 7; i++, j++) {
			if(i <= 7 && j <= 7) {
				if(turnWhite(turn))
				{
					if(gridsArray[i][j] >= 1 && gridsArray[i][j] <= 6) break;
					
					if(kingStillChecked(gridsArray, turn, x, y, i, j) == false) 
					{
						returnGridsToNormal(gridsArray, x, y, i, j);
						return true;
					}
					else
					{
						returnGridsToNormal(gridsArray, x, y, i, j);
					}
					
					if(i == 7 || j == 7) break;
				}else if(turnBlack(turn))
				{
					if(gridsArray[i][j] >= 7 && gridsArray[i][j] <= 12) break;
					
					if(kingStillChecked(gridsArray, turn, x, y, i, j) == false) 
					{
						returnGridsToNormal(gridsArray, x, y, i, j);
						return true;
					}
					else
					{
						returnGridsToNormal(gridsArray, x, y, i, j);
					}
					
					if(i == 7 || j == 7) break;
				}
				
			}	
		}
		return false;
	}

	private boolean turnBlack(int turn) {
		return turn == -1;
	}

	private boolean turnWhite(int turn) {
		return turn == 1;
	}
	
	public boolean canQueenSaveKing(int turn, int gridsArray[][], int x, int y, int xEnemyCheck, int yEnemyCheck) {
		if(turnWhite(turn)) {
			if(canRookSaveKing(turn, gridsArray, x, y, xEnemyCheck, yEnemyCheck) == true) return true;
			if(canBishopSaveKing(turn, gridsArray, x, y, xEnemyCheck, yEnemyCheck) == true) return true;
		}
		else if(turnBlack(turn)) {
			if(canRookSaveKing(turn, gridsArray, x, y, xEnemyCheck, yEnemyCheck) == true) return true;
			if(canBishopSaveKing(turn, gridsArray, x, y, xEnemyCheck, yEnemyCheck) == true) return true;
		}
		return false;
	}
	
	public boolean canPawnSaveKing(int turn, int gridsArray[][], int x, int y, int xEnemyCheck, int yEnemyCheck) {
		if(turnWhite(turn)) {
			if(x-1 >= 0 && y-1 >= 0) {
				if(gridsArray[x-1][y-1] >= 7 && gridsArray[x-1][y-1] <= 12)
				{
					if(x-1 == xEnemyCheck && y-1 == yEnemyCheck && gridsArray[x-1][y-1] == gridsArray[xEnemyCheck][yEnemyCheck]) return true;
				}
			}
			if(x-1 >= 0 && y+1 <= 7) {
				if(gridsArray[x-1][y+1] >= 7 && gridsArray[x-1][y+1] <= 12)
				{
					if(x-1 == xEnemyCheck && y+1 == yEnemyCheck && gridsArray[x-1][y+1] == gridsArray[xEnemyCheck][yEnemyCheck]) return true;
				}
			}
			if(x-1 >= 0 )
			{
				if(gridsArray[x-1][y] == 0)
				{
					if(kingStillChecked(gridsArray, turn, x, y, x-1, y) == false) 
					{
						returnGridsToNormal(gridsArray, x, y, x-1, y);
						return true;
					}
					else
					{
						returnGridsToNormal(gridsArray, x, y, x-1, y);
					}
				}
				if(x == 6) {
					if(gridsArray[x-2][y] == 0)
					{
						if(kingStillChecked(gridsArray, turn, x, y, x-2, y) == false) 
						{
							returnGridsToNormal(gridsArray, x, y, x-2, y);
							return true;
						}
						else
						{
							returnGridsToNormal(gridsArray, x, y, x-2, y);
						}
					}
				}
			}
		}
		else if(turnBlack(turn)) {
			if(x+1 <= 7 && y+1 <= 7) {
				if(gridsArray[x+1][y+1] >= 1 && gridsArray[x+1][y+1] <= 6)
				{
					if(x+1 == xEnemyCheck && y+1 == yEnemyCheck && gridsArray[x+1][y+1] == gridsArray[xEnemyCheck][yEnemyCheck]) return true;
				}
			}
			if(x+1 <= 7 && y-1 >= 0) {
				if(gridsArray[x+1][y-1] >= 1 && gridsArray[x+1][y-1] <= 6)
				{
					if(x+1 == xEnemyCheck && y-1 == yEnemyCheck && gridsArray[x+1][y-1] == gridsArray[xEnemyCheck][yEnemyCheck]) return true;
				}
			}
			if(x+1 <= 7)
			{
				if(gridsArray[x+1][y] == 0)
				{
					if(kingStillChecked(gridsArray, turn, x, y, x+1, y) == false) 
					{
						returnGridsToNormal(gridsArray, x, y, x+1, y);
						return true;
					}
					else
					{
						returnGridsToNormal(gridsArray, x, y, x+1, y);
					}
				}
				if(turnWhite(x)) {
					if(gridsArray[x+2][y] == 0) {
						if(kingStillChecked(gridsArray, turn, x, y, x+2, y) == false) 
						{
							returnGridsToNormal(gridsArray, x, y, x+2, y);
							return true;
						}
						else
						{
							returnGridsToNormal(gridsArray, x, y, x+2, y);
						}
					}
				}
			}
			
		}
		return false;
	}
	
	public boolean canKnightSaveKing(int turn, int gridsArray[][], int x, int y, int xEnemyCheck, int yEnemyCheck) {
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
					
					if(gridsArray[tempX][tempY] >= 1 && gridsArray[tempX][tempY] <= 6) continue;
					
					if(kingStillChecked(gridsArray, turn, x, y, tempX, tempY) == false) 
					{
						returnGridsToNormal(gridsArray, x, y, tempX, tempY);
						return true;
					}
					else
					{
						returnGridsToNormal(gridsArray, x, y, tempX, tempY);
					}
				}else if(spin == 2)
				{
					tempX = x-2;
					tempY = y-1;
					if(tempX < 0 || tempY < 0) continue;
					
					if(gridsArray[tempX][tempY] >= 1 && gridsArray[tempX][tempY] <= 6) continue;
					
					if(kingStillChecked(gridsArray, turn, x, y, tempX, tempY) == false) 
					{
						returnGridsToNormal(gridsArray, x, y, tempX, tempY);
						return true;
					}
					else
					{
						returnGridsToNormal(gridsArray, x, y, tempX, tempY);
					}
				}else if(spin == 3)
				{
					tempX = x-1;
					tempY = y+2;
					if(tempX < 0 || tempY > 7) continue;
					
					if(gridsArray[tempX][tempY] >= 1 && gridsArray[tempX][tempY] <= 6) continue;
					
					if(kingStillChecked(gridsArray, turn, x, y, tempX, tempY) == false) 
					{
						returnGridsToNormal(gridsArray, x, y, tempX, tempY);
						return true;
					}
					else
					{
						returnGridsToNormal(gridsArray, x, y, tempX, tempY);
					}
				}else if(spin == 4)
				{
					tempX = x-2;
					tempY = y+1;
					if(tempX < 0 || tempY > 7) continue;
					
					if(gridsArray[tempX][tempY] >= 1 && gridsArray[tempX][tempY] <= 6) continue;
					
					if(kingStillChecked(gridsArray, turn, x, y, tempX, tempY) == false) 
					{
						returnGridsToNormal(gridsArray, x, y, tempX, tempY);
						return true;
					}
					else
					{
						returnGridsToNormal(gridsArray, x, y, tempX, tempY);
					}
				}else if(spin == 5)
				{
					tempX = x+1;
					tempY = y+2;
					if(tempX > 7 || tempY > 7) continue;
					
					if(gridsArray[tempX][tempY] >= 1 && gridsArray[tempX][tempY] <= 6) continue;
					
					if(kingStillChecked(gridsArray, turn, x, y, tempX, tempY) == false) 
					{
						returnGridsToNormal(gridsArray, x, y, tempX, tempY);
						return true;
					}
					else
					{
						returnGridsToNormal(gridsArray, x, y, tempX, tempY);
					}
				}else if(spin == 6)
				{
					tempX = x+2;
					tempY = y+1;
					if(tempX > 7 || tempY > 7) continue;
					
					if(gridsArray[tempX][tempY] >= 1 && gridsArray[tempX][tempY] <= 6) continue;
					
					if(kingStillChecked(gridsArray, turn, x, y, tempX, tempY) == false) 
					{
						returnGridsToNormal(gridsArray, x, y, tempX, tempY);
						return true;
					}
					else
					{
						returnGridsToNormal(gridsArray, x, y, tempX, tempY);
					}
				}else if(spin == 7)
				{
					tempX = x+1;
					tempY = y-2;
					if(tempX > 7 || tempY < 0) continue;
					
					if(gridsArray[tempX][tempY] >= 1 && gridsArray[tempX][tempY] <= 6) continue;
					
					if(kingStillChecked(gridsArray, turn, x, y, tempX, tempY) == false) 
					{
						returnGridsToNormal(gridsArray, x, y, tempX, tempY);
						return true;
					}
					else
					{
						returnGridsToNormal(gridsArray, x, y, tempX, tempY);
					}
				}else if(spin == 8)
				{
					tempX = x+2;
					tempY = y-1;
					if(tempX > 7 || tempY < 0) continue;
					
					if(gridsArray[tempX][tempY] >= 1 && gridsArray[tempX][tempY] <= 6) continue;
					
					if(kingStillChecked(gridsArray, turn, x, y, tempX, tempY) == false) 
					{
						returnGridsToNormal(gridsArray, x, y, tempX, tempY);
						return true;
					}
					else
					{
						returnGridsToNormal(gridsArray, x, y, tempX, tempY);
					}
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
					
					if(gridsArray[tempX][tempY] >= 7 && gridsArray[tempX][tempY] <= 12) continue;
					
					if(kingStillChecked(gridsArray, turn, x, y, tempX, tempY) == false) 
					{
						returnGridsToNormal(gridsArray, x, y, tempX, tempY);
						return true;
					}
					else
					{
						returnGridsToNormal(gridsArray, x, y, tempX, tempY);
					}
				}else if(spin == 2)
				{
					tempX = x-2;
					tempY = y-1;
					if(tempX < 0 || tempY < 0) continue;
					
					if(gridsArray[tempX][tempY] >= 7 && gridsArray[tempX][tempY] <= 12) continue;
					
					if(kingStillChecked(gridsArray, turn, x, y, tempX, tempY) == false) 
					{
						returnGridsToNormal(gridsArray, x, y, tempX, tempY);
						return true;
					}
					else
					{
						returnGridsToNormal(gridsArray, x, y, tempX, tempY);
					}
				}else if(spin == 3)
				{
					tempX = x-1;
					tempY = y+2;
					if(tempX < 0 || tempY > 7) continue;
					
					if(gridsArray[tempX][tempY] >= 7 && gridsArray[tempX][tempY] <= 12) continue;
					
					if(kingStillChecked(gridsArray, turn, x, y, tempX, tempY) == false) 
					{
						returnGridsToNormal(gridsArray, x, y, tempX, tempY);
						return true;
					}
					else
					{
						returnGridsToNormal(gridsArray, x, y, tempX, tempY);
					}
				}else if(spin == 4)
				{
					tempX = x-2;
					tempY = y+1;
					if(tempX < 0 || tempY > 7) continue;
					
					if(gridsArray[tempX][tempY] >= 7 && gridsArray[tempX][tempY] <= 12) continue;
					
					if(kingStillChecked(gridsArray, turn, x, y, tempX, tempY) == false) 
					{
						returnGridsToNormal(gridsArray, x, y, tempX, tempY);
						return true;
					}
					else
					{
						returnGridsToNormal(gridsArray, x, y, tempX, tempY);
					}
				}else if(spin == 5)
				{
					tempX = x+1;
					tempY = y+2;
					if(tempX > 7 || tempY > 7) continue;
					
					if(gridsArray[tempX][tempY] >= 7 && gridsArray[tempX][tempY] <= 12) continue;
					
					if(kingStillChecked(gridsArray, turn, x, y, tempX, tempY) == false) 
					{
						returnGridsToNormal(gridsArray, x, y, tempX, tempY);
						return true;
					}
					else
					{
						returnGridsToNormal(gridsArray, x, y, tempX, tempY);
					}
				}else if(spin == 6)
				{
					tempX = x+2;
					tempY = y+1;
					if(tempX > 7 || tempY > 7) continue;
					
					if(gridsArray[tempX][tempY] >= 7 && gridsArray[tempX][tempY] <= 12) continue;
					
					if(kingStillChecked(gridsArray, turn, x, y, tempX, tempY) == false) 
					{
						returnGridsToNormal(gridsArray, x, y, tempX, tempY);
						return true;
					}
					else
					{
						returnGridsToNormal(gridsArray, x, y, tempX, tempY);
					}
				}else if(spin == 7)
				{
					tempX = x+1;
					tempY = y-2;
					if(tempX > 7 || tempY < 0) continue;
					
					if(gridsArray[tempX][tempY] >= 7 && gridsArray[tempX][tempY] <= 12) continue;
					
					if(kingStillChecked(gridsArray, turn, x, y, tempX, tempY) == false) 
					{
						returnGridsToNormal(gridsArray, x, y, tempX, tempY);
						return true;
					}
					else
					{
						returnGridsToNormal(gridsArray, x, y, tempX, tempY);
					}
				}else if(spin == 8)
				{
					tempX = x+2;
					tempY = y-1;
					if(tempX > 7 || tempY < 0) continue;
					
					if(gridsArray[tempX][tempY] >= 7 && gridsArray[tempX][tempY] <= 12) continue;
					
					if(kingStillChecked(gridsArray, turn, x, y, tempX, tempY) == false) 
					{
						returnGridsToNormal(gridsArray, x, y, tempX, tempY);
						return true;
					}
					else
					{
						returnGridsToNormal(gridsArray, x, y, tempX, tempY);
					}
				}
				
			}while(spin <= 8);
			return false;
		}
		
		return false;
		
	}
}

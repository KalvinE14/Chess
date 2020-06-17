package chess_rule;

import chess_piece.Bishop;
import chess_piece.Knight;
import chess_piece.Pawn;
import chess_piece.Rook;

public class Stalemate {
	
	public void moveKing(int gridsArray[][], int x1, int y1, int x2, int y2) {
		gridsArray[x2][y2] = gridsArray[x1][y1];
		gridsArray[x1][y1] = 0;
	}
	
	public int findXKing(int gridsArray[][], int turn) {
		for (int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if(turnWhite(turn)) {
					if(gridsArray[i][j] == 6) {
						return i;
					}
				}
				else if(turnBlack(turn)) {
					if(gridsArray[i][j] == 12) {
						return i;
					}
				}
			}
		}
		return -1;
	}

	private boolean turnBlack(int turn) {
		return turn == -1;
	}

	private boolean turnWhite(int turn) {
		return turn == 1;
	}
	
	public int findYKing(int gridsArray[][], int turn) {
		for (int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if(turnWhite(turn)) {
					if(gridsArray[i][j] == 6) {
						return j;
					}
				}
				else if(turnBlack(turn)) {
					if(gridsArray[i][j] == 12) {
						return j;
					}
				}
			}
		}
		return -1;
	}
	
	public boolean stalemate(int gridsArray[][], int turn) {
		int xKing = findXKing(gridsArray, turn);
		int yKing = findYKing(gridsArray, turn);
		int checkCounter = 0;
		InvalidMove invalidMove = new InvalidMove();	
		
		if(invalidMove.validateInvalidMove(gridsArray, turn) == true) return false;
		
		if(xKing-1 >= 0) {
			if(gridsArray[xKing-1][yKing] == 0) {
				moveKing(gridsArray, xKing, yKing, xKing-1, yKing);
				if(invalidMove.validateInvalidMove(gridsArray, turn) == true) {
					checkCounter++;
				}
				moveKing(gridsArray, xKing-1, yKing, xKing, yKing);
			}
			else {
				if(turnWhite(turn)) {
					if(gridsArray[xKing-1][yKing] == 7 || gridsArray[xKing-1][yKing] == 8 || gridsArray[xKing-1][yKing] == 9 || gridsArray[xKing-1][yKing] == 10 || gridsArray[xKing-1][yKing] == 11 || gridsArray[xKing-1][yKing] == 12) {
						int temp = gridsArray[xKing-1][yKing];
						moveKing(gridsArray, xKing, yKing, xKing-1, yKing);
						if(invalidMove.validateInvalidMove(gridsArray, turn) == true) {
							checkCounter++;
						}
						moveKing(gridsArray, xKing-1, yKing, xKing, yKing);
						gridsArray[xKing-1][yKing] = temp;
					}
					else {
						checkCounter++;
					}
				}
				else if(turnBlack(turn)) {
					if(gridsArray[xKing-1][yKing] == 1 || gridsArray[xKing-1][yKing] == 2 || gridsArray[xKing-1][yKing] == 3 || gridsArray[xKing-1][yKing] == 4 || gridsArray[xKing-1][yKing] == 5 || gridsArray[xKing-1][yKing] == 6) {
						int temp = gridsArray[xKing-1][yKing]; 
						moveKing(gridsArray, xKing, yKing, xKing-1, yKing);
						if(invalidMove.validateInvalidMove(gridsArray, turn) == true) {
							checkCounter++;
						}
						moveKing(gridsArray, xKing-1, yKing, xKing, yKing);
						gridsArray[xKing-1][yKing] = temp;
					}
					else {
						checkCounter++;
					}
				}
			}
		}
		else {
			checkCounter++;
		}
		
		if(xKing+1 <= 7) {
			if(gridsArray[xKing+1][yKing] == 0) {
				moveKing(gridsArray, xKing, yKing, xKing+1, yKing);
				if(invalidMove.validateInvalidMove(gridsArray, turn) == true) {
					checkCounter++;
				}
				moveKing(gridsArray, xKing+1, yKing, xKing, yKing);
			}
			else {
				if(turnWhite(turn)) {
					if(gridsArray[xKing+1][yKing] == 7 || gridsArray[xKing+1][yKing] == 8 || gridsArray[xKing+1][yKing] == 9 || gridsArray[xKing+1][yKing] == 10 || gridsArray[xKing+1][yKing] == 11 || gridsArray[xKing+1][yKing] == 12) {
						int temp = gridsArray[xKing+1][yKing];
						moveKing(gridsArray, xKing, yKing, xKing+1, yKing);
						if(invalidMove.validateInvalidMove(gridsArray, turn) == true) {
							checkCounter++;
						}
						moveKing(gridsArray, xKing+1, yKing, xKing, yKing);
						gridsArray[xKing+1][yKing] = temp;
					}
					else {
						checkCounter++;
					}
				}
				else if(turnBlack(turn)) {
					if(gridsArray[xKing+1][yKing] == 1 || gridsArray[xKing+1][yKing] == 2 || gridsArray[xKing+1][yKing] == 3 || gridsArray[xKing+1][yKing] == 4 || gridsArray[xKing+1][yKing] == 5 || gridsArray[xKing+1][yKing] == 6) {
						int temp = gridsArray[xKing+1][yKing];
						moveKing(gridsArray, xKing, yKing, xKing+1, yKing);
						if(invalidMove.validateInvalidMove(gridsArray, turn) == true) {
							checkCounter++;
						}
						moveKing(gridsArray, xKing+1, yKing, xKing, yKing);
						gridsArray[xKing+1][yKing] = temp;
					}
					else {
						checkCounter++;
					}
				}
			}			
		}
		else {
			checkCounter++;
		}
		
		if(yKing-1 >= 0) {
			if(gridsArray[xKing][yKing-1] == 0) {
				moveKing(gridsArray, xKing, yKing, xKing, yKing-1);
				if(invalidMove.validateInvalidMove(gridsArray, turn) == true) checkCounter++;
				moveKing(gridsArray, xKing, yKing-1, xKing, yKing);
			}
			else {
				if(turnWhite(turn)) {
					if(gridsArray[xKing][yKing-1] == 7 || gridsArray[xKing][yKing-1] == 8 || gridsArray[xKing][yKing-1] == 9 || gridsArray[xKing][yKing-1] == 10 || gridsArray[xKing][yKing-1] == 11 || gridsArray[xKing][yKing-1] == 12) {
						int temp = gridsArray[xKing][yKing-1];
						moveKing(gridsArray, xKing, yKing, xKing, yKing-1);
						if(invalidMove.validateInvalidMove(gridsArray, turn) == true) {
							checkCounter++;
						}
						moveKing(gridsArray, xKing, yKing-1, xKing, yKing);
						gridsArray[xKing][yKing-1] = temp;
					}
					else {
						checkCounter++;
					}
				}
				else if(turnBlack(turn)) {
					if(gridsArray[xKing][yKing-1] == 1 || gridsArray[xKing][yKing-1] == 2 || gridsArray[xKing][yKing-1] == 3 || gridsArray[xKing][yKing-1] == 4 || gridsArray[xKing][yKing-1] == 5 || gridsArray[xKing][yKing-1] == 6) {
						int temp = gridsArray[xKing][yKing-1];
						moveKing(gridsArray, xKing, yKing, xKing, yKing-1);
						if(invalidMove.validateInvalidMove(gridsArray, turn) == true) {
							checkCounter++;
						}
						moveKing(gridsArray, xKing, yKing-1, xKing, yKing);
						gridsArray[xKing][yKing-1] = temp;
					}
					else {
						checkCounter++;
					}
				}
			}	
		}
		else {
			checkCounter++;
		}
		
		if(yKing+1 <= 7) {
			if(gridsArray[xKing][yKing+1] == 0) {
				moveKing(gridsArray, xKing, yKing, xKing, yKing+1);
				if(invalidMove.validateInvalidMove(gridsArray, turn) == true) {
					checkCounter++;
				}
				moveKing(gridsArray, xKing, yKing+1, xKing, yKing);
			}
			else {
				if(turnWhite(turn)) {
					if(gridsArray[xKing][yKing+1] == 7 || gridsArray[xKing][yKing+1] == 8 || gridsArray[xKing][yKing+1] == 9 || gridsArray[xKing][yKing+1] == 10 || gridsArray[xKing][yKing+1] == 11 || gridsArray[xKing][yKing+1] == 12) {
						int temp = gridsArray[xKing][yKing+1];
						moveKing(gridsArray, xKing, yKing, xKing, yKing+1);
						if(invalidMove.validateInvalidMove(gridsArray, turn) == true) {
							checkCounter++;
						}
						moveKing(gridsArray, xKing, yKing+1, xKing, yKing);
						gridsArray[xKing][yKing+1] = temp;
					}
					else {
						checkCounter++;
					}
				}
				else if(turnBlack(turn)) {
					if(gridsArray[xKing][yKing+1] == 1 || gridsArray[xKing][yKing+1] == 2 || gridsArray[xKing][yKing+1] == 3 || gridsArray[xKing][yKing+1] == 4 || gridsArray[xKing][yKing+1] == 5 || gridsArray[xKing][yKing+1] == 6) {
						int temp = gridsArray[xKing][yKing+1];
						moveKing(gridsArray, xKing, yKing, xKing, yKing+1);
						if(invalidMove.validateInvalidMove(gridsArray, turn) == true) {
							checkCounter++;
						}
						moveKing(gridsArray, xKing, yKing+1, xKing, yKing);
						gridsArray[xKing][yKing+1] = temp;
					}
					else {
						checkCounter++;
					}
				}
			}	
		}
		else {
			checkCounter++;
		}
		
		if(xKing-1 >= 0 && yKing+1 <= 7) {
			if(gridsArray[xKing-1][yKing+1] == 0) {
				moveKing(gridsArray, xKing, yKing, xKing-1, yKing+1);
				if(invalidMove.validateInvalidMove(gridsArray, turn) == true) checkCounter++;
				moveKing(gridsArray, xKing-1, yKing+1, xKing, yKing);
			}
			else {
				if(turnWhite(turn)) {
					if(gridsArray[xKing-1][yKing+1] == 7 || gridsArray[xKing-1][yKing+1] == 8 || gridsArray[xKing-1][yKing+1] == 9 || gridsArray[xKing-1][yKing+1] == 10 || gridsArray[xKing-1][yKing+1] == 11 || gridsArray[xKing-1][yKing+1] == 12) {
						int temp = gridsArray[xKing-1][yKing+1];
						moveKing(gridsArray, xKing, yKing, xKing-1, yKing+1);
						if(invalidMove.validateInvalidMove(gridsArray, turn) == true) {
							checkCounter++;
						}
						moveKing(gridsArray, xKing-1, yKing+1, xKing, yKing);
						gridsArray[xKing-1][yKing+1] = temp;
					}
					else {
						checkCounter++;
					}
				}
				else if(turnBlack(turn)) {
					if(gridsArray[xKing-1][yKing+1] == 1 || gridsArray[xKing-1][yKing+1] == 2 || gridsArray[xKing-1][yKing+1] == 3 || gridsArray[xKing-1][yKing+1] == 4 || gridsArray[xKing-1][yKing+1] == 5 || gridsArray[xKing-1][yKing+1] == 6) {
						int temp = gridsArray[xKing-1][yKing+1];
						moveKing(gridsArray, xKing, yKing, xKing-1, yKing+1);
						if(invalidMove.validateInvalidMove(gridsArray, turn) == true) {
							checkCounter++;
						}
						moveKing(gridsArray, xKing-1, yKing+1, xKing, yKing);
						gridsArray[xKing-1][yKing+1] = temp;
					}
					else {
						checkCounter++;
					}
				}
			}
		}
		else {
			checkCounter++;
		}
		
		if(xKing-1 >= 0 && yKing-1 >= 0) {
			if(gridsArray[xKing-1][yKing-1] == 0) {
				moveKing(gridsArray, xKing, yKing, xKing-1, yKing-1);
				if(invalidMove.validateInvalidMove(gridsArray, turn) == true) checkCounter++;
				moveKing(gridsArray, xKing-1, yKing-1, xKing, yKing);
			}
			else {
				if(turnWhite(turn)) {
					if(gridsArray[xKing-1][yKing-1] == 7 || gridsArray[xKing-1][yKing-1] == 8 || gridsArray[xKing-1][yKing-1] == 9 || gridsArray[xKing-1][yKing-1] == 10 || gridsArray[xKing-1][yKing-1] == 11 || gridsArray[xKing-1][yKing-1] == 12) {
						int temp = gridsArray[xKing-1][yKing-1];
						moveKing(gridsArray, xKing, yKing, xKing-1, yKing-1);
						if(invalidMove.validateInvalidMove(gridsArray, turn) == true) {
							checkCounter++;
						}
						moveKing(gridsArray, xKing-1, yKing-1, xKing, yKing);
						gridsArray[xKing-1][yKing-1] = temp;
					}
					else {
						checkCounter++;
					}
				}
				else if(turnBlack(turn)) {
					if(gridsArray[xKing-1][yKing-1] == 1 || gridsArray[xKing-1][yKing-1] == 2 || gridsArray[xKing-1][yKing-1] == 3 || gridsArray[xKing-1][yKing-1] == 4 || gridsArray[xKing-1][yKing-1] == 5 || gridsArray[xKing-1][yKing-1] == 6) {
						int temp = gridsArray[xKing-1][yKing-1];
						moveKing(gridsArray, xKing, yKing, xKing-1, yKing-1);
						if(invalidMove.validateInvalidMove(gridsArray, turn) == true) {
							checkCounter++;
						}
						moveKing(gridsArray, xKing-1, yKing-1, xKing, yKing);
						gridsArray[xKing-1][yKing-1] = temp;
					}
					else {
						checkCounter++;
					}
				}
			}
		}
		else {
			checkCounter++;
		}
		
		if(xKing+1 <= 7 && yKing-1 >= 0) {
			if(gridsArray[xKing+1][yKing-1] == 0) {
				moveKing(gridsArray, xKing, yKing, xKing+1, yKing-1);
				if(invalidMove.validateInvalidMove(gridsArray, turn) == true) checkCounter++;
				moveKing(gridsArray, xKing+1, yKing-1, xKing, yKing);
			}
			else {
				if(turnWhite(turn)) {
					if(gridsArray[xKing+1][yKing-1] == 7 || gridsArray[xKing+1][yKing-1] == 8 || gridsArray[xKing+1][yKing-1] == 9 || gridsArray[xKing+1][yKing-1] == 10 || gridsArray[xKing+1][yKing-1] == 11 || gridsArray[xKing+1][yKing-1] == 12) {
						int temp = gridsArray[xKing+1][yKing-1];
						moveKing(gridsArray, xKing, yKing, xKing+1, yKing-1);
						if(invalidMove.validateInvalidMove(gridsArray, turn) == true) {
							checkCounter++;
						}
						moveKing(gridsArray, xKing+1, yKing-1, xKing, yKing);
						gridsArray[xKing+1][yKing-1] = temp;
					}
					else {
						checkCounter++;
					}
				}
				else if(turnBlack(turn)) {
					if(gridsArray[xKing+1][yKing-1] == 1 || gridsArray[xKing+1][yKing-1] == 2 || gridsArray[xKing+1][yKing-1] == 3 || gridsArray[xKing+1][yKing-1] == 4 || gridsArray[xKing+1][yKing-1] == 5 || gridsArray[xKing+1][yKing-1] == 6) {
						int temp = gridsArray[xKing+1][yKing-1];
						moveKing(gridsArray, xKing, yKing, xKing+1, yKing-1);
						if(invalidMove.validateInvalidMove(gridsArray, turn) == true) {
							checkCounter++;
						}
						moveKing(gridsArray, xKing+1, yKing-1, xKing, yKing);
						gridsArray[xKing+1][yKing-1] = temp;
					}
					else {
						checkCounter++;
					}
				}
			}	
		}
		else {
			checkCounter++;
		}
		
		if(xKing+1 <= 7 && yKing+1 <= 7) {
			if(gridsArray[xKing+1][yKing+1] == 0) {
				moveKing(gridsArray, xKing, yKing, xKing+1, yKing+1);
				if(invalidMove.validateInvalidMove(gridsArray, turn) == true) {
					checkCounter++;
				}
				moveKing(gridsArray, xKing+1, yKing+1, xKing, yKing);
			}
			else {
				if(turnWhite(turn)) {
					if(gridsArray[xKing+1][yKing+1] == 7 || gridsArray[xKing+1][yKing+1] == 8 || gridsArray[xKing+1][yKing+1] == 9 || gridsArray[xKing+1][yKing+1] == 10 || gridsArray[xKing+1][yKing+1] == 11 || gridsArray[xKing+1][yKing+1] == 12) {
						int temp = gridsArray[xKing+1][yKing+1];
						moveKing(gridsArray, xKing, yKing, xKing+1, yKing+1);
						if(invalidMove.validateInvalidMove(gridsArray, turn) == true) {
							checkCounter++;
						}
						moveKing(gridsArray, xKing+1, yKing+1, xKing, yKing);
						gridsArray[xKing+1][yKing+1] = temp;
					}
					else {
						checkCounter++;
					}
				}
				else if(turnBlack(turn)) {
					if(gridsArray[xKing+1][yKing+1] == 1 || gridsArray[xKing+1][yKing+1] == 2 || gridsArray[xKing+1][yKing+1] == 3 || gridsArray[xKing+1][yKing+1] == 4 || gridsArray[xKing+1][yKing+1] == 5 || gridsArray[xKing+1][yKing+1] == 6) {
						int temp = gridsArray[xKing+1][yKing+1];
						moveKing(gridsArray, xKing, yKing, xKing+1, yKing+1);
						if(invalidMove.validateInvalidMove(gridsArray, turn) == true) {
							checkCounter++;
						}
						moveKing(gridsArray, xKing+1, yKing+1, xKing, yKing);
						gridsArray[xKing+1][yKing+1] = temp;
					}
					else {
						checkCounter++;
					}
				}
			}	
		}
		else {
			checkCounter++;
		}
		
		System.out.println(checkCounter);
		if(checkCounter == 8) {
			for(int i = 0; i < 8; i++) {
				for(int j = 0; j < 8; j++) {
					
					if(turnWhite(turn)) {
						if(gridsArray[i][j] == 2) {
							if(validateRookMovement(gridsArray, turn, i, j) == false) return false;
						}
						
						else if(gridsArray[i][j] == 4) {
							if(validateBishopMovement(gridsArray, turn, i, j) == false) return false;
						}
						
						else if(gridsArray[i][j] == 5) { 
							if(validateRookMovement(gridsArray, turn, i, j) == false) return false;
							if(validateBishopMovement(gridsArray, turn, i, j) == false) return false;
						}
						
						else if(gridsArray[i][j] == 3) {
							if(validateKnightMovement(gridsArray, turn, i, j) == false) return false;
						}
						
						else if(gridsArray[i][j] == 1) {
							if(validateWhitePawnMovement(gridsArray, turn, i, j) == false) return false;
						}
					}
					
					else if(turnBlack(turn)) {
						if(gridsArray[i][j] == 8) {
							if(validateRookMovement(gridsArray, turn, i, j) == false) return false;
						}
						
						else if(gridsArray[i][j] == 10) {
							if(validateBishopMovement(gridsArray, turn, i, j) == false) return false;
						}
						
						else if(gridsArray[i][j] == 11) {
							if(validateRookMovement(gridsArray, turn, i, j) == false) return false;
							if(validateBishopMovement(gridsArray, turn, i, j) == false) return false;
						}
						
						else if(gridsArray[i][j] == 9) {
							if(validateKnightMovement(gridsArray, turn, i, j) == false) return false;
						}
						
						else if(gridsArray[i][j] == 7) {
							if(validateBlackPawnMovement(gridsArray, turn, i, j) == false) return false;		
						}
					}
					if(j == 7 && i == 7) return true;
				}
			}
				
		}
		else if(checkCounter != 8){
			return false;
		}
				
		return true;
	}

	private boolean validateBlackPawnMovement(int[][] gridsArray, int turn, int i, int j) {
		Pawn pawn = new Pawn();
		if(pawn.validateBlackMovement(gridsArray, i, j, i+1, j) == true) {
			int temp = gridsArray[i+1][j];
			InvalidMove invalid = new InvalidMove();
			moveKing(gridsArray, i, j, i+1, j);
			if(invalid.validateInvalidMove(gridsArray, turn) == true) {
				gridsArray[i][j] = gridsArray[i+1][j];
				gridsArray[i+1][j] = temp;
			}
			else {
				gridsArray[i][j] = gridsArray[i+1][j];
				gridsArray[i+1][j] = temp;
				return false;
			}	
		}
		if(i+1 <= 7) { 
			if(j-1 < 0) {
				if(gridsArray[i+1][j+1] != 0) {
					if(i+1 <= 7 && j+1 <= 7 && pawn.validateBlackMovement(gridsArray, i, j, i+1, j+1) == true) {
						int temp = gridsArray[i+1][j+1];
						InvalidMove invalid = new InvalidMove();
						moveKing(gridsArray, i, j, i+1, j+1);
						if(invalid.validateInvalidMove(gridsArray, turn) == false) {
							gridsArray[i][j] = gridsArray[i+1][j+1];
							gridsArray[i+1][j+1] = temp;
							return false;
						}
					}
				}
			}
			else if(j+1 > 7) {
				if(gridsArray[i+1][j-1] != 0) {
					if(i+1 <= 7 && j-1 >= 0 && pawn.validateBlackMovement(gridsArray, i, j, i+1, j-1) == true) {
						int temp = gridsArray[i+1][j-1];
						InvalidMove invalid = new InvalidMove();
						moveKing(gridsArray, i, j, i+1, j-1);
						if(invalid.validateInvalidMove(gridsArray, turn) == false) {
							gridsArray[i][j] = gridsArray[i+1][j-1];
							gridsArray[i+1][j-1] = temp;
							return false;
						}
					}
				}
			}
			else {
				if(gridsArray[i+1][j-1] == 0 && gridsArray[i+1][j+1] == 0) return true;
				else if(gridsArray[i+1][j-1] == 0 && gridsArray[i+1][j+1] != 0) {
					if(i+1 <= 7 && j+1 <= 7 && pawn.validateBlackMovement(gridsArray, i, j, i+1, j+1) == true) {
						int temp = gridsArray[i+1][j+1];
						InvalidMove invalid = new InvalidMove();
						moveKing(gridsArray, i, j, i+1, j+1);
						if(invalid.validateInvalidMove(gridsArray, turn) == true) {
							gridsArray[i][j] = gridsArray[i+1][j+1];
							gridsArray[i+1][j+1] = temp;
						}
						else {
							gridsArray[i][j] = gridsArray[i+1][j+1];
							gridsArray[i+1][j+1] = temp;
							return false;
						}	
					}
				}
				else if(gridsArray[i+1][j-1] != 0 && gridsArray[i+1][j+1] == 0) {
					if(i+1 <= 7 && j-1 >= 0 && pawn.validateBlackMovement(gridsArray, i, j, i+1, j-1) == true) {
						int temp = gridsArray[i+1][j-1];
						InvalidMove invalid = new InvalidMove();
						moveKing(gridsArray, i, j, i+1, j-1);
						if(invalid.validateInvalidMove(gridsArray, turn) == true) {
							gridsArray[i][j] = gridsArray[i+1][j-1];
							gridsArray[i+1][j-1] = temp;
						}
						else {
							gridsArray[i][j] = gridsArray[i+1][j-1];
							gridsArray[i+1][j-1] = temp;
							return false;
						}
					}
				}
				else {
					if(i+1 <= 7 && j+1 <= 7 && pawn.validateBlackMovement(gridsArray, i, j, i+1, j+1) == true) {
						int temp = gridsArray[i+1][j+1];
						InvalidMove invalid = new InvalidMove();
						moveKing(gridsArray, i, j, i+1, j+1);
						if(invalid.validateInvalidMove(gridsArray, turn) == true) {
							gridsArray[i][j] = gridsArray[i+1][j+1];
							gridsArray[i+1][j+1] = temp;
						}
						else {
							gridsArray[i][j] = gridsArray[i+1][j+1];
							gridsArray[i+1][j+1] = temp;
							return false;
						}	
					}
					if(i+1 <= 7 && j-1 >= 0 && pawn.validateBlackMovement(gridsArray, i, j, i+1, j-1) == true) {
						int temp = gridsArray[i+1][j-1];
						InvalidMove invalid = new InvalidMove();
						moveKing(gridsArray, i, j, i+1, j-1);
						if(invalid.validateInvalidMove(gridsArray, turn) == true) {
							gridsArray[i][j] = gridsArray[i+1][j-1];
							gridsArray[i+1][j-1] = temp;
						}
						else {
							gridsArray[i][j] = gridsArray[i+1][j-1];
							gridsArray[i+1][j-1] = temp;
							return false;
						}
					}
				}
			}
		}
		return true;
	}

	private boolean validateWhitePawnMovement(int[][] gridsArray, int turn, int i, int j) {
		Pawn pawn = new Pawn();
			if(pawn.validateMovement(gridsArray, i, j, i-1, j) == true) {
				int temp = gridsArray[i-1][j];
				InvalidMove invalid = new InvalidMove();
				moveKing(gridsArray, i, j, i-1, j);
				if(invalid.validateInvalidMove(gridsArray, turn) == true) {
					gridsArray[i][j] = gridsArray[i-1][j];
					gridsArray[i-1][j] = temp;
				}
				else {
					gridsArray[i][j] = gridsArray[i-1][j];
					gridsArray[i-1][j] = temp;
					return false;
				}	
			}
			
			if(i-1 >= 0) {
				if(j-1 < 0) {
					if(gridsArray[i-1][j+1] != 0) {
						if(i-1 >= 0 && j+1 <= 7 && pawn.validateMovement(gridsArray, i, j, i-1, j+1) == true) {
							int temp = gridsArray[i-1][j+1];
							InvalidMove invalid = new InvalidMove();
							moveKing(gridsArray, i, j, i-1, j+1);
							if(invalid.validateInvalidMove(gridsArray, turn) == false) {
								gridsArray[i][j] = gridsArray[i-1][j+1];
								gridsArray[i-1][j+1] = temp;
								return false;
							}
						}
					}
				}
				else if(j+1 > 7) {
					if(gridsArray[i-1][j-1] != 0) {
						if(i-1 >= 0 && j-1 >= 0 && pawn.validateMovement(gridsArray, i, j, i-1, j-1) == true) {
							int temp = gridsArray[i-1][j-1];
							InvalidMove invalid = new InvalidMove();
							moveKing(gridsArray, i, j, i-1, j-1);
							if(invalid.validateInvalidMove(gridsArray, turn) == false) {
								gridsArray[i][j] = gridsArray[i-1][j-1];
								gridsArray[i-1][j-1] = temp;
								return false;
							}
						}
					}
				}
				else {
					if(gridsArray[i-1][j-1] == 0 && gridsArray[i-1][j+1] == 0) return true;
					else if(gridsArray[i-1][j-1] == 0 && gridsArray[i-1][j+1] != 0) {
						if(i-1 >= 0 && j+1 <= 7 && pawn.validateMovement(gridsArray, i, j, i-1, j+1) == true) {
							int temp = gridsArray[i-1][j+1];
							InvalidMove invalid = new InvalidMove();
							moveKing(gridsArray, i, j, i-1, j+1);
							if(invalid.validateInvalidMove(gridsArray, turn) == true) {
								gridsArray[i][j] = gridsArray[i-1][j+1];
								gridsArray[i-1][j+1] = temp;
							}
							else {
								gridsArray[i][j] = gridsArray[i-1][j+1];
								gridsArray[i-1][j+1] = temp;
								return false;
							}	
						}
					}
					else if(gridsArray[i-1][j-1] != 0 && gridsArray[i-1][j+1] == 0) {
						if(i-1 >= 0 && j-1 >= 0 && pawn.validateMovement(gridsArray, i, j, i-1, j-1) == true) {
							int temp = gridsArray[i-1][j-1];
							InvalidMove invalid = new InvalidMove();
							moveKing(gridsArray, i, j, i-1, j-1);
							if(invalid.validateInvalidMove(gridsArray, turn) == true) {
								gridsArray[i][j] = gridsArray[i-1][j-1];
								gridsArray[i-1][j-1] = temp;
							}
							else {
								gridsArray[i][j] = gridsArray[i-1][j-1];
								gridsArray[i-1][j-1] = temp;
								return false;
							}	
						}
					}
					else {
						if(i-1 >= 0 && j+1 <= 7 && pawn.validateMovement(gridsArray, i, j, i-1, j+1) == true) {
							int temp = gridsArray[i-1][j+1];
							InvalidMove invalid = new InvalidMove();
							moveKing(gridsArray, i, j, i-1, j+1);
							if(invalid.validateInvalidMove(gridsArray, turn) == true) {
								gridsArray[i][j] = gridsArray[i-1][j+1];
								gridsArray[i-1][j+1] = temp;
							}
							else {
								gridsArray[i][j] = gridsArray[i-1][j+1];
								gridsArray[i-1][j+1] = temp;
								return false;
							}	
						}
						if(i-1 >= 0 && j-1 >= 0 && pawn.validateMovement(gridsArray, i, j, i-1, j-1) == true) {
							int temp = gridsArray[i-1][j-1];
							InvalidMove invalid = new InvalidMove();
							moveKing(gridsArray, i, j, i-1, j-1);
							if(invalid.validateInvalidMove(gridsArray, turn) == true) {
								gridsArray[i][j] = gridsArray[i-1][j-1];
								gridsArray[i-1][j-1] = temp;
							}
							else {
								gridsArray[i][j] = gridsArray[i-1][j-1];
								gridsArray[i-1][j-1] = temp;
								return false;
							}	
						}
					}
				}
			}
			return true;
	}

	private boolean validateKnightMovement(int[][] gridsArray, int turn, int i, int j) {
		Knight knight = new Knight();
		if(knight.validateMovement(gridsArray, i, j, i-2, j+1) ==  true) {
			int temp = gridsArray[i-2][j+1];
			InvalidMove invalid = new InvalidMove();
			moveKing(gridsArray, i, j, i-2, j+1);
			if(invalid.validateInvalidMove(gridsArray, turn) == true) {
				gridsArray[i][j] = gridsArray[i-2][j+1];
				gridsArray[i-2][j+1] = temp;
			}
			else {
				gridsArray[i][j] = gridsArray[i-2][j+1];
				gridsArray[i-2][j+1] = temp;
				return false;
			}
		}
		if(knight.validateMovement(gridsArray, i, j, i-2, j-1) ==  true) {
			int temp = gridsArray[i-2][j-1];
			InvalidMove invalid = new InvalidMove();
			moveKing(gridsArray, i, j, i-2, j-1);
			if(invalid.validateInvalidMove(gridsArray, turn) == true) {
				gridsArray[i][j] = gridsArray[i-2][j-1];
				gridsArray[i-2][j-1] = temp;
			}
			else {
				gridsArray[i][j] = gridsArray[i-2][j-1];
				gridsArray[i-2][j-1] = temp;
				return false;
			}
		}
		if(knight.validateMovement(gridsArray, i, j, i-1, j+2) ==  true) {
			int temp = gridsArray[i-1][j+2];
			InvalidMove invalid = new InvalidMove();
			moveKing(gridsArray, i, j, i-1, j+2);
			if(invalid.validateInvalidMove(gridsArray, turn) == true) {
				gridsArray[i][j] = gridsArray[i-1][j+2];
				gridsArray[i-1][j+2] = temp;
			}
			else {
				gridsArray[i][j] = gridsArray[i-1][j+2];
				gridsArray[i-1][j+2] = temp;
				return false;
			}
		}
		if(knight.validateMovement(gridsArray, i, j, i-1, j-2) ==  true) {
			int temp = gridsArray[i-1][j-2];
			InvalidMove invalid = new InvalidMove();
			moveKing(gridsArray, i, j, i-1, j-2);
			if(invalid.validateInvalidMove(gridsArray, turn) == true) {
				gridsArray[i][j] = gridsArray[i-1][j-2];
				gridsArray[i-1][j-2] = temp;
			}
			else {
				gridsArray[i][j] = gridsArray[i-1][j-2];
				gridsArray[i-1][j-2] = temp;
				return false;
			}
		}
		if(knight.validateMovement(gridsArray, i, j, i+2, j+1) ==  true) {
			int temp = gridsArray[i+2][j+1];
			InvalidMove invalid = new InvalidMove();
			moveKing(gridsArray, i, j, i+2, j+1);
			if(invalid.validateInvalidMove(gridsArray, turn) == true) {
				gridsArray[i][j] = gridsArray[i+2][j+1];
				gridsArray[i+2][j+1] = temp;
			}
			else {
				gridsArray[i][j] = gridsArray[i+2][j+1];
				gridsArray[i+2][j+1] = temp;
				return false;
			}
		}
		if(knight.validateMovement(gridsArray, i, j, i+2, j-1) ==  true) {
			int temp = gridsArray[i+2][j-1];
			InvalidMove invalid = new InvalidMove();
			moveKing(gridsArray, i, j, i+2, j-1);
			if(invalid.validateInvalidMove(gridsArray, turn) == true) {
				gridsArray[i][j] = gridsArray[i+2][j-1];
				gridsArray[i+2][j-1] = temp;
			}
			else {
				gridsArray[i][j] = gridsArray[i+2][j-1];
				gridsArray[i+2][j-1] = temp;
				return false;
			}
		}
		if(knight.validateMovement(gridsArray, i, j, i+1, j+2) ==  true) {
			int temp = gridsArray[i+1][j+2];
			InvalidMove invalid = new InvalidMove();
			moveKing(gridsArray, i, j, i+1, j+2);
			if(invalid.validateInvalidMove(gridsArray, turn) == true) {
				gridsArray[i][j] = gridsArray[i+1][j+2];
				gridsArray[i+1][j+2] = temp;
			}
			else {
				gridsArray[i][j] = gridsArray[i+1][j+2];
				gridsArray[i+1][j+2] = temp;
				return false;
			}
		}
		if(knight.validateMovement(gridsArray, i, j, i+1, j-2) ==  true) {
			int temp = gridsArray[i+1][j-2];
			InvalidMove invalid = new InvalidMove();
			moveKing(gridsArray, i, j, i+1, j-2);
			if(invalid.validateInvalidMove(gridsArray, turn) == true) {
				gridsArray[i][j] = gridsArray[i+1][j-2];
				gridsArray[i+1][j-2] = temp;
			}
			else {
				gridsArray[i][j] = gridsArray[i+1][j-2];
				gridsArray[i+1][j-2] = temp;
				return false;
			}
		}
		return true;
	}

	private boolean validateBishopMovement(int[][] gridsArray, int turn, int i, int j) {
		Bishop bishop = new Bishop();
		InvalidMove invalid = new InvalidMove();
		if(bishop.validateMovement(gridsArray, i, j, i-1, j-1) == true) {
			int temp = gridsArray[i-1][j-1];
			moveKing(gridsArray, i, j, i-1, j-1);
			if(invalid.validateInvalidMove(gridsArray, turn) == true) {
				gridsArray[i][j] = gridsArray[i-1][j-1];
				gridsArray[i-1][j-1] = temp;
			}
			else {
				gridsArray[i][j] = gridsArray[i-1][j-1];
				gridsArray[i-1][j-1] = temp;
				return false;
			}	
		}
		if(bishop.validateMovement(gridsArray, i, j, i-1, j+1) == true) {
			int temp = gridsArray[i-1][j+1];
			moveKing(gridsArray, i, j, i-1, j+1);
			if(invalid.validateInvalidMove(gridsArray, turn) == true) {
				gridsArray[i][j] = gridsArray[i-1][j+1];
				gridsArray[i-1][j+1] = temp;
			}
			else {
				gridsArray[i][j] = gridsArray[i-1][j+1];
				gridsArray[i-1][j+1] = temp;
				return false;
			}	
		}
		if(bishop.validateMovement(gridsArray, i, j, i+1, j-1) == true) {
			int temp = gridsArray[i+1][j-1];
			moveKing(gridsArray, i, j, i+1, j-1);
			if(invalid.validateInvalidMove(gridsArray, turn) == true) {
				gridsArray[i][j] = gridsArray[i+1][j-1];
				gridsArray[i+1][j-1] = temp;
			}
			else {
				gridsArray[i][j] = gridsArray[i+1][j-1];
				gridsArray[i+1][j-1] = temp;
				return false;
			}	
		}
		if(bishop.validateMovement(gridsArray, i, j, i+1, j+1) == true) {
			int temp = gridsArray[i+1][j+1];
			moveKing(gridsArray, i, j, i+1, j+1);
			if(invalid.validateInvalidMove(gridsArray, turn) == true) {
				gridsArray[i][j] = gridsArray[i+1][j+1];
				gridsArray[i+1][j+1] = temp;
			}
			else {
				gridsArray[i][j] = gridsArray[i+1][j+1];
				gridsArray[i+1][j+1] = temp;
				return false;
			} 
		}
		return true;
	}

	private boolean validateRookMovement(int[][] gridsArray, int turn, int i, int j) {
		int temp;
		Rook rook = new Rook();
		InvalidMove invalid = new InvalidMove();
		if(rook.validateMovement(gridsArray, i, j, i-1, j) == true) {
			temp = gridsArray[i-1][j];
			moveKing(gridsArray, i, j, i-1, j);
			if(invalid.validateInvalidMove(gridsArray, turn) == true) {
				gridsArray[i][j] = gridsArray[i-1][j];
				gridsArray[i-1][j] = temp;
			}
			else {
				gridsArray[i][j] = gridsArray[i-1][j];
				gridsArray[i-1][j] = temp;
				return false;
			}	
		}
		if(rook.validateMovement(gridsArray, i, j, i+1, j) == true) {
			temp = gridsArray[i+1][j];
			moveKing(gridsArray, i, j, i+1, j);
			if(invalid.validateInvalidMove(gridsArray, turn) == true) {
				gridsArray[i][j] = gridsArray[i+1][j];
				gridsArray[i+1][j] = temp;
			}
			else {
				gridsArray[i][j] = gridsArray[i+1][j];
				gridsArray[i+1][j] = temp;
				return false;
			}	
		}
		if(rook.validateMovement(gridsArray, i, j, i, j-1) == true) {
			temp = gridsArray[i][j-1];
			moveKing(gridsArray, i, j, i, j-1);
			if(invalid.validateInvalidMove(gridsArray, turn) == true) {
				gridsArray[i][j] = gridsArray[i][j-1];
				gridsArray[i][j-1] = temp;
			}
			else {
				gridsArray[i][j] = gridsArray[i][j-1];
				gridsArray[i][j-1] = temp;
				return false;
			}	
		}
		if(rook.validateMovement(gridsArray, i, j, i, j+1) == true) {
			temp = gridsArray[i][j+1];
			moveKing(gridsArray, i, j, i, j+1);
			if(invalid.validateInvalidMove(gridsArray, turn) == true) {
				gridsArray[i][j] = gridsArray[i][j+1];
				gridsArray[i][j+1] = temp;
			}
			else {
				gridsArray[i][j] = gridsArray[i][j+1];
				gridsArray[i][j+1] = temp;
				return false;
			}	
		}
		return true;
	}

}
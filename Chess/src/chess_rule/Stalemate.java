package chess_rule;

import chess_piece.Bishop;
import chess_piece.Knight;
import chess_piece.Pawn;
import chess_piece.Queen;
import chess_piece.Rook;

public class Stalemate {
	
	public void moveKing(int gridsArray[][], int x1, int y1, int x2, int y2) {
		gridsArray[x2][y2] = gridsArray[x1][y1];
		gridsArray[x1][y1] = 0;
	}
	
	public int findXKing(int gridsArray[][], int turn) {
		for (int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if(turn == 1) {
					if(gridsArray[i][j] == 6) {
						return i;
					}
				}
				else if(turn == -1) {
					if(gridsArray[i][j] == 12) {
						return i;
					}
				}
			}
		}
		return -1;
	}
	
	public int findYKing(int gridsArray[][], int turn) {
		for (int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if(turn == 1) {
					if(gridsArray[i][j] == 6) {
						return j;
					}
				}
				else if(turn == -1) {
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
		
		//atas
		if(xKing-1 >= 0) {
			if(gridsArray[xKing-1][yKing] == 0) {
				moveKing(gridsArray, xKing, yKing, xKing-1, yKing);
				if(invalidMove.validateInvalidMove(gridsArray, turn) == true) {
					//System.out.println("msk1");
					checkCounter++;
				}
				moveKing(gridsArray, xKing-1, yKing, xKing, yKing);
			}
			else {
				if(turn == 1) {
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
				else if(turn == -1) {
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
			//System.out.println("msk1");
			checkCounter++;
		}
		
		//bawah
		if(xKing+1 <= 7) {
			if(gridsArray[xKing+1][yKing] == 0) {
				moveKing(gridsArray, xKing, yKing, xKing+1, yKing);
				if(invalidMove.validateInvalidMove(gridsArray, turn) == true) checkCounter++;
				moveKing(gridsArray, xKing+1, yKing, xKing, yKing);
			}
			else {
				if(turn == 1) {
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
				else if(turn == -1) {
					if(gridsArray[xKing+1][yKing] == 1 || gridsArray[xKing+1][yKing] == 2 || gridsArray[xKing+1][yKing] == 3 || gridsArray[xKing+1][yKing] == 4 || gridsArray[xKing+1][yKing] == 5 || gridsArray[xKing+1][yKing] == 6) {
						int temp = gridsArray[xKing+1][yKing];
						moveKing(gridsArray, xKing, yKing, xKing+1, yKing);
						if(invalidMove.validateInvalidMove(gridsArray, turn) == true) {
							//System.out.println("msk9");
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
			
		//kiri
		if(yKing-1 >= 0) {
			if(gridsArray[xKing][yKing-1] == 0) {
				moveKing(gridsArray, xKing, yKing, xKing, yKing-1);
				if(invalidMove.validateInvalidMove(gridsArray, turn) == true) checkCounter++;
				moveKing(gridsArray, xKing, yKing-1, xKing, yKing);
			}
			else {
				if(turn == 1) {
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
				else if(turn == -1) {
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
			//System.out.println("msk2");
			checkCounter++;
		}
			
		//kanan
		if(yKing+1 <= 7) {
			if(gridsArray[xKing][yKing+1] == 0) {
				moveKing(gridsArray, xKing, yKing, xKing, yKing+1);
				if(invalidMove.validateInvalidMove(gridsArray, turn) == true) {
					//System.out.println("msk3");
					checkCounter++;
				}
				moveKing(gridsArray, xKing, yKing+1, xKing, yKing);
			}
			else {
				if(turn == 1) {
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
				else if(turn == -1) {
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
			
		//kanan atas
		if(xKing-1 >= 0 && yKing+1 <= 7) {
			if(gridsArray[xKing-1][yKing+1] == 0) {
				moveKing(gridsArray, xKing, yKing, xKing-1, yKing+1);
				if(invalidMove.validateInvalidMove(gridsArray, turn) == true) checkCounter++;
				moveKing(gridsArray, xKing-1, yKing+1, xKing, yKing);
			}
			else {
				if(turn == 1) {
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
				else if(turn == -1) {
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
			//System.out.println("msk23");
			checkCounter++;
		}
		
		//kiri atas
		if(xKing-1 >= 0 && yKing-1 >= 0) {
			if(gridsArray[xKing-1][yKing-1] == 0) {
				moveKing(gridsArray, xKing, yKing, xKing-1, yKing-1);
				if(invalidMove.validateInvalidMove(gridsArray, turn) == true) checkCounter++;
				moveKing(gridsArray, xKing-1, yKing-1, xKing, yKing);
			}
			else {
				if(turn == 1) {
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
				else if(turn == -1) {
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
			//System.out.println("msk55");
			checkCounter++;
		}
		
		//kiri bawah
		if(xKing+1 <= 7 && yKing-1 >= 0) {
			if(gridsArray[xKing+1][yKing-1] == 0) {
				moveKing(gridsArray, xKing, yKing, xKing+1, yKing-1);
				if(invalidMove.validateInvalidMove(gridsArray, turn) == true) checkCounter++;
				moveKing(gridsArray, xKing+1, yKing-1, xKing, yKing);
			}
			else {
				if(turn == 1) {
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
				else if(turn == -1) {
					if(gridsArray[xKing+1][yKing-1] == 1 || gridsArray[xKing+1][yKing-1] == 2 || gridsArray[xKing+1][yKing-1] == 3 || gridsArray[xKing+1][yKing-1] == 4 || gridsArray[xKing+1][yKing-1] == 5 || gridsArray[xKing+1][yKing-1] == 6) {
						int temp = gridsArray[xKing+1][yKing-1];
						moveKing(gridsArray, xKing, yKing, xKing+1, yKing-1);
						if(invalidMove.validateInvalidMove(gridsArray, turn) == true) {
							//System.out.println("msk9");
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
			//System.out.println("msk7");
			checkCounter++;
		}
		
		//kanan bawah
		if(xKing+1 <= 7 && yKing+1 <= 7) {
			if(gridsArray[xKing+1][yKing+1] == 0) {
				moveKing(gridsArray, xKing, yKing, xKing+1, yKing+1);
				if(invalidMove.validateInvalidMove(gridsArray, turn) == true) {
					//System.out.println("msk8");
					checkCounter++;
				}
				moveKing(gridsArray, xKing+1, yKing+1, xKing, yKing);
			}
			else {
				if(turn == 1) {
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
				else if(turn == -1) {
					if(gridsArray[xKing+1][yKing+1] == 1 || gridsArray[xKing+1][yKing+1] == 2 || gridsArray[xKing+1][yKing+1] == 3 || gridsArray[xKing+1][yKing+1] == 4 || gridsArray[xKing+1][yKing+1] == 5 || gridsArray[xKing+1][yKing+1] == 6) {
						int temp = gridsArray[xKing+1][yKing+1];
						moveKing(gridsArray, xKing, yKing, xKing+1, yKing+1);
						if(invalidMove.validateInvalidMove(gridsArray, turn) == true) {
							//System.out.println("msk9");
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

		if(checkCounter == 8) {
			for(int i = 0; i < 8; i++) {
				for(int j = 0; j < 8; j++) {
					
					if(turn == 1) {
						//rook
						if(gridsArray[i][j] == 2) {
							Rook rook = new Rook();
							if(rook.validateMovement(gridsArray, i, j, i-1, j) == true) return false;
							if(rook.validateMovement(gridsArray, i, j, i+1, j) == true) return false;
							if(rook.validateMovement(gridsArray, i, j, i, j-1) == true) return false;
							if(rook.validateMovement(gridsArray, i, j, i, j+1) == true) return false;
						}
						//==========================
						
						//bishop
						else if(gridsArray[i][j] == 4) {
							Bishop bishop = new Bishop();
							if(bishop.validateMovement(gridsArray, i, j, i-1, j-1) == true) return false;
							if(bishop.validateMovement(gridsArray, i, j, i-1, j+1) == true) return false;
							if(bishop.validateMovement(gridsArray, i, j, i+1, j-1) == true) return false;
							if(bishop.validateMovement(gridsArray, i, j, i+1, j+1) == true) return false;
						}
						//==========================
						
						//queen
						else if(gridsArray[i][j] == 5) {
							Queen queen = new Queen();
							if(queen.validateMovement(gridsArray, i, j, i-1, j) == true) return false;
							if(queen.validateMovement(gridsArray, i, j, i+1, j) == true) return false;
							if(queen.validateMovement(gridsArray, i, j, i, j-1) == true) return false;
							if(queen.validateMovement(gridsArray, i, j, i, j+1) == true) return false;
							if(queen.validateMovement(gridsArray, i, j, i-1, j-1) == true) return false;
							if(queen.validateMovement(gridsArray, i, j, i-1, j+1) == true) return false;
							if(queen.validateMovement(gridsArray, i, j, i+1, j-1) == true) return false;
							if(queen.validateMovement(gridsArray, i, j, i+1, j+1) == true) return false;
						} 
						//==========================	
						
						//knight
						else if(gridsArray[i][j] == 3) {
							Knight knight = new Knight();
							if(knight.validateMovement(gridsArray, i, j, i-2, j+1) ==  true) return false;
							if(knight.validateMovement(gridsArray, i, j, i-2, j-1) ==  true) return false;
							if(knight.validateMovement(gridsArray, i, j, i-1, j+2) ==  true) return false;
							if(knight.validateMovement(gridsArray, i, j, i-1, j-2) ==  true) return false;
							if(knight.validateMovement(gridsArray, i, j, i+2, j+1) ==  true) return false;
							if(knight.validateMovement(gridsArray, i, j, i+2, j-1) ==  true) return false;
							if(knight.validateMovement(gridsArray, i, j, i+1, j+2) ==  true) return false;
							if(knight.validateMovement(gridsArray, i, j, i+1, j-2) ==  true) return false;
						}
						//==========================
						
						//pawn
						else if(gridsArray[i][j] == 1) {
							Pawn pawn = new Pawn();
							if(pawn.validateMovement(gridsArray, i, j, i-1, j) == true) return false;
							if(i-1 >= 0 && j-1 >= 0 && pawn.validateMovement(gridsArray, i, j, i-1, j-1) == true) return false;
							if(i-1 >= 0 && j+1 <= 7 && pawn.validateMovement(gridsArray, i, j, i-1, j+1) == true) return false;
						}
						//=========================
					}
					
					else if(turn == -1) {
						//rook
						if(gridsArray[i][j] == 8) {
							Rook rook = new Rook();
							if(rook.validateMovement(gridsArray, i, j, i-1, j) == true) return false;
							if(rook.validateMovement(gridsArray, i, j, i+1, j) == true) return false;
							if(rook.validateMovement(gridsArray, i, j, i, j-1) == true) return false;
							if(rook.validateMovement(gridsArray, i, j, i, j+1) == true) return false;
						}
						//==========================
						
						//bishop
						else if(gridsArray[i][j] == 10) {
							Bishop bishop = new Bishop();
							if(bishop.validateMovement(gridsArray, i, j, i-1, j-1) == true) return false;
							if(bishop.validateMovement(gridsArray, i, j, i-1, j+1) == true) return false;
							if(bishop.validateMovement(gridsArray, i, j, i+1, j-1) == true) return false;
							if(bishop.validateMovement(gridsArray, i, j, i+1, j+1) == true) return false;
						}
						//==========================
						
						//queen
						else if(gridsArray[i][j] == 11) {
							Queen queen = new Queen();
							if(queen.validateMovement(gridsArray, i, j, i-1, j) == true) return false;
							if(queen.validateMovement(gridsArray, i, j, i+1, j) == true) return false;
							if(queen.validateMovement(gridsArray, i, j, i, j-1) == true) return false;
							if(queen.validateMovement(gridsArray, i, j, i, j+1) == true) return false;
							if(queen.validateMovement(gridsArray, i, j, i-1, j-1) == true) return false;
							if(queen.validateMovement(gridsArray, i, j, i-1, j+1) == true) return false;
							if(queen.validateMovement(gridsArray, i, j, i+1, j-1) == true) return false;
							if(queen.validateMovement(gridsArray, i, j, i+1, j+1) == true) return false;
						}
						//==========================	
						
						//knight
						else if(gridsArray[i][j] == 9) {
							Knight knight = new Knight();
							if(knight.validateMovement(gridsArray, i, j, i-2, j+1) ==  true) return false;
							if(knight.validateMovement(gridsArray, i, j, i-2, j-1) ==  true) return false;
							if(knight.validateMovement(gridsArray, i, j, i-1, j+2) ==  true) return false;
							if(knight.validateMovement(gridsArray, i, j, i-1, j-2) ==  true) return false;
							if(knight.validateMovement(gridsArray, i, j, i+2, j+1) ==  true) return false;
							if(knight.validateMovement(gridsArray, i, j, i+2, j-1) ==  true) return false;
							if(knight.validateMovement(gridsArray, i, j, i+1, j+2) ==  true) return false;
							if(knight.validateMovement(gridsArray, i, j, i+1, j-2) ==  true) return false;
						}
						//==========================
						
						//pawn
						else if(gridsArray[i][j] == 7) {
							Pawn pawn = new Pawn();
							if(pawn.validateBlackMovement(gridsArray, i, j, i+1, j) == true) {
								return false;
							}
							if(i+1 <= 7 && j-1 >= 0 && pawn.validateBlackMovement(gridsArray, i, j, i+1, j-1) == true) { 
								return false;			
							}
							if(i+1 <= 7 && j+1 <= 7) {
								if(pawn.validateBlackMovement(gridsArray, i, j, i+1, j+1) == true) {
									return false;
								}
							}
						}
						//=========================
						
					}
					if(j == 7 && i == 7) return true;
				}
			}
				
		}
		else {
			return false;
		}
		
		int pawn = 0;
		int rook = 0;
		int knight = 0;
		int bishop = 0;
		int queen = 0;
		
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if(turn == 1) {
					if(gridsArray[i][j] == 1 || gridsArray[i][j] == 2 || gridsArray[i][j] == 3 || gridsArray[i][j] == 4 || gridsArray[i][j] == 5) return false;
					if(gridsArray[i][j] == 7) pawn++;
					else if(gridsArray[i][j] == 8) rook++;
					else if(gridsArray[i][j] == 9) knight++;
					else if(gridsArray[i][j] == 10) bishop++;
					else if(gridsArray[i][j] == 11) queen++;
				}
				else if(turn == -1) {
					if(gridsArray[i][j] == 7 || gridsArray[i][j] == 8 || gridsArray[i][j] == 9 || gridsArray[i][j] == 10 || gridsArray[i][j] == 11) return false;
					if(gridsArray[i][j] == 1) pawn++;
					else if(gridsArray[i][j] == 2) rook++;
					else if(gridsArray[i][j] == 3) knight++;
					else if(gridsArray[i][j] == 4) bishop++;
					else if(gridsArray[i][j] == 5) queen++;
				}
			}
		}
		
		System.out.println(pawn);
		System.out.println(rook);
		System.out.println(knight);
		System.out.println(bishop);
		System.out.println(queen);
		
		if(pawn >= 1 || queen == 1 || rook >= 1) return false;
		
		if(pawn == 0 && rook == 0 && queen == 0 && (bishop == 0 || knight == 0)) {
			if(bishop == 0) {
				if(knight == 0) return false;
			}
			else if(knight == 0) {
				if(bishop == 2 || bishop == 0) return false;
			}
		}
				
		return true;
	}

}
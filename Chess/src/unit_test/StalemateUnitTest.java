package unit_test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import chess_board.PrintBoard;
import chess_rule.Stalemate;

class StalemateUnitTest {
	public int wPawn() {
		return 1;
	}
	public int wRook() {
		return 2;
	}
	public int wKnight() {
		return 3;
	}
	public int wBishop() {
		return 4;
	}
	public int wQueen() {
		return 5;
	}
	public int wKing() {
		return 6;
	}
	public int bPawn() {
		return 7;
	}
	public int bRook() {
		return 8;
	}
	public int bKnight() {
		return 9;
	}
	public int bBishop() {
		return 10;
	}
	public int bQueen() {
		return 11;
	}
	public int bKing() {
		return 12;
	}
	
	@Test
	public void testMoveKing() {
		int[][] grids = new int[8][8];
		Stalemate stalemate = new Stalemate();
		grids[3][4] = 2;
		grids[3][5] = 4;
		
		stalemate.moveKing(grids, 3, 4, 3, 5); 
		
		assert(grids[3][4] == 0 && grids[3][5] == 2); 
	}
	 
	@Test
	public void testFindKingPosition() {
		int[][] grids = new int[8][8];
		Stalemate stalemate = new Stalemate();
		
		grids[3][4] = 6;
		grids[7][7] = 12;
		
		assert(stalemate.findXKing(grids, 1) == 3 && stalemate.findYKing(grids, 1) == 4);
		assert(stalemate.findXKing(grids, -1) == 7 && stalemate.findYKing(grids, -1) == 7);
		
		grids[3][4] = 0;
		grids[7][7] = 0;
		
		assert(stalemate.findXKing(grids, 1) == -1 && stalemate.findYKing(grids, 1) == -1);
		assert(stalemate.findXKing(grids, -1) == -1 && stalemate.findYKing(grids, -1) == -1);
	}
	
	@Test
	public void testStalemate() {
		int[][] grids = new int[8][8];
		Stalemate stalemate = new Stalemate();
		PrintBoard pb = new PrintBoard();
		grids[0][0] = bKing();
		grids[1][0] = wPawn();
		grids[2][0] = wKing();
		grids[2][1] = wQueen();
		grids[1][3] = wBishop(); 
		grids[2][3] = wKnight();
		grids[6][0] = bPawn();
		grids[5][1] = bPawn();
		grids[6][2] = bPawn();
		grids[5][3] = bPawn();
		grids[6][4] = bPawn();
		grids[5][5] = bPawn();
		grids[6][6] = bPawn();
		grids[5][7] = bPawn();
		grids[7][0] = wRook();
		grids[6][1] = wPawn();
		grids[7][2] = wBishop();
		grids[6][3] = wPawn();
		grids[7][4] = wKnight();
		grids[6][5] = wPawn();
		grids[7][6] = wRook();
		grids[6][7] = wPawn();
		
		assert(stalemate.stalemate(grids, -1) == true);
		
		grids = new int[8][8];
		
		grids[7][0] = 2;
		grids[7][1] = 3;
		grids[7][2] = 4;
		grids[7][4] = 6;
		grids[7][5] = 4;
		grids[7][6] = 3;
		grids[7][7] = 2;
		grids[6][0] = 1;
		grids[6][1] = 1; 
		grids[6][2] = 1;
		grids[6][3] = 1;
		grids[6][5] = 1;
		grids[6][6] = 1;
		grids[5][4] = 1;
		grids[4][7] = 1;
		grids[3][7] = 7;
		grids[2][4] = 5;
		grids[2][5] = 7;
		grids[2][6] = 12;
		grids[2][7] = 8;
		grids[1][4] = 7;
		grids[1][6] = 7;
		grids[1][7] = 11;
		grids[0][5] = 10;
		grids[0][6] = 9;
		grids[0][7] = 8;
	
		pb.print(grids);
	
		assert(stalemate.stalemate(grids, -1) == true);
		

		grids[7][0] = 2;
		grids[7][1] = 3;
		grids[7][2] = 4;
		grids[7][4] = 6;
		grids[7][5] = 4;
		grids[7][6] = 3;
		grids[7][7] = 2;
		grids[6][0] = 1;
		grids[6][1] = 1; 
		grids[6][2] = 1;
		grids[6][3] = 1;
		grids[6][5] = 1;
		grids[6][6] = 1;
		grids[5][4] = 1;
		grids[4][7] = 1;
		grids[3][7] = 0; 
		grids[2][4] = 5;
		grids[2][5] = 7;
		grids[2][6] = 12;
		grids[2][7] = 8;
		grids[1][4] = 7;
		grids[1][6] = 7;
		grids[1][7] = 11;
		grids[0][5] = 10;
		grids[0][6] = 9;
		grids[0][7] = 8;
		
		pb.print(grids);
	
		assert(stalemate.stalemate(grids, -1) == false);
	
		grids = new int[8][8];
		
		grids[7][0] = 8;
		grids[7][1] = 9;
		grids[7][2] = 10;
		grids[7][4] = 12;
		grids[7][5] = 10;
		grids[7][6] = 9;
		grids[7][7] = 8;
		grids[6][0] = 7;
		grids[6][1] = 7; 
		grids[6][2] = 7;
		grids[6][3] = 7;
		grids[6][5] = 7;
		grids[6][6] = 7;
		grids[5][4] = 7;
		grids[4][7] = 7;
		grids[3][7] = 1;
		grids[2][4] = 11;
		grids[2][5] = 1;
		grids[2][6] = 6;
		grids[2][7] = 2;
		grids[1][4] = 1;
		grids[1][6] = 1;
		grids[1][7] = 5;
		grids[0][5] = 4;
		grids[0][6] = 3;
		grids[0][7] = 2;
		grids[0][4] = 8;
		
		pb.print(grids);
		
		assert(stalemate.stalemate(grids, 1) == false);
		
		grids = new int[8][8];
		
		grids[7][0] = 2;
		grids[7][1] = 3;
		grids[7][2] = 4;
		grids[7][4] = 6;
		grids[7][5] = 4;
		grids[7][6] = 3;
		grids[7][7] = 2;
		grids[6][0] = 1;
		grids[6][1] = 1; 
		grids[6][2] = 1;
		grids[6][3] = 1;
		grids[6][5] = 1;
		grids[6][6] = 1;
		grids[5][4] = 1;
		grids[4][7] = 1;
		grids[3][7] = 0; 
		grids[2][4] = 5;
		grids[2][5] = 7;
		grids[2][6] = 12;
		grids[2][7] = 8;
		grids[1][4] = 7;
		grids[1][6] = 0;
		grids[1][7] = 11;
		grids[0][5] = 10;
		grids[0][6] = 9;
		grids[0][7] = 2;
		grids[0][4] = 3;
		
		pb.print(grids);
		
		assert(stalemate.stalemate(grids, -1) == false);
		
		grids[7][0] = 2;
		grids[7][1] = 3;
		grids[7][2] = 4;
		grids[7][4] = 6;
		grids[7][5] = 4;
		grids[7][6] = 3;
		grids[7][7] = 2;
		grids[6][0] = 1;
		grids[6][1] = 1; 
		grids[6][2] = 1;
		grids[6][3] = 1;
		grids[6][5] = 1;
		grids[6][6] = 1;
		grids[5][4] = 1;
		grids[4][7] = 1;
		grids[3][7] = 0; 
		grids[2][4] = 5;
		grids[2][5] = 7;
		grids[2][6] = 12;
		grids[2][7] = 8;
		grids[1][4] = 7;
		grids[1][6] = 1;
		grids[1][7] = 11;
		grids[0][5] = 10;
		grids[0][6] = 9;
		grids[0][7] = 2;
		grids[0][4] = 3;
		
		pb.print(grids);
		
		assert(stalemate.stalemate(grids, -1) == false);
		
		grids[7][0] = 2;
		grids[7][1] = 3;
		grids[7][2] = 4;
		grids[7][4] = 6;
		grids[7][5] = 4;
		grids[7][6] = 3;
		grids[7][7] = 2;
		grids[6][0] = 1;
		grids[6][1] = 1; 
		grids[6][2] = 1;
		grids[6][3] = 1;
		grids[6][5] = 1;
		grids[6][6] = 1;
		grids[5][4] = 1;
		grids[4][7] = 1;
		grids[3][7] = 0; 
		grids[2][4] = 5;
		grids[2][5] = 1;
		grids[2][6] = 12;
		grids[2][7] = 1;
		grids[1][4] = 7;
		grids[1][6] = 1;
		grids[1][7] = 1;
		grids[0][5] = 10;
		grids[0][6] = 9;
		grids[0][7] = 2;
		grids[0][4] = 3;
		grids[3][6] = 1;
		
		pb.print(grids);
		
		assert(stalemate.stalemate(grids, -1) == false);
		
		grids[7][0] = 2;
		grids[7][1] = 3;
		grids[7][2] = 4;
		grids[7][4] = 6;
		grids[7][5] = 4;
		grids[7][6] = 3;
		grids[7][7] = 2;
		grids[6][0] = 1;
		grids[6][1] = 1; 
		grids[6][2] = 1;
		grids[6][3] = 1;
		grids[6][5] = 1;
		grids[6][6] = 1;
		grids[5][4] = 1;
		grids[4][7] = 1;
		grids[3][7] = 0; 
		grids[2][4] = 5;
		grids[2][5] = 1;
		grids[2][6] = 12;
		grids[2][7] = 1;
		grids[1][4] = 7;
		grids[1][6] = 1;
		grids[1][7] = 1;
		grids[0][5] = 10;
		grids[0][6] = 9;
		grids[0][7] = 2;
		grids[0][4] = 3;
		grids[3][6] = 1;
		grids[1][5] = 7;
		
		pb.print(grids);
		
		assert(stalemate.stalemate(grids, -1) == false);
		
		grids[1][5] = 1;
		
		pb.print(grids);
		
		assert(stalemate.stalemate(grids, -1) == false);
		
		grids[3][6] = 7;
		
		pb.print(grids);
		
		assert(stalemate.stalemate(grids, -1) == false);
		
		grids[3][5] = 7;
		
		pb.print(grids);
		
		assert(stalemate.stalemate(grids, -1) == false);
		
		grids[3][5] = 2;
		
		pb.print(grids);
		
		assert(stalemate.stalemate(grids, -1) == false);
		
		grids[3][7] = 2;
		grids[3][6] = 0;
		grids[4][6] = 4;
		
		pb.print(grids);
		
		assert(stalemate.stalemate(grids, -1) == false);
		
		grids = new int[8][8];
		
		grids[0][0] = 7;
		grids[0][1] = 7;
		grids[0][2] = 7;
		grids[1][0] = 7;
		grids[1][1] = 12;
		grids[1][2] = 9;
		grids[1][7] = 5;
		grids[2][0] = 2;
		grids[2][1] = 7;
		grids[2][2] = 2;
		grids[2][7] = 2;
		grids[3][1] = 1;
		grids[7][0] = 5;
		
		pb.print(grids);
		
		assert(stalemate.stalemate(grids, -1) == true);
		
		grids[1][7] = 0;
		
		assert(stalemate.stalemate(grids, -1) == false);
		
		grids[1][7] = 5;
		grids[2][1] = 7;
		grids[7][6] = 4;
		grids[1][2] = 10;
		
		pb.print(grids);
		
		assert(stalemate.stalemate(grids, -1) == true);
		
		grids[1][7] = 0;
		
		pb.print(grids);
		
		assert(stalemate.stalemate(grids, -1) == false);
		
		grids[0][0] = 7;
		grids[0][1] = 7;
		grids[0][2] = 7;
		grids[1][0] = 7;
		grids[1][1] = 12;
		grids[1][2] = 7; 
		grids[1][7] = 0;
		grids[2][0] = 2;
		grids[2][1] = 7;
		grids[2][2] = 8;
		grids[2][7] = 2;
		grids[3][1] = 1;
		grids[7][0] = 5;
		grids[7][6] = 0;
		grids[7][7] = 5;
		
		pb.print(grids);
		
		assert(stalemate.stalemate(grids, -1) == true);
		
		grids = new int[8][8];
		
		grids[0][7] = 12;
		grids[7][0] = 2;
		grids[7][1] = 3;
		grids[7][2] = 4;
		grids[6][0] = 1;
		grids[6][1] = 1;
		grids[6][3] = 1;
		grids[5][0] = 2;
		grids[5][1] = 6;
		grids[5][2] = 1;
		grids[5][3] = 11;
		grids[4][0] = 1;
		grids[3][0] = 7;
		
		pb.print(grids);
		
		assert(stalemate.stalemate(grids, 1) == true);
		
		grids[4][1] = 7;
		
		pb.print(grids);
		
		assert(stalemate.stalemate(grids, 1) == true);
		
		grids[6][2] = 8;
		 
		pb.print(grids);
		
		assert(stalemate.stalemate(grids, 1) == true);
	
		grids[7][2] = 0;
		grids[6][2] = 0;
		grids[6][1] = 10; 
		grids[7][2] = 10;
		
		pb.print(grids);
		
		assert(stalemate.stalemate(grids, 1) == true);

		grids[5][2] = 7;
		grids[7][1] = 1;
		grids[6][3] = 7;
		grids[4][2] = 8;
		
		pb.print(grids);
		
		assert(stalemate.stalemate(grids, 1) == true);
	
		grids[3][0] = 8;
		grids[4][0] = 8;
		grids[5][0] = 10;
		
		pb.print(grids);
		
		assert(stalemate.stalemate(grids, 1) == true);
		
		grids[6][0] = 8;
		grids[7][0] = 7;
		grids[7][1] = 10;
		
		pb.print(grids);
		
		assert(stalemate.stalemate(grids, 1) == true);
		
		grids[4][2] = 5;
		grids[0][6] = 10;
		
		pb.print(grids);
		
		assert(stalemate.stalemate(grids, 1) == true);
		
		grids = new int[8][8];
		
		grids[4][4] = 1;
		grids[4][5] = 6;
		grids[5][0] = 8;  
		grids[4][0] = 8;
		grids[3][0] = 8;
		grids[0][4] = 8;
		grids[0][6] = 8;
		  
		pb.print(grids);
		  
		assert(stalemate.stalemate(grids, 1) == true);
		
		grids[3][5] = 7;
		
		pb.print(grids);
		
		assert(stalemate.stalemate(grids, 1) == true);
		
		grids[3][3] = 8;
		
		pb.print(grids);
	
		
		assert(stalemate.stalemate(grids, 1) == true);
	
		pb.print(grids);
		
		grids = new int[8][8];
		
		grids[4][1] = 6;
		grids[3][0] = 8;
		grids[3][1] = 7;
		grids[0][0] = 8;
		grids[0][2] = 8;
		grids[5][7] = 8;
		grids[4][0] = 1;
		
		pb.print(grids);
		
		assert(stalemate.stalemate(grids, 1) == false);
		
		grids[3][1] = 0;
		
		pb.print(grids);
		
		assert(stalemate.stalemate(grids, 1) == true);
		
		grids[3][0] = 0;
		grids[3][7] = 8;
		pb.print(grids);
		
		assert(stalemate.stalemate(grids, 1) == false);
	
		
	}
	
	 @Test	
	 void testPawnBreakStalemate() {
		  int[][] grids = new int[8][8];
		  grids[4][5] = 6;
		  
		  grids[5][0] = 8;
		  grids[3][0] = 8;
		  grids[0][4] = 8;
		  grids[0][6] = 8;
		  
		  Stalemate stalemate = new Stalemate();
		  
		  assert(stalemate.stalemate(grids, 1));
		  
		  grids[4][1] = 1;
		  
		  assert(!stalemate.stalemate(grids, 1));
		  
		  grids[4][5] = 12;
		  
		  grids[5][0] = 2;
		  grids[3][0] = 2;
		  grids[0][4] = 2;
		  grids[0][6] = 2;
		  
		  assert(stalemate.stalemate(grids, -1));
		  
		  grids[2][3] = 7;
		  
		  assert(!stalemate.stalemate(grids, -1));
		 }
		 
		 @Test
		 void testPawnCornerEatRightMove() {
		  int[][] grids = new int[8][8];
		  grids[1][5] = 6;
		  
		  grids[0][1] = 8;
		  grids[2][1] = 8;
		  grids[0][4] = 8;
		  grids[0][6] = 8;
		  
		  Stalemate stalemate = new Stalemate();
		  
		  assert(stalemate.stalemate(grids, 1));
		  
		  grids[1][0] = 1;
		  grids[0][0] = 1;
		  
		  assert(!stalemate.stalemate(grids, 1));
		  
		  grids[1][5] = 0;
		  grids[0][1] = 0;
		  grids[2][1] = 0;
		  grids[0][4] = 0;
		  grids[0][6] = 0;
		  grids[1][0] = 0;
		  grids[0][0] = 0;
		  
		  grids[6][5] = 12;
		  
		  grids[5][1] = 2;
		  grids[7][1] = 2;
		  grids[0][4] = 2;
		  grids[0][6] = 2;
		  
		  assert(stalemate.stalemate(grids, -1));
		  
		  grids[6][0] = 7;
		  grids[7][0] = 7;
		  
		  assert(!stalemate.stalemate(grids, -1));
		 }
		 
		 @Test
		 void testPawnCornerEatLefttMove() {
		  int[][] grids = new int[8][8];
		  grids[1][2] = 6;
		  
		  grids[0][6] = 8;
		  grids[2][6] = 8;
		  grids[7][3] = 8;
		  grids[7][1] = 8;
		  
		  Stalemate stalemate = new Stalemate();
		  
		  assert(stalemate.stalemate(grids, 1));
		  
		  grids[1][7] = 1;
		  grids[0][7] = 1;
		  
		  assert(!stalemate.stalemate(grids, 1));
		  
		  grids[1][2] = 0;
		  grids[0][6] = 0;
		  grids[2][6] = 0;
		  grids[7][3] = 0;
		  grids[7][1] = 0;
		  grids[1][7] = 0;
		  grids[0][7] = 0;
		  
		  grids[6][2] = 12;
		  
		  grids[0][3] = 2;
		  grids[0][1] = 2;
		  grids[5][6] = 2;
		  grids[7][6] = 2;
		  
		  assert(stalemate.stalemate(grids, -1));
		  
		  grids[6][7] = 7;
		  grids[7][7] = 7;
		  
		  assert(!stalemate.stalemate(grids, -1));
		 }
		 
		 @Test
		 void testPawnEatRightMove() {
		  int[][] grids = new int[8][8];
		  grids[1][5] = 6;
		  
		  grids[0][2] = 8;
		  grids[2][2] = 8;
		  grids[0][4] = 8;
		  grids[0][6] = 8;
		  
		  Stalemate stalemate = new Stalemate();
		  
		  assert(stalemate.stalemate(grids, 1));
		  
		  grids[1][1] = 1;
		  grids[0][1] = 1;
		  
		  assert(!stalemate.stalemate(grids, 1));
		  
		  grids[1][5] = 0;
		  grids[0][2] = 0;
		  grids[2][2] = 0;
		  grids[0][4] = 0;
		  grids[0][6] = 0;
		  grids[1][1] = 0;
		  grids[0][1] = 0;
		  
		  grids[6][5] = 12;
		  
		  grids[5][2] = 2;
		  grids[7][2] = 2;
		  grids[0][4] = 2;
		  grids[0][6] = 2;
		  
		  assert(stalemate.stalemate(grids, -1));
		  
		  grids[6][1] = 7;
		  grids[7][1] = 7;
		  
		  assert(!stalemate.stalemate(grids, -1));
		 }
		 
		 @Test
		 void testPawnEatLefttMove() {
		  int[][] grids = new int[8][8];
		  grids[1][2] = 6;
		  
		  grids[0][5] = 8;
		  grids[2][5] = 8;
		  grids[7][3] = 8;
		  grids[7][1] = 8;
		  
		  Stalemate stalemate = new Stalemate();
		  
		  assert(stalemate.stalemate(grids, 1));
		  
		  grids[1][6] = 1;
		  grids[0][6] = 1;
		  
		  assert(!stalemate.stalemate(grids, 1));
		  
		  grids[1][2] = 0;
		  grids[0][5] = 0;
		  grids[2][5] = 0;
		  grids[7][3] = 0;
		  grids[7][1] = 0;
		  grids[1][6] = 0;
		  grids[0][6] = 0;
		  
		  grids[6][2] = 12;
		  
		  grids[0][3] = 2;
		  grids[0][1] = 2;
		  grids[5][5] = 2;
		  grids[7][5] = 2;
		  
		  assert(stalemate.stalemate(grids, -1));
		  
		  grids[6][6] = 7;
		  grids[7][6] = 7;
		  
		  assert(!stalemate.stalemate(grids, -1));
		 }
		 
		 @Test
		 void testPawnEatUp() {
		  int[][] grids = new int[8][8];
		  grids[1][5] = 6;
		  
		  grids[0][2] = 8;
		  grids[2][2] = 8;
		  grids[0][4] = 8;
		  grids[0][6] = 8;
		  
		  Stalemate stalemate = new Stalemate();
		  
		  assert(stalemate.stalemate(grids, 1));
		  
		  grids[1][1] = 1;
		  grids[0][1] = 10;
		  grids[0][0] = 10;
		  
		  assert(!stalemate.stalemate(grids, 1));
		  
		  grids[1][5] = 0;
		  grids[0][2] = 0;
		  grids[2][2] = 0;
		  grids[0][4] = 0;
		  grids[0][6] = 0;
		  grids[1][1] = 0;
		  grids[0][1] = 0;
		  grids[0][0] = 0;
		  
		  grids[6][5] = 12;
		  
		  grids[5][2] = 2;
		  grids[7][2] = 2;
		  grids[0][4] = 2;
		  grids[0][6] = 2;
		  
		  assert(stalemate.stalemate(grids, -1));
		  
		  grids[6][1] = 7;
		  grids[7][1] = 4;
		  grids[7][0] = 4;
		  
		  assert(!stalemate.stalemate(grids, -1));
		 } 
		 
		 @Test
		 public void testKnightBreakStalemate() {
			int[][] grids = new int[8][8];
			Stalemate stalemate = new Stalemate();
			
			grids[4][4] = 3;
			grids[4][5] = 6;
			grids[5][0] = 8;
			grids[3][0] = 8;
			grids[0][4] = 8;
			grids[0][6] = 8;
			
			assert(stalemate.stalemate(grids, 1) == false);
		 
			grids[4][4] = 3;
			grids[4][5] = 6;
			grids[5][0] = 8;  
			grids[4][0] = 8;
			grids[3][0] = 8;
			grids[0][4] = 8;
			grids[0][6] = 8;
			
			assert(stalemate.stalemate(grids, 1) == true);
		
			grids[2][5] = 1;
			grids[1][5] = 8;
			grids[4][0] = 0;
			
			assert(stalemate.stalemate(grids, 1) == false);
		 
			grids[2][6] = 8;
			grids[3][6] = 1;
			grids[2][3] = 1;
			grids[1][3] = 8;
			grids[7][6] = 8;
			
			assert(stalemate.stalemate(grids, 1) == false);
		 
			grids[3][2] = 1;
			grids[2][2] = 8;
			grids[3][0] = 0;
			grids[3][3] = 8;
			
			assert(stalemate.stalemate(grids, 1) == false);
		
			grids[5][5] = 10;
			grids[6][5] = 1;
			
			assert(stalemate.stalemate(grids, 1) == false);
			
			grids[6][3] = 1;
			grids[5][3] = 8;
			
			assert(stalemate.stalemate(grids, 1) == false);
			
			grids[5][6] = 1;
			grids[4][6] = 10;
			
			assert(stalemate.stalemate(grids, 1) == false);
		 }
		 
		 @Test
		 public void testBishopBreakStalemate() {
			 int[][] grids = new int[8][8];
			 Stalemate stalemate = new Stalemate();
			 
			 grids[4][4] = 4;
			 grids[4][5] = 6;
			 grids[5][0] = 8;  
			 grids[4][0] = 8;
			 grids[3][0] = 8;
			 grids[0][4] = 8;
			 grids[0][6] = 8;
			 
			 assert(stalemate.stalemate(grids, 1) == true);
		
			 grids[4][0] = 0;
			 
			 assert(stalemate.stalemate(grids, 1) == false);
			 
			 grids[3][3] = 1;
			 grids[2][3] = 8;
			 grids[3][5] = 1;
			 grids[2][5] = 8;
			 
			 assert(stalemate.stalemate(grids, 1) == false);
		 }
		 
		 @Test
		 public void testRookBreakStalemate() {
			 int[][] grids = new int[8][8];
			 Stalemate stalemate = new Stalemate();
			 
			 grids[4][4] = 2;
			 grids[4][5] = 6;
			 grids[5][0] = 8;
			 grids[3][0] = 8;
			 grids[0][4] = 8;
			 grids[0][6] = 8;
			 
			 assert(stalemate.stalemate(grids, 1) == false);
			 
			 grids[4][0] = 8;
			 
			 assert(stalemate.stalemate(grids, 1) == false);
			 
			 grids[3][0] = 0;
			 grids[3][7] = 8;
			 grids[4][0] = 0;
			 grids[3][4] = 1;
			 grids[2][4] = 8;
			 grids[4][3] = 1;
			 grids[3][3] = 8;
			 
			 assert(stalemate.stalemate(grids, 1) == false);
		 
			 grids = new int[8][8];
			 
			 grids[4][0] = 8;
			 grids[6][0] = 8;
			 grids[0][4] = 8;
			 grids[4][4] = 2;
			 grids[5][3] = 6;
			 grids[1][7] = 11;
			 grids[7][4] = 8;
			 grids[0][2] = 8;
			 grids[3][4] = 1;
			 grids[2][4] = 8;
			 
			 assert(stalemate.stalemate(grids, 1) == true);
		 
			 grids[4][3] = 1;
			 grids[3][3] = 8;
			 grids[1][7] = 0;
			 grids[5][4] = 1;
			 
			 assert(stalemate.stalemate(grids, 1) == false);
			 
			 grids = new int[8][8];
			 
			 grids[0][3] = 2;
			 grids[0][4] = 2;
			 grids[0][5] = 2;
			 grids[3][0] = 2;
			 grids[5][0] = 2;
			 grids[4][7] = 2;
			 grids[3][4] = 7;
			 grids[4][4] = 12;
			 grids[4][5] = 4;
			 
			 assert(stalemate.stalemate(grids, -1) == true);
			 
			 grids[0][3] = 2;
			 grids[0][4] = 2;
			 grids[0][5] = 2;
			 grids[3][0] = 2;
			 grids[5][0] = 2;
			 grids[4][0] = 2;
			 grids[4][7] = 0;
			 grids[3][4] = 7;
			 grids[4][4] = 12;
			 grids[4][5] = 0;
			 grids[4][3] = 4;
			 
			 assert(stalemate.stalemate(grids, -1) == true);
			 
			 grids[4][5] = 4;
			 
			 assert(stalemate.stalemate(grids, -1) == true);
		 }
}

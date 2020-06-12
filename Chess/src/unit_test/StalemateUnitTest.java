package unit_test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import chess_rule.Stalemate;

class StalemateUnitTest {
	
	
	
	//============================
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
	//============================
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
	//============================
	
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
		
	}
}

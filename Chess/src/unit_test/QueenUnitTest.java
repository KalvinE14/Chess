package unit_test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import chess_piece.Queen;

class QueenUnitTest {

	@Test
	void testItIsQueen() {
		int grids[][] = new int[8][8]; 
		grids[5][0] = 5;
		grids[6][4] = 4;
		
		grids[1][5] = 11;
		
		Queen queen = new Queen();
		
		assert(queen.validateMovement(grids, 5, 0, 2, 0) == true);
		assert(queen.validateMovement(grids, 6, 4, 7, 3) == false);
		
		assert(queen.validateMovement(grids, 1, 5, 2, 6) == true);
	}
	
	@Test
	void testQueenMovementOutOfBoard() {
		int grids[][] = new int[8][8]; 
		grids[1][1] = 5;	
		
		grids[6][6] = 11;
		
		Queen queen = new Queen();
		
		assert(queen.validateMovement(grids, 1, 1, -1, 1) == false);
		assert(queen.validateMovement(grids, 1, 1, 1, -1) == false);
		
		assert(queen.validateMovement(grids, 6, 6, 8, 6) == false);
		assert(queen.validateMovement(grids, 6, 6, 6, 8) == false);
	}
	
	@Test
	void testQueenMovement() {
		int grids[][] = new int[8][8]; 
		grids[1][1] = 5;
		
		Queen queen = new Queen();
		
		assert(queen.validateMovement(grids, 1, 1, 0, 1) == true);
		assert(queen.validateMovement(grids, 1, 1, 2, 1) == true);
		assert(queen.validateMovement(grids, 1, 1, 1, 0) == true);
		assert(queen.validateMovement(grids, 1, 1, 1, 2) == true);
		assert(queen.validateMovement(grids, 1, 1, 0, 0) == true);
		assert(queen.validateMovement(grids, 1, 1, 0, 2) == true);
		assert(queen.validateMovement(grids, 1, 1, 2, 0) == true);
		assert(queen.validateMovement(grids, 1, 1, 2, 2) == true);
	}
	
	@Test
	void testQueenEatEnemyPiece() {
		int grids[][] = new int[8][8]; 
		grids[1][1] = 5;
		grids[0][1] = 7;
		grids[2][1] = 8;
		grids[1][0] = 9;
		grids[1][2] = 10;
		grids[0][0] = 11;
		grids[0][2] = 12;
		grids[2][0] = 7;
		grids[2][2] = 8;
		
		Queen queen = new Queen();
		
		assert(queen.validateMovement(grids, 1, 1, 0, 1) == true);
		assert(queen.validateMovement(grids, 1, 1, 2, 1) == true);
		assert(queen.validateMovement(grids, 1, 1, 1, 0) == true);
		assert(queen.validateMovement(grids, 1, 1, 1, 2) == true);
		assert(queen.validateMovement(grids, 1, 1, 0, 0) == true);
		assert(queen.validateMovement(grids, 1, 1, 0, 2) == true);
		assert(queen.validateMovement(grids, 1, 1, 2, 0) == true);
		assert(queen.validateMovement(grids, 1, 1, 2, 2) == true);
	}
	
	@Test
	void testQueenEatFriendlyPiece() {
		int grids[][] = new int[8][8]; 
		grids[1][1] = 5;
		grids[0][1] = 1;
		grids[2][1] = 2;
		grids[1][0] = 3;
		grids[1][2] = 4;
		grids[0][0] = 6;
		grids[0][2] = 1;
		grids[2][0] = 2;
		grids[2][2] = 3;
		
		Queen queen = new Queen();
		
		assert(queen.validateMovement(grids, 1, 1, 0, 1) == false);
		assert(queen.validateMovement(grids, 1, 1, 2, 1) == false);
		assert(queen.validateMovement(grids, 1, 1, 1, 0) == false);
		assert(queen.validateMovement(grids, 1, 1, 1, 2) == false);
		assert(queen.validateMovement(grids, 1, 1, 0, 0) == false);
		assert(queen.validateMovement(grids, 1, 1, 0, 2) == false);
		assert(queen.validateMovement(grids, 1, 1, 2, 0) == false);
		assert(queen.validateMovement(grids, 1, 1, 2, 2) == false);
	}

}

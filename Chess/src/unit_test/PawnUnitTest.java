package unit_test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import chess_piece.Pawn;

class PawnUnitTest {
	@Test
	void testItIsPawn() {
		int grids[][] = new int[8][8]; 
		grids[6][0] = 1;
		grids[6][4] = 4;
		
		grids[1][5] = 7; 
		Pawn pawn = new Pawn();
				
		assert(pawn.validateMovement(grids, 6, 0, 4, 0) == true);
		assert(pawn.validateMovement(grids, 6, 4, 5, 4) == false);
		
		assert(pawn.validateBlackMovement(grids, 1, 5, 2, 5) == true);
	}
	
	@Test
	void testPawnMovementOutOfBoard() {
		int grids[][] = new int[8][8]; 
		grids[0][0] = 1;	
		
		grids[7][0] = 7;
		Pawn pawn = new Pawn();
				
		assert(pawn.validateMovement(grids, 0, 0, -1, 0) == false);
		
		assert(pawn.validateBlackMovement(grids, 7, 0, 8, 0) == false);
	}
	
	@Test
	void testPawnFirstMovement() {
		int grids[][] = new int[8][8]; 
		grids[6][0] = 1;
		
		grids[1][0] = 7;
		
		Pawn pawn = new Pawn();	
				
		assert(pawn.validateMovement(grids, 6, 0, 5, 0) == true);
		assert(pawn.validateMovement(grids, 6, 0, 4, 0) == true);
		
		assert(pawn.validateBlackMovement(grids, 1, 0, 2, 0) == true);
		assert(pawn.validateBlackMovement(grids, 1, 0, 3, 0) == true);
	}
	
	@Test
	void testPawnAfterFirstMove() {
		int grids[][] = new int[8][8];
		grids[5][7] = 1;
		
		grids[2][1] = 7;
		
		Pawn pawn = new Pawn();	
		
		assert(pawn.validateMovement(grids, 5, 7, 3, 7) == false);
		assert(pawn.validateMovement(grids, 5, 7, 4, 7) == true);
		
		assert(pawn.validateBlackMovement(grids, 2, 1, 4, 1) == false);
		assert(pawn.validateBlackMovement(grids, 2, 1, 3, 1) == true);
	}
	
	@Test
	void testPawnEatEnemyPiece() {
		int grids[][] = new int[8][8];
		grids[5][1] = 1;
		grids[4][2] = 8;
		grids[4][0] = 7;
		
		grids[2][1] = 7;
		grids[3][0] = 1;
		grids[3][2] = 2;
		
		Pawn pawn = new Pawn();	
		
		assert(pawn.validateMovement(grids, 5, 1, 4, 2) == true);
		assert(pawn.validateMovement(grids, 5, 1, 4, 0) == true);
		
		assert(pawn.validateBlackMovement(grids, 2, 1, 3, 0) == true);
		assert(pawn.validateBlackMovement(grids, 2, 1, 3, 2) == true);
	}
	
	@Test
	void testPawnEatFriendlyPiece() {
		int grids[][] = new int[8][8];
		grids[5][1] = 1;
		grids[4][2] = 2;
		grids[4][0] = 3;
		
		grids[2][1] = 7;
		grids[3][0] = 8;
		grids[3][2] = 9;
		
		Pawn pawn = new Pawn();	
		
		assert(pawn.validateMovement(grids, 5, 1, 4, 2) == false);
		assert(pawn.validateMovement(grids, 5, 1, 4, 0) == false);
		
		assert(pawn.validateBlackMovement(grids, 2, 1, 3, 0) == false);
		assert(pawn.validateBlackMovement(grids, 2, 1, 3, 2) == false);
	}

}

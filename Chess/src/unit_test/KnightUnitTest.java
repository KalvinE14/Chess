package unit_test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import chess_piece.Knight;

class KnightUnitTest {

	@Test
	void testItIsKnight() {
		int grids[][] = new int[8][8]; 
		grids[5][0] = 3;
		grids[6][4] = 4;
		
		grids[1][5] = 9;
		
		Knight knight= new Knight();
				
		assert(knight.validateMovement(grids, 5, 0, 3, 1) == true);
		assert(knight.validateMovement(grids, 6, 4, 4, 3) == false);
		
		assert(knight.validateMovement(grids, 1, 5, 3, 6) == true);
	}
	
	@Test
	void testKnightMovementOutOfBoard() {
		int grids[][] = new int[8][8]; 
		grids[1][1] = 3;	
		
		grids[6][6] = 9;
		
		Knight knight= new Knight();
				
		assert(knight.validateMovement(grids, 1, 1, -1, 1) == false);
		
		assert(knight.validateMovement(grids, 6, 6, 8, 7) == false);
	}
	
	@Test
	void testKnightMovement() {
		int grids[][] = new int[8][8]; 
		grids[6][5] = 3;	
		
		grids[1][2] = 9;
		
		Knight knight= new Knight();
				
		assert(knight.validateMovement(grids, 6, 5, 4, 4) == true);
		assert(knight.validateMovement(grids, 6, 5, 4, 6) == true);
		assert(knight.validateMovement(grids, 6, 5, 5, 3) == true);
		assert(knight.validateMovement(grids, 6, 5, 5, 7) == true);
		
		assert(knight.validateMovement(grids, 1, 2, 3, 1) == true);
		assert(knight.validateMovement(grids, 1, 2, 3, 3) == true);
		assert(knight.validateMovement(grids, 1, 2, 2, 0) == true);
		assert(knight.validateMovement(grids, 1, 2, 2, 4) == true);
	}
	
	@Test
	void testKnightEatEnemyPiece() {
		int grids[][] = new int[8][8]; 
		grids[6][5] = 3;	
		grids[4][4] = 7;
		grids[4][6] = 8;
		grids[5][3] = 11;
		grids[5][7] = 9;
		
		grids[1][2] = 9;
		grids[3][1] = 1;
		grids[3][3] = 3;
		grids[2][0] = 5;
		grids[2][4] = 4;
		
		Knight knight= new Knight();
				
		assert(knight.validateMovement(grids, 6, 5, 4, 4) == true);
		assert(knight.validateMovement(grids, 6, 5, 4, 6) == true);
		assert(knight.validateMovement(grids, 6, 5, 5, 3) == true);
		assert(knight.validateMovement(grids, 6, 5, 5, 7) == true);
		
		assert(knight.validateMovement(grids, 1, 2, 3, 1) == true);
		assert(knight.validateMovement(grids, 1, 2, 3, 3) == true);
		assert(knight.validateMovement(grids, 1, 2, 2, 0) == true);
		assert(knight.validateMovement(grids, 1, 2, 2, 4) == true);
	}
	
	@Test
	void testKnightEatFriendlyPiece() {
		int grids[][] = new int[8][8]; 
		grids[6][5] = 3;	
		grids[4][4] = 1;
		grids[4][6] = 2;
		grids[5][3] = 3;
		grids[5][7] = 6;
		
		grids[1][2] = 9;
		grids[3][1] = 10;
		grids[3][3] = 7;
		grids[2][0] = 8;
		grids[2][4] = 12;
		
		Knight knight= new Knight();
				
		assert(knight.validateMovement(grids, 6, 5, 4, 4) == false);
		assert(knight.validateMovement(grids, 6, 5, 4, 6) == false);
		assert(knight.validateMovement(grids, 6, 5, 5, 3) == false);
		assert(knight.validateMovement(grids, 6, 5, 5, 7) == false);
		
		assert(knight.validateMovement(grids, 1, 2, 3, 1) == false);
		assert(knight.validateMovement(grids, 1, 2, 3, 3) == false);
		assert(knight.validateMovement(grids, 1, 2, 2, 0) == false);
		assert(knight.validateMovement(grids, 1, 2, 2, 4) == false);
	}

}

package unit_test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import chess_piece.King;

class KingUnitTest {

	@Test
	public void testKingMovement() {
		King king = new King();
		int[][] grids = new int[8][8];
		
		grids[3][4] = 6;
		
		grids[2][3] = 7;
		grids[2][4] = 7;
		grids[2][5] = 7;
		grids[3][5] = 7;
		grids[3][3] = 7;
		grids[4][3] = 7;
		grids[4][4] = 7;
		grids[4][5] = 7;
		
		assert(king.validateMovement(grids, 3, 4, 2, 3) == true);
		assert(king.validateMovement(grids, 3, 4, 2, 4) == true);
		assert(king.validateMovement(grids, 3, 4, 2, 5) == true);
		assert(king.validateMovement(grids, 3, 4, 3, 5) == true);
		assert(king.validateMovement(grids, 3, 4, 3, 3) == true);
		assert(king.validateMovement(grids, 3, 4, 4, 3) == true);
		assert(king.validateMovement(grids, 3, 4, 4, 4) == true);
		assert(king.validateMovement(grids, 3, 4, 4, 5) == true);
	}
	
	@Test
	public void testKingEatOwnPiece() {
		King king = new King();
		int[][] grids = new int[8][8];
		
		grids[3][4] = 6;
		grids[2][3] = 1;
		
		assert(king.validateMovement(grids, 3, 4, 2, 3) == false);
	}
	
	@Test
	public void testKingOrNot() {
		King king = new King();
		int[][] grids = new int[8][8];
		
		grids[3][4] = 2;
		grids[2][3] = 7;
		
		assert(king.validateMovement(grids, 3, 4, 2, 3) == false);
	}
	
	@Test
	public void kingOutOfBoard() {
		King king = new King();
		int[][] grids = new int[8][8];
		
		grids[7][7] = 6;
		
		assert(king.validateMovement(grids, 7, 7, 8, 8) == false);
		assert(king.validateMovement(grids, 7, 7, 7, 8) == false);
		assert(king.validateMovement(grids, 7, 7, 8, 7) == false);
	}

}

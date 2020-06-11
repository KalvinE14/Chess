package unit_test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import chess_piece.Bishop;

class BishopUnitTest {
	
	
	@Test
	public void testBishopMovement() {
		Bishop bishop = new Bishop();
		int[][] grids = new int[8][8];
		
		grids[3][4] = 4;
		grids[0][7] = 7;
		grids[6][7] = 7;
		grids[7][0] = 7;
		grids[0][1] = 7;
		
		assert(bishop.validateMovement(grids, 3, 4, 0, 7) == true);
		assert(bishop.validateMovement(grids, 3, 4, 6, 7) == true);
		assert(bishop.validateMovement(grids, 3, 4, 7, 0) == true);
		assert(bishop.validateMovement(grids, 3, 4, 0, 1) == true);
	}
	
	@Test
	public void testBishopEatOwnPiece() {
		Bishop bishop = new Bishop();
		int[][] grids = new int[8][8];
		
		grids[3][4] = 4;
		grids[0][7] = 1;
		
		assert(bishop.validateMovement(grids, 3, 4, 0, 7) == false);
	}
	
	@Test
	public void testBishopOrNot() {
		Bishop bishop = new Bishop();
		int[][] grids = new int[8][8];
		
		grids[3][4] = 2;
		grids[0][7] = 7;
		
		assert(bishop.validateMovement(grids, 3, 4, 0, 7) == false);
	}
	
	@Test
	public void testBishopHitAnotherPiece() {
		Bishop bishop = new Bishop();
		int[][] grids = new int[8][8];
		
		grids[3][4] = 4;
		grids[2][5] = 2;
		grids[0][7] = 7;
		
		assert(bishop.validateMovement(grids, 3, 4, 0, 7) == false);
		
		grids[2][5] = 0;
		
		assert(bishop.validateMovement(grids, 3, 4, 0, 7) == true);
	}
	
	@Test
	public void testBishopOutOfBoard() {
		Bishop bishop = new Bishop();
		int[][] grids = new int[8][8];
		
		grids[3][4] = 4;
		
		assert(bishop.validateMovement(grids, 3, 4, -1, 8) == false);
		assert(bishop.validateMovement(grids, 3, 4, 8, -1) == false);
	}
}

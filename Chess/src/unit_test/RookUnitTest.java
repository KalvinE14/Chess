package unit_test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import chess_piece.Bishop;
import chess_piece.Rook;

class RookUnitTest {

	@Test
	public void testRookMovement() {
		Rook rook = new Rook();
		int[][] grids = new int[8][8];
		
		grids[3][4] = 2;
		grids[7][4] = 7;
		grids[3][7] = 7;
		grids[3][0] = 7;
		grids[0][4] = 7;
		
		assert(rook.validateMovement(grids, 3, 4, 7, 4) == true);
		assert(rook.validateMovement(grids, 3, 4, 3, 7) == true);
		assert(rook.validateMovement(grids, 3, 4, 3, 0) == true);
		assert(rook.validateMovement(grids, 3, 4, 0, 4) == true);
	}
	
	@Test
	public void testRookEatOwnPiece() {
		Rook rook = new Rook();
		int[][] grids = new int[8][8];
		
		grids[3][4] = 2;
		grids[7][4] = 4;
		
		assert(rook.validateMovement(grids, 3, 4, 7, 4) == false);
	}
	
	@Test
	public void rookOrNot() {
		Rook rook = new Rook();
		int[][] grids = new int[8][8];
		
		grids[3][4] = 4;
		grids[7][4] = 7;
		
		assert(rook.validateMovement(grids, 3, 4, 7, 4) == false);
		
		grids[3][4] = 8;
		grids[7][4] = 1;
		
		assert(rook.validateMovement(grids, 3, 4, 7, 4) == true);
	}
	
	@Test
	public void testRookHitAnotherPiece() {
		Rook rook = new Rook();
		int[][] grids = new int[8][8];
		
		grids[3][4] = 2;
		grids[4][4] = 4;
		grids[7][4] = 7;
		
		assert(rook.validateMovement(grids, 3, 4, 7, 4) == false);
		
		grids[4][4] = 0;
		
		assert(rook.validateMovement(grids, 3, 4, 7, 4) == true);
	}
	
	@Test
	public void testRookOutOfBoard() {
		Rook rook = new Rook();
		int[][] grids = new int[8][8];
		
		grids[3][4] = 2;
		
		assert(rook.validateMovement(grids, 3, 4, 8, 4) == false);
		assert(rook.validateMovement(grids, 3, 4, 3, -1) == false);
	}
}

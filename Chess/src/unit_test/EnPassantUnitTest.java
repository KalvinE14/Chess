package unit_test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import chess_rule.EnPassant;

class EnPassantUnitTest {

	@Test
	void testEnPassantWhite() {
		int[][] grids = new int[8][8];
		grids[3][3] = 7;
		
		grids[3][4] = 1;
		grids[3][2] = 1;
		
		EnPassant ep = new EnPassant();
		
		assert(ep.enPassantWhite(true, grids, 3, 4, 2, 3, 3, 3));
		assert(ep.enPassantWhite(true, grids, 3, 2, 2, 3, 3, 3));
	}
	
	@Test
	void testFalseEnPassantWhite() {
		int[][] grids = new int[8][8];
		grids[3][3] = 7;
		
		grids[3][4] = 1;
		grids[6][1] = 1;
		
		EnPassant ep = new EnPassant();
		
		assert(!ep.enPassantWhite(false, grids, 3, 4, 2, 3, 3, 3));
		assert(!ep.enPassantWhite(true, grids, 3, 4, 2, 5, 3, 3));
		assert(!ep.enPassantWhite(true, grids, 6, 1, 5, 0, 3, 3));
	}
	
	@Test
	void testEnPassantBlack() {
		int[][] grids = new int[8][8];
		grids[4][3] = 1;
		
		grids[4][2] = 7;
		grids[4][4] = 7;
		
		EnPassant ep = new EnPassant();
		
		assert(ep.enPassantBlack(true, grids, 4, 2, 5, 3, 4, 3));
		assert(ep.enPassantBlack(true, grids, 4, 4, 5, 3, 4, 3));
	}
	
	@Test
	void testFalseEnPassantBlack() {
		int[][] grids = new int[8][8];
		grids[4][3] = 1;
		
		grids[4][4] = 7;
		grids[1][7] = 7;
		
		EnPassant ep = new EnPassant();
		
		assert(!ep.enPassantBlack(false, grids, 4, 4, 5, 3, 4, 3));
		assert(!ep.enPassantBlack(true, grids, 4, 4, 5, 5, 4, 3));
		assert(!ep.enPassantBlack(true, grids, 1, 7, 2, 6, 4, 3));
		
	}

}

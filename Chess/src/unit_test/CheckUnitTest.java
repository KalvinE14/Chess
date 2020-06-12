package unit_test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import chess_rule.Check;

class CheckUnitTest {

	Check check = new Check();

	@Test
	public void testRookPath() {
		int[][] grids = new int[8][8];
	
		grids[3][4] = 2;
		
		grids[0][4] = 12;
		grids[3][6] = 4;
		grids[3][1] = 7;
		
		assert(check.validateRookPath(1, grids, 3, 4) == true);
		
		grids[0][4] = 0;
		grids[0][3] = 12;
		
		assert(check.validateRookPath(1, grids, 3, 4) == false);
		
		grids[3][4] = 8;
		
		grids[0][4] = 6;
		grids[3][6] = 10;
		grids[3][1] = 1;
		
		assert(check.validateRookPath(-1, grids, 3, 4) == true);
		
		grids[0][4] = 0;
		grids[0][3] = 6;
		
		assert(check.validateRookPath(-1, grids, 3, 4) == false);
	}

	@Test
	public void testBishopPath() {
		int[][] grids = new int[8][8];
		
		grids[3][4] = 4;
		
		grids[6][7] = 12;
		grids[0][1] = 1;
		grids[0][7] = 2;
		
		assert(check.validateBishopPath(1, grids, 3, 4) == true);
		
		grids[6][7] = 0;
		grids[5][7] = 12;
		
		assert(check.validateBishopPath(1, grids, 3, 4) == false);
		
		grids[3][4] = 10;
		
		grids[6][7] = 6;
		grids[0][1] = 7;
		grids[0][7] = 8;
		
		assert(check.validateBishopPath(-1, grids, 3, 4) == true);
		
		grids[6][7] = 0;
		grids[5][7] = 6;
		
		assert(check.validateBishopPath(-1, grids, 3, 4) == false);
	}
	
	@Test
	public void testQueenPath() {
		int[][] grids = new int[8][8];
		
		grids[3][4] = 5;
		
		grids[6][7] = 12;
		grids[0][4] = 1;
		grids[3][0] = 7;
		
		assert(check.validateQueenPath(1, grids, 3, 4) == true);
		
		grids[6][7] = 0;
		grids[5][7] = 12;
		
		assert(check.validateQueenPath(1, grids, 3, 4) == false);
		
		grids[3][4] = 11;
		
		grids[6][7] = 6;
		grids[0][4] = 7;
		grids[3][0] = 1;
		
		assert(check.validateQueenPath(-1, grids, 3, 4) == true);
		
		grids[6][7] = 0;
		grids[5][7] = 6;
	
		assert(check.validateQueenPath(1, grids, 3, 4) == false);
	}
	
	@Test
	public void testPawnPath() {
		int[][] grids = new int[8][8];
		
		grids[3][4] = 1;
		grids[2][3] = 12;
		
		assert(check.validatePawnPath(1, grids, 3, 4) == true);
		
		grids[2][3] = 0;
		grids[2][5] = 12;
		
		assert(check.validatePawnPath(1, grids, 3, 4) == true);
		
		grids[3][4] = 7;
		grids[2][5] = 0;
		grids[4][5] = 6;
		
		assert(check.validatePawnPath(-1, grids, 3, 4) == true);
		
		grids[4][5] = 0;
		grids[4][3] = 6;
	
		assert(check.validatePawnPath(-1, grids, 3, 4) == true);
		
		grids[4][3] = 0;
		
		assert(check.validatePawnPath(1, grids, 3, 4) == false);
	}
	
	@Test
	public void testKingPath() {
		int[][] grids = new int[8][8];
		
		grids[3][4] = 6;
		grids[4][5] = 12;
	
		assert(check.validateKingPath(1, grids, 3, 4) == true);
		
		grids[3][4] = 12;
		grids[4][5] = 6;
	 
		assert(check.validateKingPath(-1, grids, 3, 4) == true);
		
		grids[4][5] = 0;
		grids[1][2] = 6;
		
		assert(check.validateKingPath(-1, grids, 3, 4) == false);
	}
	 
	@Test
	public void testKnightPath() {
		int[][] grids = new int[8][8];
		
		grids[3][4] = 3;
		grids[1][5] = 4;
		grids[4][6] = 12;
		
		assert(check.validateKnightPath(1, grids, 3, 4) == true);
		
		grids[3][4] = 9;
		grids[4][6] = 6;
		
		assert(check.validateKnightPath(-1, grids, 3, 4) == true);
		
		grids[4][6] = 0;
		
		assert(check.validateKnightPath(1, grids, 3, 4) == false);
	}
	
	@Test
	public void testValidateCheck() {
		int[][] grids = new int[8][8];
		
		grids[3][4] = 1;
		grids[2][3] = 12;
		
		assert(check.validateCheck(grids, 1) == true);
		
		grids[3][4] = 2;
		grids[2][3] = 0;
		grids[7][4] = 12;
		
		assert(check.validateCheck(grids, 1) == true);
		
		grids[3][4] = 3;
		grids[7][4] = 0;
		grids[4][6] = 12;
		
		assert(check.validateCheck(grids, 1) == true);
		
		grids[3][4] = 4;
		grids[4][6] = 0;
		grids[6][7] = 12;
		
		assert(check.validateCheck(grids, 1) == true);
		
		grids[3][4] = 5;
		grids[6][7] = 0;
		grids[1][2] = 12;
		
		assert(check.validateCheck(grids, 1) == true);
		
		grids[3][4] = 6;
		grids[1][2] = 0;
		grids[2][5] = 12;
		
		assert(check.validateCheck(grids, 1) == true);
		
		
		grids[3][4] = 7;
		grids[4][5] = 6;
		
		assert(check.validateCheck(grids, -1) == true);
		
		grids[3][4] = 8;
		grids[4][5] = 0;
		grids[7][4] = 6;
		
		assert(check.validateCheck(grids, -1) == true);
		
		grids[3][4] = 9;
		grids[7][4] = 0;
		grids[4][6] = 6;
		
		assert(check.validateCheck(grids, -1) == true);
		
		grids[3][4] = 10;
		grids[4][6] = 0;
		grids[6][7] = 6;
		
		assert(check.validateCheck(grids, -1) == true);
		 
		grids[3][4] = 11;
		grids[6][7] = 0;
		grids[1][2] = 6;
		
		assert(check.validateCheck(grids, -1) == true);
		
		grids[3][4] = 12;
		grids[1][2] = 0;
		grids[2][5] = 6;
		
		assert(check.validateCheck(grids, -1) == true);
		
		grids[2][5] = 0;
		grids[3][4] = 11;
		grids[3][3] = 2;
		grids[4][0] = 12;
		grids[4][7] = 6;
		
		assert(check.validateCheck(grids, -1) == false);
	}
}

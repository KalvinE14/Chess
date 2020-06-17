package unit_test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import chess_rule.InvalidMove;

class InvalidMoveUnitTest {
	
	InvalidMove invalid = new InvalidMove();
	
	@Test
	public void testInvalidMove() {
		int[][] grids = new int[8][8];
		
		grids[3][4] = 1;
		grids[2][3] = 12;
		
		assert(invalid.validateInvalidMove(grids, -1) == true);
		
		grids[3][4] = 2;
		grids[2][3] = 0;
		grids[7][4] = 12;
		
		assert(invalid.validateInvalidMove(grids, -1) == true);
		
		grids[3][4] = 3;
		grids[7][4] = 0;
		grids[4][6] = 12;
		
		assert(invalid.validateInvalidMove(grids, -1) == true);
		
		grids[3][4] = 4;
		grids[4][6] = 0;
		grids[6][7] = 12;
		
		assert(invalid.validateInvalidMove(grids, -1) == true);
		
		grids[3][4] = 5;
		grids[6][7] = 0;
		grids[1][2] = 12;
		
		assert(invalid.validateInvalidMove(grids, -1) == true);
		
		grids[3][4] = 6;
		grids[1][2] = 0;
		grids[2][5] = 12;
		
		assert(invalid.validateInvalidMove(grids, -1) == true);
		
		
		grids[3][4] = 7;
		grids[4][5] = 6;
		
		assert(invalid.validateInvalidMove(grids, 1) == true);
		
		grids[3][4] = 8;
		grids[4][5] = 0;
		grids[7][4] = 6;
		
		assert(invalid.validateInvalidMove(grids, 1) == true);
		
		grids[3][4] = 9;
		grids[7][4] = 0;
		grids[4][6] = 6;
		
		assert(invalid.validateInvalidMove(grids, 1) == true);
		
		grids[3][4] = 10;
		grids[4][6] = 0;
		grids[6][7] = 6;
		
		assert(invalid.validateInvalidMove(grids, 1) == true);
		 
		grids[3][4] = 11;
		grids[6][7] = 0;
		grids[1][2] = 6;
		
		assert(invalid.validateInvalidMove(grids, 1) == true);
		
		grids[3][4] = 12;
		grids[1][2] = 0;
		grids[2][5] = 6;
		
		assert(invalid.validateInvalidMove(grids, 1) == true);
		
		grids[2][5] = 0;
		grids[3][4] = 11;
		grids[3][3] = 2;
		grids[4][0] = 12;
		grids[4][7] = 6;
		
		assert(invalid.validateInvalidMove(grids, 1) == false);
	}

}

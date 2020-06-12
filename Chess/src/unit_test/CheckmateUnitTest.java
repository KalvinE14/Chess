package unit_test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import chess_rule.Checkmate;

class CheckmateUnitTest {

	@Test
	void testMoveKing() {
		int[][] grids = new int[8][8];
		grids[1][1] = 6;
		
		Checkmate cm = new Checkmate();
		
		cm.moveKing(grids, 1, 1, 1, 0);
		
		assert(grids[1][0] == 6);
		assert(grids[1][1] != 6);
	}
	
	@Test
	void testFindXAndYKing() {
		int[][] grids = new int[8][8];
		grids[1][2] = 6;
		grids[5][3] = 12;
		
		Checkmate cm = new Checkmate();
		
		int xWhiteKing = cm.findXKing(grids, 1);
		int yWhiteKing = cm.findYKing(grids, 1);
		
		int xBlackKing = cm.findXKing(grids, -1);
		int yBlackKing = cm.findYKing(grids, -1);
		
		int xNotWhiteOrBlackKing = cm.findXKing(grids, 2);
		int yNotWhiteOrBlackKing = cm.findYKing(grids, 2);
		
		assert(xWhiteKing == 1);
		assert(yWhiteKing == 2);
		assert(xBlackKing == 5);
		assert(yBlackKing == 3);
		assert(xNotWhiteOrBlackKing == 0);
		assert(yNotWhiteOrBlackKing == 0);
	}
	
	@Test
	void testKingAvailableMoveChecked() {
		int[][] grids = new int[8][8];
		grids[2][2] = 6;
		grids[5][3] = 12;
		
		Checkmate cm = new Checkmate();
		
		int numberWhiteChecked = cm.isKingAvailableMoveChecked(grids, 1);
		int numberBlackChecked = cm.isKingAvailableMoveChecked(grids, -1);
		
		assert(numberWhiteChecked == 0);
		assert(numberBlackChecked == 0);
		
		grids[1][4] = 8;
		grids[7][1] = 8;
		grids[7][3] = 8;
		grids[3][7] = 8;
		
		numberWhiteChecked = cm.isKingAvailableMoveChecked(grids, 1);
		
		assert(numberWhiteChecked == 8);
		
		grids[2][2] = 0;
		grids[1][4] = 0;
		grids[7][1] = 0;
		grids[7][3] = 0;
		grids[3][7] = 0;
		
		grids[0][0] = 6;
		
		numberWhiteChecked = cm.isKingAvailableMoveChecked(grids, 1);
		assert(numberWhiteChecked == 5);
		
		grids[0][0] = 0;
		grids[5][3] = 0;
		
		grids[7][7] = 12;
		
		numberBlackChecked = cm.isKingAvailableMoveChecked(grids, -1);
		assert(numberBlackChecked == 5);
		
		grids[7][7] = 0;
		
		grids[3][3] = 6;
		grids[2][2] = 2;
		grids[2][3] = 2;
		grids[2][4] = 1;
		grids[3][4] = 1;
		grids[4][4] = 1;
		grids[4][3] = 1;
		grids[4][2] = 1;
		grids[3][2] = 1;
		
		numberWhiteChecked = cm.isKingAvailableMoveChecked(grids, 1);
		assert(numberWhiteChecked == 8);
	}
	
	@Test
	void testCheckmate() {
		int[][] grids = new int[8][8];
		grids[2][2] = 6;
		grids[2][7] = 11;
		
		Checkmate cm = new Checkmate();
		
		assert(!cm.checkmate(grids, 1, 2, 7));
		
		grids[1][4] = 8;
		grids[7][1] = 8;
		grids[7][3] = 8;
		grids[3][7] = 8;
		assert(cm.checkmate(grids, 1, 2, 7));
		
		grids[3][5] = 2;
		assert(!cm.checkmate(grids, 1, 2, 7));
		assert(cm.canRookSaveKing(1, grids, 3, 5, 2, 7));
		
		grids[3][5] = 0;
		grids[1][5] = 2;
		assert(!cm.checkmate(grids, 1, 2, 7));
		assert(cm.canRookSaveKing(1, grids, 1, 5, 2, 7));
		
		grids[1][5] = 0;
		grids[1][7] = 2;
		assert(!cm.checkmate(grids, 1, 2, 7));
		assert(cm.canRookSaveKing(1, grids, 1, 7, 2, 7));
		
		grids[1][7] = 0;
		grids[3][7] = 2;
		assert(!cm.checkmate(grids, 1, 2, 7));
		assert(cm.canRookSaveKing(1, grids, 3, 7, 2, 7));
		
		grids[3][7] = 0;
		
		grids[3][6] = 1;
		assert(!cm.checkmate(grids, 1, 2, 7));
		assert(cm.canPawnSaveKing(1, grids, 3, 6, 2, 7));
		
		grids[3][6] = 0;
		grids[3][5] = 5;
		assert(!cm.checkmate(grids, 1, 2, 7));
		assert(cm.canQueenSaveKing(1, grids, 3, 5, 2, 7));
		
		grids[3][5] = 0;
		grids[3][4] = 4;
		assert(!cm.checkmate(grids, 1, 2, 7));
		assert(cm.canBishopSaveKing(1, grids, 3, 4, 2, 7));
		
		grids[3][4] = 0;
		grids[4][7] = 4;
		assert(!cm.checkmate(grids, 1, 2, 7));
		assert(cm.canBishopSaveKing(1, grids, 4, 7, 2, 7));
		
		grids[4][7] = 0;
		grids[3][6] = 4;
		assert(!cm.checkmate(grids, 1, 2, 7));
		assert(cm.canBishopSaveKing(1, grids, 4, 6, 2, 7));
		
		grids[4][4] = 3;
		assert(!cm.checkmate(grids, 1, 2, 7));
		assert(cm.canKnightSaveKing(1, grids, 4, 4, 2, 7));
		
		grids[4][4] = 0;
		grids[3][5] = 3;
		assert(!cm.checkmate(grids, 1, 2, 7));
		assert(cm.canKnightSaveKing(1, grids, 3, 5, 2, 7));
		
		grids[3][5] = 0;
		grids[4][6] = 3;
		assert(!cm.checkmate(grids, 1, 2, 7));
		assert(cm.canKnightSaveKing(1, grids, 4, 6, 2, 7));
		
		grids[4][6] = 0;
		grids[0][6] = 3;
		assert(!cm.checkmate(grids, 1, 2, 7));
		assert(cm.canKnightSaveKing(1, grids, 0, 6, 2, 7));
		
		grids[0][6] = 0;
		grids[1][5] = 3;
		assert(!cm.checkmate(grids, 1, 2, 7));
		assert(cm.canKnightSaveKing(1, grids, 1, 5, 2, 7));
		
		grids[1][5] = 0;
		grids[0][4] = 3;
		assert(!cm.checkmate(grids, 1, 2, 7));
		assert(cm.canKnightSaveKing(1, grids, 0, 4, 2, 7));
		
		grids[0][4] = 0;
		grids[1][3] = 3;
		assert(!cm.checkmate(grids, 1, 2, 7));
		assert(cm.canKnightSaveKing(1, grids, 1, 3, 2, 7));
		
		grids[1][3] = 0;
		grids[1][7] = 3;
		assert(!cm.checkmate(grids, 1, 2, 7));
		assert(cm.canKnightSaveKing(1, grids, 1, 7, 2, 7));
		
		grids[1][7] = 0;
		grids[3][7] = 3;
		assert(!cm.checkmate(grids, 1, 2, 7));
		assert(cm.canKnightSaveKing(1, grids, 3, 7, 2, 7));
		
	}
	
	@Test
	void testMoveAndReturnPieces() {
		int[][] grids = new int[8][8];
		grids[1][1] = 6;
		
		Checkmate cm = new Checkmate();
		
		cm.moveKing(grids, 1, 1, 1, 0);
		cm.returnGridsToNormal(grids, 1, 1, 1, 0);
		
		assert(grids[1][1] == 6);
		assert(grids[1][0] != 6);
	}
}

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
		
		assert(numberWhiteChecked == 7);
		
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
	void testWhiteCheckmateBlack() {
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
		grids[3][5] = 5;
		assert(!cm.checkmate(grids, 1, 2, 7));
		assert(cm.canQueenSaveKing(1, grids, 3, 5, 2, 7));
		
		grids[3][5] = 0;
		grids[0][7] = 5;
		assert(!cm.checkmate(grids, 1, 2, 7));
		assert(cm.canQueenSaveKing(1, grids, 0, 7, 2, 7));
		
		grids[0][7] = 0;
		grids[0][5] = 5;
		grids[1][5] = 1;
		assert(!cm.checkmate(grids, 1, 2, 7));
		assert(cm.canQueenSaveKing(1, grids, 0, 5, 2, 7));
		
		grids[0][5] = 0;
		grids[1][5] = 0;
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
		assert(cm.canBishopSaveKing(1, grids, 3, 6, 2, 7));
		
		
		grids[3][6] = 0;
		grids[0][7] = 4;
		assert(!cm.checkmate(grids, 1, 2, 7));
		assert(cm.canBishopSaveKing(1, grids, 0, 7, 2, 7));
		
		grids[0][7] = 0;
		grids[0][2] = 4;
		assert(!cm.checkmate(grids, 1, 2, 7));
		assert(cm.canBishopSaveKing(1, grids, 0, 2, 2, 7));
		
		
		grids[0][2] = 0;
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
		grids[3][6] = 1;
		assert(!cm.checkmate(grids, 1, 2, 7));
		assert(cm.canPawnSaveKing(1, grids, 3, 6, 2, 7));
		
		grids[3][6] = 0;
		grids[3][5] = 1;
		assert(!cm.checkmate(grids, 1, 2, 7));
		assert(cm.canPawnSaveKing(1, grids, 3, 5, 2, 7));
		
		grids[3][5] = 0;
		grids[4][0] = 5;
		assert(cm.checkmate(grids, 1, 2, 7));
		assert(!cm.canQueenSaveKing(1, grids, 4, 0, 2, 7));
		
		grids[4][0] = 0;
		grids[4][3] = 3;
		assert(!cm.checkmate(grids, 1, 2, 7));
		assert(cm.canKnightSaveKing(1, grids, 4, 3, 2, 7));
		
		grids[4][0] = 0;
		grids[0][7] = 3;
		assert(!cm.checkmate(grids, 1, 2, 7));
		assert(cm.canKnightSaveKing(1, grids, 0, 7, 2, 7));
	}
	
	@Test
	void testBlackCheckmateWhite() {
		int[][] grids = new int[8][8];
		grids[2][2] = 12;
		grids[2][7] = 5;
		
		Checkmate cm = new Checkmate();
		
		assert(!cm.checkmate(grids, -1, 2, 7));
		
		grids[1][4] = 2;
		grids[7][1] = 2;
		grids[7][3] = 2;
		grids[3][7] = 2;
		assert(cm.checkmate(grids, -1, 2, 7));
		
		grids[3][5] = 8;
		assert(!cm.checkmate(grids, -1, 2, 7));
		assert(cm.canRookSaveKing(-1, grids, 3, 5, 2, 7));
		
		grids[3][5] = 0;
		grids[1][5] = 8;
		assert(!cm.checkmate(grids, -1, 2, 7));
		assert(cm.canRookSaveKing(-1, grids, 1, 5, 2, 7));
		
		grids[1][5] = 0;
		grids[1][7] = 8;
		assert(!cm.checkmate(grids, -1, 2, 7));
		assert(cm.canRookSaveKing(-1, grids, 1, 7, 2, 7));
		
		grids[1][7] = 0;
		grids[3][5] = 11;
		assert(!cm.checkmate(grids, -1, 2, 7));
		assert(cm.canQueenSaveKing(-1, grids, 3, 5, 2, 7));
		
		grids[3][5] = 0;
		grids[3][4] = 10;
		assert(!cm.checkmate(grids, -1, 2, 7));
		assert(cm.canBishopSaveKing(-1, grids, 3, 4, 2, 7));
		
		grids[3][4] = 0;
		grids[4][7] = 10;
		assert(!cm.checkmate(grids, -1, 2, 7));
		assert(cm.canBishopSaveKing(-1, grids, 4, 7, 2, 7));
		
		grids[4][7] = 0;
		grids[3][6] = 10;
		assert(!cm.checkmate(grids, -1, 2, 7));
		assert(cm.canBishopSaveKing(-1, grids, 3, 6, 2, 7));
		
		grids[3][6] = 0;
		grids[0][7] = 10;
		assert(!cm.checkmate(grids, -1, 2, 7));
		assert(cm.canBishopSaveKing(-1, grids, 0, 7, 2, 7));
		
		grids[0][7] = 0;
		grids[0][2] = 10;
		assert(!cm.checkmate(grids, -1, 2, 7));
		assert(cm.canBishopSaveKing(-1, grids, 0, 2, 2, 7));
		
		
		grids[0][2] = 0;
		grids[4][4] = 9;
		assert(!cm.checkmate(grids, -1, 2, 7));
		assert(cm.canKnightSaveKing(-1, grids, 4, 4, 2, 7));
		
		grids[4][4] = 0;
		grids[3][5] = 9;
		assert(!cm.checkmate(grids, -1, 2, 7));
		assert(cm.canKnightSaveKing(-1, grids, 3, 5, 2, 7));
		
		grids[3][5] = 0;
		grids[4][6] = 9;
		assert(!cm.checkmate(grids, -1, 2, 7));
		assert(cm.canKnightSaveKing(-1, grids, 4, 6, 2, 7));
		
		grids[4][6] = 0;
		grids[0][6] = 9;
		assert(!cm.checkmate(grids, -1, 2, 7));
		assert(cm.canKnightSaveKing(-1, grids, 0, 6, 2, 7));
		
		grids[0][6] = 0;
		grids[1][5] = 9;
		assert(!cm.checkmate(grids, -1, 2, 7));
		assert(cm.canKnightSaveKing(-1, grids, 1, 5, 2, 7));
		
		grids[1][5] = 0;
		grids[0][4] = 9;
		assert(!cm.checkmate(grids, -1, 2, 7));
		assert(cm.canKnightSaveKing(-1, grids, 0, 4, 2, 7));
		
		grids[0][4] = 0;
		grids[1][3] = 9;
		assert(!cm.checkmate(grids, -1, 2, 7));
		assert(cm.canKnightSaveKing(-1, grids, 1, 3, 2, 7));
		
		grids[1][3] = 0;
		grids[1][7] = 9;
		assert(!cm.checkmate(grids, -1, 2, 7));
		assert(cm.canKnightSaveKing(-1, grids, 1, 7, 2, 7));
		
		grids[1][7] = 0;
		grids[1][6] = 7;
		assert(!cm.checkmate(grids, -1, 2, 7));
		assert(cm.canPawnSaveKing(-1, grids, 1, 6, 2, 7));
		
		grids[1][6] = 0;
		grids[1][5] = 7;
		assert(!cm.checkmate(grids, -1, 2, 7));
		assert(cm.canPawnSaveKing(-1, grids, 1, 5, 2, 7));
		
		grids[1][5] = 0;
		grids[7][5] = 11;
		assert(!cm.checkmate(grids, -1, 2, 7));
		assert(cm.canQueenSaveKing(-1, grids, 7, 5, 2, 7));
		
		grids[7][5] = 0;
		grids[7][5] = 11;
		assert(!cm.checkmate(grids, -1, 2, 7));
		assert(cm.canQueenSaveKing(-1, grids, 7, 5, 2, 7));
		
		grids[7][5] = 0;
		grids[0][5] = 11;
		grids[1][5] = 7;
		assert(!cm.checkmate(grids, -1, 2, 7));
		assert(cm.canQueenSaveKing(-1, grids, 0, 5, 2, 7));
		
		grids[0][5] = 0;
		grids[1][5] = 0;
		grids[4][0] = 11;
		assert(cm.checkmate(grids, -1, 2, 7));
		assert(!cm.canQueenSaveKing(-1, grids, 4, 0, 2, 7));
		
		grids[4][0] = 0;
		grids[4][3] = 9;
		assert(!cm.checkmate(grids, -1, 2, 7));
		assert(cm.canKnightSaveKing(-1, grids, 4, 3, 2, 7));
		
		grids[4][3] = 0;
		grids[0][7] = 9;
		assert(!cm.checkmate(grids, -1, 2, 7));
		assert(cm.canKnightSaveKing(-1, grids, 0, 7, 2, 7));
		
	}
	
	@Test
	void testKingFleeLeft() {
		int[][] grids = new int[8][8];
		grids[2][0] = 6;
		grids[2][1] = 11;
		
		Checkmate cm = new Checkmate();
		
		assert(!cm.checkmate(grids, 1, 2, 1));
		
		grids[1][7] = 8;
		grids[3][7] = 8;
		assert(!cm.checkmate(grids, 1, 2, 1));
		assert(cm.canKingSaveHimself(1, grids, 2, 0, 2, 1));
		
		grids[2][2] = 12;
		assert(cm.checkmate(grids, 1, 2, 1));
		assert(!cm.canKingSaveHimself(1, grids, 2, 0, 2, 1));
	}
	
	@Test
	void testKingFleeRight() {
		int[][] grids = new int[8][8];
		grids[3][7] = 6;
		grids[3][6] = 11;
		
		Checkmate cm = new Checkmate();
		
		assert(!cm.checkmate(grids, 1, 3, 6));
		
		grids[2][0] = 8;
		grids[4][0] = 8;
		assert(!cm.checkmate(grids, 1, 3, 6));
		assert(cm.canKingSaveHimself(1, grids, 3, 7, 3, 6));
		
		grids[3][5] = 12;
		assert(cm.checkmate(grids, 1, 3, 6));
		assert(!cm.canKingSaveHimself(1, grids, 3, 7, 3, 6));
	}
	
	@Test
	void testKingFleeBot() {
		int[][] grids = new int[8][8];
		grids[7][4] = 6;
		grids[6][4] = 11;
		
		Checkmate cm = new Checkmate();
		
		assert(!cm.checkmate(grids, 1, 6, 4));
		
		grids[0][3] = 8;
		grids[0][5] = 8;
		assert(!cm.checkmate(grids, 1, 6, 4));
		assert(cm.canKingSaveHimself(1, grids, 7, 4, 6, 4));
		
		
		grids[5][4] = 12;
		assert(cm.checkmate(grids, 1, 6, 4));
		assert(!cm.canKingSaveHimself(1, grids, 7, 4, 6, 4));
	}
	
	@Test
	void testKingFleeUp() {
		int[][] grids = new int[8][8];
		grids[0][4] = 6;
		grids[1][4] = 11;
		
		Checkmate cm = new Checkmate();
		
		assert(!cm.checkmate(grids, 1, 1, 4));
		
		grids[7][3] = 8;
		grids[7][5] = 8;
		assert(!cm.checkmate(grids, 1, 1, 4));
		assert(cm.canKingSaveHimself(1, grids, 0, 4, 1, 4));
		
		grids[2][4] = 12;
		assert(cm.checkmate(grids, 1, 1, 4));
		assert(!cm.canKingSaveHimself(1, grids, 0, 4, 1, 4));
	}
	
	
	@Test
	void testKingFleeDownLeft() {
		int[][] grids = new int[8][8];
		grids[7][0] = 6;
		grids[6][1] = 11;
		
		Checkmate cm = new Checkmate();
		
		assert(!cm.checkmate(grids, 1, 6, 1));
		assert(cm.canKingSaveHimself(1, grids, 7, 0, 6, 1));
		
		grids[5][2] = 12;
		assert(cm.checkmate(grids, 1, 1, 4));
		assert(!cm.canKingSaveHimself(1, grids, 7, 0, 6, 1));
	}

	@Test
	void testKingFleeDownRight() {
		int[][] grids = new int[8][8];
		grids[7][7] = 6;
		grids[6][6] = 11;
		
		Checkmate cm = new Checkmate();
		
		assert(!cm.checkmate(grids, 1, 6, 6));
		assert(cm.canKingSaveHimself(1, grids, 7, 7, 6, 6));
		
		grids[5][5] = 12;
		assert(cm.checkmate(grids, 1, 6, 6));
		assert(!cm.canKingSaveHimself(1, grids, 7, 7, 6, 6));
	}
	
	@Test
	void testKingFleeUpwardLeft() {
		int[][] grids = new int[8][8];
		grids[0][0] = 6;
		grids[1][1] = 11;
		
		Checkmate cm = new Checkmate();
		
		assert(!cm.checkmate(grids, 1, 1, 1));
		assert(cm.canKingSaveHimself(1, grids, 0, 0, 1, 1));
		
		grids[2][2] = 12;
		assert(cm.checkmate(grids, 1, 1, 1));
		assert(!cm.canKingSaveHimself(1, grids, 0, 0, 1, 1));
	}
	
	@Test
	void testKingFleeUpwardRight() {
		int[][] grids = new int[8][8];
		grids[0][7] = 6;
		grids[1][6] = 11;
		
		Checkmate cm = new Checkmate();
		
		assert(!cm.checkmate(grids, 1, 1, 6));
		assert(cm.canKingSaveHimself(1, grids, 0, 7, 1, 6));
		
		grids[2][5] = 12;
		assert(cm.checkmate(grids, 1, 1, 6));
		assert(!cm.canKingSaveHimself(1, grids, 0, 7, 1, 6));
	}
	
	//yang 2 langkah(blom pernah jalan)
	@Test
	void testWhitePawnSaveKing() {
		int[][] grids = new int[8][8];
		grids[4][2] = 6;
		grids[4][7] = 11;
		
		grids[5][7] = 8;
		grids[3][7] = 8;
		grids[0][1] = 8;
		grids[0][3] = 8;
		
		Checkmate cm = new Checkmate();
		
		assert(cm.checkmate(grids, 1, 4, 7));
		
		grids[6][4] = 1;
		assert(!cm.checkmate(grids, 1, 4, 7));
		assert(cm.canPawnSaveKing(1, grids, 6, 4, 4, 7));
	}
	
	@Test
	void testBlackPawnSaveKing() {
		int[][] grids = new int[8][8];
		grids[3][2] = 12;
		grids[3][7] = 5;
		
		grids[2][7] = 2;
		grids[4][7] = 2;
		grids[7][1] = 2;
		grids[7][3] = 2;
		
		Checkmate cm = new Checkmate();
		
		assert(cm.checkmate(grids, -1, 3, 7));
		
		grids[1][4] = 7;
		assert(!cm.checkmate(grids, -1, 3, 7));
		assert(cm.canPawnSaveKing(-1, grids, 1, 4, 3, 7));
	}
	
	@Test
	void testBlackPawnCannotSaveKing() {
		int[][] grids = new int[8][8];
		grids[4][2] = 12;
		grids[4][7] = 5;
		
		grids[3][7] = 2;
		grids[5][7] = 2;
		grids[7][1] = 2;
		grids[7][3] = 2;
		
		Checkmate cm = new Checkmate();
		
		assert(cm.checkmate(grids, -1, 4, 7));
		
		grids[1][4] = 7;
		assert(cm.checkmate(grids, -1, 4, 7));
		assert(!cm.canPawnSaveKing(-1, grids, 1, 4, 4, 7));
	}
	
	@Test
	void testBishopBlackEatEnemyCheckDownLeft() {
		int[][] grids = new int[8][8];
		grids[3][2] = 12;
		grids[3][5] = 5;
		
		grids[2][7] = 2;
		grids[4][7] = 2;
		grids[7][1] = 2;
		grids[7][3] = 2;
		
		Checkmate cm = new Checkmate();
		
		assert(cm.checkmate(grids, -1, 3, 5));
		
		grids[1][7] = 10;
		assert(!cm.checkmate(grids, -1, 3, 5));
		assert(cm.canBishopSaveKing(-1, grids, 1, 7, 3, 5));
	}
	
	@Test
	void testBishopBlackEatEnemyCheckUpwardRight() {
		int[][] grids = new int[8][8];
		grids[3][2] = 12;
		grids[3][5] = 5;
		
		grids[2][7] = 2;
		grids[4][7] = 2;
		grids[7][1] = 2;
		grids[7][3] = 2;
		
		Checkmate cm = new Checkmate();
		
		assert(cm.checkmate(grids, -1, 3, 5));
		
		grids[6][2] = 10;
		assert(!cm.checkmate(grids, -1, 3, 5));
		assert(cm.canBishopSaveKing(-1, grids, 6, 2, 3, 5));
	}
	
	@Test
	void testRookWhiteSaveKingLeftMove() {
		int[][] grids = new int[8][8];
		grids[3][2] = 6;
		grids[7][2] = 11;
		
		grids[2][7] = 8;
		grids[4][7] = 8;
		grids[7][1] = 8;
		grids[7][3] = 8;
		
		Checkmate cm = new Checkmate();
		
		assert(cm.checkmate(grids, 1, 7, 2));
		
		grids[5][7] = 2;
		assert(!cm.checkmate(grids, 1, 7, 2));
		assert(cm.canRookSaveKing(1, grids, 5, 7, 7, 2));
		
		grids[5][6] = 1;
		assert(cm.checkmate(grids, 1, 7, 2));
		assert(!cm.canRookSaveKing(1, grids, 5, 7, 7, 2));
	}
	
	@Test
	void testRookWhiteSaveKingRightMove() {
		int[][] grids = new int[8][8];
		grids[3][5] = 6;
		grids[7][5] = 11;
		
		grids[2][7] = 8;
		grids[4][7] = 8;
		grids[7][4] = 8;
		grids[7][6] = 8;
		
		Checkmate cm = new Checkmate();
		
		assert(cm.checkmate(grids, 1, 7, 5));
		
		grids[6][0] = 2;
		assert(!cm.checkmate(grids, 1, 7, 5));
		assert(cm.canRookSaveKing(1, grids, 6, 0, 7, 5));
		
		grids[6][2] = 1;
		assert(cm.checkmate(grids, 1, 7, 5));
		assert(!cm.canRookSaveKing(1, grids, 6, 0, 7, 5));
	}
	
	@Test
	void testRookBlackSaveKingLeftMove() {
		int[][] grids = new int[8][8];
		grids[3][2] = 12;
		grids[7][2] = 5;
		
		grids[2][7] = 2;
		grids[4][7] = 2;
		grids[7][1] = 2;
		grids[7][3] = 2;
		
		Checkmate cm = new Checkmate();
		
		assert(cm.checkmate(grids, -1, 7, 2));
		
		grids[5][7] = 8;
		assert(!cm.checkmate(grids, -1, 7, 2));
		assert(cm.canRookSaveKing(-1, grids, 5, 7, 7, 2));
		
		grids[5][6] = 7;
		assert(cm.checkmate(grids, -1, 7, 2));
		assert(!cm.canRookSaveKing(-1, grids, 5, 7, 7, 2));
	}
	
	@Test
	void testRookBlackSaveKingRightMove() {
		int[][] grids = new int[8][8];
		grids[3][5] = 12;
		grids[7][5] = 5;
		
		grids[2][7] = 2;
		grids[4][7] = 2;
		grids[7][4] = 2;
		grids[7][6] = 2;
		
		Checkmate cm = new Checkmate();
		
		assert(cm.checkmate(grids, -1, 7, 5));
		
		grids[6][0] = 8;
		assert(!cm.checkmate(grids, -1, 7, 5));
		assert(cm.canRookSaveKing(-1, grids, 6, 0, 7, 5));
		
		grids[6][2] = 7;
		assert(cm.checkmate(grids, -1, 7, 5));
		assert(!cm.canRookSaveKing(-1, grids, 6, 0, 7, 5));
	}
	
	@Test
	void testWhitePawnEatEnemyCheck() {
		int[][] grids = new int[8][8];
		grids[4][2] = 6;
		grids[4][6] = 11;
		
		grids[5][6] = 8;
		grids[3][6] = 8;
		grids[0][1] = 8;
		grids[0][3] = 8;
		
		Checkmate cm = new Checkmate();
		
		assert(cm.checkmate(grids, 1, 4, 6));
		
		grids[5][7] = 1;
		assert(!cm.checkmate(grids, 1, 4, 6));
		assert(cm.canPawnSaveKing(1, grids, 5, 7, 4, 6));
	}
	
	@Test
	void testBlackPawnEatEnemyCheck() {
		int[][] grids = new int[8][8];
		grids[4][2] = 12;
		grids[4][6] = 5;
		
		grids[5][6] = 2;
		grids[3][6] = 2;
		grids[0][1] = 2;
		grids[0][3] = 2;
		
		Checkmate cm = new Checkmate();
		
		assert(cm.checkmate(grids, -1, 4, 6));
		
		grids[3][7] = 7;
		assert(!cm.checkmate(grids, -1, 4, 6));
		assert(cm.canPawnSaveKing(-1, grids, 3, 7, 4, 6));
	}
	
	@Test
	void testKnightEatEnemyCheckXMin1YPlus2() {
		int[][] grids = new int[8][8];
		grids[4][5] = 6;
		grids[4][2] = 11;
		
		grids[5][1] = 8;
		grids[3][1] = 8;
		grids[0][4] = 8;
		grids[0][6] = 8;
		
		Checkmate cm = new Checkmate();
		
		assert(cm.checkmate(grids, 1, 4, 2));
		
		grids[5][0] = 3;
		assert(!cm.checkmate(grids, 1, 4, 2));
		assert(cm.canKnightSaveKing(1, grids, 5, 0, 4, 2));
		
		grids[4][5] = 12;
		grids[4][2] = 5;
		
		grids[5][1] = 2;
		grids[3][1] = 2;
		grids[0][4] = 2;
		grids[0][6] = 2;
		
		assert(cm.checkmate(grids, -1, 4, 2));
		
		grids[5][0] = 9;
		assert(!cm.checkmate(grids, -1, 4, 2));
		assert(cm.canKnightSaveKing(-1, grids, 5, 0, 4, 2));
	}
	
	@Test
	void testKnightFailDown() {
		int[][] grids = new int[8][8];
		grids[4][5] = 6;
		grids[4][2] = 11;
		
		grids[5][1] = 8;
		grids[3][1] = 8;
		grids[0][4] = 8;
		grids[0][6] = 8;
		
		Checkmate cm = new Checkmate();
		
		assert(cm.checkmate(grids, 1, 4, 2));
		
		grids[0][1] = 3;
		assert(cm.checkmate(grids, 1, 4, 2));
		assert(!cm.canKnightSaveKing(1, grids, 0, 1, 4, 2));
		
		grids[4][5] = 12;
		grids[4][2] = 5;
		
		grids[5][1] = 2;
		grids[3][1] = 2;
		grids[0][4] = 2;
		grids[0][6] = 2;
		
		assert(cm.checkmate(grids, -1, 4, 2));
		
		grids[0][1] = 9;
		assert(cm.checkmate(grids, -1, 4, 2));
		assert(!cm.canKnightSaveKing(-1, grids, 0, 1, 4, 2));
	}
	
	@Test
	void testKnightFailUp() {
		int[][] grids = new int[8][8];
		grids[4][5] = 6;
		grids[4][2] = 11;
		
		grids[5][1] = 8;
		grids[3][1] = 8;
		grids[0][4] = 8;
		grids[0][6] = 8;
		
		Checkmate cm = new Checkmate();
		
		assert(cm.checkmate(grids, 1, 4, 2));
		
		grids[7][1] = 3;
		assert(cm.checkmate(grids, 1, 4, 2));
		assert(!cm.canKnightSaveKing(1, grids, 7, 1, 4, 2));
		
		grids[4][5] = 12;
		grids[4][2] = 5;
		
		grids[5][1] = 2;
		grids[3][1] = 2;
		grids[0][4] = 2;
		grids[0][6] = 2;
		
		assert(cm.checkmate(grids, -1, 4, 2));
		
		grids[7][1] = 9;
		assert(cm.checkmate(grids, -1, 4, 2));
		assert(!cm.canKnightSaveKing(-1, grids, 7, 1, 4, 2));
	}
	
	@Test
	void testFalseKnight() {
		int[][] grids = new int[8][8];
		grids[4][5] = 6;
		grids[4][2] = 11;
		
		grids[5][1] = 8;
		grids[3][1] = 8;
		grids[0][4] = 8;
		grids[0][6] = 8;
		
		Checkmate cm = new Checkmate();
		
		assert(cm.checkmate(grids, 1, 4, 2));
		
		grids[5][0] = 3;
		assert(!cm.checkmate(grids, 1, 4, 2));
		assert(!cm.canKnightSaveKing(3, grids, 5, 0, 4, 2));
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

package unit_test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import chess_rule.PawnPromotion;

class PawnPromotionUnitTest {

	@Test
	void testWhitePromotionInput() {
		PawnPromotion pp = new PawnPromotion();
		int piece = pp.choosePiece(1);
		
		
		assert(piece == 4 || piece == 3 || piece == 2 || piece == 5);
	}
	
	@Test
	void testBlackPromotionInput() {
		PawnPromotion pp = new PawnPromotion();
		int piece = pp.choosePiece(-1);
		
		
		assert(piece == 10 || piece == 9 || piece == 8 || piece == 11);
	}
	
	@Test
	void testNotWhiteOrBlackInput() {
		PawnPromotion pp = new PawnPromotion();
		int piece = pp.choosePiece(2);
		
		
		assert(piece == 0);
	}
	
	@Test
	void testWhitePromotion() {
		int[][] grids = new int[8][8];
		grids[0][0] = 1;
		
		PawnPromotion pp = new PawnPromotion();
		pp.pawnPromotion(grids, 1, 0, 0);
		
		assert(grids[0][0] == 2 || grids[0][0] == 3 || grids[0][0] == 4 || grids[0][0] == 5);
	}
	
	@Test
	void testBlackPromotion() {
		int[][] grids = new int[8][8];
		grids[7][0] = 7;
		
		PawnPromotion pp = new PawnPromotion();
		pp.pawnPromotion(grids, -1, 7, 0);
		
		assert(grids[7][0] == 8 || grids[7][0] == 9 || grids[7][0] == 10 || grids[7][0] == 11);
	}
	
	@Test
	void testWhitePromotionFalseLocation() {
		int[][] grids = new int[8][8];
		grids[1][0] = 1;
		
		PawnPromotion pp = new PawnPromotion();
		pp.pawnPromotion(grids, 1, 1, 0);
		
		assert(grids[1][0] == 1);
	}
	
	@Test
	void testBlackPromotionFalseLocation() {
		int[][] grids = new int[8][8];
		grids[4][2] = 7;
		
		PawnPromotion pp = new PawnPromotion();
		pp.pawnPromotion(grids, -1, 4, 2);
		
		assert(grids[4][2] == 7);
	}

}

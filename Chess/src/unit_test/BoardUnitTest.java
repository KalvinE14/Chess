package unit_test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import chess_board.Board;

class BoardUnitTest {

	@Test
	void testIsEnd() {
		Board board = new Board();
		assert(board.isEnd(1));
		assert(!board.isEnd(-1));
	}
	
	@Test
	void testKingHasMoved() {
		Board board = new Board();
		int[][] grids = new int[8][8];
		grids[7][4] = 6;
		grids[0][4] = 12;
		
		board.kingHasMoved("E1-E2", -1, 0, 0);
		board.kingHasMoved("E8-E7", 1, 0, 0);
	}
	
	@Test
	void testRookHasMoved() {
		Board board = new Board();
		int[][] grids = new int[8][8];
		grids[7][0] = 2;
		grids[7][7] = 2;
		
		grids[0][0] = 8;
		grids[0][7] = 8;
		
		board.rookHasMoved("A1-A2", -1, 0, 0, 0, 0);
		board.rookHasMoved("H1-H2", -1, 0, 0, 0, 0);
		board.rookHasMoved("A8-A7", 1, 0, 0, 0, 0);
		board.rookHasMoved("H8-H7", 1, 0, 0, 0, 0);
	}
//	
	@Test
	void testCastlingKingSide() {
		Board board = new Board();
		
		for (int i = 0; i < 8; i++) {
			System.out.println("Test Castling King Side");
			System.out.println("There will be 8 inputs");
			System.out.println("Please input");
			System.out.println("E2-E4");
			System.out.println("E7-E5");
			System.out.println("F1-A6");
			System.out.println("F8-A3");
			System.out.println("G1-H3");
			System.out.println("G8-H6");
			System.out.println("E1-G1");
			System.out.println("E8-G8");
			board.doTurn();
		}
	}
	
	
	
	@Test
	void testCastlingQueenSide() {
		Board board = new Board();
		
		for (int i = 0; i < 12; i++) {
			System.out.println("Test Castling Queen Side");
			System.out.println("There will be 12 inputs");
			System.out.println("Please input");
			System.out.println("E2-E4");
			System.out.println("E7-E5");
			System.out.println("D2-D4");
			System.out.println("D7-D5");
			System.out.println("D1-H5");
			System.out.println("D8-H4");
			System.out.println("C1-H6");
			System.out.println("C8-H3");
			System.out.println("B1-A3");
			System.out.println("B8-A6");
			System.out.println("E1-C1");
			System.out.println("E8-C8");
			board.doTurn();
		}
	}
	
	@Test
	void testEnPassantMove() {
		Board board = new Board();
		int[][] grids = new int[8][8];
		grids[3][4] = 1;
		grids[3][5] = 7;
		
		grids[4][1] = 1;
		grids[4][0] = 7;
		
		board.enPassantMove("E5-F6", 1, grids, 0, 0);
		board.enPassantMove("A4-B3", -1, grids, 0, 0);
		
		assert(grids[2][5] == 1 && grids[3][5] == 0);
		assert(grids[5][1] == 7 && grids[4][1] == 0);
	}
	
	@Test
	void testEnPassantMoveButKingChecked() {
		Board board = new Board();
		int[][] grids = new int[8][8];
		grids[3][4] = 1;
		grids[3][5] = 7;
		grids[7][4] = 6;
		grids[7][7] = 11;
		
		grids[4][1] = 1;
		grids[4][0] = 7;
		grids[0][4] = 12;
		grids[0][0] = 5;
		
		board.enPassantMove("E5-F6", 1, grids, 0, 0);
		board.enPassantMove("A4-B3", -1, grids, 0, 0);
		
		assert(grids[3][4] == 1 && grids[3][5] == 7);
		assert(grids[4][1] == 1 && grids[4][0] == 7);
	}

}

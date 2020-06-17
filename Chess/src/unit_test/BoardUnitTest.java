package unit_test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import chess_board.Board;
import chess_board.PrintBoard;
import chess_piece.Pawn;

class BoardUnitTest {
	@Test
	public void testCheckSign() {
		int[][] grids = new int[8][8];
		
		Board board = new Board();
		
		grids[3][4] = 6;
		grids[3][5] = 11;
		
		board.checkSign(grids, -1);
		
		int checkBlack = board.checkBlackCounter();
		int checkWhite = board.checkWhiteCounter();
		assert(checkWhite == 1); 
		assert(checkBlack == 0);
		 
		board.resetCheckCounter();
		 
		grids[3][4] = 12; 
		grids[3][5] = 5;
		
		board.checkSign(grids, 1); 
		
		checkBlack = board.checkBlackCounter();
		checkWhite = board.checkWhiteCounter();
		assert(checkWhite == 0); 
		assert(checkBlack == 1);
		
		board.resetCheckCounter();
		
		grids[3][5] = 0;
		grids[4][6] = 5;
		
		board.checkSign(grids, 1);
		
		checkBlack = board.checkBlackCounter();
		checkWhite = board.checkWhiteCounter();
		assert(checkWhite == 0); 
		assert(checkBlack == 0);
		
		board.resetCheckCounter();
		
		grids[3][4] = 6;
		grids[4][6] = 11;
		
		board.checkSign(grids, -1);
		
		checkBlack = board.checkBlackCounter();
		checkWhite = board.checkWhiteCounter();
		assert(checkWhite == 0); 
		assert(checkBlack == 0);
	}
	
	@Test
	public void testValidMovement() {
		Board board = new Board();
		int[][] grids = new int[8][8];
		String input = "B5-B6"; 
		
		grids[0][0] = 12;
		grids[3][1] = 6;
		grids[1][0] = 1;
		
		board.validMovement(grids, input, 1);
		
		assert(grids[2][1] == 6);
		
		grids[2][1] = 0;
		grids[0][0] = 0;
		grids[3][1] = 0;
		grids[1][0] = 0;
		
		grids[2][0] = 12;
		grids[7][1] = 5;
		grids[2][2] = 6;
		
		input = "B1-B6";
		
		board.validMovement(grids, input, 1);
		
		assert(grids[2][1] == 5 && grids[7][1] == 0);
		
		grids[2][1] = 0;
		grids[2][0] = 6; 
		grids[7][1] = 11;
		grids[2][2] = 12;
	
		
		board.validMovement(grids, input, -1);
		
		assert(grids[2][1] == 11);
		
		grids[2][4] = 7;
		
		input = "E6-E5";
		
		board.pawnMovement(grids, input, -1);
		
		assert(grids[3][4] == 7);
		
		grids = new int[8][8];
		
		grids[2][0] = 6;
		grids[1][0] = 2;
		grids[0][0] = 8;
		
		input = "A7-B7";
		
		board.validMovement(grids, input, 1);
		
		assert(grids[1][0] == 2); 
		
		
	}
	
	@Test
	void testInvalidMove() {
		Board board = new Board();
		int[][] grids = new int[8][8];
		
		grids[3][4] = 6;
		
		grids[6][4] = 8;
		
		grids[5][7] = 2;
		board.validMovement(grids, "H3-H4", 1);
		
		assert(grids[5][7] == 2);
		assert(grids[4][7] == 0);
	}
	
	@Test
	void testBlackInvalidEnPassantMove() {
		Board board = new Board();
		PrintBoard pb = new PrintBoard();
		int[][] grids = new int[8][8];
		
		grids[1][3] = 12;
		
		grids[7][3] = 2;
		grids[4][5] = 1;
		
		grids[4][6] = 7;
		pb.print(grids);
		board.enPassantMove("G4-F3", -1, grids, 0, 0);
		
		
		pb.print(grids);
		assert(grids[4][6] == 7);
		assert(grids[4][5] == 1);
	}
	
	@Test
	void testBlackEnPassantMoveCheck() {
		Board board = new Board();
		PrintBoard pb = new PrintBoard();
		int[][] grids = new int[8][8];
		
		grids[6][5] = 6;
		
		grids[4][6] = 1;
		
		grids[4][5] = 7;
		pb.print(grids);
		board.enPassantMove("F4-G3", -1, grids, 0, 1);
		
		
		pb.print(grids);
		assert(grids[5][6] == 7);
		assert(grids[4][6] == 0);
	}
	
	@Test
	void testWhiteEnPassantMoveCheck() {
		Board board = new Board();
		PrintBoard pb = new PrintBoard();
		int[][] grids = new int[8][8];
		
		grids[1][6] = 12;
		
		grids[3][5] = 7;
		
		grids[3][6] = 1;
		pb.print(grids);
		board.enPassantMove("G5-F6", 1, grids, 1, 0);
		
		
		pb.print(grids);
		assert(grids[2][5] == 1);
		assert(grids[3][5] == 0);
	}
	
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
	
	@Test
	void testCastlingKingSide() throws Exception {
		Board board = new Board();
		
		for (int i = 0; i < 11; i++) {
			System.out.println("Test Castling King Side");
			System.out.println("There will be 11 inputs");
			System.out.println("Please input");
			System.out.println("E2-E4");
			System.out.println("E7-E5");
			System.out.println("F1-B5");
			System.out.println("F8-B4");
			System.out.println("G1-H3");
			System.out.println("G8-H6");
			System.out.println("E1-G1");
			System.out.println("E8-G8");
			System.out.println("A2-A4");
			System.out.println("A7-A5");
			System.out.println("A1-A3");
			board.doTurn();
		}
	}
	
	
	
	@Test
	void testCastlingQueenSide() throws Exception {
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
	
	@Test
	void testValidMovementCheck() {
		Board board = new Board();
		int[][] grids = new int[8][8];

		grids[1][3] = 12;
		grids[7][7] = 2;
		
		board.validMovement(grids, "H1-D1", 1);
		
		assert(grids[7][3] == 2);
		assert(grids[7][7] == 0);
		
		grids[1][3] = 6;
		grids[7][7] = 8;
		
		board.validMovement(grids, "H1-D1", -1);
		
		assert(grids[7][3] == 8);
		assert(grids[7][7] == 0);
	}
	
	@Test
	void testPawnPromotion() {
		Board board = new Board();
		PrintBoard pb = new PrintBoard();
		int[][] grids = new int[8][8];

		grids[1][2] = 1;
		grids[7][7] = 12;
		
		pb.print(grids);
		board.pawnMovement(grids, "C7-C8", 1);
		pb.print(grids);
		assert(grids[1][2] == 0);
	}
	
	@Test
	void testWhiteEnPassantCheckmate() {
		Board board = new Board();
		int[][] grids = new int[8][8];
		
		grids[1][2] = 12;
		grids[3][3] = 7;
		
		grids[3][4] = 1;
		grids[0][0] = 4;
		grids[5][7] = 4;
		grids[6][7] = 4;
		grids[0][7] = 2;
		grids[7][1] = 2;
		
		board.enPassantMove("E5-D6", 1, grids, 1, 0);
		
		assert(grids[2][3] == 1 && grids[3][3] == 0);
	}
	
	@Test
	void testBlackEnPassantCheckmate() {
		Board board = new Board();
		PrintBoard pb = new PrintBoard();
		int[][] grids = new int[8][8];
		
		grids[6][2] = 6;
		grids[4][3] = 1;
		
		grids[4][4] = 7;
		grids[7][0] = 10;
		grids[1][7] = 10;
		grids[2][7] = 10;
		grids[7][7] = 8;
		grids[0][1] = 8;
		
		pb.print(grids);
		board.enPassantMove("E4-D3", -1, grids, 0, 1);
		
		assert(grids[5][3] == 7 && grids[4][3] == 0);
	}
}

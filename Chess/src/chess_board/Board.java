package chess_board;

import java.util.Scanner;

import chess_piece.Bishop;
import chess_piece.King;
import chess_piece.Knight;
import chess_piece.Pawn;
import chess_piece.Queen;
import chess_piece.Rook;
import chess_rule.Check;
import chess_rule.EnPassant;
import chess_rule.InvalidMove;
import chess_rule.PawnPromotion;


public class Board {
	private int[][] grids;
	
	public int[][] getGrids() {
		return grids;
	}

	public void setGrids(int[][] grids) {
		this.grids = grids;
	}

	private int turn;
	
	private int checkBlack = 0;
	
	private int checkWhite = 0;
	
	private int moveKingBlack = 0;
	
	private int moveKingWhite = 0;
	
	private int moveRookLeftBlack = 0;
	
	private int moveRookRightBlack = 0;
	
	private int moveRookLeftWhite = 0;
	
	private int moveRookRightWhite = 0;
	
	private boolean whiteEnPassant = false;
	
	private boolean blackEnPassant = false;
	
	private int xWhitePositionAfterMoved = -1;
	
	private int yWhitePositionAfterMoved = -1;
	
	private int xBlackPositionAfterMoved = -1;
	
	private int yBlackPositionAfterMoved = -1;

	public Board() {		
		grids = new int[8][8];
		turn = 1;
		//ini buat pion
		for (int i = 0; i < 8; i++) {
			grids[6][i] = 1;
			grids[1][i] = 7;
		}
		//ini buat piece lain
		int decrement = 1;
		int increment = 5;
		for (int i = 0; i < 8; i++) {	
			//buat dari r/R sampe k/K
			if(i < 5) {
				grids[7][i] = i + 2;
				grids[0][i] = i + 8;
			}
			//buat b/B sampe r/R
			else {
				grids[7][i] = i - decrement;
				grids[0][i] = i + increment;
				decrement += 2;
				increment -= 2;
			}
		}
	}
	
	Scanner scan = new Scanner(System.in);
	public void doTurn() {
		String input = null;
		print();
		System.out.println();
		if(turn == 1) {	
			whiteEnPassant = false;
			xWhitePositionAfterMoved = -1;
			yWhitePositionAfterMoved = -1;
			do{ 
				System.out.println("==========================");
				System.out.print("white move: ");
				input = scan.nextLine();
				System.out.println("==========================");
				
			} while(input.length() != 5 || 
					!(input.charAt(0) >= 'A' && 
					input.charAt(0) <= 'H') ||
					!(input.charAt(1) >= '1' &&
					input.charAt(1) <= '8') ||
					(input.charAt(2) != '-') ||
					!(input.charAt(3) >= 'A' && 
					input.charAt(3) <= 'H') ||
					!(input.charAt(4) >= '1' &&
					input.charAt(4) <= '8') ||
					!(grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65] <= 6 &&
					grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65] >= 1));
		}
		else if(turn == -1) {
			blackEnPassant = false;
			xBlackPositionAfterMoved = -1;
			yBlackPositionAfterMoved = -1;
			do {
				System.out.println("==========================");
				System.out.print("black move: ");
				input = scan.nextLine();
				System.out.println("==========================");
			} while(input.length() != 5 || 
					!(input.charAt(0) >= 'A' && 
					input.charAt(0) <= 'H') ||
					!(input.charAt(1) >= '1' &&
					input.charAt(1) <= '8') ||
					(input.charAt(2) != '-') ||
					!(input.charAt(3) >= 'A' && 
					input.charAt(3) <= 'H') ||
					!(input.charAt(4) >= '1' &&
					input.charAt(4) <= '8') ||
					!(grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65] >= 7 &&
					grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65] <= 12));
		}
		// klo inputan pawn
		if(grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65] == 7 || grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65] == 1) {
			Pawn pawn = new Pawn();	
			pawnMovement(input, pawn);
		}
		
		//klo inputan rook
		else if(grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65] == 8 || grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65] == 2) {
			Rook rook = new Rook();
			if(rook.validateMovement(grids, (8 - (input.charAt(1) - 48)), (input.charAt(0) - 65), (8 - (input.charAt(4) - 48)), (input.charAt(3) - 65))) {
				validMovement(input);
				rookHasMoved(input);
			}
		}
		
		//klo inputan bishop
		else if(grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65] == 10 || grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65] == 4) {
			Bishop bishop = new Bishop();
			if(bishop.validateMovement(grids, (8 - (input.charAt(1) - 48)), (input.charAt(0) - 65), (8 - (input.charAt(4) - 48)), (input.charAt(3) - 65))) {
				validMovement(input);
			}
		}
		
		//kalo inputannya knight
		else if(grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65] == 3  || grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65] == 9 )
		{
			Knight knight = new Knight();
			if(knight.validateMovement(grids, (8 - (input.charAt(1) - 48)), (input.charAt(0) - 65), (8 - (input.charAt(4) - 48)), (input.charAt(3) - 65)))
			{
				validMovement(input);
			}
		}
		
		//kalo inputannya queen
		else if(grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65] == 5  || grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65] == 11 )
		{
			Queen queen = new Queen();
			if(queen.validateMovement(grids, (8 - (input.charAt(1) - 48)), (input.charAt(0) - 65), (8 - (input.charAt(4) - 48)), (input.charAt(3) - 65)))
			{
				validMovement(input);
			}
							
		}
		
		//klo inputannya king
		else if(grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65] == 6  || grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65] == 12 ) {
			King king = new King();
			
			castlingSign(input, king);
			
		}
	}

	private void castlingSign(String input, King king) {
		//kingside castling white
		if(turn == 1 && (8 - (input.charAt(4) - 48)) - (8 - (input.charAt(1) - 48)) == 0 && (input.charAt(3) - 65) - (input.charAt(0) - 65) == 2 && checkWhite == 0 && moveRookRightWhite == 0 && moveKingWhite == 0 && grids[7][7] == 2)
		{
			System.out.println("Kingside castling white");
			if(checkWhite == 0)
			{
				if(grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65 + 1] == 0 && grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65 + 2] == 0)
				{
					validMovement(input);
					checkSign();
					if(turn == -1 && checkWhite == 0)
					{
						grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65 + 1] = 6;
						checkSign();
						if(checkWhite == 1)
						{
							System.out.println("Invalid move! violated kingside castling move!");
							grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65 + 1] = 0;
							grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65] = grids[8 - (input.charAt(4) - 48)][input.charAt(3) - 65];
							grids[8 - (input.charAt(4) - 48)][input.charAt(3) - 65] = 0;
						}else
						{
							grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65 + 1] = grids[7][7];
							grids[7][7] = 0;
						}
					}else if(turn == -1 && checkWhite == 1)
					{
						grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65] = grids[8 - (input.charAt(4) - 48)][input.charAt(3) - 65];
						grids[8 - (input.charAt(4) - 48)][input.charAt(3) - 65] = 0;
						turn *= -1;
						System.out.println("Invalid move! Destination area is dangerous for your king!");
					}
				}else
				{
					System.out.println("Invalid Kingside Castling Move!");
				}
			}else
			{
				System.out.println("Invalid move! cannot do castling, you have been checked!");
			}
			
		}
		//queenside castling white
		else if(turn == 1 && (8 - (input.charAt(4) - 48)) - (8 - (input.charAt(1) - 48)) == 0 && (input.charAt(3) - 65) - (input.charAt(0) - 65) == -2 && checkWhite == 0 && moveRookLeftWhite == 0 && moveKingWhite == 0 && grids[7][0] == 2)
		{
			System.out.println("queenside castling white");
			if(checkWhite == 0)
			{
				if(grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65 - 1] == 0 && grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65 - 2] == 0 && grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65 - 3] == 0)
				{
					validMovement(input);
					checkSign();
					if(turn == -1 && checkWhite == 0)
					{
						grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65 - 1] = 6;
						checkSign();
						if(checkWhite == 1)
						{
							System.out.println("Invalid move! violated kingside castling move!");
							grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65 - 1] = 0;
							grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65] = grids[8 - (input.charAt(4) - 48)][input.charAt(3) - 65];
							grids[8 - (input.charAt(4) - 48)][input.charAt(3) - 65] = 0;
						}else
						{
							grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65 - 1] = grids[7][0];
							grids[7][0] = 0;
						}
					}else if(turn == -1 && checkWhite == 1)
					{
						grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65] = grids[8 - (input.charAt(4) - 48)][input.charAt(3) - 65];
						grids[8 - (input.charAt(4) - 48)][input.charAt(3) - 65] = 0;
						turn *= -1;
						System.out.println("Invalid move! Destination area is dangerous for your king!");
					}
				}else
				{
					System.out.println("Invalid Queenside Castling Move!");
				}
			}else
			{
				System.out.println("Invalid move! cannot do castling, you have been checked!");
			}
			
		}
		//kingside castling black
		else if(turn == -1 && (8 - (input.charAt(4) - 48)) - (8 - (input.charAt(1) - 48)) == 0 && (input.charAt(3) - 65) - (input.charAt(0) - 65) == 2 && checkBlack == 0 && moveRookRightBlack == 0 && moveKingBlack == 0 && grids[0][7] == 8)
		{
			System.out.println("Kingside castling black");
			if(checkBlack == 0)
			{
				if(grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65 + 1] == 0 && grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65 + 2] == 0)
				{
					validMovement(input);
					checkSign();
					if(turn == 1 && checkBlack == 0)
					{
						grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65 + 1] = 12;
						checkSign();
						if(checkBlack == 1)
						{
							System.out.println("Invalid move! violated kingside castling move!");
							grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65 + 1] = 0;
							grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65] = grids[8 - (input.charAt(4) - 48)][input.charAt(3) - 65];
							grids[8 - (input.charAt(4) - 48)][input.charAt(3) - 65] = 0;
						}else
						{
							grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65 + 1] = grids[0][7];
							grids[0][7] = 0;
						}
					}else if(turn == 1 && checkBlack == 1)
					{
						grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65] = grids[8 - (input.charAt(4) - 48)][input.charAt(3) - 65];
						grids[8 - (input.charAt(4) - 48)][input.charAt(3) - 65] = 0;
						turn *= -1;
						System.out.println("Invalid move! Destination area is dangerous for your king!");
					}
				}else
				{
					System.out.println("Invalid Kingside Castling Move!");
				}
			}else
			{
				System.out.println("Invalid move! cannot do castling, you have been checked!");	
			}
			
		}
		//queenside castling black
		else if(turn == -1 && (8 - (input.charAt(4) - 48)) - (8 - (input.charAt(1) - 48)) == 0 && (input.charAt(3) - 65) - (input.charAt(0) - 65) == -2 && checkBlack == 0 && moveRookLeftBlack == 0 && moveKingBlack == 0 && grids[0][0] == 8)
		{
			System.out.println("queenside castling black");
			if(checkBlack == 0)
			{
				if(grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65 - 1] == 0 && grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65 - 2] == 0 && grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65 - 3] == 0)
				{
					validMovement(input);
					checkSign();
					if(turn == 1 && checkBlack == 0)
					{
						grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65 - 1] = 12;
						checkSign();
						if(checkBlack == 1)
						{
							System.out.println("Invalid move! violated kingside castling move!");
							grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65 - 1] = 0;
							grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65] = grids[8 - (input.charAt(4) - 48)][input.charAt(3) - 65];
							grids[8 - (input.charAt(4) - 48)][input.charAt(3) - 65] = 0;
						}else
						{
							grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65 - 1] = grids[0][0];
							grids[0][0] = 0;
						}
					}else if(turn == 1 && checkBlack == 1)
					{
						grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65] = grids[8 - (input.charAt(4) - 48)][input.charAt(3) - 65];
						grids[8 - (input.charAt(4) - 48)][input.charAt(3) - 65] = 0;
						turn *= -1;
						System.out.println("Invalid move! Destination area is dangerous for your king!");
					}
				}else
				{
					System.out.println("Invalid Queenside Castling Move!");
				}
			}else
			{
				System.out.println("Invalid move! cannot do castling, you have been checked!");	
			}
			
		}else
		{
			if(king.validateMovement(grids, (8 - (input.charAt(1) - 48)), (input.charAt(0) - 65), (8 - (input.charAt(4) - 48)), (input.charAt(3) - 65))) {
				System.out.println("test");
				validMovement(input);
				kingHasMoved(input);
			}
		}
	}

	private void kingHasMoved(String input) {
		//karena turn udh keganti di validMovement, jadinya turnnya kebalik
		if(turn == -1 && moveKingWhite == 0 && 8 - (input.charAt(1) - 48) == 7 && input.charAt(0) - 65 == 4)
		{
			System.out.println("Raja putih digerakin");
			moveKingWhite = 1;
		}else if(turn == 1 && moveKingBlack == 0 && 8 - (input.charAt(1) - 48) == 0 && input.charAt(0) - 65 == 4)
		{
			System.out.println("Raja hitam digerakin");
			moveKingBlack = 1;
		}
	}

	private void rookHasMoved(String input) {
		//karena turn udh keganti di validMovement, jadinya turnnya kebalik
		if(turn == -1 && 8 - (input.charAt(1) - 48) == 7 && input.charAt(0) - 65 == 0 && moveRookLeftWhite == 0)
		{
			System.out.println("Benteng kiri putih digerakin");
			moveRookLeftWhite = 1;
		}else if(turn == -1 && 8 - (input.charAt(1) - 48) == 7 && input.charAt(0) - 65 == 7 && moveRookRightWhite == 0)
		{
			System.out.println("Benteng kanan putih digerakin");
			moveRookRightWhite = 1;
		}else if(turn == 1 && 8 - (input.charAt(1) - 48) == 0 && input.charAt(0) - 65 == 0 && moveRookLeftBlack == 0)
		{
			System.out.println("Benteng kiri hitam digerakin");
			moveRookLeftBlack = 1;
		}else if(turn == 1 && 8 - (input.charAt(1) - 48) == 0 && input.charAt(0) - 65 == 7 && moveRookRightBlack == 0)
		{
			System.out.println("Benteng kanan hitam digerakin");
			moveRookRightBlack = 1;
		}
	}
	
	private void checkSign() {
		Check check = new Check();
		if(check.validateCheck(grids, turn) ==  true) {
			if(turn == 1)
			{
				checkBlack = 1;
				System.out.println("Checkblack: "+ checkBlack);
				System.out.println("CheckWhite: " + checkWhite);
			}else
			{
				checkWhite = 1;
				System.out.println("Checkblack: "+ checkBlack);
				System.out.println("Checkwhite:" + checkWhite);
			}
			System.out.println("CHECK !!!");
		}else
		{
			if(turn == 1)
			{
				checkBlack = 0;
				System.out.println("Checkblack: "+ checkBlack);
				System.out.println("Checkwhite:" + checkWhite);
			}else
			{
				checkWhite = 0;
				System.out.println("Checkblack: "+ checkBlack);
				System.out.println("Checkwhite:" + checkWhite);
			}
		}
	}
	
	private void pawnMovement(String input, Pawn pawn) {
		PawnPromotion promotion = new PawnPromotion();
		EnPassant ep = new EnPassant();
		
		if(turn == 1 && pawn.validateMovement(grids, (8 - (input.charAt(1) - 48)), (input.charAt(0) - 65), (8 - (input.charAt(4) - 48)), (input.charAt(3) - 65)) == true) {
			whiteEnPassant = false;
			
			if((8 - (input.charAt(4) - 48)) - (8 - (input.charAt(1) - 48)) == -2 && (input.charAt(3) - 65) - (input.charAt(0) - 65) == 0)
			{
				whiteEnPassant = true;
				xWhitePositionAfterMoved = 8 - (input.charAt(4) - 48);
				yWhitePositionAfterMoved = input.charAt(3) - 65;
				
				validMovement(input);
				promotion.pawnPromotion(grids, (turn * -1), (8 - (input.charAt(4) - 48)), (input.charAt(3) - 65));
			}else if((8 - (input.charAt(4) - 48)) - (8 - (input.charAt(1) - 48)) == -1 && (((input.charAt(0) - 65) - (input.charAt(3) - 65) == -1) || ((input.charAt(0) - 65) - (input.charAt(3) - 65) == 1)) && grids[8 - (input.charAt(4) - 48)][input.charAt(3) - 65] == 0)
			{
				boolean isWhiteEnPassant = ep.enPassantWhite(blackEnPassant, grids, 8 - (input.charAt(1) - 48), input.charAt(0) - 65, 8 - (input.charAt(4) - 48), input.charAt(3) - 65, xBlackPositionAfterMoved, yBlackPositionAfterMoved);
				
				if(isWhiteEnPassant)
				{
					System.out.println("Masuk");
					System.out.println("Black Flag : " + blackEnPassant);
					System.out.println("x position after moved : " + xBlackPositionAfterMoved + " = " + (8 - (input.charAt(1) - 48)) + " : x1");
					System.out.println("y position after moved: " + yBlackPositionAfterMoved + " = " + (input.charAt(0) - 65) + " : y1");
					
					enPassantMove(input);
				}
			}else
			{
				validMovement(input);
				promotion.pawnPromotion(grids, (turn * -1), (8 - (input.charAt(4) - 48)), (input.charAt(3) - 65));
			}
		}	
		
		else if(turn == -1 && pawn.validateBlackMovement(grids, (8 - (input.charAt(1) - 48)), (input.charAt(0) - 65), (8 - (input.charAt(4) - 48)), (input.charAt(3) - 65)) == true){
			blackEnPassant = false;
			
			if((8 - (input.charAt(4) - 48)) - (8 - (input.charAt(1) - 48)) == 2 && (input.charAt(3) - 65) - (input.charAt(0) - 65) == 0)
			{
				blackEnPassant = true;
				xBlackPositionAfterMoved = 8 - (input.charAt(4) - 48);
				yBlackPositionAfterMoved = input.charAt(3) - 65;
				
				validMovement(input);
				promotion.pawnPromotion(grids, (turn * -1), (8 - (input.charAt(4) - 48)), (input.charAt(3) - 65));
			}else if((8 - (input.charAt(4) - 48)) - (8 - (input.charAt(1) - 48)) == 1 && (((input.charAt(0) - 65) - (input.charAt(3) - 65) == -1) || ((input.charAt(0) - 65) - (input.charAt(3) - 65) == 1)) && grids[8 - (input.charAt(4) - 48)][input.charAt(3) - 65] == 0)
			{
				boolean isBlackEnPassant = ep.enPassantBlack(whiteEnPassant, grids, 8 - (input.charAt(1) - 48), input.charAt(0) - 65, 8 - (input.charAt(4) - 48), input.charAt(3) - 65, xWhitePositionAfterMoved, yWhitePositionAfterMoved);
			
				if(isBlackEnPassant)
				{
					enPassantMove(input);
				}
			}else
			{
				validMovement(input);
				promotion.pawnPromotion(grids, (turn * -1), (8 - (input.charAt(4) - 48)), (input.charAt(3) - 65));
			}
		}
	}
	
	private void enPassantMove(String input)
	{
		if(turn == 1)
		{
			int temp = 0;
			
			grids[8 - (input.charAt(4) - 48)][input.charAt(3) - 65] = grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65];
			grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65] = 0;
			temp = grids[8 - (input.charAt(4) - 48) + 1][input.charAt(3) - 65];
			grids[8 - (input.charAt(4) - 48) + 1][input.charAt(3) - 65] = 0;
			
			InvalidMove invalidMove = new InvalidMove();
			
			if(invalidMove.validateInvalidMove(grids, turn)) {
				grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65] = grids[8 - (input.charAt(4) - 48)][input.charAt(3) - 65];
				grids[8 - (input.charAt(4) - 48)][input.charAt(3) - 65] = 0;
				grids[8 - (input.charAt(4) - 48) + 1][input.charAt(3) - 65] = temp;
				
				System.out.println("");
				checkSign();
				System.out.println("");
				System.out.println("!! please protect your king !!");
				System.out.println("");
			}
			else {
				System.out.println("");
				checkSign();
				System.out.println("");
				turn *= -1;
			}	
		}else if(turn == -1)
		{
			int temp = 0;
			
			grids[8 - (input.charAt(4) - 48)][input.charAt(3) - 65] = grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65];
			grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65] = 0;
			temp = grids[8 - (input.charAt(4) - 48) - 1][input.charAt(3) - 65];
			grids[8 - (input.charAt(4) - 48) - 1][input.charAt(3) - 65] = 0;
			
			InvalidMove invalidMove = new InvalidMove();
			if(invalidMove.validateInvalidMove(grids, turn)) {
				grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65] = grids[8 - (input.charAt(4) - 48)][input.charAt(3) - 65];
				grids[8 - (input.charAt(4) - 48)][input.charAt(3) - 65] = 0;
				grids[8 - (input.charAt(4) - 48) - 1][input.charAt(3) - 65] = temp;
				
				System.out.println("");
				checkSign();
				System.out.println("");
				System.out.println("!! please protect your king !!");
				System.out.println("");
			}
			else {
				System.out.println("");
				checkSign();
				System.out.println("");
				turn *= -1;
			}	
		}
		
	}

	private void validMovement(String input) {
		grids[8 - (input.charAt(4) - 48)][input.charAt(3) - 65] = grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65];
		grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65] = 0;
		InvalidMove invalidMove = new InvalidMove();
		if(invalidMove.validateInvalidMove(grids, turn)) {
			grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65] = grids[8 - (input.charAt(4) - 48)][input.charAt(3) - 65];
			grids[8 - (input.charAt(4) - 48)][input.charAt(3) - 65] = 0;
			System.out.println("");
			checkSign();
			System.out.println("");
			System.out.println("!! please protect your king !!");
			System.out.println("");
		}
		else {
			System.out.println("");
			checkSign();
			System.out.println("");
			turn *= -1;
		}	
	}
	
	public void print() {	
		int boardNumber = 8;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				//buat ngambil value dr masing2 grid
				int key = grids[i][j];
				
				switch(key) {
					case 1:  
						System.out.print("p ");
						break;
					
					case 2: 
						System.out.print("r ");
						break;
					
					case 3:
						System.out.print("n ");
						break;
					
					case 4:
						System.out.print("b ");
						break;
					
					case 5:
						System.out.print("q ");
						break;
					
					case 6:
						System.out.print("k ");
						break;
					
					case 7:
						System.out.print("P ");
						break;
					
					case 8:
						System.out.print("R ");
						break;
					
					case 9:
						System.out.print("N ");
						break;
					
					case 10:
						System.out.print("B ");
						break;
					
					case 11:
						System.out.print("Q ");
						break;
					
					case 12:
						System.out.print("K ");
						break;
					
					default:{
						if(i % 2 == 0 && j % 2 == 0) {
							System.out.print("- ");
						}
						else if(i % 2 == 0 && j % 2 != 0) {
							System.out.print("+ ");
						}
						else if(i % 2 != 0 && j % 2 == 0) {
							System.out.print("+ ");
						}
						else if(i % 2 != 0 && j % 2 != 0) {
							System.out.print("- ");
						}
					break;
					}
				}
				//ini buat print angka disamping board
				if(j == 7) {
					System.out.print(boardNumber);
					boardNumber--;
				}
			}
			System.out.println();
			
			//ini buat print huruf dibawah board
			if(i == 7) {
				for (int j = 0; j < 8; j++) {
					System.out.print((char)(j + 'A') + " ");
				}
			}
		}
		System.out.println();
	}
}

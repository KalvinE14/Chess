package chess_board;

import java.util.Scanner;

import chess_piece.Bishop;
import chess_piece.King;
import chess_piece.Knight;
import chess_piece.Pawn;
import chess_piece.Queen;
import chess_piece.Rook;
import chess_rule.Check;
import chess_rule.Checkmate;
import chess_rule.EnPassant;
import chess_rule.InvalidMove;
import chess_rule.PawnPromotion;
import chess_rule.Stalemate;


public class Board {
	private int[][] grids;
	
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
	
	int endIndicator;
	
	public Board() {		
		grids = new int[8][8];
		turn = 1;
		endIndicator = 0;
		for (int i = 0; i < 8; i++) {
			grids[6][i] = 1;
			grids[1][i] = 7;
		}
		int decrement = 1;
		int increment = 5;
		for (int i = 0; i < 8; i++) {	
			if(i < 5) {
				grids[7][i] = i + 2;
				grids[0][i] = i + 8;
			}
			else {
				grids[7][i] = i - decrement;
				grids[0][i] = i + increment;
				decrement += 2;
				increment -= 2;
			}
		}
	}
	
	Scanner scan = new Scanner(System.in);

	String input = null;
	public void doTurn() throws Exception {
		PrintBoard pb = new PrintBoard();
		pb.print(grids);
		System.out.println();
		
		
		if(turn == 1) {	
			whiteEnPassant = false;
			xWhitePositionAfterMoved = -1;
			yWhitePositionAfterMoved = -1;
			do{ 
				System.out.println("==========================");
				System.out.print("white move: ");
				try {
					input = scan.nextLine();
				} catch (Exception e) {
					throw new Exception("please input a valid format !");
				}
				System.out.println("==========================");
				
			} while(whiteInputValidation());
		}
		else if(turn == -1) {
			blackEnPassant = false;
			xBlackPositionAfterMoved = -1;
			yBlackPositionAfterMoved = -1;
			do {
				System.out.println("==========================");
				System.out.print("black move: ");
				try {
					input = scan.nextLine();
				} catch (Exception e) {
					throw new Exception("please input a valid format !");
				}
				System.out.println("==========================");
			} while(blackInputValidation());
		}
		if(grids[getX1()][getY1()] == 7 || grids[getX1()][getY1()] == 1) {
			pawnMovement(grids, input, turn);
		}
		
		else if(grids[getX1()][getY1()] == 8 || grids[getX1()][getY1()] == 2) {
			Rook rook = new Rook();
			if(rook.validateMovement(grids, getX1(), getY1(), getX2(), getY2())) {
				validMovement(grids, input, turn);
				rookHasMoved( input,  turn,  moveRookLeftWhite,  moveRookRightWhite,  moveRookLeftBlack,  moveRookRightBlack);
			}
		}
		
		else if(grids[getX1()][getY1()] == 10 || grids[getX1()][getY1()] == 4) {
			Bishop bishop = new Bishop();
			if(bishop.validateMovement(grids, getX1(), getY1(), getX2(), getY2())) {
				validMovement(grids, input, turn);
			}
		}
		
		else if(grids[getX1()][getY1()] == 3  || grids[getX1()][getY1()] == 9 )
		{
			Knight knight = new Knight();
			if(knight.validateMovement(grids, getX1(), getY1(), getX2(), getY2()))
			{
				validMovement(grids, input, turn);
			}
		}
		
		else if(grids[getX1()][getY1()] == 5  || grids[getX1()][getY1()] == 11 )
		{
			Queen queen = new Queen();
			if(queen.validateMovement(grids, getX1(), getY1(), getX2(), getY2()))
			{
				validMovement(grids, input, turn);
			}
							
		}
		
		else if(grids[getX1()][getY1()] == 6  || grids[getX1()][getY1()] == 12 ) {
			King king = new King();
			
			castlingSign(input, king);
			
		}
	}

	private int getY2() {
		return input.charAt(3) - 65;
	}

	private int getX2() {
		return 8 - (input.charAt(4) - 48);
	}

	private int getY1() {
		return input.charAt(0) - 65;
	}

	private int getX1() {
		return 8 - (input.charAt(1) - 48);
	}
	
	private boolean blackInputValidation() {
		return input.length() != 5 || 
				!(input.charAt(0) >= 'A' && 
				input.charAt(0) <= 'H') ||
				!(input.charAt(1) >= '1' &&
				input.charAt(1) <= '8') ||
				(input.charAt(2) != '-') ||
				!(input.charAt(3) >= 'A' && 
				input.charAt(3) <= 'H') ||
				!(input.charAt(4) >= '1' &&
				input.charAt(4) <= '8') ||
				!(grids[getX1()][getY1()] >= 7 &&
				grids[getX1()][getY1()] <= 12);
	}
	
	private boolean whiteInputValidation() {
		return input.length() != 5 || 
				!(input.charAt(0) >= 'A' && 
				input.charAt(0) <= 'H') ||
				!(input.charAt(1) >= '1' &&
				input.charAt(1) <= '8') ||
				(input.charAt(2) != '-') ||
				!(input.charAt(3) >= 'A' && 
				input.charAt(3) <= 'H') ||
				!(input.charAt(4) >= '1' &&
				input.charAt(4) <= '8') ||
				!(grids[getX1()][getY1()] <= 6 &&
				grids[getX1()][getY1()] >= 1);
	}

	public void castlingSign(String input, King king) {
		if(turn == 1 && (8 - (input.charAt(4) - 48)) - (8 - (input.charAt(1) - 48)) == 0 && (input.charAt(3) - 65) - (input.charAt(0) - 65) == 2 && checkWhite == 0 && moveRookRightWhite == 0 && moveKingWhite == 0 && grids[7][7] == 2)
		{
			System.out.println("Kingside castling white");
			if(checkWhite == 0)
			{
				if(grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65 + 1] == 0 && grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65 + 2] == 0)
				{
					validMovement(grids, input, turn);
					checkSign(grids, turn); 
					if(turn == -1 && checkWhite == 0)
					{
						grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65 + 1] = 6;
						checkSign(grids, turn);
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
		else if(turn == 1 && (8 - (input.charAt(4) - 48)) - (8 - (input.charAt(1) - 48)) == 0 && (input.charAt(3) - 65) - (input.charAt(0) - 65) == -2 && checkWhite == 0 && moveRookLeftWhite == 0 && moveKingWhite == 0 && grids[7][0] == 2)
		{
			System.out.println("queenside castling white");
			if(checkWhite == 0)
			{
				if(grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65 - 1] == 0 && grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65 - 2] == 0 && grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65 - 3] == 0)
				{
					validMovement(grids, input, turn);
					checkSign(grids, turn);
					if(turn == -1 && checkWhite == 0)
					{
						grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65 - 1] = 6;
						checkSign(grids, turn);
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
		else if(turn == -1 && (8 - (input.charAt(4) - 48)) - (8 - (input.charAt(1) - 48)) == 0 && (input.charAt(3) - 65) - (input.charAt(0) - 65) == 2 && checkBlack == 0 && moveRookRightBlack == 0 && moveKingBlack == 0 && grids[0][7] == 8)
		{
			System.out.println("Kingside castling black");
			if(checkBlack == 0)
			{
				if(grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65 + 1] == 0 && grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65 + 2] == 0)
				{
					validMovement(grids, input, turn);
					checkSign(grids, turn);
					if(turn == 1 && checkBlack == 0)
					{
						grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65 + 1] = 12;
						checkSign(grids, turn);
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
		else if(turn == -1 && (8 - (input.charAt(4) - 48)) - (8 - (input.charAt(1) - 48)) == 0 && (input.charAt(3) - 65) - (input.charAt(0) - 65) == -2 && checkBlack == 0 && moveRookLeftBlack == 0 && moveKingBlack == 0 && grids[0][0] == 8)
		{
			System.out.println("queenside castling black");
			if(checkBlack == 0)
			{
				if(grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65 - 1] == 0 && grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65 - 2] == 0 && grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65 - 3] == 0)
				{
					validMovement(grids, input, turn);
					checkSign(grids, turn);
					if(turn == 1 && checkBlack == 0)
					{
						grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65 - 1] = 12;
						checkSign(grids, turn);
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
				validMovement(grids, input, turn);
				kingHasMoved(input, turn, moveKingWhite, moveKingBlack);
			}
		}
	}

	public void kingHasMoved(String input, int turn, int moveKingWhite, int moveKingBlack) {
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

	public void rookHasMoved(String input, int turn, int moveRookLeftWhite, int moveRookRightWhite, int moveRookLeftBlack, int moveRookRightBlack) {
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
	
	public int checkBlackCounter() {
		return checkBlack;
	}
	
	public int checkWhiteCounter() {
		return checkWhite;
	}
	
	public void resetCheckCounter() {
		checkWhite = 0; 
		checkBlack = 0;
	}
	
	public void checkSign(int[][] grids, int turn) {
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
	
	public void pawnMovement(int grids[][], String input, int turn) {
		Pawn pawn = new Pawn();
		PawnPromotion promotion = new PawnPromotion();
		EnPassant ep = new EnPassant();
		
		if(turn == 1 && pawn.validateMovement(grids, (8 - (input.charAt(1) - 48)), (input.charAt(0) - 65), (8 - (input.charAt(4) - 48)), (input.charAt(3) - 65)) == true) {
			whiteEnPassant = false;
			
			if((8 - (input.charAt(4) - 48)) - (8 - (input.charAt(1) - 48)) == -2 && (input.charAt(3) - 65) - (input.charAt(0) - 65) == 0)
			{
				whiteEnPassant = true;
				xWhitePositionAfterMoved = 8 - (input.charAt(4) - 48);
				yWhitePositionAfterMoved = input.charAt(3) - 65;
				
				validMovement(grids, input, turn);
				promotion.pawnPromotion(grids, (turn * -1), (8 - (input.charAt(4) - 48)), (input.charAt(3) - 65));
			}else if((8 - (input.charAt(4) - 48)) - (8 - (input.charAt(1) - 48)) == -1 && (((input.charAt(0) - 65) - (input.charAt(3) - 65) == -1) || ((input.charAt(0) - 65) - (input.charAt(3) - 65) == 1)) && grids[8 - (input.charAt(4) - 48)][input.charAt(3) - 65] == 0)
			{
				boolean isWhiteEnPassant = ep.enPassantWhite(blackEnPassant, grids, 8 - (input.charAt(1) - 48), input.charAt(0) - 65, 8 - (input.charAt(4) - 48), input.charAt(3) - 65, xBlackPositionAfterMoved, yBlackPositionAfterMoved);
				
				if(isWhiteEnPassant)
				{
					enPassantMove(input, turn, grids, checkBlack, checkWhite);
				}
			}else
			{
				validMovement(grids, input, turn);
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
				
				validMovement(grids, input, turn);
				promotion.pawnPromotion(grids, (turn * -1), (8 - (input.charAt(4) - 48)), (input.charAt(3) - 65));
			}else if((8 - (input.charAt(4) - 48)) - (8 - (input.charAt(1) - 48)) == 1 && (((input.charAt(0) - 65) - (input.charAt(3) - 65) == -1) || ((input.charAt(0) - 65) - (input.charAt(3) - 65) == 1)) && grids[8 - (input.charAt(4) - 48)][input.charAt(3) - 65] == 0)
			{
				boolean isBlackEnPassant = ep.enPassantBlack(whiteEnPassant, grids, 8 - (input.charAt(1) - 48), input.charAt(0) - 65, 8 - (input.charAt(4) - 48), input.charAt(3) - 65, xWhitePositionAfterMoved, yWhitePositionAfterMoved);
			
				if(isBlackEnPassant)
				{
					enPassantMove(input, turn, grids, checkBlack, checkWhite);
				}
			}else
			{
				validMovement(grids, input, turn);
				promotion.pawnPromotion(grids, (turn * -1), (8 - (input.charAt(4) - 48)), (input.charAt(3) - 65));
			}
		}
	}
	
	public void enPassantMove(String input, int turns, int grids[][], int checkBlack, int checkWhite)
	{
		PrintBoard pb = new PrintBoard();
		Checkmate cm = new Checkmate();
		if(turns == 1)
		{
			int temp = 0;
			
			grids[8 - (input.charAt(4) - 48)][input.charAt(3) - 65] = grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65];
			grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65] = 0;
			temp = grids[8 - (input.charAt(4) - 48) + 1][input.charAt(3) - 65];
			grids[8 - (input.charAt(4) - 48) + 1][input.charAt(3) - 65] = 0;
			
			InvalidMove invalidMove = new InvalidMove();
			
			if(invalidMove.validateInvalidMove(grids, turns)) {
				grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65] = grids[8 - (input.charAt(4) - 48)][input.charAt(3) - 65];
				grids[8 - (input.charAt(4) - 48)][input.charAt(3) - 65] = 0;
				grids[8 - (input.charAt(4) - 48) + 1][input.charAt(3) - 65] = temp;
				
				System.out.println("");
				checkSign(grids, turns);
				System.out.println("");
				System.out.println("!! please protect your king !!");
				System.out.println("");
			}
			else {
				System.out.println("");
				checkSign(grids, turns);
				if(checkBlack == 1)
				{
					if(cm.checkmate(grids, turns *= -1, 8 - (input.charAt(4) - 48), input.charAt(3) - 65)) {
						pb.print(grids);
						System.out.println("");
						System.out.println("Game Over, White Win!");
						endIndicator = 1;
					}
					else {
						turn *= -1;
						System.out.println("Go!");
					}
				}
				
				System.out.println("");
				turn *= -1;
			}	
		}else if(turns == -1)
		{
			int temp = 0;
			
			grids[8 - (input.charAt(4) - 48)][input.charAt(3) - 65] = grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65];
			grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65] = 0;
			temp = grids[8 - (input.charAt(4) - 48) - 1][input.charAt(3) - 65];
			grids[8 - (input.charAt(4) - 48) - 1][input.charAt(3) - 65] = 0;
			
			InvalidMove invalidMove = new InvalidMove();
			if(invalidMove.validateInvalidMove(grids, turns)) {
				grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65] = grids[8 - (input.charAt(4) - 48)][input.charAt(3) - 65];
				grids[8 - (input.charAt(4) - 48)][input.charAt(3) - 65] = 0;
				grids[8 - (input.charAt(4) - 48) - 1][input.charAt(3) - 65] = temp;
				
				System.out.println("");
				checkSign(grids, turns);
				System.out.println("");
				System.out.println("!! please protect your king !!");
				System.out.println("");
			}
			else {
				System.out.println("");
				checkSign(grids, turns);
				if(checkWhite == 1)
				{
					if(cm.checkmate(grids, turns *= -1, 8 - (input.charAt(4) - 48), input.charAt(3) - 65)) {
						pb.print(grids);
						System.out.println("");
						System.out.println("Game Over, Black Win!");
						endIndicator = 1;
					}
					else {
						turn *= -1;
						System.out.println("Go!");
					}
				}
				
				System.out.println("");
				turn *= -1;
			}	
		}
		
	}
	 
	public String getInput() {
		return input;
	}
	
	public void validMovement(int[][] grids, String input, int turns) {
		PrintBoard pb = new PrintBoard();
		int temp;
		temp = grids[8 - (input.charAt(4) - 48)][input.charAt(3) - 65];
		grids[8 - (input.charAt(4) - 48)][input.charAt(3) - 65] = grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65];
		grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65] = 0;
		InvalidMove invalidMove = new InvalidMove();
		if(invalidMove.validateInvalidMove(grids, turns)) {
			grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65] = grids[8 - (input.charAt(4) - 48)][input.charAt(3) - 65];
			grids[8 - (input.charAt(4) - 48)][input.charAt(3) - 65] = temp;
			System.out.println("");
			checkSign(grids, turns);
			System.out.println(""); 
			System.out.println("!! please protect your king !!");
			System.out.println("");
		}
		else { 
			Checkmate cm = new Checkmate();
			
			Stalemate stalemate = new Stalemate(); 
			if(stalemate.stalemate(grids, turns*-1) == true) {
				pb.print(grids);
				System.out.println(""); 
				System.out.println("Stalemate Draw!");
				endIndicator = 1;
			}
			
			System.out.println("");		
			
			checkSign(grids, turns);
			
			if(turns == 1 && checkBlack == 1)
			{
				if(cm.checkmate(grids, turns *= -1, 8 - (input.charAt(4) - 48), input.charAt(3) - 65)) {
					pb.print(grids);
					System.out.println(""); 
					System.out.println("Game Over, White Win!");		
					endIndicator = 1;
				}
				else {
					turn *= -1;
					System.out.println("Go!");
				}
			}else if(turns == -1 && checkWhite == 1)
			{
				if(cm.checkmate(grids, turns *= -1, 8 - (input.charAt(4) - 48), input.charAt(3) - 65)) { 
					pb.print(grids);
					System.out.println("");
					System.out.println("Game Over, Black Win!");
					endIndicator = 1;
				}
				else {
					turn *= -1;
					System.out.println("Go!");
				}
			}else
			{
				System.out.println("");
				turn = turns * -1;
			}		
		}	
	}
	
	public int endIndicator()
	{
		return endIndicator;
	}
	
	public boolean isEnd(int endIndicator) {
		if(endIndicator == 1) return true;
		return false;
	}
}

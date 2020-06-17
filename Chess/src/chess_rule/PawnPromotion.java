package chess_rule;

import java.util.Scanner;

public class PawnPromotion {
	Scanner scan = new Scanner(System.in);
	public void pawnPromotion(int[][] gridsArray,int turn, int x, int y) {
		if(turnWhite(turn)) {
			if(x == 0) {
				gridsArray[x][y] = choosePiece(turn);
			}
		}
		else if(turnBlack(turn)) {
			if(x == 7) {
				gridsArray[x][y] = choosePiece(turn);
			}
		}
	}
	
	public int choosePiece(int turn) {
		int piece;
		System.out.println("1. Bishop");
		System.out.println("2. Knight");
		System.out.println("3. Rook");
		System.out.println("4. Queen");
		do {
			System.out.print("Choose Piece : ");
			piece = scan.nextInt(); scan.nextLine();
			System.out.println();
		} while(piece < 1 || piece > 4);
		
		if(turnWhite(turn)) {
			switch (piece) {
			case 1:
				return 4;
			case 2:
				return 3;
			case 3:
				return 2;
			case 4:
				return 5;
			}	
		}	
		else if(turnBlack(turn)) {
			switch (piece) {
			case 1:
				return 10;
			case 2:
				return 9;
			case 3:
				return 8;
			case 4:
				return 11;
			}
		}
		return 0;
	}

	private boolean turnBlack(int turn) {
		return turn == -1;
	}

	private boolean turnWhite(int turn) {
		return turn == 1;
	}
}

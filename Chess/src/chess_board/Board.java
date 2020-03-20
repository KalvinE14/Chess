package chess_board;

import java.util.Scanner;

import chess_piece.Knight;
import chess_piece.Pawn;
import chess_piece.Rook;


public class Board {
	private int[][] grids;
	
	public int[][] getGrids() {
		return grids;
	}

	public void setGrids(int[][] grids) {
		this.grids = grids;
	}

	private int turn;

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
			do{ 
				System.out.print("white move: ");
				input = scan.nextLine();
				
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
		else if(turn != 1) {
			do {
				System.out.print("black move: ");
				input = scan.nextLine();
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
	}

	private void pawnMovement(String input, Pawn pawn) {
		if(turn == 1 && pawn.validateMovement(grids, (8 - (input.charAt(1) - 48)), (input.charAt(0) - 65), (8 - (input.charAt(4) - 48)), (input.charAt(3) - 65))) {
			validMovement(input);
		}	
		else if(pawn.validateBlackMovement(grids, (8 - (input.charAt(1) - 48)), (input.charAt(0) - 65), (8 - (input.charAt(4) - 48)), (input.charAt(3) - 65))){
			validMovement(input);
		}
	}

	private void validMovement(String input) {
		grids[8 - (input.charAt(4) - 48)][input.charAt(3) - 65] = grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65];
		grids[8 - (input.charAt(1) - 48)][input.charAt(0) - 65] = 0;
		turn *= -1;
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

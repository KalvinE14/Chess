package chess_board;

public class Board {
	private int[][] grids;
	private int turn;
	
	public Board() {
		grids = new int[8][8];
		turn = 1;
	}
	
	public void print() {
		int boardNumber = 8;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
			//buat ngambil value dr masing2 grid
			
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
				if(j == 7) {
					System.out.print(boardNumber);
					boardNumber--;
				}
			}
			
			System.out.println();
			
			if(i == 7) {
				for (int j = 0; j < 8; j++) {
					System.out.print((char)(j + 'A') + " ");
				}
			}
		}
	}
}
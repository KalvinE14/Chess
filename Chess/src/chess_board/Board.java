package chess_board;

public class Board {
	private int[][] grids;
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
	}
}

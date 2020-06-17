package chess_board;

public class PrintBoard {
	
	public void print(int[][] grids) {	
		int boardNumber = 8;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
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
		System.out.println();
	}
}

package chess_rule;

public class EnPassant {
	public boolean enPassantWhite(boolean blackFlagEnPassant, int gridsArray[][], int x1,int y1, int x2, int y2, int xBlackPositionAfterMoved, int yBlackPositionAfterMoved)
	{
		if(blackFlagEnPassant == true && x1 == xBlackPositionAfterMoved && (y1-1 == yBlackPositionAfterMoved || y1+1 == yBlackPositionAfterMoved) && 
				(x2+1 == xBlackPositionAfterMoved && y2 == yBlackPositionAfterMoved) && gridsArray[x2+1][y2] >=7 && gridsArray[x2+1][y2] <= 12)
		{
			return true;
		}else
		{
			return false;
		}
	}
	
	public boolean enPassantBlack(boolean whiteFlagEnPassant, int gridsArray[][], int x1,int y1, int x2, int y2, int xWhitePositionAfterMoved, int yWhitePositionAfterMoved)
	{
		if(whiteFlagEnPassant == true && (x1 == xWhitePositionAfterMoved && (y1-1 == yWhitePositionAfterMoved || y1+1 == yWhitePositionAfterMoved) &&
				(x2-1 == xWhitePositionAfterMoved && y2 == yWhitePositionAfterMoved)) && gridsArray[x2-1][y2] >=1 && gridsArray[x2-1][y2] <= 6)
		{
			return true;
		}else
		{
			return false;
		}
	}
}

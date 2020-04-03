package chess_rule;

public class InvalidMove {
	public boolean validateInvalidMove(int gridsArray[][], int turn) {
		Check check = new Check();
		if(check.validateCheck(gridsArray, turn * -1)) {
			return true;
		}
		return false;
	}
}

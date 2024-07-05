package ver1;

public enum OperationKey {
	
	CLEAR(6), EQUAL(5), POWER(3), 
	MULTIPLY(2), DIVISION(2), ADD(1), SUBTRACT(1), 
	OPEN_PARENTHESIS(0),CLOSE_PARENTHESIS(0);
	
	int precedent;
	
	OperationKey(int precedent) {
		this.precedent = precedent;
	}
	
	int getPrecedent() {
		return precedent;
	}
}

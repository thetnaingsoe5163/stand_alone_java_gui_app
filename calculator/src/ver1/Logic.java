package ver1;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Logic {

	StringBuilder expression;
	ArrayDeque<Double> num;
	ArrayDeque<OperationKey> okeys;

	Logic(Formatter f) {
		this.expression = f.getExpression();
		this.num = new ArrayDeque();
		this.okeys = new ArrayDeque();
	}
	
	
	Double operate() {
		calculate();
		allCalculation();
		return num.pop();
		//modfify
		
		
	}
	
	void calculate() {
		int i = 0;
		while(i < expression.length()) {
			StringBuilder sb = new StringBuilder();
//			System.out.println(i);
//			System.out.println("i : " + i);
			while(i < expression.length() && !isKey(expression.charAt(i))) {
//				System.out.print(expression.charAt(i));
				sb.append(expression.charAt(i));
				i++;
			}
			if(!sb.isEmpty()) {
				num.push(Double.valueOf(sb.toString()));
			}
			if(i < expression.length() && isKey(expression.charAt(i))) {
				subCalculate(getOperationKey(expression.charAt(i)), i);
			}
//			System.out.println();
			i++;
		}
	}
	
	void subCalculate(OperationKey ok, int index) {
		if(okeys.isEmpty()) {
			okeys.push(ok);
		} else {
			if((okeys.peek().getPrecedent() < ok.getPrecedent() && !ok.equals(OperationKey.CLOSE_PARENTHESIS)) || 
					ok.equals(OperationKey.OPEN_PARENTHESIS)) {
				okeys.push(ok);
			} else {
				if(ok.equals(OperationKey.CLOSE_PARENTHESIS)) {
					calculateParenthesis();
				} else {
					calculateAccordingtoPrecednet(ok);
				}
			}
		}
	}
	
	void calculateAccordingtoPrecednet(OperationKey currentKey) {
		while(!okeys.isEmpty() && okeys.peek().getPrecedent() >= currentKey.getPrecedent() && 
				!okeys.peek().equals(OperationKey.OPEN_PARENTHESIS) && !num.isEmpty()) {
			OperationKey key = okeys.pop();
			double b = num.pop();
			double a = num.pop();
			double result = operate(key, a, b);
			num.push(result);
		}
		okeys.push(currentKey);
	}
	
	void calculateParenthesis() {
		
		while(okeys.peek() != OperationKey.OPEN_PARENTHESIS) {
			OperationKey key = okeys.pop();
			double b = num.pop();
			double a = num.pop();
			double result = operate(key, a, b);
			num.push(result);
		}
		OperationKey popping = okeys.pop();
	}
	
	void allCalculation() {
		while(!okeys.isEmpty()) {
			var key = okeys.pop();
			double b = num.pop();
			double a = num.pop();
			double result = operate(key, a, b);
			num.push(result);
		}
	}

	boolean isKey(char c) {
		switch (c) {
		case '^':
			return true;
		case '*':
			return true;
		case '/':
			return true;
		case '+':
			return true;
		case '-':
			return true;
		case '(':
			return true;
		case ')':
			return true;
		case 'C':
			return true;
		case '=':
			return true;
		default:
			return false;
		}
	}

	int getPrecedent(char c) {
		switch (c) {
		case '^':
			return OperationKey.POWER.getPrecedent();
		case '*':
			return OperationKey.MULTIPLY.getPrecedent();
		case '/':
			return OperationKey.DIVISION.getPrecedent();
		case '+':
			return OperationKey.ADD.getPrecedent();
		case '-':
			return OperationKey.SUBTRACT.getPrecedent();
		case '(':
			return OperationKey.OPEN_PARENTHESIS.getPrecedent();
		case ')':
			return OperationKey.CLOSE_PARENTHESIS.getPrecedent();
		case 'C':
			return OperationKey.CLEAR.getPrecedent();
		case '=':
			return OperationKey.EQUAL.getPrecedent();
		default:
			throw new IllegalArgumentException();
		}
	}
	
	OperationKey getOperationKey(char c) {
		switch (c) {
		case '^':
			return OperationKey.POWER;
		case '*':
			return OperationKey.MULTIPLY;
		case '/':
			return OperationKey.DIVISION;
		case '+':
			return OperationKey.ADD;
		case '-':
			return OperationKey.SUBTRACT;
		case '(':
			return OperationKey.OPEN_PARENTHESIS;
		case ')':
			return OperationKey.CLOSE_PARENTHESIS;
		case 'C':
			return OperationKey.CLEAR;
		case '=':
			return OperationKey.EQUAL;
		default:
			throw new IllegalArgumentException();
		}
	}
	
	double operate(OperationKey ok, double a, double b) {
		switch (ok) {
		case POWER:
			return Math.pow(a, b);
		case MULTIPLY:
			return a * b;
		case DIVISION:
			return a / (b * 1.0);
		case ADD:
			return a + b;
		case SUBTRACT:
			return a - b;
//		case '(':
//			return OperationKey.OPEN_PARENTHESIS.getPrecedent();
//		case ')':
//			return OperationKey.CLOSE_PARENTHESIS.getPrecedent();
//		case 'C':
//			return OperationKey.CLEAR.getPrecedent();
//		case '=':
//			return OperationKey.EQUAL.getPrecedent();
		default:
			throw new IllegalArgumentException();
		}
	}
	
	void keyAndNum() {
		System.out.println("Key");
		for (OperationKey k : okeys) {
			System.out.println(k);
		}
		System.out.println("===========");
		System.out.println("Number");
		for (Double n : num) {
			System.out.println(n);
		}
	}
}

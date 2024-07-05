package ver1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Formatter {
	
	private StringBuilder sb;
	private ArrayList<OperationKey> okeys;
	
	private ArrayList<Integer> numberLastindex;
	
	char[] validKey = {'0', '1', '2', '3', '4', 
			'5', '6', '7', '8', '9', 
			'^','*', '/', '+', '-',
			'.', '(', ')'}; 
	
	ArrayList<Character> validKeyList;
	
	//pass
	//"3*2/(2*(5+6))" = 0.2727272727
	//"88*5+9-1*(2*(8+3))" = 427
	//"(2+3)*(4-1)+(6/2)" = 18
	//"1+2"

//	StringBuilder expression = new StringBuilder("1+2");
	
	StringBuilder expression;
	
	
	public Formatter(StringBuilder expression) {
		this.expression = expression;
		this.okeys = new ArrayList();
		
		this.validKeyList = convertToList(validKey);
		
	}
	
	ArrayList<Character> convertToList(char[] arr) {
		ArrayList list = new ArrayList<Character>(); 
		for (char c : arr) {
			list.add(c);
		}
		return list;
	}
	
	boolean canProcess() {
		boolean result = true;
		if(containInvalidKey() || !isBalancedParenthesis()) {
			return result = false;
		}
		return result;
	}
		
	boolean isBalancedParenthesis() {
		boolean result = false;
		ArrayDeque<Character> stack = new ArrayDeque<Character>();
		var list = getParenthesis();
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i) == '(') {
				stack.push(list.get(i));
			}
			if(list.get(i) == ')') {
				if(stack.isEmpty()) {
					return result;
				}
				else {
					stack.pop();
				}
			}
		}
		return stack.isEmpty();
	}
	
	ArrayList<Character> getParenthesis() {
		var list = new ArrayList<Character>();
		for(int i = 0; i < expression.length(); i++) {
			if(expression.charAt(i) == '(' || expression.charAt(i) == ')') {
				list.add(expression.charAt(i));
			}
		}
		return list;
	}
	
	boolean containInvalidKey() {
		boolean result = false;
		for(int i = 0; i < expression.length(); i++) {
			if(!validKeyList.contains(expression.charAt(i))) {
				return true;
			}
		}
		return result;
	}
	
	StringBuilder getExpression() {
		return expression;
	}
	
	boolean isKey(char c) {
		switch(c) {
		case '^' : return true;
		case '*' : return true;
		case '/' : return true;
		case '+' : return true;
		case '-' : return true;
		case '(' : return true;
		case ')' : return true;
		case 'C' : return true;
		case '=' : return true;
		default : return false;
		}
	}
	
}

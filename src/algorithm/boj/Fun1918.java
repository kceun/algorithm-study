package algorithm.boj;

import java.util.Scanner;
import java.util.Stack;

public class Fun1918 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String res = "";
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0 ; i<str.length();i++) {
			Character ch = str.charAt(i);	
			switch(ch) {
			case '+': case '-': {
				while(!stack.empty() && stack.peek() != '(') {
					res += stack.pop();					
				}
				stack.push(ch);
				break;
			}
			case '/': case '*': {
				while(!stack.empty() && (stack.peek()=='*' || stack.peek()=='/')) {
					res += stack.pop();
				}
				stack.push(ch);
				break;
			}
			case '(' : { 
				stack.push(ch);break;
			}
			case ')' : {
				while(true) {
					if(stack.peek()=='(') {
						stack.pop();
						break;
					}
					else
						res+=stack.pop();
				}
				break;
			}
			default: res+=ch;
			}
		}

		while(!stack.isEmpty()) {
			res +=stack.pop();
		}
		
		System.out.println(res);
	}

}

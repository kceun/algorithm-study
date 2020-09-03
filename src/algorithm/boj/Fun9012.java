package algorithm.boj;

import java.util.Scanner;
import java.util.Stack;

public class Fun9012 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		String num = sc.nextLine();
		
		
		for(int i=0;i<Integer.parseInt(num);i++) {
			boolean res = true;
			String str = sc.nextLine();
			Stack<String> stack = new Stack<String>();
			for(int j=0;j<str.length();j++) {
				
				if(str.charAt(j)=='(')  	//여는 괄호라면
					stack.push("("); 		//스택에 넣어둔다.
				else {						//여는 괄호가 아니라면 (=닫는 괄호라면)
					if(stack.isEmpty()) { 	//stack이 비어있는지 확인한다.
						res=false;			//비어있으면 한쌍이 될 수 없다.
						break;
					} else {
						stack.pop();		//여는괄호를 빼서 한쌍으로 만들어준다.
					}
				}
			}
			if(stack.isEmpty() && res)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	
		
	}

	
}

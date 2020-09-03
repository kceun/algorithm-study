package algorithm.boj;

import java.util.Scanner;
import java.util.Stack;

public class Fun3986 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int tc = Integer.parseInt(sc.nextLine());
		int cnt = 0;
		for(int i =0; i<tc;i++) {
			String str = sc.nextLine();
			Stack<Character> stack = new Stack<Character>();
			for(int j=0;j<str.length();j++) {
				if(stack.isEmpty())
					stack.push(str.charAt(j));
				else if(stack.peek().equals(str.charAt(j))) {
					stack.pop();	
				} else {
					stack.push(str.charAt(j));
				}
					
					
			}
			
			if(stack.empty())
				cnt++;
			
		}
		System.out.println(cnt);
	}

}

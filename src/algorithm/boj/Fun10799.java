package algorithm.boj;

import java.util.Scanner;
import java.util.Stack;

public class Fun10799 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		Stack<String> stack = new Stack<String>();
		int lazer = 0;
		int sum=0;
		
		for(int i=0;i<str.length();i++) {
			
			if(str.charAt(i)=='(')
				stack.push("(");
			else {
				
				if(str.charAt(i-1)=='(') { //앞의것을 보며 레이저인지 확인하는것 
					stack.pop();			// 레이저였던 ( 를 빼주기
					sum += stack.size();	// 현재까지의 레이저로 나눈것의 조각
				}
				else {
					stack.pop();			// 막대기의 시작이었던 ( 빼주기
					sum += 1;				// 끝이기에 마지막 조각
				}
						
			}
			
		}
		
		System.out.println(sum);
	}

}

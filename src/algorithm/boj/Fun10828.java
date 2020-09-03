package algorithm.boj;

import java.util.Scanner;

public class Fun10828 {

	public static int[] stack;
	public static int top = -1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int tc = Integer.parseInt(sc.nextLine());
		
		stack = new int[tc];
		
		for(int i =0;i<tc;i++) {
			String str = sc.next();
			switch(str) {
			case "push": {
				int num = Integer.parseInt(sc.next());
				push(num);
				break;
			}
			case "pop":		pop();		break;
			case "size": 	size();		break;
			case "empty": 	empty();	break;
			case "top":		top();		break;
			}
			
		}

		
	}

	public static void push(int num) {
		stack[++top] = num;
	}
	
	public static void pop() {
		if(top<0)
			System.out.println(-1);
		else
			System.out.println(stack[top--]);
	}
	public static void size() {
		System.out.println(top+1);
	}
	public static void empty() {
		if(top<0)
			System.out.println(1);
		else
			System.out.println(0);
	}
	public static void top() {
		if(top<0)
			System.out.println(-1);
		else
			System.out.println(stack[top]);
	}
}

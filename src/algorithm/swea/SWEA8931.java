package algorithm.swea;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class SWEA8931 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		System.setIn(new FileInputStream("8931input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		
		for(int tc=0;tc<T;tc++) {
			int ans = 0;
			int N = sc.nextInt(); // testcase갯수
			Stack<Integer> stack = new Stack<>();
			
			for (int i = 0; i < N; i++) {
				int num = sc.nextInt();
				if(num==0) {
					stack.pop();
					continue;
				}
				stack.push(num);
			}
			
			while(!stack.isEmpty()) {
				ans+=stack.pop();
			}
			
			
			System.out.println("#"+(tc+1)+" "+ans);
		}
	}

}

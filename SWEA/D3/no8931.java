import java.util.*;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
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

import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=0;tc<T;tc++) {
			int len = sc.nextInt();
			String ans = sc.next();
			String me = sc.next();
			int cnt = 0;
			
			for(int i=0;i<ans.length();i++) {
				if(ans.charAt(i)==me.charAt(i))
					cnt++;
			}
			
			System.out.println("#"+(tc+1)+" "+cnt);
		}
	}
}

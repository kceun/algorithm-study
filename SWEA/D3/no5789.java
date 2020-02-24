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
			int N =sc.nextInt();
			int Q =sc.nextInt();
			int[] box = new int[N];
			
			for(int i=1;i<=Q;i++) {
				int L = sc.nextInt();
				int R = sc.nextInt();
				
				for(int j=L-1;j<R;j++) {
					box[j]=i;
				}
			}
			
			System.out.print("#"+(tc+1));
			for(int i : box) {
				System.out.print(" "+i);
			}
			System.out.println();
		}
	}
}

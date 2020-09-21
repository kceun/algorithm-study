package algorithm.boj;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Fun2156 {

	public static int[] wine;
	public static int[] dp;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		wine = new int[N+1];
		dp = new int[N+1];
		for (int t = 1; t <= N; t++) {
			wine[t] = sc.nextInt();
		}
		
		dp[1] = wine[1];
		dp[2] = wine[1]+wine[2];
		
		for (int i = 3; i <= N; i++) {
			//경우의 수
			//1. 앞의 두잔을 마신상태여서 안먹을 경우
			//2. 바로 앞(i-1)꺼만 마신상태에서 지금의 잔도 먹을 경우(+ 4번째 잔부터라면 i-3일때 가장많이 마실 수 있는 양도 더해줌)
			//3. i-2꺼만 마시고 i-1는 안마신상태에서 먹을 경우
			dp[i] = Math.max(dp[i-1], 
					Math.max(wine[i-1]+wine[i]+dp[i-3], 
							dp[i-2]+wine[i]));
			
		}
		
		System.out.println(dp[N]);
		
	}

}

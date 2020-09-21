package algorithm.boj;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Fun2193 {

	public static long[] dp;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		dp = new long[n+1]; // 자리수 n일 때, 이친수의 수
		
		dp[1] =1;
		if(n>1)
			dp[2] =1;
		
		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		System.out.println(dp[n]);
		
	}

}

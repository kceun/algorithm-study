package algorithm.boj;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Fun10844 {

	public static int[][] dp;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		dp = new int[n+1][10];
		
		for (int i = 1; i < 10; i++) {
			dp[1][i] = 1;
		}
		
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j < 10; j++) {
				if(j==1)
					dp[i][j] = (dp[i-1][9] + dp[i-1][7]) % 1000000000;
				else if(j==9)
					dp[i][j] = (dp[i-1][j-1]) %1000000000;
				else
					dp[i][j] = (dp[i-1][j+1] + dp[i-1][j-1]) %1000000000;
			}
		}
		
		long res = 0;
		for (int i = 0; i < 10; i++) {
			res += dp[n][i];
		}
		
		System.out.println(res);
	}

}

package algorithm.boj;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Fun11057 {

	public static long[][] dp;
	public static void main(String[] args) throws FileNotFoundException {
		
		System.setIn(new FileInputStream("input.txt"));

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		dp = new long[n+1][10]; //dp[자리수][0~9로 시작하는 수의 갯수]
		
		//1자리 일때 세팅
		for (int i = 0; i <= 9; i++) {
			dp[1][i] = 1;
		}
		
		//bottom-up계산
		for (int i = 2; i <= n; i++) {
			for (int j = 0; j <= 9; j++) {
				long sum = 0;
				for (int k = j; k <= 9; k++) {
					sum += dp[i-1][k];
				}
				dp[i][j]=sum%10007;
			}
		}
		
		long res = 0;
		for (int i = 0; i <= 9; i++) {
			res += dp[n][i];
		}
		
		System.out.println(res%10007);

	}

}

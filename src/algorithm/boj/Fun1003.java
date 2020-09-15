package algorithm.boj;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Fun1003 {

	public static int n;
	public static int[][] dp;

	public static void main(String[] args) throws FileNotFoundException {

		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 0; t < T; t++) {
			n = sc.nextInt();

			dp = new int[n + 2][2]; // 숫자별 0의갯수, 1의갯수 저장 용도

			dp[0][0] = 1;
			dp[1][1] = 1;

			for (int i = 2; i <= n; i++) {
				for (int j = 0; j < 2; j++) {
					dp[i][j] = dp[i - 1][j] + dp[i - 2][j];
				}
			}

			System.out.println(dp[n][0] + " " + dp[n][1]);

		}

	}

}

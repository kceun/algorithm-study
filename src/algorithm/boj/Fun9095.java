package algorithm.boj;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Fun9095 {

	public static int[] dp;

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int n = sc.nextInt();
			dp = new int[n + 1];

			// dp배열은 n을 1,2,3의 합으로 나타내는 방법의 수 출력
			dp[1] = 1; // 1
			dp[2] = 2; // 1+1 , 2
			dp[3] = 4; // 1+1+1, 1+2, 2+1, 3

			for (int i = 4; i <= n; i++) {
				dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];// +1했을 경우, +2했을 경우, +3했을 경우
			}

			System.out.println(dp[n]);

		}

	}

}

package algorithm.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Fun11053 {

	public static int[] arr;
	public static int[] dp;
	public static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		dp = new int[N]; // 인덱스 별 증가 부분 수열의 최장길이
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dp[0] = 1; // 첫번째는 늘 1이 최장길이이다. 앞에 수가 없기때문에..

		// 자기보다 앞에있는 숫자들의 크기를 비교한다.
		// 크기 비교해서 그 숫자의 최장증가수열길이 +1 를 자신의 최장증가수열길이로 지정한다.
		// 자기 바로앞의 숫자까지 갈때가지 최장증가수열길이는(dp) 여러번 갱신될 수 있다.
		for (int i = 0; i < N; i++) {
			dp[i] =1;
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && dp[j] + 1 > dp[i]) // arr[i]>arr[j]는 앞의 수가 나보다 큰지? dp[j]+1 > dp[i]는 이미 알고있는 더 긴
															// 최장수열이 있는지?
					dp[i] = dp[j] + 1;

			}
			max = Math.max(max, dp[i]);
		}

		System.out.println(max);

	}

}

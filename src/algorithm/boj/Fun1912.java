package algorithm.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Fun1912 {

	public static int[] arr;
	public static int[] dp;
	public static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		dp = new int[N]; // 인덱스 별 연속합중 가장 큰 수
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
		}
		
		dp[0]=arr[0];
		
		for (int i = 1; i < N; i++) {
			dp[i] = arr[i];
			if(dp[i]<dp[i-1]+arr[i]) //지금 나의 수 vs 그 바로앞의 연속합중 가장큰수+나의 수.. 큰것비교
				dp[i] = dp[i-1]+arr[i];
		}
		
		for (int i = 0; i < N; i++) {
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
	}

}

package algorithm.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Fun11055 {
	
	
	public static int[] arr;
	public static int[] dp;
	public static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		dp = new int[N]; // 인덱스 별 증가 부분 수열의 가장 큰 합
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = arr[0];
		
		for (int i = 1; i < N; i++) {
			dp[i] = arr[i];
			for (int j = 0; j < i; j++) {
				if(arr[j]<arr[i] && dp[i] < dp[j]+arr[i]) //현재 비교하는 수보다 기준이 되는 수가 더 큰지? 
															//비교하는 수의 최고 합 + 기준 되는 수가 현재 기준되는 수의 최고 합보다 더 커지는지?
					dp[i]=dp[j]+arr[i];
			}
		}
		
		for (int i = 0; i < N; i++) {
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
	}

}

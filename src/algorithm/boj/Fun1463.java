package algorithm.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Fun1463 {

	public static int N;
	public static int ans = Integer.MAX_VALUE;
	public static int[] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		System.setIn(new FileInputStream("input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		dp = new int[N+1];
		
		//solve

		System.out.println("----------- "+solve(N));
	}
	
	public static int solve(int num) {
		System.out.println(num+"!");
		if(num==1) {
			return 0;
		}
		if(dp[num]>0) {
			System.out.println(num);
			return dp[num];
		}
		dp[num] = solve(num-1)+1;
		
		if(num%3==0) {
			dp[num] = Math.min(solve(num/3)+1,dp[num]);
		}
		if(num%2==0) {
			dp[num] = Math.min(solve(num/2)+1,dp[num]);
		}
		
		return dp[num];
		
	}

}

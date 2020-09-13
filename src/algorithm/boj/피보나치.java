package algorithm.boj;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class 피보나치 {

	public static int n;
	public static int[] dp;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		dp = new int[n+1];
		long ans = solve(n);

		System.out.println(ans);
	}
	
	public static int solve(int num) {
		if(dp[num]!=0)
			return dp[(int) num];
		
		if(num<=1) {
			dp[num] = num;
			return num;
		}
		else {
			dp[num] =solve(num-1) + solve(num-2);
			return dp[num];
			
		}
			
	}

}

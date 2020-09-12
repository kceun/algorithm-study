package algorithm.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Fun12852 {

	public static int[] dp;
	public static ArrayList<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {


		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		dp = new int[n+1];

		dp[0] = dp[1] = 0;
		for (int i = 2; i <= n; i++) {
			
			dp[i]= dp[i-1]+1;
			if(i%3==0) {
				dp[i]=Math.min(dp[i], dp[i/3]+1);
			}
			if(i%2==0) {
				dp[i]=Math.min(dp[i], dp[i/2]+1);
			}
			
		}
		
		System.out.println(dp[n]);
		print(n);
	}
	
	public static void print(int num) {
		if(num==0) return;
		
		System.out.print(num+" ");
		
		
		//바로전거라면 dp[]에 있는 cnt수가 1밖에 차이 안날 것..
		//if-else if 사용이유는.. 안그러면 dp[]의 특정 수일때 가능한 모든  경우의 수가 다출력되기 때문에 되는거아무거나 하나만 출력하자..
		if(num-1 >= 0 && dp[num-1]==dp[num]-1)
			print(num-1);
		else if(num%3==0 && dp[num/3]==dp[num]-1) {
			print(num/3);
		}
		else if(num%2==0 && dp[num/2]==dp[num]-1) {
			print(num/2);
		}		
		
		return;
	}

}

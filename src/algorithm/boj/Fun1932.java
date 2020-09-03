package algorithm.boj;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Fun1932 {
	public static int N, ans = 0;
	public static int[][] map;
	public static int[][] dp;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Fun1932.txt"));
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new int[N+1][N+1];
		dp = new int[N+1][N+1];
		//i는 층 수, j는 해당 층의 방 번호 - 편의상 맨 꼭대기를 1층으로하고 맨아랫층을 N층으로 함
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				map[i][j]=sc.nextInt();
				
				map[i][j] = map[i-1][j-1] > map[i-1][j] ? map[i-1][j-1]+map[i][j] : map[i-1][j]+map[i][j];
				ans = Math.max(ans, map[i][j]);
			}
		}
	
		
		
		//dfs(1,0,0,"");
		System.out.println(ans);
	}
	
//	public static void dfs(int row, int col, int sum,String s) {
//		
//		//1.종료조건 - N층인가? 최대인가?
//		if(row>N) {
//			ans = Math.max(sum, ans);
//			return;
//		}
//		//2.방향탐색
//		//자기 기준으로 층은 한층올리고 방은 자신,자신+1만 돌면 됨
//		for (int i = col; i <= col+1; i++) {
//			
//			if(dp[row+1][i])
//				continue;
//			dfs(row+1,i,sum+map[row][col],s+map[row][col]);
//		}
//	}

}

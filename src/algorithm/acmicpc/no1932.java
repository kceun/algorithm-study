package algorithm.acmicpc;

import java.util.Scanner;

public class no1932 {
	public static int N, ans = 0;
	public static int[][] map;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new int[N+1][N+1];
		//i는 층 수, j는 해당 층의 방 번호 - 편의상 맨 꼭대기를 1층으로하고 맨아랫층을 N층으로 함
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				map[i][j]=sc.nextInt();
				
				map[i][j] = map[i-1][j-1] > map[i-1][j] ? map[i-1][j-1]+map[i][j] : map[i-1][j]+map[i][j];
				ans = Math.max(ans, map[i][j]);
			}
		}
	
		System.out.println(ans);
    }

}

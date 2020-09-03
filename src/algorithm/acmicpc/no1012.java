package algorithm.acmicpc;

import java.util.Scanner;

public class no1012 {

	public static int T,N,M,K,ans = 0;
	public static int[][] map;
	public static boolean[][] visit;
	public static int[] dx = {0,1,0,-1};//동남서북
	public static int[] dy = {1,0,-1,0};//동남서북
	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			ans = 0;
			N = sc.nextInt(); 
			M = sc.nextInt(); 
			K = sc.nextInt();
			map = new int[N][M];
			visit = new boolean[N][M];
			
			for (int i = 0; i < K; i++) {
				int row = sc.nextInt();
				int col = sc.nextInt();
				map[row][col]=1;
			}
			
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j]==0)
						continue;
					if(visit[i][j])
						continue;
					
					visit[i][j]=true;
					dfs(i,j);
					ans++;
				}
			}
			
			System.out.println(ans);
		}			
	}
	
	public static void dfs(int row, int col) {
				

		//방향 탐색
		for (int i = 0; i < dx.length; i++) {
			int nx = row + dx[i];
			int ny = col + dy[i];
			
			//종료조건
			//배열 범위 밖이냐?
			if(nx >= N || ny >= M || nx < 0 || ny < 0 )
				continue;
			//배추가 없냐?
			if(map[nx][ny]==0)
				continue;
			//이미 들른 곳이냐?
			if(visit[nx][ny])
				continue;
			
			visit[nx][ny]=true;
			dfs(nx,ny);
			
		}
	}

}

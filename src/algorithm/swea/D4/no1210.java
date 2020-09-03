package algorithm.swea.D4;

import java.util.Scanner;

public class no1210 {

	public static int[][] map;
	public static boolean[][] visit;
	public static int res = 0;
	public static int fin[] = new int[2]; //도착 지점 x,y좌표
	public static int dx[] = {0,0};
	public static int dy[] = {-1,1};
	public static int dir[]; // 나아갈 방향
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		for (int tc = 0; tc < 10; tc++) {
			int TC = sc.nextInt();
			map = new int[100][100];
			visit = new boolean[100][100];
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					map[i][j] = sc.nextInt();
					if(map[i][j]==2)
						fin= new int[]{i,j};
						
				}
			}
			
			dfs(fin[0],fin[1]);
			
			System.out.println("#"+TC+" "+res);
		}

	}
	
	public static void dfs(int x, int y) {

		//종료조건
		// 0행인가?
		if(x==0) {
			res = y;
			return;
		}

		visit[x][y] =true;
		dir = new int[] {-1,0}; //위로 올라가는 방향(디폴트)
		
		//양옆 방향 check
		for (int i = 0; i < dx.length; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			//범위를 벗어나는가?
			if(nx >= 100 || nx < 0 || ny >= 100 || ny < 0)
				continue;
			
			//사다리가 없는가?
			if(map[nx][ny]==0)
				continue;
			
			//방문한 곳인가?
			if(visit[nx][ny])
				continue;
			
			dir = new int[] {dx[i],dy[i]};
		}
		
		dfs(x+dir[0],y+dir[1]);
	}

}

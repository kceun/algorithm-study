package algorithm.swea.D4;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class no1226 {

	public static int[][] map;
	public static boolean[][] visit;
	public static int[] start;
	public static int[] dx = { -1, 0, 1, 0 };
	public static int[] dy = { 0, 1, 0, -1 };
	public static int res;

	public static void main(String[] args)  {

		Scanner sc = new Scanner(System.in);

		for (int T = 0; T < 10; T++) {
			int tc = sc.nextInt();
			map = new int[16][16];
			visit = new boolean[16][16];
			res = 0;

			for (int i = 0; i < 16; i++) {
				String str = sc.next();
				for (int j = 0; j < 16; j++) {
					map[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
					if (map[i][j] == 2)
						start = new int[] { i, j };
				}
			}

			visit[start[0]][start[1]]=true;
			dfs(start[0], start[1]);
			System.out.println("#"+tc+" "+res);

		}

	}

	public static void dfs(int x, int y) {

		
		
		for (int i = 0; i < dx.length; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			// 범위 벗어나는가?
			if (nx >= 16 || nx < 0 || ny >= 16 || ny < 0)
				continue;

			//이미 들린 곳인가?
			if (visit[nx][ny])
				continue;
			
			// 길이 아닌가?
			if (map[nx][ny] == 1)
				continue;
			
			// 도착지점인가?
			if(map[nx][ny]==3) {
				res = 1;
				return;
			}
			
			visit[nx][ny] = true;
			dfs(nx,ny);
			
		}
	}

}

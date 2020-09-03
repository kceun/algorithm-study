package algorithm.acmicpc;

import java.util.*;

class Point {
	int x;
	int y;
	int cnt;
	
	public Point(int x,int y, int cnt) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}

public class no2178 {

	public static int N,M,ans = Integer.MAX_VALUE;
	public static int[][] map;
	public static boolean[][] visit;
	public static int[] dx = {0,1,0,-1};
	public static int[] dy = {1,0,-1,0};
	public static Queue<Point> q = new LinkedList<Point>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		visit = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				map[i][j] = Character.getNumericValue(str.charAt(j));
			}
		}
		
		q.add(new Point(0,0,1));
		bfs();
		System.out.println(ans);
	}
	
	public static void bfs() {
		
		while(!q.isEmpty()) {
			Point pt = q.poll();
			
			//종료조건
			if(pt.x==N-1 && pt.y==M-1) {
				ans = pt.cnt;
				return;
			}
			
			visit[pt.x][pt.y]= true;
			
			for (int i = 0; i < dx.length; i++) {
				int nx = pt.x + dx[i];
				int ny = pt.y + dy[i];
				
				//범위 벗어나냐?
				if(nx >= N || ny >= M || nx < 0 || ny < 0)
					continue;
				//길이 맞냐?
				if(map[nx][ny]==0)
					continue;
				//이미 방문 했었냐?
				if(visit[nx][ny])
					continue;
				
				visit[nx][ny]=true;
				q.add(new Point(nx,ny,pt.cnt+1));

			}
		}
		
	}
}

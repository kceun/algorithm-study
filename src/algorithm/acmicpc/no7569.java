package algorithm.acmicpc;

import java.util.*;

class Tomato {
	int row;
	int col;
	int height;
	int cnt;
	
	public Tomato(int h,int r,int c,int cnt) {
		this.height=h;
		this.row=r;
		this.col=c;
		this.cnt =cnt;
	}
}
public class no7569 {

	public static int N,M,H,ans = 0;
	public static int[][][] map;
	public static boolean[][][] visit;
	public static Queue<Tomato> q;
	public static int[] dx = {0,1,0,-1}; //동남서북
	public static int[] dy = {1,0,-1,0};
	public static int[] dh = {0,0,0,0,1,-1};
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		M = sc.nextInt();
		N = sc.nextInt();
		H = sc.nextInt();
		map = new int[H][N][M];
		visit = new boolean[H][N][M];
		q = new LinkedList<>();
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					map[i][j][k]= sc.nextInt();
					if(map[i][j][k]==1)
						q.add(new Tomato(i,j,k,0)); // 토마토가 있으면 큐에 넣어줌
				}
			}
		}
		
		bfs();
		System.out.println(ans);
		
	}
	public static void bfs() {
		
		Tomato t = null;
		
		while(!q.isEmpty()) { //큐가 빌 때까지
		
			int nh,nx,ny;
			t = q.poll();
			visit[t.height][t.row][t.col]=true;
			
			//방향 탐색
			//상하좌우
			for (int i = 0; i < dx.length + 2; i++) { //상하좌우 방향 4가지 + 층이동 방향 2가지
				
				//위아래 (층 이동)
				if(i>=4) {		
					nh = t.height + dh[i];
					nx = t.row;
					ny = t.col;
					
				} else {		
					
					nh = t.height;
					nx = t.row + dx[i];
					ny = t.col + dy[i];		
					
				}
	
				//범위 벗어나냐?
				if(nx >= N || ny >= M || nh >= H || nx < 0 || ny < 0 || nh < 0)
					continue;
				//토마토냐? 아니면 빈 박스냐?
				if(map[nh][nx][ny]!=0)
					continue;
				
				visit[nh][nx][ny] = true;
				map[nh][nx][ny] = 1; //익은 토마토가 되었습니다.
				q.add(new Tomato(nh,nx,ny,t.cnt+1));
			}
			
		}
		
		//종료조건
		//안익은 토마토가 있냐?
		if(isAllClear()) {
			ans = t.cnt;
			return;
		} else {
			ans = -1;
		}
	}
	
	public static boolean isAllClear() {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if(map[i][j][k]==0)
						return false;
				}
			}
		}
		return true;
	}

}

package algorithm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class CeDfsBfs {

	public static int N; //행
	public static int M; //열
	public static int[][] map;
	public static boolean[][] visit;
	public static int ans=Integer.MAX_VALUE;
	public static int[] dx = {0,1,0,-1}; //동,남,서,북
	public static int[] dy = {1,0,-1,0};
	public static Queue<int[]> q; //좌표넣을 큐
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		System.setIn(new FileInputStream("Test4.txt"));
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		visit = new boolean[N][M];
		
		// 숫자 셋팅
		for(int i =0;i<N;i++) {
			for(int j=0;j<M;j++) {
				map[i][j] = sc.nextInt();
				//System.out.print(map[i][j]);
			}
			//System.out.println();
		}
		
		//=====================================
		//dfs(0,0,0);
		System.out.println(ans);
		
		bfs();
		System.out.println(ans);
	}
	
	public static void dfs(int row,int col, int cnt) {
		//종료조건
		if(map[row][col]==1) {
			ans = Math.min(cnt, ans);
			return;
		}
		
		//visit[row][col]=true;
		// 동남서북 방향 대로 돌기
		for(int i=0;i<dx.length;i++) {
			int nx = row + dx[i]; //다음 x좌표 - 행
			int ny = col + dy[i]; //다음 y좌표 - 열
			
			//범위 벗어나는지 확인
			if(nx >= N || ny >= M || nx<0 || ny<0)
				continue;
			
			//한번 들렸던 곳인지 확인
			if(visit[nx][ny])
				continue;
			
			visit[row][col]=true;
			dfs(nx,ny,cnt+1);
			//visit[row][col]=false;
			
		}
	}
	
	public static void bfs() {
		q = new LinkedList<>();
		q.add(new int[]{0,0,0});
		int cnt = 0;
		
		while(!q.isEmpty()) {
			int[] pos = q.poll();
			//pos[0] = x좌표
			//pos[1] = y좌표
			//pos[2] = cnt값
			if(map[pos[0]][pos[1]]==1) {
				ans = Math.min(ans,pos[2]);
			}
			
			//방향탐색
			for(int i=0;i<dx.length;i++) {
				int nx = pos[0]+dx[i];
				int ny = pos[1]+dy[i];
				
				//범위 벗어나는지 확인
				if(nx >= N || ny >= M || nx<0 || ny<0)
					continue;
				
				//한번 들렸던 곳인지 확인
				if(visit[nx][ny])
					continue;
				
				
				visit[pos[0]][pos[1]]=true;
				q.add(new int[]{nx,ny,pos[2]+1});
				
				
			}
		
		}
		
	}

}

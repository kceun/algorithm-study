package algorithm.acmicpc;

import java.util.*;

public class no2468 {

	public static int min = Integer.MAX_VALUE , max = Integer.MIN_VALUE;
	public static int N, ans = Integer.MIN_VALUE, cnt = 0;
	public static int[][] map;
	public static int[][] mapCopy;
	public static boolean[][] visit;
	public static boolean[][] flood; //물에 잠겼는지 확인
	public static int[] dx = {0,1,0,-1}; //동남서북 
	public static int[] dy = {1,0,-1,0};
	public static Queue<Integer[]> q;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new int[N][N];
		
		
		q = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j]= sc.nextInt();
				min = Math.min(min, map[i][j]); // 가장 낮은 층 찾기
				max = Math.max(max, map[i][j]); // 가장 높은 층 찾기
			}
		}
		
		//물에 잠길 층 체크하기 (가장 높은 층에서 ~ 가장 낮은 층까지)
		for (int k = max; k >= 0; k--) {
			flood = new boolean[N][N];
			visit = new boolean[N][N];
			cnt = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j]<=k)
						flood[i][j]=true; //물에 잠긴 상태.
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					//물에 잠긴 건물이냐? 아님 이미 방문한 건물이냐?
					if(flood[i][j] || visit[i][j])
						continue;
					
					cnt++; // 영역 하나를 찾음
					q.add(new Integer[] {i,j});
					bfs(); // 해당 영역을 모두 방문 처리 해주기위함
				}
			}
			
			//층별로 나온 영역 값 중 가장 큰값만 계속 확인 후 저장
			ans = Math.max(ans, cnt); 

		}
		
		
		System.out.println(ans);
		
	}
	public static void bfs() {
		
		while(!q.isEmpty()) { 
			Integer[] pos = q.poll();
			
			visit[pos[0]][pos[1]] = true;
			
			for (int i = 0; i < dx.length; i++) {
				int nx = pos[0] + dx[i];
				int ny = pos[1] + dy[i];
				
				//범위 밖인가?
				if(nx >= N || ny >= N || nx < 0 || ny < 0 ) 
					continue;
				//물에 잠긴 건물인가? 아니면 이미 방문했나?
				if(visit[nx][ny] || flood[nx][ny])
					continue;
				
				visit[nx][ny]=true;
				q.add(new Integer[] {nx,ny});
				
			}
			
		}
	}
}

package algorithm.acmicpc;

import java.util.*;

public class no7576 {

	public static int N,M;
	public static int[][] map;
	public static boolean[][] visit;
	public static int[] dx = {0,1,0,-1}; //동남서북
	public static int[] dy = {1,0,-1,0};
	public static int ans=Integer.MAX_VALUE;
	public static ArrayList<Integer[]> yesTom = new ArrayList<Integer[]>(); //익은 토마토 좌표 넣기
	public static Queue<Integer[]> q;
	
	public static void main(String[] args){
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		map = new int[N][M];
		visit = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j]=sc.nextInt();
				if(map[i][j]==1)
					yesTom.add(new Integer[]{i,j,0});
			}
		}
		
		q= new LinkedList<>();
		
		//익은 토마토들 먼저 큐에 넣기 (동시에 실행하기 위하여)
		for (Integer[] i : yesTom) {
			q.add(i);
		}
		
		bfs();
		System.out.println(ans);
		
	}
	
	public static void bfs() {
        //tomato[0] = row 값
		//tomato[1] = col 값
		//tomato[2] = 현재 기준 소요된 day 값
		int day = 0;
		
		while(!q.isEmpty()) { //큐가 빌때까지

			Integer[] tomato = q.poll();
			day = tomato[2];
			//printMap();
			//System.out.println("days : "+tomato[2]);
			
//			// 종료 조건 - 안익은 토마토가 없을 경우
//			ans = isAllClear(tomato[2]);
			// 방향 탐색
			for (int i = 0; i < dx.length; i++) {
				int nx = tomato[0]+dx[i];
				int ny = tomato[1]+dy[i];
				
				
				//범위 벗어나지 않는지 체크
				if(nx >= N || ny >= M || nx < 0 || ny < 0)
					continue;
				//토마토가 없는 경우(빈상자)
				if(map[nx][ny]==-1)
					continue;
				//방문한 곳인지 체크
				if(visit[nx][ny])
					continue;
				
				visit[nx][ny]=true; // 여기들렸음
				map[nx][ny]=1; // 익은 토마토가 되었습니다.
				q.add(new Integer[]{nx,ny,tomato[2]+1});
				

				
			}
			
		}
		// 종료 조건 - 안익은 토마토가 없을 경우
			ans = isAllClear(day);
	}
	
	//안익은 토마토 있나 없나 체킹
	public static int isAllClear(int day) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]==0)
					return -1;
			}
		}
		return day;
	}

	public static void printMap() {
		System.out.println("=====PRINT=====");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}

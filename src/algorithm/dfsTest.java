package algorithm;

import java.util.*;

//import algorithm.boj.Position;

import java.io.*;

//class Position{ //클래스 구조체
//	int row, col,cnt;
//	boolean wall;
//	public Position(int row, int col,int cnt) {
//		this.row = row;
//		this.col = col;
//		this.cnt = cnt;
//	}
//}
public class dfsTest {
	public static final int[] dx = {-1,0,1,0}; //난 이 숫자를 절대로 바꾸징낳겠다.
	public static final int[] dy = {0,1,0,-1}; //북동남서
	private static final int LinkedList = 0;
	public static int map[][];
	public static boolean visit[][];
	public static int ans = Integer.MAX_VALUE;
	public static int N,M;
//	public static Queue<Position> q; //row, col좌표만 
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("Test4.txt"));
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N][M];
		visit = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				dfs(i,j,0); //16번
//			}
//		}
		dfs(0,0,0);
		//bfs();
		
		System.out.println(ans);
		
		
		
	}
	public static void dfs(int row ,int col,int cnt) {
		//1.종료조건
		//System.out.println(row+","+col);
		if(map[row][col] == 1) {
			ans = Math.min(cnt, ans); //경로중에 최솟값
			return;
		}
		
		//2. 방향탐색
		for (int i = 0; i < 4; i++) { //북동남서
			int nx = row + dx[i];
			int ny = col + dy[i];
			
			//예외처리
			if(nx < 0 || nx >= N || ny < 0 || ny >=M) {
				//ㅃ나갓을경웅
				continue;
			}
			//방문처리
			if(visit[nx][ny]) {
				continue;
			}
			visit[row][col]= true; //방문 했다.
			dfs(nx,ny,cnt+1); 
			visit[row][col]= false; //방문 했다.
		}
	
	}
/*	public static void bfs() { //1번
		q = new LinkedList<>();
		
		//어디부터 시작할 것인가.
		q.add(new Position(0,0,0)); //시작 좌표가 들어가.
		q.add(new Position(5,5,0)); //시작 좌표가 들어가.
		 
		while(!q.isEmpty()) { //q가 빌때까지 (여행이 종료될 때까지)
			Position pos = q.poll();
			
			//2. 방향탐색
			for (int i = 0; i < 4; i++) { //북동남서
				int nx = pos.row + dx[i];
				int ny = pos.col + dy[i];
				
				//예외처리
				if(nx < 0 || nx >= N || ny < 0 || ny >=M) {
					//ㅃ나갓을경웅
					continue;
				}
				//방문처리
				if(visit[nx][ny]) {
					continue;
				}

				visit[nx][ny]= true; //방문 했다.
				//종료조건은 어디서 해야할까
				if(map[nx][ny] == 1) { //집어넣을곳이 1이다!
					ans = pos.cnt+1;
					return;
				}
				//q에 넣을 수 있는 친구들만 남는다.
				q.add(new Position(nx,ny,pos.cnt + 1));
				
				//혹은 동시에 퍼져나가기
			}
		}
	}*/
}

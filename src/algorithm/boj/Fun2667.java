package algorithm.boj;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Fun2667 {

	public static int N, rCnt=0; //dCnt = 단지 카운트, rCnt = 단지별 룸 카운트
	public static char dCnt ='0';
	public static char[][] map;
	public static boolean[][] visit;
	public static int[] dx = {0,1,0,-1};
	public static int[] dy = {1,0,-1,0};
	public static Queue<Integer[]> q;
	public static ArrayList<Integer> ans = new ArrayList<>();
	public static void main(String[] args) throws FileNotFoundException {
		
		System.setIn(new FileInputStream("Fun2667.txt"));
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new char[N][N];
		visit = new boolean[N][N];
		q = new LinkedList<>();
		
		//값 넣기
		for (int i = 0; i < N; i++) {
			String str =sc.next();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		//0.0부터 순서대로 돌면서 확인
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visit[i][j] && map[i][j] !='0') {
					dCnt++;
					rCnt=1;
					q.add(new Integer[] {i,j});
					bfs();
					ans.add(rCnt);
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
		//오름차순 정렬
		Collections.sort(ans);
		
		//출력
		System.out.println(ans.size());
		for(Integer i : ans) {
			System.out.println(i);
		}
		
	}
	
	public static void bfs() {

		Integer[] pos = null;
		
		while(!q.isEmpty()) {
			pos = q.poll();
			
			visit[pos[0]][pos[1]] = true;
			map[pos[0]][pos[1]] = dCnt;
			
			//방향 탐색
			for (int i = 0; i < dx.length; i++) {
				int nx = pos[0] + dx[i];
				int ny = pos[1] + dy[i];
				
				//배열 범위에 벗어나는가?
				if(nx >= N || ny >= N || nx < 0 || ny < 0 )
					continue;
				//방이 맞는가?
				if(map[nx][ny]=='0')
					continue;
				//이미 방문한 곳인가?
				if(visit[nx][ny])
					continue;
				
				map[nx][ny] = dCnt; //단지 번호로 바꿔주기
				visit[nx][ny] = true;
				q.add(new Integer[] {nx,ny});
				rCnt++; ////단지별 방 카운트

			}
		}
		
	}

}

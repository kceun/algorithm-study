package algorithm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SWEA2814 {

	public static int T,N,M,ans=Integer.MIN_VALUE;
	public static boolean[] visit;
	public static int[][] map;
	public static void main(String[] args) throws FileNotFoundException {

		System.setIn(new FileInputStream("sample_input.txt"));
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			ans = Integer.MIN_VALUE;
			N = sc.nextInt();
			M = sc.nextInt();
			map = new int[N+1][N+1];
			
			//정점과 간선 연결
			for (int i = 0; i < M; i++) {
				int n1 = sc.nextInt();
				int n2 = sc.nextInt();
				
				map[n1][n2] = map[n2][n1] = 1; //1이 연결되었다는 뜻
			}
			
			//최장경로 찾기
			for (int i = 1; i <= N; i++) {

				visit = new boolean[N+1];
				visit[i]=true;
				dfs(i,1);
				visit[i]=false;
			}
			
			
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	public static void dfs(int num, int cnt) {
		
		//탐색
		for (int i = 1; i <= N; i++) {
			
			//같은 수 끼리의 비교인가?
			if(i==num)
				continue;
			//이미 방문한 곳인가?
			if(visit[i])
				continue;
			//정점끼리 연결이 안된 곳인가?
			if(map[num][i] != 1)
				continue;
			//System.out.println(num+","+i);
			//방문처리
			visit[i]=true;
			dfs(i,cnt+1); //반복.. i와 연결이 된 다른 것들을 탐구하러 ㄱㄱ
			visit[i]=false;
			
		}
		//System.out.println("cnt:"+cnt);
		//종료조건
		ans = Math.max(ans, cnt);
		
	}

}

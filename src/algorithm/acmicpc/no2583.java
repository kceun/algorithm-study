package algorithm.acmicpc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class no2583 {

	public static int N,M,K,ans=0,cnt=0;
	public static int[][] map;
	public static boolean[][] visit;
	public static int[] dx = {0,1,0,-1};
	public static int[] dy = {1,0,-1,0};
	public static ArrayList<Integer> ansList;
	public static void main(String[] args) throws FileNotFoundException {
		
		System.setIn(new FileInputStream("Fun2583.txt"));
		Scanner sc = new Scanner(System.in);
		
		M = sc.nextInt(); //가로 행
		N = sc.nextInt(); //세로 열
		K = sc.nextInt();
		
		map = new int[M][N];
		visit = new boolean[M][N];
		ansList = new ArrayList<Integer>(); 

		for (int k = 0; k < K; k++) {
			
			//꼭짓점 != 칸
			//{0,2} ,{4,4} 의 꼭지점이 주어졌을 때, 사각형을 그리려면  {0.2}~{3.3} 이 범위를 따라야함 오른쪽 아래 x,y에 각각 -1 해줄것.
			//제공되는 문제는 0.0부터 오른쪽으로 갈수록 x값이 증가하는 배열의 형태를 띄고있다..(ex. {0.0} {1.0} {2.0} {3.0} ... {7.0}) 나는 그게 헷갈려서
			//0.0부터 오른쪽으로 갈수록 y값이 증가하는 형태로 만들기 위해 x,y좌표 위치를 바꿔서 받아줬다. (y부터 먼저 받음)
			int leftY = sc.nextInt(); //직사각형의 왼쪽 위 y
			int leftX = sc.nextInt(); //직사각형의 왼쪽 위 x
			int rightY = sc.nextInt(); //직사각형의 오른쪽 아래 y
			int rightX = sc.nextInt(); //직사각형의 오른쪽 아래 x
			
			
			for (int i = 0 ; i <= rightX-leftX-1; i++) {
				for (int j = 0; j <= rightY-leftY-1; j++) {
					map[leftX+i][leftY+j] = 1; //직사각형 범위 표시
				}
			}	
		}
		
//		for (int i = 0; i < map.length; i++) {
//			for (int j = 0; j < map[0].length; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]==0 && !visit[i][j]) {
					cnt=0;
					dfs(i,j);
					ansList.add(cnt);
				}
			}
		}
		
		Collections.sort(ansList);
		System.out.println(ansList.size());
		for(Integer i :ansList) {
			System.out.print(i+" ");
		}
		System.out.println();
		
	}
	public static void dfs(int row, int col) {
		
		cnt++; //0을 찾았다면 무조건 카운팅
		visit[row][col]=true;
		//방향 탐색
		for (int i = 0; i < dx.length; i++) {
			int nx = row + dx[i];
			int ny = col + dy[i];
			
			//종료조건
			//범위 벗어나냐?
			if(nx >= M || ny >= N || nx < 0 || ny < 0)
				continue;
			//직사각형 범위에 포함되냐?
			if(map[nx][ny]==1) {
				continue;
			}
			//이미 들렸던 곳이냐?
			if(visit[nx][ny])
				continue;
			
			dfs(nx,ny);
		}
	}

}

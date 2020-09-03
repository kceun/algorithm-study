package algorithm.swea;

import java.io.*;
import java.util.*;

public class SWEA9282 {

	public static int N,M;
	public static int[][] map;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("sample_input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 0; tc < T; tc++) {
			N= sc.nextInt();
			M= sc.nextInt();
			map = new int[N][M];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			//초콜릿 나누기
			dfs(0,0,N,M); //0.0부터 마지막까지 (사각형)
			
		}
	}
	
	public static void dfs(int row, int col, int h,int w) {
		int min = Integer.MAX_VALUE;
		
		
		//파라미터로 들어온 정보로 사각형 만든 합
		int sum = 0;
		for (int i = row; i < h-1; i++) {
			for (int j = col; j < w-1; j++) {
				sum+=map[i][j];
			}
		}
		
		//가로 탐색
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				
			}
		}
	
	}
}
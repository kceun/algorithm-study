package algorithm.acmicpc;

import java.util.*;

public class no2167 {

	public static int n,m,k,sum=0;
	public static int[][] map;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		map = new int[n+1][m+1];
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		
		//합구하기
		k = sc.nextInt();
		for (int t = 0; t < k; t++) {
			sum = 0;
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			
			for (int i = x1; i <= x2; i++) {
				for (int j = y1; j <= y2; j++) {
					sum+=map[i][j];
				}
			}
			
			System.out.println(sum);
		}

	}

}

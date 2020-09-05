package algorithm.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Fun1780 {

	public static int[][] map;
	public static int[] cnt = new int[3];
	public static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		System.setIn(new FileInputStream("input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		// 배열 세팅
		for (int i = 0; i < N; i++) {
			int y = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			while(st.hasMoreTokens()) {
				map[i][y++] = Integer.parseInt(st.nextToken()); 

			}
			
		}
		
		// solve
		solve(0,0,N);
		
		
		System.out.println(cnt[0]);
		System.out.println(cnt[1]);
		System.out.println(cnt[2]);

	}
	
	public static void solve(int row, int col, int n) {
		
		//현재 종이를 그대로 사용할 수 있는가?
		if(isChecking(row,col,n)) {
			cnt[map[row][col]+1]++; //-1,0,1을 0,1,2 에 넣기위해 +1 해줌
		}
		else {
			//종이 나누기 
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					// 잘린 종이의 크기만큼 각각 반복문 돌기
					//3^K형태이기 때문에 항상 9조각이 난다 (3*3)
					// n/3을 통해 잘린 조각 한 변의 크기 조절하기
					solve(row+(n/3*i),col+(n/3*j),n/3);
				}
			}
			
		}
				
		
		
		
	}
	
	public static boolean isChecking(int r,int c,int n) {
		
		int std = map[r][c];
		
		for (int i = r; i < n+r; i++) {
			for (int j = c; j < n+c; j++) {
				if(std!=map[i][j])
					return false;
			}
		}
		
		return true;
		
	}

}

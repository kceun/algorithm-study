package algorithm.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Fun1992 {

	public static int[][] map;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		System.setIn(new FileInputStream("input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		
		// map 채우기
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for(int j=0 ; j<N ;j++) {
				map[i][j] =(str.charAt(j))-'0';
				
			}
		}
		
		
		// solve
		solve(0,0,N);

		
		// 값 출력
		System.out.println(sb);
	}
	
	public static void solve(int row, int col, int n) {
		

		// n*n개 모두 같은 수로 이루어져 있는가?
		if(isEqualNum(row,col,n)) {
			// 맞다면, 그 수 출력 		
			sb.append(map[row][col]);
		}
		else {
			// 아니라면, 괄호 열고 종이 4등분으로 자르고 그 각각의 등분들의 첫 좌표를 통해 다시 같은 수로 이루어져있는지 확인
			// 괄호열기
			sb.append("(");
			int cut = n/2;
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					solve(row+(i*cut),col+(j*cut),cut);
				}
			}
			// 괄호 닫기
			sb.append(")");
		}

	}

	public static boolean isEqualNum(int r, int c, int n) {
		int comp = map[r][c];
		//현재 조각 크기 만큼만 for문 돌기 (r+n , c+n)
		for (int i = r; i < r+n; i++) {
			for (int j = c; j < c+n; j++) {
				if(map[i][j]!=comp)
					return false;
			}
		}
		
		return true;
	}
}

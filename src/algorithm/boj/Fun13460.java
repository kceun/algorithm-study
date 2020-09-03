package algorithm.boj;

import java.io.*;
import java.util.*;

class Bead {
	int row;
	int col;
	
	public Bead (int r,int c) {
		this.row = r;
		this.col = c;
	}
}
public class Fun13460 {

	public static int N,M, ans=0,dir=0;
	public static String[][] map;
	public static Bead red, blue;
	public static int[] dx = {0,1,0,-1};
	public static int[] dy = {1,0,-1,0};
	public static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("Fun13460.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		st = new StringTokenizer(s);
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new String[N][M];
		
		for (int i = 0; i < N; i++) {
			s = br.readLine();
			st = new StringTokenizer(s);
			for (int j = 0; j < M; j++) {
				map[i][j] = st.nextToken();
				
				if(map[i][j].equals("R"))
					red = new Bead(i,j);
				else if(map[i][j].equals("B"))
					blue = new Bead(i,j);
			}
		}
		for (int i = 0; i < dx.length; i++) {
		
		}

	}
	public static void dfs(int cnt) {
		

		while(true) {
			
			int nx = red.row + dx[dir];
			int ny = red.col + dy[dir];
			
			//종료조건
			//O를 만났는가? 구멍인가?
			if(map[nx][ny].equals("o"))
				return;
			
			//빈공간이 아닌가? (벽이거나 다른 구슬이 있거나)
			//방향 전환
		
			//빨간 구슬 위치
			//파란 구슬 위치
			
		}
		
	}

}

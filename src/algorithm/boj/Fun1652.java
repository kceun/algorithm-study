package algorithm.boj;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Fun1652 {
	
	public static int N,wCnt=0, hCnt=0;
	public static char[][] map;
	public static boolean[][] visit;
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		System.setIn(new FileInputStream("sample_input.txt"));
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new char[N][N];
		visit = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			String line = sc.next();
			for (int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visit[i][j]) {
					widthDfs(i,j,0);
				}
			}
		}
		
		visit = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visit[i][j]) {
					heigthDfs(i,j,0);
				}
			}
		}

		System.out.println(wCnt+" "+hCnt);
	}
	
	//가로  check
	public static void widthDfs(int row, int col, int cnt) {
		
		
		visit[row][col] = true;
		
		if(map[row][col]=='X') {
			if(cnt >= 2) {
				wCnt++;
				//System.out.println("["+row+","+col+"]");
			}
		}
		else {
			int nx = col+1;
			int c = cnt+1; //누울 자리 일경우 ++
			if(nx<N) {
				widthDfs(row,nx,c);
			}
			else {
				if(c >= 2) {
					wCnt++;
					//System.out.println("["+row+","+col+"]");
				}
			}
		}
		
		return;
	}
	
	//세로  check
	public static void heigthDfs(int row, int col, int cnt) {
		
		
		visit[row][col] = true;
		
		if(map[row][col]=='X') {
			if(cnt >= 2) {
				hCnt++;
				//System.out.println("["+row+","+col+"]");
			}
		}
		else {
			int nx = row+1;
			int c = cnt+1; //누울 자리 일경우 ++
			if(nx<N) {
				heigthDfs(nx,col,c);
			}
			else {
				if(c >= 2) {
					hCnt++;
					//System.out.println("["+row+","+col+"]");
				}
			}
		}
		
		return;
	}
}

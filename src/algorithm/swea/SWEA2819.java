package algorithm.swea;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class SWEA2819 {

	public static int T;
	public static int map[][];
	public static HashSet<String> set = new HashSet<>();
	public static int dx[] = {0,1,0,-1};
	public static int dy[] = {1,0,-1,0};
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);

		T =sc.nextInt();
		
		for (int tc = 0; tc < T; tc++) {
			
			set.clear();
			map = new int[4][4];
			
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					map[i][j]=sc.nextInt();
				}
			}
			
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					dfs(i,j,"");
				}
			}
			
			
			//System.out.println(set);
			System.out.println("#"+(tc+1)+" "+set.size());
		}
	}
	
	public static void dfs(int x, int y, String str) {
		if(str.length()==7) {
			set.add(str);
			return;
		}
		
		for (int i = 0; i < dx.length; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			//범위를 벗어나는가?
			if( nx>=4 || nx <0 || ny >= 4 || ny < 0)
				continue;
			
			dfs(nx,ny,str+map[nx][ny]);
		}
	}

}

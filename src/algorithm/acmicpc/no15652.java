package algorithm.acmicpc;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no15652 {

	public static int N,M;
	public static StringBuilder sb = new StringBuilder();
	public static int[] ans;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ans = new int[M];
		
		dfs(1,0);
		System.out.println(sb);
	}
	
	public static void dfs(int num, int idx) {
		
		//종료조건
		//idx가 뽑을 갯수가 됐냐?
		if(idx==M) {	
			for (int i = 0; i < ans.length; i++) {
				sb.append(ans[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = num; i <= N; i++) {
			

			ans[idx]= i;
			dfs(i,idx+1);
			
		}
		
	}

}

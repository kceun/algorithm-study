package algorithm.boj;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Fun15655 {

	public static int N,M;
	public static int[] arr;
	public static int[] ans;
	public static boolean[] visit;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws FileNotFoundException {

		System.setIn(new FileInputStream("Fun15654.txt"));
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		ans = new int[M];
		visit = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			arr[i]=sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		dfs(0,0);
		System.out.println(sb);
		
	}
	
	public static void dfs(int num, int idx) {
		//종료조건
		//뽑을 갯수만큼 뽑았는가?
		if(idx == M) {
			for (int i = 0; i < M; i++) {
				sb.append(ans[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		//탐색
		for (int i = num; i < N; i++) {
			int n = arr[i];
			
			//이미 들렸던 곳인가?
			if(visit[i])
				continue;
			
			visit[i] = true;
			ans[idx] = n;
			dfs(i,idx+1);
			visit[i] = false;
			
		}
	}

}

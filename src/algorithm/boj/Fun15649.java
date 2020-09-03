package algorithm.boj;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Fun15649 {

	public static int N,M;
	public static int[] ans;
	public static boolean[] visit;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Fun15649.txt"));
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); //전체 수 1~N 
		M = sc.nextInt(); //뽑을 갯수
		
		
		for (int i = 1; i <= N; i++) {
			ans = new int[M];
			visit= new boolean[N+1];
			int idx= 0;
			ans[idx++]=i; //첫 시작점 넣어주기
			
			visit[i]=true;
			dfs(idx);
			visit[i]=false;
		}
	}
	
	public static void dfs( int idx) {
		
		//종료조건
		//갯수 다 뽑았는가?
		if(idx==M) {
			for (int i = 0; i < M; i++) {
				System.out.print(ans[i]+" ");
			}
			System.out.println();
			return;
		}
		
		
		for (int i = 1; i <= N; i++) {
			
			//이미 뽑았던 숫자면 제외
			if(visit[i])
				continue;
			
			ans[idx]=i;
			
			visit[i]=true;
			dfs(idx+1);
			visit[i]=false;
			
			
		}
	}

}

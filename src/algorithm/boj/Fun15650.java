package algorithm.boj;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Fun15650 {

	public static int N , M;
	public static boolean visit[];
	public static int[] ans;
	public static void main(String[] args) throws FileNotFoundException {		
		System.setIn(new FileInputStream("Fun15649.txt"));
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); //1~N까지의 숫자
		M = sc.nextInt(); //뽑을 숫자 갯수
		
		ans = new int[M];
		visit = new boolean[N+1];
		dfs(1,0); //숫자 1부터 N까지 돌것 , idx는 0

	}
	
	public static void dfs(int num , int idx) {
		
		//종료조건 
		//M만큼 뽑았는가?
		if(idx==M) {
			for (int i = 0; i < ans.length; i++) {
				System.out.print(ans[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for (int i = num; i <=N; i++) {
			
			//이미 사용한 숫자인가?
			if(visit[i])
				continue;
			
			visit[i]=true;
			ans[idx]=i;
			dfs(i,idx+1);
			visit[i]=false;
		}
	}

}

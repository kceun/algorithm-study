package algorithm.swea.D3;

import java.util.*;

public class no8338 {

	public static int T,N,ANS;
	public static int[] num;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			ANS = 0;
			N = sc.nextInt();
			num = new int[N];
			
			// 숫자 받기
			for (int i = 0; i < N; i++) {
				num[i]= sc.nextInt();
			}
			
			dfs(1,num[0]);
			
			System.out.println("#"+tc+" "+ANS);
		}

	}
	
	public static void dfs(int idx, int sum) {
		//N개의 정수만큼 다 돌았는가?
		if(idx==N) {
			ANS = Math.max(sum,ANS);
			return;
		}
		
		dfs(idx+1,sum+num[idx]); // + 연산자를 선택했을 경우
		dfs(idx+1,sum*num[idx]); // * 연산자를 선택했을 경우
	}

}

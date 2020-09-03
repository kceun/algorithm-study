package algorithm.acmicpc;

import java.util.Scanner;

class Sangdam {
	int time;
	int award;
	
	public Sangdam(int t,int a) {
		this.time = t;
		this.award = a;
		
	}
}

public class no14501 {

	public static int N,max=Integer.MIN_VALUE;
	public static Sangdam[] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new Sangdam[N+1];
		
		for (int i = 1; i <= N; i++) {
			Sangdam s = new Sangdam(sc.nextInt(), sc.nextInt());
			map[i] = s;
		}
		
		dfs(1,0);
		System.out.println(max);
	}
	
	public static void dfs(int idx,int sum) {
		//종료조건
		if(idx>N) {
			max = Math.max(max, sum);
			return;
		}
		
			Sangdam sd = map[idx];
			
			//예외처리
			//N일만에 못끝내는 일인가? (N일째 상담이 1일걸리는거면 보상받을 수 있기때문)
			if(idx+sd.time-1 >N ) {
				dfs(idx+1,sum);
			}
			else {
				//해당날짜에 일하는경우
				dfs(idx+sd.time,sum+sd.award);
				//해당날짜에 일하지 않는 경우
				dfs(idx+1,sum);
			}

	}

}

package algorithm;

import java.io.*;
import java.util.*;

class Work{
	int day, reward;
	public Work(int day , int reward){
		this.day = day;
		this.reward = reward;
	}
}
public class 퇴사 {
	static Work[] work;
	static int N;
	static boolean visit[];
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("test.txt"));
		Scanner sc= new Scanner(System.in);
		
		N = sc.nextInt();
		visit = new boolean[N];
		work = new Work[N];
		for (int i = 0; i < N; i++) {
			work[i] = new Work(sc.nextInt(), sc.nextInt());
		}
		
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			max = Math.max(dfs(i,0),max);
		}
		System.out.println(max);
	}
	public static int dfs(int cur, int reward) {
		if(cur + work[cur].day == N) {
			return reward + work[cur].reward;
		}
		else if(cur + work[cur].day > N) {
			return reward;
		}
		
		for (int i = 0; i < N; i++) {
			//자신이거나 자신 이하의 상담이면 x
			if(cur >= i) continue;
			//현재 상담 시간 이하면 x
			if(cur + work[cur].day > i) continue;
			//N을 넘기면 x
			if(cur + work[cur].day >= N) {
				continue;
			}
			
			max = Math.max(dfs(i , reward + work[cur].reward), max);
		}
		return max;
	}
}

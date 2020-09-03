package algorithm.swea;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class SWEA2817 {
	
	static int N,K, ans = 0;

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		System.setIn(new FileInputStream("2817input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int testcase = sc.nextInt();
		
		for(int tc=0;tc<testcase;tc++) {
			N = sc.nextInt();
			K = sc.nextInt();
			
			int num[] = new int[N];
			boolean visit[] = new boolean[N];
			for(int i=0;i<N;i++) {
				num[i] = sc.nextInt();
			}
			
			powerset(num,visit,0);
			
			
			System.out.println("#"+(tc+1)+" "+ans);
			ans=0;
		}
	}
	
	public static void powerset(int[] num, boolean[] visit,int idx) {
		if(idx==num.length) {
			int sum=0;
			for(int i=0;i<visit.length;i++) {
				if(visit[i]) {
					//System.out.print(num[i]);
					sum+=num[i];
					
				}
			}
			//System.out.print(" sum:"+sum);
			if(sum==K) {
				ans++;		
				sum=0;
			}
			//System.out.println();
		} else {
			//현재 idx 방문 ㅇ
			visit[idx]=true;
			powerset(num,visit,idx+1);
			
			//현재 idx 방문 ㄴ
			visit[idx]=false;
			powerset(num,visit,idx+1);
		}

	}

}

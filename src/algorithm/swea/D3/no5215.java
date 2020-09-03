package algorithm.swea.D3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class no5215 {

	public static int T,N,L,sum;
	public static int[] score,cal;
	public static boolean[] visit;
	public static ArrayList<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		System.setIn(new FileInputStream("sample_input.txt"));
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		for (int i = 1; i <= T; i++) {
			sum=0;
			N = sc.nextInt();
			L = sc.nextInt();
			score = new int[N];
			cal = new int[N];
			visit = new boolean[N];
			
			for (int j = 0; j < N; j++) {
				score[j] = sc.nextInt();
				cal[j] = sc.nextInt();
			}
			
			comb2(0,0,0);
			
			System.out.println("#"+i+" "+sum);
			
		}
		
	}
	
	public static void comb(int idx) {
		if(idx==N) {
			int totalScore=0, totalCal=0;
			
			for (int i = 0; i < N; i++) {
				if(visit[i]) {
					totalScore+=score[i];
					totalCal+=cal[i];
				}
			}
			
			if(totalCal<=L)
				sum = Math.max(totalScore, sum);
			
		} else {
			
			visit[idx] = true;
			comb(idx+1);//,totalScore+score[idx],totalCal+cal[idx]);
			
			visit[idx] = false;
			comb(idx+1);//,totalScore,totalCal);
		}
	}
	
  
  // 더 간단한 
	public static void comb2(int idx,int totalScore, int totalCal) {
		if(idx==N) {
			
			if(totalCal<=L)
				sum = Math.max(totalScore, sum);
			
		} else {
			
			comb2(idx+1,totalScore+score[idx],totalCal+cal[idx]);
			
			comb2(idx+1,totalScore,totalCal);
		}
	}

}

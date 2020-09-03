package algorithm.swea;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class SWEA4466 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("4466input.txt"));
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=0;tc<T;tc++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			int[] score = new int[N];
			int sum =0;
			
			for(int i=0;i<N;i++) {
				score[i]=sc.nextInt();
			}
			
			Arrays.sort(score);
			for(int i=0;i<K;i++) {
				sum+=score[score.length-1-i];
			}
			
			System.out.println("#"+(tc+1)+" "+sum);
		}
		
	}

}

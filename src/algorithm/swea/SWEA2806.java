package algorithm.swea;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class SWEA2806 {

	static int pan[] = {};
	static int N;
	static int sum;
	
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("2806input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = 1;//sc.nextInt();
		
		for(int tc=0;tc<T;tc++) {
			N = 4;//sc.nextInt();
			pan = new int[N];
			sum = 0;
		
			backTracking(0);
			
			System.out.println("#"+(tc+1)+" "+sum);
		}
	}
	public static void backTracking(int level) {
		if(level == N) { //끝까지 왔는가?
			sum++;
//            for(int i=0;i<N;i++){
//                System.out.print(pan[i]);
//            }
//            System.out.println("");

		}
		else {
			for(int i=0;i<N;i++) {
				pan[level] = i;
				if(isPossible(level))
					backTracking(level+1);
			}
		}
		
	}
	
	public static boolean isPossible(int level) {
		for(int i=0;i<level;i++) {
			if(pan[i]==pan[level] || i==level) //같은 행,열
				return false;
			if(Math.abs(pan[i]-pan[level])==Math.abs(i-level))
				return false;
		
		}
		return true;	
	}

}

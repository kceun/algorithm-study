package algorithm.swea;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SWEA5162 {

	public static int A,B,C, ans;
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("5162input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=0;tc<T;tc++) {
			A = sc.nextInt();
			B = sc.nextInt();
			C = sc.nextInt();
			
			
			ans = C/(A>B ? B:A);
			
			System.out.println("#"+(tc+1)+" "+ans);
			
		}
	}

}

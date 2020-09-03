package algorithm.swea;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SWEA8016 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("8016input.txt"));
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=0;tc<T;tc++) {
			
			long N = sc.nextInt();
			long start=0,end=0;
			start=(N-1)*(N-1)+(N-1)*(N-1)+1; //(N-1)^2 + 1 +(N-1)^2
			end=(N*N)+(N*N)-1;				 //N^2 + N^2 -1
			
			System.out.println("#"+(tc+1)+" "+start+" "+end);
		}
	}

}

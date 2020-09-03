package algorithm.swea;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SWEA2072 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("2072input.txt"));
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=0;tc<T;tc++) {
			int sum=0;
			for(int i=0;i<10;i++) {
				int n = sc.nextInt();
				if(n%2==0)
					continue;
				sum+=n;
			}
			System.out.println("#"+(tc+1)+" "+sum);
		}
	}

}

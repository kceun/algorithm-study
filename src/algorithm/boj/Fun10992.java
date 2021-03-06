package algorithm.boj;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Fun10992 {

	public static void main(String[] args) throws FileNotFoundException {
		
		System.setIn(new FileInputStream("input.txt"));
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		// 위쪽
		for (int i = 1; i <= N; i++) {
			
			for (int j = 1; j <= N-i; j++) {
				System.out.print(" ");
			}
			
			for (int j = 1; j <= 2*i-1; j++) {
				
				if(i!=1 && i!=N) {
					
					if(j==1 || j==2*i-1)
						System.out.print("*");
					else
						System.out.print(" ");
					
				}
				else	
					System.out.print("*");
			
			}
			
			System.out.println();
		}
	}
}

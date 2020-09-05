package algorithm.boj;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Fun2440 {

	public static void main(String[] args) throws FileNotFoundException {
		
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		for (int i = 1; i <=N; i++) {
			
			for (int j = N; j >= i; j--) {
				System.out.print("*");
			}
			
			System.out.println();
		}
	}

}

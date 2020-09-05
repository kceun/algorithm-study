package algorithm.boj;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Fun2522 {

	public static void main(String[] args) throws FileNotFoundException {
		
		System.setIn(new FileInputStream("input.txt"));
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		// 위쪽
		for (int i = 1; i <= N; i++) {
			
			for (int j = 1; j <= N-i; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		// 아래쪽
		for (int i = 1; i <= N-1; i++) {
			
			for (int j = 1; j <= i; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= N-i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}

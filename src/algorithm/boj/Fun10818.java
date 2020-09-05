package algorithm.boj;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Fun10818 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i <N; i++) {
			int num = sc.nextInt();
			
			max = Math.max(num, max);
			min = Math.min(num, min);
		}

		System.out.println(min+" "+max);

	}

}

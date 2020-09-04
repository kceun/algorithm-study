package algorithm.boj;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Fun11720 {

	public static void main(String[] args) throws FileNotFoundException {

		System.setIn(new FileInputStream("input.txt"));

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		String str = sc.next();
		int sum = 0;
		for (int j = 0; j < T; j++) {

			sum += Integer.parseInt(String.valueOf(str.charAt(j)));

		}

		System.out.println(sum);

	}

}

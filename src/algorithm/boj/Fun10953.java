package algorithm.boj;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Fun10953 {

	public static void main(String[] args) throws FileNotFoundException {
		
		System.setIn(new FileInputStream("input.txt"));
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			String[] sp = str.split(",");
			
			System.out.println(Integer.parseInt(sp[0])+Integer.parseInt(sp[1]));
		}

	}

}

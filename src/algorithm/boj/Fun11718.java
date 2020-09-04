package algorithm.boj;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Fun11718 {

	public static void main(String[] args) throws FileNotFoundException {
		
		System.setIn(new FileInputStream("input.txt"));
		
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < 100; i++) {
			
			if(!sc.hasNext())
				break;
			System.out.println(sc.nextLine());
		}
	}

}

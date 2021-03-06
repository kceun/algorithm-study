package algorithm.swea;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SWEA8658 {

	public static int T;
	public static void main(String[] args) throws FileNotFoundException {
		
		System.setIn(new FileInputStream("sample_input.txt"));
		
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
			for (int i = 0; i < 10; i++) {
				String s = String.valueOf(sc.nextInt());
				int sum = 0;
				for (int j = 0; j < s.length(); j++) {
					sum += Character.getNumericValue(s.charAt(j));
				}
				
				max = Math.max(max, sum);
				min = Math.min(min, sum);
				
			}
			
			System.out.println("#"+tc+" "+max+" "+min);
		}
	}

}

package algorithm.boj;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Fun1924 {

	public static String[] days = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

	public static void main(String[] args) throws FileNotFoundException {

		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);

		int month = sc.nextInt();
		int day = sc.nextInt();
		
		int totalDay = 0;

		for (int i = 1; i < month; i++) {
			
			switch (i) {
			case 2: {
				totalDay+=28;
				break;
			}
			case 4:
			case 6:
			case 9:
			case 11: {
				totalDay+=30;
				break;
			}
			default: {
				totalDay+=31;
				break;
			}
			}
			
		}

		totalDay += day;
		System.out.println(days[totalDay%7]); 
	}

}

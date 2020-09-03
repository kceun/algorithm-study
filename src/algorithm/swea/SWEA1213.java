package algorithm.swea;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SWEA1213 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		System.setIn(new FileInputStream("1213input.txt"));
		
		Scanner sc = new Scanner(System.in);
		
		for(int t=0;t<10;t++) {
			int TC= sc.nextInt();
			int cnt =0;
			String compStr = sc.next(); //찾을 문자열
			String str = sc.next(); // 원본 문자열
			
			str=str.replace(compStr, "*");
			for(int i=0;i<str.length();i++) {
				if(String.valueOf(str.charAt(i)).equals("*"))
					cnt++;
			}
			
			System.out.println("#"+TC+" "+cnt);
		}
	}

}

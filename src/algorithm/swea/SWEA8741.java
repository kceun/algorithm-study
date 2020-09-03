package algorithm.swea;

import java.io.*;
import java.util.*;

public class SWEA8741 {

	public static int N;
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		System.setIn(new FileInputStream("sample_input.txt"));
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < N; i++) {
			String str = sc.nextLine();
			String ans = "";
			//System.out.println(str);
			String[] sp = str.split(" ");
			
			for (int j = 0; j < sp.length; j++) {
				ans += sp[j].charAt(0);
			}
			
			
			System.out.println("#"+(i+1)+" "+ans.toUpperCase());
		}

	}

}

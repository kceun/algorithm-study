
package algorithm.boj;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Fun11721 {

	public static void main(String[] args) throws FileNotFoundException {
		
		System.setIn(new FileInputStream("input.txt"));
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		int idx = 0;
		
		for (int i = 0; i <= str.length()/10; i++) {
			
			if(idx+11 > str.length()) 
				System.out.println(str.substring(idx,str.length()));
			else 
				System.out.println(str.substring(idx,idx+10));
			
			idx+=10;
		
		}
		
	}

}

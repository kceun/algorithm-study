package algorithm.swea;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SWEA4522 {

	public static void main(String[] args) throws FileNotFoundException {

		System.setIn(new FileInputStream("4522input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			String str = sc.next();
			boolean flag = false;
			for (int i = 0; i < str.length()/2; i++) {
				if(str.charAt(i)!=str.charAt(str.length()-1-i)
						&& str.charAt(str.length()-1-i)!='?' && str.charAt(i)!='?') {
					flag= true;
					break;
				}
			}
			
			if(flag)
				System.out.println("#"+(tc+1)+" Not exist");
			else
				System.out.println("#"+(tc+1)+" Exist");
			
		}
	}

}

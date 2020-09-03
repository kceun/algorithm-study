package algorithm.swea;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class SWEA9317 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("9317input.txt"));
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=0;tc<T;tc++) {
			int len = sc.nextInt();
			String ans = sc.next();
			String me = sc.next();
			int cnt = 0;
			
			for(int i=0;i<ans.length();i++) {
				if(ans.charAt(i)==me.charAt(i))
					cnt++;
			}
			
			System.out.println("#"+(tc+1)+" "+cnt);
		}
		
	}

}

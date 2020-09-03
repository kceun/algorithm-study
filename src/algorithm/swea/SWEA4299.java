package algorithm.swea;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class SWEA4299 {

	public static int T, D,H,M,ans=0;
	public static void main(String[] args) throws FileNotFoundException {

		System.setIn(new FileInputStream("4299input.txt"));
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			D = sc.nextInt();
			H = sc.nextInt();
			M = sc.nextInt();
			ans = 0;
			
			//소개팅 전에 차였냐?
			if(D<11 || (D<=11 && H<11) || (D <= 11 && H <= 11 && D <11) ) {
				System.out.println("#"+(tc+1)+" "+(-1));
				continue;
			}
			
			ans += ((D-11)*24*60);
			ans += ((H-11)*60);
			ans += (M-11);
			
			System.out.println("#"+(tc+1)+" "+ans);
			
		}
	}

}

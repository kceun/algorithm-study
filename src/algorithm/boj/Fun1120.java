package algorithm.boj;

import java.util.Scanner;

public class Fun1120 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		String str2 = sc.next();
		
		int gap = str2.length()-str1.length();
		int index = 0;
		
		int res = str1.length();
		for(int i = 0 ;i<=gap;i++) {
			int diff = 0;
			for(int j = index;j<str1.length();j++) {
				if(str1.charAt(j)!=str2.charAt(j))
					diff++;
			}
			
			if(res>diff) 
				res = diff;
			
			str1 = " "+str1;
			index++;
			
			
		}
		
		System.out.println(res);
	}

}

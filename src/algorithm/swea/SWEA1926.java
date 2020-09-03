package algorithm.swea;

import java.util.*;

public class SWEA1926 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		fun(T);
	}
	
	public static void fun(int n) {
		for(int i = 1; i<=n ; i++) {
			String str = String.valueOf(i);
			boolean flag = false;
			if(i<10) {
				if(i%3==0)
					System.out.print('-');
				else
					System.out.print(i);
			} else {
				for(int j=0;j<str.length();j++) {
					//System.out.println("*"+Character.getNumericValue(str.charAt(j)));
					if(Character.getNumericValue(str.charAt(j))%3==0 
							&& Character.getNumericValue(str.charAt(j))!=0) {
						flag= true;
						System.out.print('-');
					}
				}
				if(!flag) {
					System.out.print(str);
				}
			}
		
			System.out.print(' ');
		}
		System.out.println();
	}

}

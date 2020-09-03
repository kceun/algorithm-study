package algorithm.swea.D3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class no1217 {

	public static int ans;
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("1217input.txt"));
		
		Scanner sc = new Scanner(System.in);
		
		for(int tc=0;tc<10;tc++) {
			int T = sc.nextInt();
			int n = sc.nextInt();
			int m = sc.nextInt();
			ans=1;
			
			fun(n,m);
			
			System.out.println("#"+T+" "+ans);
		}
	}
	public static void fun(int n,int m) {
		if(m==0)
			return;
		ans*=n;
		fun(n,m-1);
	}

}

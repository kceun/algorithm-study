package algorithm.swea.D3;

import java.util.Scanner;
import java.io.FileInputStream;


class no5162
{
    public static int A,B,C, ans;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
        
		for(int tc=0;tc<T;tc++) {
			A = sc.nextInt();
			B = sc.nextInt();
			C = sc.nextInt();
			
			ans = C/(A>B ? B:A);
			
			System.out.println("#"+(tc+1)+" "+ans);
			
		}
	}
}

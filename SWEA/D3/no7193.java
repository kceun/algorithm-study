import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{	
    public static int T,N;
	public static long dec,ans; //10진수
	public static String X;
	public static void main(String args[]) throws Exception
	{
				Scanner sc = new Scanner(System.in);

		
		T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			ans = 0;
			dec= 0;
			N = sc.nextInt();
			X = sc.next();
			
			for (int i = 0; i < X.length(); i++) {
				dec+= Character.getNumericValue(X.charAt(i));
			}
			ans = dec % (N-1);
			
			System.out.println("#"+(tc+1)+" "+ans);
		}
	}
}

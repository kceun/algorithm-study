import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 0; tc < T; tc++) {
			String str = sc.next();
			String ans = "";
			
			for (int i = 0; i < str.length(); i++) {
				if(!ans.contains(String.valueOf(str.charAt(i)))) {
					ans+=str.charAt(i);
				} else {
					ans = ans.replace(String.valueOf(str.charAt(i)), "");
				}
			}
			//ans = ans.trim();
			System.out.println("#"+(tc+1)+" "+ans.length());
		}
	}
}

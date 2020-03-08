import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			String str = sc.next();
			boolean flag = false;
			for (int i = 0; i < str.length()/2; i++) {
            	//서로 마주보는 문자끼리 같으면서 와일드 카드가 아닌가?
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

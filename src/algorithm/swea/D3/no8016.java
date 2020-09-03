package algorithm.swea.D3;

import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class no8016
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=0;tc<T;tc++) {
			long N = sc.nextInt();
			long start=0,end=0;
			start=(N-1)*(N-1)+(N-1)*(N-1)+1; //(N-1)^2 + 1 +(N-1)^2
			end=(N*N)+(N*N)-1;				 //N^2 + N^2 -1
			
			System.out.println("#"+(tc+1)+" "+start+" "+end);
			}
	}
}

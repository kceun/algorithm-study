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
		for(int tc=0;tc<10;tc++) {
			int n = sc.nextInt();
			char[][] map = new char[8][8];
			int cnt = 0;
			
			for(int i=0;i<8;i++) {
				String str= sc.next();
				for(int j=0;j<8;j++) {
					map[i][j] = str.charAt(j);
				}
			}
			//가로
			for(int i=0;i<8;i++) {
				for(int j=0;j<8;j++) {
					boolean flag =false;
					for(int k=0;k<n/2;k++) {
						if((j+n-k-1)>=8 || (j+k)>=8) {
							flag=true;
							break;
						}
						if(map[i][j+k]!=map[i][j+n-k-1]) {
							flag=true;							
						}
					}
					if(!flag) {
						cnt++;
						//System.out.println(i+","+j);
					}

				}
			}
			
			//세로
			for(int i=0;i<8;i++) {
				for(int j=0;j<8;j++) {
					boolean flag =false;
					for(int k=0;k<n/2;k++) {
						if((j+n-k-1)>=8 || (j+k)>=8) {
							flag=true;
							break;
						}
						if(map[j+k][i]!=map[j+n-k-1][i]) {
							flag=true;							
						}
					}
					if(!flag) {
						cnt++;
						//System.out.println(i+","+j);
					}
				}
			}
			
			System.out.println("#"+(tc+1)+" "+cnt);
		}
	}
}

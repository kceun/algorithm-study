package algorithm.swea;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SWEA1215 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		fun();
//		System.setIn(new FileInputStream("1215input.txt"));
//		
//		Scanner sc = new Scanner(System.in);
//		for(int tc=0;tc<10;tc++) {
//			int n = sc.nextInt();
//			char[][] map = new char[8][8];
//			int cnt = 0;
//			
//			for(int i=0;i<8;i++) {
//				String str= sc.next();
//				for(int j=0;j<8;j++) {
//					map[i][j] = str.charAt(j);
//				}
//			}
//			//가로
//			for(int i=0;i<8;i++) {
//				for(int j=0;j<8;j++) {
//					boolean flag =false;
//					for(int k=0;k<n/2;k++) {
//						if((j+n-k-1)>=8 || (j+k)>=8) {
//							flag=true;
//							break;
//						}
//						if(map[i][j+k]!=map[i][j+n-k-1]) {
//							flag=true;							
//						}
//					}
//					if(!flag) {
//						cnt++;
//						//System.out.println(i+","+j);
//					}
//
//				}
//			}
//			
//			//세로
//			for(int i=0;i<8;i++) {
//				for(int j=0;j<8;j++) {
//					boolean flag =false;
//					for(int k=0;k<n/2;k++) {
//						if((j+n-k-1)>=8 || (j+k)>=8) {
//							flag=true;
//							break;
//						}
//						if(map[j+k][i]!=map[j+n-k-1][i]) {
//							flag=true;							
//						}
//					}
//					if(!flag) {
//						cnt++;
//						//System.out.println(i+","+j);
//					}
//				}
//			}
//			
//			System.out.println("#"+(tc+1)+" "+cnt);
//		}
		
	}

	public static void fun() throws FileNotFoundException {
		System.setIn(new FileInputStream("1215input.txt"));
		
		Scanner sc = new Scanner(System.in);
		for(int tc=0;tc<10;tc++) {
			int t = sc.nextInt();
			char map[][] = new char[8][8];
			int ans = 0;
			
			for(int i=0;i<8;i++) {
				String str= sc.next();
				for(int j=0;j<8;j++) {
					map[i][j] = str.charAt(j);
				}
			}

			for(int s=7;s>0;s--) { // 99부터 좁히기
				int cnt = s+1;
				for(int i=0;i<8;i++) {
					for(int j=0;j<8;j++) {
						boolean flag = false;
						for(int k=0;k<cnt/2;k++) {
							if((j+k)>=8 || (j+s-k)>=8) {
								flag=true;
								break;
							}
							if(map[i][j+k]!=map[i][j+s-k]) {
								flag=true;
							}
						}
						if(!flag) {
							if(ans<cnt)
								ans=cnt;
						}
					}
				}
			}
			
			for(int s=7;s>0;s--) { // 99부터 좁히기
				int cnt = s+1;
				for(int i=0;i<8;i++) {
					for(int j=0;j<8;j++) {
						boolean flag = false;
						for(int k=0;k<cnt/2;k++) {
							if((j+k)>=8 || (j+s-k)>=8){
								flag=true;
								break;
							}
							if(map[j+k][i]!=map[j+s-k][i]) {
								flag=true;
							}
						}
						if(!flag) {
							if(ans<cnt)
								ans=cnt;
						}
					}
				}
			}
			
//			for(int s=7;s>0;s--) { // 99부터 좁히기
//				int cnt = s+1;
//				for(int i=0;i<8;i++) {
//					for(int j=0;j<8;j++) {
//						boolean flag = false;
//						for(int k=0;k<s/2;k++) {
//							if((j+k)>=8)
//								break;
//							if(map[j+k][i]!=map[s-k][i]) {
//								flag=true;
//							}
//						}
//						if(!flag) {
//							if(ans<cnt)
//								ans=cnt;
//						}
//					}
//				}
//			}
			
			System.out.println("#"+(tc+1)+" "+ans);
			
//			//가로
//			for(int cnt=1;cnt<8;cnt++) {
//				for(int i=0;i<8;i++) {
//					for(int k=0;k<8;k++) {
//						boolean flag= false;
//						for(int j=0;j<cnt/2;j++) {
//							if(map[i][j+k]!=map[i][cnt-1-k]) {
//								flag= true;
//							}
//						}
//						if(!flag) {
//							if(ans<cnt)
//								ans =cnt;
//							break;
//						}				
//					}
//
//				}
//			}
//			
//			//세로
//			for(int i=0;i<8;i++) {
//				for(int j=0;j<8;j++) {
//					int k=0;
//					for(int cnt=8;cnt>0;cnt--) {
//						boolean flag= false;
//						for(k=0;k<cnt/2;k++) {
//							if((j+k)>7 || (cnt-1-k)<0) {
//								break;
//							}
//							if(map[j+k][i]!=map[cnt-1-k][i]) {
//								flag= true;
//							}
//						}
//						if(!flag) {
//							if(ans<cnt)
//								ans =cnt;
//							break;
//						}				
//					}
//
//				}
//			}
//			System.out.println("#"+(tc+1)+" "+ans);
		}
	}
}

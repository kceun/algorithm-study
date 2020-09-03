package algorithm.swea;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class SWEA1209 {

	static int big = 0;
	static int[] dx= {0,1,1,1};
	static int[] dy= {1,0,1,-1};
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		System.setIn(new FileInputStream("1209input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();

		for(int tc=0;tc<T;tc++) {
			int map[][] = new int[100][100];
			
			//배열넣기
			for(int i=0;i<map.length;i++) {
				for(int j=0;j<map[0].length;j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			//sumAdd(map);
			
			sumAdd2(map);
			System.out.println("#"+(tc+1)+" "+big);
		}
		
	}
	public static void sumAdd2(int[][] map) {
	
	for(int i =0;i<map.length;i++) {
		int sum=0;
		int sum2=0;
		for(int j=0;j<map.length;j++) {
			sum+=map[i][j];
			sum2+=map[j][i];
		}
		if(sum>=big)
			big = sum;
		if(sum2>=big)
			big = sum2;
		
	}
	
	int sum3=0;
	int sum4=0;
	for(int i =0;i<map.length;i++) {
		
		sum3+=map[i][i];
		sum4+=map[i][map.length-1];

	}
	if(sum3>=big)
		big = sum3;
	if(sum4>=big)
		big = sum4;
	
}
	
//	public static void sumAdd(int[][] map) {
//		
//		for(int i =0;i<map.length;i++) {
//			int sum=0;
//			for(int j=0;j<map.length;j++) {
//				sum+=map[i][j];
//			}
//			if(sum>big)
//				big = sum;
//		}
//		
//		for(int i =0;i<map.length;i++) {
//			int sum=0;
//			for(int j=0;j<map.length;j++) {
//				sum+=map[j][i];
//			}
//			if(sum>big)
//				big = sum;
//		}
//		
//		int sum2=0;
//		for(int i =0;i<map.length;i++) {
//			
//			sum2+=map[i][i];
//			if(sum2>big)
//				big = sum2;
//		}
//		
//		for(int i =0;i<map.length;i++) {
//			int sum=0;
//			for(int j=map.length-1;j>0;j--) {
//				sum+=map[i][j];
//			}
//			if(sum>big)
//				big = sum;
//		}		
//		
//	}

}

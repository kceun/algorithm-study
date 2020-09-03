package algorithm.swea;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SWEA2805 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("2805input.txt"));
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=0;tc<T;tc++) {
			int n = sc.nextInt();
			int map[][] = new int[n][n];
			int sum=0;
			
			for(int i=0;i<n;i++) {
				String str = sc.next();
				for(int j=0;j<str.length();j++) {
					map[i][j]=Character.getNumericValue(str.charAt(j));
				}
			}
			
			int k = n/2+1; 
			//마름모 위
			for(int i=0;i<k;i++) {
				int y=0;
				for(int j=k;j>i+1;j--) {
					//System.out.print(" ");
					y++;
				}
				for(int j=0;j<=i*2;j++,y++) {
					sum+=map[i][y];
					//System.out.print(map[i][y]);					
				}
				//System.out.println();
			}
			
			//마름모 아래
			int x= k;
			for(int i=n-k;i>0;i--,x++) {
				int y=0;
				for(int j=0;j<k-i;j++) {
					//System.out.print(" ");
					y++;
				}
				for(int j=0;j<i*2-1;j++,y++){
					sum+=map[x][y];
					//System.out.print(map[x][y]);
				}
				//System.out.println();
			}
			
			System.out.println("#"+(tc+1)+" "+sum);
		}
	}

}

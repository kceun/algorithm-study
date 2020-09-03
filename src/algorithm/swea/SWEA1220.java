package algorithm.swea;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SWEA1220 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("1220input.txt"));
		
		Scanner sc = new Scanner(System.in);
		
		for(int tc=0;tc<10;tc++) {
			int m = sc.nextInt();
			int[][] map = new int [m][m];
			
			for(int i=0;i<m;i++) {
				for(int j=0;j<m;j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			//print(map);
			
			int cnt =0;
			
			for(int i=0;i<m;i++) {
				boolean flag= false; //열 바뀔때마다 리셋
				for(int j=0;j<m;j++) {
					if(flag && map[j][i]==2) { //바로 전의 것이 1이였고 지금 2인 경우
						cnt++;
						map[j][i]=-1; //체킹을 위해서
						flag=false;
					}
					if(map[j][i]==1) { // 위에서 부터 훑기때문에 2가 젤먼저 나오면 N극으로 빨려갈거임 그래서 1만 검색
						flag=true;
						continue;
					}
					
				}
			}
			System.out.println("#"+(tc+1)+" "+cnt);
			
		}
	}
	public static void print(int[][] map) {
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map.length;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}

}

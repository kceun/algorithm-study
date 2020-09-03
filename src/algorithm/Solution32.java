package algorithm;

import java.io.FileInputStream;
import java.util.*;

class People {
	int x;
	int y;
	int cnt;
	
	public People(int x, int y, int cnt) {
		this.x=x;
		this.y=y;
		this.cnt=cnt;
	}
}
public class Solution32 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("solution32.txt"));
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt(); //test case 수
		
		for(int tc=0;tc<t;tc++) {
			int y = sc.nextInt();
			int x = sc.nextInt();
			int n = sc.nextInt();
			
			
			int[][] pan = new int[y+1][x+1];
			for(int i=1;i<pan.length;i++) {
				for(int j=1;j<pan[0].length;j++) {
					pan[i][j] = sc.nextInt();
				}
			}
			
			People[] peo = new People[n];
			for(int i=0;i<n;i++) {
				peo[i] = new People(sc.nextInt(),sc.nextInt(),sc.nextInt());
			}
			
			int traps = sc.nextInt();
			for(int i=0;i<traps;i++) {
				pan[sc.nextInt()][sc.nextInt()]=-1;
			}
			
			//=======================
			int sum = 0; //상금
			for(int i=0;i<peo.length;i++) {
				sum-= 1000;
				int k =0; //방향이자 상금
				while(peo[i].cnt>0) {
					int x1 =0 ,y1 =0;
					k = pan[peo[i].x][peo[i].y]; 
					String s = String.valueOf(k);
					char way = s.charAt(0);
					int jump = Character.getNumericValue(s.charAt(1));
					
					switch(way) {
						case'1' : {
							x1=peo[i].x;
							y1=peo[i].y+jump;
							break;
						}
						case'2' : {
							x1=peo[i].x+jump;
							y1=peo[i].y;
							break;
						}
						case'3' : {
							x1=peo[i].x;
							y1=peo[i].y-jump;
							break;
						}
						case'4' : {
							x1=peo[i].x-jump;
							y1=peo[i].y;
							break;
						}
					}
					if(x1<1 || x1>pan.length || y1<1 || y1>pan[0].length) {
						k=0;
						break;
					}
					if(pan[x1][y1]==-1) {
						k=0;
						break;
					}
					
					k = pan[x1][y1];
					peo[i].x=x1;
					peo[i].y=y1;
					peo[i].cnt--;				
				
				}
				
				sum+= k*100;
				
			}
			
			System.out.println("#"+(tc+1)+" "+sum);
			
		}
	}

}

package algorithm;

public class Forpractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fun7();
	}
	public static void fun7() {
		int num=1;
		int n[][] = new int[5][5];
		
		for(int i=0;i<n.length;i++) {
			int x=i;
			int y=0;
			while(x>-1) {
				n[x--][y++]=num++;
			}
		}
		
		for(int i=1;i<n.length;i++) {
			int x=n.length-1;
			int y=i;
			while(y<n.length) {
				n[x--][y++]=num++;
			}
		}
		
		
		for(int i=0;i<n.length;i++) {
			for(int j=0;j<n[0].length;j++) {
				System.out.print(n[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void fun6() {
		int[][] map = new int[8][8];
		int[] dx = {-1,-1,1,1};
		int[] dy = {1,-1,-1,1};
		map[3][5] = 2;
		map[2][2] =2;
		
		
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map[0].length;j++) {
				if(map[i][j]==2) {

					for(int k=0;k<dx.length;k++) {
						int x=i;
						int y=j;				
						while(x<8 && x>=0 && y<8 && y>=0) {
							if(map[x][y]!=2)
								map[x][y]=1;
							x= x +dx[k];
							y= y +dy[k];
						}
					}
				}
			}
		}
		int cnt=0;
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map[0].length;j++) {
				System.out.print(map[i][j]+" ");
				if(map[i][j]>0)
					cnt++;
			}
			System.out.println();
		}
		
		System.out.println("수:" + cnt);
	}
	
	public static void fun5() {
		int[][] map = new int[5][5];
		int num=1;
		
		int x =0;
		int y=0;
		
		while(num<=25) {
			map[x][y] = num++;
			
			//if(x)
		}
		
		
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map[0].length;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void fun4() {
		int n =4;
		for(int i=n;i>0;i--) {
			for(int j=n-i;j>0;j--) {
				System.out.print(" ");
			}
			for(int j=0;j<i*2-1;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}

	public static void fun3() {
		int n = 4;
		for(int i=n;i>0;i--) { // 5 4 3 2 1
			for(int j=0;j<n-i;j++) { //0,1,2,3,4)
				System.out.print(" ");
			}
			for(int j=0;j<i*2-1;j++) { //
				System.out.print("*");
			}
			
			System.out.println();
		}
		
	}
	public static void fun2() {
		int n =5;
		int up = n/2+1;
		int down= n-up;
		for(int i=0;i<up;i++) {
			for(int j=0;j<up-1-i;j++) {
				System.out.print(" ");
			}
			for(int j=0;j<i*2+1;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i=0;i<down;i++) {
			for(int j=1;j<down+i;j++) {
				System.out.print(" ");
			}
			for(int j=1;j<(down-i)*2;j++) {
				System.out.print("*");
			}

			System.out.println();
		}
	}
	public static void fun1() {
		int n = 11;
		for(int i=0;i<n;i++){
			for(int j=0;j<n-1-i;j++) {
				System.out.print(" ");
			}
			for(int j=0;j<i*2+1;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}

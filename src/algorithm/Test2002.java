package algorithm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test2002 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//		Scanner sc = new Scanner(System.in);
//		fun1(sc.nextLine());
//		fun2();
//		fun3();
//		fun4();
		fun5();
		
		
	}
	public static void fun5() throws FileNotFoundException {
		System.setIn(new FileInputStream("Test5.txt"));
		Scanner sc = new Scanner(System.in);		
		int[][] map = new int[20][20];
		int x=0,y=0;
		int dx[] = {1,1,1,0};
		int dy[] = {-1,0,1,1};
		for(int i=1;i<map.length;i++) {
			for(int j=1;j<map[0].length;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map[0].length;j++) {
				if(map[i][j]!=0) {
					x=i;
					y=j;
					int color = map[i][j];
					int sum =0;
					for(int n1 = 0; n1<4;n1++) {
						for(int n2=5;n2>0;n2--) {
							int mx = x + dx[n1];
							int my = y + dy[n1];
							if(mx<1 || mx>19 || my<1 || my>19)
								break;
							if(color==map[mx][my]) {
								sum++;
								x=mx;
								y=my;
							} else {
								break;
							}
							
							if(sum==4) {
								System.out.println(color);
								System.out.println(i+" "+j);
								return;
							}
						}
					}
				}
			}
		}
	}
	
	
	public static void fun4() throws FileNotFoundException {
		int[] dx = {0,-1,-1,0,1,1,1,0,-1}; //1~8일때의 x값변화
		int[] dy = {0,0,1,1,1,0,-1,-1,-1}; // 
		int distance = 0;
		System.setIn(new FileInputStream("Test4.txt"));
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[][] pan = {};
		for(int tc=0;tc<t;tc++) {
			distance = 0;
			int N = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			int traps = sc.nextInt();
			pan = new int[N+1][N+1];
			
			for(int i=0;i<traps;i++) {
				pan[sc.nextInt()][sc.nextInt()] = -1;
			}
			int move = sc.nextInt();
			boolean flag = false;
			for(int i=0;i<move;i++) {
				int dir = sc.nextInt();
				int jump = sc.nextInt();
				if(!flag) {
					for(int k=jump;k>0;k--) {
						int mx = x + (dx[dir]);
						int my = y + (dy[dir]);
						
						if(mx<1 || mx>N || my<1 || my>N) {
							flag=true; 
							break;
						}
						if(pan[mx][my]==-1) {
							flag=true; 
							break;
						}
						x = mx;
						y = my;
						distance++;
					}
				}
				
			}
			System.out.println("#"+(tc+1)+" "+distance);
		}
	}
	
	public static void fun3() {
		String s = "5329053995535987827332679340558347453272569584";
		int[] nums = new int[10];
		
		for(int i=0;i<s.length();i++) {
			switch(s.charAt(i)) {
			case'0': nums[0]++; break;
			case'1': nums[1]++; break;
			case'2': nums[2]++; break;
			case'3': nums[3]++; break;
			case'4': nums[4]++; break;
			case'5': nums[5]++; break;
			case'6': nums[6]++; break;
			case'7': nums[7]++; break;
			case'8': nums[8]++; break;
			case'9': nums[9]++; break;
			}
		}
		
		for(int i=0;i<nums.length;i++) {
			if(nums[i]!=0)
				System.out.println(i+" : " + nums[i]);
		}
	}
	
	public static void fun2() {
		int[]  su =  {34, 55, 27, 67, 45, 82, 68, 99, 77, 18};
		int avg=0, num=0;
		for(int i=0;i<su.length;i++) {
			avg+=su[i];
		}
		avg= avg/su.length;
		int cha = avg;
		for(int i=0;i<su.length;i++) {
			if(Math.abs(su[i]-avg)<cha) {
				cha=Math.abs(su[i]-avg);
				num=su[i];
			}
		}
		System.out.println(avg +" "+num);
	}
	
	public static void fun1(String str) {
		if(str.equals("1")) {
			int num=1;
			for(int i=1;i<5;i++) {
				for(int j=0;j<i;j++) {
					System.out.print(num++ +" ");
				}
				System.out.println();
			}
		} else if (str.equals("A")) {
			char s='A';
//			for(int i=0;i<5;i++) {
//				for(int j=0;j<i;j++) {
//					System.out.print(s++ +" ");
//				}
//				System.out.println();
//			}
			int line = 5;
			for(int i=0;i<line;i++) {
				for(int j=line-1;j>i;j--) {
					System.out.print(" ");
				}
				for(int k=1;k<=i*2+1;k++) {
					System.out.print(s++);
				}
				System.out.println();
			}
		}
		
	}

}

package algorithm.boj;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Fun5373 {

	public static int T,N;
	public static char[][] left,up,down,right,front,back;
	public static void main(String[] args) throws FileNotFoundException {		
		
		System.setIn(new FileInputStream("sample_input.txt"));
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		left = new char[3][3];
		up = new char[3][3];
		down = new char[3][3];
		right = new char[3][3];
		front = new char[3][3];
		back = new char[3][3];
		

//		Arrays.fill(up,'w');
//		Arrays.fill(down,'y');
//		Arrays.fill(front,'r');
//		Arrays.fill(back,'o');
//		Arrays.fill(right,'b');
		
		
		for (int tc = 0; tc < T; tc++) {
			initCube();
			N = sc.nextInt();
			for (int rotate = 0; rotate < N; rotate++) {
				String str = sc.next();
				if(str.charAt(1)=='+') {
					cube(str.charAt(0));
				}else {
					//반시계방향은 시계방향을 3번돌린 것과 같다.
					for (int i = 0; i < 3; i++) {
						cube(str.charAt(0));
						
					}
				}
			}
			
			printAll();
			//printUp();
		}

	}
	
	public static void initCube() {
		for (char[] carr : left)
			Arrays.fill(carr,'g');
		for (char[] carr : up)
			Arrays.fill(carr,'w');
		for (char[] carr : down)
			Arrays.fill(carr,'y');
		for (char[] carr : front)
			Arrays.fill(carr,'r');
		for (char[] carr : back)
			Arrays.fill(carr,'o');
		for (char[] carr : right)
			Arrays.fill(carr,'b');
	}
	
	public static void cube(char loc) {
		
		if(loc=='L') {
			//내 자신 90도 회전
			left = selfRotate(left);	
			
			//다른 면 회전
			for (int i = 0; i < 3; i++) {
				char temp = back[2-i][0]; 
				back[2-i][0] = down[2-i][0];
				down[2-i][0] = front[i][0];
				front[i][0] = up[i][0];
				up[i][0]=temp;
			}
		}
		else if(loc=='F') {
			//내 자신 90도 회전
			front = selfRotate(front);
			
			for (int i = 0; i < 3; i++) {
				char temp = left[2-i][2];
				left[2-i][2] = down[2][2-i];
				down[2][2-i] = right[i][2];
				right[i][2] = up[2][i];
				up[2][i] = temp;
			}
		}
		else if(loc=='U') {
			//내 자신 90도 회전
			up = selfRotate(up);	
			
			//다른 면 회전
			for (int i = 0; i < 3; i++) {
				char temp = front[0][2-i];
				front[0][2-i] = right[0][i];
				right[0][i] = back[0][i];
				back[0][i] = left[0][2-i];
				left[0][2-i] = temp;
			}			
		}
		else if(loc=='R') {
			//내 자신 90도 회전
			right = selfRotate(right);
			right = selfRotate(right);	
			right = selfRotate(right);	
			
			//다른 면 회전
			for (int i = 0; i < 3; i++) {
				char temp = down[i][2];
				down[i][2] = back[i][2];
				back[i][2] = up[2-i][2];
				up[2-i][2] = front[2-i][2];
				front[2-i][2]=temp;
			}			
		}
		else if(loc=='D') {
			//내 자신 90도 회전
			down = selfRotate(down);	
			down = selfRotate(down);
			down = selfRotate(down);
			
			//다른 면 회전
			for (int i = 0; i < 3; i++) {
				char temp = back[2][2-i];
				back[2][2-i] = right[2][2-i];
				right[2][2-i] = front[2][i];
				front[2][i] = left[2][i];
				left[2][i] = temp;
			}
			
		}
		else if(loc=='B') {
			//내 자신 90도 회전
			back = selfRotate(back);	
			back = selfRotate(back);	
			back = selfRotate(back);	
			
			//다른 면 회전
			for (int i = 0; i < 3; i++) {
				char temp = right[2-i][0];
				right[2-i][0] = down[0][i];
				down[0][i] = left[i][0];
				left[i][0] = up[0][2-i];
				up[0][2-i] = temp;
			}
			
		}
	}

	public static char[][] selfRotate(char[][] arr) {
		
		//System.out.println("---COPY---");
		char[][] copy = new char[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				copy[i][j] = arr[2-j][i];
				//System.out.print(copy[i][j]);
			}
			//System.out.println();
		}
		
		
		
		return copy;
	}

	public static void printUp() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(up[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void printAll() {
		System.out.println("==========");
		System.out.println("*  up  *");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(up[i][j]);
			}
			System.out.println();
		}
		
		System.out.println("*  down  *");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(down[i][j]);
			}
			System.out.println();
		}
		System.out.println("*  left  *");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(left[i][j]);
			}
			System.out.println();
		}
		System.out.println("*  right  *");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(right[i][j]);
			}
			System.out.println();
		}
		System.out.println("*  back  *");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(back[i][j]);
			}
			System.out.println();
		}
		System.out.println("*  front  *");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(front[i][j]);
			}
			System.out.println();
		}
	}
}

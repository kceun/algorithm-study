package algorithm.boj;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Fun2447 {

	public static Character[][] map;
	public static void main(String[] args) throws IOException {
		
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		map = new Character[N][N];
		
		for (int i = 0; i < N; i++) {
			Arrays.fill(map[i], ' ');
		}
		
		//solve
		solve(0,0,N,false);


		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				bw.append(map[i][j]);
			}
			bw.append("\n");
		}
		
		bw.flush();
	}

	public static void solve(int row, int col, int N,boolean isCenter) {

//		System.out.println("행렬 : "+row+","+col+","+isCenter+", n = "+N);
		
		//더이상 나눌 수 없는가 ?
		if(N==1) {
			//센터인가?
			if(isCenter)
				map[row][col]=' ';
			else
				map[row][col]='*';
		}
		else if(!isCenter) {
			//아니라면 전체를 3으로 나눠서 9등분한다. (센터가 아닌애들만 확인해보기!)
			int cut = N/3;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					// 해당 x좌표가 이 정사각형의 센터 부분인가?
					// 이미 센터 부분인 경우에는 굳이 확인하지 않음..
//					boolean flag = isCenter;
//					if(!isCenter)
					boolean	flag = (i==1 && j==1 ? true : false);
					
					
					solve(row+(i*cut),col+(j*cut),cut,flag);
				}
			}
			
		}

	}
}

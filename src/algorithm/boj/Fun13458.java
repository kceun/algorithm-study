package algorithm.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Fun13458 {

	public static int N,B,C;
	public static long ans = 0;
	public static long[] stu;
	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("Fun13458.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		N = Integer.parseInt(br.readLine());
		stu = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			stu[i]=Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		B= Integer.parseInt(st.nextToken()); //총감독이 감독할 수 있는 학생 수
		C= Integer.parseInt(st.nextToken()); //부감독이 감독할 수 있는 학생 수
		
		for (int i = 0; i < N; i++) {
			//총감독 카운트
			stu[i]-=B;
			ans++;
			
			
			//부감독관 카운트
			if(stu[i]>0) {
				ans+=(stu[i]/C);
				ans+=(stu[i]%C!=0 ? 1:0);
					
			}
			
		}
		
		System.out.println(ans);
	}

}

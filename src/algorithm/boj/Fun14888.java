package algorithm.boj;

import java.io.*;
import java.util.*;

public class Fun14888 {

	public static int N, cnt, oidx=0; //oidx = 연산자받을때 사용할 idx
	public static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
	public static int[] num; // N개의 연산에 쓰일 숫자
	public static char[] operator; // 연산자 
	public static boolean[] visit; // 수식 방문했는지 여부
	public static char[] ans; // 연산자의 경우의 수 넣기 위한 배열
	public static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("Fun14888.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		cnt = N-1; // 수식의 갯수 = 연산에 쓰이는 숫자-1
		operator = new char[cnt]; // 연산자 정보
		visit = new boolean[cnt];
		ans = new char[cnt];
		String s = br.readLine();
		st = new StringTokenizer(s);
		
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		//연산자 받기
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			int o = Integer.parseInt(st.nextToken());
			for (int j = 0; j < o; j++) {
				switch(i) {
				case 0: operator[oidx++] = '+'; break;
				case 1: operator[oidx++] = '-'; break;
				case 2: operator[oidx++] = '*'; break;
				case 3: operator[oidx++] = '/'; break;
				
				}
			}
		}
		

		perm(0);

		
		System.out.println(max);
		System.out.println(min);
		
	}
	public static void perm(int idx) {
		
		//종료조건
		//수식을 다 사용했는가?
		if(idx==cnt) {
			//우선순위 무시한 계산하여 최대,최소값 구하기
			int sum = num[0];
			for (int i = 0; i < cnt; i++) {
				System.out.print(ans[i]+ " ");
				char ch = ans[i];
				switch(ch) {
				case'+': sum+=num[i+1]; break; 
				case'-': sum-=num[i+1]; break; 
				case'/': sum/=num[i+1]; break;
				case'*': sum*=num[i+1]; break; 
				}
				
			}
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			System.out.println();
			return;
		}
		
		for (int i = 0; i < cnt; i++) {
			
			
			//이미 사용한 연산자인가?
			if(visit[i])
				continue;
			
			//뽑기
			ans[idx]=operator[i];
			visit[i]=true;
			perm(idx+1); 
			visit[i]=false;
		}
		
	}

}

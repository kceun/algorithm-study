package algorithm.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Fun2875 {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int max= Integer.MIN_VALUE;
		
		//팀 구성
		int N2 = N/2;
		if(N2<=M)
			max = N2;
		else
			max = M;
		
		//남은 인원들로 인턴 선발
		K-= (N-(max*2))+(M-max);
		
		
		//그래도 모자르면 팀 하나씩 해체
		while(K>0) {
			max--;
			K-=3;
		}

		System.out.println(max);
				 
	}

}

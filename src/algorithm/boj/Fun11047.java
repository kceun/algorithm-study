package algorithm.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Fun11047 {

	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int ans = 0;
		
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		
		for (int i = N-1; i > -1; i--) {
			if(K>=arr[i]) {
				ans += K/arr[i];
				K-= (arr[i]*(K/arr[i]));
				if(K==0)
					break;
			}
		}

		System.out.println(ans);
	}

}

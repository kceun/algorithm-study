package algorithm.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Fun11399 {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr= new int[N];
		for (int i = 0; i < N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		for (int i = 0; i < arr.length; i++) {
			ans+=arr[i];
			for (int j = i-1; j >= 0; j--) {
				ans+=arr[j];
			}
		}
		
		System.out.println(ans);

	}

}

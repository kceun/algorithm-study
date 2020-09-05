package algorithm.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Fun11728 {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		StringBuilder sb = new StringBuilder();
		sb.append(br.readLine());
		
		StringTokenizer st = new StringTokenizer(sb.toString());
		
		int arr[] = new int[Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())];
		int idx = 0;
		
		st = new StringTokenizer(br.readLine());
		
		while(st.hasMoreTokens()) {
			arr[idx++] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			arr[idx++] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int i : arr) {
			bw.write(i +" ");
		}

		bw.flush();
		bw.close();

	}

}

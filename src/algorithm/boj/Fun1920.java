package algorithm.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Fun1920 {

	public static int N, M;
	public static int[] arr;
	// public static int[] mArr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 이분탐색을 위한 오름차순 정렬
		Arrays.sort(arr);

		M = Integer.parseInt(br.readLine());
		// nArr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			int start = 0;
			int end = N-1;
			
			//종료조건 - start의 크기가 end보다 더 큰가?
			while(start <= end) {
				int mid = (start+end) /2;
				if(arr[mid] < num ) {
					start = mid+1;
				} else if(arr[mid] > num) {
					end = mid-1;
				}else {
					System.out.println(1);
					break;
				}
				
			}
			if(start>end)
				System.out.println(0);

		}

	}

}

package algorithm.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Fun2805 {

	public static int N;
	public static long M;
	public static long[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Long.parseLong(st.nextToken());
		
		arr = new long[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		long start = 0;
		long end = arr[N-1]; //가장 높은 나무의 길이까지 자를 범위
		long height = 0; //절단기 높이 값
		long minSum = Long.MAX_VALUE; // 상근이가 주워갈 길이가 M 이상이 되는 최소의 나무 합
		long maxHeight = 0; //절단기 높이의 최대값
		while(start<=end) {
			//절단기 높이 지정 (이분탐색)
			height = (start+end) /2;
			
			long sum = 0; //상근이가 절단기로 자르고 주워갈 나무들의 합
			for (int i = 0; i < arr.length; i++) {
				if(arr[i]-height>0)
					sum += arr[i]-height;
			}
			//자른 나무들의 합이 주워갈 나무들보다 적은가?
			if(sum< M) {
				//높이를 낮춰서 자를 나무의 크기를 키우자
				end = height-1;
			} 
			//자른 나무들의 합이 주워갈 나무M보다 더 큰가?
			else if(sum > M) {
				//필요한만큼 (==자른것들이 최소가되게) 주워가도록 가장 작은수인가?
				if(minSum > sum) {
					minSum = sum;
					maxHeight= Math.max(maxHeight,height);
				}
				//높이를 높여서 자를 나무들을 더 잘개 쪼개자.
				start = height+1;
			}
			else {
				//자른나무들의 합과 주워가야되는 길이 M이 같은경우
				maxHeight = height;
				break; //더 볼 것도 없이 바로 끝내기
			}
			
		}
		
		System.out.println(maxHeight);
	}

}

package algorithm.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Fun1517 {

	public static long[] map, tmp;
	public static long cnt = 0;
	public static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		map = new long[N];
		tmp = new long[N];
		for (int i = 0; i < N; i++) {
			map[i] = Long.parseLong(st.nextToken());
		}

		// solve
		solve(0, N - 1);

		System.out.println(cnt);

//		for (int i : map) {
//			System.out.print(i + " ");
//		}
//		System.out.println();
	}

	public static void solve(int start, int end) {

		//0. 배열의 크기가 1인지 조건 확인
		if (start < end) {
			// 1. 분할을 하기위하여 절반 나누기 (분할된 오른쪽 부분의 idx 계산때문에 end/2가아닌 start+end/2)
			int mid = (start + end) / 2;

			solve(start, mid); // 2. 왼쪽 분할부분을 더 분할하기
			solve(mid + 1, end); // 3. 오른쪽 분할 부분을 더 분할하기

			// 4. 가장 작은 단위의 분할 부분부터 다시 병합하기
			int i = start;
			int j = mid + 1;
			int k = start;
			

			// i,j를 idx삼아 병합 .. 단, 분할된 배열의 길이를 벗어나지 않도록!.. cnt는 map[i]이 더 작을때 일어난다.
			while (i <= mid && j <= end) {
				// 대소 비교
				if (map[i] <= map[j]) {
					tmp[k++] = map[i++];
				} else {
					tmp[k++] = map[j++];
					cnt+= (mid-i+1);
				}

			}   

			// 만약 왼/오 분할된 부분 중 작은 수가 한쪽에 몰려있어서 i,j인덱스가 끝점까지 간 경우는 따로따로 확인한다.
			while (i <= mid) {
				tmp[k++] = map[i++];
			}
			while (j <= end) {
				tmp[k++] = map[j++];  
			}


			for (int l = start; l <= end; l++) {
				map[l] = tmp[l];
			}
			
		}
	}

}

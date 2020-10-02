package algorithm.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Fun1931 {

	public static ArrayList<Integer[]> list = new ArrayList<Integer[]>();
	public static int ans = 0;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list.add(new Integer[] { start, end });

		}

		// 종료시간 기준으로 오름차순 정렬
		Collections.sort(list, new Comparator<Integer[]>() {
			@Override
			public int compare(Integer[] o1, Integer[] o2) {
				if (o1[1] == o2[1]) {
					return o1[0].compareTo(o2[0]);
				} else
					return o1[1].compareTo(o2[1]);
			}
		});

		// for (Integer[] i: list) {
		// System.out.println(i[0]+", "+i[1]);
		// }

		int curr = 0; // 현재 지점
		for (int i = 0; i < list.size(); i++) {
			Integer[] meeting = list.get(i);
			if (curr <= meeting[0]) {
				curr = meeting[1];
				ans++;
			}
		}
		System.out.println(ans);

	}

}

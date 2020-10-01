package algorithm.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Fun5585 {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] coin = { 500, 100, 50, 10, 5, 1 };

		int price = 1000 - N;
		int ans = 0;

		for (int i = 0; i < coin.length; i++) {
			if (price >= coin[i]) {
				ans += price / coin[i];
				price -= coin[i] * (price / coin[i]);
				if (price == 0)
					break;
			}
		}
		System.out.println(ans);
	}

}

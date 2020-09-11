package algorithm.프로그래머스.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class 튜플 {

	public static void main(String[] args) {

		String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";

		for (int i : solution(s)) {
			System.out.println(i);
		}
	}

	public static int[] solution(String s) {
		int[] answer = {};

		s = s.substring(2, s.length() - 2).replace("},{", "/");

		String[] sp = s.split("/");
		answer = new int[sp.length];

		// 정렬
		Arrays.sort(sp, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s1.length() - s2.length();
			}
		});

		// for (int i = 0; i< sp.length; i++) {
		// System.out.println(sp[i]);
		// }

		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < sp.length; i++) {
			String[] sp2 = sp[i].split(",");
			for (int j = 0; j < sp2.length; j++) {
				if (!list.contains(Integer.parseInt(sp2[j])))
					list.add(Integer.parseInt(sp2[j]));
			}

		}

		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}

		return answer;
	}

}

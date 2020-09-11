package algorithm.프로그래머스.level2;

import java.util.Stack;

public class 괄호변환 {

	public static void main(String[] args) {

	}

	public static Stack<Character> stack = new Stack<Character>();

	public String solution(String p) {
		String answer = p;

		// 올바른 괄호 여부확인
		if (!isGood(p)) {
			// 문자열 작업
			answer = solve(p);
		}
		return answer;
	}

	public boolean isGood(String p) {

		for (int i = 0; i < p.length(); i++) {
			Character ch = p.charAt(i);

			if (ch == '(') {
				stack.push('(');
			} else {
				if (!stack.isEmpty()) {
					stack.pop();
				} else {
					return false;
				}
			}

		}

		return true;
	}

	public String solve(String w) {
		// System.out.println(w);
		if (w.length() == 0)
			return "";

		int left = 0, right = 0;
		String u = "";
		String v = "";

		// u와 v분리
		for (int i = 0; i < w.length(); i++) {
			Character ch = w.charAt(i);
			if (ch == '(') {
				left++;
			} else {
				right++;
			}

			if (left == right) {
				u = w.substring(0, i + 1);
				v = w.substring(i + 1, w.length());
				break;
			}
		}

		// u가 올바른 문자열인가?
		if (!isGood(u)) {

			// 새로운 문자열 만들기..
			String str = "";

			str = "(" + solve(v) + ")";

			// 앞뒤 문자 제거
			u = u.substring(1, u.length() - 1);
			// 나머지 문자 괄호방향 뒤집기
			u = u.replace("(", "*");
			u = u.replace(")", "(");
			u = u.replace("*", ")");

			return str + u;
		} else {
			// v에 대해 재귀수행
			return u + solve(v);
		}

	}
}

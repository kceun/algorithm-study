package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SbTest {

	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("Fun15649.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		sb.append(br.readLine());
		//ex. 1 2 3 4 5 가  한줄로 입력되는경우 숫자 하나씩 쪼개기 위한 방법
		StringTokenizer st = new StringTokenizer(sb.toString());
		int n1 = Integer.parseInt(st.nextToken());
		int n2 = Integer.parseInt(st.nextToken());
		//int n3 = Integer.parseInt(st.nextToken());
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(n1+"\n");
		bw.flush();
		bw.close();
		
		//기본으로 들어오는 형태는 String 이므로 형변환을 원하면 따로 처리 해야함.
		//int a = Integer.parseInt(br.readLine());

	}

}

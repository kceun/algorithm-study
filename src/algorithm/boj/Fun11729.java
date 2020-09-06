package algorithm.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Fun11729 {

	public static int cnt=0;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		
		//시작
		hanoi(N,1,3,2); //1번 기둥에 있는 N개의 원판을 2번 기둥을 경유하여 최종 목적지인 3번으로 옮겨야한다.
		
		System.out.println(cnt);
		System.out.println(sb);
		
		
	}
	
	public static void hanoi(int n, int start, int end, int via) {
		
		if(n==1) {
			cnt++; //옮길때마다 카운트 ++
			sb.append(start+" "+end+"\n");
		}
		else {
			hanoi(n-1,start,via,end); //n번 원판을 최종 목적지로 옮기기 위해서 그 위에있는 n-1원판을 다른곳(via)으로 옮겨 놓는다.
			sb.append(start+" "+end+"\n"); // n-1원판이 다른곳으로 옮겨졌으면 n번 원판을 최종 목적지로 이동시킨다.
			cnt++;					// 원판을 옮길때마다 카운트 ++
			hanoi(n-1,via,end,start); //다른곳(via)에 옮겨놨던 n-1원판을 다시 n번의 위로 옮겨준다.
		}
		
	}

}

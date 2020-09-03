package algorithm.boj;

import java.io.*;
import java.util.*;

public class Fun14891 {

	public static int K,ans = 0;
	public static StringTokenizer st;
	public static boolean[] visit = new boolean[5]; //이미 극이 같은지를 검사한 톱니바퀴인지 체크하기 위함
	public static Deque<String>[] dq = new ArrayDeque[5]; // 톱니바퀴(Deque) 4개를 담을 배열 , deque를 담을 배열을 선언하고 각  idx에 디큐를 생성해줌..
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("Fun14891.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 1; i <= 4; i++) {
			String s = bf.readLine();
			dq[i] = new ArrayDeque<String>(); //각 idx에 디큐 생성
			for (int j = 0; j < 8; j++) {
				dq[i].add(String.valueOf(s.charAt(j))); //각 톱니바퀴에 8개의 극(N,S) 정보 넣기
			}
		}
		
		K = Integer.parseInt(bf.readLine());
		for (int i = 0; i < K; i++) {
			String s = bf.readLine();
			st = new StringTokenizer(s);
			int gearNum = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			
			visit[gearNum]=true;
			dfs(gearNum,dir);
			visit[gearNum]=false;
			
		}
		
		//점수계산
		for (int i = 0; i < 4; i++) {
			//System.out.println(dq[i+1]);
			if(dq[i+1].peekFirst().equals("1")) { //S극이면 2의 i승 점
				ans += Math.pow(2,i);
			}
		}
		System.out.println(ans);
	
	}
	
	public static void dfs(int gearNum, int dir) {
		
		if(gearNum <= 0 || gearNum>4)
			return;
		
		String[] arr = new String[dq[gearNum].size()]; // 맞닿아 있는 극의 정보 보기위해 배열로 변환
		dq[gearNum].toArray(arr);
		// 내 기준 왼쪽 톱니바퀴 확인
		if(gearNum-1 > 0 &&!visit[gearNum-1]) {

			String[] leftArr = new String[dq[gearNum-1].size()];
			dq[gearNum-1].toArray(leftArr);
			if(!arr[6].equals(leftArr[2])) { //원형으로 뒀을때 내 톱니바퀴의 인덱스6과 왼쪽 톱니바퀴의 인덱스 2가 맞닿아있는 구조
				visit[gearNum-1] = true;
				dfs(gearNum-1,dir*(-1));
				visit[gearNum-1] = false;
			}
		}
		
		// 내 기준 오른쪽 톱니바퀴 확인
		if(gearNum+1 <= 4 && !visit[gearNum+1]) {
			String[] rightArr = new String[dq[gearNum+1].size()];
			dq[gearNum+1].toArray(rightArr);
			if(!arr[2].equals(rightArr[6])) { //원형으로 뒀을때 내 톱니바퀴의 인덱스2과 오른쪽 톱니바퀴의 인덱스 6가 맞닿아있는 구조
				visit[gearNum+1] = true;
				dfs(gearNum+1,dir*(-1));
				visit[gearNum+1] = false;
			}
		}
		
		// 방향대로 회전하기
		if(dir==1) {
			//시계방향
			//12시가 가장 맨앞에 온다는 기준일때,맨끝에 있던 정보가 맨앞으로 오게됨
			String str = dq[gearNum].removeLast();
			dq[gearNum].addFirst(str);
			
		} else if(dir==-1) {
			//반시계방향
			//12시가 가장 맨앞에 온다는 기준일때, 맨앞에 있던 정보가 맨 뒤로 가게됨
			String str= dq[gearNum].removeFirst();
			dq[gearNum].addLast(str);
		}
	}

}

package algorithm.swea.D3;

import java.util.*;

public class no1229 {

	public static int N,M; //암호문의 길이, 명령어의 갯수
	public static LinkedList<Integer> list;
	public static Scanner sc;
	public static void main(String[] args) {
		
		sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			list = new LinkedList<>();
			list.add(999); // index 1부터 맞춰주기 위함
			
			N = sc.nextInt();
			for (int i = 0; i < N; i++) {
				list.add(sc.nextInt());
			}
			

			M = sc.nextInt();
			for (int i = 0; i < M; i++) {
				String str = sc.next();
				switch(str) {
				case "I": InsertPw(); break;
				case "D": DeletePw(); break;
				}
			}

			
			System.out.print("#"+tc+" ");
			for (int i = 1; i <= 10; i++) {
				System.out.print(list.get(i)+" ");
			}
			System.out.println();
		}

		
	}
	
	public static void InsertPw() {
		int start = sc.nextInt();
		int cnt = sc.nextInt();
		
		for (int i = 1; i <= cnt; i++) {
			list.add(start+i, sc.nextInt());
		}
	}
	
	public static void DeletePw() {
		
		int start = sc.nextInt();
		int cnt = sc.nextInt();
		
		for (int i = 1; i <= cnt; i++) {
			list.remove(start+1); //지워지면 .. 앞으로 땡겨지기때문에 항상 start 뒤에걸 지워야함 지울갯수만큼!
		}
	}

}

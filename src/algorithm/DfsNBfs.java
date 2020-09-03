package algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class DfsNBfs {
	  static int n,m,v;
	  static int map[][];
	  static boolean visit[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		 n = sc.nextInt();
		 m = sc.nextInt();
		 v = sc.nextInt();
		
		 map = new int[n+1][n+1];
		 visit = new boolean[n+1];
		
		for(int i=0;i<m;i++) {
			int num1= sc.nextInt();
			int num2= sc.nextInt();
			map[num1][num2] = map[num1][num2] = 1;
		}
		
		bfs(v);
		
	}
	
	// stack
	public static void dfs1(int v ) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(v);
		System.out.print(v+" ");

		
		
		while(!stack.empty()) {
			boolean flag = false;
			int k = stack.peek();
			
			for(int i=1;i<n+1;i++) {
				if(map[k][i]==1 && visit[i]==false) {
					visit[i]=true;
					flag = true;
					stack.push(i);
					System.out.print(i+" ");
					break;
				}
			}
			
			if(!flag)
				stack.pop();
		}
		
		
		
	}

	// 재귀
	public static void dfs2(int v) {
		System.out.print(v + " ");
		visit[v]=true;
		
		for(int i=1;i<n+1;i++) {
			if(map[v][i]==1 && visit[i]==false) {
				visit[i]=true;
				dfs2(i);
			}
		}
		
	}

	// bfs queue
	public static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(v);
		visit[v]=true;
		
		while(!queue.isEmpty()) {
			int p = queue.poll();
			System.out.println(p+" ");
			for(int i=1;i<n+1;i++) {
				if(map[p][i]==1 && !visit[i]) {
					visit[i]=true;
					queue.add(i);
				}
			}
		}
		
		
		
	}
}

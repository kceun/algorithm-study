package algorithm.boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Fun1260 {

    static int n,m,v;
    static int map[][];
    static boolean visit[];

    public static void main(String[] args) {

        //dfs 깊이 우선 탐색
        Scanner sc = new Scanner(System.in);


        n = sc.nextInt(); // 정점의 개수 Integer.parseInt(sc.nextLine());
        m = sc.nextInt(); // 간선의 개수
        v = sc.nextInt(); // 정점 시작 번호

        map = new int[n+1][n+1];  // 정점끼리 간선이 있는지 확인
        visit = new boolean[n+1]; // 해당하는 정점을 방문(=출력)했는 여부 확인 (인덱스 일치를 위하여 +1 해줌)

        // 간선을 정의하는 단계
        for(int i=0;i<m;i++) {
            int n1, n2;
            n1 = sc.nextInt();
            n2 = sc.nextInt();
            map[n1][n2]=map[n2][n1]=1; //여기 땜에 자꾸 틀렸다고 했다 ㅠ 흑흑
        }

        dfs(v);
        
        for(int i=0;i<n+1;i++) {
            visit[i]=false;
        }
        System.out.println();
        bfs(v);
    }

    public static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<Integer>();

        queue.add(v);
        visit[v]=true;

        while(!queue.isEmpty()) {
            int b = queue.poll(); // 가장 맨 앞의 것을 반환하고 지움
            System.out.print(b+" ");

            for(int i=1;i<n+1;i++) {
                if(map[b][i]==1 && !visit[i]){
                    visit[i]=true;
                    queue.add(i);
                }
            }
        }

    }

    //1. 재귀함수방식
    public static void dfs(int v) {

        System.out.print(v+" ");
        visit[v] = true;

        for(int i=1;i<n+1;i++) {

            if(map[v][i]==1 && visit[i]==false) {
                dfs(i);
            }
        }

    }

}

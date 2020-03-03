import java.util.Scanner;

public class Main {

	public static int N , M;
	public static int[] ans;
    public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args)  {	
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); //1~N까지의 숫자
		M = sc.nextInt(); //뽑을 숫자 갯수
		
		ans = new int[M];
		dfs(1,0); //숫자 1부터 N까지 돌것 , idx는 0
		System.out.println(sb);
	}
	
	public static void dfs(int num , int idx) {
		
		//종료조건 
		//M만큼 뽑았는가?
		if(idx==M) {
			for (int i = 0; i < ans.length; i++) {
				sb.append(ans[i]+" ");
			}
            sb.append("\n");
			return;
		}
		
		for (int i = 1; i <=N; i++) {
			
			ans[idx]=i;
			dfs(i,idx+1);

		}
	}

}

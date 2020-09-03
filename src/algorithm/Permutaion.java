package algorithm;

public class Permutaion {

	static int visit[], num[], ans[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		num = new int[]{5,2,8};
		visit = new int[num.length];
		ans = new int[2];

		dfs(0);
	}
	
	public static void dfs(int depth) {
		if(depth==ans.length) {
			for(int i=0;i<ans.length;i++) {
				System.out.print(ans[i]);
			}
			System.out.println();
			
			//visit = new int[num.length];
		} else {
			for(int i=0;i<num.length;i++) {
				if(!(visit[i]==1)) {
					ans[depth]=num[i];
					visit[i]=1;
					dfs(depth+1);	
					visit[i]=0; //핵심
				}
			}
		}

	}

}

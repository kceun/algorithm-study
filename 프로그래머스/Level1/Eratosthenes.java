class Solution {
  public int solution(int n) {
      int answer = 0;
      
		boolean[] check = new boolean[n+1];
		
		for(int i=2;i<=n;i++) {
			if(check[i])
				continue;
			for(int j=i+i;j<=n;j+=i) {
				check[j]=true;
			}
		}
      
      
		for(int i=2;i<check.length;i++) {
			if(!check[i])
				answer++;
			
		}

      return answer;
      

  }
}


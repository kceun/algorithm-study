package algorithm;

public class Eratosthenes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//에라토스트네스의 체. 소수 알고리즘을 구하는 가장 최적의 방법
		//2의 배수를 싹다 제외시킨다. 3의배수를 제외시킨다.. 4는이미 제외되었고....그렇게 n개까지 제외시켜본다. 남는이가 소수!
		int num=100;
		boolean[] check = new boolean[num+1];
		
		
		for(int i=2;i<=num;i++) {
			if(check[i])
				continue;
			for(int j=i+i;j<=num;j+=i) {
				check[j]=true;
			}
		}
		
		System.out.println("***소수인것만 나온다***");
		
		for(int i=0;i<check.length;i++) {
			if(!check[i])
				System.out.print(i+" ");
			
		}
		
	}

	
}

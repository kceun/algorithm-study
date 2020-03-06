import java.util.*;

public class Main {

	public static int N,P,ans = 0;
	public static Stack<Integer>[] stack;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		P = sc.nextInt();
		stack = new Stack[N+1];
		for(int i=0; i<=N; i++)
            stack[i] = new Stack<>();

		for (int i = 0; i < N; i++) {
			int line = sc.nextInt();
			int fret = sc.nextInt();
			
			//해당 줄에 아무 프렛도 안눌러있는상태 == 스택이 비어있는 경우
			if(stack[line].size()==0) {
				ans++;
				stack[line].push(fret);
				continue;
			}
			
			
			//해당 줄의 프렛보다 더 큰수의 프렛을 누르고 있는 경우
			while(stack[line].peek() > fret) {
					ans++;
					stack[line].pop();
					if(stack[line].size()==0)
						break;
			}
            
			//누르려고하는 프렛과 이미 그 줄에 눌려있는 프렛의 번호가 같은 경우
			if(stack[line].size()!=0 && stack[line].peek()==fret)
				continue;
		


			ans++;
			stack[line].push(fret);
			
		}
		
		System.out.println(ans);
		
	}

}

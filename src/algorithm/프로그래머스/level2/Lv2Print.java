package algorithm.프로그래머스.level2;
import java.util.*;
public class Lv2Print {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution s = new Solution();
		int[] priorities = {1,1,9,1,1,1};
		int location = 0;
		System.out.println(s.solution(priorities, location));
	}

	
}
class KeyVal {
	public int key;
	public int value;
	
	public KeyVal(int k, int v) {
		this.key=k;
		this.value=v;
	}
}
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<KeyVal> queue = new LinkedList<KeyVal>();	//대기열의 역할을 하는 큐
        
        for(int i=0;i<priorities.length;i++) {
           KeyVal map = new KeyVal(i,priorities[i]);
            queue.add(map);
        }
        
        while(!queue.isEmpty()) {

            KeyVal num = queue.poll(); 		//현재 큐의 맨앞에 담긴 우선순위
            boolean isChange = false;             //큐에 변경이 있었는지 확인 여부
            for(KeyVal kv : queue) {
            	if(num.value<kv.value) {
            		isChange=true;            		
            	}
            }
            
            if(!isChange) {		// 현재 맨 앞 값보다 큰 수가 있었을시에..
            	answer++;
            	if(location==0)	
            		return answer;
            } else {
            	queue.add(num);
            }
            
            location--;
            
            if(location<0) {
            	location+=queue.size();
            }
        }
        
        return answer;
    }
}
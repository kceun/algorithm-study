package algorithm.프로그래머스.level2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class Lv2Joggi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Gumeong gu = new Gumeong();
		int [] peo = {70,50,80,50};
		int limit = 100;
		System.out.println(gu.solution(peo, limit));
	}

	
}
class Gumeong {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Stack<Integer> stack = new Stack<Integer>();
        Integer[] peo = new Integer[people.length];
        for(int i=0;i< people.length;i++) {
            peo[i]=Integer.parseInt(String.valueOf(people[i]));
        }
        Arrays.sort(peo,new Comparator<Integer>(){
          
            public int compare(Integer o1, Integer o2){
                if(o1<o2)
                    return 1;
                else if(o1==o2)
                    return 0;
                else
                    return -1;
            }
        });
        
        for(int i=0;i<peo.length;i++) {
            stack.push(peo[i]);
        }
        
       while(!stack.isEmpty()){
           int num = stack.pop();
               if(stack.peek() <= limit-num) {
                   answer++;
                   stack.pop();
               }else {
                   answer++;
               }
       }


        return answer;
}
}
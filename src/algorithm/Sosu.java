package algorithm;

import java.util.HashMap;

public class Sosu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1, 5, 2, 6, 3, 7, 4}; 
		int[][] command = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		solution(array,command);
//		int[] s = solution(array,command);
//		
//		for (Integer num : s) {
//			System.out.println(num+",");
//		}
		
		
	}
	
	
	public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[100];
        //System.out.println("dddd");
        int x = 0;
        
        while(x<2) {
            int[] cutarr = new int[100];
            int i = commands[x][0];
            int j = commands[x][1];
            int k = commands[x][2];
            int n = i-1;
            
            //i~j 자르기
            for(int num = 0; num<j-i+1 ; num++) {
                System.out.println(array[n]);
            	cutarr[num] = array[n++];
            }


            
            //정렬
           int least,temp,n1,n2 = 0;
            for(n1 = 0 ; n1 < cutarr.length-1; n1++){
                least = cutarr[n1];
                for(n2=1;n2<cutarr.length; n2++) {
                    if(least > cutarr[n2]) {
                        temp = least;
                        least = cutarr[n2];
                        cutarr[n2] = temp;
                    }
                }
                
            }
            
            //숫자 저장
            answer[x] = cutarr[k-1];
            for(int nn : answer) {
                System.out.println(nn);
            }
                
            x++;    
        
        }
        
		
		return answer;
	}
}


/*class Solution {
    public int solution(String numbers) {
        int answer = 0;
        return answer;
    }
}*/
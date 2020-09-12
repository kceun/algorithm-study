package algorithm.프로그래머스.level2;

import java.util.ArrayList;
import java.util.HashMap;

public class 압축 {

	public static void main(String[] args) {

	}

    public static int idx = 1;
    public static int[] answer = {};
    public static ArrayList<Integer> list = new ArrayList<Integer>();
    public static HashMap<String,Integer> map = new HashMap<String,Integer>();
    public int[] solution(String msg) {

        //A~Z사전 생성     
        while(idx<=26) {
            map.put(String.valueOf((char)('A'+idx-1))  , idx++ );
            // idx++;
        }
        
        
        solve(msg);
        
        answer = new int[list.size()];
        for(int i = 0 ; i< list.size();i++){
            answer[i]=list.get(i);
        }
        
        return answer;
    }
    
    public void solve(String msg) {
        
        if(msg.isEmpty())
            return;
        
        String w = "";
        String c = "";
        int max = Integer.MIN_VALUE;
        // 사전에서 현재 입력과 일치하는 가장 긴문자열 찾기
        for(String key : map.keySet()){
            if(msg.startsWith(key)){
                max = Math.max(max, key.length());
                w = (max == key.length() ? key : w);
            }
        }
        // 색인 번호 출력
        list.add(map.get(w));
        
        //w 제거
        msg = msg.replaceFirst(w,"");
        
        //글자가 남아있는가?
        if(msg.length()>0){
            c = msg.substring(0,1);
            map.put(w+c, idx++);
        }
        
        solve(msg);
        
        
    }
}

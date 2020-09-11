package algorithm.프로그래머스.level2;

import java.util.ArrayList;
import java.util.HashMap;

public class 오픈채팅방 {

	public static void main(String[] args) {


	}

    public String[] solution(String[] record) {
        HashMap<String,String> map = new HashMap<String,String>();
        ArrayList<String> list = new ArrayList<String>();
        String[] answer = {};
        
        for(int i =0;i<record.length; i++) {
            String[] sp = record[i].split(" ");
            
            switch(sp[0]){
                case "Enter": { 
                    map.put(sp[1],sp[2]);
                    list.add(sp[1]+"님이 들어왔습니다.");
                    break;
                }
                case "Leave": {
                    list.add(sp[1]+"님이 나갔습니다.");
                    break;
                }
                case "Change": {
                    map.put(sp[1],sp[2]);
                    break;
                }
            }
        }
        
        answer = new String[list.size()];
        
        for(int i = 0 ; i<list.size();i++) {
            String msg = list.get(i);
            String uid = msg.substring(0,msg.indexOf("님"));
            answer[i] = msg.replace(uid, map.get(uid));
            // System.out.println(answer[i]);
        }
        
        return answer;
    }
}

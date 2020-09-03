package algorithm.프로그래머스.level2;

class 문자열압축 {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        
        
        //문자열 길이의 절반만큼 돌면서 압축 가능여부 보기
        //단, 문자열 길이가 1일 경우에는 늘 1이다.
        if(s.length()==1)
            answer = 1;
        for(int n = 1 ; n <= s.length()/2 ; n++) {
            String ansStr = ""; //완성된 문자열
            String orgStr = new String(s); // 원본 문자열
            
            for(int i = 0; i<s.length();i++) {
                if(i+n > s.length())
                    continue;
                int cnt = 1;
                String compStr = s.substring(i,i+n); // 압축할 대상 문자열
               
                orgStr = orgStr.replaceFirst(compStr,"");
                
                //다음 문자열이 반복되는가?
                while(orgStr.startsWith(compStr)) {
                    cnt ++;
                    orgStr = orgStr.replaceFirst(compStr,"");
                
                }
                
                i = i+(cnt*n)-1;
                if(cnt>1) {
                    ansStr += cnt+compStr;
                }
                else {
                    ansStr += compStr;
                }

            }
            ansStr += s.substring((s.length()/n)*n,s.length()); //n단위로 잘랐을때 남은 뒤에 나머지 값들 붙여주기 
            answer = Math.min(answer,ansStr.length());
        }
        
        return answer;
    }
}

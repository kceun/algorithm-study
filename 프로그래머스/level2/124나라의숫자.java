class Solution {
    public String solution(int n) {
        String answer = "";
        int mod=0;
        
        while(n>0) {
            
            if(n%3==0) {
                n = (n/3)-1;
                mod = 4;
            }
            else {
                mod = n%3;
                n = n/3;
                
            }
            answer = mod+answer;
        }
    
        System.out.println(answer);
        return answer;
    }
}

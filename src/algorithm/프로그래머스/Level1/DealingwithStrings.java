package algorithm.프로그래머스.Level1;

class DealingwithStrings {
  public boolean solution(String s) {
      boolean answer = true;
      int len = s.length();      
      try {
            if(len != 4 && len != 6){
                answer = false; 
            }
            Integer.parseInt(s);
      } catch (Exception ex) {
            answer =false;
      }
      
      return answer;
  }
}

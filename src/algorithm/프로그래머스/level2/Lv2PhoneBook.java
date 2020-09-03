package algorithm.프로그래머스.level2;

public class Lv2PhoneBook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution2 s = new Solution2();
		String[] str = {"12232332", "12", "222222"};
		System.out.println(s.solution(str));
	}

}
class Solution2 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        for(int i = 0; i<phone_book.length;i++) {
            if(answer){
                String head = phone_book[i];
                String sss= "#####";
                System.out.println(sss.replaceFirst("#", "+"));
                for(int j =0;j<phone_book.length ;j++){
                    if(i!=j && head.length() <= phone_book[j].length()){
                    	System.out.println(phone_book[j].substring(0,head.length()));
                        if(head.equals(phone_book[j].substring(0,head.length()))) {
                            answer=false; break;
                        }
                    }

                }
            }
        }
        return answer;
    }
}
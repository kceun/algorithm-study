package algorithm.프로그래머스.level2;

public class Lv2JoyStick {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name="JEROEN";
		
		 int answer = 0;
	        for(int i =0;i<name.length();i++) {
	            //int n1= name.charAt(i)-'A';
	            //int n2= (name.charAt(i)-'Z')*(-1);
	            int num = (name.charAt(i)-'A'<(name.charAt(i)-'Z'-1)*(-1)) ? name.charAt(i)-'A': (name.charAt(i)-'Z'-1)*(-1);
	            answer +=num;
	        }
	        answer +=name.length()-1;
	     System.out.println(answer);
	     
	     System.out.println(('Y'-'Z'-1));
	}

}

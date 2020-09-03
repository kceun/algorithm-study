package algorithm;

public class Lv2Big {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "123345";
		StringBuilder sb = new StringBuilder();
		sb.append(str);
		sb.reverse();
		System.out.println(sb);
		
		 sb.delete(sb.length()-4, sb.length());
		 System.out.println(sb);
	}

}

package algorithm;

public class CRtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//=========그냥 값을 보냈을때 .. 원래 String도 객체이지만 거의..그냥 일반변수로 작동해서 그런갑다?!
		String p = "나는 메인";
		System.out.println(p); //나는 메인
		cvtest01(p);
		System.out.println(p); //나는 메인
		cvtest02(p);
		System.out.println(p); //나는 메인
		
		//=========클래스 객체 형태로 값을 보냈을 때..
		Fruit f = new Fruit("사과");
		System.out.println(f.getName()); //사과
		cvtest03(f);
		System.out.println(f.getName()); //바나나
		cvtest04(f);
		System.out.println(f.getName()); //바나나
		f = cvtest05(f);
		System.out.println(f.getName()); //맛있는 딸기
	}
	
	public static void cvtest01(String p) {
		p = "나는 다른함순디??";
	}
	
	public static void cvtest02(String p) {
		p = new String("나는 새로 만들었는디??");
	}

	public static void cvtest03(Fruit f) {
		f.setName("바나나");
	}
	
	public static void cvtest04(Fruit f) {
		f = new Fruit("포도포도");
	}
	
	public static Fruit cvtest05(Fruit f) {
		return new Fruit("맛있는딸기");
	}
}
class Fruit {
	private String name;
	
	Fruit(String name) {
		this.name=name;
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

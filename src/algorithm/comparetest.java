package algorithm;

import java.util.*;

class Foodie {
	private String name;
	private int price;
	
	public Foodie(String name, int price) {
		this.name=name;
		this.price=price;
	}
	
	public String getName() {
		return this.name;
	}
	public int getPrice() {
		return this.price;
	}
}
public class comparetest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Integer[] num = {2,10,4,6,1,8};
		List<Integer> list = Arrays.asList(num);
		
		Collections.sort(list);
		System.out.println(list);
		
		ArrayList<Foodie> flist = new ArrayList<Foodie>();

		flist.add(new Foodie("햄버거",4500));
		flist.add(new Foodie("뿌링클",19000));
		flist.add(new Foodie("크리스피도넛",1400));
		flist.add(new Foodie("쌀국수",8000));
		
		Comparator<Foodie> priceComparator = new Comparator<Foodie>() {
			@Override
			public int compare(Foodie o1, Foodie o2) {
				return o2.getPrice() - o1.getPrice();
			}
		};
		for(Foodie f : flist) {
			System.out.print("[name:"+f.getName()+" price:"+f.getPrice()+"] ");
			System.out.println();
		}
		System.out.println("--------------------------------");
		Collections.sort(flist,priceComparator);
		for(Foodie f : flist) {
			System.out.println("[name:"+f.getName()+" price:"+f.getPrice()+"] ");
		}
		
	}

}

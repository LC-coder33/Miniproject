package _Parking_program;

import java.util.Scanner;
import java.util.ArrayList;

public class Pay {
	ArrayList<CarOne> plist = new ArrayList<>();
	ArrayList<Pay> total =new ArrayList<>();
	ArrayList<CarOne> pclist = null;
	
	String cNum = null;
	int[] discount = {3,2,1,0};
	int basePrice = 1500;
	int payPerHour = 1000;
	int totalPrice = 0;
	
	public void calculate () {
		Scanner in = new Scanner(System.in);
		Pay p = new Pay();
		System.out.println("차량 번호를 입력하세요.");
		String id = in.nextLine();
		for(int i = 0; i < plist.size(); i++) {
			if(id.equals(plist.get(i).cNumber)) {
				totalPrice = basePrice + payPerHour*plist.get(i).parkingHour-discount[plist.get(i).place]*payPerHour;
				cNum = plist.get(i).cNumber;
			}
			if(plist.get(i).worker.equals("직원")) {
				totalPrice = 0;
				
			}
			p.cNum = cNum;
			p.totalPrice = totalPrice;
			total.add(p);
		}
		for(int i = 0; i < total.size(); i++) {
			if(cNum.equals(total.get(i).cNum)) {
				System.out.println("해당 차량이 지불해야 할 가격: " + total.get(i).totalPrice + "원");
			}
		}
	}
	public void seeAll () {
		for(int i = 0; i < pclist.size(); i++) {
			pclist.get(i).cPrt();
		}
	}
	
}

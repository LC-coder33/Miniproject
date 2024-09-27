package _Parking_program;

import java.util.Scanner;
import java.util.ArrayList;

public class Pay {
	ArrayList<CarOne> plist = new ArrayList<>();
	int[] discount = {3,2,1,0};
	int basePrice = 1500;
	int payPerHour = 1000;
	int totalPrice = 0;
	
	public void calculate () {
		Scanner in = new Scanner(System.in);
		System.out.println("차량 번호를 입력하세요.");
		String id = in.nextLine();
		for(int i = 0; i < plist.size(); i++) {
			if(id.equals(plist.get(i).cNumber)) {
				totalPrice = basePrice + payPerHour*plist.get(i).parkingHour-discount[plist.get(i).place]*payPerHour;
			}
			if(plist.get(i).worker.equals("직원")) {
				totalPrice = 0;
				
			}
			System.out.println("총 지불해야 할 가격: " + totalPrice + "원");
			totalPrice = 0;
		}
	}
	
}

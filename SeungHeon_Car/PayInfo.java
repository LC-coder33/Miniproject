package SeungHeon_Car;

import java.util.ArrayList;
import java.util.Scanner;

public class PayInfo {
	ArrayList<CarOne> history = null;
	Pay pay = new Pay(history);
	Pay copyPay = pay;

	public PayInfo() {
		
	}
	
	public void menu() {
		while(true) {
			System.out.println("1. 기본 금액 입력");
			System.out.println("2. 시간당 금액 입력");
			System.out.println("3. 책정된 금액 확인");
			System.out.println("9. 되돌아가기");
			Scanner in = new Scanner(System.in);
			String temp = in.nextLine();
			
			if(temp.equals("1")) {
				basicPay();
			}else if(temp.equals("2")) {
				timePerPay();
			}else if(temp.equals("3")) {
				viewPay();
			}else if(temp.equals("9")) {
				break;
			}
		}
		
		
	}
	public void basicPay() {
		System.out.println("기본금액을 입력해주세요");
		Scanner in = new Scanner(System.in);
		int temp = in.nextInt();
		in.nextLine();
		pay.insertBasicPay(temp);
		System.out.println("입력된 기본금액: "+pay.basicPay);
	}
	public void timePerPay() {
		System.out.println("시간당 주차비를 입력해주세요");
		Scanner in = new Scanner(System.in);
		int temp = in.nextInt();
		in.nextLine();
		pay.insertHourPerPay(temp);
		System.out.println("입력된 시간 당 금액: "+pay.hourPerPay);
	}
	public void viewPay() {
		System.out.println("기본금액: "+pay.basicPay+"\t"+"시간당금액: "+pay.hourPerPay);
	}
	
}

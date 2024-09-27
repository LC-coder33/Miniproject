package SeungHeon_Car;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MainMenu {
	
	ArrayList<CarOne> clist = new ArrayList<>();		// 차량 정보 객체
	Parking parking = new Parking();		// 주차장 정보 객체
	InoutHistory inoutHistory = new InoutHistory(clist);	// 출입현황 객체
	PayInfo payInfo = new PayInfo();
	
	MainMenu(){
		inoutHistory.payInfo = payInfo; 
	}
	
	public void menu() {
		Scanner in = new Scanner(System.in);
		while(true) {
			System.out.println("1. 입차");
			System.out.println("2. 출차");
			System.out.println("3. 빈자리조회");
			System.out.println("4. 입차된 차 조회");
			System.out.println("5. 지불 정보 입력");
			System.out.println("6. 입출 현황");
			System.out.println("9. 프로그램 종료");
			
			String temp = in.nextLine();
			
			if(temp.equals("1")) {
				inCar();
			}else if(temp.equals("2")) {
				outCar();
			}else if(temp.equals("3")) {
				listPark();
			}else if(temp.equals("4")) {
				listCar();
			}else if(temp.equals("5")) {
				payInfo.menu();
			}else if(temp.equals("6")) {
				inoutHistory.view();
			}else if(temp.equals("9")) {
				break;
			}
			
		}	
	}
	
	public void inCar() {
		Scanner in = new Scanner(System.in);
			
		CarOne carOne = new CarOne();
		carOne.clistJuso = clist;	// carOne 객체에 clist의 주소 입력
		System.out.println("입차 번호 입력");
		String cNumber = in.nextLine();
		System.out.println("주차된 층 입력");
		String cFloor = in.nextLine();
		
		carOne.parkIn(cNumber, cFloor);		// carOne객체의 메서드 parkIn활용 하여 입력한값을 객체에 저장
		clist.add(carOne);				// 만들어진 자동차하나(carOne)의 객체를 list 객체에 저장
		inoutHistory.addIn(carOne);
	}
	
	public void outCar() {
		Scanner in = new Scanner(System.in);
		System.out.println("출차 번호 입력");
		String cNumber = in.nextLine();
		parkOut(cNumber);
		inoutHistory.addOut(cNumber);
	}
	
	public void listPark() {
		
		int cnt1 = 0;
		int cnt2 = 0;
		int cnt3 = 0;
		for(int i = 0; i < clist.size(); i++) {
			if(clist.get(i).cFloor.equals("1")) {
				cnt1++;
			}else if(clist.get(i).cFloor.equals("2")) {
				cnt2++;
			}else if(clist.get(i).cFloor.equals("3")) {
				cnt3++;
			}
		}
		
		parking.parkOne(cnt1, cnt2, cnt3);
	}
	
	public void listCar() {				// 현재 주차된 차량을 확인하는 메서드
		for(int i = 0; i < clist.size();i++) {
			clist.get(i).prt();
		}
	}
	public void parkOut(String cNumber) {
		Random r = new Random();
		boolean check = true;
		for(int i = 0; i < clist.size(); i++) {
			if(clist.get(i).cNumber.equals(cNumber)) {		// 출차할 차량의 번호를 입력 받아
				clist.remove(i);							// 리스트에 저장 되어 있는 자동차 객체의 자동차번호 비교 
				check=false;
			}
		}
		if(check) {
			System.out.println("찾는 차량 번호가 없습니다.");
		}
	}
}

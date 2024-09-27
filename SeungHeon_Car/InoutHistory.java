package SeungHeon_Car;

import java.util.ArrayList;
import java.util.Random;

public class InoutHistory {
	ArrayList<CarOne> history = new ArrayList<>();
	Pay pay = new Pay(history);
	ArrayList<CarOne> listjuso = null;		// MainMenu 에 있는 객체의 주소를 가져와 사용하려 함
											// 코드 작성중 그렇게 할 필요가 없다는걸 확인
											// 하지만 객체의 주소를 가져와 활용하는 방법을 알게 됐으므로 코드를 지우지 않음
											// 프로그램 작동에는 관여하지 않는 코드
	PayInfo payInfo = null;
	
	public InoutHistory(ArrayList<CarOne> listjuso) {
		this.listjuso=listjuso;
	}
	public void addIn(CarOne one) {
		history.add(one);
	}
	public void addOut(String cNumber) {
		Random r = new Random();
		for(int i = 0; i < history.size(); i++) {
			if(cNumber.equals(history.get(i).cNumber)) {
				int temp = history.get(i).inTime;
				int temp2 = r.nextInt(24-temp)+temp;
				history.get(i).outTime = temp2; 
			}
		}
	}
	
	public void view() {
		System.out.println("=======================================================================");
		for(int i = 0; i < history.size(); i++) {
			System.out.print("차량번호:"+history.get(i).cNumber+"\t"+"주차 층:"+history.get(i).cFloor+"\t");
			int a= history.get(i).inTime;	//입차시간
			int b= history.get(i).outTime;	//출차시간
			int c= payInfo.copyPay.basicPay; // 기본요금
			int d= payInfo.copyPay.hourPerPay; // 시간당요금
			int payHow = (b-a)*d+c;	// 주차요금
			if(history.get(i).outTime != 0) {
				System.out.println("\t"+"입차시간:"+a+":00"+"\t"+"출차시간:"+b+":00"+"\t"+"주차요금: "+payHow);							
			}else {
				System.out.println("\t"+"입차시간:"+a+":00"+"\t"+"출차시간:"+"현재주차중"+"\t"+"주차요금: "+"미 정");
			}
		}
		System.out.println("=======================================================================");
	}
	
	
}

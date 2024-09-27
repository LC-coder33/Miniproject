package _Parking_program;

public class CarOne {
	String cNumber = null;		// 차 번호
	int cFloor = 0;				// 층 번호
	String worker = "손님";		// 직원 확인
	String inTime = null;		// 입차 시간
	String exitTime = null;		// 출차 시간
	int place = 0;		// 할인 받은 곳
	int parkingHour = 0;		// 주차한 기간
	
	public void addCar(String cNum, int fNum) {
		cNumber = cNum;
		cFloor = fNum+1;
	}
	
	public void cPrt() {
		System.out.println("차번호: " + cNumber + " 주차된 층: " + cFloor + "층" + " 직원 여부: " + worker);
		System.out.println("입차 시간: " + inTime);
	}
}

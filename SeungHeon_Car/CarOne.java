package SeungHeon_Car;

import java.util.ArrayList;
import java.util.Random;

public class CarOne {
	ArrayList<CarOne> clistJuso = null;
	String cNumber = null;
	String cFloor =  null;
	int inTime = 0;
	int outTime = 0;
	
	public void parkIn(String cNumber, String cFloor) {
		Random r = new Random();
		this.cNumber = cNumber;
		this.cFloor =cFloor;
		inTime = r.nextInt(23)+1;	// 입차시간 1시각 부터 23시각으로 가정
	}
	
	public void prt() {
		System.out.println("입차 번호: "+cNumber+"\t"+"주차 위치: "+cFloor);
	}
}

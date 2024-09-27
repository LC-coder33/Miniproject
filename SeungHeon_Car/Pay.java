package SeungHeon_Car;

import java.util.ArrayList;

public class Pay {
	int basicPay = 0;
	int	hourPerPay = 0;
	ArrayList<CarOne> history = null;
	
	public Pay(ArrayList history) {
		this.history = history;		// MainMenu 에 있는 history 객체의 주소를 가져옴
	}
	
	public void insertBasicPay(int basicPay) {
		this.basicPay = basicPay;
	}
	public void prt() {
		System.out.println(history.get(0).cNumber);
	}
	public void insertHourPerPay(int hourPerPay) {
		this.hourPerPay = hourPerPay;
	}
}

package _Parking_program;

public class Parking {
	int[] floors = new int[] {50, 50, 50};
	
	public void delFloors(int fNum) {
		floors[fNum]--;
	}
	
	public void addFloors(int i) {
		if(floors[i] < 50) {
		floors[i]++;
		} else {
			System.out.println("50개가 최대 빈자리입니다.");
		}
	}

	public void pPrt() {
		System.out.println("빈공간 확인하기");
		System.out.println("1층: " + floors[0] + "개");
		System.out.println("2층: " + floors[1] + "개");
		System.out.println("3층: " + floors[2] + "개");
	}
}

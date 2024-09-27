package SeungHeon_Car;

public class Parking {
	int floor1 = 50;
	int floor2 = 50;
	int floor3 = 50;
	
	public void pPrt() {
		System.out.print("1층 ?자리 	2층 ?자리 	3층 ?자리");
		System.out.println(" ");
	}
	
	public void parkOne(int a, int b, int c) {
		int rest1 = floor1-a;
		int rest2 = floor2-b;
		int rest3 = floor3-c;
		int sum = rest1+rest2+rest3;
		int sumTotal = floor1+floor2+floor3;
		System.out.println("1층\t"+rest1+" / "+floor1);
		System.out.println("2층\t"+rest2+" / "+floor2);
		System.out.println("3층\t"+rest3+" / "+floor3);
		System.out.println("총구역\t"+sum+" / "+sumTotal);
	}
}

package _Parking_program;

import java.util.Random;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.ArrayList;

public class MainMenu {
	ArrayList<CarOne> clist = new ArrayList<>();
	Parking parking = new Parking();
	String[] junev = {"CGV","이마트","몰", "없음"};
	Pay pay = new Pay();
	
	MainMenu () {
		Scanner in = new Scanner(System.in);
		System.out.println("[주차장 관리 프로그램]");
		
		while(true) {
			System.out.println("1. 입차");
			System.out.println("2. 출차");
			System.out.println("3. 주차장 정보 보기");
			System.out.println("4. 차량 정보 보기");
			System.out.println("5. 주차 가격 보기");
			System.out.println(" 선택 >>");
			
			int selNum = in.nextInt();
			in.nextLine();
			
			if(selNum == 1) {
				inCar();
			} else if(selNum == 2) {
				outCar();
			} else if(selNum == 3) {
				listPark();
			} else if(selNum == 4) {
				listCar();
			} else if(selNum == 5) {
				listPay();
			}
			else {
				System.out.println("잘못 선택하셨습니다.");
			}
		}
	}
	public String duplicateIDcheck(String cNum) {
		for(int i=0; i < clist.size(); i++) {
			if(clist.get(i).cNumber.equals(cNum)) {
				return "Yes";			// 중복이니 문제가 있음
			}
		}
		return "No";			// 중복이 아니니 문제가 없음
	}
	
	public String checkVnumber(String cNum) {
		if(cNum.length() < 4) {
			return "Yes";
		}
		String tletter = String.valueOf(cNum.charAt(2));
		String fletter = String.valueOf(cNum.charAt(3));
			if(cNum.length() == 7) {
				if(Pattern.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*", tletter)) {
					return "No";									// 한글이니 문제가 없음
					} 
			}
				else if(cNum.length() == 8) {
						if(Pattern.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*", fletter)) {
							return "No";
						}
					}
		return "Yes";			// 한글이 아니라 문제가 있다는 뜻
	}
	
	public void inCar() {
		Scanner in = new Scanner(System.in);
		CarOne CO = new CarOne();
		int numF = 0;
		
		 while (true) {
		        System.out.println("직원입니까? 예/아니오 로 대답하세요");
		        String checkworker = in.nextLine();
		        if (checkworker.equals("예")) {
		            CO.worker = "직원";
		            break; // Exit loop if valid input
		        } else if (checkworker.equals("아니오")) {
		            CO.worker = "손님";
		            break; // Exit loop if valid input
		        } else {
		            System.out.println("다시 시작하세요.");
		        }
		    }
		
		System.out.println("차량 번호를 입력하세요.");
		System.out.println("12허9982 같은 7자리 번호나 123마1214 와 같은 8자리 번호를 입력해주세요.");
		String cNum = in.nextLine();
		String duplicateCheck = duplicateIDcheck(cNum);
		String formatCheck = checkVnumber(cNum);
		if(duplicateIDcheck(cNum) == "Yes" && checkVnumber(cNum).equals("No")) {
			System.out.println("입력한 차량 번호는 중복됩니다.");
		} else if(duplicateIDcheck(cNum) == "No" && checkVnumber(cNum).equals("Yes")) {
			System.out.println("잘못 된 형식으로 입력하셨습니다.");	
		}
		else if(duplicateIDcheck(cNum) == "No" && checkVnumber(cNum).equals("No")) {
		System.out.println("주차 할 층을 입력하세요.");
		int fNum = in.nextInt()-1;
		in.nextLine();
		Random random = new Random();
        int hour = random.nextInt(24); // 0부터 23시까지
        int minute = random.nextInt(60); // 0부터 59까지
        int second = random.nextInt(60); // 0부터 59까지
        LocalDateTime randomDate = LocalDateTime.of(2024, 9, 24, hour, minute, second);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 hh시 mm분 ss초");
        CO.inTime = randomDate.format(formatter);
		CO.addCar(cNum,fNum);
		parking.delFloors(fNum);
		clist.add(CO);
		}

	}
	
	public void outCar() {
		Scanner in = new Scanner(System.in);
		System.out.println("출차할 차량 번호를 입력하세요");
		String del = in.nextLine(); // 출차할 차량 번호
		boolean check = true;
		
		for(int i = 0; i < clist.size(); i++) {
			if(clist.get(i).cNumber.equals(del)) {
					parking.addFloors(clist.get(i).cFloor-1);
					Random random = new Random();
					int day = Integer.parseInt(clist.get(i).inTime.substring(10, 12)) + random.nextInt(2);
					if(day == 25) {
						int hour = random.nextInt(24);
						int minute = random.nextInt(60);
				        int second = random.nextInt(60);
				        LocalDateTime randomDate = LocalDateTime.of(2024, 9, day, hour, minute, second);
				        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초");
				        clist.get(i).exitTime = randomDate.format(formatter);
				        int payHour = hour + 24 - Integer.parseInt(clist.get(i).inTime.substring(14, 16));
				        clist.get(i).parkingHour = payHour;
					}
					if(day == 24) {
						int pHour = Integer.parseInt(clist.get(i).inTime.substring(14, 16));
						int pHour2 = random.nextInt(24 - pHour);	// 13
						int hour = pHour + pHour2;		//11 + (0~13)
						int pMinute = Integer.parseInt(clist.get(i).inTime.substring(18, 20));
						int pMinute2 = random.nextInt(60 - pMinute);
						int minute = pMinute + pMinute2;
						int pSecond = Integer.parseInt(clist.get(i).inTime.substring(22, 24));
						int pSecond2 = random.nextInt(60 - pSecond);
						int second = pSecond + pSecond2;
				        LocalDateTime randomDate = LocalDateTime.of(2024, 9, day, hour, minute, second);
				        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초");
				        clist.get(i).exitTime = randomDate.format(formatter);
				        int payHour = hour - pHour;
				        clist.get(i).parkingHour = payHour;
					}
					
					System.out.println("할인 받은 매장의 번호를 입력하세요. 1. CGV 2. 이마트 3. 쥬네브몰 4. 없음");
					int place = in.nextInt()-1;
					
					clist.get(i).place = place;
					
					System.out.println("입차 시간: " + clist.get(i).inTime);
					System.out.println("출차 시간: " + clist.get(i).exitTime);
					System.out.println("주차 기간: " + clist.get(i).parkingHour + "시간");
					System.out.println("할인 받은 장소: " + junev[place]);
					
					pay.plist.add(clist.get(i));
					clist.remove(i);
					check = false;
					System.out.println(del + " 번호 차량이 출차 하였습니다.");
					
			}
		}
		if(check) {
			System.out.println("찾는 차량 번호가 없습니다.");
		}
	}
	
	public void listPark() {
		parking.pPrt();
	}

	public void listCar() {
		for(int i = 0; i < clist.size(); i++) {
			clist.get(i).cPrt();
		}
	}
	
	public void listPay() {
		pay.calculate();
	}
	
}

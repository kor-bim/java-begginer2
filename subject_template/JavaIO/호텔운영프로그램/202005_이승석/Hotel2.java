package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Hotel2 {
	

	// sc는 입력을 하기위한 변수
	// re를 통해 예약을 저장
	private Scanner sc;
	private Map<String, HotelReserve5> re ; 
	
	public Hotel2() {
		sc = new Scanner(System.in);
		re = new HashMap<String, HotelReserve5>();
	}
	
	public static void main(String[] args) {
		Hotel2 hw = new Hotel2();
		hw.HotelStart();
	}
	// 호텔 메뉴를 알리기 위한 메서드
	public void Menu() {
			System.out.print("번호를 입력해주세요");
			System.out.println("어떤 업무를 하시겠습니까?");
			System.out.println("1.체크인  2.체크아웃 3.객실상태  4.업무종료");
			System.out.println("**************************");
	}
	
	// 호텔서비스를 시작하기 위한 메서드		
	private void HotelStart() {
		input();
		System.out.println("**************************");
		System.out.println("호텔 문을 열었습니다.");
		System.out.println("**************************");
		while (true) {
			Menu();
			Scanner sc = new Scanner(System.in);
			try {
				
				int check = sc.nextInt();

				switch (check) {
				case 1:
					checkin();
					break;
				case 2:
					checkout();
					break;
				case 3:
					display();
					break;
				case 4:
					output();
					finish();
					return;
				default:
					System.out.println("숫자를 잘못 입력하셨습니다.");
					break;
				}

			} catch (Exception e) {
				System.out.println("숫자만입력하세요");
			}
		}

	}

	// 호텔을 종료하기 위한 메서드
	private void finish() {
			System.out.println("**************************");
			System.out.println("호텔 문을 닫았습니다.");
			System.out.println("**************************");
			
		}

	// 현재 호텔의 투숙객의 상황에 대해 알려주는 메서드
	private void display() {

		Set<String> search = re.keySet();
		System.out.println("====================");
		System.out.println("방번호\t투숙객");
		System.out.println("====================");

		if (search.size() == 0) {
			System.out.println("체크인중인 방이 없습니다.");
		} else {
			Iterator<String> info = search.iterator();
			while (info.hasNext()) {
				String room = info.next();
				HotelReserve5 h = re.get(room);
				System.out.println(h.getName() + "\t" + h.getRoom());
					
			}
			System.out.println("=====================");
			
		}

	}

		// 체크아웃을 하기위한 메서드
		private void checkout() {
			System.out.println();
			System.out.println("머물렀던 방번호를 입력해 주세요");
			System.out.print("방번호 입력 = >" );
			String room = sc.next();
			
			if(re.remove(room) == null) {
				System.out.println(room + "번 방은 체크인한 사람이 없습니다.");
				return;
			}
			System.out.println(room + "번 방은체크 아웃되었습니다.");
			
		}

		// 체크인을 하기 위한 메서드
		private void checkin() {
			System.out.println();
			System.out.println("어느방에 체크인 하시겠습니까?");
			System.out.print("방번호 입력 =>" );
			String room = sc.next();
			if(re.get(room)!=null) {
				System.out.println(room + "번 방은 이미 사람이 있습니다.");
				return;
			}
			
			System.out.println("누구를 체크인 하시겠습니까?");
			String name = sc.next();
			System.out.println("이름 입력 => " + name);
			
			re.put(room, new HotelReserve5(room, name));
			System.out.println("체크인 되었습니다.");
			
		}
	
	// 호텔의 정보를 읽어오기 위한 메서드
		
	@SuppressWarnings("unchecked")
	private void input() {
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("d:/D_Other/HotelList.txt")));
			Object obj = null;
			
			try {
				while ((obj = ois.readObject()) != null) {
					
					//obj의 정보를 re에 저장
					re = (Map<String, HotelReserve5>) obj;
					
//					if(ois != null) {
					ois.close();
//					}				

				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
//			e.printStackTrace();
		}
	}
	
	// 호텔의 정보를 생성 및 저장하기 위한 메서드
	private void output() {
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("d:/D_Other/HotelList.txt")));
			
			//전역변수인 re의 정보를 oos에 저장
			oos.writeObject(re);


//			if(oos != null) {
				oos.close();
//			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

// 호텔예약을 위한 VO
class HotelReserve5 implements Serializable{
	private String room; //방번호
	private String name; //이름
	
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	@Override
	public String toString() {
		return "HotelReserve [room=" + room + ", name=" + name + "]";
	}
	public HotelReserve5(String room, String name) {
		super();
		this.room = room;
		this.name = name;
	}
	
	
	
}

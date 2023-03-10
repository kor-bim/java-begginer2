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

public class HotelManageIO {
	Map<String, Room> hotelMap = new HashMap<>();
	private Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		new HotelManageIO().start();
	}

	public void start() {
		System.out.println("\r\n" + "*******************************************\r\n"
				+ "    ใพ(โงโฝโฆ*)o ๐ํธํ ๋ฌธ์ ์ด์์ต๋๋ค ๐o(*๏ฟฃโฝ๏ฟฃ*)ใ\r\n" + "\r\n"
				+ "*******************************************");
		load();
		while (true) {
			display();
			String select = sc.next();
			switch (select) {
			case "1":
				checkIn();
				break;
			case "2":
				checkOut();
				break;
			case "3":
				roomStatus();
				break;
			case "4":
				// ์ข๋ฃ
				save();
				System.out.println("    (โช.โช )...zzz ์ข๋ฃํฉ๋๋ค (โช.โช )...zzz");
				return;
			default:
				System.out.println("์๋ชป์๋ ฅํ์ต๋๋ค. ๋ค์ ์๋ ฅ ํด์ฃผ์ธ์");
			}// switch๋ฌธ
		} // while๋ฌธ
	}

	/**
	 * ๋ฐ์ดํฐ ๋ถ๋ฌ์ค๊ธฐ
	 */
	@SuppressWarnings("unchecked")
	private void load() {
		try {
			ObjectInputStream ois = new ObjectInputStream(
					new BufferedInputStream(new FileInputStream("d:/D_Other/hotelManage.bin")));
			Object obj = null;
			try {
				if ((obj = ois.readObject()) != null) {
					// ์ฝ์ด์จ ๋ฐ์ดํฐ๋ฅผ ์๋์ ๊ฐ์ฒดํ์ผ๋ก ๋ณํ ํ ์ฌ์ฉํ๋ค.
					hotelMap = (Map<String, Room>) obj;
					System.out.println("\t           ๐ฅ๋ฐ์ดํฐ ๋ก๋์๋ฃ..๐ก");
				}
				ois.close();
			} catch (ClassNotFoundException e) {

			}
		} catch (IOException e) {

		}
	}

	/**
	 * ๋ฐ์ดํฐ ์ ์ฅ
	 */
	private void save() {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(
					new BufferedOutputStream(new FileOutputStream("d:/D_Other/hotelManage.bin")));
			oos.writeObject(hotelMap);
			System.out.println("*******************************************");
			System.out.println("\t+(โ๏พใฎ๏พ)โ ๐พ์ ์ฅ์๋ฃ๐พ ใพ(โงโฝโฆ*)o");
			System.out.println("*******************************************");
			oos.close();
		} catch (Exception e) {
			System.out.println("โ( T๏นT )โ ์ ์ฅ์คํจ... (ใฃ ยฐะ ยฐ;)ใฃ ");
		}
	}

	/**
	 * ๋ฉ๋ดํ๋ฉด
	 */
	public void display() {
		System.out.println("*******************************************\r\n" + "์ด๋ค ์๋ฌด๋ฅผ ํ์๊ฒ ์ต๋๊น?\r\n"
				+ "1.์ฒดํฌ์ธ  2.์ฒดํฌ์์ 3.๊ฐ์ค์ํ 4.์๋ฌด์ข๋ฃ\r\n" + "*******************************************");
		System.out.print("๋ฉ๋ด์ ํ =>");
	}

	/**
	 * ๊ฐ์ค ์ ์ฒด ์ ๋ณด๋ฅผ ๋ถ๋ฌ์ค๋ ๋ฉ์๋
	 */
	private void roomStatus() {
		Set<String> keySet = hotelMap.keySet();
		System.out.println("=================================================");
		System.out.println("๋ฒํธ\t์ด๋ฆ\t๋ฐฉ๋ฒํธ");
		System.out.println("=================================================");

		if (keySet.size() == 0) {
			System.out.println("๋ฑ๋ก๋ ๋ฐฉ์ ๋ณด๊ฐ ์์ต๋๋ค");
		} else {
			Iterator<String> it = keySet.iterator();
			int cnt = 0;
			while (it.hasNext()) {
				cnt++;
				String name = it.next();
				Room r = hotelMap.get(name);
				System.out.println(" " + cnt + "\t" + r.getName() + "\t" + r.getRoomNum());
			}
		}
		System.out.println("=================================================");
		System.out.println("์ถ๋ ฅ์๋ฃ!");
	}

	/**
	 * ์ฒดํฌ์ธํ๋ ๋ฉ์๋
	 */
	private void checkIn() {

		System.out.println("์ด๋๋ฐฉ์ ์ฒดํฌ์ธ ํ์๊ฒ ์ต๋๊น?");
		System.out.print("๋ฐฉ๋ฒํธ >>");
		String roomNum = sc.next();
		// ์ด๋ฏธ ๋ฑ๋ก๋ ์ฌ๋์ธ์ง ๊ฒ์ฌ
		// get()๋ฉ์๋๋ก ๊ฐ์ ๊ฐ์ ธ์ฌ ๋ ๊ฐ์ ธ์ฌ ์๋ฃ๊ฐ ์์ผ๋ฉด null์ ๋ฐํ๋๋ค.
		if (hotelMap.get(roomNum) != null) {
			System.out.println(roomNum + "ํธ์๋ ์ด๋ฏธ ์ฌ๋์ด ์์ต๋๋ค.");
			return;
		}

		System.out.print("์ด๋ฆ์๋ ฅ >>");
		String name = sc.next();

		hotelMap.put(roomNum, new Room(roomNum, name));
	}

	/**
	 * ์ฒดํฌ์์ํ๋ ๋ฉ์๋ ์ ๋ณด ์ญ์ 
	 */
	private void checkOut() {

		System.out.println();
		System.out.println("์ด๋๋ฐฉ์ ์ฒดํฌ์์ ํ์๊ฒ ์ต๋๊น?");
		System.out.print("๋ฐฉ๋ฒํธ >> ");
		String roomNum = sc.next();

		// remove(key) => ์ญ์  ์ฑ๊ณตํ๋ฉด ์ญ์ ๋ value๊ฐ์ ๋ฐํํ๊ณ , ์คํจํ๋ฉด null ๋ฐํํ๋ค.
		if (hotelMap.remove(roomNum) == null) {
			System.out.println(roomNum + "ํธ์๋ ์ฒดํฌ์ธํ ์ฌ๋์ด ์์ต๋๋ค");
		} else {
			System.out.println(roomNum + "ํธ ์ฒดํฌ์์ ๋์์ต๋๋ค");
		}
	}
}

/**
 * ํธํ ์ ๋ณด๋ฅผ ์ ์ฅํ๊ธฐ ์ํ VO ํด๋์ค
 * 
 * @author ์คํ๋น
 * @since 2020.09.16
 */
@SuppressWarnings("serial")
class Room implements Serializable {
	private String name;
	private String roomNum;

	public Room(String roomNum, String name) {
		super();
		this.roomNum = roomNum;
		this.name = name;
	}

	public String getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
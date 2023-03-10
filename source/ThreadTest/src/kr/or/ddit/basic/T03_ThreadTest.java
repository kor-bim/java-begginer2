package kr.or.ddit.basic;

/**
 * 쓰레드의 수행시간 체크하기
 */
public class T03_ThreadTest {
	public static void main(String[] args) {
		Thread th = new Thread(new MyRunner());

		// 1970년 1월 1일 0시 0분 0초(표준시)로부터 경과한 시간들
		// 밀리세컨드(1/1000초)단위로 나타낸다.
		long startTime = System.currentTimeMillis();

		th.start();

		try {
			th.join(); // 현재 실행중인 쓰레드에서 작업중인 쓰레드(지금은 th 쓰레드)가 종료될때 까지 기다린다.
		} catch (Exception e) {
			// TODO: handle exception
		}
		long endTime = System.currentTimeMillis();
		System.out.println("경과시간 : " + (endTime - startTime) + "㎳");
	}
}

class MyRunner implements Runnable {

	// 1~10억까지의 합계 구하는 메서드
	@Override
	public void run() {
		long sum = 0;
		for (long i = 1L; i <= 1000000000; i++) {
			sum += i;
		}
		System.out.println("합계 : " + sum);
	}

}

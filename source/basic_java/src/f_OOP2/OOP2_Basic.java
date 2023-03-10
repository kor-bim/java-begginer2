package f_OOP2;

public class OOP2_Basic {
	public static void main(String[] args) {
		/*
		 * 1. 상속(~은 ~이다) : is a 
		 * - 기존의 클래스를 재사용하여 새로운 클래스를 만든다. 
		 * - 적은양의 코드로 새로운 클래스를 작성할 수 있다. 
		 * - 새로 작성하고 하는 클래스의 뒤에 상속 받고자하는 클래스를 키워드 "extends"와 함계 써주기만 하면 된다.
		 * class Child extends Parent{
		 * 
		 * }
		 * - 상속을 해주는 클래스를 '부모클래스', 상속을 받는 클래스를 '자손 클래스'라고 부른다
		 * 		: 조상클래스 - 상위 클래스, 부모클래스, 기반 클래스
		 * 		: 자손클래스 - 하위 클래스, 자식클래스, 파생된 클래스
		 *  - 상속을 받을 때는  멤버만 상속받는다.
		 *  - 항상 자손클래스 부모클래스보다 같거나 크다.
		 
		 * 2. 포함(~은 ~을 포함하고 있다.) : has a
		 * - 상속 이외에 클래스를 재사용하는 방법
		 * - 클래스의 멤버변수로 다른클래스를 선언하는 방법
	
		 * 3.toString()
		 * - 인스턴스의 정보를 제공할 목적으로 사용
		 * - 참조변수를 출력하면 참조변수가 가르키고 있는 인스턴스의 toString()를 호출한다.
		 * 
		 * TV t = new Tv();
		 * System.out.println(t.toString());
		
		 * 4.단일상속
		 * - 자바에서는 단일상속(두개 이상 불가)만 가능하다
		 * - class TVCR extends Tv,Vcr{ //불가능
		 *   }
		 * - Tv와 Vcr에 동일한 메서드가 존재 한다면 어떤 메서드를 상속받는지 알 수 없다.
		 * - Tv의 메서드 명을 변경한다면 그 동안 사용해온 모든 곳을 수정해주어야 한다.
		 * - 클래스 간의 관계과 명확해진다.
	
		 * 5.Object클래스(모든클래스의 최상위 클래스)
		 * - 다른 클래스를 상속받지 않는 클래스는 Object클래스를 상속 받는다.
		 * 	 class A extends Object{
		 *   }
		 * - 모든 클래스는 Object클래스를 상속받게 되어 있다.
		 * - toString()나 equals()를 사용 할 수 있는것은 Object클래스의 메서드이기 때문이다.
		 
		 * 6.오버라이딩(overriding)
		 * - 조상클래스로부터 상속받은 메서드의 내용을 재정의 하는 것
		 * - 오버라이딩 되기 위한조건 ( 선언부가 동일하면 된다. )
		 * 		: 매소드명이 동일해야한다.
		 * 		: 매개변수의 갯수와 타입이 같아야한다.
		 * 		: 반환타입이 같아야한다.
		 * - 부모클래스로부터 상속받는 자손클래스의
		 * 		: 접근제어자는 부모보다 좁은범위로 설정할 수 없다.
		 * 		: 예외의 갯수는 조상클래스의 메소드 보다 많이 선언할 수 없다.
		 * 제어자 void method() 예외처리{
		 * 
		 * }
		 
		 * 7.super
		 * - 조상클래스의 멤버와 자손클래스의 멤버의 중복 정의되어 있을 때 구분할 목적으로 사용된다.
		 * - 조상의멤버와 자손의 멤버를 구분한다는 점을 제외하고는 this. 동일하다
		
		 * 8.super() - 조상클래스의 생성자
		 * - this()와 마찬가지로 super()도 생성자 호출이다
		 * - this()는 같은 클래스내의 생성자에서 다른 생정자를 호출 할 때 사용한다.
		 * - super() 자손클래스의 생성자 내에서 부모클래스의 생성자를 호출할 때 사용한다. 
		 
		 * 9.제어자
		 * - 변수, 메서드, 그리고 클래스의 선언부에 사용이 된다.
		 * - 접근제어자와 그외 제어자로 나눈다.
		 * - 접근제어자
		 * 		: public, protected, default, private
		 * - 그 외 제어자
		 * 		: static, final, abstract, native, .....
		 * - 일반적으로 접근제어자를 가장 왼쪽에 써준다
		 *   	private static final int a;
		 * - static (클래스의, 공통적인)
		 * 		: 변수, 메서드, 초기화블럭
		 *      : 변수에 사용시
		 *      	1) 모든 인스턴스에서 공통적으로 사용
		 *      	2) 인스턴스를 생성없이 사용할 수 있다.
		 *      	3) 클래스가 method area로드될 때 같이 생성된다.
		 * 			4) 클래스 멤버에서는 인스턴스멤버를 호출할 수 없다.
		 * - final(마지막, 변경될 수 없는)
		 * 		: 변수에 사용시 값을 변경할 수 없는 상수가 된다.
		 * 		: 메서드에 사용시 오버라이드할 수 없는 메서드가 된다.
		 * 		: 클래스에 사용시 상속할 수 없는 클래스가 된다. (부모 클래스 x)
		 * - abstract(추상의, 미완성의)
		 * 		: 메서드와 클래스에만 사용이 가능하다.
		 * 		: 메서드는 선언부와 구현부로 되어있지만 추상에서는 구현부가 없고 선언부만 존재한다.
		 * 		: 추상메서드를 가지고 있다면 해당 클래스는 추상클래스가 되어야 한다.
		 * 		abstract class A{
		 * 				abstract void method();
		 * 		}
		
		 * 10.접근제어자
		 * - public
		 * 		: 접근제한이 없다
		 * - protected
		 * 		: 같은 패키지 + 다른 패키지에 있는 클래스의 자손클래스
		 * 		: 클래스에는 사용불가
		 * - default
		 * 		: 같은 패키지내에서만 가능
		 * - private
		 * 		: 같은 클래스내에서만 사용가능
		 * 		: 클래스에는 사용불가
		
		 * 11.캡슐화
		 * - 접근제어자를 사용하는 이유
		 * 		: 외부로 부터 데이터를 보호하기 위해서
		 * 		: 외부에는 불필요한 부분을 감출수 있다.
		 * DTO 
		 * 		: Data Table Object
		 * 		: DB의 컬럼과 java의 변수를 1:1 매칭
		 * VO  
		 * 		: Variable Object
		 * 		: 필요한것들만 뽑아서 씀
		 
		 * 12.생성자의 접근제어자
		 * - 인스턴스의 생성을 제한 할 수 있다.
		 * - 생성자의 접근제어자를 private으로 할 경우
		 * 		: 외부에서는 생성자에 접근할 수 없으므로 인스턴스를 생성할 수 없다.
		 * 		: 다른 클래스의 조상이 될 수 없다.
		 * 		: 다른 클래스의 조상이 될 수 없으므로 final를 주어야 한다.
		 
		 * 13.다형성(polymorphism)
		 * - 부모타입에 참조변수로 자식타입의 인스턴스를 참조할 수 있다.
		 * - 여러가지 형태를 받을 수 있는 능력
		 
		 * 14.참조변수의 형변환
		 * - 상속관계에서만 가능하다.
		 * - 자식타입->부모타입 : up-casting, 캐스트연산자 생략가능
		 * - 부모타입->자식타입 : down-casting, 캐스트연산자 생략불가
		 
		 * 15.instanceof
		 * - 참조변수가 참조하고 있는 인스턴스의 실제타입을 알아보기 위해 사용한다.
		 * - 연산결과가 true이면 검사한 타입으로 형변환이 가능하다.
		 * - 클래스멤버는 참조변수의 타입에 영향을 받는다.
		 * - 참조변수의 타입에 영향을 받지 않는 것은 인스턴스 매서드 뿐이다.
		  
		 * 16.매개변수의 다형성
		 * - 참조변수의 다형적인 특징은 매개변수에도 적용된다.
		
		 * 17.여러객체배열, Vector
		 * - 배열은 한번 크기를 정하면 변경할 수 없다. 이를 해결하기 위하여 만들어졌다.
		 * - Vector 동적으로 크기가 관리되는 객체배열이다.
		 * 		:Vector 생성자 => 10개의 객체를 저장할 수있는 Vector객체를 만든다.
		 * 		:add() => Vector에 객체를 추가한다.
		 * 		:remove() => Vector에서 객체를 삭제한다.
		 * 		:isEmpty() => Vector가 비어있는지 확인하다.
		 * 		:get(int index) => index번째 객체를 가져온다.
		 * 		:size() => 저장된 객체의 수를 반환한다.
		
		 * 18.추상클래스(abstract)
		 * - 미완성된 클래스
		 *		:미완성된 매서드를 포함하고 있다.
		 * - 추상메서드
		 *		:미완성된 메서드 이다.
		 *		:메서드는 선언부와 구현부로 이루어져 있지만 추상메서드는 구현부가 없다.
		 * - 어떤 기능을 수행할 목적으로 만든 것인지?
		
		 * 19.인터페이스(interface)
		 * - 일종의 추상클래스이지만 멤버변수로 상수와 추상메서드만 가진다.
		 * - 작성방법
		 * 	 interface 인터페이스명{
		 * 		(public static final) 변수타입 변수명 = 값;
		 * 		(public abstract) 반환타입 메서드명(매개변수);
		 *   }
		 * - 모든변수는  public static final 이어야 한다. 생략가능
		 * - 모든 메서드는 public abstract 이어야 한다. 생략가능
		 * - 인터페이스의 상속
		 * 		: 인터페이스-인터페이스 다중 상속 가능
		 * 		: 인터페이스-클래스 상속 불가능, 클래스를 상속 받으면 인터페이스가 아니게 된다.
		 * - 인터페이스의 구현
		 * 		: 자체로는 객체를 생성할 수 없다
		 * 		: 자신이 정의된 추상메서드의 몸통을 만들어 주는 클래스가 존재해야 한다.
		 * 		: 상속 => extends, 구현 => implements
		 * 		: 인터페이스의 일부분만 구현 하였다면 해당 클래스는 추상 클래스가 된다.
		 * 		: ~을 할수 있는(~able), 요즘은 IMember => (구현체 클래스)IMemberImpl 
		 * - 인터페이스의 장점
		 * 		: 개발시간을 단축 시킬수 있다.
		 * 		: 표준화가 가능하다.
		 * 		: 서로 관계가 없는 클래스들에게 관계를 설정해 줄 수 있다.
		 * 		: 독립적인 프로그래밍이 가능하다.
		 * - 인터페이스의 이해
		 * 		: 클래스를 사용하는 쪽(user)과 제공하는 쪽(provier)로 나눈다.
		 * 		: 메서드를 사용하는 쪽에서는 선언부만 알면된다.
		 * 		A-I-B (직접관계에서 => 간접관계로 바꾼다)
		 * 
		 */
	}
}

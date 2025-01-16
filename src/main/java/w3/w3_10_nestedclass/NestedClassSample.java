package w3.w3_10_nestedclass;

public class NestedClassSample {
    public static void main(String[] args) {
        System.out.println("\n[중첩 static 클래스 StaticB 확인]----------------------------------");
        System.out.println("- 내부 멤버 선언\n : (all) 모든 종류의 필드와 메소드 선언 가능");
        System.out.println("- 외부 접근\n : (O) 클래스 A에서 곧바로 접근");
        A.StaticB.accessClass();
        A.StaticB aStaticB = A.getStaticB();
        aStaticB.access();

        System.out.println("\n[중첩 instance 클래스 InstanceC 확인]------------------------------");
        System.out.println("- 내부 멤버 선언\n : (instance only) 인스턴스 필드와 메소드만 선언 가능");
        System.out.println("- 외부 접근\n : (O) 클래스 A의 객체 생성 후, 클래스 A의 객체를 통해 접근");
        System.out.println("클래스 A의 생성자 호출");
        A a = new A();
        A.InstanceC ab = a.getInstanceC();
        ab.access();

        System.out.println("\n[중첩 local 클래스 LocalD 확인]------------------------------------");
        System.out.println("- 내부 멤버 선언\n : (instance only) 인스턴스 필드와 메소드만 선언 가능");
        System.out.println("- 외부 접근\n : (X) 클래스가 선언된 위치(메서드 내부)에서만 접근 가능");
        A.accessLocalD(1);
        System.out.println("--------------------------------------------------------");
    }
}
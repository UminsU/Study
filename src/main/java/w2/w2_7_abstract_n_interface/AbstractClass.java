package w2.w2_7_abstract_n_interface;

abstract public class AbstractClass implements InterfaceSample,InterfaceSample2{
    // 추상 클래스에서는 인터페이스를 받아온 경우에도 추상 메소드를 구현할 필요가 없음
    // 추상클래스는 객체화를 할 수 없다.

    // 동작이 구현되지 않은 메서드를 등록 할 수 있다.
    abstract void abstractMethodInAbsCls();
    // 프로그래머 간 의사소통이나 협업을 위해서
    // API 용도로 작성하는 것이 아니라
    // 개념의 계층화를 위해서 작성한다

    void abstractMethodInAbsCls(int i) {
        System.out.println(
                "객체화는 할 수 없지만 구체화된 클래스에서" +
                        "동작할 내용을 디폴트 메서드로 미리 등록가능"
        );
    };


    public static void main(String[] args) {
        // 아래 동작은 금지됨!
        //AbstractClass myAbs = new AbstractClass();


    }
}

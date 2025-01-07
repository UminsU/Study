package w2.w2_7_abstract_n_interface;

public class ConcreteClass
        extends AbstractClass // 부모 클래스를 상속받으면서
        implements  InterfaceSample, InterfaceSample2 { // 동시에 인터페이스 구현을 수행
    @Override
    void abstractMethodInAbsCls() {

    }

    public static void main(String[] args) {

    }

    @Override
    public void absMethod() {

    }

    @Override
    public void absMethod(int a) {

    }

    @Override
    public void absMethod(int a, int b) {

    }

    @Override
    public void absMethod(int[] arrA) {

    }

    @Override
    public void absMethod2() {

    }
}

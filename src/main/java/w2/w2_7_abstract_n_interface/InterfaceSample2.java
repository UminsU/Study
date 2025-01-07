package w2.w2_7_abstract_n_interface;

public interface InterfaceSample2 {

    abstract void absMethod2();


    default void absMethod2(int a, int b, int c) {
        System.out.println("" +
                "구현 예제를 default 메서드로 전달할 수도 있습니다"
        );
        System.out.println("Inter");
    }
}

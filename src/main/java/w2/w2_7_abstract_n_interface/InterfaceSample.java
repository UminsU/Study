package w2.w2_7_abstract_n_interface;

public interface InterfaceSample {
    // 인터페이스란? 프로그래밍 수행시 미리 익숙한 상호작용을 다루는 단위
    // API (Application Programing Interface)
    // : 프로그래머 간의 애플리케이션 개발 시의 상호작용에 대한 약속

    // 메서드를 abstract 로 선언하고 body 를 구현하는 것은 구현체에 맡긴다
    // 메서드의 시그니처를 등록하는 용도로 사용한다
    abstract void absMethod();
    // 1. ~~한 이름으로
    // 2. ~~한 인풋을 받아서
    // 3. ~~한 리턴값을 제공하는 기능을 만들어주세요

    // 요구사항을 담을 수 있는 단위가 됨
    // 개발 전체 과정에서, Interface 만을 구현해 두고
    // 실제 개발은 여러 사람이 정해진 합의 기반으로 협업할 수 있는 방법, 수단으로 활용 가능

    abstract void absMethod(int a);
    abstract void absMethod(int a, int b);
    abstract void absMethod(int[] arrA);
    // 메서드 시그니처를 정확한 네이밍과, 오버로딩 등의 용도별 요구사항을 담아
    // 실무자, 구현 책임자에게 전달

    default void absMethod(int a, int b, int c) {
        System.out.println("" +
                "구현 예제를 default 메서드로 전달할 수도 있습니다"
        );
    }
}

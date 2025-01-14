package w3.w3_6_oop.LSP.violating;

public class LspSampleMain {
    public static void main(String[] args) {
        Bird albatross = new Albatross();
        Bird ostrich = new Ostrich();
        makeBirdFly(ostrich); // 예외 발생!
    }

    static void makeBirdFly(Bird bird) {
        bird.fly(); // throws 감지 불가능
    }
}

class Bird {
    void fly() {
        // 새가 날아감
        System.out.println("새가 날아갑니다.");
    }
}

class Ostrich extends Bird {
    // 상위 객체에서 정상동작하는 메서드를 예외 범위로 내보냄으로써 extends 라는 키워드를 위반
    //
    void fly() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("타조는 날지 못합니다.");
    }
}

class Albatross extends Bird {
    void fly()  {
        System.out.println("알바트로스가 날아갑니다.");
    }
}
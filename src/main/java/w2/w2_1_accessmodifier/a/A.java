package w2.w2_1_accessmodifier.a;

public class A {
    // Private 접근제어자 메서드
    private static void printPrivateStrA() {
        System.out.println("privateStrA");
    }
    // Default 접근제어자 메서드 (Package Private)
    static void printPackagePrivateStrA() {
        /* package-private */
        System.out.println("packagePrivateStrA");
    }
    // Protected 접근제어자 메서드 (패키지 외부, 상속관계 없는 클래스로부터)
    protected static void printProtectedStrA() {
        System.out.println("protectedStrA");
    }
    // Public 접근제어자 메서드
    public static void printPublicStrA() {
        System.out.println("publicStrA");
    }

    /* 1. private 멤버 접근 가능한 유일한 위치 */
    public static void main(String[] args) {
        A.printPrivateStrA();
        A.printPackagePrivateStrA();
        A.printProtectedStrA();
        A.printPublicStrA();
    }
}
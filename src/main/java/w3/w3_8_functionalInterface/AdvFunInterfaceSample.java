package w3.w3_8_functionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class AdvFunInterfaceSample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Jane", "Doe");
        // 각 요소를 출력하는 람다 표현식
        Consumer<String> myPrinter = // Consumer 함수형 인터페이스는 Java 에서 제공하는 단일 파라미터 기본형
                name -> System.out.println(name); // 맨 앞 괄호는 인풋 파라미터가 하나일 때 생략가능
        // 함수형 인터페이스는 객체화 했을 때,
        // 동작이지만 파라미터로 할당하며 다른 함수 스코프에서 스택을 쌓도록 전달할 수 있다.
        names.forEach(myPrinter);

        // 정적 메서드를 참조하는 람다 표현식
        MyMathIntBinaryOperation multiplication =
                (a,b) -> Math.multiplyExact(a,b); // 람다 표현식을 쓸 때, 코드를 재사용할 수 있다
                                                         // 인라인 정의를  매번 하지 않고, 간결한 코드 작성 가능
        System.out.println(multiplication.operate(1, 2)); // Alias 특정 기존 동작에 대해서 별칭을 부여할 수 있다

        // 다중 행 인라인 로직 구현, 제어문 등등 모든 자바 구문 동일하게 사용 가능 : 예외를 던지는 람다 표현식
        MyMathIntBinaryOperation division = (a, b) -> {
            if (b == 0) {
                throw new ArithmeticException("Cannot divide by zero");
            }
            return a / b;
        };
        System.out.println(division.operate(1,2));

        // 함수형 인터페이스가 프로그램에 적용됨으로써 구문은 동일하나,
        // 기본 "함수"라는 성격과는 조금 다르게 간결화된 형태가 존재함 : Runnable
        Runnable myRunnable = () -> System.out.println("Hello");
    }
}

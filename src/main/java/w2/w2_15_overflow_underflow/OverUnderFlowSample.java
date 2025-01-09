package w2.w2_15_overflow_underflow;

public class OverUnderFlowSample {
    public static void main(String[] args) {
        // 오버플로우 기본 예제
        int intMax = Integer.MAX_VALUE;
        int intOverflow1 = intMax + 1;
        System.out.printf("\nintMax = %d \nintOverflow = %d\n", intMax,intOverflow1);

        // 아래 예제는 언더플로우가 아닙니다
        int intMin = Integer.MIN_VALUE;
        int intOverflow2 = intMin - 1 ;
        System.out.printf("\nintMin = %d \nintOverflow2 = %d\n", intMin,intOverflow2);

        // 언더플로우 기본 예제
        float smallValue = 1.4e-45f; // float의 최소 양수 값
        float result = smallValue / 10; // 1.4e-46, 표현 불가능한 값

        System.out.println("\nOriginal value: " + smallValue);
        System.out.println("After division: " + result); // 0.0 출력 (언더플로우)

        float a = 0.1f;
        float b = 0.2f;
        // 부동 소수점 연산 시 정밀도가 항상 표현을 원하는 자릿수 만큼 지원되지 않음
        System.out.printf("\na + b = %6f" + (a + b)); // 출력 (언더플로우)
        // 6자리 이상으로 출력 시 정밀도 오차 확인 가능
        // 0.300000 (현재 출력)
        // 0.300000000402013 (실제 저장된 값)
        // 부동 소수점은 오차가 거의 항상 발생하고 있다고 보면 정확함

        // 언더플로우 방지 예제
        double noLossResult = (double)( smallValue / 10 ); // 1.4-46, long
        System.out.printf("\nnoLossResult = %f", noLossResult);

    }
}

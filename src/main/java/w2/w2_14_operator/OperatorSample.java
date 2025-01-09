package w2.w2_14_operator;

public class OperatorSample {
    public static void main(String[] args) {
        int volume = 10;
        volume++;  // 문이자 식
        System.out.println(volume);

        boolean powerOn = false;
        // !powerOn;  // 문으로 기능하지 못하고, 식만으로 작용
        System.out.println(!powerOn);
        // 문(Statement), 식(Expression),
        // -> 식은 단일한 데이터 값을 제공함

        int valueLoss = (int) Long.MAX_VALUE;
        System.out.println(valueLoss);
        long valueKeep = (long) Integer.MIN_VALUE;
        System.out.println(valueKeep);

        byte original = 0b0000011;  // 십진수 3
        System.out.println(toBinaryString(original));
        byte flipped = (byte) ~original;
        System.out.println(toBinaryString(flipped));

        short a = 10;
        int b = 100;
        System.out.println(a+b);
        short c = (short) (a + b);
        // 작다 크다의 기준 : 특정 데이터 타입으로 표현 가능한 값의 범위

        float d = 1000.01f;
        int e = b + (int) d;

        // 비교 연산자
        // 숫자 피연산자를 받아 boolean 값 도출
        int hotDegree = 30;
        int nowTemperature = 32;
        boolean isHot = nowTemperature > hotDegree;
        System.out.println(isHot);

        // 논리연산과 Bool 대수
        boolean result = true & false ; // false
        boolean resultSum = true | false ; // true

        boolean suppress  = false; // 프로그램 출력을 기본 조건과 무관하게 mute 시키는 옵션

        // 프로그램 출력을 기본 조건과 무관하게 강제 수행 시키는 옵션
        boolean forcePrint = true;
        if (
            // 0 & anything = 항상 false
                forcePrint & (nowTemperature > hotDegree)
            // forcePrint & reportCurrentTemperature()
            // => 단일 연산자를 사용하는 것이 적절
        ) {
            // 항상 false 임에도 앞과 뒤가 모두 참이어야 수행
            // & 연산자로는 뒤에 있는 연산을 건너 뛸 수 없음
            System.out.println("현재 온도에 대한 판단/리포팅을 수행합니다");
        }
        if (
            // 0 && anything = 항상 false 이므로 뒷부분은 수행 안합
                forcePrint && (nowTemperature > hotDegree)
            // forcePrint && reportCurrentTemperature()
            // => 숏컷 연산자가 쓰이는 경우 리포트 자체가 수행 안됨
        ) {
            // 아래 라인은 후속 명시된 연산 없이 실행됨
            System.out.println("현재 온도 판단/리포팅이 수행되지 않습니다");
        }

        // 대입 연산자 및 응용
        int aa = 10;
        aa += 1 ; // aa = aa + 1 을 하나로 축약 가능
        // 기존 값의 변경사항
        System.out.println(aa);

        // 3항 연산자
        // (조건식 ? 참연산식1 : 거짓연산식2)
        // 기존의 조건문 ( 큰 값을 출력 )
        int bbb = 1000;
        int ssss = 1;
        if (bbb > ssss) {
            System.out.println(bbb);
        } else {
            System.out.println(ssss);
        }
        // 최대 값과 같은 단순한 조건 판단 시 조건문을 축약
        int max = (bbb>ssss)? bbb:ssss;
        System.out.println(max);
    }

    // byte 값을 8비트 2진수 문자열로 변환
    private static String toBinaryString(byte value) {
        return String.format("%8s", Integer.toBinaryString(value & 0xFF)).replace(' ', '0');
    }
}

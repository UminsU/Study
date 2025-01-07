package w2.w2_10_enum;

public class SimpleEnumExample {
    public static void main(String[] args) {
        SimpleEnumDay today = SimpleEnumDay.MONDAY;

        // Enum 값 출력
        System.out.println("Today is: " + today);

        // Enum 객체 비교
        if (today == SimpleEnumDay.MONDAY) {  // 어떤 방식으로 사용하던지 객체값이 동일
            System.out.println("Start of the work week!");
        }

        // 모든 Enum 값 순회
        for (SimpleEnumDay day : SimpleEnumDay.values()) {
            System.out.println(day);
        }
    }
}

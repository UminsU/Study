package w2.w2_10_enum;

public class ConstructorEnumExample {
    public static void main(String[] args) {
        // Enum 열거형 객체는 생성자 호출 필요 없이
        // Static 변수 조회하는 형태로 불러올 수 있음
        // 메모리 사용이 가장 최적화 된 형태로 unique 한 객체 사용 가능
        //   -> Singleton 패턴의 가장 콤팩트한 적용
        ConstructorEnumDay today = ConstructorEnumDay.FRIDAY;

        // Enum 값과 필드 출력
        System.out.println("Today is: " + today);
        System.out.println("Day type: " + today.getType());

        // 모든 Enum 값과 필드 순회
        for (ConstructorEnumDay day : ConstructorEnumDay.values()) {
            System.out.println(day + " is a " + day.getType());
            day.printLiteral();
        }
    }
}
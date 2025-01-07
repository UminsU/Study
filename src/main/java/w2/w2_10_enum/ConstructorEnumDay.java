package w2.w2_10_enum;

public enum ConstructorEnumDay {
    MONDAY("Weekday", "monday"),
    TUESDAY("Weekday", "tuesday"),
    WEDNESDAY("Weekday", "wednesday"),
    THURSDAY("Weekday", "thursday"),
    FRIDAY("Weekday", "friday"),
    SATURDAY("Weekend","saturday"),
    SUNDAY("Weekend", "sunday");

    private final String type;
    private final String literal;

    // 생성자
    ConstructorEnumDay(String type , String literal) {
        this.type = type;
        this.literal = literal;
    }

    // Getter 메서드
    public String getType() {
        return type;
    }

    public void printLiteral() {
        System.out.println(literal);
    }
}

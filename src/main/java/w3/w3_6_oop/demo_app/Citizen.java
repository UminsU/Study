package w3.w3_6_oop.demo_app;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
abstract class Citizen {
    private String name; // 이름
    private int age; // 나이
    private int gender; // 성별, 남자 : 1,3 / 여자 : 2, 4
    private Nation nationality; // 국적

    public abstract void travel(Nation tgNation);
    public abstract void emigration(Nation tgNation);
}
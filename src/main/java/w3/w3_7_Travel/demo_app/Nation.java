package w3.w3_7_Travel.demo_app;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
abstract class Nation {
    private String name; // 국가명
    private String politicalSystem; // 정치체제
    private String language; // 언어
    private int population; // 인구수
    private String capital; // 수도
    private String currency; // 화폐

    // AllArgsConstructor

    public abstract boolean screenImmigration(Citizen citizen);
}
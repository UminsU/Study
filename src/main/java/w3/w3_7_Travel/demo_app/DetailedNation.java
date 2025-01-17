package w3.w3_7_Travel.demo_app;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
class DetailedNation extends Nation {
    private boolean isAtWar; // 전시 상태 여부
    private String creditRating; // 국가 신용 등급

    // 부모 클래스의 생성자를 자식 클래스에서 super로 초기화하는 것, 부모클래스에서 직접 초기화하는것 ??
    public DetailedNation(String name, String politicalSystem, String language, int population, String capital, String currency, boolean isAtWar, String creditRating) {
        super(name, politicalSystem, language, population, capital, currency);
        this.isAtWar = isAtWar;
        this.creditRating = creditRating;
    }

    @Override
    public boolean screenImmigration(Citizen citizen) {
        if (isAtWar) {
            System.out.println("전시 중인 국가이므로 입국을 허가하지 않습니다.");
            return false;
        }

        if ("Low".equals(creditRating)) {
            System.out.println("국가 신용 등급이 낮으므로 입국을 허가하지 않습니다.");
            return false;
        }

        if (citizen.getNationality() == null) {
            System.out.println("무국적자이므로 입국을 허가하지 않습니다.");
            return false;
        }
        return true;
    }
}

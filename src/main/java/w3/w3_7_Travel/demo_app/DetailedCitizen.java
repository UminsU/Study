package w3.w3_7_Travel.demo_app;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
class DetailedCitizen extends Citizen {
    private int passportNumber; // 여권 번호
    private boolean militaryServiceStatus; // 병역 여부
    private boolean hasCriminalRecord; // 범죄 기록 여부

    public DetailedCitizen(String name, int age, int gender, DetailedNation nationality, int passportNumber, boolean militaryServiceStatus, boolean hasCriminalRecord) {
        super(name, age, gender, nationality);
        this.passportNumber = passportNumber;
        this.militaryServiceStatus = militaryServiceStatus;
        this.hasCriminalRecord = hasCriminalRecord;
    }

    @Override
    public void travel(Nation tgNation) {
        boolean screenPassed = tgNation.screenImmigration(this);
        if (screenPassed) {
            System.out.println(getName() + ",  " + tgNation.getName() + " 입국이 허가되었습니다.");
        } else {
            System.out.println(getName() + ", " + tgNation.getName() + " 입국이 허가되지 않았씁니다.");
        }
    }

    @Override
    public void emigration(Nation tgNation) {
        System.out.println(getName() + ", " + tgNation.getName() + "에 입국하였습니다.");
    }

    @Override
    public String toString() {
        return super.toString() + " (여권번호: " + passportNumber + ", 병역 여부: " + militaryServiceStatus + ", 범죄경력 여부 : " + hasCriminalRecord + ")";
    }
}
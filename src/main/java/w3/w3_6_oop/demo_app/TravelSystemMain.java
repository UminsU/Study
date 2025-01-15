package w3.w3_6_oop.demo_app;

import java.util.*;

public class TravelSystemMain {

    private static List<DetailedNation> nations = new ArrayList<>();
    private static List<DetailedCitizen> citizens = new ArrayList<>();

    static {
        // 국가
        nations.add(new DetailedNation("ROK", "Republic", "한글", 50000000, "Seoul", "won", true, "High"));
        nations.add(new DetailedNation("USA", "Republic", "English", 100000000, "D.c", "dollor", false, "Medium"));
        nations.add(new DetailedNation("China", "Confederation", "French", 1300000000, "Beijing", "yuan", true, "Low"));

        // 시민
        citizens.add(new DetailedCitizen("Mings", 30, 1, nations.get(0), 123123, true, false));
        citizens.add(new DetailedCitizen("Teari", 25, 2, nations.get(1), 456456, false, false));
        citizens.add(new DetailedCitizen("Gyu", 40, 3, null, 789789, false, true));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("반갑습니다.");

        System.out.print("이름을 입력하세요 : ");
        String name = scanner.nextLine();

        System.out.print("국적을 입력하세요 : ");
        String nationality = scanner.nextLine();

        // 시민 검색
        DetailedCitizen citizen = findCitizenByNameAndNationality(name, nationality);

        if (citizen == null) {
            System.out.println("시민 정보를 찾을 수 없습니다.");
            return;
        }

        System.out.println("입국 가능 국가 :");
        for (int i = 0; i < nations.size(); i++) {
            System.out.println((i + 1) + ". " + nations.get(i).getName());
        }

        System.out.print("목적지 국가 (1-" + nations.size() + "): ");
        int nationChoice = scanner.nextInt();

        if (nationChoice < 1 || nationChoice > nations.size()) {
            System.out.println("잘못입력하셨습니다.");
            return;
        }

        DetailedNation targetNation = nations.get(nationChoice - 1);

        System.out.println("처리중입니다...");
        citizen.travel(targetNation); // 여행 처리
    }

    private static DetailedCitizen findCitizenByNameAndNationality(String name, String nationality) {
        for (DetailedCitizen citizen : citizens) {
            // 시민 이름과 국적이 일치하는지 확인
            if (citizen.getName() != null && citizen.getName().equalsIgnoreCase(name)) {
                if (citizen.getNationality() != null && citizen.getNationality().getName().equalsIgnoreCase(nationality)) {
                    return citizen;
                }
            }
        }
        return null;
    }
}

package w2.w2_12_simulator;

import java.util.Scanner;

// 전체적인 흐름을 갖고 TV를 조작하는 메인 클래스
// 1. TV, RemoteControl 객체 생성
// 2. printCommandGuide 메서드 호출 -> 초기화면, 잘못된 값 입력 시 수행
// 3. 무한루프(while(true)), 종료 입력 시 까지 수행
// -> 실제 리모컨은 자체 on/off 기능을 갖지 않고 TV의 on/off 기능만을 수행. 즉 리모컨 자체는 항상 on 상태
// 4. 사용자 입력에 따른 호출, 처리
public class SimulatorMain {
    public static void main(String[] args) {
        TV tv = new TV();
        RemoteControl remote = new RemoteControl(tv);

        printCommandGuide();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String userInput = scanner.next();
            Option option = Option.fromString(userInput);

            if (option == null) {
                System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
                printCommandGuide();
            } else if (option == Option.종료) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else {
                remote.setStatus(option);
            }
        }
    }

    private static void printCommandGuide() {
        System.out.println(
                "###################\n" +
                        "     안내 가이드\n" +
                        "  - 채널: 채널 변경\n" +
                        "  - 볼륨: 볼륨 조절\n" +
                        "  - 밝기: 화면 밝기 변경\n" +
                        "  - 대비: 화면 대비 변경\n" +
                        "  - 종료: 프로그램 종료\n" +
                        "###################\n" +
                        "명령어를 입력하세요: "
        );
    }
}


package w2.w2_13_inclass_adv_simulator;

import java.util.Scanner;

public class SimulatorAdvMain {
    public static void main(String[] args) {
        // 1. 시뮬레이션 필요 객체 생성
        // 1-1. 제어 주체 및 대상 디바이스 객체
        SatelliteTV mySatelliteTV = new SatelliteTV(
            11, 10, "Sky Life"
        );
        InternetTV myInternetTV = new InternetTV(
            150, 10, "KT Giga Internet"
        );
        Aircon myAircon = new Aircon(5, 20);
        MultiDeviceRC myMultiRC = new MultiDeviceRC();
        // 1-2. 시뮬레이션 진행용 객체
        Scanner myScanner = new Scanner(System.in);

        while (true) {
            // 2. 사용자 input 안내 및 수신
            // 2-1. 인풋 안내
            System.out.println("""
                ============ 디바이스 선택 안내 ============
                위성 TV: stv | 인터넷 TV: itv | 에어컨: air
                ============= 리모콘 버튼 안내 =============
                TV 버튼: pow, chUp, chDn, volUp, volDn
                AC 버튼: pow, windUp, windDn, tmpUp, tmpDn
                ============== 시뮬레이션 종료 =============
                "exit" 입력
                ========================================
            """);
            // 2-2. 인풋 수신
            System.out.println("리모콘 버튼을 누르세요:");
            String consoleInput = myScanner.nextLine();

            // 3. 종료 조건 판단 (exit)
            if (consoleInput.equals("exit")) {
                System.out.println("시뮬레이션을 종료합니다.");
                return;
            }

            // 4. 리모컨 입력에 대한 동작 수행
            // 4-1. 대상 디바이스 판단 (입력값 파싱)
            // ex) stv_pow, ~~~, itv_volDn,
            //     air_windUp, ~~~, air_tmpDn
            // TODO: 아래 구문에서는 예외가 발생할 수 있으므로 처리 구문 추가 필요
            String[] cmdSplit = consoleInput.split("_");
            if (cmdSplit.length != 2) {
                System.out.println("커맨드 입력이 유효하지 않습니다: " + consoleInput);
                continue;
            }
            String devChoice = cmdSplit[0];
            String actionCmd = cmdSplit[1];
            //  => 아무거나 입력 시 파싱 실패
            // =======================================
            // <예외 처리 전략 3가지 연습활동>
            // 1) 메인 함수에 직접 작성된 디바이스 판단 구문을 별도 메서드로 분리
            // 2) 분리된 메서드에서 예외 전환 수행 -> 예외 회피
            // 3) main 메서드에서 분리된 디바이스 판단 메서드를 호출하면서 전환된 예외를 복구
            // =======================================
            // 4-2. 해당 디바이스 호출
            if (devChoice.equals("stv")) {
                MultiDeviceRC.TVButton btnCmd = getBtnCmd(actionCmd);
                if (btnCmd != null) {
                    // TV enum 버튼 전달
                    myMultiRC.btnPress(mySatelliteTV, btnCmd);
                }
            } else if (devChoice.equals("itv")) {
                MultiDeviceRC.TVButton btnCmd = getBtnCmd(actionCmd);
                // TV enum 버튼 전달
                if (btnCmd != null) {
                    myMultiRC.btnPress(myInternetTV, btnCmd);
                }
            } else if (devChoice.equals("air")) {
                myMultiRC.btnPress(
                    myAircon,
                    // TODO: 제네릭을 적용해서 타입 파라미터를 핸들링
                    MultiDeviceRC.ACButton.fromCommand(actionCmd) // AC enum 버튼 전달
                );  // 파라미터로 메서드 호출이 아니라 메서드 객체 자체가 전달되는 경우가 있음
                    // (함수형 인터페이스) 후속 주제로 다룸
            } else {
                System.out.println(
                    "디바이스 선택이 잘못되었습니다:" + consoleInput
                );
            }
            // 5. 켜져있는 디바이스 전체 실행
            mySatelliteTV.showVideo();
            myInternetTV.showVideo();
            myAircon.blowWind();

            // 6. (1초 슬립) 필요 시
            try {
                Thread.sleep(1_000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static MultiDeviceRC.TVButton getBtnCmd(String actionCmd) {
        try {
            return MultiDeviceRC.TVButton.fromCommand(actionCmd);
        } catch (IllegalArgumentException e) {
            // 에러 발생 또는 메시지 출력을 아무 변환이나 출력 없이 Silent 시키는 경우
            // Application 내부에 잠재적인 디버깅 저해 요인(=유지보수성 감소)을 심게 됨
            System.err.println(e.getMessage());  // 콘솔 접근 순서 다를 수 있음
            return null;
        }
    }

    // 제네릭에서 아래와 같은 오버로딩 불가 케이스 다룰 예정
    // 파라미터 타입이 달라야만 메서드 오버로드 가능
//    private static MultiDeviceRC.ACButton getBtnCmd(String actionCmd) {
//        try {
//            return MultiDeviceRC.ACButton.fromCommand(actionCmd);
//        } catch (IllegalArgumentException e) {
//            // 에러 발생 또는 메시지 출력을 아무 변환이나 출력 없이 Silent 시키는 경우
//            // Application 내부에 잠재적인 디버깅 저해 요인(=유지보수성 감소)을 심게 됨
//            System.err.println(e.getMessage());  // 콘솔 접근 순서 다를 수 있음
//            return null;
//        }
//    }
}
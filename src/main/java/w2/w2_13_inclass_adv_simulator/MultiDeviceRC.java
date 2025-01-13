package w2.w2_13_inclass_adv_simulator;

public class MultiDeviceRC {
    public enum TVButton {
        POWER("pow"),  // "POWER"
        CH_UP("chUp"),
        CH_DN("chDn"),
        VOL_UP("volUp"),
        VOL_DN("volDn");

        private final String command;

        TVButton(String command) {
            this.command = command;
        }

        // fromXxx : 변환 메서드 (ex - fromInternetTV)
        // 여기에서는 String command -> TVButton
        public static TVButton fromCommand(String command) {
            // 외부에서 받아온 문자열 cmd 입력을 enum 객체로 변환
            for (TVButton tvButton: TVButton.values()) {
                if (tvButton.command.equals(command)) {
                    return tvButton;
                }
            }
            // 수신 문자열이 enum 내부에 존재하지 않는 경우 예외를 발생시킴
            throw new IllegalArgumentException(
                "Input command is invalid: " + command
            );
        }
    }

    // 에어콘 버튼이 따로 필요 -> enum 추가
    public enum ACButton {
        POWER("pow"),
        WIND_UP("windUp"),
        WIND_DN("windDn"),
        TMP_UP("tmpUp"),
        TMP_DN("tmpDn");

        private final String command;

        ACButton(String command) {
            this.command = command;
        }

        // fromXxx : 변환 메서드 (ex - fromInternetTV)
        // 여기에서는 String command -> TVButton
        public static ACButton fromCommand(String command) {
            // 외부에서 받아온 문자열 cmd 입력을 enum 객체로 변환
            for (ACButton tvButton: ACButton.values()) {
                if (tvButton.command.equals(command)) {
                    return tvButton;
                }
            }
            // return null;
            // 수신 문자열이 enum 내부에 존재하지 않는 경우 예외를 발생시킴
            throw new IllegalArgumentException(
                "Input command is invalid: " + command
            );
        }
    }

    // 메서드 오버로딩 방식이 가능
    // public void btnPress(InternetTV tgTV, String cmd) {}
    // public void btnPress(SatelliteTV tgTV, String cmd) {}
    // 하지만 인터페이스 다형성을 사용한 처리가 더 좋다
    // 공통 인터페이스가 있다면 메서드 하나에 인터페이스 상위 객체로 사용 가능
    public void btnPress(
        IRemoteControllableTV tgTV,  // 1) 어떤 타입의 TV 이든지 메서드에 전달 가능
        // 2) 구체적인 객체에 대해서 동작 호출 가능
        // String cmd
        TVButton btnCmd
    ) {
        switch (btnCmd) {
            case POWER:
                tgTV.powerToggle();
                break;
            case CH_UP:
                tgTV.channelUp();
                break;
            case CH_DN:
                tgTV.channelDn();
                break;
            case VOL_UP:
                tgTV.volumeUp();
                break;
            case VOL_DN:
                tgTV.volumeDn();
                break;
            default:
                System.out.println("기능 미구현 버튼입니다.");
                break;
        }
    }

    // 에어컨 조작을 위한 btnPress 메서드 오버로드
    public void btnPress(
        IRemoteControllableAC tgAC,  // 변수명은 2개 째부터 일관성 고려
        ACButton btnCmd  // 일관성 추구하는 경우, 아예 똑같아도 상관 없음
    ) {
        switch (btnCmd) {
            case POWER:
                tgAC.powerToggle();
                break;
            case WIND_UP:
                tgAC.windUp();
                break;
            case WIND_DN:
                tgAC.windDn();
                break;
            case TMP_UP:
                tgAC.tgTmpUp();
                break;
            case TMP_DN:
                tgAC.tgTmpDn();
                break;
            default:
                System.out.println("기능 미구현 버튼입니다.");
                break;
        }
    }
}

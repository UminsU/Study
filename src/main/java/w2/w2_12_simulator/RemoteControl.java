package w2.w2_12_simulator;

// 컨트롤러 역할
// 직접 TV를 제어하는거보다 좀 더 깔끔하게?
import java.util.Scanner;

class RemoteControl implements ITelevisionController {
    private TV tv;

    public RemoteControl(TV tv) {
        this.tv = tv;
    }

    @Override
    public void setStatus(Option status) {
        if (status == Option.종료) {
            System.out.println(getExitMessage());
            return;
        }

        // 사용자 입력 처리
        System.out.println(getActionMessage(status));  // 메시지를 반환하는 메서드 호출
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.next();

        // TV에 전달
        tv.updateStatus(userInput);
    }

    // 각 옵션에 맞는 메시지를 반환하는 메서드
    private String getActionMessage(Option option) {
        switch (option) {
            case 채널:
                return "채널을 변경합니다.\n원하는 채널을 입력해주세요.";
            case 볼륨:
                return "볼륨을 조절합니다.\n볼륨을 입력해주세요.";
            case 밝기:
                return "밝기를 조절합니다.\n밝기 단계를 입력해주세요.";
            case 대비:
                return "대비를 조절합니다.\n대비 정도를 입력해주세요.";
            case 종료:
                return "TV를 종료합니다.";
            default:
                return "잘못된 입력입니다.";
        }
    }

    @Override
    public String getChannelMessage() {
        return "채널을 변경합니다.\n원하는 채널을 입력해주세요.";
    }

    @Override
    public String getVolumeMessage() {
        return "볼륨을 조절합니다.\n볼륨을 입력해주세요.";
    }

    @Override
    public String getBrightnessMessage() {
        return "밝기를 조절합니다.\n밝기 단계를 입력해주세요.";
    }

    @Override
    public String getContrastMessage() {
        return "대비를 조절합니다.\n대비 정도를 입력해주세요.";
    }

    @Override
    public String getExitMessage() {
        return "TV를 종료합니다.";
    }
}


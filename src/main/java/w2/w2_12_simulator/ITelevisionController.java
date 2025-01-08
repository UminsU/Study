package w2.w2_12_simulator;

// ITelevisionController를 구현하는 클래스는 setStatus 메서드를 반드시 구현해야함 -> 공통 메서드이기 때문
interface ITelevisionController {
    void setStatus(Option status);  // 매개변수로 option 타입을 받아 TV의 옵션을 변경
    String getChannelMessage();      // 채널 메시지
    String getVolumeMessage();       // 볼륨 메시지
    String getBrightnessMessage();   // 밝기 메시지
    String getContrastMessage();     // 대비 메시지
    String getExitMessage();         // 종료 메시지
}
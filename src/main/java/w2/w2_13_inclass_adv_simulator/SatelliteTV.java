package w2.w2_13_inclass_adv_simulator;

public class SatelliteTV extends AbstractTV
    // implements ISatelliteTVRC // 하위 클래스별 인터페이스 필요 시 생성
{
    private String satelliteType;

    public SatelliteTV(
        int channel, int volume,
        String satelliteType
    ) {
        super(channel, volume);               // 부모 객체가 가져야 할 변수 초기화
        this.satelliteType = satelliteType;   // 자식 객체에서 확장된 변수 초기화
    }

    public String getSatelliteType() {
        return satelliteType;
    }

    public void setSatelliteType(String satelliteType) {
        this.satelliteType = satelliteType;
    }

    private int findSignal() {
        // 10 % 확률로 방송 신호가 없음
        // 0 ~ 100 사이의 값이 나오는 신호 강도 리턴
        return (int)(Math.random() * 100);
    }

    @Override
    public void showVideo() {
        if (!isPowerOn()) return;
        if (findSignal() < 10) {
            System.out.println(
                "채널 " + this.getChannel() + " 위성 신호가 약합니다."
            );
            return;
        }
        System.out.println(
            "정상 위성 방송 송출 : 채널 no." + this.getChannel()
        );
    }
}

package w2.w2_13_inclass_adv_simulator;

public class InternetTV extends AbstractTV
    // implements IInternetTVRC // 하위 클래스별 인터페이스 필요 시 생성
{
    private String internetServiceProvider;

    public InternetTV(
        int channel, int volume,
        String internetServiceProvider
    ) {
        super(channel, volume);
        this.internetServiceProvider = internetServiceProvider;
    }

    public String getInternetServiceProvider() {
        return internetServiceProvider;
    }

    public void setInternetServiceProvider(String internetServiceProvider) {
        this.internetServiceProvider = internetServiceProvider;
    }

    private boolean checkConnection() {
        return true;
    }

    @Override
    public void showVideo() {
        if (!isPowerOn()) return;
        if (!checkConnection()) {
            System.out.println(
                "인터넷 연결이 끊어졌습니다. 방송 송출이 불가능합니다."
            );
        }
        System.out.println(
            this.getInternetServiceProvider() + "를 통한 인터넷 방송 송출: "
                + "채널 no." + this.getChannel()
        );
    }
}

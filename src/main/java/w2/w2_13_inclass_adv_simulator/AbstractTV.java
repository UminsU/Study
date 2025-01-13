package w2.w2_13_inclass_adv_simulator;

public abstract class AbstractTV implements IRemoteControllableTV {
    private boolean powerOn;
    private int channel;
    private int volume;

    public AbstractTV(int channel, int volume) {
        this.powerOn = false;
        this.channel = channel;
        this.volume = volume;
    }

    // Encapsulation 에 해당하는 부분 getter 선언
    public boolean isPowerOn() {
        return powerOn;
    }

    public int getChannel() {
        return channel;
    }

    public int getVolume() {
        return volume;
    }
    // setter 는 특정 메서드로 커버하는 요구사항이므로 생성 X

    @Override
    public void powerToggle() {
        this.powerOn = !this.isPowerOn();  // setter 를 클래스 내부에서는 반드시 사용할 필요는 없다
        if (this.powerOn) {
            // 멀티 스레드 구조로 시뮬레이션 시에는 자식 스레드를 분리해서 showVideo() 실행
            System.out.println("TV Power On!");
        } else {
            // 멀티 스레드 구조에서는 분리된 자식 스레드를 종료하는 방식으로 변경
            System.out.println("TV Power Off!");
        }
    }

    @Override
    public void channelUp() {
        this.channel++;
        System.out.println("Channel up to " + this.channel);
    }

    @Override
    public void channelDn() {
        this.channel--;
        System.out.println("Channel down to " + this.channel);
    }

    @Override
    public void volumeUp() {
        this.volume++;
        System.out.println("Volume up to " + this.volume);
    }

    @Override
    public void volumeDn() {
        this.volume--;
        System.out.println("Volume down to " + this.volume);
    }

//    @Override
//    public void showVideo() {
//        기본 동작 구현 필요 없음
//    }
}

package w2.w2_13_inclass_adv_simulator;

public class Aircon implements IRemoteControllableAC {
    private boolean powerOn;
    private int windStrength;
    // 개념적으로는 적절한 이름이어도, 문제가 되는 변수명
    // private int tgTemperature;  // 섭씨인지 화씨인지 표시 필요
    private int tgTmpCelsius;

    public Aircon(int windStrength, int tgTmpCelsius) {
        // this.powerOn = false;
        this.windStrength = windStrength;
        this.tgTmpCelsius = tgTmpCelsius;
    }

    @Override
    public void powerToggle() {
        this.powerOn = !this.isPowerOn();  // setter 를 클래스 내부에서는 반드시 사용할 필요는 없다
        if (this.powerOn) {
            // 멀티 스레드 구조로 시뮬레이션 시에는 자식 스레드를 분리해서 showVideo() 실행
            System.out.println("AC Power On!");
        } else {
            // 멀티 스레드 구조에서는 분리된 자식 스레드를 종료하는 방식으로 변경
            System.out.println("AC Power Off!");
        }
    }

    public boolean isPowerOn() {
        return powerOn;
    }

    public int getWindStrength() {
        return windStrength;
    }

    public int getTgTmpCelsius() {
        return tgTmpCelsius;
    }

    @Override
    public void windUp() {
        this.windStrength++;
        System.out.println("Wind Strength up to " + this.windStrength);
    }

    @Override
    public void windDn() {
        this.windStrength--;
        System.out.println("Wind Strength down to " + this.windStrength);
    }

    @Override
    public void tgTmpUp() {
        this.tgTmpCelsius++;
        System.out.println("Target Temp up to " + this.tgTmpCelsius + " Celsius");
    }

    @Override
    public void tgTmpDn() {
        this.tgTmpCelsius--;
        System.out.println("Target Temp down to " + this.tgTmpCelsius + " Celsius");
    }

    @Override
    public void blowWind() {
        System.out.println(
            "에어컨에서 바람이 송출됩니다\n" +
             "바람세기: " + this.getWindStrength() + "\n" +
             "희망온도: " + this.getTgTmpCelsius() + "`C\n"
        );
    }
}

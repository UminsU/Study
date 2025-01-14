package w3.w3_6_oop.DIP.violating;

public class Switch {
    private RedLight light; // 전구를 스위치 안에 집어넣었다
    
    public Switch() {
        this.light = new RedLight();
    }
    
    public void on() {
        if (light != null) {
            light.on();
        }
    }
}

class RedLight {
    public void on() {
        System.out.println("Red Light turned on");
    }
}
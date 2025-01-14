package w3.w3_6_oop;

import lombok.Data;

@Data
public class LombokUsageSample {
    private int age = 20;
    private boolean employed = false;

    /* lombok 을 사용하면 아래와 같은 메서드를 수동 생성할 필요가 없어짐
    public void setEmployed(boolean employed) {
        this.employed = employed;
    }

    public boolean isEmployed() {
        return employed;
    }
    */

    public static void main(String[] args) {
        LombokUsageSample sul = new LombokUsageSample();
        System.out.println(sul.getAge());
        sul.setAge(30);
        System.out.println(sul.getAge());

        System.out.println(sul.isEmployed());
        sul.setEmployed(true);
        System.out.println(sul.isEmployed());
    }
}
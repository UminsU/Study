package w3.w3_9_annoymousclass;

public class AnnoymClassSample {
    public static void main(String[] args) {
        Duck duck = new Duck() {
            @Override
            public void quack(){
                System.out.println("QQQQQQUUUUAAAACCCKKK!!!!!!!!!!!!!!");
            }
        };
        duck.quack();
    }
}

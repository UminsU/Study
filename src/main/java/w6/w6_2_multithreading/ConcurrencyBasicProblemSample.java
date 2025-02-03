package w6.w6_2_multithreading;

public class ConcurrencyBasicProblemSample {
    private int passCount = 0;

    public static void main(String[] args) {
        // 하나의 객체 생성
        ConcurrencyBasicProblemSample example = new ConcurrencyBasicProblemSample();
        // 하나의 객체를 참조하는
        // 20개의 스레드를 생성해 실행
        for (int i = 0; i < 20; i++) {
            Thread thread = new Thread(() -> example.process());
            thread.start();
        }
    }
    // 각 스레드는 heap 영역에 공유된 passCount 값을 참조
    private void process() {
        // 각 스레드가 시스템 자원에 병렬 접근함으로써, 의도치 않은 로직 수행이 발생 가능함
        if (passCount < 10) {
            // 아래 1ms 만에 모든 스레드가 다 진입 성공함
            try { Thread.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
            // 안전하지 않은 방법으로 (lock 없이) 카운트 처리 수행
            System.out.println("passCount: " + (++passCount));
        } else System.out.println("blocked by passCount condition");
    }
}
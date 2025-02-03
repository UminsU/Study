package w6.w6_2_multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import static java.lang.Thread.sleep;

public class ConcurrencyAdvancedSample {
    // 여러 스레드 동시에 접근할 대상 필드 선언
    static int sharedVariable = 0;
    // 여러개의 스레드가 동시에 접근하는 것을 고려하지 않음
    // 불필요한 연산이 없어서 효율적, 하지만 동시성 발생시 안전하지 않음
    //   => Thread Unsafe 한 자료형
    static List<Integer> integerArrayList = new ArrayList<>();
    // Thread Safe 한 메서드를 제공하는 Vector
    static List<Integer> integerVactor = new Vector<>();

    static Runnable threadWorkload = () -> {
        // 코드 임계영역을 사용하지 않음
        // 1) 변수 동시 접근할 때, 스레드간 순서가 달라짐
        // 2) ArrayList.add() 와 같이 Thread Unsafe 메서드를 호출할 때, 실패 가능
        //    실패하거나 선후 관계가 뒤바뀌는 일이 발생
        // 3) Vactor.add() 동시 접근할 때, 순차처리 Sync 적용되어 실패 또는 순서 왜곡 없음
        //    하지만 변수 연산 시에 이미 동시접근 때문에 연산처리 완료 전 변수가 참조되는 문제는 그대로 반영됨
        for (int i = 0; i < 10; i++) {
            sharedVariable++;
            integerArrayList.add(sharedVariable);
            integerVactor.add(sharedVariable);
            try {
                sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    };

    // 함수형 인터페이스 구현체 (Runnable)
    static class syncedThreadWorkload implements Runnable {
        // 호출부를 Synchonize 하더라도, 호출 되는 부분 까지 Sync 할 수는 없음
        //
        @Override
        public synchronized void run() {
            for (int i = 0; i < 10; i++) {
                sharedVariable++;
                integerArrayList.add(sharedVariable);
                integerVactor.add(sharedVariable);
                try {
                    sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // 1) Unsynced
//        Thread t1 = new Thread(threadWorkload);
//        Thread t2 = new Thread(threadWorkload);
        // 2) Method Synced
        //     -> 스레드 생성 시마다 별도의 Runnable 객체가 전달되고 있음
        //     -> 아무리 정의된 워크로드가 Sync  되어 있어도, 객체단위의 Sync 이기 때문에,
        //        (static sync 가 아님)
        //         t1, t2 간 동시성은 해결되지 않는다.
        Thread t1 = new Thread(new syncedThreadWorkload());
        Thread t2 = new Thread(new syncedThreadWorkload());

        t1.start();
        t2.start();
        // 스레드가 작업을 마친후 종료된 시점까지 본 라인에서 Blocking 한 상태로 대기
        try {
            t1.join();
            t2.join();
            System.out.println(integerArrayList + " " + integerArrayList.size());
            System.out.println(integerVactor + " " + integerVactor.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

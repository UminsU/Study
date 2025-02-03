package w6.w6_2_multithreading;

import java.awt.*;

import static java.lang.Thread.sleep;

public class SimpleMultithreading {
    static class BeepController {
        int reps;
        int delayTimeMs;

        public BeepController(int reps, int delayTimeMs) {
            this.reps = reps;
            this.delayTimeMs = delayTimeMs;
        }
    }

    public static void main(String[] args) {
        // Main 스레드에서 객체를 생성합니다.
        BeepController beepController = new BeepController(10, 500);
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        // 인라인 오버라이딩 방식의 생성 ( 옛날 패러다임 )
        Thread myTread1 = new Thread() {
            @Override
            public void run() {
                // 내가 동작시킬 코드
                for (int i = 0; i < beepController.reps; i++) {
                    try {
                        sleep(beepController.delayTimeMs);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    toolkit.beep();
                }
            }
        };

        // Runnable 함수형 인터페이스
        Thread myTread2 = new Thread(
                new Runnable() { // 인라인 오버라이딩
                    @Override
                    public void run() {
                        try {
                            sleep(beepController.delayTimeMs / 2);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        for (int i = 0; i < beepController.reps; i++) {
                            try {
                                sleep(beepController.delayTimeMs);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            toolkit.beep();
                        }
                    }
                }
        );

        // 아래 반복문이 위 run 동작 종료와 관계 없이 수행됩니다.
        for (int i = 0; i < beepController.reps * 5; i++) {
            try {
                sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Main Thread is Working");
        }

        // 3) 함수형 인터페이스 익명 구현체 (=람다) 사용
        // 코드도 간결하며, 가장 직관적인 정의
        Thread myTread3 = new Thread(() -> {
            try {
                sleep(beepController.delayTimeMs / 3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            for (int i = 0; i < beepController.reps; i++) {
                try {
                    sleep(beepController.delayTimeMs);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                toolkit.beep();
            }
        });

        myTread1.start(); // 메인스레드에서 분리되어 실행되는 지점
        myTread2.start();
        myTread3.start();
    }
}

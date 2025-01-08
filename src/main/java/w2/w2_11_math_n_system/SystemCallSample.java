package w2.w2_11_math_n_system;

import java.io.Console;
import java.time.Instant;

public class SystemCallSample {
    public static void main(String[] args) {

        Instant nowtime = Instant.now();
        System.out.println("Instant now : " + nowtime);

        long currentTime = System.currentTimeMillis();
        System.out.println("현재 시간(밀리초): " + currentTime);

        long nanoTime = System.nanoTime();
        System.out.println("현재 시간(나노초): " + nanoTime);

        String javaVersion = System.getProperty("java.version");
        System.out.println("Java 버전: " + javaVersion);

        // 환경변수 가져오기
        String userName = System.getenv("USER");
        System.out.println("사용자 이름: " + userName);
        String pathEnv = System.getenv("PATH");
        System.out.println("시스템 PATH ENW: " + pathEnv);

        /*System.out.println("종료 전");
        System.exit(0); // 상태 0으로 JVM 종료
        System.out.println("종료 후"); // 이 줄은 실행되지 않음*/

        int[] sourceArray = {1, 2, 3, 4, 5};
        int[] destinationArray = new int[5];
        System.arraycopy(sourceArray, 0, destinationArray, 0, sourceArray.length);
        for (int j : destinationArray) {
            System.out.println(j);
        }

        //System.gc(); // 가비지 컬렉션 요청

        /*InheritedChannel channel = System.inheritedChannel();
        System.out.println("상속된 채널: " + channel);*/

        Console console = System.console();
        if (console != null) {
            String input = console.readLine("뭔가를 입력하세요: ");
            console.writer().println("입력하신 내용: " + input);
        }

    }
}

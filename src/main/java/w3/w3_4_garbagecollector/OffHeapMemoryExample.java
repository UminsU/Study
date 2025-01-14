package w3.w3_4_garbagecollector;

import java.lang.ref.Cleaner;
import java.nio.ByteBuffer;

public class OffHeapMemoryExample {
    static Cleaner cleaner = Cleaner.create();

    public static void main(String[] args) {
        // Off-Heap 메모리 크기 설정 (예: 1 메가바이트)
        int offHeapMemorySize = 1000 * 1000;

        // Direct ByteBuffer를 사용하여 Off-Heap 메모리 할당
        ByteBuffer offHeapBuffer = ByteBuffer.allocateDirect(offHeapMemorySize);
        // offHeapBuffer 라고하는 객체 자체가 GC의 대상이 안됨
        // GC 대상이 되게끔만 등록하면 되는게 아니라, offHeapBuffer 변수 자체가 참조가 끊어져야 수거됨
        // offHeapBuffer = null; 을 수행해야 수거됨

        // Off-Heap 메모리에 데이터 쓰기
        String data = "Hello Off-Heap!";
        byte[] bytes = data.getBytes();
        offHeapBuffer.put(bytes);

        // 읽기 모드로 변경
        offHeapBuffer.flip();

        // Off-Heap 메모리에서 데이터 읽기
        // 빈 힙메모리 이전 데이터 배열 영역을 미리 준비
        byte[] readBytes = new byte[bytes.length];
        // offHeap 에 있는 데이터를 준비한 heap 영역으로 복사
        offHeapBuffer.get(readBytes);

        String readData = new String(readBytes);
        System.out.println("Read from Off-Heap Memory: " + readData);

        // Off-Heap Buffer를 Cleaner를 사용하여 해제
        cleanDirectBuffer(offHeapBuffer);
        offHeapBuffer = null; // Off-Heap 메모리에 대한 Jeap 내부에서의 강한 참조 해제
        System.gc();
        // 수거되는 동작을 sleep 반복문으로 기다림
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // Direct ByteBuffer를 Cleaner를 사용하여 해제하는 메서드
    private static void cleanDirectBuffer(ByteBuffer buffer) {
        if (buffer.isDirect()) {
            cleaner.register(buffer, () -> {
                // Off-Heap Buffer가 해제될 때 수행할 작업 정의
                System.out.println("Cleaning Direct Buffer");
            });
        }
    }
}
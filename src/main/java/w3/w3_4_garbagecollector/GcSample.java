package w3.w3_4_garbagecollector;

import java.lang.ref.WeakReference;

public class GcSample {
    public static void main(String[] args) {
        // 1. 강한(기본) 참조 변수 선언과 객체 생성
        ResourceHolder obj = new ResourceHolder(1);
        // 2. 약한 참조로 위에 생성한 객체 연결
        WeakReference<ResourceHolder> weakRef = new WeakReference<>(obj);
        // 3. 강한 참조에 대한 참주 주소 연결 해제
        obj = null; // obj를 null로 설정하여 참조를 해제
        // 4. 생성되었던 heep 메모리상의 객체를 GC 강제 호출로 수거
        System.out.println(weakRef.get());
        System.gc(); // 예제용, 실무에선 안씀
        // 5. 수거되는 동작을 sleep 반복문으로 기다림
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(weakRef.get());
    }
}

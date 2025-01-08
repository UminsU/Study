package w2.w2_12_simulator;

import java.util.Scanner;

// 종료일 경우 종료
// 외에 Option 객체의 메세지 호출, 사용자 입력 처리
// 리모컨 : 입력을 대기하는 주체
// TV : 동작을 담당하는 주체
class TV {
    public void updateStatus(String value) {
        System.out.println(value + "(으)로 설정되었습니다.");
        System.out.println("다음 동작을 입력해주세요.");
    }
}

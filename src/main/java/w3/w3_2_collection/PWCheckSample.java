package w3.w3_2_collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PWCheckSample {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        Map<String, String> myLoginMap = new HashMap<>();
        myLoginMap.put("userId1", "pw1");
        myLoginMap.put("userId2", "pw2");
        myLoginMap.put("userId3", "pw3");
        System.out.println(myLoginMap);

        // ID 입력받은 후, 등록되어 있는지 검사
        System.out.println("아이디를 입력하세요 : ");
        String idInput = myScanner.nextLine();
        // 맵 자료형 내부에 ID는 키로 관리됨, 키 Set 에서 입력된 ID 값의 포함 유무 검사
        String userPwFound = myLoginMap.get(idInput); // 키가 없으면 null 반환
        if(userPwFound != null) {
            System.out.println("등록된 ID로 확인되었습니다.");
        } else {
            System.out.println("등록된 ID가 없습니다.");
        }
        System.out.println("아이디를 입력하세요 : ");
        String pwInput = myScanner.nextLine();
        if (pwInput.equals(userPwFound)) {
            System.out.println("패스워드 일치! 로그인 성공.");
        } else {
            System.out.println("패스워드 불일치! 로그인 실패.");
        }
    }
}

package w2.w2_6_hashcollision;

import java.util.HashMap;
import java.util.Map;

import static java.lang.System.out;

public class HashcodeCollisionCheck {
    public static void main(String[] args) {
        // {해시코드 : 객체} 형태의 Map 자료형
        Map<Integer, Object> objectMap = new HashMap<>();
        int j = 1;
        long formerCollision = Integer.MIN_VALUE;

        // int 형 범위만큼 반복
        for (long i = Integer.MIN_VALUE; i < Integer.MAX_VALUE + 1L; i++) {
            Object newObj = new Object(); // 객체 생성
            int hashCode = newObj.hashCode(); // 해시코드 얻기

            // Map 에 해당 해시 코드가 존재하는지 확인 (만일 있다면 출력)
            Object objInMap = objectMap.get(hashCode);
            if (objInMap != null) {
                out.println("[" + (i - Integer.MIN_VALUE + 1L) + "번째 루프]");
                // 서로 다른 두 객체의 해시코드가 같음 = 해시충돌 확인!
                out.println("objInMap == newObj : " + (objInMap.equals(newObj)));
                out.println("기존에 있는 객체 해시코드 : " + objInMap.hashCode());
                out.println("새롭게 만든 객체 해시코드 : " + newObj.hashCode());
                out.println("해시충돌 발생간격 : " + (i - formerCollision + 1L));
                out.println();

                // 10, 100, 1_000, 10_000, 100_000으로 바꾸며 충돌발생 간격확인
                if (j >= 10) return;
                j++;
                formerCollision = i;
            } else {
                objectMap.put(hashCode, newObj); // Map에 해시코드와 객체 등록
            }
        }
    }
}
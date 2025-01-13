package w3.w3_2_collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListSample {
    public static void main(String[] args) {
        // ArrayList // LinkedList implement List

        // 광범위한 타입 선언은 비권장
        List<Object> myList1 = new ArrayList<>();
        List<Object> myList2 = new ArrayList<>();
        // 변수에 제네릭 타입 선언한 경우, 할당되는 객체 생성문에는 그에 맞는 타입이 들어가는 것이 상식
        // 3단 논법에서의 추론 / 통계적 추론
        // A는 B다, B는 C다, 그러므로 A는 C다. (연역법) -> 연역법( 명제적 참을 도출 )
        // => 자동으로 타입 추론되므로 생략을 권장함    ↓     연역 추론 ( 컴파일러의 기본 타입 추론 방법 )
        List<String> myStrArrList = new ArrayList<>(10);
        // ArrayList 생성 시, 메모리 점유 크기를 바꾸어가면서 1000번 반복시키며 테스트 (소요시간 테스트하기)
        // 밀리세컨드 단위로 Time 객체 사용하기
        List<String> myStrLnkLNst = new LinkedList<>();

        myStrArrList.add("1");
        myStrArrList.add("2");
        myStrArrList.add("3");
        myStrArrList.add(2, "2.5");

        System.out.println(myStrArrList);

        if (myStrArrList.contains("1")) {
            System.out.println("1 is in my List.");
        }

        // 자료형이 주어졌을 때, 안전한 연산인자를 확인하고 사용하자
        System.out.println(myStrArrList.get(4));
        System.out.println(myStrArrList.isEmpty());
        System.out.println(myStrArrList.size());
        myStrArrList.clear();
        System.out.println(myStrArrList);
    }
}
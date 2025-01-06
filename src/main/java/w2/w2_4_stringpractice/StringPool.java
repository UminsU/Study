package w2.w2_4_stringpractice;

public class StringPool {
    public static void main(String[] args) {
        // String Pool을 사용하는 경우와 사용하지 않는 경우
        String s1 = "example";            // String Pool에 저장
        String s2 = "example";            // String Pool에서 참조
        String s3 = new String("example"); // Heap에 별도 객체 생성

        System.out.println(s1 == s2);      // true (String Pool에서 동일한 참조)
        System.out.println(s1 == s3);      // false (메모리 주소 비교)
        System.out.println(s1.equals(s3)); // true (내용 비교)
    }
}

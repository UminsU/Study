package w3.w3_3_objectclass;

import java.util.Objects;

public class MyObject {
    private int field1;
    private String field2;

    // getters, setters 생략


    public MyObject(int field1, String field2) {
        this.field1 = field1;
        this.field2 = field2;
    }

    @Override
    public boolean equals(Object obj) {
        // 객체 동일성 비교
        if (this == obj) return true; // this : 현재 equals 메서드를 호출한 객체 자신
        // 주소값 간의 비교 말고, 동일성 비교 예제 (
        // 널인 경우, 클래스가 다른 경우 false
        // -> 내가 만든 클래스에서 더 적절한 형태의 동일성 비교가 있다면 교체
        //    (성능이 좋거나, 동일성 판단 기준이 제한적이거나)
        if (obj == null || getClass() != obj.getClass()) return false;

        // 클래스 명시적 캐스팅이 포함되거나, 내용비교를 통한 동일성 체크로 오버라이딩 가능
        MyObject myObject = (MyObject) obj;
        return field1 == myObject.field1 && Objects.equals(field2, myObject.field2);
    }

    @Override
    public int hashCode() {
        // 해시값 계싼 기초가 되는 인풋을 변경하는 형태로 나만의 해시코드 생성 가능
        return Objects.hash(field1, field2);
        // 다양한 케이스에서 hashCode() 오버라이딩 가능
        // -> 64bit 해시코드를 특정 객체에 적용하고 싶다
        // -> 해시 함수 (해싱 알고리즘)를 해시 충돌이 덜 나오는 방향으로 계산하고 싶다
    }

    @Override
    public String toString() {
        return "MyObject{" +
                "field1=" + field1 +
                ", field2='" + field2 + '\'' +
                '}';
    }

    @Override
    protected MyObject clone() throws CloneNotSupportedException {
        // 복제 로직 추가
        return new MyObject(this.field1, this.field2);
    }

    public static void main(String[] args) {
        MyObject obj1 = new MyObject(1, "a");
        System.out.println(obj1);
    }
}
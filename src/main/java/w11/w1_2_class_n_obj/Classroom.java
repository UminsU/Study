package w11.w1_2_class_n_obj;

public class Classroom {
    // 정적변수(Static 변수) : 선언과 동시에 초기화
    // 클래스 변수 : 객체가 아닌 클래스에 속한 변수 => 언제나 사용가능
    static boolean hasDoor = true;

    // int roomNum = 410;  // 멤버변수 하드코딩 금지

    // 멤버변수
    int roomNum;
    String roomName;
    // 객체가 생성될 때에 멤버변수도 함께 초기화

    public Classroom(){
        // 기본생성자 : 매개변수가 없는 생성자
        // 클래스에 명시하지 않아도, 자바 컴파일러가 자동으로 생성, 초기화
    }

    public Classroom(int roomNum) {
        this.roomNum = roomNum;
        System.out.println(this.roomNum + "번 강의장 객체가 생성되었습니다.");
    }

    public Classroom(int roomNum, String roomName) {
        this.roomNum = roomNum;
        this.roomName = roomName;
        System.out.println(this.roomNum + "번, " + this.roomName + "강의장 객체가 생성되었습니다.");
    }

    // 일반 메서드
    public void printRoomName() {
        System.out.println(this.roomName);
    }

    // 매개변수 사용
    public void printRoomNameNTimes(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(this.roomName);
        }
    }

    // 메서드
    public static void main(String[] args) {
        // 생성자의 호출로 객체가 만들어진다
        Classroom classroom410 = new Classroom(410  );
        Classroom classroom411 = new Classroom(411  );
        Classroom classroom412 = new Classroom(412  );

        Classroom classroom413 = new Classroom(413, "A");
        Classroom classroom414 = new Classroom(414, "B");
        Classroom classroom415 = new Classroom(415, "C");

        classroom413.printRoomName();
        classroom414.printRoomName();
        classroom415.printRoomName();

        System.out.println(Classroom.hasDoor);

        classroom414.printRoomNameNTimes(3);
    }

}

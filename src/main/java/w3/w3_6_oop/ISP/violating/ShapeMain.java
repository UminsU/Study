package w3.w3_6_oop.ISP.violating;

public class ShapeMain {
    public static void main(String[] args) {
        Rectangle myRec = new Rectangle(5, 5);
        // 2D 클래스에 대해서 3D 인터페이스가 적용되어 있어서
        // 아래와 같은 메서드 호출이 가능하게 됨
        myRec.calculateArea();
    }
}

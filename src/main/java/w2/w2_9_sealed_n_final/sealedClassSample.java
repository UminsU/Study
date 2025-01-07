package w2.w2_9_sealed_n_final;

sealed class Shape permits Circle,Square{
    void draw(){
        System.out.println("Drawing Default Shape");
    };
}

final class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

// Final 클래스는 더이상 상속 불가
/*
final class ChiledCircle extends Circle {
    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }
}
*/

// non-sealed 클래스는 다음 상속 구조를 이루는 클래스 부터는
// sealed 제어 구조로부터 제거함으로써 봉인효과를 해제
non-sealed class Square extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Square");
    }
}

class ChiledSquare extends Square {
    @Override
    public void draw() {
        System.out.println("Drawing Square");
    }
}

public class sealedClassSample {
    public static void drawShape(
            // 작업을 위한 input 에서 Interface 를 사용하면 매우 유연한 동작 구현 가능
            Shape shape
    ) {
        shape.draw();
    }

    public static void main(String[] args) {
        Shape shape1 = new Circle();
        Shape shape2 = new Square();

        drawShape(shape1);
        drawShape(shape2);
    }
}
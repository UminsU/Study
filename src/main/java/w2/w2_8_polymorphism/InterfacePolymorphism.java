package w2.w2_8_polymorphism;

interface Shape {
    void draw();
}

class Circle implements Shape {
    // 도형을 작업의 대상 또는 동작의 주체로 보고
    // 기능을 구현할 때, 개발자끼리 협의하기 위한 단위로 다루고 싶은 경우
    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Square");
    }
}

public class InterfacePolymorphism {
    public static void drawShape(
            // 작업을 위한 input 에서 Interface 를 매개 변수로 사용하면 매우 유연한 동작 구현 가능
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
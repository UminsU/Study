package w2.w2_8_polymorphism;

public class InstanceOfSample {
    public static void main(String[] args) {
        Shape myShape1 = new Circle();
        Shape myShape2 = new Square();

//        if (myShape1 instanceof Shape) {
//            System.out.println("Shape 입니다!");
//        }
//
//        if (myShape1 instanceof Circle) {
//            System.out.println("Circle 입니다!");
//        } else if (myShape1 instanceof Shape) {
//            System.out.println("Shape 입니다!2");
//        }

//        if (myShape2 instanceof Circle) {
//            System.out.println("Circle 입니다!");
//        } else if (myShape2 instanceof Square) {
//            System.out.println("Square 입니다!");
//        } else if (myShape2 instanceof Shape) {
//            System.out.println("Shape 입니다!2");
//        }

        Shape[] shapes = { myShape1, myShape2 };
        for (Shape anyShape: shapes){
            if (
                // instanceof 검사 시, alias 변수명을 선언하면, 명시적 형변환 발생
                    anyShape instanceof Circle myCircleShape
            ) {
                System.out.println("Circle 입니다!");
                myCircleShape.draw();
                System.out.println(myCircleShape.getClass());
                // 아래 명시적 형변환은 불필요한 코드가 됨
                // Circle myCircle = (Circle) myCircleShape;
                // System.out.println(myCircle.getClass());
            } else if (anyShape instanceof Square mySquareShape) {
                System.out.println("Square 입니다!");
                mySquareShape.draw();
                System.out.println(mySquareShape.getClass());
            }
            System.out.println();
        }
    }
}
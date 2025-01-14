package w3.w3_6_oop.OCP.corresponding;

// (1) 확장에 열려 있는 인터페이스 선언
interface IAreaMeasurable {
    double calculateArea();
}

// (2) 인터페이스 직접 구현
class Rectangle implements IAreaMeasurable {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double calculateArea() {
        return width * height;
    }
}

// (3) 인터페이스를 구현하는 추상클래스 단계를 선언
abstract class Shape implements IAreaMeasurable{ }

// (4) 추상클래스를 상속받아 인터페이스에 따른 실제 로직 구현
class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

// (5) shape 타입 객체를 배열 인자로 받아 면적 총합 계산
class AreaCalculator {
    // 추상 클래스 기준 코드 확장용 Util
    public double calculateArea(Shape[] shapes) {
        double totalArea = 0;
        for (Shape shape : shapes) {
            totalArea += shape.calculateArea();
        }
        return totalArea;
    }

    // 인터페이스 기준 코드 확장용 Util
    public double calculateArea(IAreaMeasurable[] shapes) {
        double totalArea = 0;
        for (IAreaMeasurable shape : shapes) {
            totalArea += shape.calculateArea();
        }
        return totalArea;
    }
}
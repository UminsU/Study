package w3.w3_6_oop.ISP.violating;

public interface Shape {
    // Interface 의 SRP = ISP (인터페이스의 책임/용도 분리)
    double calculateArea();
    double calculateVolume();
}

class Rectangle implements Shape {
    private double width;
    private double height;

    public double calculateArea() {
        return width * height;
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double calculateVolume() {
        throw new UnsupportedOperationException("사각형은 부피 계산이 불가능합니다!");
    }
}

class Cube implements Shape {
    private double width;
    private double height;
    private double depth;

    public double calculateArea() {
        return 2 * (width * height + width * depth + height * depth);
    }

    public double calculateVolume() {
        return width * height * depth;
    }
}
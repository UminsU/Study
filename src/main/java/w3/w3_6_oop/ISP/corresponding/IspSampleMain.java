package w3.w3_6_oop.ISP.corresponding;

public class IspSampleMain {
    public static void main(String[] args) {
        Cube2 cube = new Cube2(10, 10, 10);
        System.out.println(cube.calculateArea()); // 600
        System.out.println(cube.calculateVolume()); // 1_000

        IAreaMeasurable rect = new Rectangle2(10, 20);
        System.out.println(rect.calculateArea()); // 200
    }
}

interface IAreaMeasurable {
    double calculateArea();
}

interface IVolumeMeasurable {
    double calculateVolume();
}

class Rectangle2 implements IAreaMeasurable {
    private double width;
    private double height;

    public Rectangle2(int width, int height) {
        this.width = width;
        this.height = height;
    }
    @Override
    public double calculateArea() {
        return width * height;
    }
}

class Cube2 implements IAreaMeasurable, IVolumeMeasurable {
    private double width;
    private double height;
    private double depth;

    public Cube2(int width, int height, int depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    @Override
    public double calculateArea() {
        return 2 * (width * height + width * depth + height * depth);
    }

    @Override
    public double calculateVolume() {
        return width * height * depth;
    }
}
package w2.w2_2_memorystructure;

public class Cat {

    // 생성자
    public Cat(int age, float furLength, String name) {
        this.age = age;
        this.furLength = furLength;
        this.name = name;
    }

    // Static 변수
    public static final boolean fourLegged = true;
    public static final boolean mammal = true;

    // 인스턴스 변수
    public int age;
    public float furLength;
    public String name;

    // 인스턴스 메서드
    public int getAge() {
        return this.age;
    }

    public float getFurLength() {
        return furLength;
    }

    public String getName() {
        return name;
    }

    // Static 메서드
    public static void main (String[]args){
        Cat myScottishFold = new Cat(1, 10.123f, "Scattish");
        int catAge = myScottishFold.getAge();
        float catFurLength = myScottishFold.getFurLength();
        String catName = myScottishFold.getName();
    }
}
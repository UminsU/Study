package w1_2_class_n_obj;

public class DogForObject {
    // 1. Static 변수
    public static final boolean fourLegged = true;
    public static final boolean mammal = true;

    // 2. 생성자
    public DogForObject(int age, String name, float furLength) {
        this.age = age;
        this.name = name;
        this.furLength = furLength;
    }

    // 3. Static 메서드
    public static void dogInfo() {
        if (fourLegged) {
            System.out.println("Dog is four legged.");
        }
        if (mammal) {
            System.out.println("Dog is mammal.");
        }
    }

    // 4. 인스턴스 변수
    public int age;
    public float furLength;
    public String name;

    // 5. 인스턴스 메서드
    public int getAge() {
        return this.age;
    }

    public float getFurLength() {
        return furLength;
    }

    public String getName() {
        return name;
    }

    // 6. main 메서드
    public static void main (String[]args){
        // static 메서드는 객체 생성 없이 사용 가능
        DogForObject.dogInfo();

        // 객체 생성을 통해 인스턴스 변수에 접근
        DogForObject myDog = new DogForObject(1, "BowWow", 10.123f);

        // getter 를 통해 인스턴스 변수에 접근
        int dogAge = myDog.getAge();
        float dogFurLength = myDog.getFurLength();
        String dogName = myDog.getName();

        // printf 사용법 : https://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html
        System.out.printf("%d, %s, %f", dogAge, dogName, dogFurLength);

    }
}

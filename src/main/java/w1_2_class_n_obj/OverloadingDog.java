package w1_2_class_n_obj;

public class OverloadingDog {
    String name;
    int age;
    int furLength;
    // : 이름은 같지만 시그니처가 다른 메서드나 생성자를 여러개 선언하는 것

    // 생성자1 : 이름과 나이만 아는 경우 Dog 객체 생성
    public OverloadingDog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 생성자2 : 털 길이까지 포함한 기능을 위해서 추가된 신규 생성자
    public OverloadingDog(String name, int age, int furLength) {
        this.name = name;
        this.age = age;
        this.furLength = furLength;
    }

    // 생성자2 : 잘못된 경우
    // 1. 용도가 다르지 않고
    // 2. 기능이 추가되지 않고
    // 3. 지금 추가/기존 생성자들과 사용패턴이 일관성을 해침
    public OverloadingDog(int furLength, String name, int age) {
        this.furLength = furLength;
        this.name = name;
        this.age = age;
    }

    // 메서드
    public void bark() {
        System.out.println("Woof! My name is " + name + " and I'm " + age + " years old.");
    }

    public void bark(int a) {
        for (int i = 0; i < a; i++) {
            System.out.println(
                    "(" + i + ") Woof! My name is " + name
                            + " and I'm " + age + " years old."
            );
        }
    }

    public static void main(String[] args) {
        // 바꿀 수는 있지만
        // 1. 너무 많이 바꾸어야 할 수도 있고
        // 2. 내가 작성하지 않은 부분을 건드릴 수도 있고
        // 3. 지금 추가/변경하는 부분의 목적이 부수적인 수정사항 때문에 집중이 흐려짐.

        // 객체 생성, 메서드 호출
        // 생성자1
        OverloadingDog myDog1 = new OverloadingDog("Buddy1", 1);
        myDog1.bark();
        // 생성자2 (good)
        OverloadingDog myDog2 = new OverloadingDog("Buddy2", 2, 10);
        myDog2.bark(2);
        // 생성자2 (bad)
        OverloadingDog myDog3 = new OverloadingDog(5, "Buddy3", 3);
        myDog3.bark(3);

    }
}

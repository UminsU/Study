package w2.w2_16_encapsulation;

class Person {
    private String name;
    private int age;
    // 생성시 이름과 나이가 없는 사람은 없음

    public Person(String name,int age) {
        this.name = name;
        this.age = age;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for age
    public int getAge() {
        return age;
    }

    // Setter for age
    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        }
    }
    public void addAge() {
        this.age++;
    }
}
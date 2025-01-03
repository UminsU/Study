package w1_3_simpleinherit;

public class InheritTest {
    public static void main(String[] args) {
        Parent parentA = new Parent();
        parentA.hello("java");

        Child childA = new Child();
        childA.hello("java");
    }
}

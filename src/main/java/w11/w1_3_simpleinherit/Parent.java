package w11.w1_3_simpleinherit;

public class Parent {
    public void hello(String target) {
        if (target == null || target.isEmpty()) {
            System.out.println("hello nobody");
        } else {
            System.out.println("hello "+ target + "!");
        }
    }
}

package w1_3_simpleinherit;

// 상속을 나타내는 키워드는 extends
// 확장하기 위해서 상속하기 때문
public class Child extends Parent {
    @Override
    public void hello (String target) {
        if (target == null || target.isEmpty()) {
            System.out.println("hello nobody");
        } else {
            System.out.println("hello "+ target + "from Child");
        }
        //System.out.println("I'm Child");
        super.hello(target);
        System.out.println("from Child");
    }
}

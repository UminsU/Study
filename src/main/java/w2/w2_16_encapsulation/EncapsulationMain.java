package w2.w2_16_encapsulation;

public class EncapsulationMain {
    public static void main(String[] args) {
        BankAccount myBankAccount = new BankAccount(1000);
        // myBankAccount.balance *= 1000;
        // System.out.println(myBankAccount.balance);

        // 대규모 프로젝트 등 여러 기능이 함께 개발되거나, 협업을 수행할 때
        // 접근 제어자를 적절히 사용하면 아래와 같은 개발자의 부정 연산을
        // 미연에 방지할 수 있다.

        myBankAccount.deposit(1000);
        System.out.println(myBankAccount.getBalance());

        // 기본적으로 필드는 직접 접근하지 못하고
        // 값의 Read 와 Update 에 대해서 메서드로 접근할 때,
        // Encapsulation 이 되어있다고 말할 수 있음

        Person myChild = new Person("Micheal",5);
        myChild.setName("Minsu");
        System.out.println(myChild.getName());
        // 의도치 않은 연산이 일어날 여지가 남는 방식의 encapsulation 적용됨
        myChild.setAge(7);
        System.out.println(myChild.getAge());
        // Getter 와 Setter 를 통해서 기본 연산을 사용하는 것은 대부분 허용
        // 항상 1살씩만 증가하는 것을 강제하는 효과까지 추구 가능
        myChild.addAge();
    }
}

package w2.w2_1_accessmodifier.a;

public class B extends A{
    public static void main(String[] args){
        // A.printPrivateStrA();
        A.printPackagePrivateStrA();
        A.printProtectedStrA();
        A.printPublicStrA();
    }
}
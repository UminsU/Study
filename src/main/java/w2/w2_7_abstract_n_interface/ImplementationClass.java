package w2.w2_7_abstract_n_interface;

public class ImplementationClass implements InterfaceSample, InterfaceSample2{

    @Override
    public void absMethod() {

    }

    @Override
    public void absMethod(int a) {

    }

    @Override
    public void absMethod(int a, int b) {

    }

    @Override
    public void absMethod(int[] arrA) {

    }

    @Override
    public void absMethod2() {

    }

    public static void main(String[] args) {
        ImplementationClass myImpl = new ImplementationClass();
        myImpl.absMethod(1, 2, 3);
        // 인터페이스를 적극적으로 활용하면
        // 개발 결과물에 대해서 업무 정의 또는 설계자가 매우 정확하고 의도한 방향에 부합하는
        // 설계 구현 결과물을 얻을 수 있는 디테일한 협업 가능
    }
}

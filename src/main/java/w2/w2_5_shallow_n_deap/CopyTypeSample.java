package w2.w2_5_shallow_n_deap;

public class CopyTypeSample {
    public static void main(String[] args) {
        // 참조자료형(Heap 관리)인 배열 객체를 생성
        int[] a = {1, 2, 3, 4, 5};
        // 1. 참조자료형을 담은 변수(배열 객체)를 할당 연산자를 사용해서 다른 변수에 할당
        int[] b = a;
        // 2. DeepCopy 를 수행하는 메서드를 명시적으로 사용 후 새 변수에 할당
        int[] c = a.clone();

        a[4] = 99;  // {1, 2, 3, 4, 99};
        System.out.printf("5th int in b is : %d \n" ,b[4]);
        System.out.printf("5th int in c is : %d" ,c[4]);
    }
}
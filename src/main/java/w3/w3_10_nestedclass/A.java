package w3.w3_10_nestedclass;

public class A {
    // 생성자
    public A() {
        System.out.println(this.classAinstanceName +" 생성됨");
     }
    // 정적 블록 (정적 블록은 사용이 권장되지는 않음)
    static {  // 중첩 정적 클래스 접근 및 StaticB 타입 객체 생성
        staticB = new StaticB();
    }
    // 정적 멤버 (필드 및 클래스)
    public static class StaticB {  // 중첩 정적 멤버 클래스 StaticB 선언
        // 생성자
        private StaticB(){
            this.staticBinstanceName =  name+"의 객체";
            System.out.println(this.staticBinstanceName +" 생성됨");
        }
        // 정적 변수
        static String name = "중첩 정적 멤버 클래스 StaticB";
        // 정적 메서드
        public static void accessClass() {
            System.out.println(name+"에 접근");
        }
        // 인스턴스 변수
        String staticBinstanceName;
        // 인스턴스 메서드
        public void access() {
            System.out.println(staticBinstanceName +"에 접근");
        }
    }
    private static final StaticB staticB;  // final 키워드로 singleton 패턴 사용
    public static StaticB getStaticB() {  // 정적 변수 b 에 대한 외부 접근 채널
        return staticB;
    }
    // 정적 메서드
    public static void accessLocalD(int accessCnt) {
        // - 외부에서 LocalD 클래스에 접근 불가
        // - 외부에 LocalD 객체 반환 불가"""
        String localDclassName = "중첩 로컬 클래스 LocalD";
        // accessCnt = 0;  - // 메서드 내부의 로컬클래스에서 변수에 접근하는 경우 자동 final로 처리됨
        // localDclassName = "";  - // 메서드 내부의 로컬클래스에서 변수에 접근하는 경우 자동 final로 처리됨
        System.out.printf("A.accessLocalD(): %s에 접근\n", localDclassName);
        class LocalD {  // 중첩 로컬 클래스 LocalD 선언
            // 생성자
            LocalD() {
                setLocalDinstanceName(localDclassName+"의 객체");
                System.out.printf("A.accessLocalD(): %s 생성됨\n", this.localDinstanceName);
            }
            // 인스턴스 필드
            String localDinstanceName;
            // 인스턴스 메서드
            void access() {
                System.out.printf("A.accessLocalD(): %s에 접근\n", localDinstanceName);
            }
            public void setLocalDinstanceName(String instanceName) {
                this.localDinstanceName = instanceName + accessCnt;
            }
        }
        final LocalD localD = new LocalD();
        localD.access();
    }
    // 인스턴스 멤버 (필드 및 클래스)
    String classAinstanceName = "클래스 A의 객체";
    InstanceC instanceC;
    // 인스턴스 블록
    // 객체화를 위해서 생성자가 호출되면
    // 먼저 호출됨
    {
        instanceC = new InstanceC();
        System.out.println(instanceC.name+"의 객체가 "+this.classAinstanceName +"보다 먼저 생성됨");
    }
    public class InstanceC {
        // 생성자
        InstanceC() {
            this.name = "중첩 인스턴스 멤버 클래스 InstanceC";
        }
        // 인스턴스 필드
        String name;
        // 인스턴스 메서드
        public void access() {
            System.out.println(A.this.classAinstanceName+"를 통해 "+this.name + "의 객체에 접근");
        }
    }
    // 인스턴스 메서드
    public InstanceC getInstanceC() {
        return this.instanceC;
    }
}
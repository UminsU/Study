package w3.w3_11_pokemonGame;

import lombok.Getter;

public class PokeTown {
    // 필드 멤버
    @Getter
    private String name;
    private String townIntroduction;
    @Getter
    private boolean walkable;

    // 동작이자 객체인 멤버를 선언 : 인터페이스 객체
    @Getter
    private  ITownEvent townEvent; // 모든 타운에 별도구현체를 할당 가능

    public PokeTown(String name, String townIntroduction, boolean walkable) {
        this.name = name;
        this.townIntroduction = townIntroduction;
        this.walkable = walkable;
    }

    public PokeTown(String name, String townIntroduction, boolean walkable, ITownEvent townEvent) {
        this.name = name;
        this.townIntroduction = townIntroduction;
        this.walkable = walkable;
        this.townEvent = townEvent;
    }

    // 메서드 선언 방식 (로직 교체 불가능)
    public void townEvent() {
        // 단일한 로직만 구현 가능한 단순 메서드 선언 방식
        System.out.println("마을에 오신 것을 환영합니다! " + this.townIntroduction);
    }

    // TownEvent 동작을 내부 함수형 인터페이스로 선언
    @FunctionalInterface
    public interface ITownEvent {
        void triggerTownEvent(Trainer trainer);
    }
}

package w3.w3_11_pokemonGame;

import lombok.Getter;

@Getter

public class Pokemon implements IPokemon {
    private String pokemonName;
//    final private String pokemonName;
//
//    public Pokemon(String pokemonName) {
//        this.pokemonName = pokemonName;
//    }

    private String custoName;
    private int hp;


    @Override
    public void attack(Pokemon tgPokemon) {
        // 데이터 및 동작 : tgPokemon.getHP(), tgPokemon.setHP(),
        // 그 외 추가 동작 및 결과
    }

    @Override
    public void flee(int enemyLv) {
        // 결과 출력
    }

    @Override
    public Pokemon evolve() {
        // 데이터 및 동작
        // : this.setters()
        // : this.getters()
        // 기존 객체 참조 삭제
        // 진화된 객체 생성 및 리턴
        return new EvolvedPokemon();
        // 리턴 타입은 부모 타입으로 선언되어 있는데,
        // 실제 리턴 객체는 자식 타입으로 반환
        // 다형성에 따른 부모 타입으로의 변환
    }


}
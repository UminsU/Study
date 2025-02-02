package w3.w3_11_pokemonGame;

import java.util.HashMap;
import java.util.Map;

public class PokeDex {
    // 포켓몬 정보 관리할 데이터 타입 필드 추가
    // 이름으로 검색 시
    static Map<String, Pokemon> pokemonByName = new HashMap<>();
    // 카테고리를 거쳐서 이름 검색 시
    static Map<PokeCategory, Map<String, Pokemon>> pokemonByCategory = new HashMap<>();
    // 진화형 검색용 인덱스 Map
    static Map<String, String> evolveMap = new HashMap<>();

    public static EvolvedPokemon getEvolveForm(String currentForm) {
        String evolveTo = evolveMap.get(currentForm);
        return (EvolvedPokemon) pokemonByName.get(evolveTo);
    }

    public enum PokeCategory {
        MOON,
        WATER, FIRE, EARTH, SKY,
        LEGENDARY, MYSTIC, NORMAL, ELECTRIC
    }

    public static Pokemon searchPokemon(String name) {
        return pokemonByName.get(name);
    }
    public static Map<String, Pokemon> searchPokemon(PokeCategory category) {
        return pokemonByCategory.get(category);
    }
}

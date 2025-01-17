package w3.w3_11_pokemonGame;

import java.util.HashMap;
import java.util.Map;

public class PokeDex {
    // 데이터 타입 추가
    static Map<String, Pokemon> pokemonByName = new HashMap<>();
    static Map<PokeCategory, Map<String, Pokemon>> pokemonByCategory = new HashMap<>();


    static {
        // 3. 포켓몬 사전 더미데이터 생성
        // 모든 PokeCategory 값을 키로 하여 내부 Map 초기화
        for (PokeCategory category : PokeCategory.values()) {
            pokemonByCategory.put(category, new HashMap<>());
        }
        // 아래에 더미데이터 생성 (매 객체 생성 시 해당 객체로pokemonByNamem pokemonByCategory 둘 다 업데이트 해야함)
        Pokemon p1 = new Pokemon();
        Pokemon p2 = new Pokemon();
        Pokemon p3 = new Pokemon();

        for (int i = 0 ; i<3 ; i++) {
            //pokemonByName.put(, p1);
            pokemonByCategory.get(PokeCategory.WATER).put(p1.getCustoName(), p1);
        }


    }

    public enum PokeCategory {
        WATER, FIRE, EARTH, SKY, LEGENDARY, MYSTIC, NORMAL, ELECTRIC
    }
    public static Pokemon searchPokemon(String name) {
        return pokemonByName.get(name);
    };

    public static Map<String, Pokemon> searchPokemon(PokeCategory category) {
        return pokemonByCategory.get(category);
    };

    // 아래 기능 필요없음
//    public static Pokemon searchPokemon(PokeCategory category, String name) {
//        return searchPokemon(category).get(name);
//    }
}

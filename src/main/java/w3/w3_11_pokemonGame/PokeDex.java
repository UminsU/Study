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

    static {
        // 달 포켓몬 & 진화형 더미데이터 생성
        // 모든 PokeCategory 값을 키로 하여 내부 Map 을 초기화
        Pokemon[] pokemons = {
                // 생성하고자 하는 포켓몬을 여기에 new 로 얼마든지 추가 가능
                new Pokemon("삐삐", 10, PokeCategory.MOON),
                new Pokemon("푸린", 10, PokeCategory.MOON),
                new EvolvedPokemon("픽시", 10, PokeCategory.MOON),
                new EvolvedPokemon("푸크린", 10, PokeCategory.MOON),
                new FlyPokemon("피죤", 10, PokeCategory.SKY),
                new SurfPokemon("거북왕", 10, PokeCategory.WATER),
        };

        for (PokeCategory category : PokeCategory.values()) {
            pokemonByCategory.put(category, new HashMap<>());  // 세부 카테고리에 대한 해시맵 초기화
        }

        for (Pokemon pokemon : pokemons) {
            // 위 생성 포켓몬을 적절한 사전 데이터 색인으로 할당
            pokemonByName.put(pokemon.getPokemonName(), pokemon);
            pokemonByCategory.get(pokemon.getPokeCategory()).put(pokemon.getPokemonName(), pokemon);
        }

        evolveMap.put("삐삐", "픽시");
        evolveMap.put("푸린", "푸크린");
    }

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

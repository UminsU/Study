package w3.w3_11_pokemonGame;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Pokemon implements IPokemon {
    private String pokemonName;  // 포켓몬의 종류 이름
    private String customName;
    private int HP;
    private PokeDex.PokeCategory pokeCategory;

    // PokeDex 전용 생성자
    public Pokemon(
            String pokemonName,
            int HP, PokeDex.PokeCategory pokeCategory) {
        this.pokemonName = pokemonName;
        this.HP = HP;
        this.pokeCategory = pokeCategory;
    }

    // 플레이어 소유 포켓몬 생성자
    public Pokemon(
            String pokemonName, String customName,
            int HP, PokeDex.PokeCategory pokeCategory) {
        this.pokemonName = pokemonName;
        this.customName = customName;
        this.HP = HP;
        this.pokeCategory = pokeCategory;
    }

    @Override
    public void attack(Pokemon tgPokemon) {
        // 데이터 및 동작 : tgPokemon.getHP(), tgPokemon.setHP()
        // 그 외 추가 동작 및 결과 출력
    }

    @Override
    public void flee(int enemyLv) {
        // 결과 출력
    }

    @Override
    public Pokemon evolve() {
        // 데이터 및 동작
        EvolvedPokemon evolveTo = PokeDex.getEvolveForm(this.pokemonName);
        System.out.println("== Evolve To: " + evolveTo.getPokemonName() + " ==");
        return new EvolvedPokemon(
            evolveTo.getPokemonName(), this.customName, evolveTo.getHP(), evolveTo.getPokeCategory()
        );
    }
}
package w3.w3_11_pokemonGame;

import lombok.Getter;

import java.util.*;

@Getter
public class Trainer implements ITrainer {
    List<Pokemon> capturedPokemonList = new ArrayList<>();
    Map<String, Pokemon> capturedPokemonByName = new HashMap<>();
    Scanner inputReader = new Scanner(System.in);

    @Override
    public void hunt(Pokemon wildPokemon) {
        // 야생의 포켓몬을 만나서 싸우거나 잡거나 (1:battle, 2:capture)
        int battleOrCapture = inputReader.nextInt();
        switch (battleOrCapture) {
            case 1:
                battle(wildPokemon);
                break;
            case 2:
                capture(wildPokemon);
                Pokemon capturedPokemon = capture(wildPokemon);
                if (capturedPokemon != null) {
                    capturedPokemonList.add(capturedPokemon);
                    capturedPokemonByName.put(
                            capturedPokemon.getPokemonName(), capturedPokemon
                    );
                }
                break;
            default:
                break;
        }
    }

    @Override
    public Pokemon capture(Pokemon wildPokemon) {
        // 확률적 포획 성공 (가중치 적용)
        // 몬스터볼 소진 등은 TBD
        return wildPokemon; // 100% 포획
    }

    @Override
    public void battle(Pokemon wildPokemon) {
        // Pokemon에 대한 getter(), setter() 호출
        // this.getCapturedPokemonList() 등 호출
        List<Pokemon> myLineUp = this.getCapturedPokemonList();
        for (Pokemon pokemon : myLineUp) {
            //HP가 모두 소진 될 때 까지
            while ((pokemon.getHp() != 0) && (wildPokemon.getHp() != 0)) {
                pokemon.attack(wildPokemon);
                wildPokemon.attack(pokemon);
            }
        }
        // 결과 출력
        if (wildPokemon.getHp() == 0) {
            System.out.println("Win!");
        } else {
            System.out.println("Lose!");
        }
    }

    @Override
    public void battle(ITrainer enemyTrainer) {

    }

    @Override
    public Pokemon searchDex(String pokemonName) {
        return PokeDex.searchPokemon(pokemonName);
    }

    public Map<String, Pokemon> searchDex(PokeDex.PokeCategory category) {
        return PokeDex.searchPokemon(category);
    }
}
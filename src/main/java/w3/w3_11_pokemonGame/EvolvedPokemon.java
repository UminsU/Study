package w3.w3_11_pokemonGame;

import lombok.Getter;

@Getter
public class EvolvedPokemon extends Pokemon
        // EvolvedPokemon is a Pokemon : 참인 명제
{
    public EvolvedPokemon(String pokemonName, int HP, PokeDex.PokeCategory pokeCategory) {
        super(pokemonName, HP, pokeCategory);
    }

    public EvolvedPokemon(String pokemonName, String customName, int HP, PokeDex.PokeCategory pokeCategory) {
        super(pokemonName, customName, HP, pokeCategory);
    }
}
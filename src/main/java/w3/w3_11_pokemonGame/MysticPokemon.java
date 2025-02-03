package w3.w3_11_pokemonGame;

import lombok.Getter;

@Getter
public class MysticPokemon extends Pokemon {
    public MysticPokemon(String pokemonName, int HP, PokeDex.PokeCategory pokeCategory) {
        super(pokemonName, HP, pokeCategory);
    }

    public MysticPokemon(String pokemonName, String customName, int HP, PokeDex.PokeCategory pokeCategory) {
        super(pokemonName, customName, HP, pokeCategory);
    }
}
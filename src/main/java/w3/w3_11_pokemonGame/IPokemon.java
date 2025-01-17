package w3.w3_11_pokemonGame;

public interface IPokemon {
    // attack
    public void attack(Pokemon tgPokemon);
    // flee
    public void flee (int enemyLv);
    //evolve : 함수 오버로딩 가능
    public Pokemon evolve ();

}

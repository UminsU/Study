package w3.w3_11_pokemonGame;

public class GameLauncher {
    public static void main(String[] args) {
        PokeTown initTown = new PokeTown(
                "태초마을", "모험이 시작되는 마을입니다!", true,
                (trainer) -> {
                    // 태초마을에서 일어나는 특별한 이벤트 정의 가능
                    // TODO : 포켓몬 선택 로직 직접 구현하기!
                    System.out.println("[미구현] 처음 게임을 시작하는 트레이너의 경우에만 포켓몬 선택을 수행합니다.");
                }
        );
        PokeTown moonHill = new PokeTown(
                "달맞이동산", "달 포켓몬들의 성지입니다!", false,
                // 람다식으로 함수형 인터페이스에 인라인 로직 할당 (객체 생성 시 매번 변경 가능)
                (trainer) -> {
                    for (Pokemon pokemon : trainer.getCapturedPokemonList()) {
                        if (pokemon.getPokeCategory() == PokeDex.PokeCategory.MOON) {
                            System.out.println("달맞이 동산의 영향으로 " + pokemon.getPokemonName() + " 이 진화합니다!");
                            pokemon.evolve();  // TODO : 진화 상세로직 구현 필요
                        }
                    }
                }
        );

        Trainer trainer1 = new Trainer("플레이어", null);

        Pokemon[] trainer1Pokemon = {
                new Pokemon("삐삐", "내 삐삐", 10, PokeDex.PokeCategory.MOON),
                new Pokemon("푸린", "내 푸린", 10, PokeDex.PokeCategory.MOON),
                new FlyPokemon("피죤", "내 피죤", 10, PokeDex.PokeCategory.SKY),
        };

        trainer1.townMove(moonHill);
        trainer1.townMove(initTown);
    }
}

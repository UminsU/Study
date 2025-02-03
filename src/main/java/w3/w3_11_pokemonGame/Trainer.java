package w3.w3_11_pokemonGame;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.*;

@Getter
//@ToString
public class Trainer implements ITrainer {
    Scanner inputReader = new Scanner(System.in);
    private List<Pokemon> capturedPokemonList = new ArrayList<>();
    private Map<String, Pokemon> capturedPokemonByName = new HashMap<>();

    private String name;
    @Setter
    private PokeTown currentLocation;

    public Trainer(String name, PokeTown currentLocation) {
        this.name = name;
        this.currentLocation = currentLocation;
    }

    public void getPokemon(Pokemon pokemon) {
        capturedPokemonList.add(pokemon);
    }

    public void getPokemon(Pokemon[] pokemon) {
        capturedPokemonList.addAll(Arrays.asList(pokemon));
    }

    @Override
    public void hunt(Pokemon wildPokemon) {
        System.out.println("야생의 포켓몬 " + wildPokemon.getPokemonName() + "을(를) 만났습니다!");
        // 야생의 포켓몬을 만나서 싸우거나 잡거나 그냥 지나가거나
        System.out.println("1: battle / 2: capture / else: pass");
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
                System.out.println("야생의 포켓몬 " + wildPokemon.getPokemonName() + "을(를) 그냥 지나갑니다.");
                break;
        }
    }

    @Override
    public Pokemon capture(Pokemon wildPokemon) {
        // 확률적 포획 성공 (가중치를 적용)
        // 몬스터볼 소진 등은 TBD
        return wildPokemon; //  100% 포획
    }

    @Override
    public void battle(Pokemon wildPokemon) {
        // Pokemon 에 대한 getter(), setter() 호출
        // this.getCapturedPokemonList() 등 호출
        List<Pokemon> myLineUp = this.getCapturedPokemonList();
        for (Pokemon pokemon: myLineUp) {
            while (((pokemon.getHP()!=0) && (wildPokemon.getHP()!=0))) {
                pokemon.attack(wildPokemon);
                wildPokemon.attack(pokemon);
            }
        }
        // 결과 출력
        if (wildPokemon.getHP()==0) {
            System.out.println("Win!");
        } else {
            System.out.println("Lost!");
        }
    }

    @Override
    public void battle(ITrainer enemyTrainer) {
        //
    }

    @Override
    public Pokemon searchDex(String pokemonName) {
        return PokeDex.searchPokemon(pokemonName);
    }

    @Override
    public Map<String, Pokemon> searchDex(PokeDex.PokeCategory category) {
        return PokeDex.searchPokemon(category);
    }

    @Override
    public void townMove(PokeTown tgTown) {
        // 기존위치인지 확인
        if (tgTown.equals(currentLocation)) {
            System.out.println("현재 위치입니다: " + currentLocation.getName());
            return;
        }
        boolean moveSuccess = false;
        if (tgTown.isWalkable()) {
            walk(tgTown);
            moveSuccess = true;
        } else {
            moveSuccess = crossOcean(tgTown);
        }
        if (moveSuccess) {
            tgTown.townEvent();  // 환영 메시지
            PokeTown.ITownEvent townEvent = tgTown.getTownEvent();
            if (townEvent != null) {
                townEvent.triggerTownEvent(this);  // 마을별 이벤트
            }
        }
    }

    // fly/surf 와 같은 동등한 이동 층위에서 호출하도록 구현
    public void walk(PokeTown tgTown) {
        this.currentLocation = tgTown;
        System.out.println("Walk to: " + tgTown.getName());
        // TODO : 마을의 특별한 이벤트 Trigger
    }

    public void crossOcean(String tgCity) {
        for (Pokemon pokemon: this.getCapturedPokemonList()) {
            if (pokemon instanceof IOceanCrossable) {
                ((IOceanCrossable) pokemon).crossOcean(tgCity);
            }
        }
    }

    public boolean crossOcean(PokeTown tgTown) {
        this.currentLocation = tgTown;
        for (Pokemon pokemon: this.getCapturedPokemonList()) {
            if (pokemon instanceof IOceanCrossable) {
                ((IOceanCrossable) pokemon).crossOcean(tgTown);
                // out : surf to~, fly to~
                return true;
            }
        }
        System.out.println("바다를 건널 수 있는 포켓몬이 없습니다.");
        return false;
    }

    @Override
    public String toString() {
        return "Trainer : " + name + '\n' +
                "currentLocation=" + currentLocation + '\n' +
                "capturedPokemonList=" + '\n' + capturedPokemonList;
    }
}
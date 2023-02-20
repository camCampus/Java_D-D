package src.items.defense;
import src.board.LevelSelection;
import src.perso.TypeCharacter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Shield extends DefenseItem{

  private String name;
  private int stats;
  private String description;

  private Random random;

    public Shield(LevelSelection level){
        this.random = new Random();
        this.setName(selectName()) ;
        this.setStats(selectStats(level));
        this.setDescription(getDescription(this.getName()));
    }

    private String selectName() {
        int rand = random.nextInt(ShieldList.values().length);
        List<String> shieldList = new ArrayList<>();

        for (ShieldList shield : ShieldList.values()) {
            shieldList.add(shield.name());
        }
        return shieldList.get(rand);
    }
    private int selectStats(LevelSelection level) {
        int easy = random.nextInt(1, 6);
        int hard = random.nextInt(6 , 11);
        int stats;
        if (level == LevelSelection.Easy) {
            stats = easy;
        } else {
            stats = hard;
        }
        return stats;
    }

    public String getDescription(String shield) {
        String description = "";
        switch (shield){
            case "Wood" ->
                description = "Old shield made in wood ";

            case "Steal" ->
                description = "Nice big shield made in steal";
        }
        return description;
    }


    @Override
    protected TypeCharacter getUseBy() {
        return TypeCharacter.Warrior;
    }
}

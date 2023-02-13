package src.items.defense;

public class Shield extends DefenseItem{

  private ShieldList name;
  private int stats;
  private String description;

    public Shield(ShieldList shield, int stats){
        super(TypeDefense.Shield);
        this.name = shield;
        this.stats = stats;
        this.description = getDescription(shield);
    }



    public String getDescription(ShieldList shield) {
        String description = "";
        switch (shield){
            case Starter ->
                description = "Old shield made in wood ";

            case StealShield ->
                description = "Nice big shield made in steal";
        }
        return description;
    }
}

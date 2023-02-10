package donjon.items.defense;

public class MagicShield extends DefenseItem {

    private MagicShieldList name;
    private int stats;
    private String description;
    MagicShield(MagicShieldList shield, int stats) {
        super(TypeDefense.MagicShield);
        this.name = MagicShieldList.Starter;
        this.stats = stats;
        this.description = getDescription(shield);
    }



    public String getDescription(MagicShieldList shield) {
        String description = "";
        switch (shield) {
            case Starter ->
                description = "Primary Magic Shield";

            case IceShield ->
                description = "Powerfull Ice Protection";

        }
        return description;
    }
}

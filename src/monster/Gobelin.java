package src.monster;

public class Gobelin {
    private int life;
    private int attack;

    public Gobelin() {
        this.life = 6;
        this.attack = 1;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }
}

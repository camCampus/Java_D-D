package src.board.cell;

import src.App;
import src.asset.AsciiArt;
import src.board.LevelSelection;
import src.items.Item;
import src.monster.*;
import src.perso.Character;

import java.util.Random;

public class MonsterCell extends Cell {

    private Monster monster;
    private Random random;
    private AsciiArt asciiArt;

    public MonsterCell(LevelSelection level) {
        this.random = new Random();
        this.monster = createMonster(level);
        this.asciiArt = new AsciiArt();
    }

    private Monster createMonster(LevelSelection level) {
        int rand = random.nextInt(3);
        Monster monster = null;

        switch (rand) {
            case 0 -> monster = new Dragon(level);
            case 1 -> monster = new Gobelin(level);
            case 2 -> monster = new Sorcerer(level);
        }
        return monster;
    }

    @Override
    public Cell getTypeCell() {
        return this;
    }

    @Override
    public Item getAllItem() {
        return null;
    }

    private boolean playerAttack(Character player) {
        boolean alive = true;

        System.out.println("You attack the monster and hit him with " + player.getPower());
        this.monster.setLife(this.monster.getLife() - player.getPower());
        if (this.monster.getLife() <= 0) {
            System.out.println("You kill the monster");
            alive = false;
        } else {
            System.out.println("Monster life = " + this.monster.getLife());
        }
        return alive;
    }

    private boolean monsterAttack(Character player) {
        boolean alive = true;
        System.out.println("The monster attack you !!");

        if (player.getDefenseItem() != null) {
            int damage = this.monster.getPower() - player.getDefenseItem().getStats();
            damage = Math.max(damage, 0);
            player.setLife(player.getLife() - damage);
            System.out.println("Monster deal you " + damage);
        } else {
            player.setLife(player.getLife() - this.monster.getPower());
        }

        if (player.getLife() <= 0) {
            alive = false;
            this.asciiArt.death();
            player.setAlive(false);
        }

        return alive;
    }

    @Override
    public void apply() {
        Character player = App.getInstance().getPersonnage();
        System.out.println(this.monster.toString());
        boolean monsterStatus;
        boolean playerStatus = true;
        boolean figth = true;

        while (figth) {
            monsterStatus = playerAttack(player);

            if (monsterStatus) {
                playerStatus = monsterAttack(player);
            }
            if (!monsterStatus || !playerStatus) {
                figth = false;
            }
        }
    }
}

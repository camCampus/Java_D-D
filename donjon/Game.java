package donjon;
import java.util.Random;
import static donjon.Utils.waitSecond;
public class Game {

    /**
     *  Le plateau de jeux ou le joueur évolue
     */
    private int map;

    /**
     *  Le dés que le joueur va lancer pour faire des actions
     */
    private int dice;
    /**
     * Le personnage du joueur
     */
    private Personnage player;
    /**
     * Attribut qui va stocker le random pour le lancer de dés
     */
    private Random random;

    /**
     * Stock la position du personnage
     */
    private int position;

    private AsciiArt asciiArt;
    private int shortWait ;
    private int longWait;

    public Game(Personnage player, Random random){
        this.map = 64;
        this.dice = 6;
        this.player = player;
        this.random = random;
        this.position = 1;
        this.asciiArt = new AsciiArt();
        this.shortWait = 1500;
        this.longWait = 3000;
    }

    /**
     * Fonction qui lance un dés a 6 faces
     */
    public int rollDice() {
        int rand = this.random.nextInt(6);
        rand++;
        return  rand;
    }

    public void playerMouve(int dice) {
        this.position = this.position + dice;
    }

    public void gameLoop(){
        while (this.position < this.map){
            int dice = this.rollDice();
            this.playerMouve(dice);
            waitSecond(shortWait);
            System.out.println("Your player advance of " + dice + "case(s)");
        }
        asciiArt.congratulation();
        waitSecond(longWait);

    }

    public int getMap() {
        return map;
    }

    public int getDice() {
        return dice;
    }

    public Personnage getPlayer() {
        return player;
    }


}

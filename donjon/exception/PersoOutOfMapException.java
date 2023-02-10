package donjon.exception;

import donjon.asset.AsciiArt;

public class PersoOutOfMapException extends Exception{
    public PersoOutOfMapException() {
        super("You past the last case of map...");

    }
}

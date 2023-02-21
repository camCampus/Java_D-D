package src.asset;

import com.diogonunes.jcolor.Attribute;
import src.App;
import src.perso.Character;

import static com.diogonunes.jcolor.Ansi.colorize;

public class AsciiArt {
    public void drawWizzard() {
        System.out.println("                    ____\n" +
                "                  .'* *.'\n" +
                "               __/_*_*(_\n" +
                "              / _______ \\\n" +
                "             _\\_)/___\\(_/_\n" +
                "            / _((\\- -/))_ \\\n" +
                "            \\ \\())(-)(()/ /\n" +
                "             ' \\(((()))/ '\n" +
                "            / ' \\)).))/ ' \\\n" +
                "           / _ \\ - | - /_  \\\n" +
                "          (   ( .;''';. .'  )\n" +
                "          _\\\"__ /    )\\ __\"/_\n" +
                "            \\/  \\   ' /  \\/\n" +
                "             .'  '...' ' )\n" +
                "              / /  |  \\ \\\n" +
                "             / .   .   . \\\n" +
                "            /   .     .   \\\n" +
                "           /   /   |   \\   \\\n" +
                "         .'   /    b    '.  '.\n" +
                "     _.-'    /     Bb     '-. '-._\n" +
                " _.-'       |      BBb       '-.  '-.\n" +
                "(________mrf\\____.dBBBb.________)____)");
    }

    public void drawDoor() {
        System.out.println("      ______\n" +
                "   ,-' ;  ! `-.\n" +
                "  / :  !  :  . \\\n" +
                " |_ ;   __:  ;  |\n" +
                " )| .  :)(.  !  |\n" +
                " |\"    (##)  _  |\n" +
                " |  :  ;`'  (_) (\n" +
                " |  :  :  .     |\n" +
                " )_ !  ,  ;  ;  |\n" +
                " || .  .  :  :  |\n" +
                " |\" .  |  :  .  |\n" +
                " |mt-2_;----.___|");
    }

    public void drawCastle() {
        System.out.println("                                  |>>>\n" +
                "                                  |\n" +
                "                    |>>>      _  _|_  _         |>>>\n" +
                "                    |        |;| |;| |;|        |\n" +
                "                _  _|_  _    \\\\.    .  /    _  _|_  _\n" +
                "               |;|_|;|_|;|    \\\\:. ,  /    |;|_|;|_|;|\n" +
                "               \\\\..      /    ||;   . |    \\\\.    .  /\n" +
                "                \\\\.  ,  /     ||:  .  |     \\\\:  .  /\n" +
                "                 ||:   |_   _ ||_ . _ | _   _||:   |\n" +
                "                 ||:  .|||_|;|_|;|_|;|_|;|_|;||:.  |\n" +
                "                 ||:   ||.    .     .      . ||:  .|\n" +
                "                 ||: . || .     . .   .  ,   ||:   |       \\,/\n" +
                "                 ||:   ||:  ,  _______   .   ||: , |            /`\\\n" +
                "                 ||:   || .   /+++++++\\    . ||:   |\n" +
                "                 ||:   ||.    |+++++++| .    ||: . |\n" +
                "              __ ||: . ||: ,  |+++++++|.  . _||_   |\n" +
                "     ____--`~    '--~~__|.    |+++++__|----~    ~`---,              ___\n" +
                "-~--~                   ~---__|,--~'                  ~~----_____-~'   `~----~~");
    }

    public void journeyStart() {
        System.out.println("   ▄████████     ███        ▄████████    ▄████████     ███          ▄██   ▄    ▄██████▄  ███    █▄     ▄████████           ▄█  ▄██████▄  ███    █▄     ▄████████ ███▄▄▄▄      ▄████████ ▄██   ▄   \n" +
                "  ███    ███ ▀█████████▄   ███    ███   ███    ███ ▀█████████▄      ███   ██▄ ███    ███ ███    ███   ███    ███          ███ ███    ███ ███    ███   ███    ███ ███▀▀▀██▄   ███    ███ ███   ██▄ \n" +
                "  ███    █▀     ▀███▀▀██   ███    ███   ███    ███    ▀███▀▀██      ███▄▄▄███ ███    ███ ███    ███   ███    ███          ███ ███    ███ ███    ███   ███    ███ ███   ███   ███    █▀  ███▄▄▄███ \n" +
                "  ███            ███   ▀   ███    ███  ▄███▄▄▄▄██▀     ███   ▀      ▀▀▀▀▀▀███ ███    ███ ███    ███  ▄███▄▄▄▄██▀          ███ ███    ███ ███    ███  ▄███▄▄▄▄██▀ ███   ███  ▄███▄▄▄     ▀▀▀▀▀▀███ \n" +
                "▀███████████     ███     ▀███████████ ▀▀███▀▀▀▀▀       ███          ▄██   ███ ███    ███ ███    ███ ▀▀███▀▀▀▀▀            ███ ███    ███ ███    ███ ▀▀███▀▀▀▀▀   ███   ███ ▀▀███▀▀▀     ▄██   ███ \n" +
                "         ███     ███       ███    ███ ▀███████████     ███          ███   ███ ███    ███ ███    ███ ▀███████████          ███ ███    ███ ███    ███ ▀███████████ ███   ███   ███    █▄  ███   ███ \n" +
                "   ▄█    ███     ███       ███    ███   ███    ███     ███          ███   ███ ███    ███ ███    ███   ███    ███          ███ ███    ███ ███    ███   ███    ███ ███   ███   ███    ███ ███   ███ \n" +
                " ▄████████▀     ▄████▀     ███    █▀    ███    ███    ▄████▀         ▀█████▀   ▀██████▀  ████████▀    ███    ███      █▄ ▄███  ▀██████▀  ████████▀    ███    ███  ▀█   █▀    ██████████  ▀█████▀  \n" +
                "                                        ███    ███                                                    ███    ███      ▀▀▀▀▀▀                          ███    ███                                  ");
    }

    public void intro() {
        System.out.println(" .----------------.  .----------------.  .----------------. \n" +
                "| .--------------. || .--------------. || .--------------. |\n" +
                "| |  ________    | || |    ___       | || |  ________    | |\n" +
                "| | |_   ___ `.  | || |  .' _ '.     | || | |_   ___ `.  | |\n" +
                "| |   | |   `. \\ | || |  | (_) '___  | || |   | |   `. \\ | |\n" +
                "| |   | |    | | | || |  .`___'/ _/  | || |   | |    | | | |\n" +
                "| |  _| |___.' / | || | | (___)  \\_  | || |  _| |___.' / | |\n" +
                "| | |________.'  | || | `._____.\\__| | || | |________.'  | |\n" +
                "| |              | || |              | || |              | |\n" +
                "| '--------------' || '--------------' || '--------------' |\n" +
                " '----------------'  '----------------'  '----------------' ");
    }

    public void drawWarior() {
        System.out.println("                          ,dM\n" +
                "                         dMMP\n" +
                "                        dMMM'\n" +
                "                        \\MM/\n" +
                "                        dMMm.\n" +
                "                       dMMP'_\\---.\n" +
                "                      _| _  p ;88;`.\n" +
                "                    ,db; p >  ;8P|  `.\n" +
                "                   (``T8b,__,'dP |   |\n" +
                "                   |   `Y8b..dP  ;_  |\n" +
                "                   |    |`T88P_ /  `\\;\n" +
                "                   :_.-~|d8P'`Y/    /\n" +
                "                    \\_   TP    ;   7`\\\n" +
                "         ,,__        >   `._  /'  /   `\\_\n" +
                "         `._ \"\"\"\"~~~~------|`\\;' ;     ,'\n" +
                "            \"\"\"~~~-----~~~'\\__[|;' _.-'  `\\\n" +
                "                    ;--..._     .-'-._     ;\n" +
                "                   /      /`~~\"'   ,'`\\_ ,/\n" +
                "                  ;_    /'        /    ,/\n" +
                "                  | `~-l         ;    /\n" +
                "                  `\\    ;       /\\.._|\n" +
                "                    \\    \\      \\     \\\n" +
                "                    /`---';      `----'\n" +
                "                   (     /            fsc\n" +
                "                    `---'");
    }

    public void congratulation() {
        System.out.println(" _______  _______  _        _______  _______  _______ _________          _        _______ __________________ _______  _         \n" +
                "(  ____ \\(  ___  )( (    /|(  ____ \\(  ____ )(  ___  )\\__   __/|\\     /|( \\      (  ___  )\\__   __/\\__   __/(  ___  )( (    /|  \n" +
                "| (    \\/| (   ) ||  \\  ( || (    \\/| (    )|| (   ) |   ) (   | )   ( || (      | (   ) |   ) (      ) (   | (   ) ||  \\  ( |  \n" +
                "| |      | |   | ||   \\ | || |      | (____)|| (___) |   | |   | |   | || |      | (___) |   | |      | |   | |   | ||   \\ | |  \n" +
                "| |      | |   | || (\\ \\) || | ____ |     __)|  ___  |   | |   | |   | || |      |  ___  |   | |      | |   | |   | || (\\ \\) |  \n" +
                "| |      | |   | || | \\   || | \\_  )| (\\ (   | (   ) |   | |   | |   | || |      | (   ) |   | |      | |   | |   | || | \\   |  \n" +
                "| (____/\\| (___) || )  \\  || (___) || ) \\ \\__| )   ( |   | |   | (___) || (____/\\| )   ( |   | |   ___) (___| (___) || )  \\  |  \n" +
                "(_______/(_______)|/    )_)(_______)|/   \\__/|/     \\|   )_(   (_______)(_______/|/     \\|   )_(   \\_______/(_______)|/    )_)  \n" +
                "                                                                                                                                ");
    }

    public void goodBye() {
        System.out.println("                            ,-.                               \n" +
                "       ___,---.__          /'|`\\          __,---,___          \n" +
                "    ,-'    \\`    `-.____,-'  |  `-.____,-'     /    `-.       \n" +
                "  ,'        |           ~'\\     /`~           |        `.      \n" +
                " /      ___//              `. ,'          ,  , \\___      \\    \n" +
                "|    ,-'   `-.__   _         |        ,    __,-'   `-.    |    \n" +
                "|   /          /\\_  `   .    |    ,      _/\\          \\   |   \n" +
                "\\  |           \\ \\`-.___ \\   |   / ___,-'/ /           |  /  \n" +
                " \\  \\           | `._   `\\\\  |  //'   _,' |           /  /      \n" +
                "  `-.\\         /'  _ `---'' , . ``---' _  `\\         /,-'     \n" +
                "     ``       /     \\    ,='/ \\`=.    /     \\       ''          \n" +
                "             |__   /|\\_,--.,-.--,--._/|\\   __|                  \n" +
                "             /  `./  \\\\`\\ |  |  | /,//' \\,'  \\                  \n" +
                "            /   /     ||--+--|--+-/-|     \\   \\                 \n" +
                "           |   |     /'\\_\\_\\ | /_/_/`\\     |   |                \n" +
                "            \\   \\__, \\_     `~'     _/ .__/   /            \n" +
                "             `-._,-'   `-._______,-'   `-._,-'");
        System.out.println("See you in hell");
    }
    public void outOfMap() {
        System.out.println("                                  _\n" +
                "                              ==(W{==========-      /===-\n" +
                "                                 ||  (.--.)         /===-_---~~~~~~~----__\n" +
                "                                | \\_,|**|,__      |===-~___            _,-'`\n" +
                "                   -==\\\\        `\\ ' `--'   ),    `//~\\\\   ~~~~`--._.-~\n" +
                "               ______-==|        /`\\_. .__/\\ \\    | |  \\\\          _-~`\n" +
                "         __--~~~  ,-/-==\\\\      (   | .  |~~~~|   | |   `\\       ,'\n" +
                "      _-~       /'    |  \\\\     )__/==0==-\\<>/   / /      \\     /\n" +
                "    .'        /       |   \\\\      /~\\___/~~\\/  /' /        \\   /\n" +
                "   /  ____  /         |    \\`\\.__/-~~   \\  |_/'  /          \\/'\n" +
                "  /-'~    ~~~~~---__  |     ~-/~         ( )   /'        _--~`\n" +
                "                    \\_|      /        _) | ;  ),   __--~~\n" +
                "                      '~~--_/      _-~/- |/ \\   '-~ \\\n" +
                "                     {\\__--_/}    / \\\\_>-|)<__\\      \\\n" +
                "                     /'   (_/  _-~  | |__>--<__|      |\n" +
                "                    |   _/) )-~     | |__>--<__|      |\n" +
                "                    / /~ ,_/       / /__>---<__/      |\n" +
                "                   o-o _//        /-~_>---<__-~      /\n" +
                "                   (^(~          /~_>---<__-      _-~\n" +
                "                  ,/|           /__>--<__/     _-~\n" +
                "               ,//('(          |__>--<__|     /                  .--_\n" +
                "              ( ( '))          |__>--<__|    |                 /' _-_~\\\n" +
                "           `-)) )) (           |__>--<__|    |               /'  /   ~\\`\\\n" +
                "          ,/,'//( (             \\__>--<__\\    \\            /'  //      ||\n" +
                "        ,( ( ((, ))              ~-__>--<_~-_  ~--__---~'/'/  /'       VV\n" +
                "      `~/  )` ) ,/|                 ~-_~>--<_/-__      __-~ _/\n" +
                "    ._-~//( )/ )) `                    ~~-'_/_/ /~~~~~__--~\n" +
                "     ;'( ')/ ,)(                              ~~~~~~~~\n" +
                "    ' ') '( (/");
    }

    public void figth() {
        System.out.println("" +
                " _______ _________ _______          _________\n" +
                "(  ____ \\\\__   __/(  ____ \\|\\     /|\\__   __/\n" +
                "| (    \\/   ) (   | (    \\/| )   ( |   ) (   \n" +
                "| (__       | |   | |      | (___) |   | |   \n" +
                "|  __)      | |   | | ____ |  ___  |   | |   \n" +
                "| (         | |   | | \\_  )| (   ) |   | |   \n" +
                "| )      ___) (___| (___) || )   ( |   | |   \n" +
                "|/       \\_______/(_______)|/     \\|   )_(   \n" +
                "                                             ");
    }

    public void death() {
        System.out.println("          .                                                      .\n" +
                "        .n                   .                 .                  n.\n" +
                "  .   .dP                  dP                   9b                 9b.    .\n" +
                " 4    qXb         .       dX                     Xb       .        dXp     t\n" +
                "dX.    9Xb      .dXb    __                         __    dXb.     dXP     .Xb\n" +
                "9XXb._       _.dXXXXb dXXXXbo.                 .odXXXXb dXXXXb._       _.dXXP\n" +
                " 9XXXXXXXXXXXXXXXXXXXVXXXXXXXXOo.           .oOXXXXXXXXVXXXXXXXXXXXXXXXXXXXP\n" +
                "  `9XXXXXXXXXXXXXXXXXXXXX'~   ~`OOO8b   d8OOO'~   ~`XXXXXXXXXXXXXXXXXXXXXP'\n" +
                "    `9XXXXXXXXXXXP' `9XX'          `98v8P'          `XXP' `9XXXXXXXXXXXP'\n" +
                "        ~~~~~~~       9X.          .db|db.          .XP       ~~~~~~~\n" +
                "                        )b.  .dbo.dP'`v'`9b.odb.  .dX(\n" +
                "                      ,dXXXXXXXXXXXb     dXXXXXXXXXXXb.\n" +
                "                     dXXXXXXXXXXXP'   .   `9XXXXXXXXXXXb\n" +
                "                    dXXXXXXXXXXXXb   d|b   dXXXXXXXXXXXXb\n" +
                "                    9XXb'   `XXXXXb.dX|Xb.dXXXXX'   `dXXP\n" +
                "                     `'      9XXXXXX(   )XXXXXXP      `'\n" +
                "                              XXXX X.`v'.X XXXX\n" +
                "                              XP^X'`b   d'`X^XX\n" +
                "                              X. 9  `   '  P )X\n" +
                "                              `b  `       '  d'\n" +
                "                               `             '");
    }

}

package src.menu;

import src.App;
import src.Database;
import src.perso.Character;

import java.sql.SQLException;

public class SavePlayer implements MenuActionEntry{

    private boolean visible;


    public SavePlayer() {
        this.visible= false;
    }
    @Override
    public void apply(Menu menu) {
        //--------| DATABASE
        try {
             new Database().checkIfPlayerAlreadyExist();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public String getLabel() {
        return "Save Your Player";
    }

    @Override
    public boolean isVisible() {
        if (App.getInstance().getPersonnage() != null){
            this.visible = true;
        }
        return this.visible;
    }
}

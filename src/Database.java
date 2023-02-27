package src;

import src.perso.Character;

import java.sql.*;

public class Database {

    private Connection connection;
private final Character player;
    public Database() throws ClassNotFoundException, SQLException {
         this.player = App.getInstance().getPersonnage();
         this.connection = DriverManager.getConnection(
                 "jdbc:mysql://localhost:3306/Dragon","root","123Campus");
    }



    public void saveNewPlayer() throws SQLException{
        if (this.player != null) {

            //-----| Requete pour créer l'inventaire du joueur et récuperer l'id de l'inventaire

            String inventoryQuery = "INSERT INTO `inventory`" + "VALUES(?)";
            PreparedStatement inventoryStatement = connection.prepareStatement(inventoryQuery, Statement.RETURN_GENERATED_KEYS);
            inventoryStatement.setNull(1, Types.INTEGER);
            inventoryStatement.executeUpdate();
            ResultSet keys = inventoryStatement.getGeneratedKeys();
            keys.next();


            //-----| Requete pour sauvegarder le joueur

            String playerQuery = "INSERT INTO `player`" + "VALUES(?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement playerStatement = connection.prepareStatement(playerQuery);
            playerStatement.setNull(1, Types.INTEGER);
            playerStatement.setString(2, this.player.getName());
            playerStatement.setString(3, this.player.getType().toString());
            playerStatement.setInt(4, this.player.getLife());
            playerStatement.setInt(5, this.player.getPower());
            playerStatement.setBoolean(6, this.player.isThunderPotion());
            playerStatement.setInt(7, keys.getInt(1));
            playerStatement.executeUpdate();

            System.out.println("Save in db");
        }
    }

    public void checkIfPlayerAlreadyExist() throws SQLException {

        String nameQuery = "SELECT * FROM `player` WHERE name= '"+this.player.getName()+"'";

        //("+ "'idplayer'," +"'name',"+ "'type'," + "'power'," + "'thunderpotion'"+")
        PreparedStatement nameStatement = connection.prepareStatement(nameQuery);
        nameStatement.executeQuery();
        ResultSet resName = nameStatement.getResultSet();
        if (resName != null) {
            System.out.println("Name already use");
            while (resName.next()) {
                System.out.println("Id: "+ resName.getInt("idplayer") +"\n" +
                        "Name: "+ resName.getString("name") +"\n" +
                        "Type: "+ resName.getString("type") +"\n" +
                        "Life: " + resName .getInt("life")+"\n" +
                        "Power: " + resName.getInt("power")+"\n" +
                        "Thunderpotion: " + resName.getString("thunderpotion"));
            }
        }
    }
}

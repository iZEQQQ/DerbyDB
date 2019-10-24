package net.jgorny.friendsdatabase;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.jgorny.friendsdatabase.db.ConnectionFactory;
import net.jgorny.friendsdatabase.db.FriendDao;
import net.jgorny.friendsdatabase.model.Friend;

import java.util.List;

public class FriendsMain extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("Friends Data Base");
        Parent root = FXMLLoader.load(FriendsMain.class.getResource("/net/jgorny/friendsdatabase/fxml/view_catalog.fxml"));


        stage.setScene(new Scene(root, 400, 350));
        stage.show();

        //"jdbc:derby:pack;create=true"

    }
}

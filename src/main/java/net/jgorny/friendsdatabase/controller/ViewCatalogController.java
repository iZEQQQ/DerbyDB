package net.jgorny.friendsdatabase.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
import net.jgorny.friendsdatabase.db.ConnectionFactory;
import net.jgorny.friendsdatabase.db.FriendDao;
import net.jgorny.friendsdatabase.model.Friend;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class ViewCatalogController implements Initializable {
    private final ObservableList<Friend> friends = FXCollections.observableArrayList();
    private final FriendDao dao = new FriendDao(new ConnectionFactory("jdbc:derby:pack;create=true", "", ""));
    @FXML
    private TableView<Friend> table;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dao.create();
        table.setItems(friends);
        refresh();
    }

    private String showDialog(String label, String initialValue) {
        TextInputDialog dialog = new TextInputDialog(initialValue);
        dialog.setTitle(label);
        dialog.setHeaderText("Insert " + label);
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }

    private void refresh() {
        friends.clear();
        friends.addAll(dao.find());
    }

    @FXML
    public void add(ActionEvent actionEvent) {
        Friend friend = new Friend();
        String name = showDialog("name", "");
        String surname = showDialog("surname", "");

        int age = Integer.parseInt(showDialog("age", ""));

        friend.setName(name);
        friend.setSurname(surname);
        friend.setAge(age);

        dao.add(friend);

        refresh();

    }

    @FXML
    public void delete(ActionEvent event) {
        for (Friend friend : table.getSelectionModel().getSelectedItems()) {
            dao.delete(friend);
        }
        refresh();
    }

    @FXML
    public void edit(ActionEvent event) {

        Friend friend = table.getSelectionModel().getSelectedItem();
        if (friend != null) {
            String name = showDialog("name", friend.getName());
            if (name == null) {
                return;
            }
            String surname = showDialog("surname", friend.getSurname());
            if (surname == null) {
                return;
            }
            String ageText = showDialog("age", friend.getAge() + "");
            if (ageText == null) {
                return;
            }
            int age = Integer.parseInt(ageText);


            friend.setName(name);
            friend.setSurname(surname);
            friend.setAge(age);

            dao.update(friend);

            refresh();

        }

    }

}

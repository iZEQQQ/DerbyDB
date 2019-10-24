package net.jgorny.friendsdatabase.db;

import javafx.fxml.Initializable;

import java.sql.*;
import java.util.*;
import java.net.URL;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import net.jgorny.friendsdatabase.model.Friend;

public class FriendDao {
    private final ConnectionFactory factory;

    public FriendDao(ConnectionFactory factory) {
        this.factory = factory;
    }


    public void create() {
        try (Connection connection = factory.createConnection(); Statement stat = connection.createStatement()) {
            stat.executeUpdate("CREATE TABLE friends(id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY ,name VARCHAR(32),surname VARCHAR(32),age INTEGER)");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }


    public void add(Friend friend) {
        String query = "INSERT INTO friends(name,surname,age) VALUES (?,?,?)";
        try (Connection connection = factory.createConnection(); PreparedStatement stat = connection.prepareStatement(query)) {
            stat.setString(1, friend.getName());
            stat.setString(2, friend.getSurname());
            stat.setInt(3, friend.getAge());
            stat.executeUpdate();
        } catch (SQLException exe) {
            exe.printStackTrace();
        }
    }


    public void update(Friend friend) {
        String query = "UPDATE friends SET name= ?,surname=?,age=?  WHERE id = ?";
        try (Connection connection = factory.createConnection(); PreparedStatement stat = connection.prepareStatement(query)) {
            stat.setString(1, friend.getName());
            stat.setString(2, friend.getSurname());
            stat.setInt(3, friend.getAge());
            stat.setInt(4, friend.getId());
            stat.executeUpdate();
        } catch (SQLException exe) {
            exe.printStackTrace();
        }
    }


    public void delete(int id) {
        String query = "DELETE FROM friends WHERE id = ?";
        try (Connection connection = factory.createConnection(); PreparedStatement stat = connection.prepareStatement(query)) {
            stat.setInt(1, id);
            stat.executeUpdate();
        } catch (SQLException exe) {
            exe.printStackTrace();
        }
    }

    public void delete(Friend friend) {
        delete(friend.getId());
    }


    public List<Friend> find() {
        List<Friend> friends = new ArrayList<>();
        try (Connection conn = factory.createConnection(); Statement stat = conn.createStatement(); ResultSet result = stat.executeQuery("SELECT id,name,surname,age FROM friends")) {
            while (result.next()) {
                Friend friend = new Friend();
                friend.setId(result.getInt(1));
                friend.setName(result.getString(2));
                friend.setSurname(result.getString(3));
                friend.setAge(result.getInt(4));
                friends.add(friend);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return friends;
    }


}

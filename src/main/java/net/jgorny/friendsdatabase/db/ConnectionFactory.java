package net.jgorny.friendsdatabase.db;

import java.sql.*;

public class ConnectionFactory {
    private final String url;
    private final String login;
    private final String password;
    public ConnectionFactory(String url, String login, String password) {
        this.url = url;
        this.login = login;
        this.password = password;
    }
    public Connection createConnection() throws SQLException {
        return DriverManager.getConnection(url, login, password);
    }

}

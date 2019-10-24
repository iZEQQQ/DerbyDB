module friendsdatabase {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens net.jgorny.friendsdatabase.controller to javafx.fxml;
    opens net.jgorny.friendsdatabase.model to javafx.fxml, javafx.base;
    exports net.jgorny.friendsdatabase;
}
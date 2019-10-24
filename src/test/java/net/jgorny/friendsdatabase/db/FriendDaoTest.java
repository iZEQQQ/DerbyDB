package net.jgorny.friendsdatabase.db;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class FriendDaoTest {


    @Test
    public void create() throws SQLException {
        ConnectionFactory factory = mock(ConnectionFactory.class);
        Connection con = mock(Connection.class);
        Statement stat = mock(Statement.class);

        when(factory.createConnection()).thenReturn(con);
        when(con.createStatement()).thenReturn(stat);

        FriendDao dao = new FriendDao(factory);
        dao.create();


    }





}

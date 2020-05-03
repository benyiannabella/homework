package homework8_jdbc;

import org.junit.Test;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class DBConnectionTest {
    DBConnection dbConnection = new DBConnection();

    @Test
    public void insert_entry_in_accommodation() throws SQLException {

        dbConnection.insertEntryInAccommodation("'two room apartment'", "'double bed'",
                2, "'insert third accommodation'");
        dbConnection.insertEntryInRoomFair(300, "'from 1 APRIL 2020 to 1 SEP 2020'");
        dbConnection.insertEntryInRelation(41,35);
        assertEquals(dbConnection.getDataFromRelation(33), 33);
    }

    @Test
    public void room_value_relation() throws SQLException {
        Map<String,Double> map = new HashMap<>();
        String s = "Select b.type, c.value from accommodation_to_room_fair_relation a "
                + "Left Join accommodation b ON b.id = a.id_accommodation "
                + "Left Join room_fair c ON c.id = a.id_room_fair ";

        dbConnection.printValuePerRoom(s, map);
        assertNotNull(map);
        assertTrue(map.size() != 0);
    }
}
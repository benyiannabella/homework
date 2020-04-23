import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class DBConnectionTest {
    DBConnection dbConnection = new DBConnection();

    @Test
    public void insert_entry_in_accommodation() throws SQLException {

        dbConnection.insertEntryInAccommodation("'two room apartment'", "'twin bed'",
                4, "'insert second accommodation'");
        dbConnection.insertEntryInRoomFair(200, "'from 1 MAR 2020 to 1 SEP 2020'");
        dbConnection.insertEntryInRelation(33,27);
        assertEquals(dbConnection.getDataFromRelation(26), 26);
    }

    @Test
    public void room_value_relation() throws SQLException {
        String s = "Select b.type, c.value from accommodation_to_room_fair_relation a "
                + "Left Join accommodation b ON b.id = a.id_accommodation "
                + "Left Join room_fair c ON c.id = a.id_room_fair ";
        dbConnection.printValuePerRoom(s);
        assertNotNull(s);
    }
}
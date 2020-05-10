package homework8_jdbc;

import org.apache.log4j.BasicConfigurator;

import java.sql.*;
import java.util.Map;

public class DBConnection {
    private Statement statement;
    final static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(DBConnection.class);

    {
        try {
            statement = getConnection().createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    // Create a new connection to the PostgreSQL database;
    public Connection getConnection() {
        Connection connection = null;
        BasicConfigurator.configure();
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/booking",
                    "postgres", "postgres");
            //logger.debug("The connection to the PostgreSQL DataBase was successful");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return connection;
    }

    //create the database;
    private void createDatabaseBooking(Connection connection) throws SQLException {
        PreparedStatement createDBBooking =
                connection.prepareStatement("create database booking");
    }

    //create DB table accommodation;
    private void createTableAccommodation(Connection connection) throws SQLException {
        PreparedStatement createAccommodationTable =
                connection.prepareStatement(
                        "create table accommodation " +
                                "(" +
                                "id SERIAL not null," +
                                "type varchar(32), " +
                                "bed_type varchar(32), " +
                                "max_guests int, " +
                                "description varchar(512), " +
                                "primary key(id))");

        createAccommodationTable.execute();
        connection.commit();
    }

    //create DB table room_fair;
    private void createTableRoomFair(Connection connection) throws SQLException {
        PreparedStatement createRoomFairTable =
                connection.prepareStatement(
                        "create table room_fair " +
                                "(" +
                                "id SERIAL not null," +
                                "value double precision, " +
                                "season varchar(32), " +
                                "primary key(id))");

        createRoomFairTable.execute();
        connection.commit();
    }

    //create DB table accommodation_to_room_fair_relation;
    private void createTableRelation(Connection connection) throws SQLException {
        PreparedStatement createRelationTable = connection.prepareStatement(
                "create table accommodation_to_room_fair_relation " +
                        "(" +
                        "id SERIAL not null, " +
                        "id_accommodation int, " +
                        "id_room_fair int, " +
                        "primary key(id), " +
                        "foreign key(id_accommodation) references accommodation(id), " +
                        "foreign key(id_room_fair) references room_fair(id))");

        createRelationTable.execute();
        connection.commit();
    }

    //insert new record in accommodation table;
    public void insertEntryInAccommodation(String type, String bedType, int maxGuests, String description) {
        try {
            String s = "insert into accommodation (type, bed_type, max_guests, description) "
                    + "values (" + type + ", " + bedType + ", " + maxGuests + ", " + description + ")";
            statement.executeUpdate(s);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //insert new record in room_fair table;
    public void insertEntryInRoomFair(double value, String season) {
        try {
            String s = "insert into room_fair (value, season) "
                    + "values (" + value + ", " + season + ")";
            statement.executeUpdate(s);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //insert new entry in relation table;
    public void insertEntryInRelation(int idAccommodation, int idRoomFair) {
        try {
            String s = "insert into accommodation_to_room_fair_relation (id_accommodation, id_room_fair) "
                    + "values (" + idAccommodation + ", " + idRoomFair + ")";
            statement.executeUpdate(s);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public int getDataFromRelation(int id) {
        ResultSet rs;
        String s = "Select a.id from accommodation_to_room_fair_relation a "
                + "Left Join accommodation b ON b.id = a.id_accommodation "
                + "Left Join room_fair c ON c.id = a.id_room_fair "
                + "Where a.id = " + id;
        try {
            rs = statement.executeQuery(s);
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return id;
    }

    public void printValuePerRoom(String s, Map<String, Double> map) throws SQLException {
        ResultSet rs = statement.executeQuery(s);
        Accommodation accommodation = new Accommodation();
        RoomFair roomFair = new RoomFair();
        while (rs.next()) {
            accommodation.setType(rs.getString("type"));
            roomFair.setValue(rs.getDouble("value"));
            map.put(accommodation.getType(), roomFair.getValue());
            logger.debug(" Accommodation type: " + accommodation.getType()
                    + " , Value: " + roomFair.getValue());
        }
    }

    /**
     * I've created the database from pgAdmin4;
     * tables have been created with java, using the below methods;
     * database and table creation should be run only once;
     * so I've commented out the method calls;


     try {
     createDatabaseBooking(connection);
     } catch (SQLException throwables) {
     throwables.printStackTrace();
     }

     call method to create accommodation table in DB;
     try {
     createTableAccommodation(connection);
     } catch (SQLException throwables) {
     throwables.printStackTrace();
     }

     call method to create room_fair table in DB
     try {
     createTableRoomFair(connection);
     } catch (SQLException throwables) {
     throwables.printStackTrace();
     }

     call method tp create accommodation_to_room_fair_relation table in DB
     try {
     createTableRelation(connection);
     } catch (SQLException throwables) {
     throwables.printStackTrace();
     }


     */

}



package genenricLibraries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DaatabaseUtils {

    // Connection object used to establish communication with the database
    Connection conn = null;

    // ResultSet object to store the result returned from SELECT queries
    ResultSet result = null;

    /**
     * This method registers the MySQL driver and connects to the database
     * using the credentials provided in the IPathConstants interface.
     *
     * @throws SQLException if database connection fails
     */
    public void connectToDB() throws SQLException {
        // register the database
        Driver driver = new Driver();
        DriverManager.registerDriver(driver);

        // get connection for database
        conn = DriverManager.getConnection(IPathConstants.dbURL, IPathConstants.dUsername, IPathConstants.dPassword);
    }

    /**
     * Executes a SELECT SQL query and returns the data in a ResultSet.
     *
     * @param query the SQL SELECT query to execute
     * @return ResultSet containing the retrieved records
     * @throws SQLException if query execution fails
     */
    public ResultSet executeQuery(String query) throws SQLException {
        // create statement
        Statement state = conn.createStatement();

        // execute query
        result = state.executeQuery(query);
        return result;
    }

    /**
     * Executes INSERT, UPDATE, or DELETE SQL queries.
     *
     * @param query SQL update query
     * @return number of rows affected by the query
     * @throws SQLException if update execution fails
     */
    public int updateQuery(String query) throws SQLException {
        // create statement
        Statement state = conn.createStatement();

        // execute update query
        int res = state.executeUpdate(query);
        return res;
    }

    /**
     * Closes the database connection.
     *
     * @throws SQLException if closing connection fails
     */
    public void disconnectDB() throws SQLException {
        // close connection
        conn.close();
    }
}

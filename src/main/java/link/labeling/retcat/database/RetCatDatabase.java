package link.labeling.retcat.database;

import java.io.IOException;
import java.sql.*;
import org.json.simple.JSONObject;

/**
 * Class for connection to the test database
 * @author thiery
 */
public class RetCatDatabase {

	private static Connection connection;

	/**
     * open database
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IOException 
     */
    public static void open() throws SQLException, ClassNotFoundException, IOException {
		Class.forName("org.postgresql.Driver");
		String url = "jdbc:postgresql://localhost:5432/test";
		connection = DriverManager.getConnection(url, "postgres", "postgres");
	}

	/**
     * close database
     * @throws SQLException 
     */
    public static void close() throws SQLException {
		connection.close();
	}

	/**
     * get test value as JSONObject
     * @param id
     * @return test JSON
     * @throws SQLException 
     */
    public static JSONObject getTestById(int id) throws SQLException {
		try {
			open();
            JSONObject result = new JSONObject();
			String sql = "SELECT * FROM test WHERE id = ?;";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				result.put("id", rs.getInt("id"));
				result.put("name", rs.getString("name"));
			}
			return result;
		} catch (Exception e) {
			close();
			throw new SQLException(e.toString());
		}
	}

}

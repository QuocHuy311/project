package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBContext {

    private static final Logger LOGGER = Logger.getLogger(DBContext.class.getName());
    private static final String SERVER_NAME = "localhost";
    private static final String DATABASE_NAME = "project";
    private static final String PORT_NUMBER = "1433";
    private static final String USER_ID = "sa";
    private static final String PASSWORD = "123";
    protected Connection connection;

    public DBContext() {
        try {
            String connectionUrl
                    = "jdbc:sqlserver://" + SERVER_NAME + ":" + PORT_NUMBER + ";databaseName=" + DATABASE_NAME;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(connectionUrl, USER_ID, PASSWORD);
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        String url
                = "jdbc:sqlserver://" + SERVER_NAME + ":" + PORT_NUMBER + ";databaseName=" + DATABASE_NAME;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, USER_ID, PASSWORD);
    }
    
    public static void main(String[] args) {
        try {
            System.out.println(new DBContext().getConnection());
        } catch (Exception e) {
        }
    }
}
//
//class TestConnection {
//
//    private static final Logger LOGGER = Logger.getLogger(TestConnection.class.getName());
//
//    public static void main(String[] args) {
//
//        DBContext dbContext = new DBContext();
//        if (dbContext.connection != null) {
//            LOGGER.log(Level.INFO, "Ket noi thanh cong");
//        } else {
//            LOGGER.log(Level.SEVERE, "Ket noi that bai");
//        }
//    }
//}

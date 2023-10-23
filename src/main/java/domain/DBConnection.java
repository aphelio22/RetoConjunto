package domain;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;

public class DBConnection {
    private static Connection connection;
    private static Logger logger;

    static {
        logger = Logger.getLogger(DBConnection.class.getName());
        String url;
        String user;
        String pass;
        Properties properties = new Properties();
        try {
            InputStream inputStream = DBConnection.class.getClassLoader().getResourceAsStream("bbdd.properties");
            properties.load(inputStream);
            System.out.println("configuración cargada");
            url = "jdbc:mysql://" + properties.get("host") + ":" + properties.get("port") + "/" + properties.get("dbname");
            user = (String) properties.get("user");
            pass = (String) properties.get("pass");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try{
            connection = DriverManager.getConnection(url, user, pass);
            System.out.println("Conexión existosa");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static Connection getConnection(){
        return connection;
    }
}

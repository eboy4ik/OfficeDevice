package ru.rsreu.golyashhuk.datalayer.oracledb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;

import ru.rsreu.golyashhuk.datalayer.DAOFactory;
import ru.rsreu.golyashhuk.datalayer.OfficeDeviceDAO;
import ru.rsreu.golyashhuk.datalayer.QueryDAO;
import ru.rsreu.golyashhuk.datalayer.UserDataDAO;

public class OracleDbDAOFactory extends DAOFactory {
    private static volatile OracleDbDAOFactory instance;
    private Connection connection;

    private OracleDbDAOFactory() {
    }

    public static OracleDbDAOFactory getInstance() throws ClassNotFoundException, SQLException {
        OracleDbDAOFactory factory = instance;
        if (instance == null) {
            synchronized (OracleDbDAOFactory.class) {
                instance = factory = new OracleDbDAOFactory();
                factory.connected();
            }
        }
        return factory;
    }

    private void connected() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Locale.setDefault(Locale.ENGLISH);
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String user = "SYSTEM";
        String password = "1";
        connection = DriverManager.getConnection(url, user, password);
        System.out.println("Connected to oracle DB!");
    }

    @Override
    public UserDataDAO getUserPasswordDAO() {
        return new OracleUserDataDAO(connection);
    }

    @Override
    public OfficeDeviceDAO getOfficeDeviceDAO() {
        return new OracleOfficeDeviceDAO(connection);
    }

    @Override
    public QueryDAO getQueryDAO() {
        return new OracleQueryDAO(connection);
    }


}

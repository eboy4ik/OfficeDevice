package ru.rsreu.golyashhuk.datalayer;

import java.sql.SQLException;

import ru.rsreu.golyashhuk.datalayer.oracledb.OracleDbDAOFactory;

public enum DBType {
    ORACLE {
        @Override
        public DAOFactory getDAOFactory() {
            DAOFactory oracleDbDAOFactory = null;
            try {
                oracleDbDAOFactory = OracleDbDAOFactory.getInstance();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return oracleDbDAOFactory;
        }
    };

    public static DBType getTypeByName(String dbType) {
        try {
            return DBType.valueOf(dbType.toUpperCase());
        } catch (Exception e) {
            throw new DBTypeException();
        }
    }

    public abstract DAOFactory getDAOFactory();

}

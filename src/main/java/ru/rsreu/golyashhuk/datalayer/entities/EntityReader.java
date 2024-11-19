package ru.rsreu.golyashhuk.datalayer.entities;

import java.sql.ResultSet;
import java.sql.SQLException;

import ru.rsreu.golyashhuk.config.ConfigurationManager;

public class EntityReader {
    private EntityReader() {
    }

    public static User readUser(ResultSet rs) {
        User user = new User();
        try {
            user.setId(rs.getInt(ConfigurationManager.getProperty("oracle.userdata.id")));
            user.setLogin(rs.getString(ConfigurationManager.getProperty("oracle.userdata.login")));
            user.setPasswordHash(rs.getString(ConfigurationManager.getProperty("oracle.userdata.password")));
            user.setBlocked(rs.getBoolean(ConfigurationManager.getProperty("oracle.userdata.isblocked")));
            user.setAuthorized(rs.getBoolean(ConfigurationManager.getProperty("oracle.userdata.isauthorized")));
            user.setName(rs.getString(ConfigurationManager.getProperty("oracle.userdata.name")));
            user.setDateRegistration(rs.getTimestamp(ConfigurationManager.getProperty("oracle.userdata.dateregistration")));
            user.setRole(readUserRole(rs));

        } catch (SQLException e) {
            return user;
        }
        return user;

    }

    public static UserRole readUserRole(ResultSet rs) {
        UserRole role = new UserRole();
        try {
            role.setId(rs.getInt(ConfigurationManager.getProperty("oracle.userrole.roleid")));
            role.setName(rs.getString(ConfigurationManager.getProperty("oracle.userrole.name")));
        } catch (SQLException e) {
            return role;
        }
        return role;
    }

    public static OfficeDevice readOfficeDevice(ResultSet rs) {
        OfficeDevice officeDevice = new OfficeDevice();
        try {
            officeDevice.setId(rs.getInt(ConfigurationManager.getProperty("oracle.officedevice.id")));
            officeDevice.setName(rs.getString(ConfigurationManager.getProperty("oracle.officedevice.name")));
            officeDevice.setTimeReceiving(rs.getTimestamp(ConfigurationManager.getProperty("oracle.officedevice.timereceiving")));
            officeDevice.setTimeRemoving(rs.getTimestamp(ConfigurationManager.getProperty("oracle.officedevice.timeremoving")));
            officeDevice.setUser(readUser(rs));
        } catch (SQLException e) {
            return officeDevice;
        }
        return officeDevice;
    }

    public static Query readQuery(ResultSet rs) {
        Query query = new Query();
        try {
            query.setId(rs.getInt(ConfigurationManager.getProperty("oracle.query.id")));
            query.setQueryType(readQueryType(rs));
            query.setQueryStatus(readQueryStatus(rs));
            query.setTimeSending(rs.getTimestamp(ConfigurationManager.getProperty("oracle.query.timesending")));
            query.setTimeClosing(rs.getTimestamp(ConfigurationManager.getProperty("oracle.query.timeclosing")));
            query.setSender(readUser(rs));
            query.setDevice(readOfficeDevice(rs));
            query.setUserMessage(rs.getString(ConfigurationManager.getProperty("oracle.query.usermessage")));
            query.setResponse(rs.getString(ConfigurationManager.getProperty("oracle.query.response")));


        } catch (SQLException e) {
            e.printStackTrace();
            return query;
        }
        return query;
    }

    public static QueryStatus readQueryStatus(ResultSet rs) {
        QueryStatus queryStatus = new QueryStatus();
        try {
            queryStatus.setId(rs.getInt(ConfigurationManager.getProperty("oracle.querystatus.id")));
            queryStatus.setName(rs.getString(ConfigurationManager.getProperty("oracle.querystatus.status")));
        } catch (SQLException e) {
            e.printStackTrace();
            return queryStatus;
        }
        return queryStatus;
    }

    public static QueryType readQueryType(ResultSet rs) {
        QueryType queryType = new QueryType();
        try {
            queryType.setId(rs.getInt(ConfigurationManager.getProperty("oracle.querytype.id")));
            queryType.setName(rs.getString(ConfigurationManager.getProperty("oracle.querytype.name")));
        } catch (SQLException e) {
            e.printStackTrace();
            return queryType;
        }
        return queryType;
    }

    ;

}

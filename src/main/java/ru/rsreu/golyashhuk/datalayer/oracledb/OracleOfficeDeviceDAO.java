package ru.rsreu.golyashhuk.datalayer.oracledb;

import ru.rsreu.golyashhuk.config.ConfigurationManager;
import ru.rsreu.golyashhuk.datalayer.OfficeDeviceDAO;
import ru.rsreu.golyashhuk.datalayer.entities.EntityReader;
import ru.rsreu.golyashhuk.datalayer.entities.OfficeDevice;
import ru.rsreu.golyashhuk.datalayer.entities.Query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class OracleOfficeDeviceDAO implements OfficeDeviceDAO {
    private Connection connection;

    public OracleOfficeDeviceDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<OfficeDevice> getFreeOfficeDevices() {
        String query = ConfigurationManager.getProperty("query.oracle.officedevice.getfreedevices");
        List<OfficeDevice> officeDevices = new LinkedList<>();
        ResultSet rs = null;
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            rs = ps.executeQuery();
            while (rs.next()) {
                officeDevices.add(EntityReader.readOfficeDevice(rs));
            }
        } catch (SQLException e) {
            System.err.println("Error connection: " + e.getMessage());
            return officeDevices;
        }

        return officeDevices;
    }

    @Override
    public boolean backAllUserDevices(int userId) {
        String query = ConfigurationManager.getProperty("query.oracle.officedevice.backalldevices");
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, userId);

            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean backDevice(int deviceId) {
        String query = ConfigurationManager.getProperty("query.oracle.officedevice.backdevice");
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, deviceId);

            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean giveDevice(int userId, int deviceId) {
        String query = ConfigurationManager.getProperty("query.oracle.officedevice.givedevice");
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, userId);
            ps.setInt(2, deviceId);

            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public int getDeviceUser(int deviceId) {
        String query = ConfigurationManager.getProperty("query.oracle.officedevice.getdeviceuser");
        ResultSet rs = null;
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, deviceId);

            rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt(1);
                return id;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
        return -1;
    }

    @Override
    public boolean createDevice(String name) {
        String query = ConfigurationManager.getProperty("query.oracle.officedevice.createdevice");
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, name);

            int rowsInserted = ps.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteDevice(int deviceId) {
        String query = ConfigurationManager.getProperty("query.oracle.officedevice.deletedevice");
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, deviceId);

            int rowsInserted = ps.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<OfficeDevice> getAllOfficeDevices() {
        String query = ConfigurationManager.getProperty("query.oracle.officedevice.getalldevices");
        List<OfficeDevice> officeDevices = new LinkedList<>();
        ResultSet rs = null;
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            rs = ps.executeQuery();
            while (rs.next()) {
                officeDevices.add(EntityReader.readOfficeDevice(rs));
            }
        } catch (SQLException e) {
            System.err.println("Error connection: " + e.getMessage());
            return officeDevices;
        }

        return officeDevices;
    }


    @Override
    public List<OfficeDevice> getUserOfficeDevices(int userId) {
        String query = ConfigurationManager.getProperty("query.oracle.officedevice.getuserdevices");
        List<OfficeDevice> officeDevices = new LinkedList<>();
        ResultSet rs = null;
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, userId);
            ps.executeUpdate();
            rs = ps.executeQuery();
            while (rs.next()) {
                officeDevices.add(EntityReader.readOfficeDevice(rs));
            }
        } catch (SQLException e) {
            System.err.println("Error connection: " + e.getMessage());
            return officeDevices;
        }

        return officeDevices;
    }
}

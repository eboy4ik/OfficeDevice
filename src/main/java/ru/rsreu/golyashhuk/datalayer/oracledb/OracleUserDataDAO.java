package ru.rsreu.golyashhuk.datalayer.oracledb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ru.rsreu.golyashhuk.config.ConfigurationManager;
import ru.rsreu.golyashhuk.datalayer.UserDataDAO;
import ru.rsreu.golyashhuk.datalayer.entities.EntityReader;
import ru.rsreu.golyashhuk.datalayer.entities.User;
import ru.rsreu.golyashhuk.datalayer.entities.UserRole;
import ru.rsreu.golyashhuk.security.Encoder;

public class OracleUserDataDAO implements UserDataDAO {
    private Connection connection;

    public OracleUserDataDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public User getUser(String login, String password) {
        String query = ConfigurationManager.getProperty("query.oracle.userdata.getuser");
        String hashedPassword = Encoder.getHash(password);

        User user;
        ResultSet rs = null;
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, login);
            ps.setString(2, hashedPassword);
            ps.executeUpdate();
            rs = ps.executeQuery();

            if (!rs.next()) {
                return User.NULL_USER;
            }

            user = EntityReader.readUser(rs);
        } catch (SQLException e) {
            e.printStackTrace();
            return User.NULL_USER;
        }

        return user;
    }

    @Override
    public List<User> getUsers() {
        String query = ConfigurationManager.getProperty("query.oracle.userdata.getusers");
        List<User> users = new ArrayList<>();
        ResultSet rs = null;
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.executeUpdate();
            rs = ps.executeQuery();

            while (rs.next()) {
                User user = EntityReader.readUser(rs);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return users;
        }

        return users;
    }


    @Override
    public boolean createUser(String login, String password, String name, int roleId) {
        if (isExistUser(login)) {
            return false;
        }

        String query = ConfigurationManager.getProperty("query.oracle.userdata.insert");
        String hashedPassword = Encoder.getHash(password);

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, login);
            ps.setString(2, hashedPassword);
            ps.setString(3, name);
            ps.setInt(4, roleId);

            int rowsInserted = ps.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteUser(int userId) {
        String query = ConfigurationManager.getProperty("query.oracle.userdata.delete");

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, userId);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean setOnlineStatus(int userId) {
        String query = ConfigurationManager.getProperty("query.oracle.userdata.setonline");
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, userId);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public int getUserRoleById(int userId) {
        String query = ConfigurationManager.getProperty("query.oracle.userdata.getuserrole");
        ResultSet rs = null;
        int roleId = 999;
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, userId);
            ps.executeUpdate();
            rs = ps.executeQuery();

            if (rs.next()) {
                roleId = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return roleId;
        }
        return roleId;

    }

    @Override
    public boolean editUserData(int userId, String newName, int newRoleId) {
        String query = ConfigurationManager.getProperty("query.oracle.userdata.edituserdata");
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(3, userId);
            ps.setString(2, newName);
            ps.setInt(1, newRoleId);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean blockUser(int userId) {
        String query = ConfigurationManager.getProperty("query.oracle.userdata.blockuser");
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, userId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean unblockUser(int userId) {
        String query = ConfigurationManager.getProperty("query.oracle.userdata.unblockuser");
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, userId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean isBlockedUser(int id) {
        String query = ConfigurationManager.getProperty("query.oracle.userdata.isblocked");
        ResultSet rs = null;
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getBoolean(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return true;
        }
        return true;
    }


    @Override
    public boolean setOfflineStatus(int userId) {
        String query = ConfigurationManager.getProperty("query.oracle.userdata.setoffline");
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, userId);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean isExistUser(String login) {
        if (login == null || login.equals("")) {
            return true;
        }

        String query = ConfigurationManager.getProperty("query.oracle.userdata.isexist");

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, login);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt(1);
                    return count > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

}
